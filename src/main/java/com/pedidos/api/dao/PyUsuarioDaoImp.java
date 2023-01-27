package com.pedidos.api.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pedidos.api.comun.Encriptacion;
import com.pedidos.api.model.PyUsuario;
import com.pedidos.api.sql.PyUsuarioSQL;
import com.pedidos.api.sql.rowmapper.PyUsuarioRowMapper;

@Service
public class PyUsuarioDaoImp implements PyUsuarioDao{

	private static final Logger LOG = Logger.getLogger(PyUsuarioDaoImp.class);
	private String sqlTot = "";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void insertRow(PyUsuario pyUsuario) throws SQLException {
		LOG.info("insertRow PyUsuario");

		sqlTot = PyUsuarioSQL.INSERT.toString();

		LOG.info(sqlTot);
		LOG.info(pyUsuario.toString());

		jdbcTemplate.update(sqlTot, pyUsuario.getUsuarioNum(), pyUsuario.getClienteNum(), pyUsuario.getCustNum(), pyUsuario.getUsuario(), Encriptacion.sha256(pyUsuario.getPassword().trim()), pyUsuario.getNombre(), pyUsuario.getEmail(), pyUsuario.getEstatus(), pyUsuario.getReserva(), pyUsuario.getIva(), pyUsuario.getClaveIva(), pyUsuario.getLimiteCredito(), pyUsuario.getCreditoUtilizado(), pyUsuario.getTipoUsuario(), pyUsuario.getObservacion(), pyUsuario.getConPrecio(), pyUsuario.getAltadir(), pyUsuario.getUltimaVis());

		return;
	}

//	@Override
//	@Transactional(propagation = Propagation.MANDATORY)
//	public int insertPyUsuario(PyUsuario pyUsuario) throws SQLException {
//		LOG.info("insertRow PyUsuario");
//
//		sqlTot = PyUsuarioSQL.INSERT.toString();
//
//		LOG.info(sqlTot);
//		LOG.info(pyUsuario.toString());
//
//		return jdbcTemplate.update(sqlTot, pyUsuario.getUsuarioNum(), pyUsuario.getClienteNum(), pyUsuario.getCustNum(), pyUsuario.getUsuario(), Encriptacion.sha256(pyUsuario.getPassword().trim()), pyUsuario.getNombre(), pyUsuario.getEmail(), pyUsuario.getEstatus(), pyUsuario.getReserva(), pyUsuario.getIva(), pyUsuario.getClaveIva(), pyUsuario.getLimiteCredito(), pyUsuario.getCreditoUtilizado(), pyUsuario.getTipoUsuario(), pyUsuario.getObservacion(), pyUsuario.getConPrecio(), pyUsuario.getAltadir(), pyUsuario.getUltimaVis());
//
//	}
	
//	@Override
//	@Transactional(propagation = Propagation.MANDATORY)
//	public int insertarUsuario(PyUsuario pyUsuario) throws SQLException {
//		sqlTot = PyUsuarioSQL.INSERT.toString();
//		return jdbcTemplate.update(sqlTot, pyUsuario.getUsuarioNum(), pyUsuario.getClienteNum(), pyUsuario.getCustNum(), pyUsuario.getUsuario(), Encriptacion.sha256(pyUsuario.getPassword().trim()), pyUsuario.getNombre(), pyUsuario.getEmail(), pyUsuario.getEstatus(), pyUsuario.getReserva(), pyUsuario.getIva(), pyUsuario.getClaveIva(), pyUsuario.getLimiteCredito(), pyUsuario.getCreditoUtilizado(), pyUsuario.getTipoUsuario(), pyUsuario.getObservacion(), pyUsuario.getConPrecio(), pyUsuario.getAltadir(), pyUsuario.getUltimaVis());
//	}

