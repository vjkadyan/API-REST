package com.pedidos.api.model;

public class CatCorreos {
	private int correoNum;
	private String nombre;
	private String nombreCorreo;
	private String status;
	
	@Override
	public String toString() {
		return "CatCorreos [correoNum=" + correoNum + ", nombre=" + nombre + ", nombreCorreo=" + nombreCorreo + ", status=" + status + "]";
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
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
