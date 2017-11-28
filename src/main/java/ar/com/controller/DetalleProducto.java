package ar.com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.DataModels.DetallePedidoDM;
import ar.com.Request.data.Request;
import ar.com.ServiceLayer.ServiceCRUD;
import ar.com.model.domain.Alumno;
import ar.com.model.domain.Archivo;
import ar.com.model.domain.Usuario;
import ar.com.model.domain.Valores;

@Controller
@Scope("session")
public class DetalleProducto {

	@Autowired
	private ServiceCRUD dataService;
//	@Autowired
//	private ServiceBussines BussinesService;
	@Autowired
	private Request req ;
	@Autowired
	private Usuario user;
	
	@RequestMapping(value="/DetalleProducto")
public ModelAndView Index(HttpServletRequest request){
		this.user=(Usuario)request.getSession().getAttribute("usuario");		
		String id =request.getParameter("archivo");
		request.getSession().removeAttribute("ERROR");		
		
		ModelAndView modelAndView = new ModelAndView();
		try {
			req.setObject(new Valores());
			modelAndView.addObject("valores",(List<Valores>)(Object) dataService.ReadAll(req));
			req.setObject(new Archivo());
			req.setId(Integer.parseInt(id));
			modelAndView.addObject("archivo",(Archivo)dataService.ReadOne(req));
			modelAndView.addObject("DetallePedido", new DetallePedidoDM());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		modelAndView.setViewName("DetalleProducto");		
		return modelAndView;

	}
	
	
}
