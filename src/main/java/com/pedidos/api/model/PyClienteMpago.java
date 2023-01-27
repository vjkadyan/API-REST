package com.pedidos.api.model;

public class PyClienteMpago {

	private long cliente_num;
	private int mpago;

	public PyClienteMpago() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PyClienteMpago(int cliente_num, int mpago) {
		super();
		this.cliente_num = cliente_num;
		this.mpago = mpago;
	}

	public long getClienteNum() {
		return cliente_num;
	}

	public void setClienteNum(long cliente_num) {
		this.cliente_num = cliente_num;
	}

	public int getMpago() {
		return mpago;
	}

	public void setMpago(int mpago) {
		this.mpago = mpago;
	}

	@Override
	public String toString() {
		return "PyClienteMpago [cliente_num=" + cliente_num + ", mpago=" + mpago + "]";
	}

}
