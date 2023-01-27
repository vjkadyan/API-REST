package com.pedidos.api.sql;

public enum ObtieneMiEquipoSql {
	SELECT,
	SELECT_T_EQUIPO_M,
	SELECT_T_EQUIPO_C,
	SELECT_T_ADMIN_M,
	SELECT_T_TIPO_C,
	SELECT_T_TV_M,
	SELECT_ACCION_EQUIPO,
	SELECT_ACCION_OTRO,
	PERTENECE_EQUIPO,
	ACCESOS_CORREOS;
	
//	EAGLESECURE
	public String toString()
	{
		switch(this)
		{
			case SELECT:				return " exec fn_getbyclte_py_usuario_equipo ?; ";
			case SELECT_T_EQUIPO_M:		return " exec fn_getbyusr_cat_modulo_cuenta ?; ";
			case SELECT_T_EQUIPO_C:		return " exec fn_getbyusr_cat_correos ?; ";
			case SELECT_T_ADMIN_M:		return " exec fn_getbynm_cat_modulo_cuenta 'administrador'; ";
			case SELECT_T_TIPO_C:		return " exec fn_getbyperm_cat_correos ?; ";
			case SELECT_T_TV_M:			return " exec fn_getbyperm_cat_modulo_cuenta ?; ";
			case SELECT_ACCION_EQUIPO:	return " exec fn_con_py_usuario_equipo";
			case SELECT_ACCION_OTRO:	return " exec fn_getbynm_cat_permisos_default ?; ";
			case PERTENECE_EQUIPO:		return " exec fn_getbynum_py_usuario_equipo ?,?; ";
			case ACCESOS_CORREOS:		return " exec fn_gettypeq_py_usuario_equipo ?,?; ";
			default:					return " CONSULTA INVALIDA ";
		}
	}
	
//	EAGLE
//	public String toString()
//	{
//		switch(this)
//		{
//			case SELECT:				return " select e.cliente_num,e.usuario_num,e.cargo,e.accion_num,e.fecha_registro,e.identificador,e.status,u.nombre, u.email from py_usuario_equipo e inner join py_usuario u on e.usuario_num = u.usuario_num where e.cliente_num = ? ";
//			case SELECT_T_EQUIPO_M:		return " select m.modulo_num,m.nombre_mod,m.clave,m.url,m.img,( case when (select count(*) from permisos_modulos where modulo_num = m.modulo_num and usuario_num = ?) > 0 then 'S' else 'N' end ) acceso from cat_modulo_cuenta m where m.status in ('A','E') order by m.modulo_num asc ";
//			case SELECT_T_EQUIPO_C:		return " select c.correo_num,c.nombre_correo,( case when (select count(*) from permisos_correos where correo_num = c.correo_num and usuario_num = ?) > 0 then 'S' else 'N' end ) acceso from cat_correos c where c.status = 'A' order by c.correo_num asc ";
//			case SELECT_T_ADMIN_M:		return " select c.modulo_num, c.nombre_mod, c.clave,c.url,c.img,'S' acceso from cat_permisos_default p inner join cat_modulo_cuenta c on p.acm_num = c.modulo_num where p.nombre_permiso = 'administrador' and p.tipo_permiso = 'M' and c.status in ('A','E') order by p.acm_num asc ";
//			case SELECT_T_TIPO_C:		return " select c.correo_num,c.nombre_correo, 'S' acceso from cat_permisos_default p inner join cat_correos c on p.acm_num = c.correo_num where p.nombre_permiso = ? and p.tipo_permiso = 'C' and c.status = 'A' order by p.acm_num asc ";
//			case SELECT_T_TV_M:			return " select m.modulo_num,m.nombre_mod,m.clave,m.url,m.img,( case when (select count(*) from cat_permisos_default where nombre_permiso = ? and tipo_permiso = 'M' and acm_num = m.modulo_num) > 0 then 'S' else 'N' end ) acceso from cat_modulo_cuenta m where m.status in ('A','E') order by m.modulo_num asc ";
//			case SELECT_ACCION_EQUIPO:	return " select accion_num accion from py_usuario_equipo where usuario_num = ?; ";
//			case SELECT_ACCION_OTRO:	return " select acm_num accion from cat_permisos_default where tipo_permiso = 'A' and nombre_permiso = ?; ";
//			case PERTENECE_EQUIPO:		return " select e.usuario_num from py_usuario_equipo e inner join py_usuario u on e.usuario_num = u.usuario_num where u.email = ? and u.cliente_num = ( select cliente_num from tipo_mi_cuenta where usuario_num = ? ) ";
//	case ACCESOS_CORREOS:		return " select pu.email,pu.usuario_num, ( case when ( select count(*) from py_usuario_equipo where usuario_num = pu.usuario_num ) > 0 then ( case when ( select count(*) from permisos_correos where usuario_num = pu.usuario_num and correo_num = ( select correo_num from cat_correos where nombre_correo = ? and status = 'A' ) and status = 'A' ) > 0 then 'S-equipo' else 'N-equipo' end ) else 'S-administrador' end ) acceso from py_usuario pu where pu.cliente_num = ? ";
//			default:		return " CONSULTA INVALIDA ";
//		}
//	}
}
