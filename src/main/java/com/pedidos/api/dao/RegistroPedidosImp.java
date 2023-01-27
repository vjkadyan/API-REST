package com.pedidos.api.dao;


import java.security.SecureRandom;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pedidos.api.comun.Fecha;
import com.pedidos.api.comun.Seguridad;
import com.pedidos.api.model.Afiliacion;
import com.pedidos.api.model.CorreosUsuario;
import com.pedidos.api.model.CotizacionPedidos;
import com.pedidos.api.model.CrmCliente;
import com.pedidos.api.model.CustGl;
import com.pedidos.api.model.Customer;
import com.pedidos.api.model.Membresia;
import com.pedidos.api.model.ModulosUsuario;
import com.pedidos.api.model.PyCliente;
import com.pedidos.api.model.PyClienteBo;
import com.pedidos.api.model.PyClienteCodigo;
import com.pedidos.api.model.PyClienteMpago;
import com.pedidos.api.model.PyConFactura;
import com.pedidos.api.model.PyItemsFavoritos;
import com.pedidos.api.model.PyLayoutEjecutiva;
import com.pedidos.api.model.PyMpagoCuenta;
import com.pedidos.api.model.PySearch;
import com.pedidos.api.model.PyUsuario;
import com.pedidos.api.model.ResenaPedidos;
import com.pedidos.api.model.SisBitacoraActualizaciones;
import com.pedidos.api.model.TestTv;

@Service
public class RegistroPedidosImp implements RegistroPedidos {
	
	private static Logger log = Logger.getLogger(RegistroPedidosImp.class);
	
	@Autowired
	private PyItemsFavoritosDao pyItemsFavoritosDaoImp;
	
	@Autowired
	private CrmClienteDao crmClienteDaoImp;
	
	@Autowired
	private PyConFacturaDao pyConFacturaDaoImp;
	
	@Autowired
	private PySearchDao pySearchDaoImp;
	
	@Autowired
	private PyClienteBoDao pyClienteBoDaoImp;
	
	@Autowired
	//@Qualifier("pyUsuarioImp")
	private PyUsuarioDao pyUsuarioDaoImp;	
	
//	@Autowired
//	@Qualifier("pyUsuarioDaoImpApl")
//	private PyUsuarioDao pyUsuarioDaoImp;
//	
	@Autowired
	private PyClienteDao pyClienteImp;
	
//	@Autowired
//	@Qualifier("pyClienteDaoImpApl")
//	private PyClienteDao pyClienteDaoImpApl;
	
	@Autowired
	private PyClienteMpagoDao pyClienteMpagoDaoImp;
	
	@Autowired
	private PyMpagoCuentaDao pyMpagoCuentaDaoImp;
	
	@Autowired
	private TestTvDao testTvDaoImp;
	
	@Autowired
	private CustGlDao custGlDaoImp;
	
//	@Autowired
//	@Qualifier("customerDaoImpApl")
//	private CustomerDao customerDaoImpApl;
	
	@Autowired
//	@Qualifier("customerDaoImp")
	private CustomerDao customerDaoImp;
	
	@Autowired 
	private PyPedidoEncDao pyPedidoEncDao;
	
	@Autowired
	private PyClienteDao pyClienteDaoImp;
	
	@Autowired
	private Fecha fechaImpl;
	
	@Autowired
	private PyClienteCodigoImp pyclientecodigoImp;
	
	@Autowired
//	@Qualifier("SisBitacoraActualizacionesDaoSql")
	private SisBitacoraActualizacionesDao sisBitacoraActualizacionesDaoImp;
	
	@Autowired
	private MiEquipoDao miEquipoImp;
	
	@Autowired
//	@Qualifier("pyLayoutEjecutivaImp")
	private PyLayoutEjecutivaDao pyLayoutEjecutiva;
	
	/**MEMBRESIA**/
	@Autowired 
	private adquierenewMem adquierenewMemImp;
	
	@Autowired
//	@Qualifier("obtieneResenaPedidosIfx")
	private ObtieneResenasDao resenasIfx;
	
	@Autowired
//	@Qualifier("carritoTempDaoImp")
	private CarritoTempDao carritoTempDaoImp;
	
	@Autowired
	private AfiliacionDAO afiliacionDaoImp;
	
	@Autowired
//	@Qualifier("pyUsuarioImp")
	private PyUsuarioDao pyUsuarioImp;	
	
	@Autowired
	private MailPedidosCom mailPedidosImp;
	
	public static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	public static final int SECURE_TOKEN_LENGTH = 20;
	
	private static final SecureRandom random = new SecureRandom();
	
	private static final char[] symbols = CHARACTERS.toCharArray();
	
