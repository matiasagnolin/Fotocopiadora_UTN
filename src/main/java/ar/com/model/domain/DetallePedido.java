package ar.com.model.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import ar.com.model.domain.Valores;

@Entity
public class DetallePedido {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id_Detalle;
//
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="Id_Pedido",nullable=false)
	private Pedido Pedido;
//	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Id_Archivo")
	private Archivo Archivo;
	
	@Column(name="TotalParcial")
	private double totalParcial;
//	
	@ManyToOne
	@JoinColumn(name="Id_Valor")
	private Valores  Valor;
	
	int Cantidad;
	
	
	public int getCantidad() {
		return Cantidad;
	}



	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}



	public DetallePedido(ar.com.model.domain.Pedido pedido, ar.com.model.domain.Archivo archivo, double totalParcial,
			Valores valor) {
		super();
		Pedido = pedido;
		Archivo = archivo;
		this.totalParcial = totalParcial;
		//Valor = valor;
	}



	public DetallePedido(){}



	public int getId_Detalle() {
		return Id_Detalle;
	}



	public void setId_Detalle(int id_Detalle) {
		Id_Detalle = id_Detalle;
	}



	public Pedido getPedido() {
		return Pedido;
	}



	public void setPedido(Pedido pedido) {
		Pedido = pedido;
	}



	public Archivo getArchivo() {
		return Archivo;
	}



	public void setArchivo(Archivo archivo) {
		Archivo = archivo;
	}



	public double getTotalParcial() {
		return totalParcial;
	}



	public void setTotalParcial(double totalParcial) {
		this.totalParcial = totalParcial;
	}



	public Valores getValor() {
		return Valor;
	}



	public void setValor(Valores valor) {
		Valor = valor;
	}
		
	
	
	
}
