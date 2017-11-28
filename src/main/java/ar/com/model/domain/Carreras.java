package ar.com.model.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.FetchMode;


@Entity
public class Carreras implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_Carrera;
	
	private String Descripcion;
	
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER) 
    @JoinTable(name="materias_carreras", joinColumns=@JoinColumn(name="id_Carrera"), inverseJoinColumns=@JoinColumn(name="id_Materia"))  
	private List<Materias> materias;
	
	

	public List<Materias> getMaterias() {
		return materias;
	}
	public void setMaterias(List<Materias> materias) {
		this.materias = materias;
	}
	public int getId_Carrera() {
		return id_Carrera;
	}
	public void setId_Carrera(int id_Carrera) {
		this.id_Carrera = id_Carrera;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public Carreras(String descripcion) {
		super();
		Descripcion = descripcion;
	}
	public Carreras() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
