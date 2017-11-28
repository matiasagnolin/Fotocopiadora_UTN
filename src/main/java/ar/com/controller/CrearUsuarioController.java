package ar.com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.com.DataModels.RegistrarUsuarioDM;
import ar.com.Request.data.Request;
import ar.com.ServiceLayer.ServiceBussines;
import ar.com.ServiceLayer.ServiceCRUD;
import ar.com.model.domain.Alumno;
import ar.com.model.domain.Carreras;
import ar.com.model.domain.Materias;
import ar.com.model.domain.Persona;
import ar.com.model.domain.Profesor;
import ar.com.model.domain.Tipos;
import ar.com.model.domain.Usuario;

@Controller
@Scope("session")
public class CrearUsuarioController {

	@Autowired
	private ServiceCRUD dataService;
//	@Autowired
//	private ServiceBussines BussinesService;
	@Autowired
	private Request req ;
//	@Autowired
//	private HttpServletRequest context;
//	@Autowired
//	private Usuario user;
	

	@RequestMapping(value="/CrearUsuario" )
	public ModelAndView Index(Model model){
		List<Carreras> carreras=null;
		model.addAttribute("usuario",new RegistrarUsuarioDM());
		req.setObject(new Carreras());
		carreras = (List<Carreras>)(Object)dataService.ReadAll(req);
		model.addAttribute("carreras", carreras);
		return new ModelAndView("CrearUsuario");
	}
	
	@RequestMapping(value = "/GuardarUsuario", method = RequestMethod.POST)
	public ModelAndView Create(@ModelAttribute("usuario") RegistrarUsuarioDM usuario,
            BindingResult result){
		
		Usuario user = new Usuario();
		Persona persona;
		List<Materias> materias = new ArrayList<Materias>();
		req.setObject(new Tipos());
		List<Tipos>tipos =(List<Tipos>)(Object) dataService.ReadAll(req);
		
		if(usuario.getTipo().equals("Alumno")){
			user.setTipo(tipos.get(0));
			persona = new Alumno();}
		else{
			persona= new Profesor();
			user.setTipo(tipos.get(1));}
		
		user.setNombre_Usuario(String.valueOf(usuario.getNombre_Usuario()));
		user.setPassword_Usuario(usuario.getPassword_Usuario());
		req.setObject(new Materias());
		try{
		for(String id : usuario.getMaterias()){
			req.setId(Integer.parseInt(id));
			materias.add((Materias)dataService.ReadOne(req));
			}
		}
		catch(Exception e){e.printStackTrace();}
		
		if(usuario.getTipo().equals("Alumno"))
			((Alumno)persona).setMaterias(materias);
		else
			((Profesor)persona).setMaterias(materias);
		
		persona.setNombre_Persona(usuario.getNombre_Persona());
		persona.setApellido_Persona(usuario.getApellido_Persona());
		persona.setEmail_Persona(usuario.getEmail_Persona());
		persona.setDNI_Persona(user.getPassword_Usuario());
		persona.setUsuario(user);
		user.setPersona(persona);
		req.setObject(persona);
		dataService.Save(req);
		req.setObject(user);
		dataService.Save(req);
		
		return new ModelAndView("redirect:/HomeAdmin");
	}


}
