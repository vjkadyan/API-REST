package com.pedidos.api.dao;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.pedidos.api.sql.PyItemDescuentoSQL;

@Service
public class PyItemsDescuentoDaoImp implements PyItemDescuentoDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	String sql = "";
	
	@Override
	public void insertRow(PyItemDescuentoDao entidad) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteRow(PyItemDescuentoDao entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRow(PyItemDescuentoDao entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PyItemDescuentoDao getByIdRow(PyItemDescuentoDao entidad) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PyItemDescuentoDao> getAllRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public Map<String, Double> obtieneDescuentos() {
		Map<String, Double> mapDescuentos = new HashMap<String, Double>();
		sql = PyItemDescuentoSQL.CONSULTA_DESCUENTOS + "";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
		while(rs.next()) {
			mapDescuentos.put(rs.getString(1).trim(), rs.getDouble(2));
		}
		return mapDescuentos;
	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public Map<String, String> obtieneRegalos() {
		Map<String, String> mapRegalos = new HashMap<String, String>();
		sql = PyItemDescuentoSQL.CONSULTA_REGALOS + "";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
		while(rs.next()) {
			mapRegalos.put(rs.getString(1).trim(), rs.getString(2).trim());
		}
		return mapRegalos;
	}

}
