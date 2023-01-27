package com.pedidos.api.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pedidos.api.model.PyClienteRfc;
import com.pedidos.api.sql.PyClienteRfcSQL;
import com.pedidos.api.sql.rowmapper.PyClienteRfcRowMapper;

@Service
public class PyClienteRfcDaoImp implements PyClienteRfcDao{
	private String sqlTot = "";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insertRow(PyClienteRfc entidad) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteRow(PyClienteRfc entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRow(PyClienteRfc entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PyClienteRfc getByIdRow(PyClienteRfc entidad) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PyClienteRfc> getAllRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PyClienteRfc> getPyClienteRfcByClienteNum(long clienteNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public int getMaxPyClienteRfc(long clienteNum) throws SQLException {
		int maxShipNum = 0;
		sqlTot = PyClienteRfcSQL.OBTENER_MAX_PY_CLIENTE_RFC.toString();

		SqlRowSet rs = jdbcTemplate.queryForRowSet(sqlTot, new Object[] { clienteNum });
		if (rs.next()) {
			maxShipNum = rs.getInt("rfc_num");
		}
		maxShipNum++;

		return maxShipNum;
	}

	@Override
	public int inactivarRfc(long clienteNum, long rfcNum) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminaPyClienteRFC(long rfcNum, long clienteNum) {
		sqlTot = PyClienteRfcSQL.ELIMINAR_CLIENTE_RFC.toString();
		return jdbcTemplate.update(sqlTot, new Object[] { rfcNum, clienteNum });
	}

	@Override
	public int eliminaPyClienteRfcInternet(String clienteNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int pedidoInternetGetRfcNum(long clienteNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PyClienteRfc> getRFC(long clienteNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PyClienteRfc> getTodosRFC(long clienteNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int actualizarRfcPyClienteRfc(PyClienteRfc pyclienteRfc) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PyClienteRfc ObtenerDatosCliente(long clienteNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	//@Transactional(propagation=Propagation.MANDATORY)
	public int insertRow(PyClienteRfc pyclienteRfc, int flag) throws SQLException {
		sqlTot = PyClienteRfcSQL.INSERT.toString();

		int i = jdbcTemplate.update(sqlTot, 
				pyclienteRfc.getRfcNum(), 
				pyclienteRfc.getClienteNum(),
				pyclienteRfc.getNombre(), 
				pyclienteRfc.getAddress1(), 
				pyclienteRfc.getAddress2(),
				pyclienteRfc.getColonia(), 
				pyclienteRfc.getCity(), 
				pyclienteRfc.getProvince(),
				pyclienteRfc.getPostalCode(), 
				pyclienteRfc.getPhone(), 
				pyclienteRfc.getContact(),
				pyclienteRfc.getmPago(),
				pyclienteRfc.getIdUsoCfdi(),
				pyclienteRfc.getClienteRfc());
		return i;
	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public PyClienteRfc ObtenerDatosClienteRfc(long clienteNum, String clienteRfc) {
		PyClienteRfc pyClienteRfc = new PyClienteRfc();
		
		sqlTot = PyClienteRfcSQL.CONSULTA2.toString() + " Where cliente_num = ? and cliente_rfc = ? ";

		SqlRowSet rs = jdbcTemplate.queryForRowSet(sqlTot, new Object[] { clienteNum, clienteRfc });
		if(rs.next())
		{
			pyClienteRfc = jdbcTemplate.queryForObject(sqlTot, new Object[] { clienteNum, clienteRfc }, new PyClienteRfcRowMapper());
		}
		else
		{
			pyClienteRfc.setClienteRfc("");
		}
		return pyClienteRfc;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int updateRowRfc(PyClienteRfc pyclienteRfc) throws SQLException {
		sqlTot = PyClienteRfcSQL.UPDATE_RFC3.toString();
		return jdbcTemplate.update(sqlTot, new Object[] { 
				pyclienteRfc.getNombre(), 
				pyclienteRfc.getAddress1(), 
				pyclienteRfc.getAddress2(), 
				pyclienteRfc.getColonia(), 
				pyclienteRfc.getCity(), 
				pyclienteRfc.getProvince(),  
				pyclienteRfc.getPostalCode(), 
				pyclienteRfc.getPhone(),
				pyclienteRfc.getContact(), 
				pyclienteRfc.getmPago(),
				pyclienteRfc.getIdUsoCfdi(),
				pyclienteRfc.getClienteRfc(),
				pyclienteRfc.getClienteNum() });
	}

	@Override
	public long obtieneRfcNumGenerico(long clienteNum) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
