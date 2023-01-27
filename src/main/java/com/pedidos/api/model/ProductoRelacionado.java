package com.pedidos.api.model;

public class ProductoRelacionado {
	private String item_num;
	private String descripcion;
	private double precio;
	private double precioAnterior;
	private String url;

	public ProductoRelacionado() {
	}

	public ProductoRelacionado(String item_num, String descripcion, double precio, double precioAnterior, String utl) {
		this.item_num = item_num;
		this.descripcion = descripcion;
		this.precio = precio;
		this.precioAnterior = precioAnterior;
		this.url = utl;
	}

	public String getItem_num() {
		return item_num;
	}

	public void setItem_num(String item_num) {
		this.item_num = item_num;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getPrecioAnterior() {
		return precioAnterior;
	}

	public void setPrecioAnterior(double precioAnterior) {
		this.precioAnterior = precioAnterior;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String utl) {
		this.url = utl;
	}

	@Override
	public String toString() {
		return "ProductoRelacionado [item_num=" + item_num + ", descripcion=" + descripcion + ", precio=" + precio + ", precioAnterior=" + precioAnterior + ", url=" + url + "]";
	}
}
