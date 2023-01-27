package com.pedidos.api.dao;

import java.util.ArrayList;

import com.pedidos.api.comun.DAO;
import com.pedidos.api.model.PyItemsFavoritos;


public interface PyItemsFavoritosDao extends DAO<PyItemsFavoritosDao>{
	
	public ArrayList<PyItemsFavoritos> obtieneFavoritosFrecuentes(long clienteNum);
	
	public String agregaFavoritos(long cliente, String itemNum, int notificacion);
	
	public String eliminaFavorito(long cliente, String item);
	
	public String agregarFavorito(long cliente_num, String item_num, int notificacion, String precio);
	
	public ArrayList<PyItemsFavoritos> obtieneItemsHome(long clienteNum, int top, long usuarioNum);
	
	public ArrayList<PyItemsFavoritos> obtieneItemsCarrito(long clienteNum, int top, long usuarioNum);

	public String test();
}
