package ar.com.ServiceLayer.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import junit.framework.Assert;
import ar.com.Request.data.Request;
import ar.com.ServiceLayer.ServiceCRUD;
import ar.com.config.spring.AppConfig;
import ar.com.model.domain.Administrador;
import ar.com.model.domain.Alumno;
import ar.com.model.domain.Archivo;
import ar.com.model.domain.Carreras;
import ar.com.model.domain.DetallePedido;
import ar.com.model.domain.Materias;
import ar.com.model.domain.Pedido;
import ar.com.model.domain.Profesor;
import ar.com.model.domain.Tipos;
import ar.com.model.domain.Usuario;
import ar.com.model.domain.Valores;

@RunWith(JUnit4.class)
public class ServiceLayerTest{
	
	private ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
	private ServiceCRUD service=(ServiceCRUD)context.getBean("Service");
	
	private Request req;
	private Alumno alumno ;
	private Profesor profesor;
	private Materias materia;
	private Materias materia1;
	private List<Profesor> profesores ;
	private List<Materias> materias ;
	private List<Alumno> alumnos ;
	private List<Carreras> carreras ;
	private Carreras carrera;
	private Usuario user;
	private Usuario userProfesor;
	private Usuario userAdmin;
	private Administrador admin;
	private Archivo file;
	private Archivo file2;
	private Tipos tipo1;
	private Tipos tipo2;
	private Tipos tipo3;
	private Pedido pedido;
	private DetallePedido detalle1;
	private DetallePedido detalle2;
	private List<DetallePedido> detalles ;
	private Valores valor;
	
	
	@Before
	public void Initialize(){
		materias = new ArrayList<>();
		alumnos = new ArrayList<>();
		profesores = new ArrayList<>();
		carreras = new ArrayList<>();
		req = new Request();
		profesor = new Profesor();
		carrera= new Carreras();
		alumno =  new Alumno();
		user= new Usuario();
		userProfesor = new Usuario();
		userAdmin = new Usuario();
		admin = new Administrador();
		file = new Archivo();
		file2 = new Archivo();
		tipo1= new Tipos();
		tipo2 = new Tipos();
		tipo3 = new Tipos();
		pedido= new Pedido();
		detalle1 = new DetallePedido();
		detalle2 = new DetallePedido();
		detalles = new ArrayList<>();
		valor = new Valores();
		materia1 = new Materias();
	}
	
	public void CreateAlumno(){
		alumno.setApellido_Persona("Agnolin");
		alumno.setDNI_Persona("38277272");
		alumno.setDomicilio_Persona("Sobremonte 1735");
		alumno.setEmail_Persona("matiasagnolin@gmail.com");
		alumno.setFechaDeNac_Persona("19940618");
		alumno.setLegajo(19351);
		alumno.setNombre_Persona("Matias");
		alumno.setTelefono_Persona("1168826221");
	}
	
	public void CreateProfesor(){
		profesor.setApellido_Persona("Profesor1");
		profesor.setDNI_Persona("11111111");
		profesor.setDomicilio_Persona("calle 1234");
		profesor.setEmail_Persona("mailprofesor1@gmail.com");
		profesor.setFechaDeNac_Persona("19941806");
		profesor.setLegajo(16676);
		profesor.setNombre_Persona("Profesor1");
		profesor.setTelefono_Persona("1168826221");
	}
	
	public void CreateAdmin(){
		admin.setApellido_Persona("Admin1");
		admin.setDNI_Persona("11111111");
		admin.setDomicilio_Persona("calle 1234");
		admin.setEmail_Persona("mailadmin@gmail.com");
		admin.setFechaDeNac_Persona("19941806");
		admin.setLegajo(123123);
		admin.setNombre_Persona("Admin1");
		admin.setTelefono_Persona("1168826221");
	}
	
	public void CreateMaterias(){
		materia = new  Materias();
		materia.setNombre("Seminario");
		materia1 = new Materias();
		materia1.setNombre("Matodologia");
		materias.add(materia);
		materias.add(materia1);
	}

	public void CreateCarreras(){
		carrera.setDescripcion("TSSI");
		carreras.add(carrera);
	}	
	
	public void CreateUsuario(){
		user.setNombre_Usuario("matias");
		user.setPassword_Usuario("matias123");
		
		userProfesor.setNombre_Usuario("Profesor");
		userProfesor.setPassword_Usuario("Profesor123");
		
		userAdmin.setNombre_Usuario("Admin");
		userAdmin.setPassword_Usuario("admin123");
		
	}
	
