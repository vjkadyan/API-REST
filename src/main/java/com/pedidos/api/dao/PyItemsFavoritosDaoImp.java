package com.pedidos.api.dao;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.pedidos.api.model.PyItemsFavoritos;
import com.pedidos.api.sql.PyItemsFavoritosSQL;

@Service
public class PyItemsFavoritosDaoImp implements PyItemsFavoritosDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;	
	
	String sql = "";

	@Override
	public void insertRow(PyItemsFavoritosDao entidad) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteRow(PyItemsFavoritosDao entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRow(PyItemsFavoritosDao entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PyItemsFavoritosDao getByIdRow(PyItemsFavoritosDao entidad) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PyItemsFavoritosDao> getAllRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String agregaFavoritos(long cliente, String itemNum, int notificacion) {
		
		sql = PyItemsFavoritosSQL.AGREGA_FAVORITOS + "";
		//Date date = new Date(); 
		String mensaje = "";
		int inserta =  jdbcTemplate.update(sql, cliente, itemNum, notificacion, "new Date()");
		
		if(inserta < 1) {
			mensaje = "ERROR";
		}else {
			mensaje = "OK";
		}
		return mensaje;
	}

	@Override
	public ArrayList<PyItemsFavoritos> obtieneFavoritosFrecuentes(long clienteNum) {
		
		sql = PyItemsFavoritosSQL.CONSULTA_FAVORITOS + "";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql,clienteNum,clienteNum,clienteNum,clienteNum);
		
		ArrayList<PyItemsFavoritos> listaFav = new ArrayList<PyItemsFavoritos>();
		while(rs.next()) {
			PyItemsFavoritos beanPyItemsFavoritos = new PyItemsFavoritos();
			beanPyItemsFavoritos.setItemNum(rs.getString(1).trim());
			beanPyItemsFavoritos.setFrecuencia(rs.getInt(2));
			beanPyItemsFavoritos.setTipo(rs.getString(3).trim());
			beanPyItemsFavoritos.setPrecio(rs.getDouble(4));
			beanPyItemsFavoritos.setDisponibilidad(rs.getInt(5));
			listaFav.add(beanPyItemsFavoritos);
		}
		
		return listaFav;
	}

	@Override
	public String eliminaFavorito(long cliente, String item) {
		
		sql = PyItemsFavoritosSQL.DELETE_FAVORITO + "";
		String mensaje = "";
		int delete =  jdbcTemplate.update(sql, cliente, item);
		
		if(delete < 1) {
			mensaje = "ERROR";
		}else {
			mensaje = "OK";
		}
		return mensaje;
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public String agregarFavorito(long cliente_num, String item_num, int notificacion, String precio) {	
		int transaccion = 0;
		
		sql = PyItemsFavoritosSQL.CONSULTA_ITEM_FAVORITO + "";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql,cliente_num,item_num);
		if(rs.next()) {
			transaccion =  jdbcTemplate.update(PyItemsFavoritosSQL.UPDATE_ITEM_FAVORITO + "", notificacion, precio, cliente_num, item_num);
		}else {
			transaccion =  jdbcTemplate.update(PyItemsFavoritosSQL.INSERT_ITEM_FAVORITO + "", cliente_num, item_num, notificacion, precio);
		}		
		return (transaccion < 1)?"ERROR":"OK";
	}
	
	@Override
	public String test() {
		
		sql = PyItemsFavoritosSQL.TEST + "";
		String mensaje =  jdbcTemplate.queryForObject(sql, String.class);
		return mensaje;
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public ArrayList<PyItemsFavoritos> obtieneItemsHome(long clienteNum, int top, long usuarioNum) {
		
		sql = PyItemsFavoritosSQL.CONSULTA_ITEM_HOME + "";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql,top,clienteNum, usuarioNum);
		
		ArrayList<PyItemsFavoritos> listaFav = new ArrayList<PyItemsFavoritos>();
		while(rs.next()) {
			PyItemsFavoritos beanPyItemsFavoritos = new PyItemsFavoritos();
			if((rs.getString(3).trim().equals("C")) 
					|| rs.getString(3).trim().equals("A") //Accesorios
					|| rs.getString(3).trim().equals("E") //Equipo
					|| rs.getString(3).trim().equals("F") //Favoritos
					|| rs.getString(3).trim().equals("G") //Recomendaciones General
					|| rs.getString(3).trim().equals("P") //Papel
					|| rs.getString(3).trim().equals("S") //Recomendaciones Ultima compra
					|| rs.getString(3).trim().equals("V") //Vistos
					|| rs.getString(3).trim().equals("B"))//Carrito
			{
				beanPyItemsFavoritos.setItemNum(rs.getString(1).trim());
				beanPyItemsFavoritos.setFrecuencia(rs.getInt(2));
				beanPyItemsFavoritos.setTipo(rs.getString(3).trim());
				beanPyItemsFavoritos.setPrecio(rs.getDouble(4));
				beanPyItemsFavoritos.setDisponibilidad(rs.getInt(5));
				listaFav.add(beanPyItemsFavoritos);
			}
		}
		
		return listaFav;
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public ArrayList<PyItemsFavoritos> obtieneItemsCarrito(long clienteNum, int top, long usuarioNum) {
		
		sql = PyItemsFavoritosSQL.CONSULTA_ITEM_CARRITO + "";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql,top,clienteNum, usuarioNum);
		
		ArrayList<PyItemsFavoritos> listaFav = new ArrayList<PyItemsFavoritos>();
		while(rs.next()) {
			PyItemsFavoritos beanPyItemsFavoritos = new PyItemsFavoritos();
			if(rs.getString(3).trim().equals("V") //Vistos
			|| rs.getString(3).trim().equals("I"))//Interesados
			{
				beanPyItemsFavoritos.setItemNum(rs.getString(1).trim());
				beanPyItemsFavoritos.setFrecuencia(rs.getInt(2));
				beanPyItemsFavoritos.setTipo(rs.getString(3).trim());
				beanPyItemsFavoritos.setPrecio(rs.getDouble(4));
				beanPyItemsFavoritos.setDisponibilidad(rs.getInt(5));
				beanPyItemsFavoritos.setEstatus(rs.getString(6).trim());
				listaFav.add(beanPyItemsFavoritos);
			}
		}
		return listaFav;
	}
}