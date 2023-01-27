package com.pedidos.api.dao;

import java.util.List;

import com.pedidos.api.comun.DAO;
import com.pedidos.api.model.PyLayoutEjecutiva;

public interface PyLayoutEjecutivaDao extends DAO<PyLayoutEjecutiva>{

	public PyLayoutEjecutiva getByDate(PyLayoutEjecutiva entidad);
	public List<PyLayoutEjecutiva> getAllCliente(long clienteNum, int empleadoNum);
	public int insertResenaEjecutivo(PyLayoutEjecutiva ejecutivo);
	
}