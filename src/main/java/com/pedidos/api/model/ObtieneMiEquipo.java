package com.pedidos.api.model;

import java.util.List;

public class ObtieneMiEquipo {
	
	private long clienteNum;
	private long usuarioNum;
	private String cargo;
	private int accionNum;
	private String fechaRegistro;
	private String identificador;
	private String status;
	private String nombre;
	private String email;
	
	private List<ModulosUsuario> modulosUsuario;
	private List<CorreosUsuario> correosUsuario;
	
	@Override
	public String toString() {
		return "ObtieneMiEquipo [clienteNum=" + clienteNum + ", usuarioNum=" + usuarioNum + ", cargo=" + cargo + ", accionNum=" + accionNum + ", fechaRegistro=" + fechaRegistro + ", identificador=" + identificador + ", status=" + status + ", nombre=" + nombre + ", email=" + email + ", modulosUsuario=" + modulosUsuario + ", correosUsuario=" + correosUsuario + "]";
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
	
	public String getCargo() {
		return cargo;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public int getAccionNum() {
		return accionNum;
	}
	
	public void setAccionNum(int accionNum) {
		this.accionNum = accionNum;
	}
	
	public String getFechaRegistro() {
		return fechaRegistro;
	}
	
	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	public String getIdentificador() {
		return identificador;
	}
	
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<ModulosUsuario> getModulosUsuario() {
		return modulosUsuario;
	}
	
	public void setModulosUsuario(List<ModulosUsuario> modulosUsuario) {
		this.modulosUsuario = modulosUsuario;
	}
	
	public List<CorreosUsuario> getCorreosUsuario() {
		return correosUsuario;
	}
	
	public void setCorreosUsuario(List<CorreosUsuario> correosUsuario) {
		this.correosUsuario = correosUsuario;
	}
}
