package com.pedidos.api.sql;

public enum PyLayoutEjecutivaSql {
	CONSULTA,
	INSERTA;
	
	public String toString()
	{
		switch(this)
		{
			case CONSULTA:		return " select fecha,cliente_num,empleado_num,calificacion,comentario from py_layout_ejecutiva ";
			case INSERTA:		return " insert into py_layout_ejecutiva(id_playeje,fecha,cliente_num,empleado_num,calificacion,comentario) values((select max(id_playeje)+1 from py_layout_ejecutiva),today,?,?,?,?) ";
			default:			return "  ";
		}
	}
}
