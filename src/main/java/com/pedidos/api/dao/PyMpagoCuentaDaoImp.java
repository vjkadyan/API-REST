package com.pedidos.api.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pedidos.api.model.PyMpagoCuenta;
import com.pedidos.api.sql.PyMpagoCuentaSQL;

@Service
public class PyMpagoCuentaDaoImp implements PyMpagoCuentaDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private String Sqltot = "";

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void insertRow(PyMpagoCuenta entidad) throws SQLException {
		Sqltot = PyMpagoCuentaSQL.INSERTA_PY_MPAGO_CUENTA.toString();
		jdbcTemplate.update(Sqltot, entidad.getClienteNum(), entidad.getCuenta());
	}

	@Override
	public int deleteRow(PyMpagoCuenta entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRow(PyMpagoCuenta entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PyMpagoCuenta getByIdRow(PyMpagoCuenta entidad) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PyMpagoCuenta> getAllRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
