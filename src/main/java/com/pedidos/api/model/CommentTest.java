package com.pedidos.api.model;

public class CommentTest {
	private long id;
	private long clienteNum;
	private String fecha;
	private String comment;
	private String alias;
	private String stat;
	private String email;
	private String itemNum;
	private String tipo;
	private int calif;

	public CommentTest() {
	}

	public CommentTest(long id, long clienteNum, String fecha, String comment, String alias, String stat, String email, String itemNum, String tipo, int calif) {
		this.id = id;
		this.clienteNum = clienteNum;
		this.fecha = fecha;
		this.comment = comment;
		this.alias = alias;
		this.stat = stat;
		this.email = email;
		this.itemNum = itemNum;
		this.tipo = tipo;
		this.calif = calif;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getClienteNum() {
		return clienteNum;
	}

	public void setClienteNum(long clienteNum) {
		this.clienteNum = clienteNum;
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

	public String getItemNum() {
		return itemNum;
	}

	public void setItemNum(String itemNum) {
		this.itemNum = itemNum;
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

	@Override
	public String toString() {
		return "CommentTest [id=" + id + ", clienteNum=" + clienteNum + ", fecha=" + fecha + ", comment=" + comment + ", alias=" + alias + ", stat=" + stat + ", email=" + email + ", itemNum=" + itemNum + ", tipo=" + tipo + ", calif=" + calif + "]";
	}
}
