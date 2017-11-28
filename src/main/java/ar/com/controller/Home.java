package ar.com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.DataModels.CarrerasMateriaMD;
import ar.com.Request.data.Request;
import ar.com.ServiceLayer.ServiceCRUD;
import ar.com.model.domain.Alumno;
import ar.com.model.domain.Archivo;
import ar.com.model.domain.Carreras;
import ar.com.model.domain.Materias;
import ar.com.model.domain.Pedido;
import ar.com.model.domain.Profesor;
import ar.com.model.domain.Usuario;

@Controller
@Scope("session")
public class Home {
	@Autowired
	private ServiceCRUD dataService;
	@Autowired
	private Request req ;
	@Autowired
	private Usuario user;
	
	@RequestMapping(value="/Home")
	public ModelAndView Index(HttpServletRequest request){
		request.getSession().setAttribute("terminado", false);
		this.user=(Usuario)request.getSession().getAttribute("usuario");
		List<List<Archivo>> archivos=new ArrayList<List<Archivo>>();
		List<Materias> materias=null;
		List<Carreras> carreras=null;
		boolean alm=false;
		boolean prf=false;
		boolean approved=false;
		ModelAndView model = new ModelAndView();
		List<Object> mat = (List<Object>)(Object)dataService.getMaterias(user.getPersona());
		
		if((user.getRole_Usuario().equals(Alumno.class)))
			alm=true;
		if(user.getRole_Usuario().equals(Profesor.class))
			prf=true;
		
		
		Materias[] m = new Materias[mat.size()];
		for(int i = 0; i<mat.size();i++)
		{
			if(mat.get(i) instanceof Object[])
			{
				Object[] o =(Object[]) mat.get(i);
				for(int h = 0 ;h<o.length;h++)
					if(o[h] instanceof Materias)
						archivos.add(dataService.getArchivos(alm,prf,(Materias)o[h]));
			}
		}
		List<Archivo> finalm = new ArrayList<Archivo>();
		
		for(List<Archivo> v :archivos )
		for(Archivo ar : v){
			if(alm){
			if(!ar.isDeleted())
				if(ar.isAprobado())
					if(ar.isPublico())
						finalm.add(ar);}
			else if(prf){
				if(!ar.isDeleted())
					if(ar.isPublico())
						finalm.add(ar);}
			}
			req.setObject(new Carreras());
			carreras = (List<Carreras>)(Object)dataService.ReadAll(req);
			model.addObject("command",new CarrerasMateriaMD());
			model.addObject("carreras",carreras);
			model.addObject("archivos", finalm);
			model.addObject("usuario", this.user);
			model.setViewName("Home");
		return model;
	}
	
	@RequestMapping(value="/DestruirSesion")
	public String DestruirSesion(HttpServletRequest request){
		try {
				request.logout();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getSession().removeAttribute("pedido");
		request.getSession().removeAttribute("usuario");
		request.getSession().removeAttribute("ERROR");
		request.getSession().setAttribute("pedido", new Pedido());
		
		return "redirect:/";
	}
	@RequestMapping(value="/HomeAdmin")
	public ModelAndView HomeAdmin(HttpServletRequest request){
	ModelAndView model = new ModelAndView();
		model.setViewName("HomeAdmin");
		List<Pedido> pedidos =null;
		req.setObject(new Pedido());
		pedidos= (List<Pedido>)(Object)dataService.ExecuteQuery(req, "Entregado", false);
		model.addObject("pedidos", pedidos);
		return model;
	}
	
}
