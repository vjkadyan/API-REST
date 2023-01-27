package com.pedidos.api.sql.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pedidos.api.comun.Cadena;
import com.pedidos.api.model.PyCelularSms;

public class PyCelularSmsRowMapper implements RowMapper<PyCelularSms>{

	@Override
	public PyCelularSms mapRow(ResultSet rs, int arg) throws SQLException {
		
		PyCelularSms pyCelularSms = new PyCelularSms();
		pyCelularSms.setCelular_num(rs.getInt("celular_num"));
		pyCelularSms.setCliente_num(rs.getLong("cliente_num"));
		pyCelularSms.setFecha_registro(Cadena.filtra(rs.getString("fecha_registro")));
		pyCelularSms.setCelular(Cadena.filtra(rs.getString("celular")));
		pyCelularSms.setStatus(Cadena.filtra(rs.getString("status")));
		
		return pyCelularSms;
	}

}
