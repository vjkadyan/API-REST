package com.pedidos.api.model;

public class ReseniasRespuesta {
	private long id_respuesta;
	private long id_comentario;
	private String contenido;
	private String fecha;
	private String stat;
	private Long cliente_num;
	private String aliasr;
	private String emailr;

	public ReseniasRespuesta() {
	}

	public ReseniasRespuesta(long id_respuesta, long id_comentario, String contenido, String fecha, String stat, Long cliente_num, String aliasr, String emailr) {
		this.id_respuesta = id_respuesta;
		this.id_comentario = id_comentario;
		this.contenido = contenido;
		this.fecha = fecha;
		this.stat = stat;
		this.cliente_num = cliente_num;
		this.aliasr = aliasr;
		this.emailr = emailr;
	}

	public long getId_respuesta() {
		return id_respuesta;
	}

	public void setId_respuesta(long id_respuesta) {
		this.id_respuesta = id_respuesta;
	}

	public long getId_comentario() {
		return id_comentario;
	}

	public void setId_comentario(long id_comentario) {
		this.id_comentario = id_comentario;
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

	public Long getCliente_num() {
		return cliente_num;
	}

	public void setCliente_num(Long cliente_num) {
		this.cliente_num = cliente_num;
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
		return "ReseniasRespuesta [id_respuesta=" + id_respuesta + ", id_comentario=" + id_comentario + ", contenido=" + contenido + ", fecha=" + fecha + ", stat=" + stat + ", cliente_num=" + cliente_num + ", aliasr=" + aliasr + ", emailr=" + emailr + "]";
	}
}
