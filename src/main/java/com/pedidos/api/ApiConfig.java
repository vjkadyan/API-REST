package com.pedidos.api;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.pedidos.api.dao.PyPedidoEncDao;

@Configuration
@ComponentScan({"com.pedidos.api.controller","com.pedidos.api.model", "com.pedidos.api.dao", "com.pedidos.api.comun"})
public class ApiConfig {
	
//	@Bean 
//	public PyPedidoEncDao fecha() {
//		
//	}
	
}
