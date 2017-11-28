package ar.com.model.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;




@Entity
public class Materias  implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_Materia;
	
	private String Nombre;  

	@ManyToMany(mappedBy="materias")  
	private List<Alumno> materias_alumnos;
	
    
    
	@ManyToMany(mappedBy="materias")
	private List<Profesor> materias_profesores ;
	
	
	@ManyToMany(mappedBy="materias", fetch = FetchType.LAZY)
	private List<Carreras> materias_carrera;
	
	public List<Profesor> getProfesores() {
		return materias_profesores;
	}
	public void setProfesores(List<Profesor> profesores) {
		this.materias_profesores = profesores;
	}
	public Materias(String nombre) {
		super();
		Nombre = nombre;
	}
	public Materias() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId_Materia() {
		return id_Materia;
	}
	public void setId_Materia(int id_Materia) {
		this.id_Materia = id_Materia;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public List<Alumno> getAlumnos() {
		return materias_alumnos;
	}
	public void setAlumnos(List<Alumno> alumnos) {
		this.materias_alumnos = alumnos;
	}
	public List<Carreras> getCarreras() {
		return materias_carrera;
	}
	public void setCarreras(List<Carreras> carreras) {
		this.materias_carrera = carreras;
	}
	

}
