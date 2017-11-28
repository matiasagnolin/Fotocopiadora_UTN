package ar.com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.DataModels.ProductoDM;
import ar.com.Request.data.Request;
import ar.com.ServiceLayer.ServiceCRUD;
import ar.com.model.domain.Archivo;
import ar.com.model.domain.Usuario;

@Controller
@Scope("session")
public class ActualizarProducto {
	@Autowired
	private ServiceCRUD dataService;
//	@Autowired
//	private ServiceBussines BussinesService;
	@Autowired
	private Request req ;
	@Autowired
	private Usuario user;
	
	@RequestMapping(value="/Producto")
	public ModelAndView Index(HttpServletRequest request){
		this.user=(Usuario)request.getSession().getAttribute("usuario");		
		String id =request.getParameter("archivo");
		request.getSession().removeAttribute("ERROR");
		ModelAndView modelAndView = new ModelAndView();
		try {
		req.setObject(new Archivo());
		req.setId(Integer.parseInt(id));
		modelAndView.addObject("archivo",(Archivo)dataService.ReadOne(req));
		modelAndView.addObject("producto", new ProductoDM());
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		modelAndView.setViewName("ActualizarProducto");		
		return modelAndView;
	}
	@RequestMapping(value="/Actualizar")
	public String Actualizar(@ModelAttribute("producto") ProductoDM producto,HttpServletRequest request){
		ModelAndView model = new ModelAndView();
		request.getSession().removeAttribute("ERROR");
		req.setObject(new Archivo());
		req.setId(producto.getIdArchivo());
		try {
			Archivo archivo = (Archivo)dataService.ReadOne(req);
			archivo.setNombre(producto.getName());
			archivo.setResumen(producto.getComment());
			req.setObject(archivo);
			dataService.Update(req);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return   "redirect:/Home";
	}
	@RequestMapping(value="/Aprobar")
	public String Aprobar(@ModelAttribute("producto") ProductoDM producto,HttpServletRequest request){
		ModelAndView model = new ModelAndView();
		request.getSession().removeAttribute("ERROR");
		req.setObject(new Archivo());
		req.setId(producto.getIdArchivo());
		try {
			Archivo archivo = (Archivo)dataService.ReadOne(req);
			if(producto.isAprobado())
				archivo.setAprobado(true);
			else
				//archivo.setDeleted(true);
				archivo.setPublico(false);
			req.setObject(archivo);
			dataService.Update(req);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return   "redirect:/Home";
	}
	@RequestMapping(value="/Eliminar")
	public String Eliminar(@ModelAttribute("producto") ProductoDM producto,HttpServletRequest request){
		ModelAndView model = new ModelAndView();
		req.setObject(new Archivo());
		req.setId(producto.getIdArchivo());
		try {
			Archivo archivo = (Archivo)dataService.ReadOne(req);
			archivo.setDeleted(true);
			req.setObject(archivo);
			dataService.Update(req);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return   "redirect:/Home";
	}
}
