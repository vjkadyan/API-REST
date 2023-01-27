package com.pedidos.api.model;


public class CarritoPedidosItems {

	private String item;
	private int cantidad;
	private int partida;
	private String centroCosto;
	private boolean seguro;
	private boolean garant1;
	private boolean garant2;
	
	public CarritoPedidosItems() {
	}
	public CarritoPedidosItems(String item, int cantidad, int partida, String centroCosto, boolean seguro, boolean garant1, boolean garant2) {
		super();
		this.item = item;
		this.cantidad = cantidad;
		this.partida = partida;
		this.centroCosto = centroCosto;
		this.seguro = seguro;
		this.garant1 = garant1;
		this.garant2 = garant2;
	}
	
	public String getCentroCosto() {
		return centroCosto;
	}
	public void setCentroCosto(String centroCosto) {
		this.centroCosto = centroCosto;
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
	
	public int getPartida() {
		return partida;
	}
	
	public void setPartida(int partida) {
		this.partida = partida;
	}
	public boolean isSeguro() {
		return seguro;
	}
	public void setSeguro(boolean seguro) {
		this.seguro = seguro;
	}
	public boolean isGarant1() {
		return garant1;
	}
	public void setGarant1(boolean garant1) {
		this.garant1 = garant1;
	}
	public boolean isGarant2() {
		return garant2;
	}
	public void setGarant2(boolean garant2) {
		this.garant2 = garant2;
	}
	@Override
	public String toString() {
		return "CarritoPedidosItems [item=" + item + ", cantidad=" + cantidad + ", partida=" + partida
				+ ", centroCosto=" + centroCosto + ", seguro=" + seguro + ", garant1=" + garant1 + ", garant2="
				+ garant2 + "]";
	}

}