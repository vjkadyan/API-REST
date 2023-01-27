package com.pedidos.api.sql;

public enum PyEnvioGratisSQL {
	
	CONSULTA,
	CONSULTA_ACTIVOS;
	
	public String toString() {
		
		switch(this) {
		
		case CONSULTA:			return "exec fn_con_py_envio_gratis(?)";
		case CONSULTA_ACTIVOS:  return "exec fn_con_py_envio_gratis ('envio_gratis = ''Y''');";
		default:					return "  ";
		
		}
	
	}

}