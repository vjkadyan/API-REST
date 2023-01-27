package com.pedidos.api.sql.rowmapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pedidos.api.comun.Cadena;
import com.pedidos.api.model.PySearch;

public class PySearchRowMapper implements RowMapper<PySearch> {

	@Override
	public PySearch mapRow(ResultSet rs, int rowNum) throws SQLException {
		PySearch pySearch = new PySearch();
		pySearch.setItemNum(Cadena.filtra(rs.getString("item_num")));
		pySearch.setNumParte(Cadena.filtra(rs.getString("num_parte")));
		pySearch.setTituloCompuesto(Cadena.filtra(rs.getString("titulo_compuesto")));
		pySearch.setUrl(Cadena.filtra(rs.getString("url")));
		pySearch.setMarca(Cadena.filtra(rs.getString("marca")));
		pySearch.setLineaNeg(Cadena.filtra(rs.getString("linea_neg")));
		pySearch.setCodFamilia(Cadena.filtra(rs.getString("cod_familia")));
		pySearch.setCodSubfamilia(Cadena.filtra(rs.getString("cod_subfamilia")));
		pySearch.setVolume(rs.getDouble("volume"));
		pySearch.setNetWeigth(rs.getDouble("net_weigth"));
		pySearch.setPrecio(rs.getDouble("precio"));
		pySearch.setPrecioDeLista(rs.getDouble("precio_de_lista"));
		pySearch.setIva(rs.getDouble("iva"));
		pySearch.setDisponibilidad(rs.getInt("disponibilidad"));
		pySearch.setProveedorExterno(Cadena.filtra(rs.getString("proveedorExterno")));
		pySearch.setSoloDf(Cadena.filtra(rs.getString("solo_df")));
		pySearch.setPonderacion(rs.getInt("ponderacion"));
		pySearch.setEstrella(rs.getInt("estrella"));
		pySearch.setAplicaExpress(Cadena.filtra(rs.getString("aplica_express")));
		pySearch.setEstatus(Cadena.filtra(rs.getString("estatus")));
		
		return pySearch;
	}

}