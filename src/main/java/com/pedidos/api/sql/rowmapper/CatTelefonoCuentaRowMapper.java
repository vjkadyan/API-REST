package com.pedidos.api.sql.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pedidos.api.comun.Cadena;
import com.pedidos.api.model.CatTelefonoCuenta;

public class CatTelefonoCuentaRowMapper implements RowMapper<CatTelefonoCuenta> {

	@Override
	public CatTelefonoCuenta mapRow(ResultSet rs, int rowNum) throws SQLException {
		CatTelefonoCuenta catTelefonoCuenta = new CatTelefonoCuenta();
		catTelefonoCuenta.setTipoNum(rs.getInt("tipo_num"));
		catTelefonoCuenta.setTipo(Cadena.filtra(rs.getString("tipo")));
		catTelefonoCuenta.setStatus(Cadena.filtra(rs.getString("status")));
		return catTelefonoCuenta;
	}

}
