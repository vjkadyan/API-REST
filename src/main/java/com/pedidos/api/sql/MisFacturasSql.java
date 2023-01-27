package com.pedidos.api.sql;

public enum MisFacturasSql {
	CONSULTA_FACTURAS,
	CONSULTA_NOTAS,
	VALIDA_CLIENTE,
	CONSULTA_DATOS_RFC,
	CONSULTA_DATO_RFC_0,
	CONSULTA_DATO_RFC,
	CONSULTA_ESTADO_DELEGACION,
	INSERTA_BITACORA,
	ELIMINA_RFC,
	CONSULTA_SERIE_STRING,
	CONSULTA_SERIE_NUM,
	CONSULTA_SERIES,
	NOTAS_BY_RFC,
	NOTAS_BY_RFC2,
	CLIENTE_RFC,
	RFC_PY_CLIENTE,
	ACTUALIZA_SHIPNUM_ORDERH,
	ACTUALIZA_SHIPNUM_SAORD;
	
	
	public String toString() {
		switch(this) 
		{
			case CONSULTA_FACTURAS:				return " select top (?) order_num,invoice_num,inv_date,order_status from sa_ord_h where div_code = 38000 and org_code = 'PDIR' and trans_type = 'DI' and order_status = 'INVOICED' and cust_num = ? ";
			//case CONSULTA_NOTAS:				return " select top(?) h.invoice_num, h.inv_date, h.net_amount + h.tax1_amt, (select rfc from py_rfc_invoice where invoice_num = h.document) ,'true' from sa_ord_h h inner join ar_mast ar on ar.trans_num = h.invoice_num where h.div_code = 38000 and h.org_code = 'PDIR' and order_status = 'INVOICED' and ((ar.document <> 0 and ar.trans_seq <> 1)or h.invoice_num in (select invoice_num from py_aplicacion_nc)) and h.trans_type = 'CM' and h.cust_num in (?) union all select h.invoice_num, h.inv_date, h.net_amount + h.tax1_amt, (select rfc from py_rfc_invoice where invoice_num = h.document) ,'false' from sa_ord_h h inner join ar_mast ar on ar.trans_num = h.invoice_num where h.div_code = 38000 and h.org_code = 'PDIR' and order_status = 'INVOICED' and h.invoice_num not in (select invoice_num from py_aplicacion_nc) and ar.document = 0 and ar.trans_seq = 0 and h.trans_type = 'CM' and h.cust_num in (?) ";
			case CONSULTA_NOTAS:				return " SELECT TOP(?) h.invoice_num ,h.inv_date ,h.net_amount + h.tax1_amt ,( SELECT rfc FROM py_rfc_invoice WHERE invoice_num = h.document) ,CASE WHEN ( ( ar.trans_seq > 1 and ar.document > 0 and h.invoice_num not in (select invoice_num from py_aplicacion_nc) ) or (h.invoice_num in (select invoice_num from py_aplicacion_nc)) ) THEN 'true' WHEN ( ar.document = 0 AND ar.trans_seq = 0 AND h.invoice_num NOT IN ( SELECT invoice_num FROM py_aplicacion_nc ) ) THEN 'false' END FROM sa_ord_h h INNER JOIN ar_mast ar ON ar.trans_num = h.invoice_num WHERE h.div_code = 38000 AND h.org_code = 'PDIR' AND order_status = 'INVOICED' AND h.trans_type = 'CM' AND h.cust_num IN ( ? ) ";
			case VALIDA_CLIENTE:				return " select count(invoice_num) cont from sa_ord_h where invoice_num = ? and cust_num = ? ";
			case CONSULTA_DATOS_RFC:			return " select 0 rfc_num,cliente_rfc,nombre,address1,address2,colonia,city,province,postal_code from py_cliente where cliente_num = ? union select rfc_num,cliente_rfc,nombre,address1,address2,colonia,city,province,postal_code from py_cliente_rfc where estatus = 'A' and cliente_num = ?; ";
			case CONSULTA_DATO_RFC_0:			return " select cliente_rfc,nombre,address1,address2,colonia,city,province,postal_code from py_cliente where cliente_num = ? and cliente_rfc = ? ";			
			case CONSULTA_DATO_RFC:				return " select rfc_num,cliente_rfc,nombre,address1,address2,colonia,city,province,postal_code from py_cliente_rfc where cliente_num = ? and cliente_rfc = ? and rfc_num = ? and estatus = 'A' ";
			case CONSULTA_ESTADO_DELEGACION:	return " select distinct e.estado, m.nombre municipio from municipioC m inner join coloniac c on m.estado = c.estado and m.municipio = c.municipio inner join estado e on c.estado = e.idEstado where c.codigo = ? ";
			case INSERTA_BITACORA:				return " insert into bit_cliente_rfc(tipo_bit,cliente_num,cliente_rfc,mensaje,fecha) values(?,?,?,?,GETDATE()); ";
			case ELIMINA_RFC:					return "  ";
			case CONSULTA_SERIE_STRING:			return " select distinct z.serial_code, z.reference from zseries z where  z.reference = ?; ";
			case CONSULTA_SERIE_NUM:			return " select distinct z.serial_code, z.reference from zseries z inner join usuario_pedidos u on z.reference = SUBSTRING(u.serie,6,6) where u.serie like '%38000%' and u.pwd = 'pedi2dcm' and z.serial_code = ?; ";
			case CONSULTA_SERIES:				return " select * from zseries where serial_code = ?";
			case NOTAS_BY_RFC: 					return " select h.invoice_num, h.inv_date, h.net_amount + h.tax1_amt,(select rfc from py_rfc_invoice where invoice_num = h.document) from sa_ord_h h inner join py_rfc_invoice r on r.invoice_num = h.document where div_code = 38000 and org_code = 'PDIR' and order_status = 'INVOICED' and trans_type = 'CM' and h.cust_num = ? and (select rfc from py_rfc_invoice where invoice_num = h.document) = ? order by inv_date desc";
			case NOTAS_BY_RFC2:					return " select h.invoice_num, h.inv_date, h.net_amount + h.tax1_amt,(select rfc from py_rfc_invoice where invoice_num = h.document) from sa_ord_h h inner join py_rfc_invoice r on r.invoice_num = h.invoice_num where div_code = 38000 and org_code = 'PDIR' and order_status = 'INVOICED' and trans_type = 'CM' and h.cust_num in (?,235509) and (select rfc from py_rfc_invoice where invoice_num = h.document) in (?,'AAGR760519T1A') order by inv_date desc";
			case CLIENTE_RFC:					return " select cliente_rfc from py_cliente_rfc where cliente_num = ? and rfc_num = ?";
			case RFC_PY_CLIENTE:				return " select cliente_rfc from py_cliente where cliente_num = ?;";
			case ACTUALIZA_SHIPNUM_ORDERH: 		return " update order_h set ship_via = ? where order_num in (?);";
			case ACTUALIZA_SHIPNUM_SAORD:  		return " update sa_ord_h set ship_via = ? where order_num in (?);";
			default:							return " Consulta invalida";
		}
	}
}
