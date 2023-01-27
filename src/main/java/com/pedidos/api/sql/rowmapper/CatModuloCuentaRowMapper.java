package com.pedidos.api.sql.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pedidos.api.comun.Cadena;
import com.pedidos.api.model.CatModuloCuenta;

public class CatModuloCuentaRowMapper implements RowMapper<CatModuloCuenta> {

	@Override
	public CatModuloCuenta mapRow(ResultSet rs, int rowNum) throws SQLException {
		CatModuloCuenta catModuloCuenta = new CatModuloCuenta();
		catModuloCuenta.setModuloNum(rs.getInt("modulo_num"));
		catModuloCuenta.setNombreMod(Cadena.filtra(rs.getString("nombre_mod")));
		catModuloCuenta.setClave(Cadena.filtra(rs.getString("clave")));
		catModuloCuenta.setUrl(Cadena.filtra(rs.getString("url")));
		catModuloCuenta.setImg(Cadena.filtra(rs.getString("img")));
		catModuloCuenta.setStatus(Cadena.filtra(rs.getString("status")));
		return catModuloCuenta;
	}

}
