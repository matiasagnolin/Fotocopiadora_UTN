package ar.com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ar.com.DataModels.CarrerasMateriaMD;
import ar.com.DataModels.DetallePedidoDM;
import ar.com.Request.data.Request;
import ar.com.ServiceLayer.ServiceCRUD;
import ar.com.model.domain.Archivo;
import ar.com.model.domain.Carreras;
import ar.com.model.domain.Comprobantes;
import ar.com.model.domain.DetallePedido;
import ar.com.model.domain.Materias;
import ar.com.model.domain.Pedido;
import ar.com.model.domain.Profesor;
import ar.com.model.domain.Usuario;
import ar.com.model.domain.Valores;
import org.apache.pdfbox.pdmodel.font.encoding.WinAnsiEncoding;


@Controller
@Scope("session")
public class FileController {
	@Autowired
	private ServiceCRUD dataService;
	@Autowired
	private Request req ;
	@Autowired
	private Usuario user;
	private Pedido pedido;
	private PDDocument doc;

	private Archivo archivo;
	private Materias materia;
	private Carreras carrera;
	
	private  String rootPath;
	
	private int id=0;
	
	/**
	 * Upload single file using Spring Controller
	 */
	@RequestMapping(value="/LoadFile", method = RequestMethod.POST)
	public String uploadFileHandler(@ModelAttribute("command") CarrerasMateriaMD command,HttpServletRequest request) {

		MultipartFile file = command.getFile();
		 carrera = new Carreras();
		 materia = new Materias();
		 archivo = new Archivo();
		 rootPath=request.getSession().getServletContext().getRealPath("/");
		 this.user=(Usuario)request.getSession().getAttribute("usuario");
		 
		 String materia2="0";
		 if(command.getMateria()!=null){
		 if(command.getMateria().size()>1)
		  materia2 = command.getCarrera()==1? (String)command.getMateria().get(0): (String)command.getMateria().get(1);
		  else
			  materia2=(String)command.getMateria().get(0);
		 }
		 
		if(FilterFile(file)){
			if(command.getPublico() ||	user.getRole_Usuario().getDescripcion().equals("class ar.com.model.domain.Profesor")) 
			{
				if( command.getCarrera()!=0 && Integer.parseInt(materia2)!=0 && (command.getResumen()!=null && command.getResumen()!="") ){
			req.setId(command.getCarrera());
			req.setObject(new Carreras());
		
			try 
			{
				carrera=(Carreras)dataService.ReadOne(req);
				req.setId( Integer.parseInt(materia2));
				req.setObject(new Materias());
				materia=(Materias)dataService.ReadOne(req);
			} 
			catch (Exception e1) 
			{
				e1.printStackTrace();
				return "redirect:/LoadFileError";
			}
			archivo.setMateria(materia);
			archivo.setCarrera(carrera);
			archivo.setNombre(command.getFileName());
			archivo.setResumen(command.getResumen());
			archivo.setFecha(getdate());
			archivo.setPublico(true);}
				else
					return "redirect:/LoadFileError";
			}
			else{
				archivo.setPublico(false);
				archivo.setNombre("ArchivoPrivado-"+user.getNombre_Usuario()+hashCode());
				
			}
				try {
					byte[] bytes = file.getBytes();
		
					// Creating the directory to store file
					File dir=null;
					if(archivo.isPublico())
					 dir = new File(rootPath + File.separator + carrera.getDescripcion() + File.separator +materia.getNombre());
					else
						dir = new File(rootPath + File.separator + "ARCHIVOS PRIVADOS");
					
					if (!dir.exists())
						dir.mkdirs();
		
					// Create the file on server
					
					File serverFile = new File(dir.getAbsolutePath()+ File.separator + archivo.getNombre()+"."+archivo.getTipo());
					
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(serverFile));
					
					
					
					stream.write(bytes);
					stream.close();
					
					archivo.setURL(serverFile.getCanonicalPath());
					archivo.setUser(user);
					
					if(!CountPages(serverFile))
						return "redirect:/LoadFileError";
					
					req.setObject(this.archivo);
					this.id=dataService.Save(req);
					
					return "redirect:/LoadFileOk";
				} 
				catch (Exception e) {
					return "redirect:/LoadFileError";
				}
		 }
		else
			return "redirect:/LoadFileError";
	}
	
	@RequestMapping(value="/LoadFileError", method = RequestMethod.GET)
	public String Error(HttpServletRequest request) {
		request.getSession().setAttribute("ERROR", true);
		System.out.println("ERRRrRORR");
		return "redirect:/Home?error=1";
	}
	
	@RequestMapping(value="/LoadFileOk", method = RequestMethod.GET)
	public ModelAndView Ok(HttpServletRequest request) {
		System.out.println("AAAAAAAAAAAAAAAa");
		ModelAndView modelAndView = new ModelAndView();
		request.getSession().setAttribute("ERROR", false);
		req.setObject(new Archivo());
		req.setId(this.id);
		
		try {
			modelAndView.addObject("archivo",dataService.ReadOne(req));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(!user.getTipo().equals(Profesor.class)){
		modelAndView.setViewName("DetalleProducto");
		modelAndView.addObject("DetallePedido", new DetallePedidoDM());		
		req.setObject(new Valores());
		modelAndView.addObject("valores",dataService.ReadAll(req));
		}
		else
			return new ModelAndView("redirect:/Home"); 
		
		return modelAndView;
	}
	
	
	
	
	
	private boolean FilterFile(MultipartFile file){

		String sString="";
		if (!file.isEmpty()){
			sString=file.getOriginalFilename().substring(file.getOriginalFilename().indexOf(".")+1);
		if(!(file.getSize()<=5000000))
		 return false;
		
		archivo.setPeso(file.getSize());
		
		if("PDF".equals(sString.toUpperCase()))
			archivo.setTipo("PDF");
		else if("DOCX".equals(sString.toUpperCase()))
			archivo.setTipo("DOCX");
		else if ("DOC".equals(sString.toUpperCase()))
				archivo.setTipo("DOC");
		else
			return false;
		}
		else return false;
		
		return true;
	}
	
	private boolean CountPages(File file){
		boolean result = false;
		
		
			if(archivo.getTipo().equals("PDF")){
				archivo.setCantPag(CountPagesPDF(file));
			}
			else if(archivo.getTipo().equals("DOC"))
			{
				archivo.setCantPag(CountPagesDoc(file));
			}
			else
				archivo.setCantPag(CountPagesDocx(file));
		
			if(archivo.getCantPag()>0)
				result=true;
			
		return result;
	}
	private String getdate(){
		 Date d1 = new Date();
		 SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY");
		 String formattedDate = df.format(d1);
		 return formattedDate;
	}
	
	

	
	private int CountPagesDocx(File file){
		XWPFDocument docx=null;
		
		try {
			docx = new XWPFDocument(POIXMLDocument.openPackage(file.getAbsolutePath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
        return docx.getProperties().getExtendedProperties().getUnderlyingProperties().getPages();
	}
	private int CountPagesDoc(File file){
		int i = 0;
		try{
        HWPFDocument wordDoc = new HWPFDocument(new FileInputStream(file.getAbsolutePath()));
        i=wordDoc.getSummaryInformation().getPageCount();
        }
		catch(IOException e){
			e.printStackTrace();
		}
        return i;
    	}
	private int CountPagesPDF(File file){
		int i = 0 ;
		try {
			doc = PDDocument.load(file);
			i=doc.getNumberOfPages();
		} catch (InvalidPasswordException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return i;

	}
	
	@RequestMapping(value="/CrearCupon", method = RequestMethod.GET)
	public void CreateCoupon(HttpServletRequest request, HttpServletResponse response){
		
	      PDDocument document = new PDDocument() ;    
	      PDPage page = new PDPage() ;
	      rootPath=request.getSession().getServletContext().getRealPath("/");
	      File dir=null;
			   this.pedido = (Pedido)request.getSession().getAttribute("pedido");
	         try{
	        	 dir = new File(rootPath + File.separator+"COMPROBANTES"+ File.separator + pedido.getId_Pedido());
	        	 if (!dir.exists())
	 				dir.mkdirs();
	            

	        	 
	      PDPageContentStream contentStream = new PDPageContentStream(document, page) ;
	      contentStream.beginText() ; 
	      contentStream.setFont(PDType1Font.TIMES_ROMAN, 12) ;
	      contentStream.setLeading(14.5f) ;	      
	      contentStream.newLineAtOffset(25,700) ;
	      String Header="PEDIDO NUMERO:"+pedido.getId_Pedido()+" USUARIO:"+pedido.getAlumno().getNombre_Usuario() + " FECHA DE PEDIDO:"+pedido.getFecha_Pedido();
	      String Datos="FECHA DE ENTREGA:"+ pedido.getFecha_Entrega()+"   TOTAL: $"+pedido.getTotal()+"  PAGADO: "; Datos+=pedido.isPagado() ? "Si" : "NO";
	      String Archivos="";
	      for(DetallePedido p : pedido.getDetalleventa()){
	    	  contentStream.showText("ARCHIVO :"+p.getArchivo().getNombre()+" CANTIDAD: " +p.getCantidad()+ "   "+p.getValor().getDescripcion());
	    	  contentStream.newLine() ;
	    	  }
	      
	      contentStream.showText(Header);  
	      contentStream.newLine() ;
	      contentStream.showText(Datos);
	      contentStream.newLine() ;
	      contentStream.showText(Archivos);
	      contentStream.endText();
	      contentStream.close();
	      document.addPage(page);
	      String finalURL=dir.getAbsolutePath()+File.separator+pedido.getAlumno().getNombre_Usuario()+".pdf";
	      document.save(new File(finalURL));
	      document.close();
	      
	      req.setId(GuardarComprobante(finalURL));
	      DownloadFile(finalURL, response);
	      pedido.setComprobante((Comprobantes)dataService.ReadOne(req));
	      req.setObject(pedido);
	      dataService.Update(req);
	      
	      Pedido pedido2= new Pedido();
	      List<DetallePedido> dp = new ArrayList<>();
		  pedido2.setDetalleventa(dp);
	      request.getSession().setAttribute("pedido", pedido2);
	      request.getSession().setAttribute("terminado", true);
	         }
	         catch(Exception e)
	         {	e.printStackTrace();}        
	}
	
	
	
	public int GuardarComprobante(String URL){
		Comprobantes comprobante = new Comprobantes();
		
		comprobante.setUrl(URL);
		comprobante.setPedido(pedido);
		req.setObject(comprobante);
		return dataService.Save(req);
		
	}
	
	
	
public void DownloadFile(String URL, HttpServletResponse response){
		
		File file = new File(URL);
        response.setHeader("Content-Type",file.getName());
        response.setHeader("Content-Length", String.valueOf(file.length()));
        response.setHeader("Content-Disposition", "attachment; filename=\""+file.getName()+"\"" );
        
        try {
			Files.copy(file.toPath(), response.getOutputStream()) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       }

	    public  String remove(String test) {
	        StringBuilder b = new StringBuilder();
	        for (int i = 0; i < test.length(); i++) {
	            if (WinAnsiEncoding.INSTANCE.contains(test.charAt(i))) {
	                b.append(test.charAt(i));
	            }
	        }
	        return b.toString();
	    }

	}

	

