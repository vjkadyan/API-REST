package com.pedidos.api.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.pedidos.api.model.Afiliacion;
import com.pedidos.api.sql.AfiliacionSQL;

@Service
public class AfiliacionDAOImp implements AfiliacionDAO{
	
	private static final Logger LOG = Logger.getLogger(AfiliacionDAOImp.class);
	
	private static String sqlTot;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public Afiliacion getAfiliacionCliente(int clienteNum) {
		Afiliacion afiliacion= null;
		sqlTot = AfiliacionSQL.GET_AFILIACION_CLIENTE.toString();
		sqlTot += " and cliente_num ="+clienteNum;
	
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sqlTot);
		if(rs.next()) {
			afiliacion = new Afiliacion();
			afiliacion.setCliente_num(rs.getInt("cliente_num"));
			afiliacion.setDescripcion(rs.getString("descripcion"));
			afiliacion.setEstatus(rs.getString("estatus"));
			afiliacion.setNombre_afiliacion(rs.getString("nombre_afiliacion"));
			afiliacion.setNum_afiliacion(rs.getLong("num_afiliacion"));
		}
		return afiliacion;
	}

}