	public void CreateFile(){
		file.setNombre("FILE1");
		file.setPeso(1);
		file.setTipo("PDF");
		file.setURL("AaAAa//aaAAA//AA/AAaa//");
		file.setPublico(true);
		file.setAprobado(true);
		
		file2.setNombre("FILE2");
		file2.setPeso(1);
		file2.setTipo("PDF");
		file2.setURL("AaAAa//aaAAA//AA/AAaa//");
		file2.setPublico(true);
		file2.setAprobado(true);
	}
	
	public void CreateTipo(){
		tipo1.setDescripcion(Alumno.class.toString());
		tipo2.setDescripcion(Profesor.class.toString());
		tipo3.setDescripcion(Administrador.class.toString());
	}
	
	public void CreateDetalleVenta(){
		detalle1.setCantidad(2);
		
		detalle2.setCantidad(3);
		
	}
	
	public void CreateValores(){
		valor.setValor(2);
		valor.setDescripcion("Simple Faz");
	}
	
	public void CreatePedido(){
		pedido.setFecha_Entrega("12102017");
		pedido.setFecha_Pedido("11102017");
	}

	
	@Test
	public void test(){
		
		try
		{
			CreateAlumno();
			CreateProfesor();
			CreateMaterias();
			CreateCarreras();
			CreateUsuario();
			CreateAdmin();
			CreateTipo();
			CreateFile();
			CreateValores();
			CreateDetalleVenta();
			CreatePedido();
			
			
			alumnos.add(alumno);
			profesores.add(profesor);
			
			materia.setAlumnos(alumnos);
			
			materia1.setAlumnos(alumnos);
			
			materia.setProfesores(profesores);
			materia1.setProfesores(profesores);
			
			alumno.setMaterias(materias);
			
			profesor.setMaterias(materias);
			
			materia.setCarreras(carreras);
			materia1.setCarreras(carreras);
			
			carrera.setMaterias(materias);
			
			user.setPersona(alumno);
			user.setRole_Usuario(tipo1);
			userProfesor.setPersona(profesor);
			userProfesor.setRole_Usuario(tipo2);
			userAdmin.setPersona(admin);
			userAdmin.setRole_Usuario(tipo3);
			
			alumno.setUsuario(user);
			profesor.setUsuario(userProfesor);
			admin.setUsuario(userAdmin);
			
			
			user.setRole_Usuario(tipo1);
			userProfesor.setRole_Usuario(tipo2);
			userAdmin.setRole_Usuario(tipo3);
			
			file.setUser(userProfesor);
			
			file2.setUser(user);
			
			file.setMateria(materia);
			
			file2.setMateria(materia1);
			
			file.setCarrera(carrera);
			file2.setCarrera(carrera);
			
			detalle1.setArchivo(file);
			detalle1.setValor(valor);
			
			detalle2.setArchivo(file2);
			detalle2.setValor(valor);
			
			detalle1.setPedido(pedido);
			detalle2.setPedido(pedido);
			
			CalcularSubTotal(detalle1);
			CalcularSubTotal(detalle2);
			
			detalles.add(detalle1);
			detalles.add(detalle2);
			
			pedido.setDetalleventa(detalles);
			pedido.setAlumno(user);
			
			CalcularTotal(pedido);
			
			save_object(materia);
			save_object(materia1);
			save_object(carrera);
			save_object(alumno);
			save_object(profesor);
			save_object(admin);
			save_object(tipo1);
			save_object(tipo2);
			save_object(tipo3);
			save_object(user);
			save_object(userProfesor);
			save_object(userAdmin);
			save_object(file);
			save_object(file2);
			save_object(valor);
//			save_object(detalle1);
//			save_object(detalle2);
			save_object(pedido);
		}
		catch(Exception e){
			Assert.assertTrue(false);
		}
		
	}
	
	private void save_object (Object request){
		
		req.setObject(request);
		service.Save(req);
		
	}
	
	public void CalcularTotal(Pedido pedido){
		double total=0;
		for(DetallePedido dt : pedido.getDetalleventa()){
			total+=dt.getTotalParcial();
		}
		pedido.setTotal(total);
	}
	
	public void CalcularSubTotal(DetallePedido detalle){
		detalle.setTotalParcial(detalle.getCantidad()*detalle.getValor().getValor());
	}
}

