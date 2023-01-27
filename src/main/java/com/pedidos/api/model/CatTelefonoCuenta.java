package com.pedidos.api.model;

public class CatTelefonoCuenta {
	 
	private int tipoNum;
	private String tipo;
	private String status;
	
	public CatTelefonoCuenta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CatTelefonoCuenta(int tipoNum, String tipo, String status) {
		super();
		this.tipoNum = tipoNum;
		this.tipo = tipo;
		this.status = status;
	}

	public int getTipoNum() {
		return tipoNum;
	}

	public void setTipoNum(int tipoNum) {
		this.tipoNum = tipoNum;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CatTelefonoCuenta [tipoNum=" + tipoNum + ", tipo=" + tipo + ", status=" + status + "]";
	}
	

}
