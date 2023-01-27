package com.pedidos.api.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CampoEntidadDao {

	public <E> E CampoEntidad(Class<E> tipo, Object nombre, ResultSet rs) throws IllegalArgumentException, IllegalAccessException, SQLException;

	public void mensaje();
}
