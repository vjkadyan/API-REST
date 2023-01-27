package com.pedidos.api.dao;

import java.util.List;
import java.util.Map;

public interface MailPedidosCom {

	/**
	 * 
	 * @param lista
	 * @param correos
	 * @return
	 */
//	public boolean enviaMailCotiPedidos(Map<String, Object> lista, List<String> correos);
//
//	/***
//	 * 
//	 * @param lista
//	 * @return
//	 */
//	public boolean enviaMailPagovsEntregaPedidos(Map<String, Object> lista);
//
//	public boolean enviaMailCotiPedidos2(CotizacionPedidos cotizacionPedidos, List<String> correos);
//
//	public boolean enviaMailRma(Map<String, Object> lista, String correo, String tipobody);
//	
//	public boolean enviaMailLevantaPedido(final Map<String, Object> lista, List<String> correos);
//	
	public boolean enviaMailPass(final Map<String, Object> lista, List<String> correos);
//
//	boolean enviaMailUniclick(Map<String, Object> params) throws AddressException;
}

