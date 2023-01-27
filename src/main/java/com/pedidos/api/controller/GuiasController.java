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
@RequestMapping("/guias/")
public class GuiasController {
	
	Servicios ser = new Servicios();

	@RequestMapping(value="obtieneCostoDHL", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneCostoDHL(@RequestParam(required = true) int kilos, @RequestParam(required = true) int cpDestino) {
		
		String resultado =  ser.POS("","POST", "/guias/obtieneCostoDHL?kilos="+kilos+"&cpDestino="+cpDestino);
		System.out.println("/guias/obtieneCostoDHL?kilos="+kilos+"&cpDestino="+cpDestino);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneCostoFEDEX", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneCostoFEDEX(@RequestParam(required = true) int kilos, @RequestParam(required = true) int cpDestino) {
		
		String resultado =  ser.POS("","POST", "/guias/obtieneCostoFEDEX?kilos="+kilos+"&cpDestino="+cpDestino);
		System.out.println("/guias/obtieneCostoFEDEX?kilos="+kilos+"&cpDestino="+cpDestino);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneCostoESTAFETA", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneCostoESTAFETA(@RequestParam(required = true) int kilos, @RequestParam(required = true) int cpDestino) {
		
		String resultado =  ser.POS("","POST", "/guias/obtieneCostoESTAFETA?kilos="+kilos+"&cpDestino="+cpDestino);
		System.out.println("/guias/obtieneCostoESTAFETA?kilos="+kilos+"&cpDestino="+cpDestino);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneCostoAsegurado", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneCostoAsegurado(@RequestParam(required = true) String asegurado) {
		
		String resultado =  ser.POS("","POST", "/guias/obtieneCostoAsegurado?asegurado="+asegurado);
		System.out.println("/guias/obtieneCostoAsegurado?asegurado="+asegurado);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneFrecuencia", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneFrecuencia(@RequestParam(required = true) int paqueteria, @RequestParam(required = true) int cpDestino) {
		
		String resultado =  ser.POS("","POST", "/guias/obtieneFrecuencia?paqueteria="+paqueteria+"&cpDestino="+cpDestino);
		System.out.println("/guias/obtieneFrecuencia?paqueteria="+paqueteria+"&cpDestino="+cpDestino);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneFrecuenciaFedex", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneFrecuenciaFedex(@RequestParam(required = true) int cpDestino) {
		
		String resultado =  ser.POS("","POST", "/guias/obtieneFrecuenciaFedex?cpDestino="+cpDestino);
		System.out.println("/guias/obtieneFrecuenciaFedex?cpDestino="+cpDestino);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneTotalSeguro", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneTotalSeguro(@RequestParam(required = true) double costo, @RequestParam(required = true) double asegurado) {
		
		String resultado =  ser.POS("","POST", "/guias/obtieneTotalSeguro?costo="+costo+"&asegurado="+asegurado);
		System.out.println("/guias/obtieneTotalSeguro?costo="+costo+"&asegurado="+asegurado);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="consultaEstado", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String consultaEstado(@RequestParam(required = true) String cp) {
		
		String resultado =  ser.POS("","POST", "/guias/consultaEstado?cp="+cp);
		System.out.println("/guias/consultaEstado?cp="+cp);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="consultaDelegacion", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String consultaDelegacion(@RequestParam(required = true) String cp) {
		
		String resultado =  ser.POS("","POST", "/guias/consultaDelegacion?cp="+cp);
		System.out.println("/guias/consultaDelegacion?cp="+cp);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value = "insertGuiaDirecciones", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object insertGuiaDirecciones(@RequestBody String pyGuiasDirecciones) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject pyGuiasDireccionesString = new JSONObject (pyGuiasDirecciones.toString());
		System.out.println("pyGuiasDirecciones: "+pyGuiasDireccionesString);
		return ser.POS(pyGuiasDireccionesString.toString(),"POST", "/guias/insertGuiaDirecciones");
	}
	
	@RequestMapping(value="insertGuia", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object insertGuia(@RequestBody String pyGuias) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject pyGuiasString = new JSONObject (pyGuias.toString());
		System.out.println("pyGuias: "+pyGuiasString);
		return ser.POS(pyGuiasString.toString(),"POST", "/guias/insertGuia");
	}
	
	@RequestMapping(value="consultaPermisos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String consultaPermisos(@RequestParam(required = true) long cliente_num) {
		String resultado =  ser.POS("","GET", "/guias/consultaPermisos?cliente_num="+cliente_num);
		System.out.println("/guias/consultaPermisos?cliente_num="+cliente_num);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneDireccionCarrito", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneDireccionCarrito(@RequestParam(required = true) int cliente_num, @RequestParam(required = true) String tipo, @RequestParam(required = true) int idGuia) {
			
		String resultado =  ser.POS("","POST", "/guias/obtieneDireccionCarrito?idGuia="+idGuia+"&cliente_num="+cliente_num+"&tipo="+tipo);
		System.out.println("/guias/obtieneDireccionCarrito?idGuia="+idGuia+"&cliente_num="+cliente_num+"&tipo="+tipo);
		return resultado;
	}
	
}
