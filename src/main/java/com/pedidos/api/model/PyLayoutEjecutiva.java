package com.pedidos.api.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PyLayoutEjecutiva {
	private String fecha;
	private long clienteNum;
	private int empleadoNum;
	private int calificacion;
	private String comentario;
	private String evaluado;
	
	public PyLayoutEjecutiva() {}
	
	@JsonCreator
	public PyLayoutEjecutiva(	@JsonProperty("fecha") String fecha,
								@JsonProperty("clienteNum") long clienteNum,
								@JsonProperty("ejecutivoNum") int empleadoNum,
								@JsonProperty("calif") int calificacion,
								@JsonProperty("coment") String comentario,
								@JsonProperty("evaluado") String evaluado)
	{
		this.fecha = fecha;
		this.clienteNum = clienteNum;
		this.empleadoNum = empleadoNum;
		this.calificacion = calificacion;
		this.comentario = comentario;
		this.evaluado = evaluado;
	}

	@Override
	public String toString() {
		return "{fecha:" + fecha + ", clienteNum:" + clienteNum + ", empleadoNum:" + empleadoNum + ", calificacion:"
				+ calificacion + ", comentario:" + comentario + ", evaluado:" + evaluado + "}";
	}

	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public long getClienteNum() {
		return clienteNum;
	}
	
	public void setClienteNum(long clienteNum) {
		this.clienteNum = clienteNum;
	}
	
	public int getEmpleadoNum() {
		return empleadoNum;
	}
	
	public void setEmpleadoNum(int empleadoNum) {
		this.empleadoNum = empleadoNum;
	}
	
	public int getCalificacion() {
		return calificacion;
	}
	
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	
	public String getComentario() {
		return comentario;
	}
	
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public String getEvaluado() {
		return evaluado;
	}
	
	public void setEvaluado(String evaluado) {
		this.evaluado = evaluado;
	}
}