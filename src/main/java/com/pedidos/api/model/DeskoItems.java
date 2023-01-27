package com.pedidos.api.model;

public class DeskoItems {

	private String item;
	private int cantidad;
	
	public DeskoItems() {
		super();
	}
	
	public DeskoItems(String item, int cantidad) {
		super();
		this.item = item;
		this.cantidad = cantidad;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}	
	
	public String toString() {
		String deskoItems = "{ item : " + item + ", cantidad : " + cantidad + " }";
		return deskoItems;
	}
}
