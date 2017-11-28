package ar.com.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import  java.nio.file.StandardCopyOption.*;

import ar.com.DataModels.DetallePedidoDM;
import ar.com.DataModels.UpdateCant;
import ar.com.Request.data.Request;
import ar.com.ServiceLayer.ServiceCRUD;
import ar.com.model.domain.Archivo;
import ar.com.model.domain.Pedido;
import ar.com.model.domain.Usuario;

@Controller
@Scope("session")
public class CarritoController {
	@Autowired
	private ServiceCRUD dataService;
	@Autowired
	private Pedido pedido ;
	@Autowired
	private Request req ;
	@Autowired
	private Usuario user;
	
	@RequestMapping(value="/CarritoController")
	public ModelAndView Index( HttpServletRequest request){
		this.pedido = (Pedido)request.getSession().getAttribute("pedido");
		ModelAndView model = new ModelAndView();
		model.addObject("pedido",pedido);
		model.addObject("UpdateCant", new UpdateCant());
		model.setViewName("Carrito");
		return model;
	}
	@RequestMapping(value="/ImpresionesController")
	public ModelAndView impresiones( HttpServletRequest request){
		this.pedido = (Pedido)request.getSession().getAttribute("pedido");
	
		ModelAndView model = new ModelAndView();
		model.addObject("pedido",pedido);
		model.setViewName("Impresiones");
		return model;
	}
	
	@RequestMapping(value="/OpenPDF")
	  public void openPDF(HttpServletRequest request, HttpServletResponse response ) 
	{		
			String id =request.getParameter("IdArchivo");
			req.setId(Integer.parseInt(id));
			req.setObject( new Archivo());
			Archivo archivo=null;
			try {
				archivo = (Archivo)dataService.ReadOne(req);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        DownloadFile(archivo.getURL(), response);
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
	@RequestMapping(value="/ArchivosImpresos")
	public ModelAndView impresos( HttpServletRequest request){
		this.pedido = (Pedido)request.getSession().getAttribute("pedido");
		this.pedido.setImpreso(true);
		req.setObject(this.pedido);
		dataService.Update(req);
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/HomeAdmin");
		return model;
	}
	@RequestMapping(value="/ArchivosEntregados")
	public ModelAndView entregados( HttpServletRequest request){
		this.pedido = (Pedido)request.getSession().getAttribute("pedido");
		this.pedido.setEntregado(true);
		req.setObject(this.pedido);
		dataService.Update(req);
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/HomeAdmin");
		return model;
	}
	@RequestMapping(value="/VerComprobante")
	public void VerComprobante(HttpServletRequest request,HttpServletResponse response){
		this.pedido = (Pedido)request.getSession().getAttribute("pedido");
		DownloadFile(pedido.getComprobante().getUrl(), response);
	}

	
}
