package com.pedidos.api.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.pedidos.api.model.Membresia;

@Service
public class adquiereMembrecia implements adquierenewMem{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public boolean insertRow(Membresia entidad) {
		
		try {
			String query = "insert into py_cliente_afiliacion_fijo VALUES(?,?,?,?);";
			jdbcTemplate.update(query,entidad.getCliente_num(),entidad.getId_afiliacion(),entidad.getComentario(),entidad.getEstatus());
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public boolean insertRowCliente(Membresia entidad) {		
		try {
			String query = 
			"IF NOT EXISTS(SELECT * FROM py_cliente_afiliacion_fijo WHERE cliente_num=?)\r\n" + 
			"BEGIN\r\n" + 
			"    INSERT INTO py_cliente_afiliacion_fijo\r\n" + 
			"    (cliente_num, id_afiliacion,comentario,estatus)\r\n" + 
			"    VALUES(?,?,(select descripcion from py_afiliacion where id_afiliacion =?),?)\r\n" + 
			"END\r\n" + 
			"ELSE\r\n" + 
			"BEGIN\r\n" + 
			"    UPDATE py_cliente_afiliacion_fijo\r\n" + 
			"    SET id_afiliacion =?,comentario=(select descripcion from py_afiliacion where id_afiliacion =?)\r\n" + 
			"    WHERE cliente_num=?\r\n" + 
			"END";
			jdbcTemplate.update(query,entidad.getCliente_num(),entidad.getCliente_num(),entidad.getId_afiliacion(),entidad.getId_afiliacion(),entidad.getEstatus(),entidad.getId_afiliacion(),entidad.getId_afiliacion(),entidad.getCliente_num());
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
}
