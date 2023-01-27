package com.pedidos.api.sql;

public enum PermisosCorreosSql {
	SELECT,
	INSERT,
	UPDATE,
	ESTATUS,
	DELETE;
	
	public String toString()
	{
		switch(this)
		{
			case SELECT:	return "  ";
			case INSERT:	return " exec fn_ins_permisos_correos ?,?,?,?; ";
			case UPDATE:	return "  ";
			case ESTATUS:	return " exec fn_upd_permisos_correos  ?,?; ";
			case DELETE:	return " exec fn_del_permisos_correos ?; ";
			default:		return " CONSULTA NO VALIDA";
		}
	}
	
//	eagle
//	public String toString()
//	{
//		switch(this)
//		{
//			case SELECT:	return "  ";
//			case INSERT:	return " insert into permisos_correos(cliente_num,usuario_num,correo_num,status) values(?,?,?,?); ";
//			case UPDATE:	return "  ";
//			case ESTATUS:	return " update permisos_correos set status = ? where usuario_num = ? ";
//			case DELETE:	return " delete from permisos_correos where usuario_num = ? ";
//			default:		return " CONSULTA NO VALIDA";
//		}
//	}
}
