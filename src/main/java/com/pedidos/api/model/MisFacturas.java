package com.pedidos.api.model;

public class MisFacturas {
	private long invoiceNum;
	private String invoice;
	private long pedidoNum;
	private String fechaFactura;
	private String horaFactura;
	private String pdf;
	private boolean tienePdf;
	private String xml;
	private boolean tieneXml;
	private String orderStatus;
	 
	@Override
	public String toString() {
		return "MisFacturas [invoiceNum=" + invoiceNum + ", invoice=" + invoice + ", pedidoNum=" + pedidoNum + ", fechaFactura=" + fechaFactura + ", horaFactura=" + horaFactura + ", pdf=" + pdf + ", tienePdf=" + tienePdf + ", xml=" + xml + ", tieneXml=" + tieneXml + ", orderStatus=" + orderStatus + "]";
	}

	public long getInvoiceNum() {
		return invoiceNum;
	}
	
	public void setInvoiceNum(long invoiceNum) {
		this.invoiceNum = invoiceNum;
	}
	
	public String getInvoice() {
		return invoice;
	}
	
	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	
	public long getPedidoNum() {
		return pedidoNum;
	}
	
	public void setPedidoNum(long pedidoNum) {
		this.pedidoNum = pedidoNum;
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
	
	public String getOrderStatus() {
		return orderStatus;
	}
	
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
}
