package com.pedidos.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PyGuias {

	private long idGuia;
	private int cliente_num;
	private long pedido_num;
	private int id_guia_direcciones_origen;
	private int id_guia_direcciones_destino;
	private double valor;
	private String asegura;
	private double asegura_monto;
	private String estatus;
	private String paqueteria;
	
	public PyGuias() {
		
	}
	
	@JsonCreator
	public PyGuias(@JsonProperty("idGuia") long idGuia, @JsonProperty("cliente_num") int cliente_num, @JsonProperty("pedido_num") long pedido_num,
			@JsonProperty("id_guia_direcciones_origen") int id_guia_direcciones_origen, 
			@JsonProperty("id_guia_direcciones_destino") int id_guia_direcciones_destino, 
			@JsonProperty("valor") double valor,
			@JsonProperty("asegura") String asegura, @JsonProperty("asegura_monto") double asegura_monto, 
			@JsonProperty("estatus") String estatus,
			@JsonProperty("paqueteria") String paqueteria) {
		super();
		this.idGuia = idGuia;
		this.cliente_num = cliente_num;
		this.pedido_num = pedido_num;
		this.id_guia_direcciones_origen = id_guia_direcciones_origen;
		this.id_guia_direcciones_destino = id_guia_direcciones_destino;
		this.valor = valor;
		this.asegura = asegura;
		this.asegura_monto = asegura_monto;
		this.estatus = estatus;
		this.paqueteria = paqueteria;
	}

	public long getIdGuia() {
		return idGuia;
	}

	public void setIdGuia(long idGuia) {
		this.idGuia = idGuia;
	}

	public int getCliente_num() {
		return cliente_num;
	}

	public void setCliente_num(int cliente_num) {
		this.cliente_num = cliente_num;
	}

	public long getPedido_num() {
		return pedido_num;
	}

	public void setPedido_num(long pedido_num) {
		this.pedido_num = pedido_num;
	}

	public int getId_guia_direcciones_origen() {
		return id_guia_direcciones_origen;
	}

	public void setId_guia_direcciones_origen(int id_guia_direcciones_origen) {
		this.id_guia_direcciones_origen = id_guia_direcciones_origen;
	}

	public int getId_guia_direcciones_destino() {
		return id_guia_direcciones_destino;
	}

	public void setId_guia_direcciones_destino(int id_guia_direcciones_destino) {
		this.id_guia_direcciones_destino = id_guia_direcciones_destino;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getAsegura() {
		return asegura;
	}

	public void setAsegura(String asegura) {
		this.asegura = asegura;
	}

	public double getAsegura_monto() {
		return asegura_monto;
	}

	public void setAsegura_monto(double asegura_monto) {
		this.asegura_monto = asegura_monto;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getPaqueteria() {
		return paqueteria;
	}

	public void setPaqueteria(String paqueteria) {
		this.paqueteria = paqueteria;
	}

	@Override
	public String toString() {
		return "{idGuia:" + idGuia + ", cliente_num:" + cliente_num + ", pedido_num:" + pedido_num
				+ ", id_guia_direcciones_origen:" + id_guia_direcciones_origen + ", id_guia_direcciones_destino:"
				+ id_guia_direcciones_destino + ", valor:" + valor + ", asegura:" + asegura + ", asegura_monto:"
				+ asegura_monto + ", estatus:" + estatus + ", paqueteria:" + paqueteria + "}";
	}

}