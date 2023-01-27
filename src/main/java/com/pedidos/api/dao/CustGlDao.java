package com.pedidos.api.dao;

import com.pedidos.api.comun.DAO;
import com.pedidos.api.model.CustGl;

public interface CustGlDao extends DAO<CustGl> {

	public CustGl prueba();
	
	public String getGlCode(String org_code,String div_code);
	
}
