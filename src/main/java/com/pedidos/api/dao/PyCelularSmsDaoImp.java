package com.pedidos.api.dao;

import java.sql.SQLException;
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

import com.pedidos.api.model.PyCelularSms;
import com.pedidos.api.sql.PyCelularSmsSQL;
import com.pedidos.api.sql.rowmapper.PyCelularSmsRowMapper;

@Service
public class PyCelularSmsDaoImp implements PyCelularSmsDao {
	 
		private static final Logger LOG = Logger.getLogger(PyCelularSmsDaoImp.class);
		private String sqlTot = "";
		
		@Autowired
		private JdbcTemplate jdbcTemplate;

		@Override
		@Transactional(propagation = Propagation.MANDATORY)
		public void insertRow(PyCelularSms entidad) throws SQLException {
			LOG.info("PyCelularSmsDaoApi.insertRow: " + entidad.toString());
			sqlTot = PyCelularSmsSQL.INSERT.toString();
			this.jdbcTemplate.update(sqlTot, entidad.getCelular_num(), entidad.getCliente_num(), entidad.getCelular(), entidad.getStatus());
		}

		@Override
		public int deleteRow(PyCelularSms entidad) throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		@Transactional(propagation = Propagation.MANDATORY)
		public int updateRow(PyCelularSms entidad) throws SQLException {
			LOG.info("PyCelularSmsDaoImp.updateRow: ");
			sqlTot = PyCelularSmsSQL.UPDATE.toString() + " set celular = ?, fecha_registro = current where cliente_num = ? and celular_num = ?";
			return this.jdbcTemplate.update(sqlTot, entidad.getCelular(), entidad.getCliente_num(), entidad.getCelular_num());
		}

		@Override
		@Transactional(isolation = Isolation.READ_UNCOMMITTED)
		public PyCelularSms getByIdRow(PyCelularSms entidad) throws SQLException {
			LOG.info("PyCelularSms.getByIdRow: " + entidad.toString());
			sqlTot = PyCelularSmsSQL.SELECT.toString();
			sqlTot += " Where celular_num = ? and cliente_num = ? ";
			try {
				return this.jdbcTemplate.queryForObject(sqlTot, new PyCelularSmsRowMapper(),
						new Object[] { entidad.getCelular_num(), entidad.getCliente_num()});
			} catch (EmptyResultDataAccessException e) {
				return null;
			}
		}
		
		@Override
		@Transactional(isolation = Isolation.READ_UNCOMMITTED)
		public List<PyCelularSms> getByIdRow(Long cliente_num) throws SQLException {
			LOG.info("PyCelularSms.getByIdRow: " + cliente_num);
			sqlTot = PyCelularSmsSQL.SELECT.toString();
			sqlTot += " Where cliente_num = ? and status = 'A' order by celular_num  ";
			try {
				return this.jdbcTemplate.query(sqlTot, new PyCelularSmsRowMapper(), new Object[] { cliente_num });
			} catch (EmptyResultDataAccessException e) {
				return null;
			}
		}
		
		@Override
		@Transactional(isolation = Isolation.READ_UNCOMMITTED)
		public int getConsec(Long cliente_num) throws SQLException {
			LOG.info("PyCelularSms.getConsec: " + cliente_num);
			sqlTot = PyCelularSmsSQL.CONSEC_ID.toString();
			try {
				SqlRowSet rs = this.jdbcTemplate.queryForRowSet(sqlTot, cliente_num);
				if(rs.next()) {
					return rs.getInt("celular_num");
				}else {
					return 1;
				}
			} catch (EmptyResultDataAccessException e) {
				return 100000;
			}
		}

		@Override
		public Integer countRow() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<PyCelularSms> getAllRow() throws SQLException {
			LOG.info("PyCelularSmsDaoImp.getByIdRow: ");
			sqlTot = PyCelularSmsSQL.SELECT.toString();
			sqlTot += " Where status = 'A' ";
			try {
				return this.jdbcTemplate.query(sqlTot, new PyCelularSmsRowMapper());
			} catch (EmptyResultDataAccessException e) {
				return null;
			}
		}
	}
