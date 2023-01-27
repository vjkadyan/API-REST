package com.pedidos.api.model;


public class PyFormaPagoTv {

	private long id;
	private long pedido_num;
	private long cliente_num;
	private long fp_num;

	public PyFormaPagoTv() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPedido_num() {
		return pedido_num;
	}

	public void setPedido_num(long pedido_num) {
		this.pedido_num = pedido_num;
	}

	public long getCliente_num() {
		return cliente_num;
	}

	public void setCliente_num(long cliente_num) {
		this.cliente_num = cliente_num;
	}

	public long getFp_num() {
		return fp_num;
	}

	public void setFp_num(long fp_num) {
		this.fp_num = fp_num;
	}

	public PyFormaPagoTv(long id, long pedido_num, long cliente_num, long fp_num) {
		this.id = id;
		this.pedido_num = pedido_num;
		this.cliente_num = cliente_num;
		this.fp_num = fp_num;
	}

	public PyFormaPagoTv(long pedido_num) {
		super();
		this.pedido_num = pedido_num;
	}

	@Override
	public String toString() {
		return "{id:" + id + ", pedido_num:" + pedido_num + ", cliente_num:" + cliente_num + ", fp_num:" + fp_num + "}";
	}

}