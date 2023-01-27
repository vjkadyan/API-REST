package com.pedidos.api.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pedidos.api.comun.Cadena;
import com.pedidos.api.model.Customer;
import com.pedidos.api.sql.CustomerSQL;
import com.pedidos.api.sql.rowmapper.CustomerRowMapper;

@Service
public class CustomerDaoImp implements CustomerDao {

	private static final Logger LOG = Logger.getLogger(CustomerDaoImp.class);
	private String sqlTot = "";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void insertRow(Customer customer) throws SQLException {

		sqlTot = CustomerSQL.INSERT.toString();
		LOG.info(customer.toString());
		LOG.info("@Customer insertRow->" + sqlTot);

		jdbcTemplate.update(sqlTot, new Object[] { customer.getCustNum(), customer.getCustName(), customer.getAddress1(), customer.getAddress2(), customer.getCity(), customer.getProvince(), customer.getCountry(), customer.getPostalCode(), customer.getPhone(), customer.getTelex(), customer.getFax(), customer.getDuns(), customer.getArContact(), customer.getOpContact(), customer.getReceiver(), customer.getReceivTel(), customer.getBuyerTel(), customer.getStandardOrder(), customer.getSortName(), customer.getSalesId(), customer.getSaCust(), customer.getCustGroup(), customer.getPpdColl(), customer.getDunningCode(), customer.getTaxRegion(), customer.getTerrCode(), customer.getCreditHold(), customer.getCreditLimit(), customer.getCreditDays(), customer.getLastCredReview(), customer.getRating(), customer.getEdi(), customer.getArMethod(), customer.getStatFreq(), customer.getInterest(), customer.getTermCode(), customer.getSlmnNum(), customer.getLicence2(), customer.getPoRequired(), customer.getPrintInvoice(), customer.getBackOrder(), customer.getPpsPrice(), customer.getPromotePrice(), customer.getOrderConfirm(), customer.getChargeTo(), customer.getWhseCode(), customer.getShipVia(), customer.getPriceLevel(), customer.getPriority(), customer.getLanguage(), customer.getArMemo(), customer.getOpMemo(), customer.getBbVendor(), customer.getCoopCode(), customer.getCoopVendor(), customer.getStat(), customer.getDateCreated(), customer.getArOwing(), customer.getOpenOrder(), customer.getPtdSales(), customer.getLyptdSales(), customer.getYtdSales(), customer.getLytdSales(), customer.getLySales(), customer.getPtdCredit(), customer.getLyptdCredit(), customer.getYtdCredit(), customer.getLytdCredit(), customer.getLyCredit(), customer.getPtdCost(), customer.getLyptdCost(), customer.getYtdCost(), customer.getLytdCost(), customer.getLyCost(), customer.getYtdNoSales(), customer.getLyNoSales(), customer.getYtdNoReturns(), customer.getLyNoReturns(), customer.getLargestBal(), customer.getDateLargestBal(), customer.getLastAmtPay(), customer.getLastDatePay(), customer.getLastInvAmt(), customer.getInvDateLast(), customer.getAvgDaysPay(), customer.getLastAging(), customer.getArFuture(), customer.getArCurrent(), customer.getAr30Days(), customer.getAr60Days(), customer.getAr90Days(), customer.getAr120Days(), customer.getShippedPending(), customer.getOrderNote(), customer.getTelCharge(), customer.getSaOutput(), customer.getLicence1(), customer.getTaxStatus(), customer.getInvByGrp(), customer.getPlanOrdFlag(), customer.getGaranCode(), customer.getAceptaBo(), customer.getContrasena(), customer.getEstatusRed(), customer.getEmailRed(), customer.getPtjeCancela(), customer.getSlmn2(), customer.getSlmn3(), customer.getDigitov(), customer.getRecibePub(), customer.getcNumExt(), customer.getcNumInt(), customer.getLadaTel(), customer.getExtTel1(), customer.getExtTel2(), customer.getExtFax(), customer.getStatFraude() }); // 117

		return;
	}

