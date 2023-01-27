package com.pedidos.api.model;

public class CotizacionItems {
	
	private String item;
	private int cantidad;
	private String imagen;
	private String descripcion;
	private String precio;
	private String subtotal;
	private String importesiva;
	private String iva;
	
	public CotizacionItems() {
	}

	public CotizacionItems(String item, int cantidad, String imagen, String descripcion, String precio, String subtotal,
			String importesiva, String iva) {
		this.item = item;
		this.cantidad = cantidad;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.precio = precio;
		this.subtotal = subtotal;
		this.importesiva = importesiva;
		this.iva = iva;
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getImportesiva() {
		return importesiva;
	}

	public void setImportesiva(String importesiva) {
		this.importesiva = importesiva;
	}

	public String getIva() {
		return iva;
	}

	public void setIva(String iva) {
		this.iva = iva;
	}

	public String getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}

	@Override
	public String toString() {
		return "CotizacionItems [item=" + item + ", cantidad=" + cantidad + ", imagen=" + imagen + ", descripcion="
				+ descripcion + ", precio=" + precio + ", subtotal=" + subtotal + ", importesiva=" + importesiva
				+ ", iva=" + iva + "]";
	}
}
