package com.pedidos.api.sql.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pedidos.api.comun.Cadena;
import com.pedidos.api.model.PyTelefonoCliente;

public class PyTelefonoClienteRowMapper implements RowMapper<PyTelefonoCliente> {

	@Override
	public PyTelefonoCliente mapRow(ResultSet rs, int rowMun) throws SQLException {
		PyTelefonoCliente pyTelefonoCliente = new PyTelefonoCliente();
		pyTelefonoCliente.setTelNum(rs.getInt("telefono_num"));
		pyTelefonoCliente.setClienteNum(rs.getLong("cliente_num"));
		pyTelefonoCliente.setUsuarioNum(rs.getLong("usuario_num"));
		pyTelefonoCliente.setTelefono(Cadena.filtra(rs.getString("telefono")));
		pyTelefonoCliente.setExtension(Cadena.filtra(rs.getString("extension")));
		pyTelefonoCliente.setTipoNum(rs.getInt("tipo_num"));
		pyTelefonoCliente.setFechaRegistro(Cadena.filtra(rs.getString("fecha_registro")));
		pyTelefonoCliente.setStatus(Cadena.filtra(rs.getString("status")));
		pyTelefonoCliente.setRolNum(rs.getInt("rol_num"));
		return pyTelefonoCliente;
	}

}