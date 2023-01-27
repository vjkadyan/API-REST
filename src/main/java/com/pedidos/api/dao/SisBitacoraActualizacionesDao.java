package com.pedidos.api.dao;

import java.sql.SQLException;

import com.pedidos.api.comun.DAO;
import com.pedidos.api.model.SisBitacoraActualizaciones;

public interface SisBitacoraActualizacionesDao extends DAO<SisBitacoraActualizaciones> {

	public int insertarBitacora(SisBitacoraActualizaciones entidad) throws SQLException;
}
