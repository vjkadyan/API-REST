package com.pedidos.api.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pedidos.api.model.PyClienteMpago;
import com.pedidos.api.sql.PyClienteMpagoSQL;

@Service
public class PyClienteMpagoDaoImp implements PyClienteMpagoDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private String Sqltot = "";

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void insertRow(PyClienteMpago entidad) throws SQLException {
		Sqltot = PyClienteMpagoSQL.INSERTA_PY_CLIENTE_MPAGO.toString();
		jdbcTemplate.update(Sqltot, entidad.getClienteNum(), entidad.getMpago());
	}

	@Override
	public int deleteRow(PyClienteMpago entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRow(PyClienteMpago entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PyClienteMpago getByIdRow(PyClienteMpago entidad) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PyClienteMpago> getAllRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
