package com.pedidos.api.dao;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;

import com.pedidos.api.comun.DAO;
import com.pedidos.api.model.Entregas;
import com.pedidos.api.model.PyPedidoEnc;

/**
 * Definicion de la clase de PyPedidoEncDao
 */

public interface PyPedidoEncDao extends DAO<PyPedidoEnc> {
 
	/**
	 * Metodo que regresa los pedidos levantados por cliente por cliente, rango de fechas y estatus de los pedidos
	 * 
	 * @param custNum
	 *            este parametro es obligatorio y es numero del distribuidor
	 * @param clienteNum
	 *            este parametro es el numero de cliente y se recibe como parametro cero devuelve los pedidos de todos los clientes del distribuidor
	 * @param fechaIni
	 *            este parametro es la fecha inicial del reporte
	 * @param fechaFin
	 *            este parametro es la fecha final del reporte
	 * @param estatus
	 *            este es el estatus de los pedidos
	 * @param usuarioNum
	 *            numero de usuario
	 * @param compra
	 *            obtiene los pedidos con estatus "Solicitud de Compra", true solo para usuarios administradores y supervisores
	 * @param pedidosDist
	 *            true para obtener los pedidos del distribuidor omitiendo las 'Cotizaciones' y 'Solicitudes de Compra'
	 * @return List regresa una lista de objetos del tipo PyPedidoEnc
	 */
	public List<PyPedidoEnc> getPedidos(long custNum, long clienteNum, String fechaIni, String fechaFin, String estatus, long usuarioNum, boolean compra, boolean pedidosDist) throws SQLException;

	/**
	 * Metodo que regresa todos los pedidos con el mismo valor del campo evento
	 * 
	 * @param evento
	 *            es un identificador
	 * @return regresa una lista de objetos del tipo PyPedidoEnc
	 */
	public List<PyPedidoEnc> getPedidos(long evento) throws SQLException;

	/**
	 * Metodo que sirve pare des-encriptar una cadena y esta compuesto por pedido | nombre | cliente_num
	 * 
	 * @param cadena
	 * @return
	 * @throws SQLException
	 */
	public String getDecryptCadenaPedidoNum(String cadena) throws SQLException;

	/**
	 * 
	 * @param pedidoNum
	 * @return
	 * @throws SQLException
	 */
	public String getPedidoNumEncryptAES(long pedidoNum) throws SQLException;

	/**
	 * 
	 * @param pedidoNum
	 * @return
	 * @throws SQLException
	 */
	public int cancelaCotizacion(long pedidoNum) throws SQLException;

	/**
	 * 
	 * @param pedidoNum
	 * @param clienteNum
	 * @return
	 */
	public PyPedidoEnc getPedidoEnc(long pedidoNum, String clienteNum);

	/**
	 * 
	 * @param dirNum
	 * @param pedidoNum
	 * @return
	 */
	public int actualizaDirNum(int dirNum, int shipvia, String observaciones, long pedidoNum);

	/**
	 * Metodo que sirve para obtener todos los pedidos reservados antes de pago y despues de pago el cual se diferencia mediante el boolean pago
	 * 
	 * @param custNum
	 * @param clienteNum
	 * @param fechaIni
	 * @param fechaFin
	 * @param pago
	 * @return
	 */
	public List<PyPedidoEnc> getReservadosYPagos(long custNum, long clienteNum, String fechaIni, String fechaFin, boolean pago);

	/**
	 * 
	 * @param custNum
	 * @param clienteNum
	 * @param fechaIni
	 * @param fechaFin
	 * @return
	 */
	public List<PyPedidoEnc> getFacturados(long custNum, long clienteNum, String fechaIni, String fechaFin);

	/**
	 * 
	 * @param entrega
	 * @return
	 * @throws SQLException
	 */
	public Entregas getDetalleEnc(Entregas entrega) throws SQLException;

	/**
	 * 
	 * @param pedidoNum
	 * @return
	 */
	public List<PyPedidoEnc> getDetalleFacturado(long pedidoNum);

	/**
	 * @param pyPedidoEnc
	 * @return pyPedidoEnc
	 **/
	public PyPedidoEnc getLocalForaneo(PyPedidoEnc pyPedidoEnc);

	public List<PyPedidoEnc> getProximosCancelacion(long custNum, long clienteNum, String fechaIni, String fechaFin);
	
	/**
	 * Metodo para actualizar shipvia
	 * @param pyPedidoEnc
	 * @return pyPedidoEnc
	 **/
	public int actualizaShipVia(PyPedidoEnc pyPedidoEnc) throws SQLException;
	
	public List<PyPedidoEnc> getListPyPedidos(long clienteNum);
	/**
	 * Metodo para traer los pedidos que esten ligados al mismo flete 
	 * @param ordership
	 * @return List<long>
	 **/
	public List<Long> getListaPedidos(long ordership) throws SQLException;
	/**
	 * Metodo para actualizar fecha regresiva los pedidos que esten ligados al mismo flete 
	 * @param pyPedidoEnc
	 * @return long
	 **/
	public long actualizafecha(PyPedidoEnc pyPedidoEnc) throws SQLException;

	public PyPedidoEnc getPedidoEnc(int pedidoNum, String orden_compra);
	
	public PyPedidoEnc getPedidoEnc(String ordenCompra);
	
	public int getPedidoNum(String ordenCompra);
	
	public String getOrdenCompra(int pedidoNum);

	public int getClienteNum(int pedidoNum);
	
	public List<PyPedidoEnc> getListPrimerosPyPedidos(long clienteNum);
	
	/*
	 * @return valor para el campo pedidoDcBodega de py pedido enc
	 * */
	public String obtienePedidoDCBodega(long pedidoNum);
	
	public String cliente_num(int pedido_num);

	PyPedidoEnc getPyPedidoEnc(long pedidoNum);

	public List<PyPedidoEnc> getPedidosEnc(String ordenCompra);
	
	public List<PyPedidoEnc> getListPrimerosPyPedidos(long clienteNum, int cantidad, String fechaPedidos);

	public List<PyPedidoEnc> getListPrimerosFacturados(long clienteNum, int cantidad, String estatus, int shipVia, int shipVia2);

	public PyPedidoEnc getByOrderDc(long orderNum);
	
	public int getPedidosFactuardos(long clienteNum);
	
	public Map<String, Integer> obtieneFrecuenciaCompras(long clienteNum, String item);
	
	public List<String> getOrderDc(long pedidoNum);
	
	public int actualizaShipNumOrder(String orderNum, int dirNum, int shipVia);
	
	public int actualizaShipNumSaOrd(String orderNum, int dirNum, int shipVia);
	
	public int actualizaShipNumOrderPagos(String orderNum, int shipVia);
	
	public int actualizaShipNumPedidoEnc(long orderNum, int shipVia);
	
	public int actualizaShipNumSaOrdPagos(String orderNum, int shipVia);
	
	public int getmPago(long pedidoNum);

}
