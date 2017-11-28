package ar.com.ServiceLayer;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javassist.expr.Instanceof;
import javassist.tools.reflect.Reflection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import ar.com.Request.data.Request;
//import ar.com.model.domain.Materias;
//import ar.com.model.domain.Pedido;
//import ar.com.model.domain.Valores;
//import ar.com.model.domain.DetallePedido;
import ar.com.model.domain.Persona;
//import ar.com.model.domain.Usuario;
//import ar.com.model.domain.Profesor;
import ar.com.repository.Repository;

public class ServiceLayerBO implements ServiceBussines, Serializable {

//	@Override
//	public int getCantidadDeVentas(Profesor vd) throws Exception {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public Profesor setCantidadDeVentas(Profesor vd) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Profesor setComisionPorProductoVendido(Profesor vd) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void setComisionPorCantidadVentas(Profesor vd) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public List<Pedido> getLsvt() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void setLsvt(List<Pedido> lsvt) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public List<Object> VentasPorVendedor(List<Object> ventas, String user, String type) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public void setLstcm(List<Valores> vnd) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void setCantidadCampania(Profesor vendedor) throws ParseException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void setComisionPrimerVendedor(List<Profesor> vnd) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void Ordenar(List<Profesor> vnd) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public List<Object> Proxy(Usuario user, List<Object> obj, String t) {
//		// TODO Auto-generated method stub
//		return null;
//	}

		
}