package com.pedidos.api.model;

public class PyClienteBo {

	private long cliente_num;
	private int cust_num;
	private String backorder;

	public PyClienteBo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getClienteNum() {
		return cliente_num;
	}

	public void setClienteNum(long l) {
		this.cliente_num = l;
	}

	public int getCustNum() {
		return cust_num;
	}

	public void setCustNum(int cust_num) {
		this.cust_num = cust_num;
	}

	public String getBackorder() {
		return backorder;
	}

	public void setBackorder(String string) {
		this.backorder = string;
	}

	@Override
	public String toString() {
		return "PyClienteBo [cliente_num=" + cliente_num + ", cust_num=" + cust_num + ", backorder=" + backorder + "]";
	}

}
