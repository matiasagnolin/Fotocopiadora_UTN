package ar.com.ServiceLayer;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.List;
//
//import ar.com.model.domain.Valores;
//import ar.com.model.domain.Usuario;
//import ar.com.model.domain.Pedido;
//import ar.com.model.domain.Profesor;

public interface ServiceBussines {
//	public int getCantidadDeVentas(Profesor vd) throws Exception;
//
//	public Profesor setCantidadDeVentas(Profesor vd) throws Exception;
//
//	public Profesor setComisionPorProductoVendido(Profesor vd);
//
//	public void setComisionPorCantidadVentas(Profesor vd);
//
//	public List<Pedido> getLsvt();
//
//	public void setLsvt(List<Pedido> lsvt);

	public List<Object>  VentasPorVendedor(List<Object> ventas,String user,String type);
//
//	public void setLstcm(List<Valores> vnd);
//
//	public void setCantidadCampania(Profesor vendedor) throws ParseException;
//
//	public void setComisionPrimerVendedor(List<Profesor> vnd);
//
//	public void Ordenar(List<Profesor> vnd);
//	
//	public List<Object> Proxy(Usuario user, List<Object> obj, String t);
}
