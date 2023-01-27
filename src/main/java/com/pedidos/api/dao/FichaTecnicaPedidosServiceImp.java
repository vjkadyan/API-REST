package com.pedidos.api.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedidos.api.model.AswerTest;
import com.pedidos.api.model.CommentTest;
import com.pedidos.api.model.FichaTecnicaUrlName;
import com.pedidos.api.model.ProductoRelacionado;
import com.pedidos.api.model.Relacionados;
import com.pedidos.api.model.ReseniasComentario;
import com.pedidos.api.model.ReseniasRespuesta;

@Service
public class FichaTecnicaPedidosServiceImp implements FichaTecnicaPedidos{
	@Autowired
	private ObtieneFichaTecnicaDao obtieneFichaTecnicaDaoImpsql;
	
	@Override
	public int obtieneExistencias(String item_num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double obtienePrecio(String item_num, long cliente_num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double obtienePrecioAnterior(String item_num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ReseniasComentario> obtieneReseniasComentarios(String item_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReseniasRespuesta> obtieneReseniasRespuesta(long id_comentario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertaComentario(CommentTest commentTest) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertaRespuestaComentario(AswerTest aswerTest) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Relacionados> obtieneProductoRelacionado(String item_num, long cliente_num) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> obtieneDetalleProducto(String item_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> obtieneDetalleProductoShopper(String item_num, String cliente_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductoRelacionado> obtieneOtrosClientesVieron(String item_num, long cliente_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FichaTecnicaUrlName obtieneDescripcionProductoTecnico(String item_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> obtieneRegalo(String item_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean esFavorito(String item_num, long cliente_num) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean esProductoExpress(String item_num) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int esMotoExpress(String item_num, String codigo_postal) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double obtieneDescuentoArticulo(String item_num, long cliente_num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double obtienePrecioDescuentoArticulo(String item_num, double precio, long cliente_num, int pedido_num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean urlSearchs(String item_num, String url) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Relacionados> obtieneProductoAsociado(String item_num) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validaCodigoPostal(String codigo_postal) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String obtieneItem(String url) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject obtieneItemCompleto(String url) throws SQLException {
		return obtieneFichaTecnicaDaoImpsql.obtieneItemCompleto(url,12232);
	}

	@Override
	public String obtieneUrl(String item_num) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertaVisto(String item_num, long cliente_num) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getPrecioGarantia(double precio, String opcion) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> disponibilidad(String item_num) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
