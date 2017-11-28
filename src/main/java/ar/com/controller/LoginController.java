package ar.com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.com.DataModels.RegistrarUsuarioDM;
import ar.com.Request.data.Request;
import ar.com.ServiceLayer.ServiceBussines;
import ar.com.ServiceLayer.ServiceCRUD;
import ar.com.model.domain.Administrador;
import ar.com.model.domain.Alumno;
import ar.com.model.domain.DetallePedido;
import ar.com.model.domain.Pedido;
import ar.com.model.domain.Profesor;
import ar.com.model.domain.Usuario;

@Controller
@Scope("session")
public class LoginController {


	@Autowired
	private ServiceCRUD dataService;
	@Autowired
	private Request req ;
	@Autowired
	private Usuario user;
	@Autowired
	private Pedido pedido;

	
	@RequestMapping(value="/")
	public ModelAndView Index(Model model){
		model.addAttribute("usuario", new Usuario());
		return new ModelAndView("Login");
	}
	

	
	@RequestMapping(value="/Login", method=RequestMethod.POST)
	public ModelAndView Login(@ModelAttribute("usuario") Usuario usuario,
            BindingResult result,HttpServletRequest requ) throws Exception
	{
		System.out.println(usuario.getNombre_Usuario());
		
		usuario.setError(false);
		List<Object> list = new ArrayList<>();
		Map<Object,Object> map = new HashMap<>();
		map.put("Nombre_Usuario", usuario.getNombre_Usuario());
		
		Pedido pedido= new Pedido();
		List<DetallePedido> dp = new ArrayList<>();
		pedido.setDetalleventa(dp);	
		
		list = dataService.ExecuteCriteria(Usuario.class, map); 
		
		if(list.size()>0)
		 user = (Usuario)list.get(0);
		
		
		if(user.equals(usuario)){
			if(user.getRole_Usuario().equals(Alumno.class))
				user.setPersona((Alumno)user.getPersona());
			else if (user.getRole_Usuario().equals(Profesor.class))
				user.setPersona((Profesor)user.getPersona());
			else
				user.setPersona((Administrador)user.getPersona());
			if((user.getRole_Usuario().equals(Alumno.class)) || (user.getRole_Usuario().equals(Profesor.class))){
			requ.getSession().setAttribute("usuario", this.user);
			requ.getSession().setAttribute("pedido", pedido);
			return  new ModelAndView("redirect:/Home");}
			else {
				requ.getSession().setAttribute("usuario", this.user);
				return  new ModelAndView("redirect:/HomeAdmin");}
		}
		else{
			usuario.setError(true);
			return new ModelAndView("Login","usuario",usuario);
		}
		
	}


}
	