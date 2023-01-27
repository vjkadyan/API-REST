package com.pedidos.api.dao;


import java.util.List;
import java.util.Map;

import com.pedidos.api.comun.DAO;
import com.pedidos.api.model.CarritoPedidos;
import com.pedidos.api.model.PyEnvioGratis;
import com.pedidos.api.model.PyPedidoDet;


public interface PyEnvioGratisDao extends DAO<PyEnvioGratisDao> {

	public boolean validaEnvioGratis(CarritoPedidos carritoPedidos);
	
	public PyEnvioGratis getByItem(PyEnvioGratis pyEnvioGratis);

	public boolean validaEnvioGratisReserv(List<PyPedidoDet> items);
	
	public Map<String, String> obtieneActivos();
}