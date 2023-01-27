package com.pedidos.api.dao;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pedidos.api.sql.PickUpSQL;
import com.auth0.jwt.internal.org.apache.commons.io.IOUtils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;

@Service
public class PickUpDaoImp implements PickUpDao {
	
	private static final Logger LOG = Logger.getLogger(PickUpDaoImp.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;	
	
	String sql = ""; 
		
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public String PalabraClave(String factura) {	
		String Palabra   = "";
		long pedido_num  = 0;
		sql = PickUpSQL.PALABRA.toString();
		if(sql != null) {
			SqlRowSet rs = jdbcTemplate.queryForRowSet(sql,factura,factura,factura,factura,factura);			
			if(rs.next()) {
				Palabra		= 	rs.getString("palabra");
				pedido_num	=	rs.getLong("pedido_num");
			}
		}
		
		if(pedido_num > 0) {
			try {
				if(!updatePalabra(pedido_num, Palabra)) {
					Palabra="";
				}
			} catch (Exception e) {
				e.printStackTrace();
				Palabra="";
			}			
		}
		return Palabra;
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public String getEnvioCorreo(long pedido_num) {		
		sql = PickUpSQL.PYPICKUPENC.toString();
		if(sql != null) {
			SqlRowSet rs = jdbcTemplate.queryForRowSet(sql,pedido_num);			
			if(rs.next()) {				
			   String mail 			= isnull(rs.getString("correo"));
			   String factura 		= isnull(rs.getString("factura"));
			   String f_env_corr	= isnull(rs.getString("f_env_corr"));
			   long num_cliente		= 		 rs.getLong("cliente_num");
			   String nombre		= isnull(rs.getString("nombre"));
			   if(!"".equals(mail)) {
				   if(!"".equals(factura)) {
					   if(!"".equals(f_env_corr)) {
						   if(!"".equals(nombre)) {
							   nombre = nombre.split(" ")[0];
							   if(num_cliente > 0) {
								   String opt = "?opt=39";
								   String email = "&email=" + mail;
								   String find = "&find=%26guia,%26dirrecion,%26ciudad,%26codigoPostal,%26facturas,%26hora_entrega,%26noCliente,%26razonSocial,%26quien_recibio,%26tipo_entrega,%26isPickUp";
								   String change = "&change=3J1M6H27AG201537,Alejandro+Dumas+135+Local+A3+135Alejandro+Dumas+135+Local+A3+MIGUEL+HIDALGO,CIUDAD+DE+MEXICO,2032863,"+factura+","+f_env_corr+","+num_cliente+","+nombre+","+nombre+",,S";
								   String name = "&name=212494/20668/1/firma/743.png";
								   String variables = opt + email + find + change+ name;
								   try {
									   String url = "http://192.10.1.8:9081/MandrilAPI/mailAPI"+variables;
									   HttpClient 	client 	= HttpClientBuilder.create().build();
									   HttpGet 		get 	= new HttpGet(url);
									   HttpResponse response = client.execute(get);
									   BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
									   String line = "";
									   while ((line = rd.readLine()) != null) {
										   if(line.trim().equals("Exito")) {
											  return "Enviado al correo "+mail; 
										   }else {
											   return "Error: al enviar "+line;
										   }
									   }
								   } catch (Exception e) {
									  e.printStackTrace();
								   }
							   }else {
								   return "Error: No se encontro el numero del cliente";
							   }
						   }else {
							   return "Error: No se encontro el nombre del cliente";
						   }  
					   }else {
						   return "Error: Sin fecha de envio";
					   }  
				   }else {
					   return "Error: El pedido no se encontro la factura";
				   }				   
			   }else {
				   return "Error: El pedido no cuenta con correo asignado";
			   }
			}
		}
		return "Error: al enviar";
	}
	
	
	@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
	public boolean updatePalabra(long pedido_num,String Palabra) throws Exception{
		sql = PickUpSQL.UPDATEPALABRA.toString();
		if(jdbcTemplate.update(sql,Palabra,pedido_num) > 0) {
			sql = PickUpSQL.UPDATEFECHAINGRESO.toString();
			return (jdbcTemplate.update(sql,pedido_num) > 0);
		}
		return false;
	}	
	
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public JSONObject Login(String usuario, String password) {	
		JSONObject data = new JSONObject("{\"num_empleado\": 0}");
		sql = PickUpSQL.LOGIN.toString()+" AND c.pass= CONVERT(VARCHAR(20), HashBytes('MD5', '"+password+"' + 'agreguesalypimientaalgusto'), 2)";
		if(sql != null) {
			SqlRowSet rs = jdbcTemplate.queryForRowSet(sql,usuario);			
			if(rs.next()) {
				data.put("num_empleado", rs.getLong("num_empleado"));
				data.put("nombre", 		 rs.getString("nombre"));
				data.put("puesto", 		 rs.getString("puesto"));
			}
		}
		return data;
	}
	
	
	
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public JSONObject getNumPedidosPickUP() {	
		JSONObject data = new JSONObject("{\"pickUp\": 0}");
		sql = PickUpSQL.NUMEROS.toString();
		if(sql != null) {
			SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);			
			if(rs.next()) {
				data.put("pickUp", 			rs.getLong("pickUp"));
				data.put("inventario", 		rs.getLong("inventario"));	
				data.put("mantenimiento",	rs.getLong("mantenimiento"));
			}
		}
		return data;
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<JSONObject> PedidosPickUP() {	
		List<JSONObject> data = new ArrayList<JSONObject>();
		sql = PickUpSQL.PEDIDOS.toString();
		if(sql != null) {
			SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
			while(rs.next()) {
				JSONObject datos = new JSONObject();
				datos.put("Pedido", 	rs.getLong("pedido_num"));
				datos.put("Cliente",	rs.getString("nombre"));
				datos.put("Fecha", 		rs.getString("fecha_factura"));
				datos.put("Factura",	rs.getString("factura"));
				data.add(datos);
			}
		}
		if(data.size() == 0) {
			JSONObject datos =new JSONObject();
			datos.put("Pedido", 	0);
			datos.put("Cliente",	"");
			datos.put("Fecha", 		"");
			data.add(datos);
		}
		return data;
	}

	
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public JSONObject getDetallePedidosPickUP(long pedido_num) {		
		List<JSONObject>   	data	= new ArrayList<JSONObject>();
							sql 	= PickUpSQL.CAJASPEDIDO.toString();	
		boolean 			isEscan = true;
		String 				isEstat	= "";
		String 				nombre	= "";
		String 				fecha_factura="";
		String 				pvs		= "";
		double 				precio  = 0;
		if(sql != null) {
			SqlRowSet 	rs 		= jdbcTemplate.queryForRowSet(sql,pedido_num);
			while(rs.next()) {
				
				JSONObject 	datos 	= 	new JSONObject();
				long 		caja 	=	rs.getLong("caja");
				String 		estatus =  	rs.getString("estC");
				 			isEstat	= 	rs.getString("estP");
				 			nombre	=   rs.getString("nombre");
				 	   fecha_factura=	rs.getString("fecha_factura");
				 			pvs		= 	rs.getString("pvs");
				long   order_num	=   rs.getLong("order_num"); 
				datos .put("Caja", 		caja);
				datos .put("Piezas", 	rs.getLong("piezas"));
				datos .put("Estatus", 	estatus);
				isEscan= (isEscan)?("P".equals(estatus))?false:isEscan:isEscan;
				List<JSONObject> detalles = new ArrayList<JSONObject>();
				sql 	= PickUpSQL.SKUCAJA.toString();	
				SqlRowSet 	rsC 		= jdbcTemplate.queryForRowSet(sql,pedido_num,caja,order_num);
				while(rsC.next()) {
					JSONObject detalle = new JSONObject();
					long 	   cantidad		= rsC.getLong("cantidad");
					double     precio_uni   = rsC.getDouble("precio_m");
							   precio       = precio+(precio_uni*cantidad);				    
					detalle.put("Sku", 			rsC.getString("item_num"));
					detalle.put("Descipcion", 	rsC.getString("titulo_m").trim());
					detalle.put("Precio_uni", 	precio_uni);
					detalle.put("Piezas",		cantidad);
					detalles.add(detalle);
				}		
				
				datos .put("skus", 		detalles);
				data.add(datos);
			}
		}
		JSONObject         dataTotal = new JSONObject();
		dataTotal.put("tabla", 			data);
		dataTotal.put("isEscaneado", 	isEscan);
		dataTotal.put("Estatus", 		isEstat);
		dataTotal.put("Nombre", 		nombre);
		dataTotal.put("FechaFactura", 	fecha_factura);
		dataTotal.put("Pvs", 			pvs);
		dataTotal .put("Precio", 	    precio);
		return dataTotal;
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public boolean  validaCodigo(long pedido_num, String codigo) {
		sql = PickUpSQL.EXISTECODIGO.toString();
		System.out.println(codigo+" "+pedido_num);
		if(sql != null) {
			SqlRowSet rs = jdbcTemplate.queryForRowSet(sql,codigo.trim(),pedido_num);			
			if(rs.next()) {
				return true;
			}
		}
		return false;
	}
	
	@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
	public boolean getEscaneaCodigo(long pedido_num) throws Exception{
		sql = PickUpSQL.UPDATEESTATUS.toString();
		return (jdbcTemplate.update(sql,"R",pedido_num) > 0);
	}	
	
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public JSONObject getEscaneaCajas(long pedido_num,String escaneo) throws Exception{
		JSONObject data = new JSONObject();
		if(!"".equals(escaneo)) {	
			if(escaneo.contains("http")  || escaneo.contains("=")) {
				int posicion = escaneo.indexOf("=");
				if(posicion > 0) {
					escaneo		 = escaneo.substring(posicion+1,escaneo.length());
				}
			}			
			String codigos[] = escaneo.split("/");	
			
			
			if(codigos.length > 2) {
				long order_num 	= DecodificarPedido(codigos[0].trim());
				long caja 		= Long.parseLong(codigos[1].trim());	
				sql = PickUpSQL.EXISTEESCANEO.toString();
				if(sql != null) {
					String estatus = "";
					SqlRowSet rs = jdbcTemplate.queryForRowSet(sql,pedido_num,order_num,caja);			
					while(rs.next()) {						
						estatus=rs.getString("estatus");
						if("P".equals(estatus)) {							;
							break;
						}
					}
					
					if("P".equals(estatus)) {
						if(RegistrarEscaneo(pedido_num, order_num, caja)) {
							data.put("estatus", "OK");
							data.put("caja", caja);
						}else {
							data.put("estatus", "Error en registrar caja");
						}
					}else if("E".equals(estatus)) {
						data.put("estatus", "Pedido "+pedido_num+" y Caja "+caja+" ya escaneada");
						data.put("caja", caja);
					}else {
						data.put("estatus", "El codigo no pertenece a este pedido");
					}
				}else {
					data.put("estatus", "Error en consulta");
				}
			}else {
				data.put("estatus", "El formato de codigo es ivalido");
			}
		}else {
			data.put("estatus", "Se requiere un codigo de escaneo");
		}
		
		return data;
	}
	
	@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
	public boolean RegistrarEscaneo(long pedido_num,long order_num,long caja)  throws Exception{
		sql = PickUpSQL.ACTUALIZOESCANEO.toString();
		int i = jdbcTemplate.update(sql,pedido_num,order_num,caja);
		System.out.println("Escaneo "+ i);
		if(i > 0 ) {
			sql = PickUpSQL.ACTUALIZOESCANEOESTATUS.toString();
			i = jdbcTemplate.update(sql,pedido_num,pedido_num,pedido_num);
			System.out.println("Escaneo 2 "+ i);
		}
		return i>0;
	}
	
	@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
	public boolean getLibera(String data) throws Exception{
		JSONObject dataJson = new JSONObject(data);
		if(!dataJson.isNull("data")) {
			JSONObject dataJ = dataJson.getJSONObject("data");
			if(!dataJ.isNull("pedido")) {
				if(!dataJ.isNull("base64")) {
					sql = PickUpSQL.INSERTFIRMA.toString();
					int i = jdbcTemplate.update(sql,dataJ.getLong("pedido"),dataJ.getString("base64"));
					sql = PickUpSQL.UPDATEESTATUS.toString();
					int i2 = jdbcTemplate.update(sql,"E",dataJ.getLong("pedido"));
					if(i > 0) {
						if(i2 > 0) {
							return true;
						}
					}
					
				}
			}
		}
		return false;
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public List<JSONObject> getInventario(String fecha) {	
		List<JSONObject> data = new ArrayList<JSONObject>();	
		sql = PickUpSQL.INVENTARIO.toString();
		if(sql != null) {
			SqlRowSet rs = jdbcTemplate.queryForRowSet(sql,fecha);
			while(rs.next()) {
				JSONObject datos = new JSONObject();
				datos.put("Cajas", rs.getLong("cajas"));
				datos.put("Caja", rs.getLong("caja"));
				datos.put("Pedido", rs.getLong("pedido_num"));				
				datos.put("OrderNum", rs.getLong("order_num"));
				datos.put("FechaIngreso", rs.getString("fecha_ingreso"));
				data.add(datos);
			}
		}
		return data;
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public JSONObject EscaneoInventario(String codigoCaja,long num_empleado) throws Exception{
		JSONObject	data	= new JSONObject();
		data.put("estatus", "Error");
		if(!"".equals(codigoCaja)) {
			if(codigoCaja.contains("http") || codigoCaja.contains("=")) {
				int posicion = codigoCaja.indexOf("=");
				if(posicion > 0) {
					codigoCaja = codigoCaja.substring(posicion+1,codigoCaja.length());
				}	
			}	
			String codigos[] = codigoCaja.split("/");
			if(codigos.length > 2) {
				long order_num = DecodificarPedido(codigos[0].trim());
				long caja = Long.parseLong(codigos[1].trim());
				sql = PickUpSQL.EXISTEESCANEOINV.toString();
				if(sql != null) {
					SqlRowSet rs = jdbcTemplate.queryForRowSet(sql,order_num,caja);
					if(rs.next()) {						
						long escaneado  = rs.getLong("escaneado");
						long pedido_num = rs.getLong("pedido_num");
						if(escaneado == 0) {
							if(IngresarEscaneo(pedido_num,caja,num_empleado)) {
								data.put("estatus", "OK");
							}else {
								data.put("estatus", "Error al ingresar escaneo");
							}							
						}else {
							data.put("estatus", "Pedido "+order_num+" y Caja "+caja+" ya se escaneo el dia de hoy");
						}
					}else {
						data.put("estatus", "El codigo no existe");
					}
				}else {
					data.put("estatus", "Erro en consulta");
				}
			}else {
				data.put("estatus", "El formato del escaneo no es valido");
			}			
		}else {
			data.put("estatus", "Se requiere un codigo de escaneo");
		}	
		return data;
	}
	
	@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
	public boolean IngresarEscaneo(long pedido_num,long caja, long num_empleado) throws Exception{
		sql = PickUpSQL.INGRESARESCANEO.toString();
		return (jdbcTemplate.update(sql,pedido_num,caja,num_empleado) > 0);
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public JSONObject getActividades() {	
		JSONObject 			data 		= new JSONObject();
		List<JSONObject> 	tabla 		= new ArrayList<JSONObject>();
		long 				Completas 	= 0;
		long 				Pendientes	= 0;		
		sql = PickUpSQL.ACTIVIDADES.toString();
		if(sql != null) {
			SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
			while(rs.next()) {
				JSONObject datos 	= new JSONObject();
				Long 	   id		= rs.getLong("id");
				List<JSONObject> img 	= new ArrayList<JSONObject>();
				datos.put("id", 	    id);
				datos.put("actividad",	rs.getString("actividad"));
				datos.put("hora_inicio",rs.getString("hora_inicio"));
				datos.put("hora_fin", 	rs.getString("hora_fin"));
				datos.put("isRegis", 	rs.getLong("isRegis"));
				datos.put("estatus", 	rs.getString("estatus"));					
				if(datos.getLong("isRegis") > 0) {
					sql = PickUpSQL.IMAGENESACTIVIDADES.toString();
					SqlRowSet rsI = jdbcTemplate.queryForRowSet(sql,id);
					while(rsI.next()) {
						JSONObject imagen = new JSONObject();
						imagen.put("label",  rsI.getString("actividad"));
						imagen.put("date",   rsI.getString("fecha")+" "+rsI.getString("hora"));
						imagen.put("base64", rsI.getString("imagen"));
						img.add(imagen);
					}
					Completas++;
				}else {
					Pendientes++;
				}
				datos.put("img", 	img);				
				tabla.add(datos);
			}
		}
		data.put("Tabla", 		tabla);
		data.put("Completas", 	Completas);
		data.put("Pendientes", 	Pendientes);
		return data;
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
	public boolean getSubirEvidencia(String data) {	
		JSONObject 			data_info 		= new JSONObject(data);		
		if(data_info != null) {
			if(!data_info.isNull("id_actividad")) {
				if(!data_info.isNull("base64")) {
					sql = PickUpSQL.SUBIREVIDENCIA.toString();
					return (jdbcTemplate.update(sql,data_info.getLong("id_actividad"),data_info.getString("base64")) > 0);
				}
			}
		}		
		return false;
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public JSONObject getZettle(long pedido_num){
		System.out.println("Zeetle");
		JSONObject 	data 	= new JSONObject();
		String 		cliente	= "grant_type=urn:ietf:params:oauth:grant-type:jwt-bearer&assertion=eyJraWQiOiIwIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJpc3MiOiJpWmV0dGxlIiwiYXVkIjoiQVBJIiwiZXhwIjoyNTY5ODkzMjMwLCJzdWIiOiJhMmVlNTUyYS1jMzI1LTExZWItOTAwNC1lMTU0MTY3Njg2ODciLCJpYXQiOjE2MjMxODU0NTQsInJlbmV3ZWQiOmZhbHNlLCJzY29wZSI6WyJXUklURTpQUk9EVUNUIiwiUkVBRDpQUk9EVUNUIiwiUkVBRDpVU0VSSU5GTyIsIlJFQUQ6RklOQU5DRSIsIlJFQUQ6UFVSQ0hBU0UiXSwidXNlciI6eyJ1c2VyVHlwZSI6IlVTRVIiLCJ1dWlkIjoiYTJlZTU1MmEtYzMyNS0xMWViLTkwMDQtZTE1NDE2NzY4Njg3Iiwib3JnVXVpZCI6ImEyZWM5NzQ0LWMzMjUtMTFlYi1hYWQ1LTdjZDEwY2RjNDliYSIsInVzZXJSb2xlIjoiT1dORVIifSwidHlwZSI6InVzZXItYXNzZXJ0aW9uIiwiY2xpZW50X2lkIjoiMzc3YzU4NDItYzg5Yi0xMWViLWFmNmEtZmY1Nzk2Y2I1OTZmIn0.NFjzewDKbYAsvf38zrWaF1AaF0bM3OhbS2wfzgWlIaIZhF_Hbwd6vmDFBIaX2hNbrrhiag7CK4NRLcZ3vvAcpZKcxSDX7D32rincvRphP93_behvrwezZWmNVTL8dN89RDZNQ54DGAkFmW3wZU5sgfhjS-CBKVj4PJk1sDqdRszWzEIG2Wu2l-Sd-5mg012dYTpSD5jntueMAi6AMsezuOtxNROMM7PL1Zv19IgUxBVkAV0g-vL2GYktg4m2c8UmiVBN9kUtpIyTUgVqS21uUz5BF2jOmQlePxSIczXu-qgMnTxQ2qxWjtTOnVuI1pb0DLrh-rNZpFPHRmfJfpX18g&client_id=377c5842-c89b-11eb-af6a-ff5796cb596f";
		JSONObject 	tokens 	= API("https://oauth.izettle.com/token","POST","",cliente);
		 String     token  	= verificoJsonS(tokens,"access_token",100000000); 
		 System.out.println("token"+ token);
		 if(!"".equals(token)) {
			 sql = PickUpSQL.FECHAS.toString();
			 SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
			 if(rs.next()) {
				 String fechas 		= "";
				 String startDate 	= isnull(rs.getString("ini"));
				 String endDate 	= isnull(rs.getString("fin"));
				 if(!"".equals(startDate) && !"".equals(endDate)) {
					fechas="&startDate="+startDate+"&endDate="+endDate;
					 System.out.println("fechas"+ fechas);
					String masCompras	= "";	
					do {
						 String 	url 		= "https://purchase.izettle.com/purchases/v2?descending=true"+fechas+masCompras;
						 JSONObject compras 	= API(url,"GET",token,"");	
						 System.out.println("compras "+masCompras);
						 			masCompras  = verificoJsonS(compras,"lastPurchaseHash",100000000);
						 			masCompras	= ("".equals(masCompras))?"":"&lastPurchaseHash="+masCompras;
						 if(!compras.isNull("purchases")) {
							 JSONArray purchases = compras.getJSONArray("purchases");
							 if(purchases.length() > 0) {
								 for (int i = 0; i < purchases.length(); i++) {
									 JSONObject 	purchase = purchases.getJSONObject(i);
									 JSONArray products = verificoJsonA(purchase,"products");
									 if(products != null) {
										 for (int j = 0; j < products.length(); j++) {
											 JSONObject 	product 	= products.getJSONObject(j);
											 String 		name 		= verificoJsonS(product,"name",10);
											 System.out.println("PEDIDO: "+name);
											 if(name.trim().equals(pedido_num+"".trim())) {
												 data.put("estatus", "OK");
												 masCompras="";
											 }
										 } 
									 }
								 }
							 }
						 }
						 
						 
					} while(!"".equals(masCompras));
					
					if(data.isNull("estatus")) {
						data.put("estatus", "No se encontro ningun pago con el pedido "+pedido_num);
					}
				 } 
				 
				 
			 }
		 }
		return data;
	}
	
	@Override
	public long DecodificarPedido(String data) {
		long pedido = 0;
		try {
			if(!"".equals(data)) {
				String pedido_s = "";
				for (int x=0;x<data.length();x++) {
					String caracter= data.charAt(x)+"";
					boolean isNumeric =  caracter.matches("[+-]?\\d*(\\.\\d+)?");
					if(isNumeric) {
						pedido_s=caracter+pedido_s;
					}					
				}
				if(!"".equals(pedido_s)) {
					pedido= Integer.parseInt(pedido_s);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pedido;
	}
	
	public JSONObject API(String url,String metodo,String token, String datos) {
		JSONObject data = null;
		try {
			URL Api = new URL(url);
			HttpURLConnection postConnection = (HttpURLConnection) Api.openConnection();
			postConnection.setConnectTimeout(20000);
			postConnection.setRequestMethod(metodo);
			postConnection.addRequestProperty("Accept", "*/*");
			if("".equals(token)) {
				postConnection.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			}else {
				postConnection.addRequestProperty("Content-Type", "application/json");
				postConnection.addRequestProperty("Authorization", "Bearer "+token);
			}
			
			if(!"".equals(datos)) {
				postConnection.setRequestProperty("Content-Length", "" + Integer.toString(datos.toString().getBytes().length));				
				postConnection.setUseCaches(false);
				postConnection.setDoInput(true);
				postConnection.setDoOutput(true);
				DataOutputStream dis = new DataOutputStream(postConnection.getOutputStream());
				dis.writeBytes(datos.toString());
				dis.flush();
				dis.close();
			}			
			int code = postConnection.getResponseCode();
		
			InputStream input;
			if (code >= 400) {
				input = postConnection.getErrorStream();
			} else {
				input = postConnection.getInputStream();
			}

			BufferedReader docHtml = new BufferedReader(new InputStreamReader(input));
			String line;

			while ((line = docHtml.readLine()) != null) {
					data = new JSONObject(line);			
			}
			docHtml.close();
			postConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public String verificoJsonS(JSONObject json,String key, int longitud) {
		String dato = "";
		try {
			if(json != null) {
				dato=(json.has(key))?(json.isNull(key))?"":isnull(json.getString(key)):"";
			}
			
			if(dato.length() > longitud) {
				dato = dato.substring(0,longitud);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dato;
	}
	
	public JSONArray verificoJsonA(JSONObject json,String key) {
		JSONArray dato = null;
		try {
			if(json != null) {
				dato=(json.has(key))?(json.isNull(key))?null:json.getJSONArray(key):null;
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dato;
	}
	
	public String isnull(String dato) {
		try {
			if(dato == null) {
				dato="";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dato.toString().trim();
	}
	
	public String quitaPedidoTracking(long pedido_num,String motivo) throws SQLException{
		String respuesta = "";		
		sql = PickUpSQL.CONSULTATRACKING.toString();
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql,pedido_num);
		if(rs.next()) {
			return "El pedido ya existe en la tabla. No se puede agregar";
		}else {
			sql = PickUpSQL.INSERTATRACKING.toString();
			int i = jdbcTemplate.update(sql,pedido_num,motivo);			
			if(i>=1) {
				respuesta=i+" Registros Fueron Actualizados";
			}else{
				respuesta="No se puedo insertar. Validar numero de pedido";
			}
		}
		
		return respuesta;
	}
	
	public String modificaCatalogoMSI(String accion,String sku) throws SQLException{
		String respuesta = "";
		
		if(accion.equals("insertar")){
			
			sql = PickUpSQL.VALIDAPRODUCTOFICHA.toString();
			SqlRowSet rs = jdbcTemplate.queryForRowSet(sql,sku);
			
			if(rs.next()) {
				
				sql = PickUpSQL.CONSULTAPRODUCTOMSI.toString();
				rs = jdbcTemplate.queryForRowSet(sql,sku);
				
				if(rs.next()) {
					respuesta ="El producto ya existe en el catalogo";
				}else {
					sql = PickUpSQL.INSERTAPRODUCTOSMSI.toString();
					int i = jdbcTemplate.update(sql,sku);	
					
					if(i>=1) {
						respuesta="El SKU: "+sku+" fue insertado";
					}else{
						respuesta="No se puedo insertar.";
					}
				}
				
			}else {
				return "El producto ingresado no existe";
			}
									
		}else if(accion.equals("eliminar")) {
			
			sql = PickUpSQL.CONSULTAPRODUCTOMSI.toString();
			SqlRowSet rs = jdbcTemplate.queryForRowSet(sql,sku);
			
			if(rs.next()) {
				sql = PickUpSQL.ELIMINAPRODUCTOMSI.toString();
				int i = jdbcTemplate.update(sql,sku);		
				
				if(i>=1) {
					respuesta="El sku: "+sku+" Fue Eliminado";
				}else{
					respuesta="No se puedo eliminar";
				}
				
			}else {
				return "El producto ingresado no existe, no se puede eliminar";
			}	
		}
		
		return respuesta;		
	}
	
	public String validaMSI(String sku) throws SQLException{		 
		SqlRowSet rs = jdbcTemplate.queryForRowSet("select * from py_productos_msi where item_num in"+"("+sku+")");			
		if(rs.next()) {
			return "S";
		}else {
			return "N";
		}
	}
	
}
