package ar.com.model.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "Id_Administrador", referencedColumnName = "Id_Persona")
public class Administrador extends Persona implements Serializable{
	

	
	public Administrador(){super();}
	
	public Administrador(String DNI_Persona, String nombre_Persona,
			String apellido_Persona, String telefono_Persona,
			String email_Persona, String fechaDeNac_Persona,
			String domicilio_Persona,long legajo) {
		super(DNI_Persona, nombre_Persona, apellido_Persona, telefono_Persona,
				email_Persona, fechaDeNac_Persona, domicilio_Persona,legajo);
	}


	
	
}
