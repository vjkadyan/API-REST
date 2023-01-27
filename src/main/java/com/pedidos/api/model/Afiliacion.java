package com.pedidos.api.model;

public class Afiliacion { 
	private int cliente_num;
	private long num_afiliacion;
	private String descripcion;
	private String estatus;
	private String nombre_afiliacion;
	 
	public int getCliente_num() {
		return cliente_num;
	}
	
	public void setCliente_num(int cliente_num) {
		this.cliente_num = cliente_num;
	}
	
	public long getNum_afiliacion() {
		return num_afiliacion;
	}
	
	public void setNum_afiliacion(long num_afiliacion) {
		this.num_afiliacion = num_afiliacion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getEstatus() {
		return estatus;
	}
	
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	public String getNombre_afiliacion() {
		return nombre_afiliacion;
	}
	
	public void setNombre_afiliacion(String nombre_afiliacion) {
		this.nombre_afiliacion = nombre_afiliacion;
	}

	@Override
	public String toString() {
		return "Afiliacion [cliente_num=" + cliente_num + ", num_afiliacion=" + num_afiliacion + ", descripcion=" + descripcion + ", estatus=" + estatus + ", nombre_afiliacion=" + nombre_afiliacion + "]";
	}
	
	

}
