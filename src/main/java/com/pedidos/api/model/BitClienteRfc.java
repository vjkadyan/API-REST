package com.pedidos.api.model;

public class BitClienteRfc {
	private int idBit;
	private String tipoBit;
	private long clienteNum;
	private String clienteRfc;
	private String mensaje;
	private String fecha;
	 
	@Override
	public String toString() {
		return "BitClienteRfc [idBit=" + idBit + ", tipoBit=" + tipoBit + ", clienteNum=" + clienteNum + ", clienteRfc=" + clienteRfc + ", mensaje=" + mensaje + ", fecha=" + fecha + "]";
	}

	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getIdBit() {
		return idBit;
	}
	
	public void setIdBit(int idBit) {
		this.idBit = idBit;
	}

	public String getTipoBit() {
		return tipoBit;
	}
	
	public void setTipoBit(String tipoBit) {
		this.tipoBit = tipoBit;
	}
	
	public long getClienteNum() {
		return clienteNum;
	}
	
	public void setClienteNum(long clienteNum) {
		this.clienteNum = clienteNum;
	}
	
	public String getClienteRfc() {
		return clienteRfc;
	}
	
	public void setClienteRfc(String clienteRfc) {
		this.clienteRfc = clienteRfc;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
