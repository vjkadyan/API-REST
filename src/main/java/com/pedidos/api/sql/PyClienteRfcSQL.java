package com.pedidos.api.sql;

public enum PyClienteRfcSQL {
	INSERT,
	UPDATE,
	CONSULTA,
	CONSULTA2,
	OBTENER_MAX_PY_CLIENTE_RFC,
	INACTIVAR_RFC,
	ELIMINAR_CLIENTE_RFC,
	ELIMINAR_PY_CLIENTE_RFC_INTERNET,
	PEDIDO_INTERNET_GET_RFC_NUM,
	//ACTUALIZA_REFERENCIA,
	CONSULTA_DETALLES,
	DIRECCION_PAGOSREGISTRADOS,
	UPDATE_RFC,
	UPDATE_RFC2,
	UPDATE_RFC3;
	 
	public String toString(){
		switch (this) {
		case INSERT:
			return " Insert into py_cliente_rfc  (rfc_num,cliente_num,nombre,address1,address2,colonia,city,province, postal_code,phone,contact,m_pago,id_uso_cfdi,cliente_rfc)  Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		case UPDATE:
			return " UPDATE py_cliente_rfc SET nombre = ?, address1=?, address2=?, colonia=?, city=?, province=?, postal_code=?, phone=?, contact=?,m_pago=?,id_uso_cfdi=?,cliente_rfc=? WHERE rfc_num = ? AND cliente_num = ? ";
		case CONSULTA:
			return "SELECT * FROM PY_CLIENTE_RFC";
		case CONSULTA2:
			return " Select rfc_num,cliente_num,nombre,address1,address2,colonia,city, province,postal_code,phone,contact,m_pago,id_uso_cfdi,cliente_rfc,estatus From py_cliente_rfc";
		case OBTENER_MAX_PY_CLIENTE_RFC:
			return " Select isnull(MAX(rfc_num),0) as rfc_num From py_cliente_rfc Where cliente_num = ? ";
		case INACTIVAR_RFC:
			return " Update py_cliente_rfc set estatus = 'I' Where cliente_num = ? and rfc_num = ? ";
		case ELIMINAR_CLIENTE_RFC:
			return " DELETE FROM py_cliente_rfc WHERE rfc_num = ? AND cliente_num = ? ";
		case ELIMINAR_PY_CLIENTE_RFC_INTERNET:
			return " Update py_cliente_rfc set estatus = 'I' Where cliente_num = ? ";
		case PEDIDO_INTERNET_GET_RFC_NUM:
			return " SELECT rfc_num FROM py_cliente_rfc WHERE cliente_num = ? and estatus = 'A' ";
		/*case ACTUALIZA_REFERENCIA:
			return " UPDATE py_dir_envio SET address2 = ?,  entre_calle1 = ?,  entre_calle2 = ?  WHERE dir_num = ?  AND cliente_num = ?  ";*/
		case CONSULTA_DETALLES:
			return " select trim(address1)||', '||trim(address2)||', '||trim(colonia)||', '||trim(city)||', '||trim(province) from py_cliente_rfc where rfc_num=? and cliente_num=?  ";
		case DIRECCION_PAGOSREGISTRADOS:
			return "select address1,address2,colonia,city,province,country,postal_code from py_dir_envio where cliente_num = ? and dir_num = ?";
		case UPDATE_RFC:
			return " UPDATE py_cliente_rfc SET nombre = ?, address1=?, address2=?, colonia=?, city=?, province=?, postal_code=?, phone=?, contact=?, m_pago=?,id_uso_cfdi=?,cliente_rfc=? WHERE rfc_num = ? AND cliente_num = ? ";
		case UPDATE_RFC2:
			return " UPDATE py_cliente_rfc SET address2=? WHERE rfc_num = ? AND cliente_num = ? ";		
		case UPDATE_RFC3:
			return " UPDATE py_cliente_rfc SET nombre = ?, address1=?, address2=?, colonia=?, city=?, province=?, postal_code=?, phone=?, contact=?, m_pago=?, id_uso_cfdi=? WHERE cliente_rfc = ? AND cliente_num = ? ";
		
		}
		return  "" ; 
	}
}
