package com.pedidos.api.dao;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.pedidos.api.model.PySearch;
import com.pedidos.api.sql.PySearchSQL;
import com.pedidos.api.sql.rowmapper.PySearchRowMapper;

@Service
public class PySearchDaoImp implements PySearchDao {
 
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final Logger LOG = Logger.getLogger(PySearchDaoImp.class);
	private String sqlTot = "";
	
	@Override
	public void insertRow(PySearch entidad) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteRow(PySearch entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRow(PySearch entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public PySearch getByIdRow(PySearch entidad) throws SQLException {
		LOG.info("PySearchDaoImp:getByIdRow  " + entidad.toString());
		sqlTot = PySearchSQL.SELECT.toString() + "where item_num = ? ";
		try {
			return jdbcTemplate.queryForObject(sqlTot, new PySearchRowMapper(),
					new Object[] { entidad.getItemNum() });
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
	public List<PySearch> getAllRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public Map<String, PySearch> obtieneListaPySearch(String itemsFavoritos) {
		Map<String, PySearch> mapaFavoritos = new HashMap<String, PySearch>();
		
		sqlTot = PySearchSQL.SELECT.toString() + "where item_num in ("+ itemsFavoritos +")";
		
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sqlTot);
		
		while(rs.next()) {
			PySearch beanPySearch = new PySearch();
			beanPySearch.setItemNum(rs.getString(1).trim());
			beanPySearch.setNumParte(rs.getString(2).trim());
			beanPySearch.setTituloCompuesto(rs.getString(3).trim());
			beanPySearch.setUrl(rs.getString(4).trim());
			beanPySearch.setMarca(rs.getString(5).trim());
			beanPySearch.setLineaNeg(rs.getString(6).trim());
			beanPySearch.setCodFamilia(rs.getString(7).trim());
			beanPySearch.setCodSubfamilia(rs.getString(8).trim());
			beanPySearch.setVolume(rs.getDouble(9));
			beanPySearch.setNetWeigth(rs.getDouble(10));
			beanPySearch.setPrecioDeLista(rs.getDouble(12));
			beanPySearch.setIva(rs.getDouble(13));
			beanPySearch.setProveedorExterno(rs.getString(15).trim());
			beanPySearch.setSoloDf(rs.getString(16).trim());
			beanPySearch.setPonderacion(rs.getInt(17));
			beanPySearch.setEstrella(rs.getInt(18));
			beanPySearch.setAplicaExpress(rs.getString(19).trim());
			beanPySearch.setEstatus(rs.getString(20).trim());
			
			mapaFavoritos.put(rs.getString(1).trim(), beanPySearch);
		}
		return mapaFavoritos;
	}

}
