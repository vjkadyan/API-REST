package com.pedidos.api.dao;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.pedidos.api.model.CarritoPedidos;
import com.pedidos.api.model.CarritoPedidosItems;
import com.pedidos.api.model.PyEnvioGratis;
import com.pedidos.api.model.PyPedidoDet;
import com.pedidos.api.sql.PyEnvioGratisSQL;

@Service
public class PyEnvioGratisDaoImpl implements PyEnvioGratisDao{
	
	private static Logger log = Logger.getLogger(PyEnvioGratisDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;	
	
	String sql = ""; 

	@Override
	public void insertRow(PyEnvioGratisDao entidad) throws SQLException {
		// TODO Auto-generated method stub 
		
	}

	@Override
	public int deleteRow(PyEnvioGratisDao entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRow(PyEnvioGratisDao entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PyEnvioGratisDao getByIdRow(PyEnvioGratisDao entidad) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PyEnvioGratisDao> getAllRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validaEnvioGratis(CarritoPedidos carritoPedidos) {
		// TODO Auto-generated method stub
		boolean envio = false;
		
		//recorro el objeto para buscar los items en py_envio_gratis
		for(CarritoPedidosItems items : carritoPedidos.getItems()) {
			if(!(items.getItem().indexOf("ZZZ") == 0 || items.getItem().indexOf("CON-REG") == 0)) {
				PyEnvioGratis pyEnvioGratis = new PyEnvioGratis();
				pyEnvioGratis.setItemNum(items.getItem());
				pyEnvioGratis = getByItem(pyEnvioGratis);

				if(pyEnvioGratis.getEnvioGratis() == null) {
					return false;
				}else {
					if(pyEnvioGratis.getEnvioGratis().equals("Y")) {
					envio = true;
					}else {
						return false;
					}
				}
				
				log.info("itemEnvio: " + items.getItem() + " envio: " + envio);
			}
			
		}
		
		return envio;
	}

	@Override
	public PyEnvioGratis getByItem(PyEnvioGratis pyEnvioGratis) {
		// TODO Auto-generated method stub
		PyEnvioGratis bean = new PyEnvioGratis();
		sql = PyEnvioGratisSQL.CONSULTA.toString();
		String where = "item_num = '" + pyEnvioGratis.getItemNum() + "'";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, where);
		
		if(rs.next()) {
			bean.setItemNum(rs.getString(1));
			bean.setEnvioGratis(rs.getString(2));
			bean.setFechaAct(rs.getDate(3));
			bean.setUser(rs.getString(4));
		}

		return bean;
	}

	@Override
	public boolean validaEnvioGratisReserv(List<PyPedidoDet> items) {
		// TODO Auto-generated method stub
		
		boolean envio = false;
		
		for (PyPedidoDet item : items) {
			if(!(item.getItemNum().indexOf("ZZZ") == 0 || item.getItemNum().indexOf("CON-REG") == 0)) {
				PyEnvioGratis pyEnvioGratis = new PyEnvioGratis();
				pyEnvioGratis.setItemNum(item.getItemNum());
				pyEnvioGratis = getByItem(pyEnvioGratis);

				if(pyEnvioGratis.getEnvioGratis() == null) {
					return false;
				}else {
					if(pyEnvioGratis.getEnvioGratis().equals("Y")) {
					envio = true;
					}else {
						return false;
					}
				}			
				log.info("itemEnvio: " + item.getItemNum() + " envio: " + envio);
			}
			
		}
		
		return envio;
	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public Map<String, String> obtieneActivos() {
		Map<String, String> mapEnvios = new HashMap<String, String>();
		sql = PyEnvioGratisSQL.CONSULTA_ACTIVOS + "";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
		while(rs.next()) {
			mapEnvios.put(rs.getString(1).trim(), rs.getString(2).trim());
		}
		return mapEnvios;
	}

}
