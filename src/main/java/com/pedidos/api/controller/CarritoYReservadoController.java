package com.pedidos.api.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.json.JSONObject;
import org.springframework.boot.json.JsonParseException;
import org.springframework.expression.ParseException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.pedidos.api.Servicios;

@CrossOrigin("*")
@RestController
@RequestMapping("/carritoyreservado/")
public class CarritoYReservadoController {
	
	Servicios ser = new Servicios();
	
	@RequestMapping(value="obtieneNoCelulares", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneItemCompleto(@RequestParam Long cliente_num) {
		
		String resultado =  ser.POS("","GET", "/carritoyreservado/obtieneNoCelulares?cliente_num="+cliente_num);
		System.out.println("/carritoyreservado/obtieneNoCelulares?cliente_num="+cliente_num);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneLongLat", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneLongLat(@RequestParam String longLat) {
		
		String resultado =  ser.POS("","POST", "/carritoyreservado/obtieneLongLat?longLat="+longLat);
		System.out.println("/carritoyreservado/obtieneLongLat?longLat="+longLat);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	@RequestMapping(value="agregaCarrito", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object agregaCarrito(@RequestBody String carrito) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject carritoString = new JSONObject (carrito.toString());
		System.out.println("carritoString : "+carritoString.toString());
		String resultado = ser.POS(carritoString.toString(),"POST", "/carritoyreservado/agregaCarrito");
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="getCarrito", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getCarrito(@RequestParam Long clienteNum, @RequestParam Long usuarioNum, @RequestParam String top, @RequestParam String afiliado) {
		
		String resultado =  ser.POS("","GET", "/carritoyreservado/getCarrito?clienteNum="+clienteNum+"&usuarioNum="+usuarioNum+"&top="+top+"&afiliado="+afiliado);
		System.out.println("/carritoyreservado/getCarrito?clienteNum="+clienteNum+"&usuarioNum="+usuarioNum+"&top="+top+"&afiliado="+afiliado);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="deleteCarrito", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteCarrito(@RequestParam Long clienteNum, @RequestParam Long usuarioNum, @RequestParam String items) {
		
		String resultado =  ser.POS("","DELETE", "/carritoyreservado/deleteCarrito?clienteNum="+clienteNum+"&usuarioNum="+usuarioNum+"&items="+items);
		System.out.println("/carritoyreservado/deleteCarrito?clienteNum="+clienteNum+"&usuarioNum="+usuarioNum+"&items="+items);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="modificaSegGaran", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String modificaSegGaran(@RequestParam Long clienteNum, @RequestParam Long usuarioNum, @RequestParam String itemNum, @RequestParam int idInt, @RequestParam int seguro, @RequestParam String itemGarantia, @RequestParam int garantia, @RequestParam int opcion) {
		
		String resultado =  ser.PUT("", "/carritoyreservado/modificaSegGaran?clienteNum="+clienteNum+"&usuarioNum="+usuarioNum+"&itemNum="+itemNum+"&idInt="+idInt+"&seguro="+seguro+"&itemGarantia="+itemGarantia+"&garantia="+garantia+"&opcion="+opcion);
		System.out.println("/carritoyreservado/modificaSegGaran?cliente_num="+clienteNum+"&usuarioNum="+usuarioNum+"&itemNum="+itemNum+"&idInt="+idInt+"&seguro="+seguro+"&itemGarantia="+itemGarantia+"&garantia="+garantia+"&opcion="+opcion);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="reservaCarrito", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String reservaCarrito(@RequestParam Long clienteNum, @RequestParam Long usuarioNum, @RequestParam Long ejecutivo, @RequestParam String afiliado, @RequestParam String cupon, @RequestParam String ip, @RequestBody(required = true) String jsonCarrito) {
		String resultado =  ser.POS(jsonCarrito,"POST", "/carritoyreservado/reservaCarrito?clienteNum="+clienteNum+"&usuarioNum="+usuarioNum+"&ejecutivo="+ejecutivo+"&afiliado="+afiliado+"&cupon="+cupon+"&ip="+ip);
		System.out.println("/carritoyreservado/reservaCarrito?cliente_num="+clienteNum+"&usuarioNum="+usuarioNum+"&ejecutivo="+ejecutivo+"&afiliado="+afiliado+"&cupon="+cupon+"&ip="+ip);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneResumenPedido", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneResumenPedido(@RequestParam Long pedidoNum, @RequestParam String afiliado, @RequestParam int paso) {
		
		String resultado =  ser.POS("","GET", "/carritoyreservado/obtieneResumenPedido?pedidoNum="+pedidoNum+"&afiliado="+afiliado+"&paso="+paso);
		System.out.println("/carritoyreservado/obtieneResumenPedido?pedido="+pedidoNum+"&afiliado="+afiliado+"&paso="+paso);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="generaCotizacion", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String generaCotizacion(@RequestParam Long pedidoNum, @RequestParam int dirNum, @RequestParam Long empleadoNum, @RequestParam String ip) {
		
		String resultado =  ser.POS("","POST", "/carritoyreservado/generaCotizacion?pedidoNum="+pedidoNum+"&dirNum="+dirNum+"&empleadoNum="+empleadoNum+"&ip="+ip);
		System.out.println("/carritoyreservado/generaCotizacion?pedidoNum="+pedidoNum+"&dirNum="+dirNum+"&empleadoNum="+empleadoNum+"&ip="+ip);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="actualizaDireccion", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public String actualizaDireccion(@RequestParam Long clienteNum, @RequestParam Long pedidoNum, @RequestParam int dirNum, @RequestParam Long ejecutivo, @RequestParam String observaciones, @RequestParam int op, @RequestParam double peso, @RequestParam String afiliado) {
		observaciones = observaciones.replace(" ", "%20"); 
		String resultado =  ser.PUT("","/carritoyreservado/actualizaDireccion?clienteNum="+clienteNum+"&pedidoNum="+pedidoNum+"&dirNum="+dirNum+"&ejecutivo="+ejecutivo+"&observaciones="+observaciones+"&op="+op+"&peso="+peso+"&afiliado="+afiliado);
		System.out.println("/carritoyreservado/actualizaDireccion?clienteNum="+clienteNum+"&pedidoNum="+pedidoNum+"&dirNum="+dirNum+"&ejecutivo="+ejecutivo+"&observaciones="+observaciones+"&op="+op+"&peso="+peso+"&afiliado="+afiliado);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}

	@RequestMapping(value="actualizaRFC", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public String actualizaRFC(@RequestParam Long clienteNum, @RequestParam Long pedidoNum, @RequestParam int rfcNum, @RequestParam Long ejecutivo, @RequestParam String cfdi, @RequestParam int pago, @RequestParam String notas) {
		
		String resultado =  ser.PUT("","/carritoyreservado/actualizaRFC?clienteNum="+clienteNum+"&pedidoNum="+pedidoNum+"&rfcNum="+rfcNum+"&ejecutivo="+ejecutivo+"&cfdi="+cfdi+"&pago="+pago+"&notas="+notas);
		System.out.println("/carritoyreservado/actualizaRFC?cliente_num="+clienteNum+"&pedidoNum="+pedidoNum+"&rfcNum="+rfcNum+"&ejecutivo="+ejecutivo+"&cfdi="+cfdi+"&pago="+pago+"&notas="+notas);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneNotas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneNotas(@RequestParam(required = true) long clienteNum, @RequestParam(required = true) String rfc, @RequestParam(required = true) double total) {
		
		String resultado =  ser.POS("","GET", "/carritoyreservado/obtieneNotas?clienteNum="+clienteNum+"&rfc="+rfc+"&total="+total);
		System.out.println("/carritoyreservado/obtieneNotas?cliente="+clienteNum+"&rfc="+rfc+"&total="+total);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="actualizaPagos", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object actualizaPagos(@RequestBody String carrito) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject carritoString = new JSONObject (carrito.toString());
		System.out.println("carritoString: "+carritoString);
		return ser.PUT(carritoString.toString(), "/carritoyreservado/actualizaPagos");
	}
	
	@RequestMapping(value="agregarAlCarrito", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String agregarAlCarrito(@RequestParam Long pedidoNum) {
		
		String resultado =  ser.PUT("", "/carritoyreservado/agregarAlCarrito?pedidoNum="+pedidoNum);
		System.out.println("/carritoyreservado/agregarAlCarrito?pedidoNum="+pedidoNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="consultaMargen", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String consultaMargen(@RequestParam Long clienteNum, @RequestParam Long custNum, @RequestParam String itemNum) {
		
		String resultado =  ser.POS("","GET", "/carritoyreservado/consultaMargen?clienteNum="+clienteNum+"&custNum="+custNum+"&itemNum="+itemNum);
		System.out.println("/carritoyreservado/consultaMargen?clienteNum="+clienteNum+"&custNum="+custNum+"&itemNum="+itemNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="generacodigoOxxo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String generacodigoOxxo(@RequestParam Long pedidoNum) {
		
		String resultado =  ser.POS("","GET", "/carritoyreservado/generacodigoOxxo?pedidoNum="+pedidoNum);
		System.out.println("/carritoyreservado/generacodigoOxxo?pedidoNum="+pedidoNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}	
	
	@RequestMapping(value="validaCodigoDescuento", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String validaCodigoDescuento(@RequestParam Long clienteNum, @RequestParam Long usuarioNum, @RequestParam String cupon) {
		String resultado =  ser.POS("","GET", "/carritoyreservado/validaCodigoDescuento?clienteNum="+clienteNum+"&usuarioNum="+usuarioNum+"&cupon="+cupon);
		System.out.println("/carritoyreservado/validaCodigoDescuento?clienteNum="+clienteNum+"&usuarioNum="+usuarioNum+"&cupon="+cupon);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
}