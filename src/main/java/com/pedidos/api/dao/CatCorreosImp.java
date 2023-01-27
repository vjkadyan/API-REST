package com.pedidos.api.dao;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.pedidos.api.model.CatCorreos;
import com.pedidos.api.sql.CatCorreosSql;

@Service
public class CatCorreosImp implements CatCorreosDao{
	
	private static final Logger log = Logger.getLogger(CatCorreosImp.class);
	private String sql = "";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<CatCorreos> getCorreos(String correos) throws SQLException {
		sql = CatCorreosSql.SELECT_NC.toString()+" where nombre_correo in("+correos+")";
		List<CatCorreos> listaCorreos = new LinkedList<CatCorreos>();
		CatCorreos correo = null;
		SqlRowSet rs = this.jdbcTemplate.queryForRowSet(sql);
		while(rs.next())
		{
			correo = null;
			correo = new CatCorreos();
			correo.setCorreoNum(rs.getInt("correo_num"));
			correo.setNombreCorreo(rs.getString("nombre_correo"));
			correo.setStatus(rs.getString("status"));
			listaCorreos.add(correo);
		}
		return listaCorreos;
	}

	@Override
	public void insertRow(CatCorreos entidad) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteRow(CatCorreos entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRow(CatCorreos entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CatCorreos getByIdRow(CatCorreos entidad) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CatCorreos> getAllRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