	private static final char[] buf = new char[SECURE_TOKEN_LENGTH];
	
	public ResenaPedidos consultaUltimoEjecutivo(long clienteNum) {
		ResenaPedidos resenaEjecutivo = resenasIfx.getByCliente(clienteNum);
		if(resenaEjecutivo.getSlmn() > -1) {
			try {
				SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
				SimpleDateFormat parser2 = new SimpleDateFormat("yyyy-MM-dd");
				Date fechaP = parser2.parse(parser2.format(parser.parse(resenaEjecutivo.getFecha())));
				String fecha = formatter.format(fechaP);
				resenaEjecutivo.setFecha(fecha);
				
				List<PyLayoutEjecutiva> pyLayout = pyLayoutEjecutiva.getAllCliente(clienteNum, resenaEjecutivo.getSlmn());
				PyLayoutEjecutiva ultimoEvaluado = new PyLayoutEjecutiva();
				if("NOENCONTRADO".equals(pyLayout.get(0).getComentario())){
					ultimoEvaluado = new PyLayoutEjecutiva();
					ultimoEvaluado.setEvaluado("POREVALUAR");
				} else {
					//SI HAY REGISTROS, VALIDA FECHA PARA SABER SI YA EVALUÓ EL ULTIMO PEDIDO
					for(PyLayoutEjecutiva py : pyLayout) {
						Date fechaLayout = parser2.parse(py.getFecha());
						int comp =fechaLayout.compareTo(fechaP);
						if(comp >= 0) {//YA EVALUO EL PEDIDO
							ultimoEvaluado.setFecha(py.getFecha());
							ultimoEvaluado.setClienteNum(py.getClienteNum());
							ultimoEvaluado.setEmpleadoNum(py.getEmpleadoNum());
							ultimoEvaluado.setCalificacion(py.getCalificacion());
							ultimoEvaluado.setComentario(py.getComentario());
							ultimoEvaluado.setEvaluado("EVALUADO");
							break;
						}
					}
					if(ultimoEvaluado.getCalificacion() == 0) {
						ultimoEvaluado = new PyLayoutEjecutiva();
						ultimoEvaluado.setEvaluado("POREVALUAR");
					}
				}
				resenaEjecutivo.setPyLayoutEjecutiva(ultimoEvaluado);
			} catch(Exception s) {
				log.error("Error al consultar py_layout_ejecutiva, puede ser por la fecha");
				s.printStackTrace();
				resenaEjecutivo = new ResenaPedidos();
				resenaEjecutivo.setSlmn(-1);
			}
		}
		log.info("ej:"+resenaEjecutivo.toString());
		return resenaEjecutivo;
	}
	
