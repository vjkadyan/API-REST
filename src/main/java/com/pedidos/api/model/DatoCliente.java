package com.pedidos.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
 
public class DatoCliente {
	private String nombre;
	private String apellido;
	private String statEmp;
	private String empresa;
	private String email;
	private String fechaNac;
	private long usuarioNum;
	private String tipoCuenta;
	private int nivelAcceso;
	
	public DatoCliente() {}
	
	@JsonCreator
	public DatoCliente(	@JsonProperty("nombre") String nombre,
						@JsonProperty("apellido") String apellido,
						@JsonProperty("statEmp") String statEmp,
						@JsonProperty("empresa") String empresa,
						@JsonProperty("email") String email,
						@JsonProperty("fechaNac") String fechaNac,
						@JsonProperty("usuarioNum") long usuarioNum,
						@JsonProperty("tipoCuenta") String tipoCuenta,
						@JsonProperty("nivelAcceso") int nivelAcceso)
	{
		this.nombre = nombre.trim();
		this.apellido = apellido.trim();
		this.statEmp = statEmp.trim();
		this.empresa = empresa.trim();
		this.email = email.trim();
		this.fechaNac = fechaNac.trim();
		this.usuarioNum = usuarioNum;
		this.tipoCuenta = tipoCuenta.trim();
		this.nivelAcceso = nivelAcceso;
	}

	

	@Override
	public String toString() {
		return "{nombre:" + nombre + ", apellido:" + apellido + ", statEmp:" + statEmp + ", empresa:" + empresa
				+ ", email:" + email + ", fechaNac:" + fechaNac + ", usuarioNum:" + usuarioNum + ", tipoCuenta:"
				+ tipoCuenta + ", nivelAcceso:" + nivelAcceso + "}";
	}

	public int getNivelAcceso() {
		return nivelAcceso;
	}

	
	public void setNivelAcceso(int nivelAcceso) {
		this.nivelAcceso = nivelAcceso;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public long getUsuarioNum() {
		return usuarioNum;
	}

	
	public void setUsuarioNum(long usuarioNum) {
		this.usuarioNum = usuarioNum;
	}

	public String getStatEmp() {
		return statEmp;
	}

	
	public void setStatEmp(String statEmp) {
		this.statEmp = statEmp;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}
	
}