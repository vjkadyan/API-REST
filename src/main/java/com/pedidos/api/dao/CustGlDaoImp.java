package com.pedidos.api.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pedidos.api.model.CustGl;
import com.pedidos.api.sql.CustGlSQL;
import com.pedidos.api.sql.rowmapper.CustGlRowMapper;

@Service
public class CustGlDaoImp implements CustGlDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static String SQLTOT = "";

	@Transactional(propagation = Propagation.MANDATORY)
	@Override
	public void insertRow(CustGl entidad) throws SQLException {
		SQLTOT = CustGlSQL.INSERTA_CUST_GL.toString();
		jdbcTemplate.update(SQLTOT, entidad.getOrgCode(), entidad.getDivCode(), entidad.getCustNum(), entidad.getGlCode());
	}

	@Override
	public int deleteRow(CustGl entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRow(CustGl entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CustGl getByIdRow(CustGl entidad) throws SQLException {
		
		return null;
	}

	@Override
	public Integer countRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustGl> getAllRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustGl prueba() {
		SQLTOT = CustGlSQL.CONSULTA.toString() + " WHERE cust_num=400608;";
		return jdbcTemplate.queryForObject(SQLTOT, new CustGlRowMapper());
	}

	@Override
	public String getGlCode(String org_code, String div_code) {
		SQLTOT=CustGlSQL.OBTIENE_GL_CHARTI.toString();
		return jdbcTemplate.queryForObject(SQLTOT,new Object[]{org_code ,div_code} ,String.class);		
	}

}
