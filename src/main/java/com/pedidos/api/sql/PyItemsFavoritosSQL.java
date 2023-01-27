package com.pedidos.api.sql;


public enum PyItemsFavoritosSQL {
	TEST,
	AGREGA_FAVORITOS,
	CONSULTA_FAVORITOS,
	DELETE_FAVORITO,
	CONSULTA_ITEM_HOME,
	CONSULTA_ITEM_CARRITO,
	CONSULTA_ITEM_FAVORITO,
	UPDATE_ITEM_FAVORITO,
	INSERT_ITEM_FAVORITO;
	
	
	public String toString() {
		
		switch(this) {
		
		case TEST: 					return "select top 1 item_num from dbo.py_items_favoritos order by id asc";
		case AGREGA_FAVORITOS: 		return "INSERT INTO py_items_favoritos (cliente_num, item_num, notificacion, precio, fecha) VALUES(?, ?, ?, ?)";
		case CONSULTA_FAVORITOS:	return "SELECT distinct det.item_num item_num ,count(det.item_num) cuenta ,'C' ,( SELECT x.usuDistribuidor *(1 + (g.tax_rate / 100)) FROM TABLE (sp_py_precio_es_inventario(det.item_num, enc.cliente_num)) x(usuFinal, usuDistribuidor, margen)) AS precio ,(get_avail_metro_pedidos(det.item_num)) FROM py_pedido_det det INNER JOIN py_pedido_enc enc ON det.pedido_num = enc.pedido_num INNER JOIN item it ON (it.item_num = det.item_num) LEFT JOIN gst_rate g ON (it.tax_grp1 = g.tax_grp1) WHERE DATE('01/01/'||year(today))>= g.beg_date AND DATE('12/31/'||year(today))<= g.end_date AND enc.cliente_num = ? AND enc.pedido_num = det.pedido_num AND enc.estatus = 'F' AND enc.observaciones NOT IN ( SELECT nombre_market FROM clientes_marketplace WHERE estatus = 'A' ) AND det.item_num NOT LIKE 'ZZZ%' AND det.item_num NOT LIKE 'COMISION' AND (get_avail_metro_pedidos(det.item_num)) > 0 GROUP BY 1 ,3 ,4 UNION ALL SELECT distinct det.item_num item_num ,count(det.item_num) cuenta ,'C' ,( SELECT x.usuFinal * (1 + (g.tax_rate / 100)) FROM TABLE (sp_py_precio_es(det.item_num, enc.cliente_num)) x(usuFinal, usuDistribuidor, margen, colum4, colum5, colum6, colum7) ) AS precio , get_avail_metro(det.item_num) FROM py_pedido_det det INNER JOIN py_pedido_enc enc ON det.pedido_num = enc.pedido_num INNER JOIN item it ON (it.item_num = det.item_num) LEFT JOIN gst_rate g ON (it.tax_grp1 = g.tax_grp1) WHERE DATE('01/01/'||year(today))>= g.beg_date AND DATE('12/31/'||year(today))<= g.end_date AND enc.cliente_num = ? AND enc.pedido_num = det.pedido_num AND enc.estatus = 'F' AND enc.observaciones NOT IN ( SELECT nombre_market FROM clientes_marketplace WHERE estatus = 'A' ) AND det.item_num NOT LIKE 'ZZZ%' AND det.item_num NOT LIKE 'COMISION' AND enc.fecha >= DATE('01/01/'||year(today)) AND enc.fecha <= DATE('12/31/'||year(today)) AND (get_avail_metro_pedidos(det.item_num)) = 0 GROUP BY 1 ,3 ,4 UNION ALL SELECT distinct f.item_num ,3 ,'F' ,( SELECT x.usuDistribuidor * (1 + (g.tax_rate / 100)) FROM TABLE (sp_py_precio_es_inventario(f.item_num, cliente_num)) x(usuFinal, usuDistribuidor, margen) ) AS precio ,(get_avail_metro_pedidos(f.item_num)) FROM py_items_favoritos f INNER JOIN item it ON it.item_num = f.item_num LEFT JOIN gst_rate g ON (it.tax_grp1 = g.tax_grp1) WHERE DATE('01/01/'||year(today))>= g.beg_date AND DATE('12/31/'||year(today))<= g.end_date AND cliente_num = ? AND (get_avail_metro_pedidos(f.item_num)) > 0 UNION ALL SELECT distinct f.item_num ,3 ,'F' ,( SELECT x.usuFinal * (1 + (g.tax_rate / 100)) FROM TABLE (sp_py_precio_es(f.item_num, cliente_num)) x(usuFinal, usuDistribuidor, margen, colum4, colum5, colum6, colum7) ) AS precio ,get_avail_metro(f.item_num) FROM py_items_favoritos f INNER JOIN item it ON it.item_num = f.item_num LEFT JOIN gst_rate g ON (it.tax_grp1 = g.tax_grp1) WHERE DATE('01/01/'||year(today))>= g.beg_date AND DATE('12/31/'||year(today))<= g.end_date AND cliente_num = ? AND (get_avail_metro_pedidos(f.item_num)) = 0 ORDER BY 3,2 DESC;";
		case DELETE_FAVORITO: 		return "delete from py_items_favoritos where cliente_num = ? and item_num = ?;";
		case CONSULTA_ITEM_HOME: 	return "exec fn_con_items_home_pedidos(?,?,?);";
		case CONSULTA_ITEM_CARRITO:	return "exec fn_con_items_carrito_pedidos(?,?,?);";
		case CONSULTA_ITEM_FAVORITO:return "select id from py_items_favoritos where cliente_num = ? and item_num= ?";
		case UPDATE_ITEM_FAVORITO:	return "update py_items_favoritos set notificacion = ?, precio = ?, fecha = GETDATE() where cliente_num = ? and item_num = ?";
		case INSERT_ITEM_FAVORITO:	return "insert into py_items_favoritos (cliente_num, item_num, notificacion, precio, fecha) values(?,?,?,?,GETDATE())";
		default: 					return "";
		}
	}
	
	
}
