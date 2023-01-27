package com.pedidos.api.dao;

import java.sql.SQLException;
import java.util.List;

import com.pedidos.api.comun.DAO;
import com.pedidos.api.model.PyTelefonoCliente;

public interface PyTelefonoClienteDao extends DAO<PyTelefonoCliente>{
	 
		public List<PyTelefonoCliente> getListById(Long clienteNum) throws SQLException;

	}
