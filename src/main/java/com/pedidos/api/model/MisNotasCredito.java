package com.pedidos.api.model;

public class MisNotasCredito {
private long invoiceNum;
	
	private String fechaFactura;
	private String horaFactura;
	private String invoice;
	private String pdf;
	private boolean tienePdf;
	private String xml;
	private boolean tieneXml;
	private double monto;
	private String estatus;
	private String rfc;
	private boolean aplicada;
	private int pedidoNc;
	private String aplica;
	
	public int getPedidoNc() {
		return pedidoNc;
	}
	public void setPedidoNc(int pedidoNc) {
		this.pedidoNc = pedidoNc;
	}
	public long getInvoiceNum() {
		return invoiceNum;
	}
	public void setInvoiceNum(long invoiceNum) {
		this.invoiceNum = invoiceNum;
	}
	public String getFechaFactura() {
		return fechaFactura;
	}
	public void setFechaFactura(String fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	public String getHoraFactura() {
		return horaFactura;
	}
	public void setHoraFactura(String horaFactura) {
		this.horaFactura = horaFactura;
	}
	public String getInvoice() {
		return invoice;
	}
	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	public String getPdf() {
		return pdf;
	}
	public void setPdf(String pdf) {
		this.pdf = pdf;
	}
	public boolean isTienePdf() {
		return tienePdf;
	}
	public void setTienePdf(boolean tienePdf) {
		this.tienePdf = tienePdf;
	}
	public String getXml() {
		return xml;
	}
	public void setXml(String xml) {
		this.xml = xml;
	}
	public boolean isTieneXml() {
		return tieneXml;
	}
	public void setTieneXml(boolean tieneXml) {
		this.tieneXml = tieneXml;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public boolean getAplicada() {
		return aplicada;
	}
	public void setAplicada(boolean aplicada) {
		this.aplicada = aplicada;
	}
	public String getAplica() {
		return aplica;
	}
	public void setAplica(String aplica) {
		this.aplica = aplica;
	}
	@Override
	public String toString() {
		return "MisNotasCredito [invoiceNum=" + invoiceNum + ", fechaFactura=" + fechaFactura + ", horaFactura="
				+ horaFactura + ", invoice=" + invoice + ", pdf=" + pdf + ", tienePdf=" + tienePdf + ", xml=" + xml
				+ ", tieneXml=" + tieneXml + ", monto=" + monto + ", estatus=" + estatus + ", rfc=" + rfc
				+ ", aplicada=" + aplicada + ", pedidoNc=" + pedidoNc + ", aplica=" + aplica + "]";
	}
}
