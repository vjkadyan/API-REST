package com.pedidos.api.sql;

public enum PyUsuarioEquipoSQL {
	INSERT,
	UPDATE_1,
	SELECT_USUARIO,
	UPD_IDENTIFICADOR,
	TIPO_USUARIO,
	ESTATUS_USUARIO,
	IDENTIFICADOR, 
	DELETE;
	
//	EAGLESECURE
	public String toString(){
		switch (this) {
		case INSERT:
			return " exec fn_ins_py_usuario_equipo ?,?,?,?,?,?; ";
		case UPDATE_1:
			return " exec fn_upd_py_usuario_equipo ?,?,?; ";
		case SELECT_USUARIO:
			return " exec fn_getbyusr_py_usuario_equipo ?; ";
		case TIPO_USUARIO:
			return " exec fn_gettype_py_usuario_equipo ? ";
		case UPD_IDENTIFICADOR:
			return " exec fn_updid_py_usuario_equipo ?,?; ";
		case ESTATUS_USUARIO:
			return " exec fn_updst_py_usuario_equipo ?,?; ";
		case IDENTIFICADOR:
			return " exec fn_getid_py_usuario_equipo ?; ";
		case DELETE:
			return " exec fn_del_py_usuario_equipo ?; ";
		}
		return"";
	}
	
//	EAGLE
//	public String toString(){
//		switch (this) {
//		case INSERT:
//			return " insert into py_usuario_equipo (cliente_num,usuario_num,cargo,accion_num,fecha_registro,identificador,status) values(?,?,?,?,current,?,?); ";
//		case UPDATE:
//			return "update py_usuario_equipo ";
//		case UPDATE:
//			return "update py_usuario_equipo set telefono_princ = ?, celular_princ = ? where usuario_num = ?";
//		case SELECT_USUARIO:
//			return " select e.cliente_num,e.usuario_num,e.cargo,e.accion_num,to_char(e.fecha_registro, '%Y-%m-%d') fecha_registro,e.identificador,e.celular_princ,e.telefono_princ,e.status,u.nombre,(select empresa from tipo_mi_cuenta where cliente_num = e.cliente_num) empresa,(select tipo_cuenta from tipo_mi_cuenta where cliente_num = e.cliente_num) tipo_cuenta from py_usuario_equipo e inner join py_usuario u on e.usuario_num = u.usuario_num ";
//		case TIPO_USUARIO:
//			return " select case when( select count(usuario_num) from tipo_mi_cuenta where usuario_num = pu.usuario_num ) > 0 then 'administrador' else( select case when( select count(usuario_num) from py_usuario_equipo where usuario_num = pu.usuario_num ) > 0 then 'equipo' else 'nuevo' end from py_usuario where usuario_num = pu.usuario_num ) end tipo_usuario from py_usuario pu where pu.cust_num = 38000 and pu.usuario_num = ? ";
//		case UPD_IDENTIFICADOR:
//			return " update py_usuario_equipo set identificador = ? where usuario_num = ? ";
//		case ESTATUS_USUARIO:
//			return " update py_usuario_equipo set status = ? where usuario_num = ? ";
//		case IDENTIFICADOR:
//			return " select identificador from py_usuario_equipo ";
//		case DELETE:
//			return " delete from py_usuario_equipo ";
//		}
//		return"";
//	}

}
