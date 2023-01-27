package com.pedidos.api.dao;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.DecimalFormat;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.pedidos.api.Servicios;
import com.pedidos.api.sql.ObtieneFichaTecnicaSQL;

@Service
public class ObtieneFichaTecnicaDaoImp implements ObtieneFichaTecnicaDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;	
	
	String sql = ""; 
	
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public boolean esFavorito(String item_num, long cliente_num) {
		sql = ObtieneFichaTecnicaSQL.ES_FAVORITO.toString();
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, cliente_num, item_num);
		if (rs.next()) {
			return true;
		}
		return false;
	}
	
	@Override
	public void guardaVisto(String item_num, long cliente_num) throws SQLException {
		sql = ObtieneFichaTecnicaSQL.INSERT_VISTO.toString();
		jdbcTemplate.update(sql,item_num,cliente_num);
	}

	@Override
	public JSONObject obtieneItemCompleto(String url, int cliente_num) throws SQLException {
		JSONObject item_num = new JSONObject();;
		sql = ObtieneFichaTecnicaSQL.OBTIENE_ITEM_URL_TOTAL.toString();
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, url);
		SqlRowSet rs2 = jdbcTemplate.queryForRowSet(sql, url);
		DecimalFormat decimalFormato = new DecimalFormat("#.00");
		if (rs.next()) {
			try {		
				
				String sku	= rs.getString("item_num").trim();
				item_num.put("item_num",  		sku);
				item_num.put("asociados", 		"{\"listaAsociados\":"+rs.getString("asociados")+"}");
				item_num.put("relacionados", 	"{\"listaRelacionados\":"+rs.getString("relacionados")+"}");
				item_num.put("descripcion", 	"{\"descripcion\":"+rs.getString("descripcion")+"}");
				item_num.put("iva", 			rs.getString("iva"));
				item_num.put("precio_anterior", rs.getString("precio_anterior"));				
				item_num.put("detalle", 		rs.getString("detalle"));
				item_num.put("regalos", 		"{\"regalo\":"+rs.getString("regalos")+"}");
				item_num.put("isExpress", 		"S".equals(rs.getString("aplica_express").trim()));
				item_num.put("estatus_img", 	rs.getString("estatus_img"));
				item_num.put("detalle_seo", 	rs.getString("detalle_seo"));
				item_num.put("breadcrumb", 	    rs.getString("breadcrumb"));
				item_num.put("metas", 	    	"{\"metasList\":"+rs.getString("metas")+"}");
				item_num.put("envio_gratis", 	("true".equals(rs.getString("envio_gratis")))?"Y":"N");
				item_num.put("marca", 	    	 rs.getString("marca"));
				item_num.put("categoriasHewlett",rs.getString("categoriasHewlett"));
				item_num.put("disponibilidad"	,rs.getString("disponible"));
				item_num.put("horarioEntrega"	,"{\"horarioLocal\": \""+rs.getString("horarioLocal")+"\",\"horarioForaneo\": \""+rs.getString("horarioForaneo")+"\",\"bodega\": \""+rs.getString("bodega")+"\"}");
				
				
				String precio 	= /*(cliente_num	==	201221)?rs.getString("precio"):*/new Servicios().POS("","POST", "/fichaTecnica/obtienePrecio?item_num="+sku+"&cliente_num="+cliente_num);
				double precioInt = Double.parseDouble(precio) * 1.16;
				
				double 	precioSeguro 	= (Double.parseDouble(precio)/1000) * 13.5;
						precioSeguro 	= (precioSeguro < 250)?Math.round((290 /.85) * Math.pow(10, 2)) / Math.pow(10, 2):Math.round(((precioSeguro + (precioSeguro * 0.16))/ .85) * Math.pow(10, 2)) / Math.pow(10, 2);
				double  garantia1		= 0;
				double  garantia2		= 0;
				double formatoGarantia1 = 0;
				double formatoGarantia2 = 0;
				sql = ObtieneFichaTecnicaSQL.GARANTIA.toString();				
				rs = jdbcTemplate.queryForRowSet(sql, Double.toString(precioInt));
				if (rs.next()) {					
					garantia1 = (rs.getString("tipo").equals("G1"))?rs.getDouble("precio_unitario"):garantia1;					
				}
				sql = ObtieneFichaTecnicaSQL.GARANTIA2.toString();
				rs2 = jdbcTemplate.queryForRowSet(sql, Double.toString(precioInt));
				if (rs2.next()) {
					garantia2 = (rs2.getString("tipo").equals("G2"))?rs2.getDouble("precio_unitario"):garantia2;
				}
				garantia1 = (garantia1 / 0.85);				
				formatoGarantia1 = Math.round(garantia1 * 10.0) / 10.0;
				
				garantia2 = (garantia2 / 0.85);
				formatoGarantia2 = Math.round(garantia2 * 10.0) / 10.0;
				
				
				item_num.put("precio"		,precio);
				item_num.put("precioSeguro"	,precioSeguro);	
				item_num.put("garantia1"	,decimalFormato.format(formatoGarantia1));
				item_num.put("garantia2"	,decimalFormato.format(formatoGarantia2));
				
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		return item_num;
	}
}
