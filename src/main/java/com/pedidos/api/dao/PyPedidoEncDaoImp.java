package com.pedidos.api.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pedidos.api.comun.Fecha;
import com.pedidos.api.model.Entregas;
import com.pedidos.api.model.PyPedidoEnc;
import com.pedidos.api.sql.PyPedidoEncSQL;
import com.pedidos.api.sql.rowmapper.PyPedidoEncRowMapper;

//import sun.org.mozilla.javascript.internal.ObjArray;
/**
 * Definicion de la clase de PyPedidoEncDaoImp
 * 
 * @see <a href = "http://www.blitz.com" />Ver Pagina</a>
 */
@Service
public class PyPedidoEncDaoImp implements PyPedidoEncDao {
	 
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final Logger LOG = Logger.getLogger(PyPedidoEncDaoImp.class);
	private StringBuilder sql = new StringBuilder();
	private String sqlTot = "";

	@Autowired
	private Fecha fecha;
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void insertRow(PyPedidoEnc pyPedidoEnc) throws SQLException {
		LOG.info("pyPedidoEncDaoImp.insertRow: " + pyPedidoEnc);
		sqlTot = PyPedidoEncSQL.INSERT.toString();
		jdbcTemplate.update(sqlTot, pyPedidoEnc.getOrgCode(), pyPedidoEnc.getDivCode(), pyPedidoEnc.getPedidoNum(), pyPedidoEnc.getCustNum(), pyPedidoEnc.getClienteNum(), pyPedidoEnc.getDirNum(), pyPedidoEnc.getFecha(), pyPedidoEnc.getIdSuperpedido(), pyPedidoEnc.getUsuario(), pyPedidoEnc.getCentroCosto(), pyPedidoEnc.getOrdenCompra(), pyPedidoEnc.getObservaciones(), pyPedidoEnc.getEstatus(), pyPedidoEnc.getEstEnvio(), pyPedidoEnc.getImporte(), pyPedidoEnc.getIva(), pyPedidoEnc.getTipoEntrega(), pyPedidoEnc.getEvento(), pyPedidoEnc.getOrigen(), pyPedidoEnc.getRemFact(), pyPedidoEnc.getShipVia(), pyPedidoEnc.getShipNum());
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public int deleteRow(PyPedidoEnc pyPedidoEnc) throws SQLException {
		sqlTot = PyPedidoEncSQL.DELETE.toString();
		return jdbcTemplate.update(sqlTot, pyPedidoEnc.getPedidoNum());
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public int updateRow(PyPedidoEnc pyPedidoEnc) throws SQLException {
		sqlTot = PyPedidoEncSQL.UPDATE.toString();

		return jdbcTemplate.update(sqlTot, pyPedidoEnc.getOrgCode(), pyPedidoEnc.getDivCode(), pyPedidoEnc.getCustNum(), pyPedidoEnc.getClienteNum(), pyPedidoEnc.getDirNum(), pyPedidoEnc.getFecha(), pyPedidoEnc.getIdSuperpedido(), pyPedidoEnc.getUsuario(), pyPedidoEnc.getCentroCosto(), pyPedidoEnc.getOrdenCompra(), pyPedidoEnc.getObservaciones(), pyPedidoEnc.getEstatus(), pyPedidoEnc.getEstEnvio(), pyPedidoEnc.getImporte(), pyPedidoEnc.getIva(), pyPedidoEnc.getTipoEntrega(), pyPedidoEnc.getEvento(), pyPedidoEnc.getOrigen(), pyPedidoEnc.getRemFact(), pyPedidoEnc.getShipVia(), pyPedidoEnc.getShipNum(), pyPedidoEnc.getPedidoNum());
	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public PyPedidoEnc getByIdRow(PyPedidoEnc pedidoNum) throws SQLException {

		sqlTot = PyPedidoEncSQL.CONSULTA.toString();
		sqlTot += " Where pedido_num = ? ";

		return jdbcTemplate.queryForObject(sqlTot, new PyPedidoEncRowMapper(), pedidoNum.getPedidoNum());
	}

	@Override
	public Integer countRow() throws SQLException {

		return new Integer(1);
	}

	@Override
	public List<PyPedidoEnc> getAllRow() throws SQLException {

		return new ArrayList<PyPedidoEnc>();
	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<PyPedidoEnc> getPedidos(long custNum, long clienteNum, String fechaIni, String fechaFin, String estatus, long usuarioNum, boolean compra, boolean pedidosDist) throws SQLException {
		LOG.info("CustNum:" + custNum + ", clienteNum:" + clienteNum + ", fechaIni:" + fechaIni + ", fechaFin:" + fechaFin + ", estatus:" + estatus + ", usuarioNum:" + usuarioNum + ", compra:" + compra + ", pedidosDist:" + pedidosDist);
		String fIni;
		String fFin;
		fecha.setFormatoFecha(Fecha.DDMMYYYY);
		fecha.setFecha(fechaIni);
		fIni = fecha.getFecha(Fecha.MMDDYYYY);

		fecha.setFormatoFecha(Fecha.DDMMYYYY);
		fecha.setFecha(fechaFin);
		fFin = fecha.getFecha(Fecha.MMDDYYYY);

		sqlTot = PyPedidoEncSQL.CONSULTA.toString();
		sqlTot += " Where cust_num = ?  And date(fecha) >= ?  And date(fecha) <= ? ";

		if (clienteNum > 0) {
			sqlTot += " And cliente_num = " + clienteNum;
		}

		if (compra) { // Obtiene los pedidos con el estatus " Solicitud de Compra"
			sqlTot += " And estatus = 'S'";
		} else {
			if (!"A".equals(estatus)) {
				sqlTot += " And estatus IN ('" + estatus + " ')";
			} else {
				if (pedidosDist) {
					sqlTot += " and estatus != 'S'  ";
				}
			}

		}

		if (usuarioNum != 0) {
			sqlTot += " and usuario = " + usuarioNum;
		}

		sqlTot += " order by fecha desc ";

		LOG.info(sqlTot);

		return jdbcTemplate.query(sqlTot, new Object[] { custNum, fIni, fFin }, new PyPedidoEncRowMapper());
	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<PyPedidoEnc> getPedidos(long evento) throws SQLException {
		sqlTot = PyPedidoEncSQL.CONSULTA.toString();
		sqlTot += " Where evento = ?  And estatus  != 'C' ";

		return jdbcTemplate.query(sqlTot, new Object[] { evento }, new PyPedidoEncRowMapper());
	}

	public Fecha getFecha() {
		return fecha;
	}

	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public String getDecryptCadenaPedidoNum(String cadena) throws SQLException {
		String cadenaDecrypt = "";
		cadena = cadena.replaceAll(" ", "+");

		Connection con = null;
		Statement stm = null;
		try {
			con = jdbcTemplate.getDataSource().getConnection();
			stm = con.createStatement();
			stm.execute(" set encryption password get_enc_pass(); ");

			try {
				sql.delete(0, sql.length());
			} catch (StringIndexOutOfBoundsException ex) {
				sql = new StringBuilder();
			}
			sql.append(" Select decrypt_char('");
			sql.append(cadena);
			sql.append("')");
			sql.append(" from customer ");
			sql.append(" where cust_num = 16886 ");

			LOG.info(sql.toString());

			ResultSet rs = stm.executeQuery(sql.toString());
			if (rs.next()) {
				cadenaDecrypt = rs.getString(1);
			}
			rs.close();
		} catch (Exception e) {

		} finally {
			try {
				if (stm != null) {
					if (!stm.isClosed()) {
						stm.close();
					}
				}
				if (con != null) {
					if (!con.isClosed()) {
						con.close();
					}
				}
			} catch (Exception e) {

			}
		}

		return cadenaDecrypt;
	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public String getPedidoNumEncryptAES(long pedidoNum) throws SQLException {
		String cadena = "";
		Connection con = null;
		Statement stm = null;
		try {
			con = jdbcTemplate.getDataSource().getConnection();
			stm = con.createStatement();
			stm.execute(" set encryption password get_enc_pass(); ");

			try {
				sql.delete(0, sql.length());
			} catch (StringIndexOutOfBoundsException ex) {
				sql = new StringBuilder();
			}
			sql.append(" Select encrypt_aes(e.pedido_num || '|' || c.nombre|| '|' || c.cliente_num) as cadena ");
			sql.append(" from py_pedido_enc e,py_cliente c ");
			sql.append(" where e.pedido_num = ");
			sql.append(pedidoNum);
			sql.append(" and c.cliente_num = e.cliente_num ");

			ResultSet rs = stm.executeQuery(sql.toString());
			if (rs.next()) {
				cadena = rs.getString(1);
			}
			rs.close();
		} catch (Exception e) {

		} finally {
			try {
				if (stm != null) {
					if (!stm.isClosed()) {
						stm.close();
					}
				}
				if (con != null) {
					if (!con.isClosed()) {
						con.close();
					}
				}
			} catch (Exception e) {

			}
		}

		return cadena;
	}

	@Override
	@Transactional
	public int cancelaCotizacion(long pedidoNum) throws SQLException {
		sqlTot = PyPedidoEncSQL.CANCELACOTIZACION.toString();

		return jdbcTemplate.update(sqlTot, pedidoNum);
	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public PyPedidoEnc getPedidoEnc(long pedidoNum, String clienteNum) {
		try {
			sql.delete(0, sql.length());
		} catch (StringIndexOutOfBoundsException ex) {
			sql = new StringBuilder();
		}
		sqlTot = PyPedidoEncSQL.CONSULTA.toString();
		sqlTot += " Where pedido_num = ? AND cliente_num = ?";

		return jdbcTemplate.queryForObject(sqlTot, new PyPedidoEncRowMapper(), pedidoNum, clienteNum);

	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public PyPedidoEnc getPedidoEnc(int pedidoNum, String orden_compra) {
		LOG.info("Entra a getpedidoEnc");
		try {
			sql.delete(0, sql.length());
		} catch (StringIndexOutOfBoundsException ex) {
			sql = new StringBuilder();
		}
		sqlTot = PyPedidoEncSQL.CONSULTA.toString();
		sqlTot += " Where pedido_num = ? and orden_compra = ?";

		return jdbcTemplate.queryForObject(sqlTot, new PyPedidoEncRowMapper(), pedidoNum, orden_compra);

	}
	
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public PyPedidoEnc getPedidoEnc(String ordenCompra) {
		LOG.info("Entrto getpedidoEnc");
		try {
			sql.delete(0, sql.length());
		} catch (StringIndexOutOfBoundsException ex) {
			sql = new StringBuilder();
		}
		LOG.info("sql");
		sqlTot = PyPedidoEncSQL.CONSULTA_OC.toString();
		sqlTot += " where e.orden_compra = ? group by e.org_code,e.div_code,e.pedido_num,e.cust_num,e.cliente_num,e.dir_num,e.fecha,e.id_superpedido, \r\n" + 
				"e.usuario,e.centro_costo,e.orden_compra,e.observaciones,e.estatus,e.est_envio,e.importe,e.iva, e.tipo_entrega,\r\n" + 
				"e.evento,e.origen,e.rem_fact,e.ship_via,e.ship_num ";

		return jdbcTemplate.queryForObject(sqlTot, new Object[] { ordenCompra }, new PyPedidoEncRowMapper());

	}
	
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<PyPedidoEnc> getPedidosEnc(String ordenCompra) {
		LOG.info("Entrto getpedidoEnc");
		try {
			sql.delete(0, sql.length());
		} catch (StringIndexOutOfBoundsException ex) {
			sql = new StringBuilder();
		}
		LOG.info("sql");
		sqlTot = PyPedidoEncSQL.CONSULTA_OC.toString();
		sqlTot += " where e.orden_compra = ? group by e.org_code,e.div_code,e.pedido_num,e.cust_num,e.cliente_num,e.dir_num,e.fecha,e.id_superpedido," + 
				"e.usuario,e.centro_costo,e.orden_compra,e.observaciones,e.estatus,e.est_envio,e.importe,e.iva, e.tipo_entrega," + 
				"e.evento,e.origen,e.rem_fact,e.ship_via,e.ship_num ";

		return jdbcTemplate.query(sqlTot, new PyPedidoEncRowMapper(), new Object[] { ordenCompra });

	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public int actualizaDirNum(int dirNum, int shipvia, String observaciones, long pedidoNum) {
		sqlTot = PyPedidoEncSQL.ACTUALIZADIRNUM.toString();
		return jdbcTemplate.update(sqlTot, new Object[] { dirNum, dirNum, shipvia, observaciones, pedidoNum });
	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<PyPedidoEnc> getReservadosYPagos(long custNum, long clienteNum, String fechaIni, String fechaFin, boolean pago) {
		List<PyPedidoEnc> pedidos = new ArrayList<PyPedidoEnc>();
		String fIni;
		String fFin;
		fecha.setFormatoFecha(Fecha.DDMMYYYY);
		fecha.setFecha(fechaIni);
		fIni = fecha.getFecha(Fecha.MMDDYYYY);
		PyPedidoEnc pyPedidoEnc;
		fecha.setFormatoFecha(Fecha.DDMMYYYY);
		fecha.setFecha(fechaFin);
		fFin = fecha.getFecha(Fecha.MMDDYYYY);
		sqlTot = PyPedidoEncSQL.CONSULTA_RESERVADOS_PAGOS.toString();
		sqlTot += " Where pe.cust_num = ?  And date(pe.fecha) >= ?  And date(pe.fecha) <= ? ";
		if (clienteNum > 0) {
			sqlTot += " And pe.cliente_num = " + clienteNum;
		}
		if (pago) {
			sqlTot += " And h.ship_via<>15";
		} else {
			sqlTot += "And h.ship_via = 15";
		}
		sqlTot += " and pe.estatus = 'R' And h.order_status in ('PRINTED','HOLD') order by pe.fecha desc";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sqlTot, new Object[] { custNum, fIni, fFin });
		while (rs.next()) {
			pyPedidoEnc = new PyPedidoEnc();
			pyPedidoEnc.setPedidoNum(rs.getLong("pedido_num"));
			pyPedidoEnc.setClienteNum(rs.getLong("cliente_num"));
			pyPedidoEnc.setImporte(rs.getDouble("importe"));
			pyPedidoEnc.setIva(rs.getDouble("iva"));
			pyPedidoEnc.setFecha(rs.getString("fecha"));
			pyPedidoEnc.setUsuario(rs.getLong("usuario"));
			pyPedidoEnc.setNombreCliente(rs.getString("nombre"));
			pyPedidoEnc.setPedidoDC(rs.getString("order_num"));
			pyPedidoEnc.setImporteDist(rs.getDouble("net_amount"));
			pyPedidoEnc.setIvaDist(rs.getDouble("tax1_amt"));
			pyPedidoEnc.setTipoEntrega(rs.getString("ship_via"));
			pyPedidoEnc.setTermCode(rs.getLong("term_code"));
			pyPedidoEnc.setRuta(rs.getString("ruta"));
			pyPedidoEnc.setHoraRuta(rs.getString("hora_ruta"));
			pyPedidoEnc.setOrderStatus(rs.getString("order_status"));
			pyPedidoEnc.setHoraCredito(rs.getString("hora_credito"));
			pyPedidoEnc.setFechaSeg(rs.getString("fecha").substring(0, 16));
			pyPedidoEnc.setDirNum(rs.getInt("dir_num"));
			pyPedidoEnc.setFacturaPDF(rs.getString("factura"));
			pyPedidoEnc.setBodega(rs.getString("bodega"));
			String pedidoDCBodega = rs.getString("bodega")+rs.getString("order_num");
			pyPedidoEnc.setPedidoDCBodega(pedidoDCBodega);
			pyPedidoEnc.setShipVia(rs.getString("ship_via"));
			pedidos.add(pyPedidoEnc);
		}
		return pedidos;
	}

	@Override
	public Entregas getDetalleEnc(Entregas entrega) throws SQLException {
		sqlTot = PyPedidoEncSQL.CONSULTA_CLIENTE_BLITZ.toString();
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sqlTot, new Object[] { entrega.getIdSuperpedido() });
		if (rs.next()) {
			entrega.setClienteNum(rs.getLong("cliente_num"));
			entrega.setTotalCliente(rs.getDouble("importe"));
			entrega.setPedidoNum(rs.getLong("pedido_num"));
			entrega.setNombreCliente(rs.getString("nombre"));
			entrega.setDirNum(rs.getInt("dir_num"));
		}
		return entrega;
	}

	@Override	
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<PyPedidoEnc> getFacturados(long custNum, long clienteNum, String fechaIni, String fechaFin) {
		List<PyPedidoEnc> pedidos = new ArrayList<PyPedidoEnc>();
		String fIni;
		String fFin;
		fecha.setFormatoFecha(Fecha.DDMMYYYY);
		fecha.setFecha(fechaIni);
		fIni = fecha.getFecha(Fecha.MMDDYYYY);
		PyPedidoEnc pyPedidoEnc;
		fecha.setFormatoFecha(Fecha.DDMMYYYY);
		fecha.setFecha(fechaFin);
		fFin = fecha.getFecha(Fecha.MMDDYYYY);
		sqlTot = PyPedidoEncSQL.CONSULTA_FACTURACION.toString();
		if (clienteNum > 0) {
			sqlTot += " And pe.cliente_num = " + clienteNum;
		}
		sqlTot += " ORDER BY pe.pedido_num,h.order_num";		
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sqlTot, new Object[] { custNum, fIni, fFin });
		while (rs.next()) {
			pyPedidoEnc = new PyPedidoEnc();
			pyPedidoEnc.setClienteNum(rs.getLong("cliente_num"));
			pyPedidoEnc.setNombreCliente(rs.getString("nombre"));
			pyPedidoEnc.setPedidoNum(rs.getLong("pedido_num"));
			pyPedidoEnc.setPedidoDC(rs.getString("order_num"));
			pyPedidoEnc.setFecha(rs.getString("fecha"));
			pyPedidoEnc.setFechaFacturacion(rs.getString("inv_gen_time"));
			pyPedidoEnc.setImporteDist(rs.getDouble("net_amount"));
			pyPedidoEnc.setIvaDist(rs.getDouble("tax1_amt"));
			pyPedidoEnc.setImporte(rs.getDouble("importe"));
			pyPedidoEnc.setIva(rs.getDouble("iva"));
			pyPedidoEnc.setShipVia(rs.getString("ship_via").trim());
			pyPedidoEnc.setLigaFactura(rs.getString("ligafactura").trim());
			pyPedidoEnc.setNumFactura(rs.getInt("invoice_num"));
			pyPedidoEnc.setOrderNum(rs.getInt("order_num"));
			pyPedidoEnc.setProducto(rs.getString("desc").trim());
			pyPedidoEnc.setNumproductos(rs.getInt("numArt"));
			pyPedidoEnc.setCalle(rs.getString("s_name").trim());
			pyPedidoEnc.setAddress1(rs.getString("address1").trim());
			pyPedidoEnc.setAddress2(rs.getString("address2").trim());
			pyPedidoEnc.setColonia(rs.getString("colonia").trim());
			pyPedidoEnc.setCity(rs.getString("city").trim());
			pyPedidoEnc.setProvince(rs.getString("province").trim());
			pyPedidoEnc.setCountry(rs.getString("country").trim());
			pyPedidoEnc.setPostal_code(rs.getString("postal_code").trim());
			pyPedidoEnc.setOrdership(rs.getLong("order_ship"));
			pyPedidoEnc.setFacturaPDF(rs.getString("factura"));
			pyPedidoEnc.setBodega(rs.getString("bodega"));
			String pedidoDCBodega = rs.getString("bodega")+rs.getString("order_num");
			pyPedidoEnc.setPedidoDCBodega(pedidoDCBodega);
			pedidos.add(pyPedidoEnc);
		}		
		LOG.info(pedidos);		
		return pedidos;
	}

	@Override
	public List<PyPedidoEnc> getDetalleFacturado(long pedidoNum) {
		PyPedidoEnc pyPedidoEnc;
		List<PyPedidoEnc> pedidos = new ArrayList<PyPedidoEnc>();
		sqlTot = PyPedidoEncSQL.CONSULTA_FACTURACION_X_PEDIDO.toString();
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sqlTot, new Object[] { pedidoNum });
		while (rs.next()) {
			pyPedidoEnc = new PyPedidoEnc();
			pyPedidoEnc.setClienteNum(rs.getLong("cliente_num"));
			pyPedidoEnc.setNombreCliente(rs.getString("nombre"));
			pyPedidoEnc.setPedidoNum(rs.getLong("pedido_num"));
			pyPedidoEnc.setPedidoDC(rs.getString("order_num"));
			pyPedidoEnc.setFecha(rs.getString("fecha"));
			pyPedidoEnc.setFechaFacturacion(rs.getString("inv_gen_time"));
			pyPedidoEnc.setImporteDist(rs.getDouble("net_amount"));
			pyPedidoEnc.setIvaDist(rs.getDouble("tax1_amt"));
			pyPedidoEnc.setImporte(rs.getDouble("importe"));
			pyPedidoEnc.setIva(rs.getDouble("iva"));
			pyPedidoEnc.setShipVia(rs.getString("ship_via"));
			pyPedidoEnc.setLigaFactura(rs.getString("ligafactura"));
			pedidos.add(pyPedidoEnc);
		}
		return pedidos;
	}

	@Override
	public PyPedidoEnc getLocalForaneo(PyPedidoEnc pyPedidoEnc) {
		sqlTot = PyPedidoEncSQL.CONSULTASHIPVIALOCALFORANEO.toString();
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sqlTot, new Object[] { pyPedidoEnc.getShipVia() });
		LOG.info(sqlTot.replaceFirst("\\?", pyPedidoEnc.getShipVia()));
		if (rs.next()) {
			pyPedidoEnc.setLocalForaneo(rs.getString("ship_name").contains("LOCAL") ? "Local" : rs.getString("ship_name").contains("FORANE") ? "Foraneo" : "Mostrador");
		}
		return pyPedidoEnc;
	}

	@Override
	public List<PyPedidoEnc> getProximosCancelacion(long custNum, long clienteNum, String fechaIni, String fechaFin) {
		List<PyPedidoEnc> pedidos = new ArrayList<PyPedidoEnc>();
		String fIni;
		String fFin;
		fecha.setFormatoFecha(Fecha.DDMMYYYY);
		fecha.setFecha(fechaIni);
		fIni = fecha.getFecha(Fecha.MMDDYYYY);
		PyPedidoEnc pyPedidoEnc;
		fecha.setFormatoFecha(Fecha.DDMMYYYY);
		fecha.setFecha(fechaFin);
		fFin = fecha.getFecha(Fecha.MMDDYYYY);
		sqlTot = PyPedidoEncSQL.CONSULTA_PROXIMA_CANCELACION.toString();
		sqlTot += " Where pe.cust_num = ?  And date(h.cancel_date) >= ?  And date(h.cancel_date) <= ? ";
		if (clienteNum > 0) {
			sqlTot += " And pe.cliente_num = " + clienteNum;
		}

		sqlTot += " and pe.estatus = 'R' And h.order_status in ('PRINTED','HOLD') order by pe.fecha desc";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sqlTot, new Object[] { custNum, fIni, fFin });
		while (rs.next()) {
			pyPedidoEnc = new PyPedidoEnc();
			pyPedidoEnc.setPedidoNum(rs.getLong("pedido_num"));
			pyPedidoEnc.setClienteNum(rs.getLong("cliente_num"));
			pyPedidoEnc.setImporte(rs.getDouble("importe"));
			pyPedidoEnc.setIva(rs.getDouble("iva"));
			pyPedidoEnc.setFecha(rs.getString("fecha"));
			pyPedidoEnc.setUsuario(rs.getLong("usuario"));
			pyPedidoEnc.setNombreCliente(rs.getString("nombre"));
			pyPedidoEnc.setPedidoDC(rs.getString("order_num"));
			pyPedidoEnc.setImporteDist(rs.getDouble("net_amount"));
			pyPedidoEnc.setIvaDist(rs.getDouble("tax1_amt"));
			pyPedidoEnc.setTipoEntrega(rs.getString("ship_via"));
			pyPedidoEnc.setTermCode(rs.getLong("term_code"));
			pyPedidoEnc.setRuta(rs.getString("ruta"));
			pyPedidoEnc.setHoraRuta(rs.getString("hora_ruta"));
			pyPedidoEnc.setOrderStatus(rs.getString("order_status"));
			pyPedidoEnc.setHoraCredito(rs.getString("hora_credito"));
			pyPedidoEnc.setFechaCancelacion(rs.getString("cancel_date").substring(0, 10));
			pedidos.add(pyPedidoEnc);
		}
		return pedidos;
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public int actualizaShipVia(PyPedidoEnc pyPedidoEnc) throws SQLException {
		sqlTot = PyPedidoEncSQL.CAMBIASHIPVIAEXPRESS.toString();
		return jdbcTemplate.update(sqlTot, new Object[] { pyPedidoEnc.getShipVia(), pyPedidoEnc.getPedidoNum()});
	}
	
	@Override	
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<PyPedidoEnc> getListPyPedidos(long clienteNum) {
		sqlTot = PyPedidoEncSQL.CONSULTA.toString() + "  Where cliente_num = ?  order by fecha DESC";
		LOG.info(sqlTot);
			
		return jdbcTemplate.query(sqlTot, new Object[] { clienteNum }, new PyPedidoEncRowMapper());
	
	}

	@Override
	public List<Long> getListaPedidos(long ordership) throws SQLException {
		long pedido=0;
		List<Long> pedidos = new ArrayList<Long>();
		sqlTot = PyPedidoEncSQL.CONSULTA_TRAE_PEDIDO.toString();
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sqlTot, new Object[] { ordership });
		while (rs.next()) {
			pedido = rs.getLong(1);
			pedidos.add(pedido);
		}
		return pedidos;
	}

	@Override
	public long actualizafecha(PyPedidoEnc pyPedidoEnc) throws SQLException {
		sqlTot = PyPedidoEncSQL.CAMBIAFECHAREGRESIVA.toString();		
		return jdbcTemplate.update(sqlTot, new Object[] {pyPedidoEnc.getFecharegresiva(),pyPedidoEnc.getPedidoNum()});
	}

	@Override
	public int getPedidoNum(String ordenCompra) {
		int pedidoNum = 0;
		sqlTot = PyPedidoEncSQL.CONSULTA_PEDIDO_NUM_CON_ORDEN_COMPRA.toString();
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sqlTot, new Object[] { ordenCompra });
		while (rs.next()) {
			pedidoNum = rs.getInt(1);
		}
		return pedidoNum;
	}

	@Override
	public String getOrdenCompra(int pedidoNum) {
		String ordenCompra = "";
		sqlTot = PyPedidoEncSQL.CONSULTA_ORDEN_COMPRA_CON_PEDIDO_NUM.toString();
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sqlTot, new Object[] { pedidoNum });
		while (rs.next()) {
			ordenCompra = rs.getString(1);
		}
		return ordenCompra;
	}
	
	@Override
	public int getClienteNum(int pedidoNum) {
		int clienteNum =0;
		sqlTot = PyPedidoEncSQL.CONSULTA_NUMERO_DE_CLIENTE.toString();
		sqlTot+=pedidoNum;
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sqlTot);
		if(rs.next()) {
			clienteNum = rs.getInt("cliente_num");
		}
		return clienteNum;
	}
	
	
	@Override	
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<PyPedidoEnc> getListPrimerosPyPedidos(long clienteNum) {
		sqlTot = PyPedidoEncSQL.CONSULTA_PEDIDOS_CLIENTE.toString() + "  Where cliente_num = ?  order by fecha DESC";
		LOG.info(sqlTot);
			
		return jdbcTemplate.query(sqlTot, new Object[] { clienteNum }, new PyPedidoEncRowMapper());
	
	}

	@Override	
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<PyPedidoEnc> getListPrimerosPyPedidos(long clienteNum, int cantidad, String fechaPedidos) {
		String fechaInicio = "";
		String fechaFin = "";
		sqlTot = PyPedidoEncSQL.CONSULTA_CUANTOS_PEDIDOS_CLIENTE.toString();
		if("".equals(fechaPedidos) || fechaPedidos == "")
		{
			sqlTot += "  Where estatus in ('R','F','C') and cliente_num = ? order by estatus desc,fecha desc ";
			return jdbcTemplate.query(sqlTot, new Object[] { cantidad,clienteNum }, new PyPedidoEncRowMapper());
		}
		else
		{
			try
			{
				//FECHA INICIO
				SimpleDateFormat parser = new SimpleDateFormat("MM/yyyy");
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				fechaInicio = formatter.format(parser.parse(fechaPedidos)).toString() + " 00:00:00";
				
				//FECHA FIN
				Calendar cal = Calendar.getInstance();
				cal.setTime(parser.parse(fechaPedidos));
				cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
				fechaFin = formatter.format(cal.getTime()).toString() + " 23:59:59";
				sqlTot += "  Where estatus not in ('P','B') and cliente_num = ? and fecha between ? and ? order by fecha DESC";
				return jdbcTemplate.query(sqlTot, new Object[] { 50,clienteNum,fechaInicio,fechaFin }, new PyPedidoEncRowMapper());
			}
			catch(ParseException e)
			{
				e.printStackTrace();
				LOG.info("Fecha invalida, realizando consulta sin fecha");
				sqlTot += "  Where estatus not in ('P','B') and cliente_num = ? order by fecha DESC";
				return jdbcTemplate.query(sqlTot, new Object[] { cantidad,clienteNum }, new PyPedidoEncRowMapper());
			}
		}
	}

	@Override	
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<PyPedidoEnc> getListPrimerosFacturados(long clienteNum, int cantidad, String estatus, int shipVia, int shipVia2) {
		sqlTot = PyPedidoEncSQL.CONSULTA_CUANTOS_PEDIDOS_CLIENTE.toString();
		sqlTot += " where cliente_num = ? and cust_num = 38000 and div_code = 'PDIR' and estatus = ? and ship_via in (?,?) order by fecha desc ";
		return jdbcTemplate.query(sqlTot, new Object[] { cantidad,clienteNum,estatus,shipVia,shipVia2 }, new PyPedidoEncRowMapper());
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public String obtienePedidoDCBodega(long pedidoNum) {
		SqlRowSet rs = jdbcTemplate.queryForRowSet(PyPedidoEncSQL.CONSULTA_PEDIDO_DC_BODEGA.toString(),new Object[] {pedidoNum});
		String pedidoDcBodega = "";
		while(rs.next()) {
			String whseCode = rs.getString(1);
			int orderNum = rs.getInt(2);
			String bodegaLetra =  "" ;
			if("01".equals(whseCode.trim()) || "02".equals(whseCode.trim())) {
				bodegaLetra = "A";
			}else if("03".equals(whseCode.trim()) || "04".equals(whseCode.trim())) {
				bodegaLetra = "C";
			}else if("21".equals(whseCode.trim()) || "22".equals(whseCode.trim())) {
				bodegaLetra = "E";
			}
			pedidoDcBodega+=bodegaLetra+orderNum+",";
		}
		if(pedidoDcBodega.length()>0) {
			pedidoDcBodega = pedidoDcBodega.substring(0,pedidoDcBodega.length()-1);
		}
		return pedidoDcBodega;
	}
	
	@Override
	public String cliente_num(int pedido_num) {
		try {
			String cliente ="",observaiones = "";
			sqlTot = PyPedidoEncSQL.OBTIENE_NUM_CLIENTE.toString();
			LOG.info(sqlTot);
			SqlRowSet rs =  jdbcTemplate.queryForRowSet(sqlTot, new Object[] { pedido_num });
			while (rs.next()) {
				cliente = rs.getString(1);
				observaiones = rs.getString(2);
			}
			return cliente +"/"+observaiones;
		} catch (Exception e) {
			return "NULL" +"/"+" NULL";
		}
	}
	
	@Override
	public PyPedidoEnc getPyPedidoEnc(long pedidoNum) {
		
		sqlTot = PyPedidoEncSQL.CONSULTA_PEDIDO_FAVORITO.toString();
		
		return jdbcTemplate.queryForObject(sqlTot, new PyPedidoEncRowMapper(), pedidoNum);
		
	}
	
	@Override
	public PyPedidoEnc getByOrderDc(long orderNum) {
		
		sqlTot = PyPedidoEncSQL.CONSULTA_PEDIDO_ORDER_DC.toString();
		
		return jdbcTemplate.queryForObject(sqlTot, new PyPedidoEncRowMapper(), orderNum,orderNum);
		
	}

	@Override
	public int getPedidosFactuardos(long clienteNum) {
		// TODO Auto-generated method stub
		
		sqlTot = PyPedidoEncSQL.CONSULTA_PEDIDOS_FACTURADOS_CLIENTE + " where estatus = 'F' and cliente_num = ?";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sqlTot,clienteNum);
		int facturados = 0;
		if(rs.next()) {
			facturados = rs.getInt(1);
		}
		return facturados;
	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public Map<String, Integer> obtieneFrecuenciaCompras(long clienteNum, String item) {
		
		sqlTot = PyPedidoEncSQL.CONSULTA_FRECUENCIA_COMPRAS_CLIENTE_ITEM + "";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sqlTot,clienteNum,item);
		
		int 	interno = 0, piezas = 0;
		long  	restantes = 0, diasTot = 0, diferencia = 0,dias = 0, diferenciaFecha =0;
		Date 	fecha1 = null,fecha2 = null;
		
		while(rs.next()) {
			
			fecha2 = rs.getDate(3);
			
			if(interno > 0) {
				//LOG.info("fecha2: " + fecha2 + " fecha1: " + fecha1);
				diferencia = fecha2.getTime() - fecha1.getTime();
				//LOG.info("diferencia: " + diferencia);
				dias = diferencia / ((1000 * 60 * 60 * 24));
				//LOG.info("dias: " + dias);
				diasTot = diasTot + dias;
			}
			
			piezas = rs.getInt(1);
			fecha1 = fecha2;
			interno ++;
		}
		//LOG.info("diasTot: " + diasTot + " interno: " + interno + " item: " + item);
		if (interno - 1 == 0) {
			diasTot = 0;
		} else {
			diasTot = diasTot/((interno - 1));
		}
		//LOG.info("item: " + item + " frecuencia: " + diasTot);
		
		//obtengo fecha actual y comparo con la del ultimo pedido para obtener dias restantes
		
		Date now = new Date();
		diferenciaFecha = now.getTime() - fecha2.getTime();
		dias =  diferenciaFecha / ((1000 * 60 * 60 * 24));
		if(dias > diasTot) {
			restantes = 0;
		}else {
			restantes = diasTot - dias;
		}
		//LOG.info("item: " + item + " restantes: " + restantes);
		Map<String, Integer> mapFrecuenciaCompras = new HashMap<String, Integer>();
		mapFrecuenciaCompras.put("promedio", (int)diasTot);
		mapFrecuenciaCompras.put("restantes", (int)restantes) ;
		mapFrecuenciaCompras.put("piezas", piezas);
		
		return mapFrecuenciaCompras;
	}

	@Override	
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<String> getOrderDc(long pedidoNum) {
		List<String> list = new ArrayList<String>();
		sqlTot = PyPedidoEncSQL.CONSULTA_ORDER_DC + "";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sqlTot,pedidoNum,pedidoNum);
		while(rs.next()) {
			list.add(rs.getString(1).trim());
		}
		return list;
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public int actualizaShipNumOrder(String orderNum, int dirNum, int shipVia) {
		sqlTot = PyPedidoEncSQL.ACTUALIZA_SHIPNUM_ORDERH.toString();
		return jdbcTemplate.update(sqlTot, new Object[] { dirNum, shipVia, orderNum });
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public int actualizaShipNumSaOrd(String orderNum, int dirNum, int shipVia) {
		sqlTot = PyPedidoEncSQL.ACTUALIZA_SHIPNUM_SAORD.toString();
		return jdbcTemplate.update(sqlTot, new Object[] { dirNum, shipVia, orderNum });
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public int actualizaShipNumOrderPagos(String orderNum, int shipVia) {
		sqlTot = PyPedidoEncSQL.ACTUALIZA_SHIPNUM_ORDERH_PAGOS.toString();
		return jdbcTemplate.update(sqlTot, new Object[] { shipVia, orderNum });
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public int actualizaShipNumSaOrdPagos(String orderNum, int shipVia) {
		sqlTot = PyPedidoEncSQL.ACTUALIZA_SHIPNUM_SAORD_PAGOS.toString();
		return jdbcTemplate.update(sqlTot, new Object[] { shipVia, orderNum });
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public int actualizaShipNumPedidoEnc(long orderNum, int shipVia) {
		sqlTot = PyPedidoEncSQL.ACTUALIZA_PEDIDO_ENC.toString();
		return jdbcTemplate.update(sqlTot, new Object[] { shipVia, orderNum});
	}
	
	@Override	
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public int getmPago(long pedidoNum) {
		int idPago = 1;
		sqlTot = PyPedidoEncSQL.GET_IDPAGO + "";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sqlTot,pedidoNum);
		while(rs.next()) {
			idPago = rs.getInt(1);
		}
		return idPago;
	}
}
