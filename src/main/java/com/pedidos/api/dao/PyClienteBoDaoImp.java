package com.pedidos.api.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pedidos.api.model.PyClienteBo;
import com.pedidos.api.sql.PyClienteBoSQL;

@Service
public class PyClienteBoDaoImp implements PyClienteBoDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private String sqltot = "";

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void insertRow(PyClienteBo entidad) throws SQLException {
		sqltot = PyClienteBoSQL.INSERTA_PY_CLIENTE_BO.toString();
		jdbcTemplate.update(sqltot, entidad.getClienteNum(), entidad.getCustNum(), entidad.getBackorder());
	}

	@Override
	public int deleteRow(PyClienteBo entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRow(PyClienteBo entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PyClienteBo getByIdRow(PyClienteBo entidad) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PyClienteBo> getAllRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}

