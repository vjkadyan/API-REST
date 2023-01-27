package com.pedidos.api.sql;

public enum CarritoTempSQL {
	INSERTA,
	CONSULTA_PARTIDAS,
	GET_CARRITO,
	GET_EJECUTIVO,
	ELIMINA,
	GET_PRECIO_GARANTIA1,
	GET_PRECIO_GARANTIA2,
	ACTUALIZA_SEGURO_GARANTIA,
	RESERVA_CARRITO,
	OBTIENE_RESUMEN,
	GET_DIRECCIONES,
	GET_FACTURAS,
	GET_REFERENCE,
	GET_COSTOS_ENVIO,
	VALIDA_EXPRESS,
	VALIDA_PEDIDO_GRATIS,
	AGREGA_A_CARRITO,
	ACTUALIZA_DIRECCION,
	CONSULTA_MARGEN,
	GET_ZONA_FEDEX,
	GET_COSTO_FEDEX,
	GET_COSTO_ADICIONAL_FEDEX,
	GET_TOTAL_PEDIDO,
	GET_COBERTURAS,
	VALIDA_CUPON;

	public String toString() {
		switch (this) {
			case INSERTA:
				return "exec fn_ins_carrito_pedidos(?,?,?,?,?,?);";
			case CONSULTA_PARTIDAS:
				return "exec fn_log_carrito_pedidos(?,?,?);";
			case GET_CARRITO:
				return "exec fn_carrito_pedidos(?,?,?);";
			case GET_EJECUTIVO:
				return "exec fn_getejecutivo(?,?);";
			case ELIMINA:
				return "exec fn_del_carrito_pedidos(?,?,?);";
			case GET_PRECIO_GARANTIA1:
				return "exec fn_get_py_precios_seg_garant('G1',?);";
			case GET_PRECIO_GARANTIA2:
				return "exec fn_get_py_precios_seg_garant('G2',?);";
			case ACTUALIZA_SEGURO_GARANTIA:
				return "exec fn_upd_sg_carrito_pedidos(?,?,?,?,?,?,?,?);";
			case RESERVA_CARRITO:
				return "exec fn_reserva_carrito_pedidos(?,?,?,?,?,?);"; 
			case OBTIENE_RESUMEN:
				return "exec fn_resumen_pedidos(?);"; 
			case GET_DIRECCIONES:
				return "SELECT nvl(de.dir_num,0) numero, nvl(trim(de.nombre),'') nombre, nvl(trim(de.address1),'') || ', ' || nvl(trim(de.colonia),'') || ', ' || nvl(trim(de.postal_code),'') || ', ' || nvl(trim(de.city),'') || ', ' || nvl(trim(de.province),'') direccion, CASE WHEN de.instr_entrega <> \"\" THEN trim(de.instr_entrega) || ' entre ' || nvl(trim(de.entre_calle1),'') || ', ' || nvl(trim(de.entre_calle2),'') ELSE 'entre ' || nvl(trim(de.entre_calle1),'') || ', ' || nvl(trim(de.entre_calle2),'') end as observaciones,(select count(*) from py_pedido_enc e where e.cliente_num = de.cliente_num and de.dir_num = e.dir_num and e.estatus = 'F') as cantidad, (select count(*) from py_pedido_enc e where e.cliente_num = de.cliente_num and de.dir_num = e.dir_num and e.estatus = 'R') as reservado FROM py_dir_envio de where de.cliente_num = ? and de.estatus = 'A' and nombre <> 'Generica' order by 5 desc;";
			case GET_FACTURAS:
				return "select 0 rfc_num, c.cliente_rfc, c.nombre, '' direccion, 'G03' as idUso, '1' mpago, 0 reservado,(select count(*) from py_rfc_pedido where cliente_num = c.cliente_num and rfc_num = 0) total from py_cliente c where c.cliente_num = ? union all select c.rfc_num, c.cliente_rfc, c.nombre, nvl(trim(c.address1),'') || ', ' || nvl(trim(c.colonia),'') || ', ' || nvl(trim(c.postal_code),'') || ', ' || nvl(trim(c.city),'') || ', ' || nvl(trim(c.province),'') direccion, nvl(c.id_uso_cfdi,'') as idUso , nvl(c.m_pago,'') mpago, (select count(*) from py_pedido_enc a inner join py_rfc_pedido b on a.pedido_num = b.pedido_num and a.cliente_num = c.cliente_num  where a.estatus = 'R' and b.rfc_num = c.rfc_num) reservado, (select count(*) from py_rfc_pedido where cliente_num = c.cliente_num and rfc_num = c.rfc_num) total from py_cliente_rfc c where c.cliente_num = ? and c.estatus = 'A' order by 8 desc;";
			case GET_REFERENCE:
				return "exec digitov(?); ";
			case GET_COSTOS_ENVIO:
				return "exec fn_obtiene_costo_envio(?,?,?);";
			case VALIDA_EXPRESS:
				return "exec fn_valida_express(?,?);"; 
			case VALIDA_PEDIDO_GRATIS:
				return "exec fn_valida_envio_gratis_pedidos(?);"; 
			case AGREGA_A_CARRITO:
				return "exec fn_agrega_al_carrito(?);";
			case ACTUALIZA_DIRECCION:
				return "exec fn_upd_direc_pedidos(?,?,?,?,?,?,?);";
			case CONSULTA_MARGEN:
				return "exec fn_con_precioPyme_pedidos(?,?,?);";
			case GET_ZONA_FEDEX:
				return "select zone from fedex_cobertura where cp = ? and type_service = 'EC';";
			case GET_COSTO_FEDEX:
				return "select (select tarifa from dist_paquete_tarifa where paquete_num = 37) * zona_# from dist_fedex_zonas where servicio = 'EC' and tipo = 'TAR' and kg = ?;";
			case GET_COSTO_ADICIONAL_FEDEX:
				return "select zona_# * ? as tarifa_adicional from dist_fedex_zonas where servicio = 'EC' and tipo = 'AD';";
			case GET_TOTAL_PEDIDO:
				return "select importe + iva from py_pedido_enc where pedido_num in (?);"; 
			case GET_COBERTURAS:
				return "select case when(select count(*) from dhl_cobertura where cp = ?) > 0 then '' else 'DHL' end from dhl_cobertura where cp = ? union select case when (select count(*) from fedex_cobertura where cp = ? and type_service = 'EC') > 0 then '' else 'FedEx' end from dis_estafeta_cobertura where codigo = ? union select case when (select count(*) from dis_estafeta_cobertura where codigo = ?) > 0 then '' else 'Estafeta' end from fedex_cobertura where cp = ? and type_service = 'EC' union select case when (select count(*) from redpack_cobertura where cp = ?) > 0 then '' else 'REDPACK' end union select case when (select count(*) from fedex_ex_cobertura where cp = ?) > 0 then '' else 'FedExE' end;";
			case VALIDA_CUPON:
				return "exec fn_valida_cupon_pedidos(38000,?,?,?);";
		}
		return null;
	}
}
