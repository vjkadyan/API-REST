package com.pedidos.api.sql;

public enum PyUsuarioSQL {
	INSERT,
	INACTIVAR_USUARIO,
	UPDATE,
	UPDATE_DATOSU,
	CONSULTA,
	CONSULTA2,
	GET_CONSECUTIVO,
	EXISTEN_USUARIO,
	USUARIO_EXISTENTE,
	INACTIVAR_USUARIOS,
	INACTIVAR_USUARIOS_INTERNET,
	ENCRIPTAR_PASSWORD,
	UPDATEMIINFO,
	UPDATESINC, 
	ACTUALIZARDATOS,
	ACTUALIZARDATOS_EQUIPO,
	ENCRIPTAR_USUARIO,
	ACTUALIZARPASSWORD,
	ACTUALIZARPASSWORD2,
	USUARIO_REPETIDO, 
	GET_PY_USUARIO_BY_CLIENTE_NUM, 
	ESTATUS_USUARIO,
	ACTUALIZA_NOMBRE,
	VALIDA_USUARIO_EXISTENTE,
	INSERTA_PRECIO_CINTA_VERDE,
	DELETE_PRECIO_CINTA_VERDE,
	GET_PRECIO_CINTA_VERDE,
	INSERT_TRANSFER,
	ENCRIPTION,
	GET_IS_PYUSUARIO,
	GET_IS_PYUSUARIO_GLOBAL,
	GET_PYUSUARIO_PYCLIENTE,
	GET_PYDIRENVIO_USUARIO,
	GET_PYDIRENVIO,
	GET_PRIMERACOMPRA,
	GET_MERCADOLIBRE;
	
