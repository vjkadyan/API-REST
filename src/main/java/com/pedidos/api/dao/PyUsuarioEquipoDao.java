package com.pedidos.api.dao;

import java.sql.SQLException;
import java.util.List;

import com.pedidos.api.comun.DAO;
import com.pedidos.api.model.CorreosUsuario;
import com.pedidos.api.model.PyUsuarioEquipo;

public interface PyUsuarioEquipoDao extends DAO<PyUsuarioEquipo> {

	public String getTipoUsuario(long usuarioNum);
	public String obtieneIdentificador(long usuarioNum) throws SQLException;
	public int updateColor(PyUsuarioEquipo pyUsuarioE);
	public int estatusUsuario(long usuarioMod, String estatus) throws SQLException;
	public PyUsuarioEquipo getByUsuario(long usuarioNum) throws SQLException;

}
