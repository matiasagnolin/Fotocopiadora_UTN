package ar.com.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.DataModels.DetallePedidoDM;
import ar.com.DataModels.UpdateCant;
import ar.com.Request.data.Request;
import ar.com.ServiceLayer.ServiceCRUD;
import ar.com.model.domain.DetallePedido;
import ar.com.model.domain.Pedido;
import ar.com.model.domain.Usuario;

@Controller
@Scope("session")
public class FinalizarPedido {
	@Autowired
	private ServiceCRUD dataService;
	@Autowired
	private Pedido pedido ;
	@Autowired
	private Request req ;
	@Autowired
	private Usuario user;
	
	private  String rootPath;
	@RequestMapping(value="/FinalizarPedido")
	public ModelAndView Index(@ModelAttribute("UpdateCant")UpdateCant UpdateCant , HttpServletRequest request){
		try{
		this.pedido = (Pedido)request.getSession().getAttribute("pedido");
		for(int i =0 ; i<UpdateCant.getCantidad().size();i++)
			pedido.getDetalleventa().get(i).setCantidad(Integer.parseInt(UpdateCant.getCantidad().get(i)));
		pedido.setFecha_Entrega(UpdateCant.getDeliveryDate());
		request.getSession().setAttribute("pedido", pedido);
		return   new ModelAndView("FinalizarPedido");}
		catch(Exception e ){
		return   new ModelAndView("redirect:/CarritoController");}
	}
	
	@RequestMapping(value="/PagarCompra")
	public ModelAndView pagar(HttpServletRequest request){
		this.pedido = (Pedido)request.getSession().getAttribute("pedido");
		double total=0;
		
		pedido.setPagado(true);
		pedido.setFecha_Pedido(getdate());
		pedido.setAlumno((Usuario)request.getSession().getAttribute("usuario"));
		pedido.setTotal(calcularTotal(total));
		setPedido(request);
		guardarPedido();
		request.getSession().setAttribute("pedido", pedido);
		return   new ModelAndView("redirect:/CrearCupon");
	}
	@RequestMapping(value="/NoPagar")
	public ModelAndView nopagar(HttpServletRequest request){
		this.pedido = (Pedido)request.getSession().getAttribute("pedido");
		double total=0;
		
		pedido.setPagado(false);
		pedido.setFecha_Pedido(getdate());
		pedido.setAlumno((Usuario)request.getSession().getAttribute("usuario"));
		pedido.setTotal(calcularTotal(total));
		setPedido(request);
		guardarPedido();
		request.getSession().setAttribute("pedido", pedido);
		return   new ModelAndView("redirect:/CrearCupon");
	}
	public void guardarPedido(){
		req.setObject(this.pedido);
		pedido.setId_Pedido(dataService.Save(req));
		
	}
	private String getdate(){
		 Date d1 = new Date();
		 SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY");
		 String formattedDate = df.format(d1);
		 return formattedDate;
	}
	private double calcularTotal(double total){
		for(DetallePedido p : this.pedido.getDetalleventa())
			total+=p.getTotalParcial()*p.getCantidad();
			
			return total;
	}
	private void setPedido(HttpServletRequest request){
		for(DetallePedido p : this.pedido.getDetalleventa())
			p.setPedido(this.pedido);
		for(int i  = 0; i<this.pedido.getDetalleventa().size(); i ++)
		{
			this.pedido.getDetalleventa().get(i).setPedido((Pedido)request.getSession().getAttribute("pedido"));
		}
			
	}
	
		}
