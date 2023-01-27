package com.pedidos.api.dao;

import java.sql.SQLException;

import com.pedidos.api.comun.DAO;
import com.pedidos.api.model.PyUsuario;

public interface PyUsuarioDao extends DAO<PyUsuario>{
	public int getUsuarioNum();
	PyUsuario getPyUsuarioPedidosEnc(String user, String password) throws SQLException;
	public PyUsuario getPyUsuarioPedidos(String user,String password) throws SQLException;
	public PyUsuario getPyUsuarioPedidosClien(int clien) throws SQLException;
	public String validaUsuario(String usuario) throws SQLException;
	public int actualizarPassword2(PyUsuario pyUsuario);
	public PyUsuario existeUsuario(String emailUF, long custNum);
	public PyUsuario getByUserUsuarioNum(Long usuarioNum);
	public int insertPyUsuario(PyUsuario pyUsuario) throws SQLException;
	public int estatusUsuario(PyUsuario pyUsuario) throws SQLException;

	
}
