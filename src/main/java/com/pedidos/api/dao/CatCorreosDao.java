package com.pedidos.api.dao;

import java.sql.SQLException;
import java.util.List;

import com.pedidos.api.comun.DAO;
import com.pedidos.api.model.CatCorreos;

public interface CatCorreosDao extends DAO<CatCorreos>{
	public List<CatCorreos> getCorreos(String correos) throws SQLException;
}