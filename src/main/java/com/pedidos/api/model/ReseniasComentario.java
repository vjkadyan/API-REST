package com.pedidos.api.model;

import java.util.List;


public class ReseniasComentario {
	private long id;
	private long cliente_num;
	private String fecha;
	private String comment;
	private String alias;
	private String stat;
	private String email;
	private String item_num;
	private String tipo;
	private int calif;
	private List<ReseniasRespuesta> reseniasRespuesta;

	public ReseniasComentario() {
	}

	public ReseniasComentario(int id, long cliente_num, String fecha, String comment, String alias, String stat, String email, String item_num, String tipo, int calif, List<ReseniasRespuesta> reseniasRespuesta) {
		this.id = id;
		this.cliente_num = cliente_num;
		this.fecha = fecha;
		this.comment = comment;
		this.alias = alias;
		this.stat = stat;
		this.email = email;
		this.item_num = item_num;
		this.tipo = tipo;
		this.calif = calif;
		this.reseniasRespuesta = reseniasRespuesta;
	}

	public long getId() {
		return id;
	}

	public void setId(long l) {
		this.id = l;
	}

	public long getCliente_num() {
		return cliente_num;
	}

	public void setCliente_num(long cliente_num) {
		this.cliente_num = cliente_num;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getItem_num() {
		return item_num;
	}

	public void setItem_num(String item_num) {
		this.item_num = item_num;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCalif() {
		return calif;
	}

	public void setCalif(int calif) {
		this.calif = calif;
	}

	public List<ReseniasRespuesta> getReseniasRespuesta() {
		return reseniasRespuesta;
	}

	public void setReseniasRespuesta(List<ReseniasRespuesta> reseniasRespuesta) {
		this.reseniasRespuesta = reseniasRespuesta;
	}

	@Override
	public String toString() {
		return "ReseniasComentario [id=" + id + ", cliente_num=" + cliente_num + ", fecha=" + fecha + ", comment=" + comment + ", alias=" + alias + ", stat=" + stat + ", email=" + email + ", item_num=" + item_num + ", tipo=" + tipo + ", calif=" + calif + ", reseniasRespuesta=" + reseniasRespuesta + "]";
	}
}
