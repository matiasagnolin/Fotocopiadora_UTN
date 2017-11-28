package ar.com.DataModels;

import java.util.Date;
import java.util.List;

public class UpdateCant {

	
	List<String> Cantidad;
	String deliveryDate;

	public List<String> getCantidad() {
		return Cantidad;
	}

	public void setCantidad(List<String> cantidad) {
		Cantidad = cantidad;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
	
}
