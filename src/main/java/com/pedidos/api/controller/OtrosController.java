package com.pedidos.api.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedidos.api.Servicios;

@CrossOrigin("*")
@RestController
public class OtrosController {
	
	Servicios ser = new Servicios();

	@RequestMapping(value="correoPedidoLevantado", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String correoPedidoLevantado(@RequestParam(required = true) long pedido_num) {
			
		String resultado =  ser.POS("","POST", "/envioCorreoSms/correoPedidoLevantado?pedido_num="+pedido_num);
		System.out.println("/envioCorreoSms/correoPedidoLevantado?pedido_num="+pedido_num);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
}
