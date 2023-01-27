package com.pedidos.api.dao;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.pedidos.api.model.CatModuloCuenta;
import com.pedidos.api.sql.CatModuloCuentaSQL;
import com.pedidos.api.sql.rowmapper.CatModuloCuentaRowMapper;

@Service
public class CatModuloCuentaDaoImp implements CatModuloCuentaDao {
	 
		private static final Logger LOG = Logger.getLogger(CatModuloCuentaDaoImp.class);
		private String sqlTot = "";
		
		
		@Autowired
		private JdbcTemplate jdbcTemplate;

		@Override
		public void insertRow(CatModuloCuenta entidad) throws SQLException {
			LOG.info("CatModuloCuentaDaoImp.insertRow: ");
			sqlTot = CatModuloCuentaSQL.INSERT.toString();
			this.jdbcTemplate.update(sqlTot, entidad.getModuloNum(), entidad.getNombreMod(), entidad.getClave(),
					entidad.getUrl(), entidad.getImg(), entidad.getStatus()); 
		}

		@Override
		public int deleteRow(CatModuloCuenta entidad) throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int updateRow(CatModuloCuenta entidad) throws SQLException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public CatModuloCuenta getByIdRow(CatModuloCuenta entidad) throws SQLException {
			LOG.info("CatModuloCuentaDaoImp.getByIdRow: ");
			sqlTot = CatModuloCuentaSQL.SELECT_MODULO.toString();
			try {
				return this.jdbcTemplate.queryForObject(sqlTot, new Object[] { entidad.getModuloNum() },
						new CatModuloCuentaRowMapper());
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
		public List<CatModuloCuenta> getAllRow() throws SQLException {
			LOG.info("CatModuloCuentaDaoImp.getAllRow: ");
			sqlTot = CatModuloCuentaSQL.SELECT_STATUS.toString();
			try {
				return this.jdbcTemplate.query(sqlTot, new CatModuloCuentaRowMapper());
			} catch (EmptyResultDataAccessException e) {
				return null;
			}
		}
		
		@Override
		public CatModuloCuenta getByIdRow(int moduloNum) throws SQLException {
			LOG.info("CatModuloCuentaDaoImp.getByIdRow: ");
			sqlTot = CatModuloCuentaSQL.SELECT_MODULO.toString();
			try {
				return this.jdbcTemplate.queryForObject(sqlTot, new Object[] { moduloNum },
						new CatModuloCuentaRowMapper());
			} catch (EmptyResultDataAccessException e) {
				return null;
			}
		}

		@Override
		public List<CatModuloCuenta> listaModulos(String modulos) throws SQLException {
			sqlTot = CatModuloCuentaSQL.SELECT_CVE.toString()+" where clave in ("+modulos+")";
			LOG.info("listaModulos: " + sqlTot);
			try
			{
				SqlRowSet rs = this.jdbcTemplate.queryForRowSet(sqlTot);
				List<CatModuloCuenta> listaModulos = new LinkedList<CatModuloCuenta>();
				CatModuloCuenta modulo = null;
				while(rs.next())
				{
					modulo = null;
					modulo = new CatModuloCuenta();
					modulo.setModuloNum(rs.getInt("modulo_num"));
					modulo.setNombreMod(rs.getString("nombre_mod"));
					modulo.setClave(rs.getString("clave"));
					modulo.setUrl(rs.getString("url"));
					modulo.setImg(rs.getString("img"));
					modulo.setStatus(rs.getString("status"));
					listaModulos.add(modulo);
				}
				return listaModulos;
			} 
			catch (EmptyResultDataAccessException e) 
			{
				return null;
			}
		}

	}
