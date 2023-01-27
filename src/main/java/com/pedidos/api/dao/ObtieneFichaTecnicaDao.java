package com.pedidos.api.dao;

import java.sql.SQLException;

import org.json.JSONObject;

public interface ObtieneFichaTecnicaDao {
	
	public boolean esFavorito(String item_num, long cliente_num);
	
	public void guardaVisto(String item_num, long cliente_num) throws SQLException;
	
	JSONObject obtieneItemCompleto(String url, int cliente_num) throws SQLException;
}
