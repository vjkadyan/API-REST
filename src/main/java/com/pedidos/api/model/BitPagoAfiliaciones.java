package com.pedidos.api.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BitPagoAfiliaciones {
	
	private Long pedidoNum;
	private Long clienteNum;
	private int numAfiliacion;
	private int rechazos;
	private int otrosMsg;
	private String statusBank;
	private String ip;
	private double monto;
	private String fecha;
	
	public BitPagoAfiliaciones() {
	}
	
	@JsonCreator
	public BitPagoAfiliaciones(@JsonProperty("pedidoNum")Long pedidoNum, 
			@JsonProperty("clienteNum") Long clienteNum, 
			@JsonProperty("numAfiliacion") int numAfiliacion, 
			@JsonProperty("rechazos") int rechazos, 
			@JsonProperty("otrosMsg") int otrosMsg,
			@JsonProperty("statusBank") String statusBank, 
			@JsonProperty("ip") String ip, 
			@JsonProperty("monto") double monto,
			@JsonProperty("fecha") String fecha) {
		super();
		this.pedidoNum = pedidoNum;
		this.clienteNum = clienteNum;
		this.numAfiliacion = numAfiliacion;
		this.rechazos = rechazos;
		this.otrosMsg = otrosMsg;
		this.statusBank = statusBank;
		this.ip = ip;
		this.monto = monto;
		this.fecha = fecha;
	}

	public Long getPedidoNum() {
		return pedidoNum;
	}

	public void setPedidoNum(Long pedidoNum) {
		this.pedidoNum = pedidoNum;
	}

	public Long getClienteNum() {
		return clienteNum;
	}

	public void setClienteNum(Long clienteNum) {
		this.clienteNum = clienteNum;
	}

	public int getNumAfiliacion() {
		return numAfiliacion;
	}

	public void setNumAfiliacion(int numAfiliacion) {
		this.numAfiliacion = numAfiliacion;
	}

	public int getRechazos() {
		return rechazos;
	}

	public void setRechazos(int rechazos) {
		this.rechazos = rechazos;
	}

	public int getOtrosMsg() {
		return otrosMsg;
	}

	public void setOtrosMsg(int otrosMsg) {
		this.otrosMsg = otrosMsg;
	}

	public String getStatusBank() {
		return statusBank;
	}

	public void setStatusBank(String statusBank) {
		this.statusBank = statusBank;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "{pedidoNum:" + pedidoNum + ", clienteNum:" + clienteNum + ", numAfiliacion:" + numAfiliacion
				+ ", rechazos:" + rechazos + ", otrosMsg:" + otrosMsg + ", statusBank:" + statusBank + ", ip:" + ip
				+ ", monto:" + monto + ", fecha:" + fecha + "}";
	}

}
