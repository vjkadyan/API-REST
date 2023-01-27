package com.pedidos.api.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DatoFactNuevo {
	private long clienteNum;
	private String clienteRfc;
	private String usoCfdi;
	private String razonSocial;
	private String telefono;
	private String contact;
	private String direccion;
	private String cp;
	private String colonia;
	private String estado;
	private String delegacion;
	private int mpago;
	 
	public DatoFactNuevo() {}

	@JsonCreator
	public DatoFactNuevo(	@JsonProperty("clienteNum") long clienteNum,
							@JsonProperty("clienteRfc") String clienteRfc,
							@JsonProperty("razonSocial") String razonSocial,
							@JsonProperty("telefono") String telefono,
							@JsonProperty("contact") String contact,
							@JsonProperty("direccion") String direccion,
							@JsonProperty("cp") String cp,
							@JsonProperty("colonia") String colonia,
							@JsonProperty("estado") String estado,
							@JsonProperty("delegacion") String delegacion,
							@JsonProperty("mpago") int mpago) {
		this.clienteNum = clienteNum;
		this.clienteRfc = clienteRfc.trim();
		this.razonSocial = razonSocial.trim();
		this.telefono = telefono.trim();
		this.contact = contact.trim();
		this.direccion = direccion.trim();
		this.cp = cp.trim();
		this.colonia = colonia.trim();
		this.estado = estado.trim();
		this.delegacion = delegacion.trim();
		this.mpago = mpago;
	}

	@Override
	public String toString() {
		return "{clienteNum:" + clienteNum + ", clienteRfc:" + clienteRfc + ", usoCfdi:" + usoCfdi + ", razonSocial:"
				+ razonSocial + ", telefono:" + telefono + ", contact:" + contact + ", direccion:" + direccion + ", cp:"
				+ cp + ", colonia:" + colonia + ", estado:" + estado + ", delegacion:" + delegacion + ", mpago:" + mpago
				+ "}";
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

	
	public String getUsoCfdi() {
		return usoCfdi;
	}

	
	public void setUsoCfdi(String usoCfdi) {
		this.usoCfdi = usoCfdi;
	}

	
	public String getRazonSocial() {
		return razonSocial;
	}

	
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	
	public String getTelefono() {
		return telefono;
	}

	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
	public String getContact() {
		return contact;
	}

	
	public void setContact(String contact) {
		this.contact = contact;
	}

	
	public String getDireccion() {
		return direccion;
	}

	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	
	public String getEstado() {
		return estado;
	}

	
	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	public String getDelegacion() {
		return delegacion;
	}

	
	public void setDelegacion(String delegacion) {
		this.delegacion = delegacion;
	}

	
	public int getMpago() {
		return mpago;
	}

	
	public void setMpago(int mpago) {
		this.mpago = mpago;
	}
}
