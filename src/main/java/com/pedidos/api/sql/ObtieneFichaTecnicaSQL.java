package com.pedidos.api.sql;

public enum ObtieneFichaTecnicaSQL {
	ES_FAVORITO,
	INSERT_VISTO,
	OBTIENE_ITEM_URL_TOTAL,
	GARANTIA,
	GARANTIA2;
	
	public String toString() {
		switch (this) {
		
		case ES_FAVORITO:
			return "SELECT * FROM  PY_ITEMS_FAVORITOS WHERE CLIENTE_NUM = ? AND ITEM_NUM = ? ";
		case INSERT_VISTO:
			return "exec fn_upd_py_item_vistos_pedidos(?,?);";
		case OBTIENE_ITEM_URL_TOTAL:
			return "SELECT f.item_num, f.asociados, f.relacionados, f.descripcion, f.iva, f.precio_anterior, f.detalle, f.regalos, f.aplica_express, f.estatus_img, f.detalle_seo, f.breadcrumb, f.metas, Isnull(f.envio_gratis, 'N') envio_gratis, f.marca, f.categoriashewlett, dbo.precio_item(f.item_num,839494) precio, f.disponible, Isnull(dbo.local_item(f.item_num),'Ninguna') bodega, Isnull(dbo.entrega_local_item(f.item_num),'') horarioLocal, Isnull(dbo.entrega_foraneo_item(f.item_num),'') horarioForaneo FROM   py_ficha_tecnica f WHERE  f.url = ?";
		case GARANTIA:
			return "select MAX(precio_unitario) precio_unitario,tipo from py_precios_seg_garant where tipo = 'G1' and desde_precio <= ? group by tipo";
		case GARANTIA2:
			return "select MAX(precio_unitario) precio_unitario,tipo from py_precios_seg_garant where tipo = 'G2' and desde_precio <= ? group by tipo";
		}
		return null;
	}
}
