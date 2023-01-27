package com.pedidos.api.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.pedidos.api.model.PermisosCorreos;
import com.pedidos.api.sql.PermisosCorreosSql;

@Service
public class PermisosCorreosImp implements PermisosCorreosDao{
	private static final Logger log = Logger.getLogger(PermisosCorreosImp.class);
	String sql = "";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insertRow(PermisosCorreos entidad) throws SQLException {
		log.info("PermisosCorreosImp insertRow ");
		sql = PermisosCorreosSql.INSERT.toString();
		this.jdbcTemplate.queryForObject(sql, new Object[] {entidad.getClienteNum(), entidad.getUsuarioNum(), entidad.getCorreoNum(), entidad.getStatus()}, Integer.class); 
	}

	@Override
	public int deleteRow(PermisosCorreos entidad) throws SQLException {
		sql = PermisosCorreosSql.DELETE.toString();
		log.info("PermisosCorreosImp deleteRow: " + sql);
		return this.jdbcTemplate.queryForObject(sql, new Object[] {entidad.getUsuarioNum()}, Integer.class);
	}

	@Override
	public int updateRow(PermisosCorreos entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PermisosCorreos getByIdRow(PermisosCorreos entidad) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PermisosCorreos> getAllRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int estatusUsuario(long usuarioMod, String estatus) throws SQLException {
		sql = PermisosCorreosSql.ESTATUS.toString();
		log.info("PermisosCorreosImp estatusUsuario: " + sql);
		return this.jdbcTemplate.queryForObject(sql, new Object[] {usuarioMod, estatus}, Integer.class);
	}

	@Override
	public int deleteByUsuario(long usuarioNum) throws SQLException {
		sql = PermisosCorreosSql.DELETE.toString();
		log.info("PermisosCorreosImp deleteByUsuario: " + sql);
		return this.jdbcTemplate.queryForObject(sql, new Object[] {usuarioNum}, Integer.class);
	}

}
