package ar.com.model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Pedido implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id_Pedido;
	
	@ManyToOne
	@JoinColumn(name="Id_Usuario")
	private Usuario Alumno;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy = "Pedido",fetch = FetchType.EAGER)
	private List<DetallePedido> detalleventa;
	
	@OneToOne
	@JoinColumn(name="IdComprobante")
	private Comprobantes comprobante;
	
	
	private String Fecha_Pedido;
	private boolean Pagado;
	
	private String Fecha_Entrega;
	private boolean Entregado;
	private boolean Impreso;
	private double Total;

	
	
	public Pedido(Usuario alumno, 
			//List<DetallePedido> detalleventa,
			String fecha_Pedido, String fecha_Entrega,
			double total) {
		super();
		Alumno = alumno;
		//this.detalleventa = detalleventa;
		Fecha_Pedido = fecha_Pedido;
		Fecha_Entrega = fecha_Entrega;
		Total = total;
	}

	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getID_Venta() {
		return Id_Pedido;
	}

	public void setID_Venta(int iD_Venta) {
		Id_Pedido = iD_Venta;
	}

	public Usuario getAlumno() {
		return Alumno;
	}

	public void setAlumno(Usuario alumno) {
		Alumno = alumno;
	}

	public List<DetallePedido> getDetalleventa() {
		return detalleventa;
	}

	public void setDetalleventa(List<DetallePedido> detalleventa) {
		this.detalleventa = detalleventa;
	}

	public String getFecha_Pedido() {
		return Fecha_Pedido;
	}

	public void setFecha_Pedido(String fecha_Pedido) {
		Fecha_Pedido = fecha_Pedido;
	}

	public String getFecha_Entrega() {
		return Fecha_Entrega;
	}

	public void setFecha_Entrega(String fecha_Entrega) {
		Fecha_Entrega = fecha_Entrega;
	}

	public double getTotal() {
		return Total;
	}

	public void setTotal(double total) {
		Total = total;
	}

	public int getId_Pedido() {
		return Id_Pedido;
	}

	public void setId_Pedido(int id_Pedido) {
		Id_Pedido = id_Pedido;
	}

	public boolean isPagado() {
		return Pagado;
	}

	public void setPagado(boolean pagado) {
		Pagado = pagado;
	}

	public boolean isEntregado() {
		return Entregado;
	}

	public void setEntregado(boolean entregado) {
		Entregado = entregado;
	}

	public boolean isImpreso() {
		return Impreso;
	}

	public void setImpreso(boolean impreso) {
		Impreso = impreso;
	}

	public Comprobantes getComprobante() {
		return comprobante;
	}

	public void setComprobante(Comprobantes comprobante) {
		this.comprobante = comprobante;
	}
	
	


}
