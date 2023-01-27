package com.pedidos.api.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Pagos {
	private long clienteNum;
	private long pedidoNum;
	private String paq;
	private double paqPrecio;
	private String tipoHora;
	private String fecha;
	private String hora;
	private double tipoHoraPrecio;
	private long ejecutivo;
	private int shipVia;
	
	public Pagos() {
	}
	
	@JsonCreator
	public Pagos(@JsonProperty("clienteNum") long clienteNum,
					@JsonProperty("pedidoNum") long pedidoNum,
					@JsonProperty("paq") String paq, 
					@JsonProperty("paqPrecio") double paqPrecio,
					@JsonProperty("tipoHora") String tipoHora, 
					@JsonProperty("fecha") String fecha,
					@JsonProperty("hora") String hora,
					@JsonProperty("tipoHoraPrecio") double tipoHoraPrecio,
					@JsonProperty("ejecutivo") long ejecutivo,
					@JsonProperty("shipVia") int shipVia) {
		this.clienteNum		=clienteNum;
		this.pedidoNum		=pedidoNum;
		this.paq 			= paq;
		this.paqPrecio 		= paqPrecio;
		this.tipoHora 		= tipoHora;
		this.fecha 			= fecha;
		this.hora			= hora;
		this.tipoHoraPrecio = tipoHoraPrecio;
		this.ejecutivo 		= ejecutivo;
		this.shipVia 		= shipVia;
	}

	public long getClienteNum() {
		return clienteNum;
	}

	public void setClienteNum(long clienteNum) {
		this.clienteNum = clienteNum;
	}

	public long getPedidoNum() {
		return pedidoNum;
	}

	public void setPedidoNum(long pedidoNum) {
		this.pedidoNum = pedidoNum;
	}

	public String getPaq() {
		return paq;
	}

	public void setPaq(String paq) {
		this.paq = paq;
	}

	public double getPaqPrecio() {
		return paqPrecio;
	}

	public void setPaqPrecio(double paqPrecio) {
		this.paqPrecio = paqPrecio;
	}

	public String getTipoHora() {
		return tipoHora;
	}

	public void setTipoHora(String tipoHora) {
		this.tipoHora = tipoHora;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public double getTipoHoraPrecio() {
		return tipoHoraPrecio;
	}

	public void setTipoHoraPrecio(double tipoHoraPrecio) {
		this.tipoHoraPrecio = tipoHoraPrecio;
	}

	public long getEjecutivo() {
		return ejecutivo;
	}

	public void setEjecutivo(long ejecutivo) {
		this.ejecutivo = ejecutivo;
	}

	public int getShipVia() {
		return shipVia;
	}

	public void setShipVia(int shipVia) {
		this.shipVia = shipVia;
	}

	@Override
	public String toString() {
		return "{clienteNum:" + clienteNum + ", pedidoNum:" + pedidoNum + ", paq:" + paq + ", paqPrecio:" + paqPrecio
				+ ", tipoHora:" + tipoHora + ", fecha:" + fecha + ", hora:" + hora + ", tipoHoraPrecio:"
				+ tipoHoraPrecio + ", ejecutivo:" + ejecutivo + ", shipVia:" + shipVia + "}";
	}

}