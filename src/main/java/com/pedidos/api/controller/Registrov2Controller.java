package com.pedidos.api.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.expression.ParseException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.pedidos.api.Servicios;
import com.pedidos.api.dao.RegistroPedidos;

@CrossOrigin("*")
@Component
@RestController
@RequestMapping("/registrov2/")
public class Registrov2Controller {
	
	private static final Logger log = Logger.getLogger(RegistroPedidos.class);
	
	@Autowired
	private RegistroPedidos registroDao;
	

	Servicios ser = new Servicios();
	//Ficha Tecnica
	@RequestMapping(value="createOrder", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object createOrder(@RequestBody String createOrder) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		System.out.println("createOrder: "+createOrder);
		return ser.POS(createOrder,"POST", "/registrov2/createOrder");
	}
	
	//Ficha Tecnica
	@RequestMapping(value="getOrder", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object getOrder(@RequestBody String getOrder) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		System.out.println("getOrder: "+getOrder);
		return ser.POS(getOrder,"POST", "/registrov2/getOrder");
	}
	
	//Ficha Tecnica
	@RequestMapping(value="clientetoken", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneItemCompleto(@RequestParam(required = true) String cust_num) {		
		String resultado =  ser.POS("","POST", "/registrov2/clientetoken?cust_num="+cust_num);
		System.out.println("/registrov2/clientetoken?cust_num="+cust_num);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	//Ficha Tecnica
	@RequestMapping(value="createOrderPayPal", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object createOrderPayPal(@RequestBody String createOrderPayPal,@RequestParam (required = true) String cmid) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		System.out.println("createOrderPayPal: "+createOrderPayPal);
		System.out.println("Proyecto CON CMID");
		System.out.println("/registrov2/createOrderPayPal?cmid="+cmid);
		return ser.POS(createOrderPayPal,"POST", "/registrov2/createOrderPayPal?cmid="+cmid);
	}
	
	//Ficha Tecnica
	@RequestMapping(value="datelePaymentTokens", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String datelePaymentTokens(@RequestParam(required = true) String id) {
		System.out.println("datelePaymentTokens: "+id);
		return ser.POS("","POST", "/registrov2/datelePaymentTokens?id="+id);
	}
	
	//Ficha Tecnica
	@RequestMapping(value="getOrderPayPal", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object getOrderPayPal(@RequestBody String getOrderPayPal,String cmid) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		System.out.println("getOrderPayPal: "+getOrderPayPal);
		System.out.println("/registrov2/getOrderPayPal?cmid="+cmid);
		return ser.POS(getOrderPayPal,"POST", "/registrov2/getOrderPayPal?cmid="+cmid);
	}
	
	//Ficha Tecnica
	@RequestMapping(value="validaIntentosPagoyRfc", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String validaIntentosPagoyRfcPaypal(@RequestParam(required = true) int pedidoNum, @RequestParam(required = true) int clienteNum) {
			
		String resultado =  ser.POS("","POST", "/registrov2/validaIntentosPagoyRfc?pedidoNum="+pedidoNum+"&clienteNum="+clienteNum);
		System.out.println("/registrov2/validaIntentosPagoyRfc?pedidoNum="+pedidoNum+"&clienteNum="+clienteNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="registraCelularesSms", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object registraCelularesSms(@RequestBody String pyCelularSms) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject pyCelularSmsString = new JSONObject (pyCelularSms.toString());
		System.out.println("pyCelularSmsString: "+pyCelularSmsString);
		return ser.POS(pyCelularSmsString.toString(),"POST", "/registrov2/registraCelularesSms");
	}
	
	@RequestMapping(value="afiliacionesBitacora", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object afiliacionesBitacora(@RequestBody String bitPagoAfiliaciones) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject bitPagoAfiliacionesString = new JSONObject (bitPagoAfiliaciones.toString());
		System.out.println("bitPagoAfiliacionesString: "+bitPagoAfiliacionesString);
		return ser.POS(bitPagoAfiliacionesString.toString(),"POST", "/registrov2/afiliacionesBitacora");
	}
	
	@RequestMapping(value="validaUsuario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String validaUsuario(@RequestParam(required = true) String usuario) throws SQLException, JSONException{
		String resultado = registroDao.validaUsuario(usuario);	
		//String resultado =  ser.POS("","POST", "/registrov2/validaUsuario?usuario="+usuario);
		System.out.println("/registrov2/validaUsuario?usuario="+usuario);
		System.out.println("Resultado: "+resultado);		
		return resultado;
	}
	
	@RequestMapping(value="registraUsuarioNuevo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String registraUsuarioNuevo(@RequestBody String data) throws SQLException {
        String resultado =  ser.POS(data,"POST", "/registrov2/registraUsuarioNuevo");    
        return resultado;
    }
	
	@RequestMapping(value="obtieneItemsHome", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneItemsHome(@RequestParam(required = true) long clienteNum, String top, long usuarioNum) {
			
		String resultado =  ser.POS("","POST", "/registrov2/obtieneItemsHome?clienteNum="+clienteNum+"&top="+top+"&usuarioNum="+usuarioNum);
		System.out.println("/registrov2/obtieneItemsHome?clienteNum="+clienteNum+"&top="+top+"&usuarioNum="+usuarioNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="registraFormaPagoTv", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object guardaFormaDePago(@RequestBody String pyFormaPagoTv) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject pyFormaPagoTvString = new JSONObject (pyFormaPagoTv.toString());
		System.out.println("pyFormaPagoTvString: "+pyFormaPagoTvString);
		return ser.PUT(pyFormaPagoTvString.toString(),"/registrov2/registraFormaPagoTv");
	}
	
	@RequestMapping(value="obtienePrecioTotalDesko", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object obtienePrecioTotalDesko(@RequestBody String deskoPedidos) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject deskoPedidosString = new JSONObject (deskoPedidos.toString());
		System.out.println("deskoPedidosString: "+deskoPedidosString);
		return ser.POS(deskoPedidosString.toString(),"POST", "/registrov2/obtienePrecioTotalDesko");
	}
	
	@RequestMapping(value="guardaPagoAlRecibir", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object guardaPagoAlRecibir(@RequestBody String request) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject requestString = new JSONObject (request.toString());
		System.out.println("guardaPagoAlRecibir request: "+requestString.toString());
		return ser.PUT(requestString.toString(), "/registrov2/guardaPagoAlRecibir");
	}
	
	@RequestMapping(value="obtieneDatosCliente", method = RequestMethod.GET)
	public String obtieneDatosCliente(@RequestParam(required = true) String token) {
			
		String resultado =  ser.POS("","GET", "/registrov2/obtieneDatosCliente?token="+token);
		System.out.println("/registrov2/obtieneDatosCliente?token="+token);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="enviacorreoPedidos", method = RequestMethod.GET)
	public String enviacorreoPedidos(@RequestParam(required = true) String email) throws SQLException {
			
		String resultado =  ser.POS("","GET", "/registrov2/enviacorreoPedidos?email="+email);
		System.out.println("/registrov2/enviacorreoPedidos?email="+email);
		System.out.println("Resultado: "+resultado);
	
//		log.info("Entro enviacorreoPedidos");
//		registroDao.enviacorreoPedidos(email);
		return resultado;
	}
	
	@RequestMapping(value="inhabilitadireccion", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public String inhabilitadireccion(@RequestParam(required = true) long clienteNum, @RequestParam(required = true) int dirNum) {
			
		String resultado =  ser.PUT("","/registrov2/inhabilitadireccion?clienteNum="+clienteNum+"&dirNum="+dirNum);
		System.out.println("/registrov2/inhabilitadireccion?clienteNum="+clienteNum+"&dirNum="+dirNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneCliente", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneCliente(@RequestParam(required = true) int cliente) {
			
		String resultado =  ser.POS("","POST", "/registrov2/obtieneCliente?cliente="+cliente);
		System.out.println("/registrov2/obtieneCliente?cliente="+cliente);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="enviacorreoUniclick", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String enviacorreoUniclick(@RequestParam(required = true) String name, String email, String phoneNumber) {
			
		String resultado =  ser.POS("","POST", "/registrov2/enviacorreoUniclick?name="+name+"&email="+email+"&phoneNumber="+phoneNumber);
		System.out.println("/registrov2/enviacorreoUniclick?name="+name+"&email="+email+"&phoneNumber="+phoneNumber);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="UpdatePyClienteCodigo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String UpdatePyClienteCodigo(@RequestParam(value="codigo") String codigo, @RequestParam(value="correo") String correo) {
			
		String resultado =  ser.POS("","POST", "/registrov2/UpdatePyClienteCodigo?codigo="+codigo+"&correo="+correo);
		System.out.println("/registrov2/UpdatePyClienteCodigo?codigo="+codigo+"&correo="+correo);
		System.out.println("Resultado: "+resultado);
		
		//return registroDao.UpdateCodigo(codigo,correo).toString();
		return resultado;
	}
	
	@RequestMapping(value="enviaCorreoCodigo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String enviaCorreoCodigo(@RequestParam(required=true)String email, @RequestParam(required=true)String ip){
		String resultado =  ser.POS("","POST", "/registrov2/enviaCorreoCodigo?email="+email+"&ip="+ip);
		System.out.println("/registrov2/enviaCorreoCodigo?email="+email);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="verificaPasswordCodigo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String verificaCodigo(@RequestParam(required=true)String email,@RequestParam(required=true)String codigo){
		String resultado =  ser.POS("","POST", "/registrov2/verificaPasswordCodigo?email="+email+"&codigo="+codigo);
		System.out.println("/registrov2/enviaCorreoCodigo?email="+email);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="isCodigoVerificado", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String isCodigoVerificado(@RequestParam(value="correo") String correo, @RequestParam(value="contrasena") String contrasena) {
		String resultado =	registroDao.isCodigoVerificado(correo,contrasena).toString();
		//String resultado =  ser.POS("","POST", "/registrov2/isCodigoVerificado?correo="+correo+"&contrasena="+contrasena);
		System.out.println("/registrov2/isCodigoVerificado?correo="+correo+"&contrasena="+contrasena);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="reenviarCodigo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String reenviarCodigo(@RequestParam(value="correo") String correo) {
			
		String resultado =  ser.POS("","POST", "/registrov2/reenviarCodigo?correo="+correo);
		System.out.println("/registrov2/reenviarCodigo?correo="+correo);
		System.out.println("Resultado: "+resultado);
		
		//return registroDao.reenviarCodigo(correo).toString();
		return resultado;
	}
	
	@RequestMapping(value="consultaNcPedido", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String consultaNcPedido(@RequestParam(value="pedidoNum") String pedidoNum, @RequestParam(value="clienteNum") String clienteNum) {
		
		String resultado =  ser.PUT("", "/registrov2/consultaNcPedido?pedidoNum="+pedidoNum+"&clienteNum="+clienteNum);
		System.out.println("/registrov2/consultaNcPedido?pedidoNum="+pedidoNum+"&clienteNum="+clienteNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	//Login
    @RequestMapping(value="validaCredencial", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object validaCredencial(@RequestBody String data) throws SQLException {                
        String resultado =  ser.POS(data,"POST", "/registrov2/validaCredencial");    
        System.out.println("/registrov2/validaCredencial");
        System.out.println("Resultado: "+new JSONObject(resultado) + "");
        return new JSONObject(resultado) + "";
    }
	
	//Login
	@RequestMapping(value="validaCredencialClien", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String validaCredencialClien(@RequestParam String email, @RequestParam String pass, @RequestParam int clien, @RequestParam int user_m) throws SQLException {
			
		String resultado =  ser.POS("","POST", "/registrov2/validaCredencialClien?email="+email+"&pass="+pass+"&clien="+clien+"&user_m="+user_m);
		/*System.out.println("/registrov2/validaCredencialClien?email="+email+"&pass="+pass+"&clien="+clien+"&user_m="+user_m);
		System.out.println("Resultado: "+resultado);
		
		//Habilitar servicio para SQL
		log.info("Entro validaCredencial CRM");
		PyUsuario p = registroDao.validaCredencialClien(email, pass, clien, user_m);
		Map<String, Object> resp = new LinkedHashMap<String, Object>();

		if (p != null) {
			p.setPassword("");
			resp.put("usuario", p);

		} else {
			resp.put("error", "Usuario o Password Invalido");

		}*/
//		return new JSONObject(resp) + "";
		
		return resultado;
	}
	
	//formaPago
	@RequestMapping(value="obtieneFormaPagoYEnvio", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneFormaPagoYEnvio(@RequestParam(required = true) int pedidoNum) {
			
		String resultado =  ser.POS("","POST", "/registrov2/obtieneFormaPagoYEnvio?pedidoNum="+pedidoNum);
		System.out.println("/registrov2/obtieneFormaPagoYEnvio?pedidoNum="+pedidoNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	//formaPago
	@RequestMapping(value="registraPagoVsEntrega", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object registraPagoVsEntrega(@RequestBody String request) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject requestString = new JSONObject (request.toString());
		System.out.println("/registrov2/registraPagoVsEntrega request: "+request.toString());
		return ser.POS(requestString.toString(),"PUT", "/registrov2/registraPagoVsEntrega");
	}
	
	//formaPago
	@RequestMapping(value="agregaEnvio", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String agregaEnvio(@RequestParam(required = true) String pedidoNum, @RequestParam(required = true) Double precioEnvio, @RequestParam(required = true) String paqueteria, @RequestParam(required = true) String contieneMem) {
			
		String resultado =  ser.POS("","POST", "/registrov2/agregaEnvio?pedidoNum="+pedidoNum+"&precioEnvio="+precioEnvio+"&paqueteria="+paqueteria+"&contieneMem="+contieneMem);
		System.out.println("/registrov2/agregaEnvio?pedidoNum="+pedidoNum+"&precioEnvio="+precioEnvio+"&paqueteria="+paqueteria+"&contieneMem="+contieneMem);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	//registroCliente
	@RequestMapping(value="registroCliente", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object registroCliente(@RequestBody String request) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject requestString = new JSONObject (request.toString());
		System.out.println("/registrov2/registroCliente pyFormaPagoTvString: "+requestString.toString());
		return ser.PUT(requestString.toString(),"/registrov2/registroCliente");
	}
	
	//registroCliente
	@RequestMapping(value="obtieneListaDirecciones", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneListaDirecciones(@RequestParam(required = true) int  cp) {
		String resultado =  ser.POS("","POST", "/registrov2/obtieneListaDirecciones?cp="+cp);
		System.out.println("/registrov2/obtieneListaDirecciones?cp="+cp);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="validaCorreo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String validaCorreo(@RequestParam(required = true) String correo, @RequestParam(required = true) long custNum) {
		String resultado =  ser.POS("","POST", "/registrov2/validaCorreo?correo="+correo+"&custNum="+custNum);
		System.out.println("/registrov2/validaCorreo?correo="+correo+"&custNum="+custNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneUsoCFDI", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneUsoCFDI(@RequestParam(value="tipoPersona") String tipoPersona) {

		String resultado =  ser.POS("","POST", "/registrov2/obtieneUsoCFDI?tipoPersona="+tipoPersona);
		System.out.println("/registrov2/obtieneUsoCFDI?tipoPersona="+tipoPersona);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneTipoPersona", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneTipoPersona(@RequestParam(required = true) long cliente_num) {

		String resultado =  ser.POS("","POST", "/registrov2/obtieneTipoPersona?cliente_num="+cliente_num);
		System.out.println("/registrov2/obtieneTipoPersona?cliente_num="+cliente_num);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneEstados", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneEstados() {
		String resultado =  ser.POS("","POST", "/registrov2/obtieneEstados");
		System.out.println("/registrov2/obtieneEstados");
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneDelegacion", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneDelegacion(@RequestParam(required = true) String idestado) {

		String resultado =  ser.POS("","POST", "/registrov2/obtieneDelegacion?idestado="+idestado);
		System.out.println("/registrov2/obtieneDelegacion?idestado="+idestado);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneEjecutivosActivos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneEjecutivosActivos() {
		String resultado =  ser.POS("","POST", "/registrov2/obtieneEjecutivosActivos");
		System.out.println("/registrov2/obtieneEjecutivosActivos");
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneMetodoPago", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneMetodoPago() {
		String resultado =  ser.POS("","POST", "/registrov2/obtieneMetodoPago");
		System.out.println("/registrov2/obtieneMetodoPago");
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneDescuentos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object obtieneDescuentos(@RequestBody String request) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject requestString = new JSONObject (request.toString());
		System.out.println("/registrov2/obtieneDescuentos request: "+requestString.toString());
		return ser.POS(requestString.toString(),"POST", "/registrov2/obtieneDescuentos");
	}
	
	@RequestMapping(value="registradireccion", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object registradireccion(@RequestBody String request) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject requestString = new JSONObject (request.toString());
		System.out.println("/registrov2/registradireccion request: "+requestString.toString());
		return ser.PUT(requestString.toString(), "/registrov2/registradireccion");
	}
	
	@RequestMapping(value="editadireccion", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object editadireccion(@RequestBody String request) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject requestString = new JSONObject (request.toString());
		System.out.println("/registrov2/editadireccion request: "+requestString.toString());
		return ser.PUT(requestString.toString(), "/registrov2/editadireccion");
	}
	
	@RequestMapping(value="obtenerDirecciones", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtenerDirecciones(@RequestParam(required = true) long clienteNum) {

		String resultado =  ser.POS("","POST", "/registrov2/obtenerDirecciones?clienteNum="+clienteNum);
		System.out.println("/registrov2/obtenerDirecciones?clienteNum="+clienteNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtenerRfc2", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtenerRfc2(@RequestParam(required = true) String clienteNum) {

		String resultado =  ser.POS("","POST", "/registrov2/obtenerRfc2?clienteNum="+clienteNum);
		System.out.println("/registrov2/obtenerRfc2?clienteNum="+clienteNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtenerRfc", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtenerRfc(@RequestParam(required = true) String clienteNum) {

		String resultado =  ser.POS("","POST", "/registrov2/obtenerRfc?clienteNum="+clienteNum);
		System.out.println("/registrov2/obtenerRfc?clienteNum="+clienteNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="registraRFC", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object registraRFC(@RequestBody String request) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject requestString = new JSONObject (request.toString());
		System.out.println("/registrov2/registraRFC request: "+requestString.toString());
		return ser.PUT(requestString.toString(),"/registrov2/registraRFC");
	}
	
	@RequestMapping(value="inhabilitaRFC", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String inhabilitaRFC(@RequestParam(required = true) long rfcNum, @RequestParam(required = true) String clienteNum) {
			
		String resultado =  ser.PUT("", "/registrov2/inhabilitaRFC?rfc_num="+rfcNum+"&clienteNum="+clienteNum);
		System.out.println("/registrov2/inhabilitaRFC?rfc_num="+rfcNum+"&clienteNum="+clienteNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneMailContacto", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneMailContacto(@RequestParam(required = true) int clienteNum) {
			
		String resultado =  ser.POS("","POST", "/registrov2/obtieneMailContacto?clienteNum="+clienteNum);
		System.out.println("/registrov2/inhabilitaRFC?clienteNum="+clienteNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="registroClienteMaps", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object registroClienteMaps(@RequestBody String request) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject requestString = new JSONObject (request.toString());
		System.out.println("/registrov2/editadireccion request: "+requestString.toString());
		return ser.PUT(requestString.toString(), "/registrov2/registroClienteMaps");
	}
	
	//PagoPayPalController
	@RequestMapping(value="creaPagoPaypal", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String creaPagoPaypal(@RequestParam(required = true) String pedido) {
			
		String resultado =  ser.POS("","POST", "/registrov2/creaPagoPaypal?pedido="+pedido);
		System.out.println("/registrov2/creaPagoPaypal?pedido="+pedido);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtienePedido", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtienePedido(@RequestParam(required = true) long evento) {
			
		String resultado =  ser.POS("","POST", "/registrov2/obtienePedido?evento="+evento);
		System.out.println("/registrov2/obtienePedido?evento="+evento);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="executePayment", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String executePayment(@RequestParam(required = true) String payerId, String paymentId, String rememberedCard, int clienteNum, int pedido) {
			
		String resultado =  ser.POS("","POST", "/registrov2/executePayment?payerId="+payerId+"&paymentId="+paymentId+"&rememberedCard="+rememberedCard+"&clienteNum="+clienteNum+"&pedido="+pedido);
		System.out.println("/registrov2/executePayment?payerId="+payerId+"&paymentId="+paymentId+"&rememberedCard="+rememberedCard+"&clienteNum="+clienteNum+"&pedido="+pedido);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="liberaPedido", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String liberaPedido(@RequestParam(required = true) String pedidoNum, String idOperacion, double montoPagado, String mensaje, String ip) {
			
		String resultado =  ser.POS("","POST", "/registrov2/liberaPedido?pedidoNum="+pedidoNum+"&idOperacion="+idOperacion+"&montoPagado="+montoPagado+"&mensaje="+mensaje+"&ip="+ip);
		System.out.println("/registrov2/liberaPedido?pedidoNum="+pedidoNum+"&idOperacion="+idOperacion+"&idOperacion="+montoPagado+"&mensaje="+mensaje+"&ip="+ip);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="verificaPago", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String verificaPago(@RequestParam(required = true) int pedidoNum) {
			
		String resultado =  ser.POS("","POST", "/registrov2/verificaPago?pedidoNum="+pedidoNum);
		System.out.println("/registrov2/verificaPago?pedidoNum="+pedidoNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneDetallePago", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneDetallePago(@RequestParam(required = true) int pedidoNum) {
			
		String resultado =  ser.POS("","POST", "/registrov2/obtieneDetallePago?pedidoNum="+pedidoNum);
		System.out.println("/registrov2/obtieneDetallePago?pedidoNum="+pedidoNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="insertaRespuestaError", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String insertaRespuestaError(@RequestParam(required = true) String pedidoNum, String mensaje) {
			
		String resultado =  ser.POS("","POST", "/registrov2/insertaRespuestaError?pedidoNum="+pedidoNum+"&mensaje="+mensaje);
		System.out.println("/registrov2/insertaRespuestaError?pedidoNum="+pedidoNum+"&mensaje="+mensaje);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="actualizaDatosCliente", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateCliente(@RequestParam(required = true) int clienteNum, String mail, String telefono) {
			
		String resultado =  ser.POS("","POST", "/registrov2/actualizaDatosCliente?clienteNum="+clienteNum+"&mail="+mail+"&telefono="+telefono);
		System.out.println("/registrov2/actualizaDatosCliente?clienteNum="+clienteNum+"&mail="+mail+"&telefono="+telefono);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	//Generales.asp
	@RequestMapping(value="obtieneEjecutivoActual", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneEjecutivoActual(@RequestParam(required = true) String cliente_num) {
			
		String resultado =  ser.POS("","POST", "/registrov2/obtieneEjecutivoActual?cliente_num="+cliente_num);
		System.out.println("/registrov2/obtieneEjecutivoActual?cliente_num="+cliente_num);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}	
	
	@RequestMapping(value="countFavoritos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public int countFavoritos(@RequestParam(required = true) int clienteNum) throws SQLException {
			
		String resultado =  ser.POS("","POST", "/registrov2/countFavoritos?clienteNum="+clienteNum);
		System.out.println("/registrov2/countFavoritos?clienteNum="+clienteNum);
		System.out.println("Resultado: "+resultado);

		if (clienteNum != 233156 && clienteNum != 846601 
				&& clienteNum != 804832 && clienteNum != 817503
				&& clienteNum != 820693) {
			return registroDao.countFavoritos(clienteNum); 
		} else {
			return 21;
		}
	}	
	
	@RequestMapping(value="countPartidas", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String countPartidas(@RequestParam(value="clienteNum") int clienteNum, @RequestParam(value="usuarioNum") int usuarioNum) {
			
		String resultado =  ser.POS("","POST", "/registrov2/countPartidas?clienteNum="+clienteNum+"&usuarioNum="+usuarioNum);
		System.out.println("/registrov2/countPartidas?clienteNum="+clienteNum+"&usuarioNum="+usuarioNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="getOrderPayPalOXXO", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getOrderPayPalOXXO(@RequestBody String request) throws JsonParseException, JsonMappingException, IOException, SQLException, ParseException {
		JSONObject requestString = new JSONObject (request.toString());
		System.out.println("getOrderPayPalOXXO request: "+requestString.toString());
		return ser.POS(requestString.toString(),"POST", "/registrov2/getOrderPayPalOXXO");
	}
	
	@RequestMapping(value = "CalculatedFinancingOptions", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String CalculatedFinancingOptions(@RequestParam(required = true)String value, @RequestParam(required = true)String id) throws IOException, JSONException, SQLException {
		System.out.println("CalculatedFinancingOptions");
		return ser.POS("","POST", "/registrov2/CalculatedFinancingOptions?value="+value+"&id="+id);
	}
	
	@RequestMapping(value="obtieneRegimenFiscal", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneRegimenFiscal() {		
		String resultado =  ser.POS("","POST", "/registrov2/obtieneRegimenFiscal");
		System.out.println("/registrov2/obtieneRegimenFiscal");
		System.out.println("Resultado Regimen Fiscal: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="estatusCliente", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String estatuscliente(@RequestParam(required = false)int clienteNum, @RequestParam(required = true)String accion,@RequestParam(required = false) String estatus,@RequestParam(required = false) String email) {		
		String resultado =  ser.POS("","POST", "/registrov2/estatusCliente?clienteNum="+clienteNum+"&accion="+accion+"&estatus="+estatus+"&email="+email);
		System.out.println("Resultado Estatus Cliente: "+resultado);
		return resultado;
	}
	
	
}
