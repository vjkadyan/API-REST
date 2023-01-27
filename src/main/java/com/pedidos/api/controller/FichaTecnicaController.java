package com.pedidos.api.controller;

import java.sql.SQLException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedidos.api.Servicios;
import com.pedidos.api.dao.ObtieneFichaTecnicaDao;
import com.pedidos.api.dao.PyItemsFavoritosDao;


@CrossOrigin("*")
@RestController
@RequestMapping("/fichaTecnica/")
public class FichaTecnicaController {
	
	@Autowired
	private PyItemsFavoritosDao pyItemsFavoritosDao;
	
	@Autowired
	private ObtieneFichaTecnicaDao obtieneFichaTecnicaDao;
	
	Servicios ser = new Servicios();
	
	@RequestMapping(value="obtieneDescripcionProductotecnico", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneDescripcionProductotecnico(@RequestParam(required = true) String itemNum) {
			
		String resultado =  ser.POS("","POST", "/fichaTecnica/obtieneDescripcionProductotecnico?itemNum="+itemNum);
		System.out.println("/fichaTecnica/obtieneDescripcionProductotecnico?itemNum="+itemNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	//Probado
	@RequestMapping(value="obtienePrecio", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtienePrecioT(@RequestParam(required = true) String item_num, @RequestParam(required = true) long cliente_num) {
			
		String resultado =  ser.POS("","POST", "/fichaTecnica/obtienePrecio?item_num="+item_num+"&cliente_num="+cliente_num);
		System.out.println("/fichaTecnica/obtienePrecio?item_num="+item_num+"&cliente_num="+cliente_num);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtienePrecioAnterior", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtienePrecioT(@RequestParam(required = true) String item_num) {
			
		String resultado =  ser.POS("","POST", "/fichaTecnica/obtienePrecioAnterior?item_num="+item_num);
		System.out.println("/fichaTecnica/obtienePrecioAnterior?item_num="+item_num);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneDetalleProducto", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneDetalleProducto(@RequestParam(required = true) String item_num) {
			
		String resultado =  ser.POS("","POST", "/fichaTecnica/obtieneDetalleProducto?item_num="+item_num);
		System.out.println("/fichaTecnica/obtieneDetalleProducto?item_num="+item_num);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneDetalleProductoShopper", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneDetalleProductoShopper(@RequestParam(required = true) String item_num, @RequestParam(required = true) String cliente_num) {
			
		String resultado =  ser.POS("","POST", "/fichaTecnica/obtieneDetalleProductoShopper?item_num="+item_num+"&cliente_num="+cliente_num);
		System.out.println("/fichaTecnica/obtieneDetalleProductoShopper?item_num="+item_num+"&cliente_num="+cliente_num);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	//Probado
	@RequestMapping(value="obtieneExistencias", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneExistencias(@RequestParam(required = true) String item_num) {
		
		String resultado =  ser.POS("","POST", "/fichaTecnica/obtieneExistencias?item_num="+item_num);
		System.out.println("/fichaTecnica/obtieneExistencias?item_num="+item_num);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneProductoRelacionado", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneProductoRelacionado(@RequestParam(required = true) String item_num, @RequestParam(required = true) long cliente_num) {
			
		String resultado =  ser.POS("","POST", "/fichaTecnica/obtieneProductoRelacionado?cliente_num="+cliente_num+"&item_num="+item_num);
		System.out.println("/fichaTecnica/obtieneProductoRelacionado?cliente_num="+cliente_num+"&item_num="+item_num);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneProductoAsociado", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneProductoAsociado(@RequestParam(required = true) String item_num) {
			
		String resultado =  ser.POS("","POST", "/fichaTecnica/obtieneProductoAsociado?item_num="+item_num);
		System.out.println("/fichaTecnica/obtieneProductoAsociado?item_num="+item_num);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneItem", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneItem(@RequestParam(required = true) String url) {
		
		String resultado =  ser.POS("","POST", "/fichaTecnica/obtieneItem?url="+url);
		System.out.println("/fichaTecnica/obtieneItem?url="+url);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneReseniasComentarios", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneReseniasComentarios(@RequestParam(value="item_num") String item_num) {
			
		String resultado =  ser.POS("","POST", "/fichaTecnica/obtieneReseniasComentarios?item_num="+item_num);
		System.out.println("/fichaTecnica/obtieneReseniasComentarios?item_num="+item_num);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneOtrosClientesVieron", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneOtrosClientesVieron(@RequestParam(required = true) String item_num, @RequestParam(required = true) long cliente_num) {
			
		String resultado =  ser.POS("","POST", "/fichaTecnica/obtieneOtrosClientesVieron?cliente_num="+cliente_num+"&item_num="+item_num);
		System.out.println("/fichaTecnica/obtieneOtrosClientesVieron?cliente_num="+cliente_num+"&item_num="+item_num);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneRegalo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneRegalo(@RequestParam(required = true) String itemNum) {
		
		String resultado =  ser.POS("","POST", "/fichaTecnica/obtieneRegalo?itemNum="+itemNum);
		System.out.println("/fichaTecnica/obtieneRegalo?itemNum="+itemNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="esFavorito", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String esFavorito(@RequestParam(required = true) String item_num, @RequestParam(required = true) long cliente_num) {
			
		String resultado =  ser.POS("","POST", "/fichaTecnica/esFavorito?cliente_num="+cliente_num+"&item_num="+item_num);
		System.out.println("/fichaTecnica/esFavorito?cliente_num="+cliente_num+"&item_num="+item_num);
		System.out.println("Resultado: "+resultado);
		
		boolean esFavorito = false;
		esFavorito = obtieneFichaTecnicaDao.esFavorito(item_num, cliente_num);
		return resultado;
	}
	
	@RequestMapping(value="agregaFavoritos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String agregaFavoritos(@RequestParam(required = true) long cliente, @RequestParam(required = true) String itemNum, @RequestParam(required = true) int notificacion) {
		System.out.println("/fichaTecnica/agregaFavoritos?cliente="+cliente+"&itemNum="+itemNum+"&notificacion="+notificacion);
		return pyItemsFavoritosDao.agregaFavoritos(cliente, itemNum, notificacion);
	}
	
	@RequestMapping(value="esProductoExpress", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String esProductoExpress(@RequestParam(required = true) String itemNum) {
		
		String resultado =  ser.POS("","POST", "/fichaTecnica/esProductoExpress?itemNum="+itemNum);
		System.out.println("/fichaTecnica/esProductoExpress?itemNum="+itemNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="esMotoExpress", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String esMotoExpress(@RequestParam(required = true) String item_num, @RequestParam(required = true) String codigo_postal) {
		
		String resultado =  ser.POS("","POST", "/fichaTecnica/esMotoExpress?item_num="+item_num+"&codigo_postal="+codigo_postal);
		System.out.println("/fichaTecnica/esMotoExpress?item_num="+item_num+"&codigo_postal="+codigo_postal);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtieneDescuentoArticulo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneDescuentoArticulo(@RequestParam(required = true) long item_num, @RequestParam(required = true) String cliente_num) {
			
		String resultado =  ser.POS("","POST", "/fichaTecnica/obtieneDescuentoArticulo?cliente_num="+cliente_num+"&item_num="+item_num);
		System.out.println("/fichaTecnica/obtieneDescuentoArticulo?cliente_num="+cliente_num+"&item_num="+item_num);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtienePrecioDescuentoArticulo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtienePrecioDescuentoArticulo(@RequestParam(required = true) String item_num, @RequestParam(required = true) long cliente_num, @RequestParam(required = true) int pedido_num) {
			
		String resultado =  ser.POS("","POST", "/fichaTecnica/obtienePrecioDescuentoArticulo?pedido_num="+pedido_num+"&cliente_num="+cliente_num+"&item_num="+item_num);
		System.out.println("/fichaTecnica/obtienePrecioDescuentoArticulo?pedido_num="+pedido_num+"&cliente_num="+cliente_num+"&item_num="+item_num);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="validaUrlSearchs", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String validaUrlSearchs(@RequestParam(required = true) String item_num, @RequestParam(required = true) String url) {
		
		String resultado =  ser.POS("","POST", "/fichaTecnica/validaUrlSearchs?itemNum="+item_num+"&url="+url);
		System.out.println("/fichaTecnica/validaUrlSearchs?itemNum="+item_num+"&url="+url);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtienePrecioSeguro", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtienePrecioSeguro(@RequestParam(required = true) double precio) {
		
		String resultado =  ser.POS("","POST", "/fichaTecnica/obtienePrecioSeguro?precio="+precio);
		System.out.println("/fichaTecnica/obtienePrecioSeguro?precio="+precio);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	@RequestMapping(value="obtienePrecioGarantia", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtienePrecioGarantia(@RequestParam(required = true) double precio, @RequestParam(required = true) String opcion) {
		
		String resultado =  ser.POS("","POST", "/fichaTecnica/obtienePrecioGarantia?precio="+precio+"&opcion="+opcion);
		System.out.println("/fichaTecnica/obtienePrecioGarantia?precio="+precio+"&opcion="+opcion);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}

	@RequestMapping(value="guardaVisto", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void guardarVisto(@RequestParam(required = true) String itemNum, @RequestParam(required = true) long clienteNum) throws SQLException {
			
		String resultado =  ser.POS("","POST", "/fichaTecnica/guardaVisto?itemNum="+itemNum+"&clienteNum="+clienteNum);
		System.out.println("/fichaTecnica/guardaVisto?itemNum="+itemNum+"&clienteNum="+clienteNum);
		obtieneFichaTecnicaDao.guardaVisto(itemNum, clienteNum);
	}
	
	@RequestMapping(value="disponibilidad", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String disponibilidad(@RequestParam(required = true) String itemNum) {
			
		String resultado =  ser.POS("","POST", "/fichaTecnica/disponibilidad?itemNum="+itemNum);
		System.out.println("/fichaTecnica/disponibilidad?itemNum="+itemNum);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	@RequestMapping(value="obtieneItemCompleto", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String obtieneItemCompleto(@RequestParam(required = true) String url,@RequestParam(required = false, defaultValue="201221") int cliente_num) throws SQLException{
		JSONObject item_num = obtieneFichaTecnicaDao.obtieneItemCompleto(url,cliente_num);
		return item_num.toString();
	}
	
}
