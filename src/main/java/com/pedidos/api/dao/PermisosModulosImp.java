package com.pedidos.api.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.pedidos.api.model.PermisosModulos;
import com.pedidos.api.sql.PermisosModulosSql;

@Service
public class PermisosModulosImp implements PermisosModulosDao{
	private static final Logger log = Logger.getLogger(PermisosModulosImp.class);
	String sql = "";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insertRow(PermisosModulos entidad) throws SQLException {
		sql =  PermisosModulosSql.INSERT.toString();
		log.info("PermisosModulosImp insertRow: " + sql);
		this.jdbcTemplate.queryForObject(sql, new Object[] {entidad.getClienteNum(), entidad.getUsuarioNum(), entidad.getModuloNum(), entidad.getStatus()}, Integer.class);
	}

	@Override
	public int deleteRow(PermisosModulos entidad) throws SQLException {
		sql =  PermisosModulosSql.DELETE.toString();
		log.info("PermisosModulosImp deleteRow: " + sql);
		return this.jdbcTemplate.queryForObject(sql, new Object[] {entidad.getUsuarioNum()}, Integer.class);
	}

	@Override
	public int updateRow(PermisosModulos entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PermisosModulos getByIdRow(PermisosModulos entidad) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PermisosModulos> getAllRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int estatusUsuario(long usuarioMod, String estatus) throws SQLException {
		sql =  PermisosModulosSql.ESTATUS.toString();
		log.info("PermisosModulosImp estatusUsuario: " + sql);
		return this.jdbcTemplate.queryForObject(sql, new Object[] {usuarioMod, estatus}, Integer.class);
	}

	@Override
	public int deleteByUsuario(long usuarioNum) throws SQLException {
		sql =  PermisosModulosSql.DELETE.toString();
		log.info("PermisosModulosImp deleteByUsuario: " + sql);
		return this.jdbcTemplate.queryForObject(sql, new Object[] {usuarioNum}, Integer.class);
	}

}
