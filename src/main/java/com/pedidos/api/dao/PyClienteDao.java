package com.pedidos.api.dao;

import com.pedidos.api.comun.DAO;
import com.pedidos.api.model.PyCliente;

public interface PyClienteDao extends DAO<PyCliente> {

	public int getClienteNumPedidos();
	
	public PyCliente ObtenerDatoscliente(long clienteNum);
	
	public boolean existePyCliente(String correo, long custNum);
}
