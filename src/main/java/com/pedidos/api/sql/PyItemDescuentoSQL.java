package com.pedidos.api.sql;

public enum PyItemDescuentoSQL {
	
	CONSULTA_DESCUENTOS,
	CONSULTA_REGALOS;
	
	public String toString() {
		
		switch(this) {
		
		case CONSULTA_DESCUENTOS:		return "select item_num, descuento from py_item_descuento where estatus = 'A'; ";
		case CONSULTA_REGALOS:			return "select item_num ,estatus from promo_partidas_tiendas where today between fecha_ini and fecha_fin and estatus = 'A';";
		default: 						return "";
		}
	}
}