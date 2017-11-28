package ar.com.model.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;




@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Persona implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String Alumno = null;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Id_Persona", unique = true, nullable = false)
	private int Id_Persona;
	private String DNI_Persona;
	@Column(name="Nombre_Persona")
	private String Nombre_Persona;
	@Column(name="Apellido_Persona")
	private String Apellido_Persona;
	@Column(name="Telefono_Persona")
	private String Telefono_Persona;
	@Column(name="Email_Persona")
	private String Email_Persona;
	@Column(name="FechaDeNac_Persona")
	private String FechaDeNac_Persona;
	@Column(name="Domicilio_Persona")
	private String Domicilio_Persona;
	
	private long legajo;
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "Persona")
	private Usuario user;
	
	public Persona(){}
	
	public Persona(String DNI_Persona, String nombre_Persona, String apellido_Persona, String telefono_Persona,
			String email_Persona, String fechaDeNac_Persona, String domicilio_Persona,long legajo)  {
			
			this.DNI_Persona = DNI_Persona;
			this.Nombre_Persona = nombre_Persona;
			this.Apellido_Persona = apellido_Persona;
			this.Telefono_Persona = telefono_Persona;
			this.Email_Persona = email_Persona;
			this.FechaDeNac_Persona = fechaDeNac_Persona;
			this.Domicilio_Persona = domicilio_Persona;		
			this.legajo=legajo;
	}
	public Persona(int Id_Persona,String DNI_Persona, String nombre_Persona, String apellido_Persona, String telefono_Persona,
			String email_Persona, String fechaDeNac_Persona, String domicilio_Persona,
			//Usuario usuario,
			long legajo)  {
			this.Id_Persona=Id_Persona;
			this.DNI_Persona = DNI_Persona;
			this.Nombre_Persona = nombre_Persona;
			this.Apellido_Persona = apellido_Persona;
			this.Telefono_Persona = telefono_Persona;
			this.Email_Persona = email_Persona;
			this.FechaDeNac_Persona = fechaDeNac_Persona;
			this.Domicilio_Persona = domicilio_Persona;		
			//this.usuario=usuario;
			this.legajo=legajo;
	}
	public Persona(String DNI_Persona)  {
		
			this.DNI_Persona = DNI_Persona;	
	}
	public Persona(int Id_Persona)  {
		
		this.Id_Persona = Id_Persona;	
}
	public Persona(String DNI_Persona, String nombre_Persona, String apellido_Persona)  {
		
		this.DNI_Persona = DNI_Persona;
		this.Nombre_Persona = nombre_Persona;
		this.Apellido_Persona = apellido_Persona;
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

	public int getId_Persona(){
		return Id_Persona;
	}
	public void setId_Persona(int Id_Persona){
		this.Id_Persona=Id_Persona;
	}
	public long getLegajo(){
		return legajo;
	}
	public void setLegajo(long legajo){
		this.legajo=legajo;
	}
	public Usuario getUsuario() {
		return user;
	}

	public void setUsuario(Usuario usuario) {
		this.user = usuario;
	}

	@Override
	public String toString() {
		return  DNI_Persona;
	}

	
	
}
