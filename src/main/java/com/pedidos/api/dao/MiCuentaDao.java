package com.pedidos.api.dao;

import java.sql.SQLException;

public interface MiCuentaDao {
	
//	public Object obtieneMisDatos(Long usuarioNum) throws SQLException;
//
//	public Object registraMisDatos(TipoMiCuenta tipoMiCuenta);
//	
//	public Object obtieneTelefonos(Long usuarioNum) throws SQLException;
//	
//	public Object obtieneTipoTelefono() throws SQLException;
//	
//	public int cambioContrasena(Long usuarioNum,String contrasenaA,String contrasenaN,String contrasenaN2) throws SQLException;
	
	public int cambioContrasena2(String email,String contrasenaN,String contrasenaN2) throws SQLException;
	
//	public String actualizaDatos(DatoCliente datoCliente);
//	
//	public int agregaTelCel(PyTelefonoCliente pyTelefonoCliente) throws SQLException;
//	
//	public Object todosMisTelefonos(Long clienteNum, Long usuarioNum) throws SQLException;
//	
//	public int editarMisTelefonos(TelefonosPedidosCuenta telefonosPedidosCuenta);
//
//	int actualizarNotificaciones(Long usuarioNum, String telfijo, String telCelular, boolean envCliente, boolean envMensaje) throws SQLException;
//	
//	public Afiliacion getAfiliacionCliente(long clienteNum);
//
//	public ArrayList<PyItemsFavoritos> obtieneFavoritosFrecuentes(long clienteNum);
//	
//	public String eliminaFavorito(long cliente, String item);
//	
//	public String cintaVerde(long clienteNum, int accion) throws SQLException;
//	
//	public int getCintaVerde(long clienteNum) throws SQLException;
}
