package com.pedidos.api.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.pedidos.api.model.CatTelefonoCuenta;
import com.pedidos.api.sql.CatTelefonoCuentaSQL;
import com.pedidos.api.sql.rowmapper.CatTelefonoCuentaRowMapper;

@Service
public class CatTelefonoCuentaDaoImp implements CatTelefonoCuentaDao{
	 
		private static final Logger LOG = Logger.getLogger(CatTelefonoCuentaDaoImp.class);
		private String sqlTot = "";
		
		@Autowired
		private JdbcTemplate jdbcTemplate;
		
		@Override
		public void insertRow(CatTelefonoCuenta entidad) throws SQLException {
			LOG.info("CatTelefonoCuentaDaoImp.insertRow: ");
			sqlTot = CatTelefonoCuentaSQL.INSERT.toString();
			this.jdbcTemplate.update(sqlTot, entidad.getTipoNum(), entidad.getTipo(), entidad.getStatus());
		}

		@Override
		public int deleteRow(CatTelefonoCuenta entidad) throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int updateRow(CatTelefonoCuenta entidad) throws SQLException {
			LOG.info("CatTelefonoCuentaDaoImp.updateRow: ");
			sqlTot = CatTelefonoCuentaSQL.UPDATE.toString() + "  ";
			return this.jdbcTemplate.update(sqlTot, "");
		}

		@Override
		public CatTelefonoCuenta getByIdRow(CatTelefonoCuenta entidad) throws SQLException {
			LOG.info("CatTelefonoCuentaDaoImp.getByIdRow: ");
			sqlTot = CatTelefonoCuentaSQL.SELECT.toString()+ " Where tipo_num = ? ";
			try {
				return this.jdbcTemplate.queryForObject(sqlTot,new Object[] { entidad.getTipoNum() },
						new CatTelefonoCuentaRowMapper());
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
		public List<CatTelefonoCuenta> getAllRow() throws SQLException {
			sqlTot = CatTelefonoCuentaSQL.SELECT.toString() + " Where status = 'A' ";
			try {
				return this.jdbcTemplate.query(sqlTot,new CatTelefonoCuentaRowMapper());
			} catch (EmptyResultDataAccessException e) {
				return null;
			}
		}

	}
