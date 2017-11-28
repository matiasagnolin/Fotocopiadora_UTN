package ar.com.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.DataModels.DetallePedidoDM;
import ar.com.Request.data.Request;
import ar.com.ServiceLayer.ServiceCRUD;
import ar.com.model.domain.Archivo;
import ar.com.model.domain.Pedido;
import ar.com.model.domain.Usuario;
import ar.com.model.domain.Valores;

@Controller
@Scope("session")
public class DetallePedido {
	@Autowired
	private ServiceCRUD dataService;
	@Autowired
	private Pedido pedido ;
	@Autowired
	private Request req ;
	@Autowired
	private Usuario user;
	
	@RequestMapping(value="/DetallePedido")
public String Index(@ModelAttribute("DetallePedido") DetallePedidoDM detalle, HttpServletRequest request){
		this.user=(Usuario)request.getSession().getAttribute("usuario");		
		this.pedido = (Pedido)request.getSession().getAttribute("pedido");
		ar.com.model.domain.DetallePedido detallepedido = new ar.com.model.domain.DetallePedido();
		

		req.setObject(new Archivo());
		req.setId(detalle.getId_Archivo());
		
		try {
			detallepedido.setArchivo((Archivo)dataService.ReadOne(req));
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			
			pedido.setFecha_Pedido(dateFormat.format(date).toString());
			detallepedido.setCantidad(1);
			Valores valor = new Valores();	
			req.setObject(valor);
			if(detalle.getIdSimpleFaz()!=0)
				req.setId(detalle.getIdSimpleFaz());
			else
				req.setId(detalle.getIdDobleFaz());
			
			detallepedido.setValor((Valores)dataService.ReadOne(req));
			detallepedido.setTotalParcial(detallepedido.getArchivo().getCantPag()*detallepedido.getValor().getValor());
			
			if(detalle.getIdAnillado()!=0){
				req.setId(detalle.getIdAnillado());
				valor = (Valores)dataService.ReadOne(req);
				detallepedido.setTotalParcial(detallepedido.getTotalParcial()+valor.getValor());
				}
			
			for(ar.com.model.domain.DetallePedido pd : pedido.getDetalleventa())
				if((pd.getArchivo().getId_Archivo()==detallepedido.getArchivo().getId_Archivo()))
							return   "redirect:/CarritoController";
							
			pedido.getDetalleventa().add(detallepedido);
			request.getSession().setAttribute("pedido", pedido);

			return   "redirect:/CarritoController";

			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		return   "redirect:/Home";
	}
	
	@RequestMapping(value="/DeleteDetalle")
	public String delete( HttpServletRequest request){
		
		String id =request.getParameter("IdArchivo");
		this.pedido = (Pedido)request.getSession().getAttribute("pedido");
		
		for(ar.com.model.domain.DetallePedido dp : pedido.getDetalleventa())
		{
			if(String.valueOf(dp.getArchivo().getId_Archivo()).equals(id)){
				pedido.getDetalleventa().remove(dp);
				return   "redirect:/CarritoController";
				}
		}
		return   "redirect:/CarritoController";
	}
	@RequestMapping(value="/Imprimir")
	public String ImprimirPedido( HttpServletRequest request){
		String id =request.getParameter("pedido");
		req.setObject(new Pedido());
		req.setId(Integer.parseInt(id));
		try {
			request.getSession().setAttribute("pedido", (Pedido)dataService.ReadOne(req));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return   "redirect:/ImpresionesController";
	}
	
}
