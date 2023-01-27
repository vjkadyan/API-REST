package com.pedidos.api.sql;

public enum AfiliacionSQL {
	GET_AFILIACION_CLIENTE;
	 
	public String toString() {
		switch(this) {
			case GET_AFILIACION_CLIENTE:
				return "SELECT pcaf.cliente_num, pa.num_afiliacion, " + 
						"pa.descripcion,pcaf.estatus, pa.nombre_afiliacion FROM py_cliente_afiliacion_fijo pcaf " + 
						"inner join py_afiliacion pa on(pa.id_afiliacion=pcaf.id_afiliacion) " + 
						"where pa.estatus='A'";
		}
		return "";
	}
}
