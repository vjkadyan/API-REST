package com.pedidos.api.dao;

import java.util.ArrayList;
import java.util.List;

import com.pedidos.api.model.DatoFactNuevo;
import com.pedidos.api.model.DatosFacturacion;
import com.pedidos.api.model.DatosRefacturacion;
import com.pedidos.api.model.MisFacturas;
import com.pedidos.api.model.MisNotasCredito;
import com.pedidos.api.model.PyMPago;
import com.pedidos.api.model.SatUsoCfdi;;

public interface MisFacturasDao {
	public List<MisFacturas> consultaFacturas(long clienteNum,String fechaFacturas);
	public List<DatosFacturacion> obtieneRfcs(long clienteNum);
	public long corrigeSerie(String invoice);
	public String agregaSerie(long invoice);
	public String obtieneArchivo(long clienteNum,String invoice,String extension);
	public List<DatosFacturacion> obtieneDatosFacturacion(long clienteNum);
	public List<SatUsoCfdi> obtieneCfdi(String tipoPersona);
	public DatosFacturacion consultaDatoFact(int rfcNum,String rfc,long clienteNum);
	public List<PyMPago> obtieneMPago();
	public List<DatosFacturacion> consultaCp(String cp);
	public String guardaDatoFactNuevo(DatoFactNuevo dato);
	public String guardaDatoFactNuevoRefactura(DatosRefacturacion dato);
	public String eliminaRfc(int rfcNum,String rfc,long clienteNum);
	public ArrayList<MisNotasCredito> consultaNotasC(long clienteNum,String fechaNotas);
	public ArrayList<MisNotasCredito> obtieneNotasByRfc(long clienteNum,String rfc);
	public String obtieneRfcByRfcNum(long clienteNum, int rfcNum);
	public MisNotasCredito detalleNc(long clienteNum, String nc);
}
