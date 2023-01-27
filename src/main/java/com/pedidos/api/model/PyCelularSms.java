package com.pedidos.api.model;


public class PyCelularSms {
	 
	private int celular_num;
	private Long cliente_num;
	private String fecha_registro;
	private String celular;
	private String status;
	
	
	public PyCelularSms() {
	}

	public PyCelularSms(int celular_num, Long cliente_num, String fecha_registro, String celular, String status) {
		super();
		this.celular_num = celular_num;
		this.cliente_num = cliente_num;
		this.fecha_registro = fecha_registro;
		this.celular = celular;
		this.status = status;
	}

	public int getCelular_num() {
		return celular_num;
	}

	public void setCelular_num(int celular_num) {
		this.celular_num = celular_num;
	}

	public Long getCliente_num() {
		return cliente_num;
	}

	public void setCliente_num(Long cliente_num) {
		this.cliente_num = cliente_num;
	}

	public String getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "{celular_num:" + celular_num + ", cliente_num:" + cliente_num + ", fecha_registro:" + fecha_registro
				+ ", celular:" + celular + ", status:" + status + "}";
	}
}
