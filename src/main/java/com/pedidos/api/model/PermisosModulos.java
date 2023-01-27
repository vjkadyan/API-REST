package com.pedidos.api.model;

public class PermisosModulos {
	private long clienteNum;
	private long usuarioNum;
	private long moduloNum;
	private String status;
	
	@Override
	public String toString() {
		return "PermisosModulos [clienteNum=" + clienteNum + ", usuarioNum=" + usuarioNum + ", moduloNum=" + moduloNum + ", status=" + status + "]";
	}

	public long getClienteNum() {
		return clienteNum;
	}
	
	public void setClienteNum(long clienteNum) {
		this.clienteNum = clienteNum;
	}
	
	public long getUsuarioNum() {
		return usuarioNum;
	}
	
	public void setUsuarioNum(long usuarioNum) {
		this.usuarioNum = usuarioNum;
	}
	
	public long getModuloNum() {
		return moduloNum;
	}
	
	public void setModuloNum(long moduloNum) {
		this.moduloNum = moduloNum;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
