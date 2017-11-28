package ar.com.model.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tipos implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_tipo;
	private String descripcion;

	public Tipos() {

	}

	public Tipos( String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public int getTipo() {
		return id_tipo;
	}

	public void setTipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	@Override
	public boolean equals(Object obj) {
		System.out.println(descripcion);
		System.out.println(obj);
		if (descripcion.toString().trim().equals(obj.toString().trim()))
			return true;
		return false;
	}
	
	

}
