package com.pedidos.api.model;

public class PyMpagoCuenta {

	private Long cliente_num;
	private String cuenta;

	public PyMpagoCuenta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PyMpagoCuenta(Long cliente_num, String cuenta) {
		super();
		this.cliente_num = cliente_num;
		this.cuenta = cuenta;
	}

	public Long getClienteNum() {
		return cliente_num;
	}

	public void setClienteNum(Long cliente_num) {
		this.cliente_num = cliente_num;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	@Override
	public String toString() {
		return "PyMpagoCuenta [cliente_num=" + cliente_num + ", cuenta=" + cuenta + "]";
	}

}
