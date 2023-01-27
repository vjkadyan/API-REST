package com.pedidos.api.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pedidos.api.model.PyConFactura;
import com.pedidos.api.sql.PyConFacturaSQL;

@Service
public class PyConFacturaDaoImp implements PyConFacturaDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private String sqltot = "";

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void insertRow(PyConFactura entidad) throws SQLException {
		sqltot = PyConFacturaSQL.INSERTA_PY_CONFACTURA.toString();
		jdbcTemplate.update(sqltot, entidad.getCustNum(), entidad.getFactura());

	}

	@Override
	public int deleteRow(PyConFactura entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRow(PyConFactura entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PyConFactura getByIdRow(PyConFactura entidad) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PyConFactura> getAllRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
