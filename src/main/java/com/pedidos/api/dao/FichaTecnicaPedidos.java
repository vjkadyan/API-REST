package com.pedidos.api.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.pedidos.api.model.AswerTest;
import com.pedidos.api.model.CommentTest;
import com.pedidos.api.model.FichaTecnicaUrlName;
import com.pedidos.api.model.ProductoRelacionado;
import com.pedidos.api.model.Relacionados;
import com.pedidos.api.model.ReseniasComentario;
import com.pedidos.api.model.ReseniasRespuesta;

public interface FichaTecnicaPedidos {
	public int obtieneExistencias(String item_num);

	public double obtienePrecio(String item_num, long cliente_num);

	public double obtienePrecioAnterior(String item_num);

	public List<ReseniasComentario> obtieneReseniasComentarios(String item_num);

	public List<ReseniasRespuesta> obtieneReseniasRespuesta(long id_comentario);

	public void insertaComentario(CommentTest commentTest) throws SQLException;

	public void insertaRespuestaComentario(AswerTest aswerTest) throws SQLException;

	public List<Relacionados> obtieneProductoRelacionado(String item_num, long cliente_num) throws SQLException;

	public Map<String, Object> obtieneDetalleProducto(String item_num);
	
	public Map<String, Object> obtieneDetalleProductoShopper(String item_num, String cliente_num);

	public List<ProductoRelacionado> obtieneOtrosClientesVieron(String item_num, long cliente_num);

	public FichaTecnicaUrlName obtieneDescripcionProductoTecnico(String item_num);

	public List<String> obtieneRegalo(String item_num);

	public boolean esFavorito(String item_num, long cliente_num);
	
	public boolean esProductoExpress(String item_num) throws SQLException;
	
	public int esMotoExpress(String item_num, String codigo_postal) throws SQLException;
	
	public double obtieneDescuentoArticulo(String item_num, long cliente_num);
	
	public double obtienePrecioDescuentoArticulo(String item_num, double precio, long cliente_num, int pedido_num);

	public boolean urlSearchs(String item_num, String url) throws SQLException;

	public List<Relacionados> obtieneProductoAsociado(String item_num) throws SQLException;
	
	public boolean validaCodigoPostal(String codigo_postal) throws SQLException;

	public String obtieneItem(String url) throws SQLException;
	
	public JSONObject obtieneItemCompleto(String url) throws SQLException;

	String obtieneUrl(String item_num) throws SQLException;
	
	public void insertaVisto(String item_num, long cliente_num) throws SQLException;
	
	public double getPrecioGarantia(double precio, String opcion) throws SQLException;
	
	public Map<String, Object> disponibilidad(String item_num) throws SQLException;
}
