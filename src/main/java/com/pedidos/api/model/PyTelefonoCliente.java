package com.pedidos.api.model;


public class PyTelefonoCliente {
 
	private int telNum;
	private Long clienteNum;
	private Long usuarioNum;
	private String telefono;
	private String extension;
	private int tipoNum;
	private String fechaRegistro;
	private String status;
	private int rolNum;
	
	public PyTelefonoCliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PyTelefonoCliente(int telNum, Long clienteNum, Long usuarioNum, String telefono, String extension, int tipoNum,
			String fechaRegistro, String status, int rolNum) {
		super();
		this.telNum = telNum;
		this.clienteNum = clienteNum;
		this.usuarioNum = usuarioNum;
		this.telefono = telefono;
		this.extension = extension;
		this.tipoNum = tipoNum;
		this.fechaRegistro = fechaRegistro;
		this.status = status;
		this.rolNum = rolNum;
	}

	public int getTelNum() {
		return telNum;
	}

	public void setTelNum(int telNum) {
		this.telNum = telNum;
	}

	public Long getClienteNum() {
		return clienteNum;
	}

	public void setClienteNum(Long clienteNum) {
		this.clienteNum = clienteNum;
	}

	public Long getUsuarioNum() {
		return usuarioNum;
	}

	public void setUsuarioNum(Long usuarioNum) {
		this.usuarioNum = usuarioNum;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public int getTipoNum() {
		return tipoNum;
	}

	public void setTipoNum(int tipoNum) {
		this.tipoNum = tipoNum;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getRolNum() {
		return rolNum;
	}

	public void setRolNum(int rolNum) {
		this.rolNum = rolNum;
	}

	@Override
	public String toString() {
		return "{telNum:" + telNum + ", clienteNum:" + clienteNum + ", usuarioNum:" + usuarioNum + ", telefono:"
				+ telefono + ", extension:" + extension + ", tipoNum:" + tipoNum + ", fechaRegistro:" + fechaRegistro
				+ ", status:" + status + ", rolNum:" + rolNum + "}";
	}
	
}