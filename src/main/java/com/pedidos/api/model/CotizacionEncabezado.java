package com.pedidos.api.model;

public class CotizacionEncabezado {
	
	private double envio;
	private String paqueteria;
	private double subtotal;
	private double importe;
	private double ivaT;
	private double cupon;
	private double total;
	private int cotizacion;
	
	public CotizacionEncabezado() {
	}

	public CotizacionEncabezado(double envio, String paqueteria, double subtotal, double importe, double ivaT, double total,
			double cupon,int cotizacion) {
		this.envio = envio;
		this.paqueteria = paqueteria;
		this.subtotal = subtotal;
		this.importe = importe;
		this.ivaT = ivaT;
		this.cupon = cupon;
		this.total = total;
		this.cotizacion = cotizacion;
	}
	
	

	public String getPaqueteria() {
		return paqueteria;
	}

	public void setPaqueteria(String paqueteria) {
		this.paqueteria = paqueteria;
	}

	public double getCupon() {
		return cupon;
	}

	public void setCupon(double cupon) {
		this.cupon = cupon;
	}

	public double getEnvio() {
		return envio;
	}

	public void setEnvio(double envio) {
		this.envio = envio;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public double getIvaT() {
		return ivaT;
	}

	public void setIvaT(double ivaT) {
		this.ivaT = ivaT;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(int cotizacion) {
		this.cotizacion = cotizacion;
	}

	@Override
	public String toString() {
		return "CotizacionEncabezado [envio=" + envio + ", paqueteria=" + paqueteria + ", subtotal=" + subtotal
				+ ", importe=" + importe + ", ivaT=" + ivaT + ", cupon=" + cupon + ", total=" + total + ", cotizacion="
				+ cotizacion + "]";
	}

}
