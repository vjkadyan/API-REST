package com.pedidos.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Carrito {
	private long cliente_num;
	private long usuario_num;
	private int cantidad;
	private String item_num;
	private String seguro;
	private String garantia;
	
	public Carrito() {
	}
	
	@JsonCreator
	public Carrito(@JsonProperty("cliente_num") long cliente_num,
					@JsonProperty("usuario_num") long usuario_num,
					@JsonProperty("cantidad") int cantidad, 
					@JsonProperty("item_num") String item_num,
					@JsonProperty("seguro") String seguro, 
					@JsonProperty("garantia") String garantia) {
		this.cliente_num=cliente_num;
		this.usuario_num=usuario_num;
		this.cantidad = cantidad;
		this.item_num = item_num;
		this.seguro = seguro;
		this.garantia = garantia;
	}

	public long getCliente_num() {
		return cliente_num;
	}

	public void setCliente_num(long cliente_num) {
		this.cliente_num = cliente_num;
	}

	public long getUsuario_num() {
		return usuario_num;
	}

	public void setUsuario_num(long usuario_num) {
		this.usuario_num = usuario_num;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getItem_num() {
		return item_num;
	}

	public void setItem_num(String item_num) {
		this.item_num = item_num;
	}

	public String getSeguro() {
		return seguro;
	}

	public void setSeguro(String seguro) {
		this.seguro = seguro;
	}

	public String getGarantia() {
		return garantia;
	}

	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}

	@Override
	public String toString() {
		return "{cliente_num:" + cliente_num + ", usuario_num:" + usuario_num + ", cantidad:" + cantidad + ", item_num:"
				+ item_num + ", seguro:" + seguro + ", garantia:" + garantia + "}";
	}

}
