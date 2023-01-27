package com.pedidos.api.model;


public class Entregas {
	private long custNum;
	private long clienteNum;
	private long pedidoNum;
	private long orderNum;
	private String tipoEntrega;
	private int envio;
	private double totalDist;
	private double totalCliente;
	private String fechaEntrega;
	private String evidencia;
	private int shipVia;
	private int invoiceNum;
	private String estatus;
	private String paqueteria;
	private String fechaFacturacion;
	private String fechaRegistro;
	private int idSuperpedido;
	private String guia;
	private String nombreCliente;
	private int numPaqueteria;
	private String direccion;
	private int shipNum;
	private int dirNum;
	private String ligaFactura;
	private String evaluacion;
	private String factura;
	private String bodega;
	private String pedidoDCBodega;
	private int folio;
	private int caja;
	String numeroEnvio;
	public long getCustNum() {
		return custNum;
	}
	public void setCustNum(long custNum) {
		this.custNum = custNum;
	}
	public long getClienteNum() {
		return clienteNum;
	}
	public void setClienteNum(long clienteNum) {
		this.clienteNum = clienteNum;
	}
	public long getPedidoNum() {
		return pedidoNum;
	}
	public void setPedidoNum(long pedidoNum) {
		this.pedidoNum = pedidoNum;
	}
	public long getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(long orderNum) {
		this.orderNum = orderNum;
	}
	public String getTipoEntrega() {
		return tipoEntrega;
	}
	public void setTipoEntrega(String tipoEntrega) {
		this.tipoEntrega = tipoEntrega;
	}
	public int getEnvio() {
		return envio;
	}
	public void setEnvio(int envio) {
		this.envio = envio;
	}
	public double getTotalDist() {
		return totalDist;
	}
	public void setTotalDist(double totalDist) {
		this.totalDist = totalDist;
	}
	public double getTotalCliente() {
		return totalCliente;
	}
	public void setTotalCliente(double totalCliente) {
		this.totalCliente = totalCliente;
	}
	public String getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public String getEvidencia() {
		return evidencia;
	}
	public void setEvidencia(String evidencia) {
		this.evidencia = evidencia;
	}
	public int getShipVia() {
		return shipVia;
	}
	public void setShipVia(int shipVia) {
		this.shipVia = shipVia;
	}
	public int getInvoiceNum() {
		return invoiceNum;
	}
	public void setInvoiceNum(int invoiceNum) {
		this.invoiceNum = invoiceNum;
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
	public String getFechaFacturacion() {
		return fechaFacturacion;
	}
	public void setFechaFacturacion(String fechaFacturacion) {
		this.fechaFacturacion = fechaFacturacion;
	}
	public String getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public int getIdSuperpedido() {
		return idSuperpedido;
	}
	public void setIdSuperpedido(int idSuperpedido) {
		this.idSuperpedido = idSuperpedido;
	}
	public String getGuia() {
		return guia;
	}
	public void setGuia(String guia) {
		this.guia = guia;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public int getNumPaqueteria() {
		return numPaqueteria;
	}
	public void setNumPaqueteria(int numPaqueteria) {
		this.numPaqueteria = numPaqueteria;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getShipNum() {
		return shipNum;
	}
	public void setShipNum(int shipNum) {
		this.shipNum = shipNum;
	}
	public int getDirNum() {
		return dirNum;
	}
	public void setDirNum(int dirNum) {
		this.dirNum = dirNum;
	}
	public String getLigaFactura() {
		return ligaFactura;
	}
	public void setLigaFactura(String ligaFactura) {
		this.ligaFactura = ligaFactura;
	}
	public String getEvaluacion() {
		return evaluacion;
	}
	public void setEvaluacion(String evaluacion) {
		this.evaluacion = evaluacion;
	}
	public String getFactura() {
		return factura;
	}
	public void setFactura(String factura) {
		this.factura = factura;
	}
	public String getBodega() {
		return bodega;
	}
	public void setBodega(String bodega) {
		this.bodega = bodega;
	}
	public String getPedidoDCBodega() {
		return pedidoDCBodega;
	}
	public void setPedidoDCBodega(String pedidoDCBodega) {
		this.pedidoDCBodega = pedidoDCBodega;
	}
	public int getFolio() {
		return folio;
	}
	public void setFolio(int folio) {
		this.folio = folio;
	}
	public int getCaja() {
		return caja;
	}
	public void setCaja(int caja) {
		this.caja = caja;
	}
	public String getNumeroEnvio() {
		return numeroEnvio;
	}
	public void setNumeroEnvio(String numeroEnvio) {
		this.numeroEnvio = numeroEnvio;
	}
	@Override
	public String toString() {
		return "Entregas [custNum=" + custNum + ", clienteNum=" + clienteNum + ", pedidoNum=" + pedidoNum
				+ ", orderNum=" + orderNum + ", tipoEntrega=" + tipoEntrega + ", envio=" + envio + ", totalDist="
				+ totalDist + ", totalCliente=" + totalCliente + ", fechaEntrega=" + fechaEntrega + ", evidencia="
				+ evidencia + ", shipVia=" + shipVia + ", invoiceNum=" + invoiceNum + ", estatus=" + estatus
				+ ", paqueteria=" + paqueteria + ", fechaFacturacion=" + fechaFacturacion + ", fechaRegistro="
				+ fechaRegistro + ", idSuperpedido=" + idSuperpedido + ", guia=" + guia + ", nombreCliente="
				+ nombreCliente + ", numPaqueteria=" + numPaqueteria + ", direccion=" + direccion + ", shipNum="
				+ shipNum + ", dirNum=" + dirNum + ", ligaFactura=" + ligaFactura + ", evaluacion=" + evaluacion
				+ ", factura=" + factura + ", bodega=" + bodega + ", pedidoDCBodega=" + pedidoDCBodega + ", folio="
				+ folio + ", caja=" + caja + ", numeroEnvio=" + numeroEnvio + "]";
	}
	public Entregas(long custNum, long clienteNum, long pedidoNum, long orderNum, String tipoEntrega, int envio,
			double totalDist, double totalCliente, String fechaEntrega, String evidencia, int shipVia, int invoiceNum,
			String estatus, String paqueteria, String fechaFacturacion, String fechaRegistro, int idSuperpedido,
			String guia, String nombreCliente, int numPaqueteria, String direccion, int shipNum, int dirNum,
			String ligaFactura, String evaluacion, String factura, String bodega, String pedidoDCBodega, int folio,
			int caja, String numeroEnvio) {
		super();
		this.custNum = custNum;
		this.clienteNum = clienteNum;
		this.pedidoNum = pedidoNum;
		this.orderNum = orderNum;
		this.tipoEntrega = tipoEntrega;
		this.envio = envio;
		this.totalDist = totalDist;
		this.totalCliente = totalCliente;
		this.fechaEntrega = fechaEntrega;
		this.evidencia = evidencia;
		this.shipVia = shipVia;
		this.invoiceNum = invoiceNum;
		this.estatus = estatus;
		this.paqueteria = paqueteria;
		this.fechaFacturacion = fechaFacturacion;
		this.fechaRegistro = fechaRegistro;
		this.idSuperpedido = idSuperpedido;
		this.guia = guia;
		this.nombreCliente = nombreCliente;
		this.numPaqueteria = numPaqueteria;
		this.direccion = direccion;
		this.shipNum = shipNum;
		this.dirNum = dirNum;
		this.ligaFactura = ligaFactura;
		this.evaluacion = evaluacion;
		this.factura = factura;
		this.bodega = bodega;
		this.pedidoDCBodega = pedidoDCBodega;
		this.folio = folio;
		this.caja = caja;
		this.numeroEnvio = numeroEnvio;
	}
	public Entregas() {
		super();
		// TODO Auto-generated constructor stub
	}


}