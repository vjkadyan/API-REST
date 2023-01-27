package com.pedidos.api.sql;


public enum PyPedidoEncSQL {
	INSERT,
	DELETE,
	UPDATE,
	CONSULTA,
	CANCELACOTIZACION,
	ACTUALIZADIRNUM,
	CONSULTA_RESERVADOS_PAGOS,
	CONSULTA_CLIENTE_BLITZ,
	CONSULTA_FACTURACION,
	CONSULTA_FACTURACION_X_PEDIDO,
	CONSULTASHIPVIALOCALFORANEO,
	CONSULTA_PROXIMA_CANCELACION,
	CAMBIASHIPVIAEXPRESS,
	CAMBIAFECHAREGRESIVA,
	CONSULTA_TRAE_PEDIDO,
	CONSULTA_PEDIDO_NUM_CON_ORDEN_COMPRA,
	CONSULTA_ORDEN_COMPRA_CON_PEDIDO_NUM,
	CONSULTA_NUMERO_DE_CLIENTE,
	CONSULTA_PEDIDOS_CLIENTE,
	CONSULTA_CUANTOS_PEDIDOS_CLIENTE,
	CONSULTA_OC,
	CONSULTA_PEDIDO_DC_BODEGA,
	OBTIENE_NUM_CLIENTE,
	CONSULTA_PEDIDO_FAVORITO,
	CONSULTA_PEDIDO_ORDER_DC,
	CONSULTA_PEDIDOS_FACTURADOS_CLIENTE,
	CONSULTA_FRECUENCIA_COMPRAS_CLIENTE_ITEM,
	CONSULTA_ORDER_DC,
	ACTUALIZA_SHIPNUM_ORDERH,
	ACTUALIZA_SHIPNUM_SAORD,
	ACTUALIZA_SHIPNUM_ORDERH_PAGOS,
	ACTUALIZA_SHIPNUM_SAORD_PAGOS,
	ACTUALIZA_CB_SURTIDO_RUTA_PAGOS,
	ACTUALIZA_PEDIDO_ENC,
	GET_IDPAGO;
	
