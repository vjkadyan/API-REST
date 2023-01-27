package com.pedidos.api.model;

public class AswerTest {
	private long idRespuesta;
	private long idComentario;
	private String contenido;
	private String fecha;
	private String stat;
	private long clienteNum;
	private String aliasr;
	private String emailr;

	public AswerTest() {
	}

	public AswerTest(long idRespuesta, long idComentario, String contenido, String fecha, String stat, long clienteNum, String aliasr, String emailr) {
		this.idRespuesta = idRespuesta;
		this.idComentario = idComentario;
		this.contenido = contenido;
		this.fecha = fecha;
		this.stat = stat;
		this.clienteNum = clienteNum;
		this.aliasr = aliasr;
		this.emailr = emailr;
	}

	public long getIdRespuesta() {
		return idRespuesta;
	}

	public void setIdRespuesta(long idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	public long getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(long idComentario) {
		this.idComentario = idComentario;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	public long getClienteNum() {
		return clienteNum;
	}

	public void setClienteNum(long clienteNum) {
		this.clienteNum = clienteNum;
	}

	public String getAliasr() {
		return aliasr;
	}

	public void setAliasr(String aliasr) {
		this.aliasr = aliasr;
	}

	public String getEmailr() {
		return emailr;
	}

	public void setEmailr(String emailr) {
		this.emailr = emailr;
	}

	@Override
	public String toString() {
		return "AswerTest [idRespuesta=" + idRespuesta + ", idComentario=" + idComentario + ", contenido=" + contenido + ", fecha=" + fecha + ", stat=" + stat + ", clienteNum=" + clienteNum + ", aliasr=" + aliasr + ", emailr=" + emailr + "]";
	}
}