	@Transactional(propagation = Propagation.MANDATORY)
	@Override
	public int deleteRow(PyUsuario entidad) throws SQLException {
		LOG.info("Borrando Usuario py_usuario-> " + entidad.getUsuarioNum());
		int respuesta = 1;

		sqlTot = PyUsuarioSQL.INACTIVAR_USUARIO.toString() + " where usuario_num in (" + entidad.getUsuarioNum() + ") ";

		jdbcTemplate.update(sqlTot);

		return respuesta;
	}

	@Transactional(propagation = Propagation.MANDATORY)
	@Override
	public int updateRow(PyUsuario entidad) throws SQLException {

		sqlTot = PyUsuarioSQL.UPDATE.toString();
		return jdbcTemplate.update(sqlTot, new Object[] { entidad.getUsuario(), Encriptacion.sha256(entidad.getPassword().trim()), entidad.getNombre(), entidad.getEmail(), entidad.getUsuarioNum(), entidad.getClienteNum(), entidad.getCustNum() });
	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public PyUsuario getByIdRow(PyUsuario pyUsuario) throws SQLException {

		sqlTot = PyUsuarioSQL.CONSULTA.toString() + " Where usuario_num = ? ";

		return jdbcTemplate.queryForObject(sqlTot, new PyUsuarioRowMapper(), pyUsuario.getUsuarioNum());
	}
	
	@Override
	public Integer countRow() throws SQLException {

		return new Integer(1);
	}

	@Override
	public List<PyUsuario> getAllRow() throws SQLException {

		return new ArrayList<PyUsuario>();
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public int getUsuarioNum() {
		int valor = 0;
		sqlTot = PyUsuarioSQL.GET_CONSECUTIVO.toString();

		SqlRowSet rs = jdbcTemplate.queryForRowSet(sqlTot);
		if (rs.next()) {
			valor = rs.getInt(3);
		}

		LOG.info("usuario_num: " + valor);
		return valor;

	}
	
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public PyUsuario getPyUsuarioPedidosEnc(String user, String password ) throws SQLException {
		user = user.toLowerCase();
		sqlTot = PyUsuarioSQL.CONSULTA.toString() + " Where cust_num=38000 AND (usuario = ? or email = ? ) And (password = ? OR password = ? )  And estatus = 'A' ";

		LOG.info("sql ->" + sqlTot);
		try {
			return jdbcTemplate.queryForObject(sqlTot, new PyUsuarioRowMapper(), user, user, password, Encriptacion.sha256(password));

		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public PyUsuario getPyUsuarioPedidos(String user, String password ) throws SQLException {
		user = user.toLowerCase();
		LOG.info("Usuario: " + user);
		LOG.info("Password: " + password);
		sqlTot = PyUsuarioSQL.CONSULTA.toString() + " Where cust_num=38000 AND (Lower(usuario) = ?  or Lower(email) = ? )And (password = ? OR password = ? )  And estatus = 'A' ";

		LOG.info("sql ->" + sqlTot);
		try {
			System.out.println(Encriptacion.sha256(password));
			return jdbcTemplate.queryForObject(sqlTot, new PyUsuarioRowMapper(), user, user, password, Encriptacion.sha256(password));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public PyUsuario getPyUsuarioPedidosClien(int clien) throws SQLException {
		sqlTot = PyUsuarioSQL.CONSULTA.toString() + " Where cust_num=38000 AND cliente_num = ? And estatus = 'A' ";
		LOG.info("sql ->" + sqlTot);
		try {
			return jdbcTemplate.queryForObject(sqlTot, new PyUsuarioRowMapper(), clien);

		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	@Override
	public String validaUsuario(String usuario) throws SQLException {
		sqlTot = PyUsuarioSQL.VALIDA_USUARIO_EXISTENTE.toString();
		String estatus = "N";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sqlTot, usuario, usuario);
		if(rs.next()) {
			estatus = (rs.getInt(1)>0) ? "S" : "N";
		}
		return estatus;
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public int actualizarPassword2(PyUsuario pyUsuario) {
		sqlTot = PyUsuarioSQL.ACTUALIZARPASSWORD2.toString();
		return jdbcTemplate.update(sqlTot,Encriptacion.sha256(pyUsuario.getPassword().trim()),pyUsuario.getEmail() );

	}
	
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public PyUsuario existeUsuario(String emailUF, long custNum) {
		try {
			sqlTot = PyUsuarioSQL.CONSULTA.toString() + " where email = ? and cust_num = ? and estatus = 'A' ";
			return jdbcTemplate.queryForObject(sqlTot, new PyUsuarioRowMapper(), emailUF, custNum);
		} catch (EmptyResultDataAccessException e) {
			LOG.info("No se encontro PyUsuario, SQL:" + sqlTot + ", email:" + emailUF + ",custNum:" + custNum);
		}
		
		return null;
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public PyUsuario getByUserUsuarioNum(Long usuarioNum) {
		PyUsuario entidad = new PyUsuario();
		
		sqlTot = PyUsuarioSQL.CONSULTA.toString() + " Where usuario_num = ? ";

		SqlRowSet rs = this.jdbcTemplate.queryForRowSet(sqlTot, new Object[] {usuarioNum});
		if (rs.next()) {
			entidad.setUsuarioNum(rs.getLong("usuario_num"));
			entidad.setClienteNum(rs.getLong("cliente_num"));
			entidad.setCustNum(rs.getLong("cust_num"));
			entidad.setUsuario(rs.getString("usuario").trim());
			entidad.setPassword(rs.getString("password").trim());
			entidad.setNombre(rs.getString("nombre").trim());
			entidad.setEmail(rs.getString("email").trim());
			entidad.setEstatus(rs.getString("estatus").trim());
			entidad.setReserva(rs.getString("reserva").trim());
			entidad.setIva(rs.getString("iva").trim());
			entidad.setClaveIva(rs.getString("clave_iva").trim());
			entidad.setLimiteCredito(rs.getDouble("limite_credito"));
			entidad.setCreditoUtilizado(rs.getDouble("credito_utilizado"));
			entidad.setTipoUsuario(rs.getString("tipo_usuario").trim());
			entidad.setObservacion(rs.getString("observacion").trim());
			entidad.setConPrecio(rs.getString("con_precio").trim());
			entidad.setAltadir(rs.getString("altadir").trim());
			entidad.setUltimaVis(rs.getString("ultima_vis").trim());
		}

		LOG.info("usuario_num: " + entidad.toString());
		return entidad;

	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public int insertPyUsuario(PyUsuario pyUsuario) throws SQLException {
		LOG.info("insertRow PyUsuario");

		sqlTot = PyUsuarioSQL.INSERT.toString();

		LOG.info(sqlTot);
		LOG.info(pyUsuario.toString());

		return this.jdbcTemplate.update(sqlTot, pyUsuario.getUsuarioNum(), pyUsuario.getClienteNum(), pyUsuario.getCustNum(), pyUsuario.getUsuario(), Encriptacion.sha256(pyUsuario.getPassword().trim()), pyUsuario.getNombre(), pyUsuario.getEmail(), pyUsuario.getEstatus(), pyUsuario.getReserva(), pyUsuario.getIva(), pyUsuario.getClaveIva(), pyUsuario.getLimiteCredito(), pyUsuario.getCreditoUtilizado(), pyUsuario.getTipoUsuario(), pyUsuario.getObservacion(), pyUsuario.getConPrecio(), pyUsuario.getAltadir(), pyUsuario.getUltimaVis());

	}
	
	@Override
	public int estatusUsuario(PyUsuario pyUsuario)  throws SQLException{
		sqlTot = PyUsuarioSQL.ESTATUS_USUARIO.toString();
		LOG.info("estatusUsuario: " + sqlTot);
		return this.jdbcTemplate.update(sqlTot, pyUsuario.getEstatus(), pyUsuario.getCustNum(), pyUsuario.getClienteNum(), pyUsuario.getUsuarioNum());
	}
}
