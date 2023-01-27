package com.pedidos.api.dao;

import java.util.Map;

import com.pedidos.api.comun.DAO;

public interface PyItemDescuentoDao extends DAO<PyItemDescuentoDao>{

	public Map<String, Double> obtieneDescuentos();
	public Map<String, String> obtieneRegalos();
}
