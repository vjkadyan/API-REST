package com.pedidos.api.dao;

import java.util.Map;

import com.pedidos.api.comun.DAO;
import com.pedidos.api.model.PySearch;

public interface PySearchDao extends DAO<PySearch> {

	public Map<String, PySearch> obtieneListaPySearch(String itemsFavoritos);
 
}