	@Override
	public int deleteRow(Customer customer) throws SQLException {

		return 1;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateRow(Customer customer) throws SQLException {
		sqlTot = CustomerSQL.UPDATE.toString();
		return jdbcTemplate.update(sqlTot, new Object[] { customer.getCustName(), 
				customer.getAddress1(), 
				customer.getAddress2(), 
				customer.getCity(), 
				customer.getProvince(), 
				customer.getPostalCode(), 
				customer.getPhone(), 
				customer.getArContact(), 
				customer.getCustNum() });
	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public Customer getByIdRow(Customer entidad) throws SQLException {
		sqlTot = CustomerSQL.CONSULTA.toString() + " Where cust_num = ? and cust_num not in(select cliente_num from py_cliente where cliente_num = customer.cust_num) ";
		LOG.info(sqlTot + entidad.getCustNum());
		LOG.info(entidad);

		return jdbcTemplate.queryForObject(sqlTot, new Object[] { entidad.getCustNum() }, new CustomerRowMapper());
	}

	@Override
	public Integer countRow() throws SQLException {

		return new Integer(1);
	}

	@Override
	public List<Customer> getAllRow() throws SQLException {
		return new ArrayList<Customer>();
	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<Customer> getByName(String custName) throws SQLException {

		sqlTot = CustomerSQL.CONSULTA.toString() + " where cust_name matches '*" + custName + "*' And stat = 'P' ";

		return jdbcTemplate.query(sqlTot, new CustomerRowMapper());
	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public boolean isClienteCredito(long custNum) throws SQLException {
		boolean isCredito = false;
		sqlTot = CustomerSQL.CONSULTA.toString() + " Where cust_num = ? And term_code > 07 ";

		SqlRowSet rs = jdbcTemplate.queryForRowSet(sqlTot, new Object[] { custNum });
		isCredito = rs.next();

		return isCredito;
	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<Customer> getClientesActivosDCDI() throws SQLException {
		sqlTot = CustomerSQL.CONSULTA.toString() + " where stat <>'I' and cust_num  not in( select distinct(cust_num) from py_distribuidor where tipo_distri = 'DCM' and status = 'A') order by cust_num";

		return jdbcTemplate.query(sqlTot, new CustomerRowMapper());
	}

	@Override
	public String getPasswordDCDI(String sText) {
		Random rnd = new Random();
		
		Calendar c2 = new GregorianCalendar();

		double rand = (rnd.nextDouble());
		int anio = c2.get(Calendar.YEAR);
		int segundos = c2.get(Calendar.SECOND) + 1;
		int iUpperbound = 0;
		int iLowerbound = anio / segundos;
		int iRandomNumber = (int) ((iUpperbound - iLowerbound + 1) * rand + iLowerbound);
		int iExtraDigit = 0;

		String iRandomText = Integer.toString(iRandomNumber);
		String sNewPassword = "";
		do {
			double rand1 = (rnd.nextDouble());
			iExtraDigit = (int) ((9 - 0 + 1) * rand1 + 0);
			iRandomText = iRandomText + iExtraDigit;
		} while (iRandomText.length() < 6);

		sNewPassword = sText.substring(1, 2) + iRandomText + sText.substring(0, 1);

		return sNewPassword;
	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public String getRFCDistribuidor(long custNum) {
		String rfc = "";
		sqlTot = CustomerSQL.CONSULTA_RFC.toString();

		SqlRowSet rs = jdbcTemplate.queryForRowSet(sqlTot, new Object[] { custNum });

		while (rs.next()) {
			rfc = rs.getString("sort_name");
		}

		return rfc;
	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public String getEmailCustomer(long custNum) {

		sqlTot = CustomerSQL.CONSULTA_EMAILRED.toString();

		SqlRowSet rs = jdbcTemplate.queryForRowSet(sqlTot, new Object[] { custNum });

		if (rs.next())
			return rs.getString("email_red");
		else
			return "";
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public int eliminaCustomer(long clienteNum) {

		sqlTot = CustomerSQL.UPDATE_INACTIVAR.toString();

		LOG.info("eliminaCustomer customer->" + clienteNum + "|" + sqlTot);

		return jdbcTemplate.update(sqlTot, new Object[] { clienteNum });
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public int eliminaCustomerInternet(long clienteNum) {

		sqlTot = CustomerSQL.ELIMINAR_CUSTOMER_INTERNET.toString();

		LOG.info("eliminaCustomer customer->" + clienteNum + "|" + sqlTot);

		return jdbcTemplate.update(sqlTot, new Object[] { clienteNum });
	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public String getCustNumEncryptAESTime(long custNum) {
		String cadena = "";
		String sql = "";
		Statement stmI1 = null;
		Connection sqlI1 = null;

		try {
			sqlI1 = jdbcTemplate.getDataSource().getConnection();
			stmI1 = sqlI1.createStatement();

			stmI1.execute(" set encryption password get_enc_pass(); ");

			sql = " Select encrypt_aes(current + 15  UNITS  MINUTE || '|' || cust_num || '|' || cust_name) as cadena " + " from customer " + " where cust_num =  " + custNum;

			ResultSet rs = stmI1.executeQuery(sql);
			if (rs.next()) {
				cadena = Cadena.filtra(rs.getString(1));
			}
			rs.close();

		} catch (Exception e) {

		} finally {
			try {
				if (stmI1 != null) {
					if (!stmI1.isClosed()) {
						stmI1.close();
					}
				}
				if (sqlI1 != null) {
					if (!sqlI1.isClosed()) {
						sqlI1.close();
					}
				}
			} catch (Exception e) {

			}
		}

		return cadena;
	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public String getCustNumDecryptAESTime(String cadena) {
		String cadenaDec = "";
		String sql = "";
		Statement stmI1 = null;
		Connection sqlI1 = null;

		try {
			sqlI1 = jdbcTemplate.getDataSource().getConnection();
			stmI1 = sqlI1.createStatement();

			stmI1.execute(" set encryption password get_enc_pass(); ");

			sql = " Select decrypt_char('" + cadena + "') as cadena " + " from customer " + " where cust_num =  16886 ";

			ResultSet rs = stmI1.executeQuery(sql);
			if (rs.next()) {
				cadenaDec = Cadena.filtra(rs.getString(1));
			}
			rs.close();

		} catch (Exception e) {

		} finally {
			try {
				if (stmI1 != null) {
					if (!stmI1.isClosed()) {
						stmI1.close();
					}
				}
				if (sqlI1 != null) {
					if (!sqlI1.isClosed()) {
						sqlI1.close();
					}
				}
			} catch (Exception e) {

			}
		}

		return cadenaDec;
	}

	@Override
	public boolean getFechaValida(long custNum, String fecha) {
		boolean esValidaFecha = false;
		String sql = "";
		Statement stmI1 = null;
		Connection sqlI1 = null;

		try {
			sqlI1 = jdbcTemplate.getDataSource().getConnection();
			stmI1 = sqlI1.createStatement();

			sql = " Select cust_num " + " From customer " + " Where cust_num = " + custNum + " And current <= '" + fecha + "' ";

			LOG.info(sql);
			ResultSet rs = stmI1.executeQuery(sql);
			if (rs.next()) {
				esValidaFecha = true;
			}
			rs.close();

		} catch (Exception e) {

		} finally {
			try {
				if (stmI1 != null) {
					if (!stmI1.isClosed()) {
						stmI1.close();
					}
				}
				if (sqlI1 != null) {
					if (!sqlI1.isClosed()) {
						sqlI1.close();
					}
				}
			} catch (Exception e) {

			}
		}

		return esValidaFecha;
	}

	public String getNombreCliente(long custNum) {
		String nombre = "";
		sqlTot = CustomerSQL.OBTENER_NOMBRE.toString();
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sqlTot, new Object[] { custNum });
		while (rs.next()) {
			nombre = rs.getString("cust_name").trim();
		}
		return nombre;
	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public String getCustNumEncryptAESTime(long custNum, int minute) {

		String cadena = "";
		String sql = "";
		Statement stmI1 = null;
		Connection sqlI1 = null;

		try {
			sqlI1 = jdbcTemplate.getDataSource().getConnection();
			stmI1 = sqlI1.createStatement();

			stmI1.execute(" set encryption password get_enc_pass(); ");

			sql = " Select encrypt_aes(current + " + minute + "  UNITS  MINUTE || '|' || cust_num || '|' || cust_name) as cadena " + " from customer " + " where cust_num =  " + custNum;

			ResultSet rs = stmI1.executeQuery(sql);
			if (rs.next()) {
				cadena = Cadena.filtra(rs.getString(1));
			}
			rs.close();

		} catch (Exception e) {

		} finally {
			try {
				if (stmI1 != null) {
					if (!stmI1.isClosed()) {
						stmI1.close();
					}
				}
				if (sqlI1 != null) {
					if (!sqlI1.isClosed()) {
						sqlI1.close();
					}
				}
			} catch (Exception e) {

			}
		}

		return cadena;
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public boolean esBloqueoHP(long custNum) {
		boolean bloqueo = false;
		sqlTot = CustomerSQL.OBTENER_BLOQUEO_HP.toString();
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sqlTot, new Object[] { custNum });
		if (rs.next()) {
			bloqueo = true;
		}
		return bloqueo;
	}

	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public boolean esBloqueoTonerHP(long custNum) {
		boolean bloqueo = false;
		sqlTot = CustomerSQL.OBTENER_BLOQUEO_TONER_HP.toString();
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sqlTot, new Object[] { custNum });
		if (rs.next()) {
			bloqueo = true;
		}
		return bloqueo;
	}

	@Override
	public Customer getCustomerXClienteNum(Customer customer) {
		sqlTot = CustomerSQL.CONSULTA.toString() + " Where cust_num = ? ";
		return jdbcTemplate.queryForObject(sqlTot, new Object[] { customer.getCustNum() }, new CustomerRowMapper());
	}
	
	@Override
	public Customer getDateCreated(Customer customer) {
		sqlTot = CustomerSQL.CONSULTA_FECHA_CREACION.toString() + " Where cust_num = ? ";
		Customer cust = new Customer();
		SqlRowSet rs =  jdbcTemplate.queryForRowSet(sqlTot, new Object[] { customer.getCustNum() });
		
		if(rs.next()) {
			cust.setCustNum(rs.getInt(1));
			cust.setDateCreated(rs.getString(2));
		}
		 return cust;
	}
	
	@Override
	@Transactional(isolation=Isolation.READ_UNCOMMITTED)
	public String getSlmnNum(long custNum){
		String slmnNum="";
		sqlTot=CustomerSQL.OBTENER_SLMN_NUM.toString();
		SqlRowSet rs=jdbcTemplate.queryForRowSet(sqlTot,new Object[]{custNum});
		if(rs.next()){
			slmnNum=rs.getString("slmn_num");
		}
		return slmnNum;
	}
	
	@Override
	@Transactional(isolation=Isolation.READ_UNCOMMITTED)
	public Customer getDireccion(long custNum) {
		sqlTot = CustomerSQL.CONSULTA.toString() + " where cust_num = ?";

		return jdbcTemplate.queryForObject(sqlTot, new Object[] { custNum }, new CustomerRowMapper());
	}
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public boolean updateDatosFact(Customer customer) {
		sqlTot = CustomerSQL.UPDATE_DATOSFACT.toString();
		Boolean  retorno = false;
		try {
			
			
			int rs = jdbcTemplate.update(sqlTot, new Object[] { customer.getAddress1(),customer.getPostalCode(), 
					customer.getCity(),customer.getProvince(),customer.getPhone(),customer.getCustNum()});
			retorno = true;
		}
		catch(Exception e) {
		
			LOG.info("Error"+ e);
			retorno = false;
		}
		
		return retorno;
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<Map<String, String>> getCollectorCustomer(long custNum) throws SQLException{
		String sqlTot = "";
		sqlTot = CustomerSQL.OBTENER_COLLECTOR.toString();
		List<Map<String, String>> lstCollector = new ArrayList<Map<String, String>>();
		SqlRowSet row = jdbcTemplate.queryForRowSet(sqlTot, custNum);
		Map<String, String> mapCollector = null;

		while (row.next()) {
			mapCollector = new HashMap<String, String>();
			mapCollector.put("collNum", row.getString("collNum"));
			mapCollector.put("collName", row.getString("collName"));			
			lstCollector.add(mapCollector);

		}
		return lstCollector;
	}
	
	
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public String getEmailCliente(long clienteNum) {
		String email = "";
		sqlTot = CustomerSQL.OBTENER_EMAIL_CLIENTE.toString();

		SqlRowSet rs = jdbcTemplate.queryForRowSet(sqlTot, new Object[] { clienteNum });

		while (rs.next()) {
			email = rs.getString("email_red");
		}

		return email;
	}
	
	@Override
	@Transactional(isolation=Isolation.READ_UNCOMMITTED)
	public String getGpoCliente(long custNum){
		String grupoVentas="";
		sqlTot=CustomerSQL.OBTENER_SLMN_NUM.toString();
		SqlRowSet rs=jdbcTemplate.queryForRowSet(sqlTot,new Object[]{custNum});
		if(rs.next()){
			grupoVentas=rs.getString("grupo_ventas");
		}
		return grupoVentas;
	}
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public String getRazonSocial(long custNum) {
		String razonSocial = "";
		sqlTot = CustomerSQL.CONSULTA_CUSTNUM.toString();

		SqlRowSet rs = jdbcTemplate.queryForRowSet(sqlTot, new Object[] { custNum });

		rs.next();
		razonSocial = rs.getString("cust_num");
		

		return razonSocial;
	}
	
	@Override
	public int updateToken(long custNum, String token) {
		sqlTot = CustomerSQL.UPDATETOKEN.toString();
		return jdbcTemplate.update(sqlTot, new Object[] { token, custNum });
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public String getDatosCliente(String token) {
		String datos = "";
		sqlTot = CustomerSQL.GETDATOSCLIENTE.toString();
		SqlRowSet rs=jdbcTemplate.queryForRowSet(sqlTot,new Object[]{token});
		if(rs.next()){
			datos = rs.getString(1).trim() + "," + rs.getString(2).trim();
		}
		return datos;
	}
}
