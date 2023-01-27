package com.pedidos.api.model;

public class CorreosUsuario {
	private int correoNum;
	private String nombre;
	private String nombreCorreo;
	private String acceso;
	
	@Override
	public String toString() {
		return "CorreosUsuario [correoNum=" + correoNum + ", nombre=" + nombre + ", nombreCorreo=" + nombreCorreo + ", acceso=" + acceso + "]";
	}

	public int getCorreoNum() {
		return correoNum;
	}

	public void setCorreoNum(int correoNum) {
		this.correoNum = correoNum;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombreCorreo() {
		return nombreCorreo;
	}
	
	public void setNombreCorreo(String nombreCorreo) {
		this.nombreCorreo = nombreCorreo;
	}
	
	public String getAcceso() {
		return acceso;
	}
	
	public void setAcceso(String acceso) {
		this.acceso = acceso;
	}
}
