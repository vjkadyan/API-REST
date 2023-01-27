package com.pedidos.api.model;

public class DatosFacturacion {
	private int rfcNum;
	private String usoCfdi;
	private String clienteRfc;
	private String razonSocial;
	private String direccionFiscal;
	private String cp;
	private String colonia;
	private String ciudad;
	private String delegacion;
	private String estado;
	 
	public int getRfcNum() {
		return rfcNum;
	}
	
	public void setRfcNum(int rfcNum) {
		this.rfcNum = rfcNum;
	}
	
	public String getUsoCfdi() {
		return usoCfdi;
	}
	
	public void setUsoCfdi(String usoCfdi) {
		this.usoCfdi = usoCfdi;
	}
	
	public String getClienteRfc() {
		return clienteRfc;
	}
	
	public void setClienteRfc(String clienteRfc) {
		this.clienteRfc = clienteRfc;
	}
	
	public String getRazonSocial() {
		return razonSocial;
	}
	
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	
	public String getDireccionFiscal() {
		return direccionFiscal;
	}
	
	public void setDireccionFiscal(String direccionFiscal) {
		this.direccionFiscal = direccionFiscal;
	}
	
	public String getCp() {
		return cp;
	}
	
	public void setCp(String cp) {
		this.cp = cp;
	}
	
	public String getColonia() {
		return colonia;
	}
	
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public String getDelegacion() {
		return delegacion;
	}
	
	public void setDelegacion(String delegacion) {
		this.delegacion = delegacion;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "DatosFacturacion [rfcNum=" + rfcNum + ", usoCfdi=" + usoCfdi + ", clienteRfc=" + clienteRfc + ", razonSocial=" + razonSocial + ", direccionFiscal=" + direccionFiscal + ", cp=" + cp + ", colonia=" + colonia + ", ciudad=" + ciudad + ", delegacion=" + delegacion + ", estado=" + estado + "]";
	}
}
