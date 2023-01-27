package com.pedidos.api.model;

public class FichaTecnicaUrlName {
	private String item_num;
	private String descripcionUno;
	private String descripcionDos;
	private String urlName;
	private String url;
	private String marca1;
	private String subfamilia;
	private String estatus_prop;
	private String sort_name;
	private String titulo;
	private String link;

	public FichaTecnicaUrlName() {
	}

	public FichaTecnicaUrlName(String item_num, String descripcionUno, String descripcionDos, String urlName, String url, String marca1, String subfamilia, String estatus_prop, String sort_name, String titulo, String link) {
		this.item_num = item_num;
		this.descripcionUno = descripcionUno;
		this.descripcionDos = descripcionDos;
		this.urlName = urlName;
		this.url = url;
		this.marca1 = marca1;
		this.subfamilia = subfamilia;
		this.estatus_prop = estatus_prop;
		this.sort_name = sort_name;
		this.titulo = titulo;
		this.link = link;
	}

	public String getItem_num() {
		return item_num;
	}

	public void setItem_num(String item_num) {
		this.item_num = item_num;
	}

	public String getDescripcionUno() {
		return descripcionUno;
	}

	public void setDescripcionUno(String descripcionUno) {
		this.descripcionUno = descripcionUno;
	}

	public String getDescripcionDos() {
		return descripcionDos;
	}

	public void setDescripcionDos(String descripcionDos) {
		this.descripcionDos = descripcionDos;
	}

	public String getUrlName() {
		return urlName;
	}

	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMarca1() {
		return marca1;
	}

	public void setMarca1(String marca1) {
		this.marca1 = marca1;
	}

	public String getSubfamilia() {
		return subfamilia;
	}

	public void setSubfamilia(String subfamilia) {
		this.subfamilia = subfamilia;
	}

	public String getEstatus_prop() {
		return estatus_prop;
	}

	public void setEstatus_prop(String estatus_prop) {
		this.estatus_prop = estatus_prop;
	}

	public String getSort_name() {
		return sort_name;
	}

	public void setSort_name(String sort_name) {
		this.sort_name = sort_name;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "FichaTecnicaUrlName [item_num=" + item_num + ", descripcionUno=" + descripcionUno + ", descripcionDos=" + descripcionDos + ", urlName=" + urlName + ", url=" + url + ", marca1=" + marca1 + ", subfamilia=" + subfamilia + ", estatus_prop=" + estatus_prop + ", sort_name=" + sort_name + ", titulo=" + titulo +", link=" + link + "]";
	}
}
