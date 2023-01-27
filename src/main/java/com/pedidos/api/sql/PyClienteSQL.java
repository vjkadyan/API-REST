package com.pedidos.api.sql;

public enum PyClienteSQL  {
	INSERT, UPDATE, UPDATE_DATOS, CONSULTA, OBTENER_CLIENTE_NUM, OBTENER_POR_CORREO, ELIMINA_PY_CLIENTE,
	OBTENER_CLIENTES_INTERNET, ELIMINAR_CLIENTE_INTERNET, CONFIRMAR_CLIENTE_INTERNET, 
	EXISTE_CLIENTE_CORREO,UPDATE_DATOSFACT,
	OBTENER_CLIENTE_NUM_PEDIDOS, OBTIENECORREO,OBTIENE_CONSECUTIVO_HP,CONSULTA_R;

	public String toString() {
		switch (this) {
			case INSERT:
				return " insert into py_cliente (cliente_num,cust_num,nombre,address1,address2, colonia,city,province,country,postal_code,phone,fax,contact,puesto,email,  modo_porcentaje,porcentaje,estatus,instruc_cobro,rem_fact,cliente_rfc,zona, directo,laboratorio,margen_lab,apartado,clave_horario,p_sup_alta,cant_usu_alta, costo_envio,envios_gratis,monto_envio,control_envios,tipo_entrega,credito,  ult_visita,cuenta_soho,maneja_cc,clasificacion,clase,tipo,remision,validado_credito)  Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
			case UPDATE:
				return " UPDATE py_cliente SET nombre = ?, address1 =?, address2=?, colonia=?, city=?, province=?,postal_code=?,phone=?,email=? WHERE cliente_num = ? AND cust_num = ?";
			case UPDATE_DATOS:
				return " UPDATE py_cliente SET phone=? WHERE cliente_num = ? ";
			case UPDATE_DATOSFACT:
				return " UPDATE py_cliente SET  cliente_rfc =? ,address1 =?, colonia=?, city=?, province=?,postal_code=?,phone=?,email=?";			
			case CONSULTA:
				return " Select cliente_num,cust_num,nombre,address1,address2,colonia,city,province,country,postal_code,phone,fax,contact,puesto,email,modo_porcentaje,porcentaje,estatus,instruc_cobro,rem_fact,cliente_rfc,zona,directo,laboratorio,margen_lab,apartado,clave_horario,p_sup_alta,cant_usu_alta,costo_envio,envios_gratis,monto_envio,control_envios,tipo_entrega,credito,ult_visita,cuenta_soho,maneja_cc,clasificacion,clase,tipo,remision,validado_credito From py_cliente ";
			case OBTENER_CLIENTE_NUM:
				return " EXEC sp_conse_clien('d31000') ";
			case OBTENER_POR_CORREO:
				return " select usuario from py_usuario Where cust_num = ? and usuario = ? ";
			case ELIMINA_PY_CLIENTE:
				return " UPDATE py_cliente SET estatus = 'I' WHERE cust_num = ? AND cliente_num = ? ";
			case OBTENER_CLIENTES_INTERNET:
				return " select cliente_num,cust_num,nombre,ult_visita from py_cliente where estatus = 'T' and cust_num = ? ";
			case ELIMINAR_CLIENTE_INTERNET:
				return " DELETE FROM py_cliente WHERE cust_num = ? AND cliente_num = ? ";
			case CONFIRMAR_CLIENTE_INTERNET:
				return " UPDATE py_cliente SET estatus = 'A' WHERE cust_num = ? AND cliente_num = ? ";
			case EXISTE_CLIENTE_CORREO:
				return "SELECT 'EXISTE' EXISTE FROM PY_CLIENTE  WHERE CUST_NUM=? AND EMAIL =?;";
			case OBTENER_CLIENTE_NUM_PEDIDOS:
				return "EXEC sp_conse_clien('d100000')";
			case OBTIENECORREO:
				return "SELECT EMAIL FROM  PY_CLIENTE WHERE CLIENTE_NUM= ? AND CUST_NUM = ? AND ESTATUS ='A';";
			case OBTIENE_CONSECUTIVO_HP:
				return " EXEC sp_conse_clien('ID_MAIL_HP')  ";
			case CONSULTA_R:
				return " select * from py_cliente";
				
		}
		return "";
	}

}