package com.pedidos.api.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PyLayoutMailJson {
	private long id_evaluacion;
	private long invoice_num;
	private long certif_num;
	private long cliente_num;
	private int evaluacion;
	private String comentario;
	private String fecha;
	
	@JsonCreator
	public PyLayoutMailJson(@JsonProperty("id_evaluacion") long id_evaluacion,
							@JsonProperty("invoice_num") long invoice_num,
							@JsonProperty("certif_num") long certif_num,
							@JsonProperty("cliente_num") long cliente_num,
							@JsonProperty("evaluacion") int evaluacion,
							@JsonProperty("comentario") String comentario,
							@JsonProperty("fecha") String fecha)
	{
		this.id_evaluacion = id_evaluacion;
		this.invoice_num = invoice_num;
		this.certif_num = certif_num;
		this.cliente_num = cliente_num;
		this.evaluacion = evaluacion;
		this.comentario = comentario;
		this.fecha = fecha;
	}

	
	public long getId_evaluacion() {
		return id_evaluacion;
	}

	
	public void setId_evaluacion(long id_evaluacion) {
		this.id_evaluacion = id_evaluacion;
	}

	
	public long getInvoice_num() {
		return invoice_num;
	}

	
	public void setInvoice_num(long invoice_num) {
		this.invoice_num = invoice_num;
	}

	
	public long getCertif_num() {
		return certif_num;
	}

	
	public void setCertif_num(long certif_num) {
		this.certif_num = certif_num;
	}

	
	public long getCliente_num() {
		return cliente_num;
	}

	
	public void setCliente_num(long cliente_num) {
		this.cliente_num = cliente_num;
	}

	
	public int getEvaluacion() {
		return evaluacion;
	}

	
	public void setEvaluacion(int evaluacion) {
		this.evaluacion = evaluacion;
	}

	
	public String getComentario() {
		return comentario;
	}

	
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	
	public String getFecha() {
		return fecha;
	}

	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "{id_evaluacion:" + id_evaluacion + ", invoice_num:" + invoice_num + ", certif_num:" + certif_num
				+ ", cliente_num:" + cliente_num + ", evaluacion:" + evaluacion + ", comentario:" + comentario
				+ ", fecha:" + fecha + "}";
	}
	
}