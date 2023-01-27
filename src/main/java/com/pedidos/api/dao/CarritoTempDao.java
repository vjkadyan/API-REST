package com.pedidos.api.dao;

import java.sql.SQLException;

import com.pedidos.api.comun.DAO;
import com.pedidos.api.model.Carrito;

public interface CarritoTempDao extends DAO<Carrito> {
	
//	public int inserta(Carrito entidad, String base) throws SQLException;
	
	public int consultaPartidas(int cliente_num, int usuario_num, int usuario_temp, String base) throws SQLException;
	
//	public ArrayList<PreCarrito> getCarrito(long clienteNum, long usuarioNum, String afiliado) throws SQLException;
//	
//	public ArrayList<ResenaPedidos> getEjecutivo(long cliente_num, long usuario_num) throws SQLException;
//	
//	public int elimina(long clienteNum,long usuarioNum,String items,String base) throws SQLException;
//	
//	public ArrayList<PyItemsFavoritos> obtieneFavoritosFrecuentes(long clienteNum, int top, long usuarioNum);
//	
//	public double getPrecioGarantia(double precio, String opcion) throws SQLException;
//	
//	public void modificaSegGaran(long clienteNum, long usuarioNum, String itemNum, int idInt, int seguro, String itemGarantia, int garantia, int opcion, String base) throws SQLException;
//	
//	public JSONObject reservaCarrito(long clienteNum,long usuarioNum,String afiliado,long ejecutivo, String cupon, String ip) throws SQLException, JSONException;
//
//	public ResumenPedido obtieneResumenPedido(long pedidoNum) throws SQLException, JSONException;
//	
//	public ArrayList<Facturas> getFacturas(long clienteNum) throws SQLException;
//
//	public ArrayList<Direccion> getDirecciones(long clienteNum) throws SQLException, JSONException;
//	
//	public int obtieneReferencia(long pedidoNum) throws SQLException;
//	
//	public int obtieneDigitoV(long pedidoNum) throws SQLException;
//
//	public Map<String, String> getFormasEnvio(long pedidoNum,String afiliado, String envio, double peso, String cp) throws SQLException;
//	
//	public String getPedidoGratis(long pedidoNum) throws SQLException;
//	
//	public String validaExpress(long pedidoNum, String cp) throws SQLException;
//	
//	public Integer agregarAlCarrito(long pedidoNum) throws SQLException;
//	
//	public String consultaMargen(Long clienteNum, Long custNum, String itemNum) throws SQLException;
//	
//	public String actualizaDireccion(long clienteNum, long pedidoNum, int dirNum, int ship_via, long ejecutivo, String observaciones, int op) throws SQLException;
//	
//	public String getCostoFedex(int peso, String cp) throws SQLException;
//	
//	public double getTotal(long pedidoNum) throws SQLException;
//	
//	public ArrayList<String> getCoberturas(String cp) throws SQLException;
//	
//	public boolean validaCodigoDescuento(Long clienteNum, Long usuarioNum, String cupon) throws SQLException;
}