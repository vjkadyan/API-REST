package com.pedidos.api.model;

public class Membresia {
	private int cliente_num;
	private int id_afiliacion;
	private String comentario;
	private String estatus;
	
	public Membresia() {
		
	}

	public Membresia(int cliente_num, int id_afiliacion, String comentario, String estatus) {
		this.cliente_num = cliente_num;
		this.id_afiliacion = id_afiliacion;
		this.comentario = comentario;
		this.estatus = estatus;
	}
	
	public int getCliente_num() {
		return cliente_num;
	}
	public void setCliente_num(int cliente_num) {
		this.cliente_num = cliente_num;
	}
	public int getId_afiliacion() {
		return id_afiliacion;
	}
	public void setId_afiliacion(int id_afiliacion) {
		this.id_afiliacion = id_afiliacion;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	@Override
	public String toString() {
		return "Membresia [cliente_num=" + cliente_num + ", id_afiliacion=" + id_afiliacion + ", comentario="
				+ comentario + ", estatus=" + estatus + "]";
	}
}
