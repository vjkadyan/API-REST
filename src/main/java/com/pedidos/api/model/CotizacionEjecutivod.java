package com.pedidos.api.model;

public class CotizacionEjecutivod {
	
	private Long num_empleado;
	private String nombre;
	private String email;
	private int ext;
	private String stat;
	private String ckase;
	
	public CotizacionEjecutivod() {
	}

	public CotizacionEjecutivod(Long num_empleado, String nombre, String email, int ext, String stat, String ckase) {
		this.num_empleado = num_empleado;
		this.nombre = nombre;
		this.email = email;
		this.ext = ext;
		this.stat = stat;
		this.ckase = ckase;
	}

	public Long getNum_empleado() {
		return num_empleado;
	}

	public void setNum_empleado(Long num_empleado) {
		this.num_empleado = num_empleado;
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

	public int getExt() {
		return ext;
	}

	public void setExt(int ext) {
		this.ext = ext;
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	public String getCkase() {
		return ckase;
	}

	public void setCkase(String ckase) {
		this.ckase = ckase;
	}

	@Override
	public String toString() {
		return "CotizacionEjecutivod [num_empleado=" + num_empleado + ", nombre=" + nombre + ", email=" + email
				+ ", ext=" + ext + ", stat=" + stat + ", ckase=" + ckase + "]";
	}
	

}
