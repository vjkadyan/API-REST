package com.pedidos.api.dao;

import java.sql.SQLException;
import java.util.List;

import org.json.JSONObject;

import com.pedidos.api.model.CorreosUsuario;
import com.pedidos.api.model.ModulosUsuario;

public interface MiEquipoDao {
	public String obtieneTipoUsuario(long usuarioNum) throws SQLException;
	
	public int getAccionUsuario(long usuarioNum, String tipoUsuario) throws SQLException;
	public List<ModulosUsuario> obtieneModulosUsuario(long usuarioNum, String tipoUsuario) throws SQLException;
	public List<CorreosUsuario> obtieneCorreosUsuario(long usuarioNum, String tipoUsuario) throws SQLException;
	public String obtieneIdentificador(long usuarioNum, String tipoUsuario) throws SQLException;
	public String registraUsuario(JSONObject usuarioJson, int usuario_num) throws SQLException;
	public String modificaUsuario(JSONObject usuarioJson) throws SQLException;
	public String estatusUsuario(JSONObject usuarioJson, String tipoEstatus) throws SQLException;
	public String asignaAdmin(JSONObject jsonO);

}
