package com.pedidos.api.dao;

import java.util.ArrayList;
import java.util.List;

import com.pedidos.api.model.BitClienteRfc;
import com.pedidos.api.model.DatosFacturacion;
import com.pedidos.api.model.MisFacturas;
import com.pedidos.api.model.MisNotasCredito;
import com.pedidos.api.model.PyCliente;
import com.pedidos.api.model.PyClienteRfc;
import com.pedidos.api.model.SaOrdH;


public interface ObtieneMisFacturasDao {
	public List<MisFacturas> obtieneFacturas(long clienteNum, String fechaFacturas);
	public MisFacturas obtieneFactura(long clienteNum, long invoiceNum);
	public boolean validaCliente(long clienteNum,long invoiceNum);
	public List<DatosFacturacion> obtieneDatosFacturacion(long clienteNum);
	public DatosFacturacion obtieneDatosFacturacion(int rfcNum, String rfc,long clienteNum);
	public List<DatosFacturacion> consultaCp(String cp);
	public int insertaDatoFact(PyClienteRfc pyclienteRfc);
	public PyCliente obtieneDatosCliente(long clienteNum);
	public PyClienteRfc obtieneDatosClienteRfc(long clienteNum, String clienteRfc);
	public int actualizaRfc(PyClienteRfc clienteRfc);
	public int agregaBitacoraRfc(BitClienteRfc bitacora);
	public int eliminaRfc(int rfcNum,long clienteNum,String clienteRfc);
	public String consultaSerieByString(String serie);
	public String consultaSerieByNum(String serie);
	public ArrayList<MisNotasCredito> consultaNotasC(long clienteNum, String fechaFacturas);
	public ArrayList<MisNotasCredito> consultaNotasCarrito(long clienteNum, double total);
	public String consultaSerie(int cod);
	public ArrayList<MisNotasCredito> obtieneNotasByRfc(long clienteNum, String rfc);
	public String obtieneRfcByRfcNum(long cliente_num, int rfc_num);
	public int actualizaShipViaOrder(long orderNum, int shipVia);
	public int actualizaShipViaSaOrd(long orderNum, int shipVia);
	public SaOrdH getByRowSaOrdH(long order_num);
}
