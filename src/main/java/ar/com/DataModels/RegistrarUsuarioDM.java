package ar.com.DataModels;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;

import ar.com.model.domain.Carreras;
import ar.com.model.domain.Materias;

public class RegistrarUsuarioDM implements Serializable {
	private String DNI_Persona;
	private String Nombre_Persona;
	private String Apellido_Persona;
	private String Telefono_Persona;
	private String Email_Persona;
	private String FechaDeNac_Persona;
	private String Domicilio_Persona;	
	private int Nombre_Usuario;
	private String Password_Usuario;
	private long legajo;
	private String Tipo;
	private List<String> materias;
	private Carreras carrera;
	
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String alumno) {
		this.Tipo = alumno;
	}

	public int getNombre_Usuario() {
		return Nombre_Usuario;
	}
	public void setNombre_Usuario(int nombre_Usuario) {
		Nombre_Usuario = nombre_Usuario;
	}
	public String getPassword_Usuario() {
		return Password_Usuario;
	}
	public void setPassword_Usuario(String password_Usuario) {
		Password_Usuario = password_Usuario;
	}
	public String getDNI_Persona() {
		return DNI_Persona;
	}
	public void setDNI_Persona(String dNI_Persona) {
		DNI_Persona = dNI_Persona;
	}
	public String getNombre_Persona() {
		return Nombre_Persona;
	}
	public void setNombre_Persona(String nombre_Persona) {
		Nombre_Persona = nombre_Persona;
	}
	public String getApellido_Persona() {
		return Apellido_Persona;
	}
	public void setApellido_Persona(String apellido_Persona) {
		Apellido_Persona = apellido_Persona;
	}
	public String getTelefono_Persona() {
		return Telefono_Persona;
	}
	public void setTelefono_Persona(String telefono_Persona) {
		Telefono_Persona = telefono_Persona;
	}
	public String getEmail_Persona() {
		return Email_Persona;
	}
	public void setEmail_Persona(String email_Persona) {
		Email_Persona = email_Persona;
	}
	public String getFechaDeNac_Persona() {
		return FechaDeNac_Persona;
	}
	public void setFechaDeNac_Persona(String fechaDeNac_Persona) {
		FechaDeNac_Persona = fechaDeNac_Persona;
	}
	public String getDomicilio_Persona() {
		return Domicilio_Persona;
	}
	public void setDomicilio_Persona(String domicilio_Persona) {
		Domicilio_Persona = domicilio_Persona;
	}
	public long getLegajo() {
		return legajo;
	}
	public void setLegajo(long legajo) {
		this.legajo = legajo;
	}
	public List<String> getMaterias() {
		return materias;
	}
	public void setMaterias(List<String> materias) {
		this.materias = materias;
	}
	public Carreras getCarrera() {
		return carrera;
	}
	public void setCarrera(Carreras carrera) {
		this.carrera = carrera;
	}

	
}
