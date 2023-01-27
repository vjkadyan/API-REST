package com.pedidos.api.model;

public class PermisosCorreos {
	private long clienteNum;
	private long usuarioNum;
	private long correoNum;
	private String status;
	
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
	
	public long getCorreoNum() {
		return correoNum;
	}
	
	public void setCorreoNum(long correoNum) {
		this.correoNum = correoNum;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "PermisosCorreos [clienteNum=" + clienteNum + ", usuarioNum=" + usuarioNum + ", correoNum=" + correoNum + ", status=" + status + "]";
	}

}
