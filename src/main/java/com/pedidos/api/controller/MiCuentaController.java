package com.pedidos.api.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.expression.ParseException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pedidos.api.Servicios;
import com.pedidos.api.dao.LectoresJson;
import com.pedidos.api.dao.MiCuentaDao;
import com.pedidos.api.dao.MiEquipoDao;
import com.pedidos.api.dao.MisFacturasImp;
import com.pedidos.api.dao.PyItemsFavoritosDao;
import com.pedidos.api.model.DatoFactNuevo;
import com.pedidos.api.model.PyItemsFavoritos;

@CrossOrigin("*")
@RestController
@RequestMapping("/miCuenta/")
public class MiCuentaController {
	
	private static final Logger log = Logger.getLogger(MiCuentaController.class);
	private ObjectMapper objectMapper = null;
	
	@Autowired
	private MiCuentaDao miCuentaDaoImp;
	
	@Autowired
	private PyItemsFavoritosDao pyItemsFavoritosDao;
	
	@Autowired
	private MisFacturasImp misFacturasImp;
	
	@Autowired
	private LectoresJson lectorJson;
	
	@Autowired
	private MiEquipoDao miEquipoImp;
	
	Servicios ser = new Servicios();
	
	@RequestMapping(value="obtieneMisDatos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneMisDatos(@RequestParam(required = true) Long usuarioNum) {
			
		String resultado =  ser.POS("","POST", "/miCuenta/obtieneMisDatos?usuarioNum="+usuarioNum);
		System.out.println("miCuenta/obtieneMisDatos?usuarioNum="+usuarioNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="registraMisDatos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object registraMisDatos(@RequestBody String tipoMiCuenta) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject tipoMiCuentaString = new JSONObject (tipoMiCuenta.toString());
		System.out.println("tipoMiCuentaString: "+tipoMiCuentaString);
		return ser.POS(tipoMiCuentaString.toString(),"POST", "/miCuenta/registraMisDatos");
	}
	
	@RequestMapping(value="obtieneTelefonos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneTelefonos(@RequestParam(required = true) Long usuarioNum) {
			
		String resultado =  ser.POS("","POST", "/miCuenta/obtieneTelefonos?usuarioNum="+usuarioNum);
		System.out.println("miCuenta/obtieneTelefonos?usuarioNum="+usuarioNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneTipoTelefono", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object obtieneTipoTelefono() throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		String resultado = ser.POS("","POST", "/miCuenta/obtieneTipoTelefono");
		System.out.println("/miCuenta/obtieneTipoTelefono: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="cambioContrasena", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String cambioContrasena(@RequestParam(required = true) Long usuarioNum, @RequestParam(required = true) String contrasenaA, @RequestParam(required = true) String contrasenaN, @RequestParam(required = true) String contrasenaN2) {
		
		String resultado =  ser.POS("","POST", "/miCuenta/cambioContrasena?usuarioNum="+usuarioNum+"&contrasenaA="+contrasenaA+"&contrasenaN="+contrasenaN+"&contrasenaN2="+contrasenaN2);
		System.out.println("/miCuenta/cambioContrasena?usuarioNum="+usuarioNum+"&contrasenaA="+contrasenaA+"&contrasenaN="+contrasenaN+"&contrasenaN2="+contrasenaN2);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="cambioContrasena2", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String cambioContrasena2(@RequestParam(required = true) String email, @RequestParam(required = true) String contrasenaN, @RequestParam(required = true) String contrasenaN2) {
		
		String resultado =  ser.POS("","POST", "/miCuenta/cambioContrasena2?email="+email+"&contrasenaN="+contrasenaN+"&contrasenaN2="+contrasenaN2);
		System.out.println("/miCuenta/cambioContrasena2?email="+email+"&contrasenaN="+contrasenaN+"&contrasenaN2="+contrasenaN2);
		System.out.println("Resultado: "+resultado);
		
		//return miCuentaDaoImp.cambioContrasena2(email,contrasenaN,contrasenaN2);
		return resultado;
	}
	
	@RequestMapping(value="cambioPassword", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String cambioPassword(@RequestParam(required=true)String email,@RequestParam(required=true)String passwordI, @RequestParam(required=true)String passwordF) {
		String resultado =  ser.POS("","POST", "/miCuenta/cambioPassword?email="+email+"&passwordI="+passwordI+"&passwordF="+passwordF);
		System.out.println("/miCuenta/cambioPassword?email="+email+"&passwordI="+passwordI+"&passwordF="+passwordF);
		System.out.println("Resultado: "+resultado);
		
		return resultado;
	}
	
	@RequestMapping(value="agregaTelCel", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object agregaTelCel(@RequestBody String pyTelefonoCliente) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject pyTelefonoClienteString = new JSONObject (pyTelefonoCliente.toString());
		System.out.println("pyTelefonoClienteString: "+pyTelefonoClienteString);
		return ser.POS(pyTelefonoClienteString.toString(),"POST", "/miCuenta/agregaTelCel");
	}
	
	@RequestMapping(value="todosMisTelefonos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String todosMisTelefonos(@RequestParam(required = true) Long clienteNum, @RequestParam(required = true) Long usuarioNum) {
		
		String resultado =  ser.POS("","POST", "/miCuenta/todosMisTelefonos?clienteNum="+clienteNum+"&usuarioNum="+usuarioNum);
		System.out.println("/miCuenta/todosMisTelefonos?clienteNum="+clienteNum+"&usuarioNum="+usuarioNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="editarMisTelefonos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object editarMisTelefonos(@RequestBody String telefonosPedidosCuenta) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject telefonosPedidosCuentaString = new JSONObject (telefonosPedidosCuenta.toString());
		System.out.println("telefonosPedidosCuentaString: "+telefonosPedidosCuentaString);
		return ser.POS(telefonosPedidosCuentaString.toString(),"POST", "/miCuenta/editarMisTelefonos");
	}

	@RequestMapping(value="actualizarNotificaciones", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody int actualizarNotificaciones(@RequestParam(required = true) Long usuarioNum,
			@RequestParam(required = true) String telFijo, @RequestParam(required = true) String telCelular,
			@RequestParam(required = true) boolean envCliente, @RequestParam(required = true) boolean envMensaje)
			throws JsonParseException, JsonMappingException, IOException, SQLException {
		String resultado  = ser.POS("","POST", "/miCuenta/actualizarNotificaciones?usuarioNum="+usuarioNum+"telFijo="+telFijo+"&telCel="+telCelular+"&envClien="+envCliente+"&envMsg="+envMensaje);
		System.out.println("/miCuenta/actualizarNotificaciones?usuarioNum="+usuarioNum+"telFijo="+telFijo+"&telCel="+telCelular+"&envClien="+envCliente+"&envMsg="+envMensaje);
		System.out.println("Resultado: "+resultado);
		
		return Integer.parseInt(resultado);
	}
	
	@RequestMapping(value="consultaPedidos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String consultaPedidos(@RequestParam(required = true) String clienteNum) {
			
		String resultado =  ser.POS("","POST", "/miCuenta/consultaPedidos?clienteNum="+clienteNum);
		System.out.println("miCuenta/consultaPedidos?clienteNum="+clienteNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="consultaPedidosFecha", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String consultaPedidosFecha(@RequestParam(required = true) long clienteNum, @RequestParam(required = true) String fechaPedidos) {
		
		String resultado =  ser.POS("","POST", "/miCuenta/consultaPedidosFecha?clienteNum="+clienteNum+"&fechaPedidos="+fechaPedidos);
		System.out.println("/miCuenta/consultaPedidosFecha?clienteNum="+clienteNum+"&fechaPedidos="+fechaPedidos);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="consultaFacturas", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String consultaFacturas(@RequestParam(required = true) long clienteNum, @RequestParam(required = true) String fechaFacturas) {
		
		String resultado =  ser.POS("","POST", "/miCuenta/consultaFacturas?clienteNum="+clienteNum+"&fechaFacturas="+fechaFacturas);
		System.out.println("/miCuenta/consultaFacturas?clienteNum="+clienteNum+"&fechaFacturas="+fechaFacturas);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="detallePedido", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String detallePedido(@RequestParam(required = true) long clienteNum, @RequestParam(required = true) long pedidoNum) {
		
		String resultado =  ser.POS("","POST", "/miCuenta/detallePedido?clienteNum="+clienteNum+"&pedidoNum="+pedidoNum);
		System.out.println("/miCuenta/detallePedido?clienteNum="+clienteNum+"&pedidoNum="+pedidoNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="consultaNotasFecha", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String consultaNotasFecha(@RequestParam(required = true) long clienteNum, @RequestParam(required = true) String fechaNotas) {
		
		String resultado =  ser.POS("","POST", "/miCuenta/consultaNotasFecha?clienteNum="+clienteNum+"&fechaNotas="+fechaNotas);
		System.out.println("/miCuenta/consultaNotasFecha?clienteNum="+clienteNum+"&fechaNotas="+fechaNotas);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneNotasByRfc", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String notasByRfc(@RequestParam(required = true)String clienteNum, @RequestParam(required = true) String rfc) {
		
		String resultado =  ser.POS("","POST", "/miCuenta/obtieneNotasByRfc?clienteNum="+clienteNum+"&rfc="+rfc);
		System.out.println("/miCuenta/obtieneNotasByRfc?clienteNum="+clienteNum+"&rfc="+rfc);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="detalleNc", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String detalleNc(@RequestParam(value="cliente") String clienteNum, @RequestParam(value="nc") String nc) {
		
		String resultado =  ser.POS("","POST", "/miCuenta/detalleNc?clienteNum="+clienteNum+"&nc="+nc);
		System.out.println("/miCuenta/detalleNc?clienteNum="+clienteNum+"&nc="+nc);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="cancelaPedido", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String cancelaPedido(@RequestParam(required = true) long clienteNum, @RequestParam(required = true) String pedidoNum) {
		
		String resultado =  ser.POS("","POST", "/miCuenta/cancelaPedido?clienteNum="+clienteNum+"&pedidoNum="+pedidoNum);
		System.out.println("/miCuenta/cancelaPedido?clienteNum="+clienteNum+"&pedidoNum="+pedidoNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="pagaPedido", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String pagaPedido(@RequestParam(required = true) long clienteNum, @RequestParam(required = true) long pedidoNum) {
		
		String resultado =  ser.POS("","POST", "/miCuenta/pagaPedido?clienteNum="+clienteNum+"&pedidoNum="+pedidoNum);
		System.out.println("/miCuenta/pagaPedido?clienteNum="+clienteNum+"&pedidoNum="+pedidoNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="validaCliente", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String validaCliente(@RequestParam(required = true) long clienteNum, @RequestParam(required = true) long pedidoNum) {
		
		String resultado =  ser.POS("","POST", "/miCuenta/validaCliente?clienteNum="+clienteNum+"&pedidoNum="+pedidoNum);
		System.out.println("/miCuenta/validaCliente?clienteNum="+clienteNum+"&pedidoNum="+pedidoNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneCarrito", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneCarrito(@RequestParam(required = true) long clienteNum, @RequestParam(required = true) long pedidoNum) {
		
		String resultado =  ser.POS("","POST", "/miCuenta/obtieneCarrito?clienteNum="+clienteNum+"&pedidoNum="+pedidoNum);
		System.out.println("/miCuenta/obtieneCarrito?clienteNum="+clienteNum+"&pedidoNum="+pedidoNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="consultaArchivo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String consultaArchivo(@RequestParam(required = true) long clienteNum, @RequestParam(required = true) String invoice, @RequestParam(required = true) String extension) {
		
		String resultado =  ser.POS("","POST", "/miCuenta/obtieneArchivo?clienteNum="+clienteNum+"&invoice="+invoice+"&extension="+extension);
		System.out.println("/miCuenta/obtieneArchivo?clienteNum="+clienteNum+"&invoice="+invoice+"&extension="+extension);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneDatosFacturacion", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object obtieneDatosFacturacion(@RequestParam(required = true) long clienteNum) {
		String resultado =  ser.POS("","POST", "/miCuenta/obtieneDatosFacturacion?clienteNum="+clienteNum);
		System.out.println("/miCuenta/obtieneDatosFacturacion?clienteNum="+clienteNum);
		//System.out.println("Resultado: "+resultado);
		//return misFacturasImp.obtieneDatosFacturacion(clienteNum);
		return resultado;
	}
	
	@RequestMapping(value="obtieneCfdi", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneCfdi(@RequestParam(required = true) String tipoPersona) {
		
		String resultado =  ser.POS("","POST", "/miCuenta/obtieneCfdi?tipoPersona="+tipoPersona);
		System.out.println("/miCuenta/obtieneCfdi?tipoPersona="+tipoPersona);
		System.out.println("Resultado cfdi: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="consultaDatoFact", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object consultaDatoFact(@RequestParam(required = true) int rfcNum, @RequestParam(required = true) String rfc, @RequestParam(required = true) long clienteNum) {
		//String resultado =  ser.POS("","POST", "/miCuenta/consultaDatoFact?rfcNum="+rfcNum+"&rfc="+rfc+"&clienteNum="+clienteNum);
		System.out.println("/miCuenta/consultaDatoFact?rfcNum="+rfcNum+"&rfc="+rfc+"&clienteNum="+clienteNum);
		//System.out.println("Resultado: "+ressultado);
		return misFacturasImp.consultaDatoFact(rfcNum,rfc,clienteNum);
	}
	
	@RequestMapping(value="obtieneMPago", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneMPago() {
		
		String resultado =  ser.POS("","POST", "/miCuenta/obtieneMPago");
		System.out.println("/miCuenta/obtieneMPago");
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="consultaCp", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String consultaCp(@RequestParam(required = true) String cp) {
		
		String resultado =  ser.POS("","POST", "/miCuenta/consultaCp?cp="+cp);
		System.out.println("/miCuenta/consultaCp?cp="+cp);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="guardaDatoFactNuevo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object guardaDatoFactNuevo(@RequestBody String datoFactNuevo) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject datoFactNuevoString = new JSONObject (datoFactNuevo.toString());
		String resultado =  ser.POS(datoFactNuevoString.toString(),"POST", "/miCuenta/guardaDatoFactNuevo");		
		System.out.println("datoFactNuevoString: "+datoFactNuevoString.toString());
		return resultado;
	}
	@RequestMapping(value="editaDatoFac", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object editaDatoFac(@RequestBody String datoFactNuevo) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject datoFactNuevoString = new JSONObject (datoFactNuevo.toString());
		String resultado =  ser.POS(datoFactNuevoString.toString(),"POST", "/miCuenta/editaDatoFac");
		System.out.println("datoFactNuevoString: "+datoFactNuevoString.toString());
		return resultado;
	}
	
	
	@RequestMapping(value="eliminaRfc", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String eliminaRfc(@RequestParam(required = true) int rfcNum, @RequestParam(value="rfc") String rfc, @RequestParam(required = true) long clienteNum) {
		String resultado = ser.POS("","POST", "/miCuenta/eliminaRfc?rfcNum="+rfcNum+"&rfc="+rfc+"&clienteNum="+clienteNum);
		if(resultado.indexOf("error") == -1) {
			misFacturasImp.eliminaRfc(rfcNum,rfc,clienteNum);
		}		
		System.out.println("/miCuenta/eliminaRfc?rfcNum="+rfcNum+"&rfc="+rfc+"&clienteNum="+clienteNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="consultaDirecciones", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String consultaDirecciones(@RequestParam(required = true) long clienteNum) {
		
		String resultado =  ser.POS("","POST", "/miCuenta/consultaDirecciones?clienteNum="+clienteNum);
		System.out.println("/miCuenta/consultaDirecciones?clienteNum="+clienteNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="eliminaDireccion", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String eliminaDireccion(@RequestParam(required = true) int dirNum, @RequestParam(required = true) long clienteNum) {
		
		String resultado =  ser.POS("","POST", "/miCuenta/eliminaDireccion?dirNum="+dirNum+"&clienteNum="+clienteNum);
		System.out.println("/miCuenta/eliminaDireccion?dirNum="+dirNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="agregaDireccion", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object agregaDireccion(@RequestBody String pyDirEnvioJson) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject pyDirEnvioJsonString = new JSONObject (pyDirEnvioJson.toString());
		System.out.println("pyDirEnvioJsonString: "+pyDirEnvioJsonString);
		return ser.POS(pyDirEnvioJsonString.toString(),"POST", "/miCuenta/agregaDireccion");
	}
	
	@RequestMapping(value="actualizaDatos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object actualizaDatos(@RequestBody String datoCliente) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject datoClienteString = new JSONObject (datoCliente.toString());
		System.out.println("datoClienteString: "+datoClienteString);
		return ser.POS(datoClienteString.toString(),"POST", "/miCuenta/actualizaDatos");
	}
	
	@RequestMapping(value="consultaAfiliacion", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String consultaAfiliacion(@RequestParam(required = true) long clienteNum) {
		
		String resultado =  ser.POS("","POST", "/miCuenta/consultaAfiliacion?clienteNum="+clienteNum);
		System.out.println("/miCuenta/consultaAfiliacion?clienteNum="+clienteNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="consultaEjecutivo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String consultaEjecutivo(@RequestParam(required = true) long clienteNum) {
		
		String resultado =  ser.POS("","POST", "/miCuenta/consultaEjecutivo?clienteNum="+clienteNum);
		System.out.println("/miCuenta/consultaEjecutivo?clienteNum="+clienteNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="guardaEjecutivo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object guardaEjecutivo(@RequestBody String pyLayoutEjecutiva) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject pyLayoutEjecutivaString = new JSONObject (pyLayoutEjecutiva.toString());
		System.out.println("pyLayoutEjecutivaString: "+pyLayoutEjecutivaString);
		return ser.PUT(pyLayoutEjecutivaString.toString(), "/miCuenta/guardaEjecutivo");
	}
	
	@RequestMapping(value="consultaTransportista", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String consultaTransportista(@RequestParam(required = true) long clienteNum) {
		
		String resultado =  ser.POS("","POST", "/miCuenta/consultaTransportista?clienteNum="+clienteNum);
		System.out.println("/miCuenta/consultaTransportista?clienteNum="+clienteNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="guardaTransportista", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object guardaTransportista(@RequestBody String pyLayoutMailJson) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject pyLayoutMailJsonString = new JSONObject (pyLayoutMailJson.toString());
		System.out.println("pyLayoutMailJsonString: "+pyLayoutMailJsonString);
		return ser.PUT(pyLayoutMailJsonString.toString(), "/miCuenta/guardaTransportista");
	}
	
	@RequestMapping(value="consultaFacturaRma", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String consultaFacturaRma(@RequestParam(required = true) String invoiceNum, @RequestParam(required = true) Long clienteNum) {
		
		String resultado =  ser.POS("","POST", "/miCuenta/consultaFacturaRma?clienteNum="+clienteNum+"&invoiceNum="+invoiceNum);
		System.out.println("/miCuenta/consultaFacturaRma?clientenum="+clienteNum+"&invoiceNum="+invoiceNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="consultaInfoFacturaRma", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String consultaInfoFacturaRma(@RequestParam(required = true) long clienteNum, @RequestParam(required = true) String invoiceNum) {
		
		String resultado =  ser.POS("","POST", "/miCuenta/consultaInfoFacturaRma?clienteNum="+clienteNum+"&invoiceNum="+invoiceNum);
		System.out.println("/miCuenta/consultaInfoFacturaRma?clienteNum="+clienteNum+"&invoiceNum="+invoiceNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="generaRma", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String generaRma(@RequestBody String request) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject requestString = new JSONObject (request.toString());
		System.out.println("/miCuenta/generaRma request: "+request.toString());
		return ser.POS(requestString.toString(),"POST", "/miCuenta/generaRma");
	}
	
	@RequestMapping(value="imprimeRma", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String imprimeRma(@RequestParam(required = true) int garantNum, @RequestParam(required = true) int folioGr, @RequestParam(required = true) String divCode, @RequestParam(required = true) long clienteNum) {
		
		String resultado =  ser.POS("","POST", "/miCuenta/imprimeRma?clienteNum="+clienteNum+"&garantNum="+garantNum+"&folioGr="+folioGr+"&divCode="+divCode);
		System.out.println("/miCuenta/imprimeRma?clienteNum="+clienteNum+"&garantNum="+garantNum+"&folioGr="+folioGr+"&divCode="+divCode);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="registraUsuario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object registraUsuario(HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject requestString = new JSONObject (request.toString());
		System.out.println("/miCuenta/registraUsuario request: "+requestString.toString());
		
		
		String mensaje = "";
	    try
	    {
		    JSONObject jsonO = lectorJson.leeJson(request);
	    	log.info("Registra usuario: "+jsonO.toString());
	    	mensaje = miEquipoImp.registraUsuario(jsonO,0);
	    }
	    catch (Exception ex)
	    {
	    	ex.printStackTrace();
	        log.error("Error al registrar usuario");
	        mensaje = "ERRORocurrio un problema al guardar el usuario";
	    }
		log.info(mensaje);
		
		return ser.POS(requestString.toString(),"POST", "/miCuenta/registraUsuario");
		
		//return mensaje;
	}
	
	@RequestMapping(value="obtieneEquipo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneEquipo(@RequestParam(required = true) long clienteNum) {
		
		String resultado =  ser.POS("","POST", "/miCuenta/obtieneEquipo?clienteNum="+clienteNum);
		System.out.println("/miCuenta/consultaTransportista?clienteNum="+clienteNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneCatModulos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneCatModulos() {
		
		String resultado =  ser.POS("","POST", "/miCuenta/obtieneCatModulos");
		System.out.println("/miCuenta/obtieneCatModulos");
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneCatCorreos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneCatCorreos() {
		
		String resultado =  ser.POS("","POST", "/miCuenta/obtieneCatCorreos");
		System.out.println("/miCuenta/obtieneCatModulos");
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtienePermisosUsuario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtienePermisosUsuario(@RequestParam(required = true) long usuarioNum, @RequestParam(required = true) String email) {
		
		String resultado =  ser.POS("","POST", "/miCuenta/obtienePermisosUsuario?usuarioNum="+usuarioNum+"&email="+email);
		System.out.println("/miCuenta/obtienePermisosUsuario?usuarioNum="+usuarioNum+"&email="+email);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="modificaUsuario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object modificaUsuario(HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject requestString = new JSONObject (request.toString());
		System.out.println("/miCuenta/modificaUsuario request: "+requestString.toString());
		
		String mensaje = "";
	    try
	    {
		    JSONObject jsonO = lectorJson.leeJson(request);
	    	log.info("Modifica Usuario: "+jsonO.toString());
	    	mensaje = miEquipoImp.modificaUsuario(jsonO);
	    }
	    catch (Exception ex)
	    {
	    	ex.printStackTrace();
	        log.error("Error al registrar usuario");
	        mensaje = "ERRORocurrio un problema al modificar el usuario";
	    }
		log.info(mensaje);
//		return mensaje;
		
		return ser.POS(requestString.toString(),"POST", "/miCuenta/modificaUsuario");
	}
	
	@RequestMapping(value="desactivaUsuario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object desactivaUsuario(HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject requestString = new JSONObject (request.toString());
		System.out.println("/miCuenta/desactivaUsuario request: "+requestString.toString());
		
		String mensaje = "";
	    try
	    {
		    JSONObject jsonO = lectorJson.leeJson(request);
	    	log.info("Desactiva Usuario: "+jsonO.toString());
	    	mensaje = miEquipoImp.estatusUsuario(jsonO,"I");
	    }
	    catch (Exception ex)
	    {
	    	ex.printStackTrace();
	        log.error("Error al desactivar usuario");
	        mensaje = "ERRORocurrio un problema al desactivar el usuario";
	    }
		log.info(mensaje);
		//
		
		return ser.POS(requestString.toString(),"POST", "/miCuenta/desactivaUsuario");
	}
	
	@RequestMapping(value="activaUsuario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object activaUsuario(HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject requestString = new JSONObject (request.toString());
		System.out.println("/miCuenta/activaUsuario request: "+requestString.toString());
		
		String mensaje = "";
	    try
	    {
		    JSONObject jsonO = lectorJson.leeJson(request);
	    	log.info("Activa Usuario: "+jsonO.toString());
	    	mensaje = miEquipoImp.estatusUsuario(jsonO,"A");
	    }
	    catch (Exception ex)
	    {
	    	ex.printStackTrace();
	        log.error("Error al activar usuario");
	        mensaje = "ERRORocurrio un problema al activar el usuario";
	    }
		log.info(mensaje);
//		return mensaje;

		return ser.POS(requestString.toString(),"POST", "/miCuenta/activaUsuario");
	}
	
	@RequestMapping(value="adminUsuario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object adminUsuario(HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject requestString = new JSONObject (request.toString());
		System.out.println("/miCuenta/adminUsuario request: "+requestString.toString());
		
		String mensaje = "";
	    try
	    {
		    JSONObject jsonO = lectorJson.leeJson(request);
	    	log.info("Admin Usuario: "+jsonO.toString());
	    	mensaje = miEquipoImp.asignaAdmin(jsonO);
	    }
	    catch (Exception ex)
	    {
	    	ex.printStackTrace();
	        log.error("Error al nombrar admin al usuario");
	        mensaje = "ERRORocurrio un problema al asignar el usuario";
	    }
		log.info(mensaje);
//		return mensaje;
		
		return ser.POS(requestString.toString(),"POST", "/miCuenta/adminUsuario");
	}
	
	@RequestMapping(value="validaEstatusUsuario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String validaEstatusUsuario(@RequestParam(required = true) long usuarioNum) {
		
		String resultado =  ser.POS("","POST", "/miCuenta/validaEstatusUsuario?usuarioNum="+usuarioNum);
		System.out.println("/miCuenta/validaEstatusUsuario?usuarioNum="+usuarioNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneModulosUsuario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object obtieneModulosUsuario(@RequestBody String request) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject requestString = new JSONObject (request.toString());
		System.out.println("obtieneModulosUsuario request: "+requestString.toString());
		return ser.POS(requestString.toString(),"POST", "/miCuenta/obtieneModulosUsuario");
	}
	
	@RequestMapping(value="obtieneFavoritosFrecuentes", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneFavoritosFrecuentes(@RequestParam(required = true) long clienteNum) {
		
		String resultado =  ser.POS("","POST", "/miCuenta/obtieneFavoritosFrecuentes?clienteNum="+clienteNum);
		return resultado;
	}
	
	@RequestMapping(value="eliminaFavorito", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object eliminaFavorito(@RequestParam(required = true) long cliente, @RequestParam(required = true) String itemNum) {
		
		String resultado =  ser.POS("","POST", "/miCuenta/eliminaFavorito?cliente="+cliente+"&itemNum="+itemNum);
		System.out.println("/miCuenta/eliminaFavorito?cliente="+cliente+"&itemNum="+itemNum);
		System.out.println("Resultado: "+resultado);
		System.out.println("Elimina Fav Cloud");
		return ("OK".equals(resultado))?pyItemsFavoritosDao.eliminaFavorito(cliente, itemNum):resultado;
	}
	
	@RequestMapping(value="agregarFavorito", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String agregarFavorito(@RequestParam(required = true) long cliente_num,@RequestParam(required = true) String item_num,@RequestParam(required = true) int notificacion, @RequestParam(required = true) String precio) {
		
		String resultado =  ser.POS("","POST", "/miCuenta/agregarFavorito?cliente_num="+cliente_num+"&item_num="+item_num+"&notificacion="+notificacion+"&precio="+precio);
		System.out.println("/miCuenta/agregarFavorito?cliente_num="+cliente_num+"&item_num="+item_num+"&notificacion="+notificacion+"&precio="+precio);
		System.out.println("Resultado: "+resultado);
		System.out.println("Add Fav Cloud");
		return ("OK".equals(resultado))?pyItemsFavoritosDao.agregarFavorito(cliente_num, item_num, notificacion, precio):resultado;
	}
	
	@RequestMapping(value="cintaVerde", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String cintaVerde(@RequestParam(required = true) long clienteNum, @RequestParam(required = true) int accion) {
		
		String resultado =  ser.PUT("", "/miCuenta/cintaVerde?clienteNum="+clienteNum+"&accion="+accion);
		System.out.println("/miCuenta/cintaVerde?clienteNum="+clienteNum+"&accion="+accion);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="getCintaVerde", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String getCintaVerde(@RequestParam(required = true) long clienteNum) {
		
		String resultado =  ser.POS("","GET", "/miCuenta/getCintaVerde?clienteNum="+clienteNum);
		System.out.println("/miCuenta/getCintaVerde?clienteNum="+clienteNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="getRefacturacion", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object getRefacturacion(@RequestBody String datosRefacturacion) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject datosRefacturacionString = new JSONObject (datosRefacturacion.toString());
		System.out.println("datosRefacturacionString: "+datosRefacturacionString);
		return ser.POS(datosRefacturacionString.toString(),"POST", "/miCuenta/getRefacturacion");
	}
	
	
}