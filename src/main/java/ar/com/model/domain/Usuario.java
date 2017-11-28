package ar.com.model.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Entity
@Table(name="usuarios")
@Component
@Scope("session")
public class Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id_Usuario;
	
	private String Nombre_Usuario;
	
	@OneToOne
	@JoinColumn(name="Id_Persona")
	private Persona Persona;
	
	@Column(name="Password_Usuario")
	private String Password_Usuario;

	@OneToOne
	@JoinColumn(name="id_tipo")
	private Tipos tipo;
	@Transient
	private boolean error;
	
	public Tipos getTipo() {
		return tipo;
	}

	public void setTipo(Tipos tipo) {
		this.tipo = tipo;
	}

	public boolean getError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public Usuario(){}

	public Usuario(String nombre_Usuario, String password_Usuario, Persona DNI) {
		this.Nombre_Usuario = nombre_Usuario;
		this.Password_Usuario = password_Usuario;
		//this.Role_Usuario = role_Usuario;
		this.Persona = DNI;
	}
	public Usuario(String nombre_Usuario, String password_Usuario) {
		this.Nombre_Usuario = nombre_Usuario;
		this.Password_Usuario = password_Usuario;
		//this.Role_Usuario = role_Usuario;

	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((Nombre_Usuario == null) ? 0 : Nombre_Usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (Nombre_Usuario == null) {
			if (other.Nombre_Usuario != null)
				return false;
		} else if (!Nombre_Usuario.equals(other.Nombre_Usuario) || !Password_Usuario.equals(other.Password_Usuario))
			return false;
		System.out.println(this.getPassword_Usuario());
		return true;
	}

	public String getNombre_Usuario() {
		return Nombre_Usuario;
	}

	public void setNombre_Usuario(String nombre_Usuario) {
		Nombre_Usuario = nombre_Usuario;
	}

	public String getPassword_Usuario() {
		return Password_Usuario;
	}

	public void setPassword_Usuario(String password_Usuario) {
		Password_Usuario = password_Usuario;
	}

	

	public Persona getPersona() {
		return Persona;
	}

	public void setPersona(Persona persona) {
		Persona = persona;
	}

	@Override
	public String toString() {
		return  Nombre_Usuario ;
	}

	public Tipos getRole_Usuario() {
		return tipo;
	}

	public void setRole_Usuario(Tipos role_Usuario) {
		tipo = role_Usuario;
	}


	
}
