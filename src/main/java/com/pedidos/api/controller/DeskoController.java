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
@RequestMapping("/desko/")
public class DeskoController {

	
	Servicios ser = new Servicios();

	@RequestMapping(value="obtieneDetalleDesko", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneDetalleDesko(@RequestParam(required = true) long cliente_num, @RequestParam(required = true) String item_num) {
		
		String resultado =  ser.POS("","POST", "/desko/obtieneDetalleDesko?cliente_num="+cliente_num+"&item_num="+item_num);
		System.out.println("/desko/obtieneDetalleDesko?cliente_num="+cliente_num+"&item_num="+item_num);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneDescripcionDesko", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneDescripcionDesko(@RequestParam(required = true) String item_num) {
		
		String resultado =  ser.POS("","POST", "/desko/obtieneDescripcionDesko?item_num="+item_num);
		System.out.println("/desko/obtieneDescripcionDesko?item_num="+item_num);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtienePrecioDesko", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtienePrecioDesko(@RequestParam(required = true) long cliente_num, @RequestParam(required = true) String item_num) {
		
		String resultado =  ser.POS("","POST", "/desko/obtienePrecioDesko?cliente_num="+cliente_num+"&item_num="+item_num);
		System.out.println("/desko/obtienePrecioDesko?cliente_num="+cliente_num+"&item_num="+item_num);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}

	@RequestMapping(value="obtieneImagenDesko", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneImagenDesko() {
		
		String resultado =  ser.POS("","POST", "");
		System.out.println("");
		System.out.println("Resultado: "+resultado);
		return resultado;
	}

	@RequestMapping(value="obtienePrecioTotalDesko", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object obtienePrecioTotalDesko(@RequestBody String deskoPedidos) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject deskoPedidosString = new JSONObject (deskoPedidos.toString());
		System.out.println("deskoPedidosString: "+deskoPedidosString);
		return ser.POS(deskoPedidosString.toString(),"POST", "/desko/obtienePrecioTotalDesko");
	}
	
	@RequestMapping(value="armaEspacio", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String armaEspacio(@RequestParam(required = true) String nombre, @RequestParam(required = true) String email, @RequestParam(required = true) String telefono, @RequestParam(required = true) String message, @RequestParam(required = true) String news, @RequestParam(required = true) String cliente_num) {
		
		String resultado =  ser.POS("","POST", "/desko/armaEspacio?nombre="+nombre+"&email="+email+"&telefono="+telefono+"&message="+message+"&news="+news+"&cliente_num="+cliente_num);
		System.out.println("/desko/armaEspacio?nombre="+nombre+"&email="+email+"&telefono="+telefono+"&message="+message+"&news="+news+"&cliente_num="+cliente_num);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneDetDesko", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneDetDesko(@RequestParam(required = true) String cliente_num, @RequestParam(required = true) long item_num) {
		
		String resultado =  ser.POS("","POST", "/desko/obtieneDetDesko?cliente_num="+cliente_num+"&item_num="+item_num);
		System.out.println("/desko/obtieneDetDesko?cliente_num="+cliente_num+"&item_num="+item_num);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneDeskoConfig", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneDeskoConfig(@RequestParam(required = true) int caso) {
		
		String resultado =  ser.POS("","POST", "/desko/obtieneDeskoConfig?caso="+caso);
		System.out.println("/desko/obtieneDeskoConfig?caso="+caso);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
}
