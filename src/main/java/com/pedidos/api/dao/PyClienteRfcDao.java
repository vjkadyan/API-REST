package com.pedidos.api.dao;

import java.sql.SQLException;
import java.util.List;

import com.pedidos.api.comun.DAO;
import com.pedidos.api.model.PyClienteRfc;

public interface PyClienteRfcDao extends DAO<PyClienteRfc>{
	/**
	 * Metodo que devuelve todos los RFC  por cliente
	 * 
	 * @param clienteNum
	 *            parametro que recibe es el numero de cliente
	 * @return List regresa un lista de Objectos tipo PyClienteRfc
	 */
	public List<PyClienteRfc> getPyClienteRfcByClienteNum(long clienteNum);

	/**
	 * 
	 * @param clienteNum
	 * @return
	 * @throws SQLException
	 */
	public int getMaxPyClienteRfc(long clienteNum) throws SQLException;

	/**
	 * 
	 * @param clienteNum
	 * @param rfcNum
	 * @return
	 * @throws SQLException
	 */
	public int inactivarRfc(long clienteNum, long rfcNum) throws SQLException;
	
	public int eliminaPyClienteRFC(long rfcNum, long clienteNum) ;
	/**
	 * @param clienteNum
	 */
	public int eliminaPyClienteRfcInternet(String clienteNum);

	/**
	 * @param clienteNum
	 */
	public int pedidoInternetGetRfcNum(long clienteNum);

	public List<PyClienteRfc> getRFC(long clienteNum);
	
	/**
	 * 
	 * @param clienteNum
	 * @return
	 */
	public List<PyClienteRfc> getTodosRFC(long clienteNum);
	
	public int actualizarRfcPyClienteRfc(PyClienteRfc pyclienteRfc);

	public PyClienteRfc ObtenerDatosCliente(long clienteNum);

	int insertRow(PyClienteRfc pyclienteRfc, int flag) throws SQLException;

	public PyClienteRfc ObtenerDatosClienteRfc(long clienteNum, String clienteRfc);

	public int updateRowRfc(PyClienteRfc pyclienteRfc) throws SQLException;
	
	public long obtieneRfcNumGenerico(long clienteNum) throws SQLException;
}
