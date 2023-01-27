package com.pedidos.api.model;

public class PyConFactura {

	private long cust_num;
	private String factura;

	public PyConFactura() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PyConFactura(int cust_num, String factura) {
		super();
		this.cust_num = cust_num;
		this.factura = factura;
	}

	public long getCustNum() {
		return cust_num;
	}

	public void setCustNum(long cust_num) {
		this.cust_num = cust_num;
	}

	public String getFactura() {
		return factura;
	}

	public void setFactura(String factura) {
		this.factura = factura;
	}

	@Override
	public String toString() {
		return "PyConFactura [cust_num=" + cust_num + ", factura=" + factura + "]";
	}

}

