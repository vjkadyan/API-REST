package com.pedidos.api.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.pedidos.api.model.BitClienteRfc;
import com.pedidos.api.model.DatosFacturacion;
import com.pedidos.api.model.MisFacturas;
import com.pedidos.api.model.MisNotasCredito;
import com.pedidos.api.model.PyCliente;
import com.pedidos.api.model.PyClienteRfc;
import com.pedidos.api.model.SaOrdH;
import com.pedidos.api.sql.MisFacturasSql;

@Service
public class ObtieneMisFacturasImp implements ObtieneMisFacturasDao{
	private String sql;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired()
	private PyClienteDao pyclienteDaoImpIfx;
	
	@Autowired
	private PyClienteRfcDao pyclienteRfcDaoImpIfx;
	
	@Override
	public List<MisFacturas> obtieneFacturas(long clienteNum, String fechaFacturas) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MisFacturas obtieneFactura(long clienteNum, long invoiceNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validaCliente(long clienteNum, long invoiceNum) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<DatosFacturacion> obtieneDatosFacturacion(long clienteNum) {
		List<DatosFacturacion> listaRetorno = new LinkedList<DatosFacturacion>();
		DatosFacturacion datosFacturacion = null;
		sql = MisFacturasSql.CONSULTA_DATOS_RFC.toString();
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, clienteNum, clienteNum);
		while(rs.next())
		{
			datosFacturacion = new DatosFacturacion();
			datosFacturacion.setRfcNum(rs.getInt("rfc_num"));
			datosFacturacion.setClienteRfc(("".equals(rs.getString("cliente_rfc").trim())||rs.getString("cliente_rfc").trim()=="")?"-":rs.getString("cliente_rfc").trim());
			datosFacturacion.setRazonSocial(rs.getString("nombre").trim());
			datosFacturacion.setDireccionFiscal(rs.getString("address1").trim());
			datosFacturacion.setColonia(rs.getString("colonia").trim());
			datosFacturacion.setCiudad(rs.getString("city").trim());
			datosFacturacion.setEstado(rs.getString("province").trim());
			datosFacturacion.setCp(rs.getString("postal_code").trim());
			listaRetorno.add(datosFacturacion);
		}
		return listaRetorno;
	}

	@Override
	public DatosFacturacion obtieneDatosFacturacion(int rfcNum, String rfc, long clienteNum) {
		DatosFacturacion datosFacturacion = new DatosFacturacion();
		SqlRowSet rs = null;
		if(rfcNum == 0)
		{
			sql = MisFacturasSql.CONSULTA_DATO_RFC_0.toString();
			rs = jdbcTemplate.queryForRowSet(sql, clienteNum, rfc);
		}
		else
		{
			sql = MisFacturasSql.CONSULTA_DATO_RFC.toString();
			rs = jdbcTemplate.queryForRowSet(sql, clienteNum, rfc,rfcNum);
		}
		if(rs.next())
		{
			datosFacturacion.setClienteRfc(("".equals(rs.getString("cliente_rfc").trim())||rs.getString("cliente_rfc").trim()=="")?"-":rs.getString("cliente_rfc").trim());
			datosFacturacion.setRazonSocial(rs.getString("nombre").trim());
			datosFacturacion.setDireccionFiscal(rs.getString("address1").trim());
			datosFacturacion.setColonia(rs.getString("colonia").trim());
			datosFacturacion.setCiudad(rs.getString("city").trim());
			datosFacturacion.setEstado(rs.getString("province").trim());
			datosFacturacion.setCp(rs.getString("postal_code").trim());
		}
		return datosFacturacion;
	}

	@Override
	public List<DatosFacturacion> consultaCp(String cp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertaDatoFact(PyClienteRfc pyclienteRfc) {
		int i = 0;
		try 
		{
			pyclienteRfc.setRfcNum(pyclienteRfcDaoImpIfx.getMaxPyClienteRfc(pyclienteRfc.getClienteNum())+1);
			i = pyclienteRfcDaoImpIfx.insertRow(pyclienteRfc,0);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public PyCliente obtieneDatosCliente(long clienteNum) {
		PyCliente pyCliente = pyclienteDaoImpIfx.ObtenerDatoscliente(clienteNum);
		return pyCliente;
	}

	@Override
	public PyClienteRfc obtieneDatosClienteRfc(long clienteNum, String clienteRfc) {
		PyClienteRfc pyCliente = pyclienteRfcDaoImpIfx.ObtenerDatosClienteRfc(clienteNum, clienteRfc);
		return pyCliente;
	}

	@Override
	public int actualizaRfc(PyClienteRfc clienteRfc) {
		int x = 0;
		try 
		{
			x = pyclienteRfcDaoImpIfx.updateRowRfc(clienteRfc);
		} 
		catch (SQLException e) 
		{
			x = -1;
			e.printStackTrace();
		}
		return x;
	}

	@Override
	public int agregaBitacoraRfc(BitClienteRfc bitacora) {
		sql = MisFacturasSql.INSERTA_BITACORA.toString();
		int x = jdbcTemplate.update(sql, bitacora.getTipoBit(),bitacora.getClienteNum(),bitacora.getClienteRfc(),bitacora.getMensaje());
		return x;
	}

	@Override
	public int eliminaRfc(int rfcNum, long clienteNum, String clienteRfc) {
		int x = pyclienteRfcDaoImpIfx.eliminaPyClienteRFC(rfcNum, clienteNum);
		return x;
	}

	@Override
	public String consultaSerieByString(String serie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String consultaSerieByNum(String serie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MisNotasCredito> consultaNotasC(long clienteNum, String fechaFacturas) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MisNotasCredito> consultaNotasCarrito(long clienteNum, double total) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String consultaSerie(int cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MisNotasCredito> obtieneNotasByRfc(long clienteNum, String rfc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String obtieneRfcByRfcNum(long cliente_num, int rfc_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int actualizaShipViaOrder(long orderNum, int shipVia) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizaShipViaSaOrd(long orderNum, int shipVia) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SaOrdH getByRowSaOrdH(long order_num) {
		// TODO Auto-generated method stub
		return null;
	}

}
