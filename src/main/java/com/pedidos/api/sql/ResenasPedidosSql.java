package com.pedidos.api.sql;


public enum ResenasPedidosSql {
	CONSULTA_ULTIMO_EJECUTIVO, 
	CONSULTA_ULTIMO_TRANSPORTISTA,
	GET_ROW_PY_PEDIDO_HELP,
	INSERTA_PY_PEDIDO_HELP,
	ACTUALIZA_PY_PEDIDO_HELP;
	
	public String toString()
	{
		switch(this)
		{
			case CONSULTA_ULTIMO_EJECUTIVO:		return " select top 1 h.slmn, e.fecha, e.pedido_num,ej.nombre,ej.email,ej.ext,ej.stat,ej.ckase from py_pedido_help h inner join py_pedido_enc e on h.pedido_num = e.pedido_num inner join py_ejecutivo ej on cast(h.slmn as varchar(10)) = cast(ej.num_empleado as varchar(10)) where e.cliente_num = ? and e.estatus in ('R','F') order by h.pedido_num desc ";
			case CONSULTA_ULTIMO_TRANSPORTISTA:	return " select top 1 h.certif_num,l.invoice_num,c.chofer_num,c.nombre, c.paterno, c.materno from certificado_h h, certificado_l l, chofer c where h.certif_num = l.certif_num and c.chofer_num = h.chofer_num ";
			case GET_ROW_PY_PEDIDO_HELP:		return " select pedido_num, estatus, slmn from py_pedido_help where pedido_num = ?;";
			case INSERTA_PY_PEDIDO_HELP:		return " insert into py_pedido_help values (?,'A',?,null);";
			case ACTUALIZA_PY_PEDIDO_HELP:		return " update py_pedido_help set slmn = ? where pedido_num = ?";
			default:							return " CONSULTA INVALIDA ";
		}
	}
	
}
