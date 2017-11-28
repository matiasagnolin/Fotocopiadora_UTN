package ar.com.model.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.metamodel.Type;
@Entity
public class Valores implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id_Valor;
	private double Valor;
	private String Descripcion;

	
	
	
	public Valores() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Valores(double valor, String descripcion) {
		super();
		Valor = valor;
		Descripcion = descripcion;
	}
	public int getId_Valor() {
		return Id_Valor;
	}
	public void setId_Valor(int id_Valor) {
		Id_Valor = id_Valor;
	}
	public double getValor() {
		return Valor;
	}
	public void setValor(double valor) {
		Valor = valor;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	
	
	
}
