package ar.com.model.domain;

import java.io.Serializable;
import ar.com.model.domain.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Archivo implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id_Archivo;
	private String Nombre;
	private String Tipo;
	private int CantPag;
	private String URL;
	private double Peso; //expresado en mb
	private boolean Publico;
	private String fecha;
	private boolean Aprobado;
	@Column(length=140)
	private String Resumen;
	private boolean Deleted;
	
	public boolean isDeleted() {
		return Deleted;
	}
	public void setDeleted(boolean deleted) {
		Deleted = deleted;
	}
	@ManyToOne
	@JoinColumn(name="Id_Materia")
	private Materias materia;
	
	@ManyToOne
	@JoinColumn(name="id_Carrera")
	private Carreras carrera;
	
	@ManyToOne
	@JoinColumn(name="Id_Usuario")
	private Usuario user;
	
	public Archivo() {
		super();
	}
	public Archivo(String nombre, String tipo, int cantPag, String uRL, double peso, boolean publico) {
		super();
		Nombre = nombre;
		Tipo = tipo;
		CantPag = cantPag;
		URL = uRL;
		Peso = peso;
		Publico = publico;
	}
	public int getId_Archivo() {
		return Id_Archivo;
	}
	public void setId_Archivo(int id_Archivo) {
		Id_Archivo = id_Archivo;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public int getCantPag() {
		return CantPag;
	}
	public void setCantPag(int cantPag) {
		CantPag = cantPag;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public double getPeso() {
		return Peso;
	}
	public void setPeso(double peso) {
		Peso = peso;
	}
	public boolean isPublico() {
		return Publico;
	}
	public void setPublico(boolean publico) {
		this.Publico = publico;
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public Materias getMateria() {
		return materia;
	}
	public void setMateria(Materias materia) {
		this.materia = materia;
	}
	public Carreras getCarrera() {
		return carrera;
	}
	public void setCarrera(Carreras carrera) {
		this.carrera = carrera;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public boolean isAprobado() {
		return Aprobado;
	}
	public void setAprobado(boolean aprobado) {
		Aprobado = aprobado;
	}
	public String getResumen() {
		return Resumen;
	}
	public void setResumen(String resumen) {
		Resumen = resumen;
	}
	
	
}
