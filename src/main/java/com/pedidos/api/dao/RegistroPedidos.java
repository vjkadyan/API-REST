package com.pedidos.api.dao;

import java.sql.SQLException;

import com.pedidos.api.model.PyUsuario;

public interface RegistroPedidos {
	
	public int countFavoritos(int clienteNum) throws SQLException;
	
	public String registraUsuarioNuevo(String usuario,String email,String pass,String passC,String ip, String tel, String isEmpresa, int clienteNum, int usuarioNum ) throws SQLException;
	
	boolean insertamembresiaClinte(int cliente_num);
	
	public PyUsuario validaCredencial(String user, String Password, int user_m) throws SQLException;

	public PyUsuario validaCredencialClien(String user, String Password, int clien, int user_m) throws SQLException;
	
	public String UpdateCodigo(String codigo, String correo);
	
	public String isCodigoVerificado(String correo,String contrasena);
	
	public String reenviarCodigo(String codigo);
	
	public String validaUsuario(String usuario) throws SQLException;

	public void enviacorreoPedidos(String email) throws SQLException;
}
