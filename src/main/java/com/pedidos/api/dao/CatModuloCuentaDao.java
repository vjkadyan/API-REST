package com.pedidos.api.dao;

import java.sql.SQLException;
import java.util.List;

import com.pedidos.api.comun.DAO;
import com.pedidos.api.model.CatModuloCuenta;

public interface CatModuloCuentaDao extends DAO<CatModuloCuenta>{
	 
		public CatModuloCuenta getByIdRow(int moduloNum) throws SQLException;
		public List<CatModuloCuenta> listaModulos(String modulos) throws SQLException;

	}
