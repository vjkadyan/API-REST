package com.pedidos.api.model;

public class PyClienteCodigo {
	private long 	cliente_num;
	private String 	isEmpresa;
	private String 	codigo;
	private String 	estatus;
	private String 	fecha;
	private String 	correo;
	private String  contrasena;
	private String  usuario;
	
	public long getCliente_num() {
		return cliente_num;
	}
	public void setCliente_num(long cliente_num) {
		this.cliente_num = cliente_num;
	}
	public String getIsEmpresa() {
		return isEmpresa;
	}
	public void setIsEmpresa(String isEmpresa) {
		this.isEmpresa = isEmpresa;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "PyClienteCodigo [cliente_num=" + cliente_num + ", isEmpresa=" + isEmpresa + ", codigo=" + codigo
				+ ", estatus=" + estatus + ", fecha=" + fecha + ", correo=" + correo + ", contrasena=" + contrasena
				+ ", usuario=" + usuario + "]";
	}	
}
