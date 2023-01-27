package com.pedidos.api.sql;

public enum CatCorreosSql {
	SELECT_STATUS,
	SELECT_NC;
	
//	EAGLESECURE
	public String toString()
	{
		switch(this)
		{
			case SELECT_STATUS:	return " exec fn_getbyst_cat_correos('A'); ";
			case SELECT_NC:		return " select correo_num,nombre_correo,status from cat_correos";
			default:			return " COSNULTA INVALIDA";
		}
	}
	
//	EAGLE
//	public String toString()
//	{
//		switch(this)
//		{
//			case SELECT:	return " select correo_num,nombre_correo,status from cat_correos  ";
//			case INSERT:	return "  ";
//			case UPDATE:	return "  ";
//			case DELETE:	return "  ";
//			case SELECT_NC:	return " select correo_num,nombre_correo,status from cat_correos  where nombre_correo in () order by correo_num asc ";
//			default:		return " COSNULTA INVALIDA";
//		}
//	}
}
