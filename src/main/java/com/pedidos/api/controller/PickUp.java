package com.pedidos.api.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.google.zxing.WriterException;
import com.pedidos.api.Servicios;
import com.pedidos.api.dao.PickUpDao;

@CrossOrigin("*")
@RestController
@RequestMapping("/pickUp/")
public class PickUp {
	@Autowired
	private PickUpDao PickUp;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String server() {		
		return "OK";
	}
	
	@RequestMapping(value="/getQr", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String getQr(String factura) throws WriterException{
		String clave =PickUp.PalabraClave(factura);
		System.out.println("Qr "+clave);
		return clave;
	}
	
	@RequestMapping(value="/getEnvioCorreo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String getEnvioCorreo(long pedido_num) throws Exception{
		return PickUp.getEnvioCorreo(pedido_num).toString();
	}
	
	@RequestMapping(value="/getLogin", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String getLogin(@RequestParam(defaultValue="") String usuario,@RequestParam(defaultValue="") String password) {
		return PickUp.Login(usuario, password).toString();
	}	
	
	@RequestMapping(value="/getNumPedidosPickUP", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String getNumPedidosPickUP() {
		return PickUp.getNumPedidosPickUP().toString();
	}
	
	@RequestMapping(value="/getPedidosPickUP", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String getPedidosPickUP() {
		return PickUp.PedidosPickUP().toString();
	}
	
	@RequestMapping(value="/getDetallePedidosPickUP", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String getDetallePedidosPickUP2(long pedido_num) {
		System.out.println("Entro Detalle Pedido");
		return PickUp.getDetallePedidosPickUP(pedido_num).toString();
	}
	
	@RequestMapping(value="/getEscaneaCodigo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String getEscaneaCodigo(long pedido_num, String codigo) throws Exception{
		return (PickUp.validaCodigo(pedido_num, codigo))?(PickUp.getEscaneaCodigo(pedido_num))?"OK":"No se actualizo el estatus":"El codigo no concide con el pedido "+pedido_num;
	}
	
	@RequestMapping(value="/getEscaneaCajas", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String getEscaneaCajas(long pedido_num, String escaneo) throws Exception{
		return PickUp.getEscaneaCajas(pedido_num, escaneo).toString();
	}
	
	@RequestMapping(value="/getLibera", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean getLibera(@RequestBody String data) throws Exception{
		return PickUp.getLibera(data);
	}
	
	@RequestMapping(value="/getInventario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String getInventario(String fecha) throws Exception{
		System.out.println("Entro Inventario");
		return PickUp.getInventario(fecha).toString();
	}
	
	@RequestMapping(value="/EscaneoInventario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String EscaneoInventario(String codigoCaja, long num_empleado) throws Exception{
		System.out.println("Entro Inventario escanoe -"+codigoCaja+"-");
		return PickUp.EscaneoInventario(codigoCaja,num_empleado).toString();
	}
	
	@RequestMapping(value="/getActividades", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String getActividades() throws Exception{
		return PickUp.getActividades().toString();
	}
	
	@RequestMapping(value="/getSubirEvidencia", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean getSubirEvidencia(@RequestBody String data) throws Exception{
		return PickUp.getSubirEvidencia(data);
	}
	
	@RequestMapping(value="/getZettle", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String getZettle(long pedido_num) throws Exception{
		return PickUp.getZettle(pedido_num).toString();
	}
	
	@RequestMapping(value="/quitaPedidoTracking", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String quitaPedidoTracking(long pedido_num,String motivo) throws Exception{
		return PickUp.quitaPedidoTracking(pedido_num,motivo);
	}
	
	@RequestMapping(value="/modificaCatalogoMSI", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String modificaCatalogoMSI(String accion,String sku) throws Exception{
		System.out.println("entro a ModificaCatalogoMSI");
		return PickUp.modificaCatalogoMSI(accion,sku);
	}
	
	@RequestMapping(value="/validaMSI", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String validaMSI(@RequestBody String skus) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject sku = new JSONObject (skus.toString());
		System.out.println("entro a validaMSI");
		return PickUp.validaMSI(sku.getString("sku"));
	}
}