	public String toString(){
		switch (this) {
		case INSERT:
			return " Insert into py_usuario (usuario_num,cliente_num,cust_num,usuario,password, nombre,email,estatus,reserva,iva,clave_iva,limite_credito,credito_utilizado, tipo_usuario,observacion,con_precio,altadir,ultima_vis) Values (?,?,?,?,?, ?,?,?,?,?,?,?,?, ?,?,?,?,?)  ";
		case INACTIVAR_USUARIO:
			return " UPDATE py_usuario SET estatus='I' ";
		case UPDATE:
			return " UPDATE py_usuario SET usuario = ?,password=?, nombre=?, email=? WHERE usuario_num = ? AND cliente_num = ? AND cust_num = ? ";
		case UPDATE_DATOSU:
			return " UPDATE py_usuario SET  nombre=?, email=?";
		case CONSULTA:
			return " Select usuario_num,cliente_num,cust_num,usuario,password,nombre,email,estatus,reserva,iva,clave_iva,limite_credito,credito_utilizado,tipo_usuario,observacion,con_precio,altadir,ultima_vis From py_usuario ";
		case GET_CONSECUTIVO:
			return " exec sp_conse_clien('Usuario') ";
		case EXISTEN_USUARIO:
			return " SELECT COUNT(usuario_num) FROM py_usuario where cliente_num = ? ";
		case USUARIO_EXISTENTE:
			return " SELECT usuario FROM py_config WHERE usuario = ? UNION SELECT usuario FROM py_distribuidor WHERE usuario = ? UNION SELECT usuario FROM py_usuario WHERE usuario = ? and usuario_num<>0 UNION SELECT usuario FROM c_config WHERE usuario = ? UNION SELECT usuario  FROM c_distribuidor WHERE usuario = ? UNION SELECT usuario FROM c_usuario WHERE usuario = ? and usuario_num<>0  ";
		case INACTIVAR_USUARIOS:
			return " Update py_usuario set estatus = 'I' Where cust_num = ? and cliente_num = ? and usuario_num = ? ";
		case CONSULTA2: 
			return "select usu.usuario_num,usu.cliente_num,usu.cust_num,usu.usuario,usu.password,usu.nombre,usu.email,usu.tipo_usuario,usu2.tel,usu2.ext from py_usuario usuinner join py_usu_2 usu2on usu.usuario_num = usu2.usuario_num ";
		case INACTIVAR_USUARIOS_INTERNET:
			return " DELETE FROM py_usuario Where cust_num = ? and cliente_num = ? and usuario_num = ? ";
		case ENCRIPTAR_PASSWORD:
			return " Update py_usuario set password = ? WHERE usuario_num = ? ";
		case ACTUALIZARDATOS:
			return " Update py_usuario SET  nombre=?, email=?, usuario = ?, password = ? WHERE usuario_num = ?";
		case UPDATEMIINFO:
			return "Update py_usuario SET  nombre=?, email=?, password = ? WHERE usuario_num = ?" ;
		case UPDATESINC:
			return "Update py_usuario SET  nombre=?, email=? WHERE usuario_num = ?" ;
		case ENCRIPTAR_USUARIO:
			return "select encrypt_aes(usuario_num) as usuario, encrypt_aes(password) as password  from py_usuario where cliente_num = ? ";
		case USUARIO_REPETIDO:
			return "select count(usuario) as usuario from py_usuario where usuario = ? and estatus = 'A';";
		case GET_PY_USUARIO_BY_CLIENTE_NUM:
			return "";
		case ACTUALIZARPASSWORD:
			return " Update py_usuario SET password = ? WHERE usuario_num = ?";
		case ACTUALIZARPASSWORD2:
			return " Update py_usuario SET password = ? WHERE email = ? and cust_num = 38000";
		case ACTUALIZARDATOS_EQUIPO:
			return " update py_usuario set nombre = ? where usuario_num = ? ";
		case ESTATUS_USUARIO:
			return " Update py_usuario set estatus = ? Where cust_num = ? and cliente_num = ? and usuario_num = ? ";
		case ACTUALIZA_NOMBRE:
			return " update py_usuario set nombre = ? where usuario_num = ?; ";
		case VALIDA_USUARIO_EXISTENTE:
			return "select count(*) from py_usuario where cust_num = 38000 and (usuario = ? or email = ?) and estatus = 'A';";
		case INSERTA_PRECIO_CINTA_VERDE:
			return "exec fn_ins_py_pedido_cinta_verde(?);";
		case DELETE_PRECIO_CINTA_VERDE:
			return "exec fn_del_py_pedido_cinta_verde(?);";
		case GET_PRECIO_CINTA_VERDE:
			return "exec fn_get_py_pedido_cinta_verde(?);";
		case INSERT_TRANSFER:
			return "insert into py_transferencias (pedido_num,referencia,estatus,fecha) values (?,?,?,GETDATE());";
		case ENCRIPTION:
			return "set encryption password get_enc_pass()";
		case GET_IS_PYUSUARIO:
			return "select decrypt_char(?) usuario, decrypt_char(?) contra from py_usuario where cliente_num = 201221";
		case GET_IS_PYUSUARIO_GLOBAL:
			return "select decrypt_char(?) session_id  from global";
		case GET_PYUSUARIO_PYCLIENTE:
			return "Select u.cust_num,u.cliente_num,u.usuario_num, u.nombre From py_usuario u,py_cliente c Where u.email = ? And u.password = ? And c.cust_num = u.cust_num And c.cliente_num = u.cliente_num And c.cust_num = 38000 And c.tipo = 'S' And c.estatus = 'A'";
		case GET_PYDIRENVIO_USUARIO:
			return "SELECT d.* FROM py_dir_envio d,py_dir_envio_usu u WHERE d.cliente_num = ? AND u.dir_num=d.dir_num AND u.usuario_num=? AND d.estatus = 'A' ORDER BY d.nombre";
		case GET_PYDIRENVIO:
			return "SELECT d.* FROM py_dir_envio d WHERE d.cliente_num = ? AND	d.estatus = 'A' ORDER BY d.nombre";
		case GET_PRIMERACOMPRA:
			return "SELECT contacto FROM reg_contacto_primercompra WHERE estatus = 'A' AND cookie_sesion = ?";
		case GET_MERCADOLIBRE:
			return "SELECT test1 FROM test_tv WHERE cliente_num = ?";
		}
		return"";
	}

}
