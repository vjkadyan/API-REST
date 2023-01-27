package com.pedidos.api.dao;


import java.sql.SQLException;
import java.util.List;
import org.json.JSONObject;

import com.google.zxing.WriterException;

public interface PickUpDao {		
	String PalabraClave(String factura);
	String getEnvioCorreo(long pedido_num);
	JSONObject Login(String usuario,String password);
	JSONObject getNumPedidosPickUP();
	List<JSONObject> PedidosPickUP();
	JSONObject getDetallePedidosPickUP(long pedido_num);
	boolean  validaCodigo(long pedido_num, String codigo);
	boolean getEscaneaCodigo(long pedido_num) throws Exception;
	JSONObject getEscaneaCajas(long pedido_num,String escaneo) throws Exception;
	boolean RegistrarEscaneo(long pedido_num,long order_num,long caja) throws Exception;
	boolean getLibera(String data) throws Exception;
	JSONObject getActividades();
	boolean getSubirEvidencia(String data);
	List<JSONObject> getInventario(String fecha);
	JSONObject EscaneoInventario(String codigoCaja,long num_empleado) throws Exception;
	JSONObject getZettle(long pedido_num);
	JSONObject API(String url,String metodo,String token, String datos);
	long DecodificarPedido(String data);
	String quitaPedidoTracking (long pedido_num,String motivo) throws SQLException;
	String modificaCatalogoMSI(String accion, String sku) throws SQLException;
	String validaMSI(String skus) throws SQLException;
}
