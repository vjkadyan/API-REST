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

import com.pedidos.api.model.PyTelefonoCliente;
import com.pedidos.api.sql.PyTelefonoClienteSQL;
import com.pedidos.api.sql.rowmapper.PyTelefonoClienteRowMapper;

@Service
public class PyTelefonoClienteDaoImp implements PyTelefonoClienteDao {
	 
		private static final Logger LOG = Logger.getLogger(PyTelefonoClienteDaoImp.class);
		private String sqlTot = "";
		
		@Autowired
		private JdbcTemplate jdbcTemplate;

		@Override
		@Transactional(propagation = Propagation.MANDATORY)
		public void insertRow(PyTelefonoCliente entidad) throws SQLException {
			LOG.info("PyTelefonoClienteDaoImp.insertRow: ");
			sqlTot = PyTelefonoClienteSQL.INSERT.toString();
			//LOG.info(":" + entidad.getClienteNum() + ":" + entidad.getClienteNum() + ":" + entidad.getUsuarioNum() + ":" + entidad.getTelefono() + ":" + entidad.getExtension() + ":" + entidad.getTipoNum() + ":" + entidad.getStatus() + ":" + entidad.getRolNum() + ":");
			this.jdbcTemplate.update(sqlTot, entidad.getClienteNum(), entidad.getClienteNum(), entidad.getUsuarioNum(),
					entidad.getTelefono(), entidad.getExtension(), entidad.getTipoNum(),
					entidad.getStatus(), entidad.getRolNum());
		}

		@Override
		public int deleteRow(PyTelefonoCliente entidad) throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		@Transactional(propagation = Propagation.MANDATORY)
		public int updateRow(PyTelefonoCliente entidad) throws SQLException {
			LOG.info("PyTelefonoClienteDaoImp.updateRow: " + entidad.toString());
			sqlTot = PyTelefonoClienteSQL.UPDATE.toString() + " set telefono = ?, extension = ?, tipo_num = ?, fecha_registro = current where cliente_num = ? and usuario_num = ? and telefono_num = ?";
			return this.jdbcTemplate.update(sqlTot, entidad.getTelefono(), entidad.getExtension(), entidad.getTipoNum(), entidad.getClienteNum(), entidad.getUsuarioNum(), entidad.getTelNum());
		}

		@Override
		@Transactional(isolation = Isolation.READ_UNCOMMITTED)
		public PyTelefonoCliente getByIdRow(PyTelefonoCliente entidad) throws SQLException {
			LOG.info("PyTelefonoClienteDaoImp.getByIdRow: ");
			sqlTot = PyTelefonoClienteSQL.SELECT.toString() + " Where telefono_num = ? and cliente_num = ?";
			try {
				return this.jdbcTemplate.queryForObject(sqlTot, new Object[] { entidad.getTelNum(), entidad.getClienteNum() },
						new PyTelefonoClienteRowMapper());
			} catch (EmptyResultDataAccessException e) {
				return null;
			}
		}

		@Override
		public Integer countRow() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<PyTelefonoCliente> getAllRow() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		@Transactional(isolation = Isolation.READ_UNCOMMITTED)
		public List<PyTelefonoCliente> getListById(Long usuarioNum) throws SQLException {
			LOG.info("PyTelefonoClienteDaoImp.getListById: ");
			sqlTot = PyTelefonoClienteSQL.SELECT.toString() + " Where usuario_num = ? and status = 'A' order by telefono_num ";
			try {
				return this.jdbcTemplate.query(sqlTot, new Object[] { usuarioNum },
						new PyTelefonoClienteRowMapper());
			} catch (EmptyResultDataAccessException e) {
				return null;
			}
		}

	}
