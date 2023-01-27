package com.pedidos.api.dao;

import java.sql.SQLException;

import com.pedidos.api.comun.DAO;
import com.pedidos.api.model.PermisosModulos;

public interface PermisosModulosDao extends DAO<PermisosModulos>{

	public int estatusUsuario(long usuarioMod, String estatus) throws SQLException;

	public int deleteByUsuario(long usuarioNum) throws SQLException;

}
