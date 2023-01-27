package com.pedidos.api.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pedidos.api.model.TipoMiCuenta;
import com.pedidos.api.sql.TipoMiCuentaSQL;
import com.pedidos.api.sql.rowmapper.TipoMiCuentaRowMapper;

@Service
public class TipoMiCuentaDaoImp implements TipoMiCuentaDao {

	private static final Logger LOG = Logger.getLogger(TipoMiCuentaDaoImp.class);
	private String sqlTot = ""; 
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void insertRow(TipoMiCuenta entidad) throws SQLException {
		LOG.info("TipoMiCuentaDaoImp.insertRow: ");
		sqlTot = TipoMiCuentaSQL.INSERT.toString();
		this.jdbcTemplate.update(sqlTot, entidad.getClienteNum(), entidad.getUsuarioNum(), entidad.getNombre(),
				entidad.getApellido(), entidad.getEmpresa(), entidad.getFechaNac(), "N", "N", entidad.getTipoCuenta());
	}

	@Override
	public int deleteRow(TipoMiCuenta entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public int updateRow(TipoMiCuenta entidad) throws SQLException {
		LOG.info("TipoMiCuentaDaoImp.updateRow: ");
		sqlTot = TipoMiCuentaSQL.UPDATE.toString()
				+ "set envia_msg = ? , entrega_clientes = ? , telefono_princ = ? , celular_princ = ? where usuario_num = ? ";
		return this.jdbcTemplate.update(sqlTot, entidad.getEnviaMsg(), entidad.getEntregaCliente(),
				entidad.getTelefonoPrinc(), entidad.getCelularPrinc(), entidad.getUsuarioNum());
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public int actualizaDatos(TipoMiCuenta entidad) throws SQLException {
		LOG.info("TipoMiCuentaDaoImp.actualizaDatos: " + entidad.toString());
		sqlTot = TipoMiCuentaSQL.UPDATE.toString()
				+ " set nombre = ?, apellido = ?, empresa = ?, fecha_nac = ? where usuario_num = ? ";
		LOG.info(sqlTot);
		return this.jdbcTemplate.update(sqlTot, entidad.getNombre(), entidad.getApellido(), entidad.getEmpresa(), entidad.getFechaNac(), entidad.getUsuarioNum());
	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public TipoMiCuenta getByIdRow(TipoMiCuenta entidad) throws SQLException {
		LOG.info("TipoMiCuentaDaoImp.getByIdRow: " + entidad.toString());
		sqlTot = TipoMiCuentaSQL.SELECT.toString();
		sqlTot += " Where cliente_num = ?";
		try {
			return this.jdbcTemplate.queryForObject(sqlTot, new TipoMiCuentaRowMapper(),
					new Object[] { entidad.getClienteNum() });
		} catch (EmptyResultDataAccessException e) {
			return new TipoMiCuenta();
		}
	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public TipoMiCuenta getByCliente(Long clienteNum) throws SQLException {
		LOG.info("TipoMiCuentaDaoImp.getByCliente: " + clienteNum);
		sqlTot = TipoMiCuentaSQL.SELECT.toString();
		sqlTot += " Where cliente_num = ?";
		try {
			return this.jdbcTemplate.queryForObject(sqlTot, new TipoMiCuentaRowMapper(),
					new Object[] { clienteNum });
		} catch (EmptyResultDataAccessException e) {
			return new TipoMiCuenta();
		}
	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public TipoMiCuenta getByUsuario(Long usuarioNum) throws SQLException {
		LOG.info("TipoMiCuentaDaoImp.getByUsuario: " + usuarioNum);
		sqlTot = TipoMiCuentaSQL.SELECT.toString();
		sqlTot += " Where usuario_num = ?";
		try {
			return this.jdbcTemplate.queryForObject(sqlTot, new TipoMiCuentaRowMapper(),
					new Object[] { usuarioNum });
		} catch (EmptyResultDataAccessException e) {
			return new TipoMiCuenta();
		}
	}

	@Override
	public Integer countRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoMiCuenta> getAllRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateAdmin(TipoMiCuenta entidadTCA, long usuarioNum) throws SQLException {
		sqlTot = TipoMiCuentaSQL.UPDATE.toString() + " set usuario_num = ?, nombre = ?, apellido = ?, celular_princ = ?, telefono_princ = ? where usuario_num = ? ";
		int rows = this.jdbcTemplate.update(sqlTot,entidadTCA.getUsuarioNum(),entidadTCA.getNombre(),entidadTCA.getApellido(),entidadTCA.getCelularPrinc(),entidadTCA.getTelefonoPrinc(),usuarioNum);

		return rows;
	}

}
