package ar.com.model.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;



@Entity
@PrimaryKeyJoinColumn(name = "Id_Profesor", referencedColumnName = "Id_Persona")
public class Profesor extends Persona implements Serializable{

	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})  
    @JoinTable(name="materias_profesor", joinColumns=@JoinColumn(name="Id_Profesor"), inverseJoinColumns=@JoinColumn(name="id_Materia"))
	private List<Materias> materias;


	public Profesor(){super();}
	
	public Profesor(String DNI_Persona, String nombre_Persona,
			String apellido_Persona, String telefono_Persona,
			String email_Persona, String fechaDeNac_Persona,
			String domicilio_Persona,long legajo) {
		super(DNI_Persona, nombre_Persona, apellido_Persona, telefono_Persona,
				email_Persona, fechaDeNac_Persona, domicilio_Persona,legajo);
	}

	public List<Materias> getMaterias() {
		return materias;
	}
	public void setMaterias(List<Materias> materias) {
		this.materias = materias;
	}
	
	
	
}
