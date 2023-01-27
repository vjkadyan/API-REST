package com.pedidos.api.model;

public class ResenaPedidos {
	private int slmn;
	private String fecha;
	private long pedidoNum;
	private String nombre;
	private String email;
	private String ext;
	private String stat;
	private String ckase;
	private PyLayoutEjecutiva pyLayoutEjecutiva;
	
	public int getSlmn() {
		return slmn;
	}
	
	public void setSlmn(int slmn) {
		this.slmn = slmn;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public long getPedidoNum() {
		return pedidoNum;
	}
	
	public void setPedidoNum(long pedidoNum) {
		this.pedidoNum = pedidoNum;
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
	
	public String getExt() {
		return ext;
	}
	
	public void setExt(String ext) {
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
	
	public PyLayoutEjecutiva getPyLayoutEjecutiva() {
		return pyLayoutEjecutiva;
	}
	
	public void setPyLayoutEjecutiva(PyLayoutEjecutiva pyLayoutEjecutiva) {
		this.pyLayoutEjecutiva = pyLayoutEjecutiva;
	}

	@Override
	public String toString() {
		return "ReseñaPedidos [slmn=" + slmn + ", fecha=" + fecha + ", pedidoNum=" + pedidoNum + ", nombre=" + nombre + ", email=" + email + ", ext=" + ext + ", stat=" + stat + ", ckase=" + ckase + ", pyLayoutEjecutiva=" + pyLayoutEjecutiva + "]";
	}
	
}
