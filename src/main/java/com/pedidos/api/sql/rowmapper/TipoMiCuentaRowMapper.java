package com.pedidos.api.sql.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pedidos.api.comun.Cadena;
import com.pedidos.api.model.TipoMiCuenta;

public class TipoMiCuentaRowMapper implements RowMapper<TipoMiCuenta>{

	@Override
	public TipoMiCuenta mapRow(ResultSet rs, int arg1) throws SQLException {
		
		TipoMiCuenta tipoMiCuenta = new TipoMiCuenta();
		tipoMiCuenta.setClienteNum(rs.getLong("cliente_num"));
		tipoMiCuenta.setUsuarioNum(rs.getLong("usuario_num"));
		tipoMiCuenta.setNombre(Cadena.filtra(rs.getString("nombre")));
		tipoMiCuenta.setApellido(Cadena.filtra(rs.getString("apellido")));
		tipoMiCuenta.setEmpresa(Cadena.filtra(rs.getString("empresa")));
		tipoMiCuenta.setFechaNac(Cadena.filtra(rs.getString("fecha_nac")));
		tipoMiCuenta.setFechaReg(Cadena.filtra(rs.getString("fecha_reg")));
		tipoMiCuenta.setEnviaMsg(Cadena.filtra(rs.getString("envia_msg")));
		tipoMiCuenta.setEntregaCliente(Cadena.filtra(rs.getString("entrega_clientes")));
		tipoMiCuenta.setTipoCuenta(Cadena.filtra(rs.getString("tipo_cuenta")));
		tipoMiCuenta.setTelefonoPrinc(Cadena.filtra(rs.getString("telefono_princ")));
		tipoMiCuenta.setCelularPrinc(Cadena.filtra(rs.getString("celular_princ")));
		return tipoMiCuenta;
	}

}