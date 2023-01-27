package com.pedidos.api.sql;

public enum PermisosModulosSql {
	SELECT,
	INSERT,
	UPDATE,
	ESTATUS,
	DELETE;
	
//	EAGLESECURE
	public String toString()
	{
		switch(this)
		{
			case SELECT:	return "  ";
			case INSERT:	return " exec fn_ins_permisos_modulos ?,?,?,?; ";
			case UPDATE:	return "  ";
			case ESTATUS:	return " exec fn_upd_permisos_modulos ?,?; ";
			case DELETE:	return " exec fn_del_permisos_modulos ?; ";
			default:		return " COSNULTA INVALIDA";
		}
	}
	
//	EAGLE
//	public String toString()
//	{
//		switch(this)
//		{
//			case SELECT:	return "  ";
//			case INSERT:	return " insert into permisos_modulos(cliente_num,usuario_num,modulo_num,status) values(?,?,?,?); ";
//			case UPDATE:	return "  ";
//			case ESTATUS:	return " update permisos_modulos set status = ? where usuario_num = ? ";
//			case DELETE:	return " delete from permisos_modulos where usuario_num = ? ";
//			default:		return " COSNULTA INVALIDA";
//		}
//	}
}
