package com.pedidos.api.dao;

import java.sql.SQLException;
import java.util.List;

import com.pedidos.api.comun.DAO;
import com.pedidos.api.model.CorreosUsuario;
import com.pedidos.api.model.ModulosUsuario;
import com.pedidos.api.model.ObtieneMiEquipo;

public interface ObtieneMiEquipoDao extends DAO<ObtieneMiEquipo>{
	
	public int getAccionUsuario(long usuarioNum, String tipoUsuario) throws SQLException;
	public List<ModulosUsuario> getModulosUsuario(long usuarioNum, String tipoUsuario) throws SQLException;
	public List<CorreosUsuario> getCorreosUsuario(long usuarioNum, String tipoUsuario) throws SQLException;
	public long perteneceEquipo(String correo, long usuarioNum) throws SQLException;

}
