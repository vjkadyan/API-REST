package com.pedidos.api.model;

public class ModulosUsuario {
	private int moduloNum;
	private String nombreMod;
	private String clave;
	private String url;
	private String img;
	private String acceso;
	
	@Override
	public String toString() {
		return "ModulosUsuario [moduloNum=" + moduloNum + ", nombreMod=" + nombreMod + ", clave=" + clave + ", url=" + url + ", img=" + img + ", acceso=" + acceso + "]";
	}

	public int getModuloNum() {
		return moduloNum;
	}
	
	public void setModuloNum(int moduloNum) {
		this.moduloNum = moduloNum;
	}
	
	public String getNombreMod() {
		return nombreMod;
	}
	
	public void setNombreMod(String nombreMod) {
		this.nombreMod = nombreMod;
	}
	
	public String getClave() {
		return clave;
	}
	
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getImg() {
		return img;
	}
	
	public void setImg(String img) {
		this.img = img;
	}
	
	public String getAcceso() {
		return acceso;
	}
	
	public void setAcceso(String acceso) {
		this.acceso = acceso;
	}
}
