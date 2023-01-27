package com.pedidos.api.model;

public class PyMPago {
	private int mpago;
	private String descripcion;
	private String pay_code_sat;
	private String metodo_pago;
 
	public int getMpago() {
		return mpago;
	}

	public void setMpago(int mpago) {
		this.mpago = mpago;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPay_code_sat() {
		return pay_code_sat;
	}

	public void setPay_code_sat(String pay_code_sat) {
		this.pay_code_sat = pay_code_sat;
	}

	public String getMetodo_pago() {
		return metodo_pago;
	}

	public void setMetodo_pago(String metodo_pago) {
		this.metodo_pago = metodo_pago;
	}

	@Override
	public String toString() {
		return "PyMPago [mpago=" + mpago + ", descripcion=" + descripcion + ", pay_code_sat=" + pay_code_sat + ", metodo_pago=" + metodo_pago + "]";
	}

	public PyMPago(int mpago, String descripcion, String pay_code_sat, String metodo_pago) {
		this.mpago = mpago;
		this.descripcion = descripcion;
		this.pay_code_sat = pay_code_sat;
		this.metodo_pago = metodo_pago;
	}

	public PyMPago() {
	}
}
