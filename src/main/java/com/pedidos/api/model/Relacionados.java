package com.pedidos.api.model;

public class Relacionados {
	private String item_princ;
	private float costo_princ;
	private String item_rel;
	private float costo_rel;
	private String url;
	private String sort_name;
	private int existencias_rel;
	private String alt;
	
	
	public Relacionados() {
		super();
	}


	


	public Relacionados(String item_princ, float costo_princ, String item_rel, float costo_rel, String url,
			String sort_name, int existencias_rel, String alt) {
		super();
		this.item_princ = item_princ;
		this.costo_princ = costo_princ;
		this.item_rel = item_rel;
		this.costo_rel = costo_rel;
		this.url = url;
		this.sort_name = sort_name;
		this.existencias_rel = existencias_rel;
		this.alt = alt;
	}





	public String getItem_princ() {
		return item_princ;
	}


	public void setItem_princ(String item_princ) {
		this.item_princ = item_princ;
	}


	public float getCosto_princ() {
		return costo_princ;
	}


	public void setCosto_princ(float costo_princ) {
		this.costo_princ = costo_princ;
	}


	public String getItem_rel() {
		return item_rel;
	}


	public void setItem_rel(String item_rel) {
		this.item_rel = item_rel;
	}


	public float getCosto_rel() {
		return costo_rel;
	}


	public void setCosto_rel(float costo_rel) {
		this.costo_rel = costo_rel;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getSort_name() {
		return sort_name;
	}


	public void setSort_name(String sort_name) {
		this.sort_name = sort_name;
	}
	
	
	
	public int getExistencias_rel() {
		return existencias_rel;
	}


	public void setExistencias_rel(int existencias_rel) {
		this.existencias_rel = existencias_rel;
	}
	
	public String getAlt() {
		return alt;
	}
	
	public void setAlt(String alt) {
		this.alt = alt;
	}

	@Override
	public String toString() {
		return "Relacionados [item_princ=" + item_princ + ", costo_princ=" + costo_princ + ", item_rel=" + item_rel + ", costo_rel=" + costo_rel + ", url=" + url + ", sort_name=" + sort_name+",existencias_rel="+existencias_rel+",alt="+alt+"]";
	}
}