	@Override
	public int countFavoritos(int clienteNum) throws SQLException {
		//obtengo los items favoritos y frecuentes del cliente
		ArrayList<PyItemsFavoritos> listaFavoritos = new ArrayList<PyItemsFavoritos>();
		listaFavoritos = pyItemsFavoritosDaoImp.obtieneFavoritosFrecuentes(clienteNum);
		
		ArrayList<PyItemsFavoritos> listaFavoritosDisponibles = new ArrayList<PyItemsFavoritos>();
		
		String itemsFav = "";
		for(PyItemsFavoritos item : listaFavoritos) {
			itemsFav += "'" + item.getItemNum() + "',";
		}
		
		ArrayList<String> listaItems = new ArrayList<String>();
		
		if(listaFavoritos.size() >= 1) {
			itemsFav = itemsFav.substring(0,itemsFav.length() - 1);
			
			//obtengo los detalles de los productos en py_Search
			Map<String, PySearch> mapPySearch = new HashMap<String,PySearch>();
			mapPySearch = pySearchDaoImp.obtieneListaPySearch(itemsFav);
			
			for(PyItemsFavoritos item : listaFavoritos) {
				
				PySearch beanPysearch = new PySearch();
				beanPysearch = mapPySearch.get(item.getItemNum().trim());
				//se agregan detalles de py_search
				if(beanPysearch != null) {
					
					//obtener fechas de pedidos para calcular promedio de dias y dias restantes
					if(item.getTipo().equals("C")) {
		
						Map<String, Integer> mapFrecuenciaCompras = new HashMap<String,Integer>();
						mapFrecuenciaCompras = pyPedidoEncDao.obtieneFrecuenciaCompras(clienteNum, item.getItemNum());
						if(mapFrecuenciaCompras != null) {
							item.setDiasPromedio(mapFrecuenciaCompras.get("promedio"));
							item.setDiasRestantes(mapFrecuenciaCompras.get("restantes"));
							item.setFrecuencia(mapFrecuenciaCompras.get("piezas"));
						}
						
					}
					
					item.setUrl(beanPysearch.getUrl());
					item.setTituloCompuesto(beanPysearch.getTituloCompuesto());
					item.setNumParte(beanPysearch.getNumParte().trim());
					item.setMarca(beanPysearch.getMarca().trim());
					item.setLineaNeg(beanPysearch.getLineaNeg().trim());
					item.setCodFamilia(beanPysearch.getCodFamilia());
					item.setCodSubfamilia(beanPysearch.getCodSubfamilia());
					item.setVolume(beanPysearch.getVolume());
					item.setNetWeigth(beanPysearch.getNetWeigth());
					item.setPrecioDeLista(beanPysearch.getPrecioDeLista());
					item.setIva(beanPysearch.getIva());
					item.setProveedorExterno(beanPysearch.getProveedorExterno());
					item.setSoloDf(beanPysearch.getSoloDf().trim());
					item.setPonderacion(beanPysearch.getPonderacion());
					item.setEstrella(beanPysearch.getEstrella());
					item.setAplicaExpress(beanPysearch.getAplicaExpress().trim());
					
					if(!listaItems.contains(item.getItemNum().trim())) {
						listaFavoritosDisponibles.add(item);
						listaItems.add(item.getItemNum().trim());
					}
					
					
				}
	
			}
		}
		
		return listaFavoritosDisponibles.size();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public String registraUsuarioNuevo(String usuario,String email,String pass,String passC,String ip, String tel, String isEmpresa, int clienteNum, int usuarioNum) throws SQLException {

		String mensaje = "N";
		tel=(tel==null)?"123456":tel;
		try {
			Date fechaHoy = new Date();
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			/*************************INSERTA SIS BITACORA ACTUALIZACIONES*************************/
			SisBitacoraActualizaciones sisBitacoraActualizaciones = new SisBitacoraActualizaciones();
			sisBitacoraActualizaciones.setIdModulo(8);
			sisBitacoraActualizaciones.setIdSubModulo(1);
			sisBitacoraActualizaciones.setIp(ip);
			sisBitacoraActualizaciones.setTerminal(ip);
			sisBitacoraActualizaciones.setNumEmpleado(0);
			sisBitacoraActualizaciones.setFecha(formato.format(fechaHoy));
			sisBitacoraActualizaciones.setInstruccion(usuario);
			sisBitacoraActualizacionesDaoImp.insertarBitacora(sisBitacoraActualizaciones);
			/*************************SE GENERA UN NUEVO NUMERO CLIENTE****************************/
			//int clienteNum = pyClienteDaoImp.getClienteNumPedidos();
			/*************************INSERTA CRM CLIENTE******************************************/
			CrmCliente crmCliente = new CrmCliente();
			crmCliente.setColonia("ANAHUAC II");
			crmCliente.setMunicipio("MIGUEL HIDALGO");
			crmCliente.setEstado("CIUDAD DE MEXICO");
			crmCliente.setTelUno(tel);
			crmCliente.setExtUno("");
			crmCliente.setCalleYNo("LAGO SILVERIO 258");
			crmCliente.setCalleYNoDos("LAGO SILVERIO 258");
			crmCliente.setRazonSocial(usuario);
			crmCliente.setRfc("XAXX010101000");
			crmCliente.setCp("11320");
			crmCliente.setPais("Mexico");
			crmCliente.setCalleUno("LAGO SILVERIO 258");
			crmCliente.setCalleDos("LAGO SILVERIO 258");
			crmCliente.setCustNum(clienteNum);
			crmCliente.setOrgCode("PDIR");
			crmCliente.setDivCode("38000");
			crmCliente.setRazonComercial("");
			crmCliente.setTelDos(tel);
			crmCliente.setExtDos("");
			crmCliente.setTelTres(tel);
			crmCliente.setExtTres("");
			crmCliente.setFax("");
			crmCliente.setExtFax("");
			crmCliente.setSitioWeb("");
			crmCliente.setObtenido("SOHO");
			crmCliente.setGiro("");
			crmCliente.setSector("S");
			crmCliente.setClasificacion("S");
			crmCliente.setStatus("C");
			crmCliente.setCapturista("INTE");
			crmCliente.setModificadoPor("");
			crmCliente.setFechaUlMod("");
			crmCliente.setTipoEmpresa("Pequeña");
			crmCliente.setTipo("");
			crmCliente.setNombre("");
			crmCliente.setPaterno("");
			crmCliente.setMaterno("");
			crmCliente.setAsignadoA(0);
			fechaImpl.setFormatoFecha("dd-MM-yyyy");
			crmCliente.setFechaAlta(fechaImpl.getFechaHoy());
			crmCliente.setActualizaStatus("");
			crmClienteDaoImp.insertRow(crmCliente);
			/*************************INSERTA PY CLIENTE*******************************************/
			PyCliente pyCliente = new PyCliente();
			pyCliente.setEmail(email);
			pyCliente.setCustNum(38000);
			pyCliente.setClienteNum(clienteNum);
			pyCliente.setNombre(usuario);
			pyCliente.setAddress1("LAGO SILVERIO 258");
			pyCliente.setAddress2("LAGO SILVERIO 258");
			pyCliente.setColonia("ANAHUAC II");
			pyCliente.setCity("MIGUEL HIDALGO");
			pyCliente.setProvince("CIUDAD DE MEXICO");
			pyCliente.setCountry("Mexico");
			pyCliente.setPostalCode("11320");
			pyCliente.setPhone(tel);
			pyCliente.setFax("");
			pyCliente.setContact("");
			pyCliente.setPuesto("");
			pyCliente.setModoPorcentaje("K");
			pyCliente.setPorcentaje("0");
			pyCliente.setEstatus("A");
			pyCliente.setInstrucCobro("");
			pyCliente.setRemFact("");
			pyCliente.setClienteRfc("XAXX010101000");
			pyCliente.setZona("");
			pyCliente.setDirecto("N");
			pyCliente.setLaboratorio("");
			pyCliente.setMargenLab(0);
			pyCliente.setApartado("S");
			pyCliente.setClaveHorario(0);
			pyCliente.setPSupAlta("S");
			pyCliente.setCantUsuAlta(1);
			pyCliente.setCostoEnvio(0);
			pyCliente.setEnviosGratis(0);
			pyCliente.setMontoEnvio(0);
			pyCliente.setControlEnvios(0);
			pyCliente.setTipoEntrega("S");
			pyCliente.setCredito("N");
			pyCliente.setCuentaSoho("N");
			pyCliente.setManejaCc("N");
			pyCliente.setClasificacion("2SSSSSSS");
			pyCliente.setClase("D");
			pyCliente.setTipo("S");
			fechaImpl.setFormatoFecha("dd-MM-yyyy");
			pyCliente.setUltVisita(fechaImpl.getFechaHoy());
			pyClienteImp.insertRow(pyCliente);
			
			/*************************INSERTA PY CLIENTE M PAGO************************************/
			PyClienteMpago pyClienteMpago = new PyClienteMpago();
			pyClienteMpago.setClienteNum(clienteNum);
			pyClienteMpago.setMpago(1);
			pyClienteMpagoDaoImp.insertRow(pyClienteMpago);
			/*************************INSERTA PY M PAGO CUENTA*************************************/
			PyMpagoCuenta pyMpagoCuenta = new PyMpagoCuenta();
			pyMpagoCuenta.setClienteNum((long) clienteNum);
			pyMpagoCuenta.setCuenta("");
			pyMpagoCuentaDaoImp.insertRow(pyMpagoCuenta);
			/*************************INSERTA CUSTOMER************************************/
			Customer customer = new Customer();
			customer.setCustNum(clienteNum);
			customer.setCustName(usuario);
			customer.setAddress1("LAGO SILVERIO 258");
			customer.setAddress2("LAGO SILVERIO 258");
			customer.setCity("MIGUEL HIDALGO");
			customer.setProvince("CIUDAD DE MEXICO");
			customer.setCountry("Mexico");
			customer.setPostalCode("11320");
			customer.setPhone(tel);
			customer.setTelex("");
			customer.setFax("");
			customer.setDuns("local");
			customer.setArContact("");
			customer.setOpContact("");
			customer.setReceiver("");
			customer.setReceivTel("");
			customer.setBuyerTel("");
			customer.setStandardOrder("N");
			customer.setSalesId(String.valueOf(clienteNum));
			customer.setSaCust("LCCC");
			customer.setCustGroup("2SSSSSSS");
			customer.setPpdColl("C");
			customer.setDunningCode("");
			customer.setTaxRegion("MEXICO");
			customer.setTerrCode("0001");
			customer.setCreditHold("Y");
			customer.setCreditLimit(0);
			customer.setCreditDays(0);
			customer.setLastCredReview("");
			customer.setRating("");
			customer.setEdi("N");
			customer.setArMethod("0");
			customer.setStatFreq("0");
			customer.setInterest("N");
			customer.setTermCode("01");
			customer.setSlmnNum("PED");
			customer.setLicence2("EF");
			customer.setPoRequired("N");
			customer.setPrintInvoice("Y");
			customer.setBackOrder("Y");
			customer.setPpsPrice("N");
			customer.setPromotePrice("Y");
			customer.setOrderConfirm("N");
			customer.setChargeTo(String.valueOf(clienteNum));
			customer.setWhseCode("01");
			customer.setShipVia("5");
			customer.setPriceLevel(1);
			customer.setPriority("");
			customer.setLanguage("2");
			customer.setArMemo("");
			customer.setOpMemo("");
			customer.setBbVendor("");
			customer.setCoopCode("");
			customer.setCoopVendor("");
			customer.setStat("P");
			customer.setArOwing(0);
			customer.setOpenOrder(0);
			customer.setPtdSales(0);
			customer.setLyptdSales(0);
			customer.setYtdSales(0);
			customer.setLytdSales(0);
			customer.setLySales(0);
			customer.setPtdCredit(0);
			customer.setLyptdCredit(0);
			customer.setYtdCredit(0);
			customer.setLytdCredit(0);
			customer.setLyCredit(0);
			customer.setPtdCost(0);
			customer.setLyptdCost(0);
			customer.setYtdCost(0);
			customer.setLytdCost(0);
			customer.setLyCost(0);
			customer.setYtdNoSales(0);
			customer.setLyNoSales(0);
			customer.setYtdNoReturns(0);
			customer.setLyNoReturns(0);
			customer.setLargestBal(0);
			customer.setDateLargestBal("");
			customer.setLastAmtPay(0);
			customer.setLastDatePay("");
			customer.setLastInvAmt(0);
			customer.setInvDateLast("");
			customer.setAvgDaysPay(0);
			customer.setArFuture(0);
			customer.setArCurrent(0);
			customer.setAr30Days(0);
			customer.setAr60Days(0);
			customer.setAr90Days(0);
			customer.setAr120Days(0);
			customer.setShippedPending(0);
			customer.setOrderNote("");
			customer.setTelCharge("");
			customer.setSaOutput("1");
			customer.setLicence1("EF");
			customer.setTaxStatus("Y");
			customer.setInvByGrp("N");
			customer.setPlanOrdFlag("N");
			customer.setGaranCode(1);
			customer.setAceptaBo("");
			customer.setContrasena("");
			customer.setEstatusRed("I");
			customer.setEmailRed("");
			customer.setPtjeCancela(0);
			customer.setSlmn2("PED");
			customer.setSlmn3("PED");
			customer.setDigitov(String.valueOf(clienteNum));
			customer.setRecibePub("N");
			customer.setcNumExt("");
			customer.setcNumInt("");
			customer.setLadaTel("");
			customer.setExtTel1(0);
			customer.setExtTel2(0);
			customer.setExtFax(0);
			customer.setStatFraude("");	
			fechaImpl.setFormatoFecha("dd-MM-yyyy");
			customer.setDateCreated(fechaImpl.getFechaHoy());
			customer.setLastAging(fechaImpl.getFechaHoy());
			customerDaoImp.insertRow(customer);
			/*************************INSERTA TEST TV************************************/
			TestTv testTv = new TestTv();
			testTv.setClienteNum(clienteNum);
			testTv.setTest1("");
			testTv.setTest2("");
			testTv.setTest3("");
			testTvDaoImp.insertRow(testTv);
			/*************************INSERTA CUST GL************************************/
			CustGl custGl = new CustGl();
			custGl.setOrgCode("PDIR");
			custGl.setDivCode("38000");
			custGl.setCustNum(clienteNum);
			custGl.setGlCode(custGlDaoImp.getGlCode(custGl.getOrgCode(), custGl.getDivCode()));
		
			custGlDaoImp.insertRow(custGl);
			/*************************INSERTA PY USUARIO************************************/
			PyUsuario pyUsuario = new PyUsuario();
			pyUsuario.setEmail(email);
			pyUsuario.setCustNum(38000);
			pyUsuario.setUsuarioNum(usuarioNum);
			pyUsuario.setClienteNum(clienteNum);
			if (usuario.length()>9) {
				pyUsuario.setUsuario(usuario.substring(0, 9));
			} else {
				pyUsuario.setUsuario(usuario);
			}
			pyUsuario.setPassword(pass);
			pyUsuario.setNombre(usuario);
			pyUsuario.setEstatus("A");
			pyUsuario.setReserva("S");
			pyUsuario.setIva("N");
			pyUsuario.setClaveIva("SIN IVA");
			pyUsuario.setLimiteCredito(0);
			pyUsuario.setCreditoUtilizado(0);
			pyUsuario.setTipoUsuario("S");
			pyUsuario.setObservacion("PAGINA SOHO");
			pyUsuario.setConPrecio("N");
			pyUsuario.setAltadir("N");
			fechaImpl.setFormatoFecha("dd-MM-yyyy");
			pyUsuario.setUltimaVis(fechaImpl.getFechaHoy());
			pyUsuario.setUsuario(usuario);
			
			pyUsuarioDaoImp.insertRow(pyUsuario);
			/*************************INSERTA FACTURA SOHO************************************/
			PyClienteBo pyClienteBo = new PyClienteBo();
			pyClienteBo.setClienteNum(clienteNum);
			pyClienteBo.setCustNum(38000);
			pyClienteBo.setBackorder("S");
			pyClienteBoDaoImp.insertRow(pyClienteBo);
			/*************************INSERTA PY CON FACTURA************************************/
			PyConFactura pyConFactura = new PyConFactura();
			pyConFactura.setCustNum(pyUsuario.getClienteNum());
			pyConFactura.setFactura("N");
			pyConFacturaDaoImp.insertRow(pyConFactura);
			/**********************INSERTA EL CODIGO DE VERIFICACION************************************************************/
			String codigo = pyclientecodigoImp.codigo();
			PyClienteCodigo PyClienteCodigo = new PyClienteCodigo();
			PyClienteCodigo.setCliente_num(clienteNum);
			PyClienteCodigo.setIsEmpresa(isEmpresa);
			PyClienteCodigo.setCodigo(codigo);
			PyClienteCodigo.setEstatus("I");
			PyClienteCodigo.setCorreo(email);
			PyClienteCodigo.setContrasena(pass);
			if (usuario.length()>9) {
				PyClienteCodigo.setUsuario(usuario.substring(0, 9));
			} else {
				PyClienteCodigo.setUsuario(usuario);
			}			
			pyclientecodigoImp.insertRow(PyClienteCodigo);
			/**********************CORREO EL CODIGO DE VERIFICACION************************************************************/
			pyclientecodigoImp.enviarCorreo(email, codigo);			
			mensaje = "S";
		} catch (Exception e) {
			e.printStackTrace();
			mensaje = "N";
		}
		return mensaje;
	}

	@Override
	public boolean insertamembresiaClinte(int cliente_num) {
		Membresia entidad = new Membresia();		
		try {
			entidad.setCliente_num(cliente_num);
			entidad.setId_afiliacion(2);
			entidad.setComentario("");
			entidad.setEstatus("A");
			adquierenewMemImp.insertRow(entidad);		
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public static String nextToken() {
	    for (int idx = 0; idx < buf.length; ++idx)
	        buf[idx] = symbols[random.nextInt(symbols.length)];
	    return new String(buf);
	}
	
	//NO ES CRM, ES CLIENTE
		@Override
		public PyUsuario validaCredencial(String user, String Password, int user_m) throws SQLException {
			PyUsuario pyUsuario = new PyUsuario();
			String tipoUsuario = "";
			int nivelAcceso = 0;
			int favoritos = 0;
			try {
				String userDec = Seguridad.Desencriptar(user.replace("_UP", "+").replace("_US","/").trim());
				String PasswordDec = Seguridad.Desencriptar(Password.replace("_UP", "+").replace("_US","/").trim());
				pyUsuario = pyUsuarioDaoImp.getPyUsuarioPedidosEnc(userDec, PasswordDec);
				if(pyUsuario == null) { 
					pyUsuario = pyUsuarioDaoImp.getPyUsuarioPedidos(user, Password);
				}
			} catch(Exception e) {
				pyUsuario = pyUsuarioDaoImp.getPyUsuarioPedidos(user, Password);
			}
			if(pyUsuario == null) { //NO EXISTE O ESTA MAL SU PASSWORD
				return pyUsuario;
			}
			tipoUsuario = miEquipoImp.obtieneTipoUsuario(pyUsuario.getUsuarioNum());
			pyUsuario.setTipoUsuarioPed(tipoUsuario);
			
			nivelAcceso = miEquipoImp.getAccionUsuario(pyUsuario.getUsuarioNum(), tipoUsuario);
			pyUsuario.setNivelAcceso(nivelAcceso);
			
			List<ModulosUsuario> listaModulos = miEquipoImp.obtieneModulosUsuario(pyUsuario.getUsuarioNum(), tipoUsuario);
			pyUsuario.setListaModulos(listaModulos);
			
			String token = nextToken() + Long.toString(System.currentTimeMillis() / 1000L);
			
			customerDaoImp.updateToken(pyUsuario.getClienteNum(), token);
			
			pyUsuario.setToken(token);
			
			List<CorreosUsuario> listaCorreos = miEquipoImp.obtieneCorreosUsuario(pyUsuario.getUsuarioNum(), tipoUsuario);
			pyUsuario.setListaCorreos(listaCorreos);
			
			String identificador = miEquipoImp.obtieneIdentificador(pyUsuario.getUsuarioNum(), tipoUsuario);
			pyUsuario.setIdentificador(identificador);
			
			ResenaPedidos resenaPedidos = consultaUltimoEjecutivo(pyUsuario.getClienteNum());
			if (resenaPedidos != null) {
				if (resenaPedidos.getNombre() != null) {
					pyUsuario.setEjecutiva(resenaPedidos.getNombre());
					pyUsuario.setExt(resenaPedidos.getExt());
				} else {
					pyUsuario.setEjecutiva("");
					pyUsuario.setExt("");
				} 
			} else {
				pyUsuario.setEjecutiva("");
				pyUsuario.setExt("");
			}
			if (pyUsuario.getClienteNum() != 233156 && pyUsuario.getClienteNum() != 846601 
					&& pyUsuario.getClienteNum() != 804832 && pyUsuario.getClienteNum() != 817503
					&& pyUsuario.getClienteNum() != 820693 && pyUsuario.getClienteNum() != 223908) {
				//favoritos = countFavoritos((int) pyUsuario.getClienteNum());
				favoritos=1;
			} else {
				favoritos = 21;
			}
			pyUsuario.setFavoritos(favoritos);
			//carritoTempDaoImpS.consultaPartidas((int) pyUsuario.getClienteNum(), (int) pyUsuario.getUsuarioNum(), user_m, "SQL");
			//pyUsuario.setPartidas(carritoTempDaoImp.consultaPartidas((int) pyUsuario.getClienteNum(), (int) pyUsuario.getUsuarioNum(), user_m, "INF"));
			pyUsuario.setPartidas(1);
			
			Afiliacion afiliacion = afiliacionDaoImp.getAfiliacionCliente((int) pyUsuario.getClienteNum());
			boolean afiliado = afiliacion!=null&&(afiliacion.getDescripcion().contains("Afiliacion Libre") || afiliacion.getDescripcion().contains("Afiliacion a Meses Sin Intereses"))&&afiliacion.getEstatus().equals("A")?true:false;
			pyUsuario.setAfiliacion(afiliado);
			
			log.info(pyUsuario.toString());
			return pyUsuario;
		}
		
		@Override
		public PyUsuario validaCredencialClien(String user, String Password, int clien, int user_m) throws SQLException {
			PyUsuario pyUsuario = new PyUsuario();
			int favoritos = 0;
			try
			{
				boolean esBase64Usu = org.apache.commons.codec.binary.Base64.isBase64(user);
				boolean esBase64Pass = org.apache.commons.codec.binary.Base64.isBase64(Password);
				if(esBase64Usu || esBase64Pass)
				{
					byte[] byteUsuArray = org.apache.commons.codec.binary.Base64.decodeBase64(user.getBytes());
					byte[] bytePassArray = org.apache.commons.codec.binary.Base64.decodeBase64(Password.getBytes());
					
					user = new String(byteUsuArray);
					Password = new String(bytePassArray);
				}
				String userDec = Seguridad.Desencriptar(user.replace("_UP", "+").replace("_US","/").trim());
				String PasswordDec = Seguridad.Desencriptar(Password.replace("_UP", "+").replace("_US","/").trim());
				pyUsuario = pyUsuarioImp.getPyUsuarioPedidosEnc(userDec, PasswordDec);
				if(pyUsuario == null) { 
					pyUsuario = pyUsuarioImp.getPyUsuarioPedidos(user, Password);
				}
			}
			catch(Exception e)
			{
				log.info("Error al desencriptar credenciales");
				pyUsuario = pyUsuarioImp.getPyUsuarioPedidos(user, Password);
			}
			
			if(pyUsuario == null) 
			{
				pyUsuario = pyUsuarioImp.getPyUsuarioPedidosClien(clien);
				if(pyUsuario == null) 
				{
					return pyUsuario;
				}
			}
			String tipoUsuario = "tienda virtual";
			pyUsuario.setTipoUsuarioPed(tipoUsuario);
			
			int nivelAcceso = miEquipoImp.getAccionUsuario(pyUsuario.getUsuarioNum(), tipoUsuario);
			pyUsuario.setNivelAcceso(nivelAcceso);
			
			List<ModulosUsuario> listaModulos = miEquipoImp.obtieneModulosUsuario(pyUsuario.getUsuarioNum(), tipoUsuario);
			pyUsuario.setListaModulos(listaModulos);
			
			pyUsuario.setToken("");
			
			List<CorreosUsuario> listaCorreos = miEquipoImp.obtieneCorreosUsuario(pyUsuario.getUsuarioNum(), tipoUsuario);
			pyUsuario.setListaCorreos(listaCorreos);
			
			String identificador = miEquipoImp.obtieneIdentificador(pyUsuario.getUsuarioNum(), tipoUsuario);
			pyUsuario.setIdentificador(identificador);
			
			ResenaPedidos resenaPedidos = consultaUltimoEjecutivo(pyUsuario.getClienteNum());
			if (resenaPedidos != null) {
				if (resenaPedidos.getNombre() != null) {
					pyUsuario.setEjecutiva(resenaPedidos.getNombre());
					pyUsuario.setExt(resenaPedidos.getExt());
				} else {
					pyUsuario.setEjecutiva("");
					pyUsuario.setExt("");
				} 
			} else {
				pyUsuario.setEjecutiva("");
				pyUsuario.setExt("");
			}
			if (pyUsuario.getClienteNum() != 233156 && pyUsuario.getClienteNum() != 846601 
					&& pyUsuario.getClienteNum() != 804832 && pyUsuario.getClienteNum() != 817503 
					&& pyUsuario.getClienteNum() != 820693) {
				favoritos = countFavoritos((int) pyUsuario.getClienteNum());
			} else {
				favoritos = 21;
			}
			pyUsuario.setFavoritos(favoritos);
			//pyUsuario.setPartidas(carritoTempDaoImpS.consultaPartidas((int) pyUsuario.getClienteNum(), (int) pyUsuario.getUsuarioNum(), user_m, "SQL"));
			pyUsuario.setPartidas(carritoTempDaoImp.consultaPartidas((int) pyUsuario.getClienteNum(), (int) pyUsuario.getUsuarioNum(), user_m, "INF"));
			
			Afiliacion afiliacion = afiliacionDaoImp.getAfiliacionCliente((int) pyUsuario.getClienteNum());
			boolean afiliado = afiliacion!=null&&(afiliacion.getDescripcion().contains("Afiliacion Libre") || afiliacion.getDescripcion().contains("Afiliacion a Meses Sin Intereses"))&&afiliacion.getEstatus().equals("A")?true:false;
			pyUsuario.setAfiliacion(afiliado);
			
			log.info(pyUsuario.toString());
			return pyUsuario;
		}
		
		public String UpdateCodigo(String codigo, String correo) {
			JSONObject isActualizado = new JSONObject();		
			try {
				isActualizado.put("estatus", "ERROR");
				PyClienteCodigo cliente = pyclientecodigoImp.existeCodigo(codigo,correo);
				if(cliente.getEstatus() != null) {
					if("I".equals(cliente.getEstatus())) {
						if(pyclientecodigoImp.UpdateEstatus(codigo)) {
							isActualizado.put("estatus", "OK");
							isActualizado.put("correo", cliente.getCorreo());
							isActualizado.put("pass", cliente.getContrasena());
							isActualizado.put("usu", cliente.getUsuario());
							isActualizado.put("isEmp", cliente.getIsEmpresa());
							pyclientecodigoImp.enviarCorreoBienvenida(cliente.getCorreo(), cliente.getUsuario());					
						}else {
							isActualizado.put("estatus", "ERROR AL ACTUALIZAR CODIGO");
						}
					}else {
						isActualizado.put("estatus", "EL CODIGO ES INVALIDO ");
					}				
				}else {
					isActualizado.put("estatus", "CODIGO INVALIDO");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return isActualizado.toString();
		}
		
		public String isCodigoVerificado(String correo, String contrasena) {
			PyClienteCodigo cliente = new PyClienteCodigo();
			String isVerificado="I";
			try {
				cliente=pyclientecodigoImp.DataPyClienteCodigo(correo);
				if(cliente.getEstatus() != null) {
					if(contrasena.equals(cliente.getContrasena())) {
						isVerificado=cliente.getEstatus();
					}else {
						isVerificado="C";
					}
				}else {
					isVerificado="A";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}		
			return isVerificado;
		}	
		
		public String reenviarCodigo(String correo) {
			String isEnvido="NO ENVIADO";
			try {
				PyClienteCodigo cliente = pyclientecodigoImp.DataPyClienteCodigo(correo);
				if(cliente != null) {
					isEnvido=pyclientecodigoImp.reenviarCodigo(cliente);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return isEnvido;
		}
		
		@Override
		public String validaUsuario(String usuario) throws SQLException {		
			return pyUsuarioImp.validaUsuario(usuario);		
		}
		
		@Override
		public void enviacorreoPedidos(String email) throws SQLException {
			try {
				List<String> correos = new ArrayList<String>();
				CotizacionPedidos cotizacionPedidos = new CotizacionPedidos();
				cotizacionPedidos.setNombre(email);
				correos.add(email);
				
				ObjectMapper m = new ObjectMapper();
				Map<String, Object> props = m.convertValue(cotizacionPedidos, Map.class);
				mailPedidosImp.enviaMailPass(props, correos);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
