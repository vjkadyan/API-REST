package com.pedidos.api.dao;


import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pedidos.api.model.PyCliente;
import com.pedidos.api.sql.PyClienteSQL;
import com.pedidos.api.sql.rowmapper.PyClienteRowMapper;

@Service
public class PyClienteDaoImp implements PyClienteDao {

	private static final Logger LOG = Logger.getLogger(PyClienteDaoImp.class);
	private String sqlTot = "";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void insertRow(PyCliente pyCliente) throws SQLException {
		sqlTot = PyClienteSQL.INSERT.toString();

		LOG.info(pyCliente.toString());
		LOG.info("@pyCliente insertRow ->" + sqlTot);

		jdbcTemplate.update(sqlTot, pyCliente.getClienteNum(), pyCliente.getCustNum(), pyCliente.getNombre(), pyCliente.getAddress1(), pyCliente.getAddress2(), pyCliente.getColonia(), pyCliente.getCity(), pyCliente.getProvince(), pyCliente.getCountry(), pyCliente.getPostalCode(), pyCliente.getPhone(), pyCliente.getFax(), pyCliente.getContact(), pyCliente.getPuesto(), pyCliente.getEmail(), pyCliente.getModoPorcentaje(), pyCliente.getPorcentaje(), pyCliente.getEstatus(), pyCliente.getInstrucCobro(), pyCliente.getRemFact(), pyCliente.getClienteRfc(), pyCliente.getZona(), pyCliente.getDirecto(), pyCliente.getLaboratorio(), pyCliente.getMargenLab(), pyCliente.getApartado(), pyCliente.getClaveHorario(), pyCliente.getPSupAlta(), pyCliente.getCantUsuAlta(), pyCliente.getCostoEnvio(), pyCliente.getEnviosGratis(), pyCliente.getMontoEnvio(), pyCliente.getControlEnvios(), pyCliente.getTipoEntrega(), pyCliente.getCredito(), pyCliente.getUltVisita(), pyCliente.getCuentaSoho(), pyCliente.getManejaCc(), pyCliente.getClasificacion(), pyCliente.getClase(), pyCliente.getTipo(), pyCliente.getRemision(), pyCliente.getValidadoCredito());

		return;
	}

	@Override
	public int deleteRow(PyCliente pyCliente) throws SQLException {

		return 1;
	}

	@Override
	@Transactional
	public int updateRow(PyCliente pyCliente) throws SQLException {
		sqlTot = PyClienteSQL.UPDATE.toString();

		return jdbcTemplate.update(sqlTot, new Object[] { pyCliente.getNombre(), 
				pyCliente.getAddress1(), 
				pyCliente.getAddress2(), pyCliente.getColonia(),
				pyCliente.getCity(), 
				pyCliente.getProvince(), 
				pyCliente.getPostalCode(), 
				pyCliente.getPhone(), 
				pyCliente.getEmail(), 
				pyCliente.getClienteNum(), 
				pyCliente.getCustNum() });
	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public PyCliente getByIdRow(PyCliente pyCliente) throws SQLException {

		sqlTot = PyClienteSQL.CONSULTA.toString() + " Where cliente_num = ? ";
		LOG.info(sqlTot);
		LOG.info("Cliente: " + pyCliente.getClienteNum());
		return jdbcTemplate.queryForObject(sqlTot, new PyClienteRowMapper(), pyCliente.getClienteNum());

	}

	@Override
	public Integer countRow() throws SQLException {

		return new Integer(1);
	}

	@Override
	public List<PyCliente> getAllRow() throws SQLException {

		return new ArrayList<PyCliente>();
	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public int getClienteNumPedidos(){
		int valor = 0;
		try {
			SimpleJdbcCall actor = new SimpleJdbcCall(jdbcTemplate).withProcedureName("sp_conse_clien");
			SqlParameterSource params = new MapSqlParameterSource();
			((MapSqlParameterSource) params).addValue("SWP_Ret_Value", "d100000");
			Map<String, Object> out = actor.execute(params);
			valor = (Integer) out.get("SWP_Ret_Value2");
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return valor;
	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public PyCliente ObtenerDatoscliente(long clienteNum) {
		sqlTot = PyClienteSQL.CONSULTA.toString() + " Where cliente_num = ? ";		
		return this.jdbcTemplate.queryForObject(sqlTot, new PyClienteRowMapper(),clienteNum );
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public boolean existePyCliente(String correo, long custNum) {
		sqlTot = PyClienteSQL.EXISTE_CLIENTE_CORREO.toString();
		SqlRowSet rs = this.jdbcTemplate.queryForRowSet(sqlTot, custNum, correo);
		if (rs.next()) {
			return true;
		}
		return false;
	}
}
