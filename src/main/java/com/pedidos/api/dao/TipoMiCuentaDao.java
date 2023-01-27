package com.pedidos.api.dao;

import java.sql.SQLException;

import com.pedidos.api.comun.DAO;
import com.pedidos.api.model.TipoMiCuenta;

public interface TipoMiCuentaDao extends DAO<TipoMiCuenta>{
	 
		public TipoMiCuenta getByCliente(Long clienteNum) throws SQLException;
		public int actualizaDatos(TipoMiCuenta entidad) throws SQLException;
		public TipoMiCuenta getByUsuario(Long usuarioNum) throws SQLException;
		public int updateAdmin(TipoMiCuenta entidadTCA, long usuarioNum) throws SQLException;
	}