	public String toString(){
		
		switch (this) {
			case INSERT:
			return " Insert into py_pedido_enc(org_code, div_code, pedido_num, cust_num, cliente_num, dir_num, fecha, id_superpedido, usuario, centro_costo, orden_compra, observaciones, estatus, est_envio, importe, iva, tipo_entrega, evento, origen, rem_fact, ship_via, ship_num) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		
			case DELETE:
				return " Delete from py_pedido_enc where pedido_num = ?  ";
			
			case UPDATE:
				return " Update py_pedido_enc Set org_code = ?, div_code = ?, cust_num = ?, cliente_num = ?, dir_num = ?, fecha = ?, id_superpedido = ?, usuario = ?, centro_costo = ?, orden_compra = ?, observaciones = ?, estatus = ?, est_envio = ?, importe = ?, iva = ?, tipo_entrega = ?, evento = ?, origen = ?, rem_fact = ?, ship_via = ?, ship_num = ? Where pedido_num = ?  ";

			case CONSULTA:
				return " Select org_code,div_code,pedido_num,cust_num,cliente_num,dir_num,fecha,id_superpedido, usuario,centro_costo,orden_compra,observaciones,estatus,est_envio,importe,iva, tipo_entrega,evento,origen,rem_fact,ship_via,ship_num from py_pedido_enc ";
				
			case CONSULTA_OC:
				return " select e.org_code,e.div_code,e.pedido_num,e.cust_num,e.cliente_num,e.dir_num,e.fecha,e.id_superpedido, e.usuario,e.centro_costo,e.orden_compra,e.observaciones,e.estatus,e.est_envio,e.importe,e.iva, e.tipo_entrega,e.evento,e.origen,e.rem_fact,e.ship_via,e.ship_num  from py_pedido_enc e right join py_pedido_det d on e.pedido_num = d.pedido_num and d.item_num <> 'ZZZCUPON' and e.orden_compra <> '' ";
				
			case CANCELACOTIZACION:
				return " Update py_pedido_enc Set estatus = 'C' Where pedido_num = ? ";
				
			case ACTUALIZADIRNUM:
				return " Update py_pedido_enc set dir_num = ?, ship_num = ?, ship_via = ?, observaciones = ? Where pedido_num = ? ";
				
			case CONSULTA_RESERVADOS_PAGOS:
				return " SELECT pe.pedido_num,pe.cliente_num,pe.importe,pe.iva,pe.fecha,pe.usuario,pc.nombre,h.order_num,h.net_amount,h.tax1_amt,h.ship_via,h.term_code, h.ruta, h.hora_ruta, h.order_status, h.hora_credito,pe.dir_num, l.desc[1,1] as bodega, inv_series(h.invoice_num) as factura,h.ship_via from py_pedido_enc pe INNER JOIN py_cliente pc ON pe.cliente_num = pc.cliente_num and pe.cust_num = pc.cust_num INNER JOIN order_h h ON pe.id_superpedido = h.id_superpedido and pe.cust_num = h.cust_num INNER JOIN loca_whse lh ON h.whse_code = lh.whse_code INNER JOIN location l ON l.loca_code = lh.loca_code ";
			
			case CONSULTA_CLIENTE_BLITZ:
				return " SELECT e.pedido_num,e.cliente_num,e.importe,c.nombre,e.dir_num FROM py_pedido_enc e,py_cliente c WHERE id_superpedido=? and c.cliente_num=e.cliente_num ";
			
			case CONSULTA_FACTURACION:
				return "SELECT pe.cliente_num,pc.nombre,pe.pedido_num,h.order_num,pe.fecha,h2.inv_gen_time,h.net_amount,h.tax1_amt,pe.importe,pe.iva,h.ship_via,showInvPag(h.org_code, h.div_code, h.invoice_num) AS ligaFactura,h.invoice_num,h.order_num,h.whse_code,l.loca_code,l.DESC,(SELECT count(*) FROM sa_ord_l WHERE org_code = h.org_code AND div_code = h.div_code AND order_num = h.order_num) AS numArt,nvl((select z.order_ship from zzzenvio z,sa_ord_h sh3 Where sh3.order_num=z.order_ship and sh3.div_code=h.div_code and sh3.org_code=h.org_code and h.order_num = z.order_num and z.cust_num = pe.cust_num),0) as order_ship,nvl((select nombre from py_dir_envio where cliente_num = pe.cliente_num and dir_num = pe.dir_num),'') as nombre,nvl((select address1 from py_dir_envio where cliente_num = pe.cliente_num and dir_num = pe.dir_num),'') as address1,nvl((select address2 from py_dir_envio where cliente_num = pe.cliente_num and dir_num = pe.dir_num),'') as address2,nvl((select colonia from py_dir_envio where cliente_num = pe.cliente_num and dir_num = pe.dir_num),'') as colonia,nvl((select city from py_dir_envio where cliente_num = pe.cliente_num and dir_num = pe.dir_num),'') as city,nvl((select province from py_dir_envio where cliente_num = pe.cliente_num and dir_num = pe.dir_num),'') as province,nvl((select country from py_dir_envio where cliente_num = pe.cliente_num and dir_num = pe.dir_num),'') as country,nvl((select postal_code from py_dir_envio where cliente_num = pe.cliente_num and dir_num = pe.dir_num),'') as postal_code, nvl(h.s_name,'') as s_name, inv_series(h.invoice_num) as factura, l.desc[1,1] as bodega FROM py_pedido_enc pe INNER JOIN py_cliente pc ON pe.cliente_num = pc.cliente_num AND pe.cust_num = pc.cust_num INNER JOIN sa_ord_h h ON pe.cust_num = h.cust_num AND pe.org_code = h.org_code AND pe.div_code = h.div_code AND pe.id_superpedido = h.id_superpedido INNER JOIN sa_ord_h_2 h2 ON h.org_code = h2.org_code AND h.div_code = h2.div_code AND h.invoice_num = h2.invoice_num INNER JOIN loca_whse lo ON h.whse_code = lo.whse_code INNER JOIN location l ON lo.loca_code = l.loca_code WHERE h.cust_num = ? AND DATE (pe.fecha) >= ? AND DATE (pe.fecha) <= ? AND h.id_superpedido > 0 AND pe.org_code = 'DC' AND pe.div_code = 'DCM'";
				//return "Select pe.cliente_num,pc.nombre,pe.pedido_num,h.order_num,pe.fecha,h2.inv_gen_time,h.net_amount,h.tax1_amt,pe.importe,pe.iva,h.ship_via,showInvPag(h.org_code,h.div_code,h.invoice_num) as ligaFactura,h.invoice_num,h.order_num  from py_pedido_enc pe INNER JOIN py_cliente pc ON pe.cliente_num = pc.cliente_num and pe.cust_num = pc.cust_num  INNER JOIN sa_ord_h h ON pe.cust_num = h.cust_num and pe.org_code=h.org_code and pe.div_code=h.div_code and pe.id_superpedido= h.id_superpedido INNER JOIN sa_ord_h_2 h2 ON h.org_code=h2.org_code and h.div_code = h2.div_code and h.invoice_num = h2.invoice_num where h.cust_num = ? and date(pe.fecha) >=? and date(pe.fecha) <=? and h.id_superpedido > 0 and pe.org_code= 'DC' and pe.div_code='DCM'";
			case CONSULTA_FACTURACION_X_PEDIDO:
				return "Select pe.cliente_num,pc.nombre,pe.pedido_num,h.order_num,pe.fecha,h2.inv_gen_time,h.net_amount,h.tax1_amt,pe.importe,pe.iva,h.ship_via,showInvPag(h.org_code,h.div_code,h.invoice_num) as ligaFactura  from py_pedido_enc pe INNER JOIN py_cliente pc ON pe.cliente_num = pc.cliente_num and pe.cust_num = pc.cust_num  INNER JOIN sa_ord_h h ON pe.cust_num = h.cust_num and pe.org_code=h.org_code and pe.div_code=h.div_code and pe.id_superpedido= h.id_superpedido INNER JOIN sa_ord_h_2 h2 ON h.org_code=h2.org_code and h.div_code = h2.div_code and h.invoice_num = h2.invoice_num where pe.pedido_num = ?  and h.id_superpedido > 0 and pe.org_code= 'DC' and pe.div_code='DCM' and h.order_status = 'INVOICED'";
			
			case CONSULTASHIPVIALOCALFORANEO:
				return "SELECT ship_name FROM zship_via WHERE ship_code=?";
				
			case CONSULTA_PROXIMA_CANCELACION:
				return "Select pe.pedido_num,pe.cliente_num,pe.importe,pe.iva,pe.fecha,pe.usuario,pc.nombre,h.order_num,h.net_amount,h.tax1_amt,h.ship_via,h.term_code, h.ruta, h.hora_ruta, h.order_status, h.hora_credito,h.cancel_date from py_pedido_enc pe INNER JOIN py_cliente pc ON pe.cliente_num = pc.cliente_num and pe.cust_num = pc.cust_num INNER JOIN order_h h ON pe.id_superpedido = h.id_superpedido and pe.cust_num = h.cust_num";
			case CAMBIASHIPVIAEXPRESS:
				return "UPDATE PY_PEDIDO_ENC SET SHIP_VIA = ? WHERE PEDIDO_NUM = ?;";
			case CONSULTA_TRAE_PEDIDO:
				return "select pedido_num from py_pedido_enc pe inner join order_h h on h.id_superpedido=pe.id_superpedido and h.cust_num=pe.cust_num inner join zzzenvio ze on pe.cust_num=ze.cust_num and h.order_num=ze.order_num where ze.order_ship= ? and pe.estatus = 'R';";
			case CAMBIAFECHAREGRESIVA:
				return "UPDATE PY_PEDIDO_ENC SET fecha_regresiva = ? WHERE PEDIDO_NUM = ?;";
			case CONSULTA_PEDIDO_NUM_CON_ORDEN_COMPRA:
				return "select e.pedido_num from py_pedido_enc e inner join py_pedido_det d on e.pedido_num = d.pedido_num and d.item_num <> 'ZZZCUPON' and e.orden_compra <> '' and e.orden_compra = ? group by e.pedido_num;";
			case CONSULTA_ORDEN_COMPRA_CON_PEDIDO_NUM:
				return "SELECT orden_compra FROM py_pedido_enc WHERE pedido_num = ? ";
			case CONSULTA_NUMERO_DE_CLIENTE:
				return "SELECT cliente_num from py_pedido_enc WHERE pedido_num = ";
			case CONSULTA_PEDIDOS_CLIENTE:
				return " select TOP 15 * from py_pedido_enc ";
			case CONSULTA_CUANTOS_PEDIDOS_CLIENTE:
				return " select TOP ? * from py_pedido_enc ";
			case CONSULTA_PEDIDO_DC_BODEGA:
				return " SELECT whse_code,order_num FROM order_h h WHERE h.id_superpedido = ( SELECT id_superpedido from py_pedido_enc WHERE pedido_num = ? ) and h.order_status <> 'CANCELLED' ";
			case CONSULTA_PEDIDO_FAVORITO:
				return "SELECT * FROM py_pedido_enc WHERE pedido_num = ?";
				//**************************************/
			case OBTIENE_NUM_CLIENTE:
				return "select cliente_num,observacion from py_usuario where cliente_num = (select cliente_num from py_pedido_enc where pedido_num = ? and item_num = 'ZZZMEMBRESIA')";
			case CONSULTA_PEDIDO_ORDER_DC:
				return "select * from py_pedido_enc where id_superpedido = ( select id_superpedido from sa_ord_h where order_num = ? ) or id_superpedido = ( select id_superpedido from order_h where order_num = ? ) ";
			case CONSULTA_PEDIDOS_FACTURADOS_CLIENTE:
				return "select count(*) from py_pedido_enc";
			case CONSULTA_FRECUENCIA_COMPRAS_CLIENTE_ITEM:
				return "select sum(det.cantidad),det.pedido_num pedido_num,enc.fecha fecha from py_pedido_det det,py_pedido_enc enc where enc.cliente_num = ? and enc.pedido_num = det.pedido_num and det.item_num = ? and enc.estatus = 'F' group by pedido_num, fecha order by pedido_num asc; ";
			case CONSULTA_ORDER_DC:
				return " select order_num from order_h where id_superpedido =(select id_superpedido from py_pedido_enc where pedido_num = ? and cust_num = 38000) and id_superpedido > 0 union select order_num from sa_ord_h where id_superpedido = (select id_superpedido from py_pedido_enc where pedido_num = ? and cust_num = 38000) and id_superpedido > 0 ; ";
			case ACTUALIZA_SHIPNUM_ORDERH:
				return "update order_h set ship_num = ?, ship_via = ? where order_num in (?);";
			case ACTUALIZA_SHIPNUM_SAORD:
				return "update sa_ord_h set ship_num = ?, ship_via = ? where order_num in (?);";
			case ACTUALIZA_SHIPNUM_ORDERH_PAGOS:
				return "update order_h set ship_via = ?, ppd_coll = '' where order_num in (?);";
			case ACTUALIZA_SHIPNUM_SAORD_PAGOS:
				return "update sa_ord_h set ship_via = ?, ppd_coll = '' where order_num in (?);";
			case ACTUALIZA_CB_SURTIDO_RUTA_PAGOS:
				return "update cb_surtido_ruta set ship_via = ? where pedido in (?);";
			case ACTUALIZA_PEDIDO_ENC:
				return "update py_pedido_enc set ship_via = ? where pedido_num = ?;";
			case GET_IDPAGO:
				return "select mpago from py_metodopag_pedido where pedido_num = ? ;";
		}
		return "Error";
	}
}
