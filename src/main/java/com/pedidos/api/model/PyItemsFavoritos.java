package com.pedidos.api.model;


public class PyItemsFavoritos {
	
	
	private String itemNum;
	private String numParte;
	private String tituloCompuesto;
	private String url;
	private String marca;
	private String lineaNeg;
	private String codFamilia;
	private String codSubfamilia;
	private Double volume;
	private Double netWeigth;
	private Double precio;
	private Double precioDeLista;
	private Double iva;
	private int disponibilidad;
	private String proveedorExterno;
	private String soloDf;
	private int ponderacion;
	private int estrella;
	private String aplicaExpress;
	private String estatus;
	private int clienteNum;
	private int cantidad;
	private String tipo;
	private int frecuencia;
	private double descuento = 0;
	private String envioGratis = "N";
	private String regalo = "I";
	private int diasRestantes = 0;
	private int diasPromedio = 0;
	
	public PyItemsFavoritos() {
		super();
	}

	public PyItemsFavoritos(String itemNum, String numParte, String tituloCompuesto, String url, String marca,
			String lineaNeg, String codFamilia, String codSubfamilia, Double volume, Double netWeigth, Double precio,
			Double precioDeLista, Double iva, int disponibilidad, String proveedorExterno, String soloDf,
			int ponderacion, int estrella, String aplicaExpress, String estatus, int clienteNum, int cantidad,
			String tipo, int frecuencia, double descuento, String envioGratis, String regalo, int diasRestantes,
			int diasPromedio) {
		super();
		this.itemNum = itemNum;
		this.numParte = numParte;
		this.tituloCompuesto = tituloCompuesto;
		this.url = url;
		this.marca = marca;
		this.lineaNeg = lineaNeg;
		this.codFamilia = codFamilia;
		this.codSubfamilia = codSubfamilia;
		this.volume = volume;
		this.netWeigth = netWeigth;
		this.precio = precio;
		this.precioDeLista = precioDeLista;
		this.iva = iva;
		this.disponibilidad = disponibilidad;
		this.proveedorExterno = proveedorExterno;
		this.soloDf = soloDf;
		this.ponderacion = ponderacion;
		this.estrella = estrella;
		this.aplicaExpress = aplicaExpress;
		this.estatus = estatus;
		this.clienteNum = clienteNum;
		this.cantidad = cantidad;
		this.tipo = tipo;
		this.frecuencia = frecuencia;
		this.descuento = descuento;
		this.envioGratis = envioGratis;
		this.regalo = regalo;
		this.diasRestantes = diasRestantes;
		this.diasPromedio = diasPromedio;
	}

	public String getItemNum() {
		return itemNum;
	}

	public void setItemNum(String itemNum) {
		this.itemNum = itemNum;
	}

	public String getNumParte() {
		return numParte;
	}

	public void setNumParte(String numParte) {
		this.numParte = numParte;
	}

	public String getTituloCompuesto() {
		return tituloCompuesto;
	}

	public void setTituloCompuesto(String tituloCompuesto) {
		this.tituloCompuesto = tituloCompuesto;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getLineaNeg() {
		return lineaNeg;
	}

	public void setLineaNeg(String lineaNeg) {
		this.lineaNeg = lineaNeg;
	}

	public String getCodFamilia() {
		return codFamilia;
	}

	public void setCodFamilia(String codFamilia) {
		this.codFamilia = codFamilia;
	}

	public String getCodSubfamilia() {
		return codSubfamilia;
	}

	public void setCodSubfamilia(String codSubfamilia) {
		this.codSubfamilia = codSubfamilia;
	}

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public Double getNetWeigth() {
		return netWeigth;
	}

	public void setNetWeigth(Double netWeigth) {
		this.netWeigth = netWeigth;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Double getPrecioDeLista() {
		return precioDeLista;
	}

	public void setPrecioDeLista(Double precioDeLista) {
		this.precioDeLista = precioDeLista;
	}

	public Double getIva() {
		return iva;
	}

	public void setIva(Double iva) {
		this.iva = iva;
	}

	public int getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(int disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public String getProveedorExterno() {
		return proveedorExterno;
	}

	public void setProveedorExterno(String proveedorExterno) {
		this.proveedorExterno = proveedorExterno;
	}

	public String getSoloDf() {
		return soloDf;
	}

	public void setSoloDf(String soloDf) {
		this.soloDf = soloDf;
	}

	public int getPonderacion() {
		return ponderacion;
	}

	public void setPonderacion(int ponderacion) {
		this.ponderacion = ponderacion;
	}

	public int getEstrella() {
		return estrella;
	}

	public void setEstrella(int estrella) {
		this.estrella = estrella;
	}

	public String getAplicaExpress() {
		return aplicaExpress;
	}

	public void setAplicaExpress(String aplicaExpress) {
		this.aplicaExpress = aplicaExpress;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public int getClienteNum() {
		return clienteNum;
	}

	public void setClienteNum(int clienteNum) {
		this.clienteNum = clienteNum;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(int frecuencia) {
		this.frecuencia = frecuencia;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public String getEnvioGratis() {
		return envioGratis;
	}

	public void setEnvioGratis(String envioGratis) {
		this.envioGratis = envioGratis;
	}

	public String getRegalo() {
		return regalo;
	}

	public void setRegalo(String regalo) {
		this.regalo = regalo;
	}

	public int getDiasRestantes() {
		return diasRestantes;
	}

	public void setDiasRestantes(int diasRestantes) {
		this.diasRestantes = diasRestantes;
	}

	public int getDiasPromedio() {
		return diasPromedio;
	}

	public void setDiasPromedio(int diasPromedio) {
		this.diasPromedio = diasPromedio;
	}

	@Override
	public String toString() {
		return "PyItemsFavoritos [itemNum=" + itemNum + ", numParte=" + numParte + ", tituloCompuesto="
				+ tituloCompuesto + ", url=" + url + ", marca=" + marca + ", lineaNeg=" + lineaNeg + ", codFamilia="
				+ codFamilia + ", codSubfamilia=" + codSubfamilia + ", volume=" + volume + ", netWeigth=" + netWeigth
				+ ", precio=" + precio + ", precioDeLista=" + precioDeLista + ", iva=" + iva + ", disponibilidad="
				+ disponibilidad + ", proveedorExterno=" + proveedorExterno + ", soloDf=" + soloDf + ", ponderacion="
				+ ponderacion + ", estrella=" + estrella + ", aplicaExpress=" + aplicaExpress + ", estatus=" + estatus
				+ ", clienteNum=" + clienteNum + ", cantidad=" + cantidad + ", tipo=" + tipo + ", frecuencia="
				+ frecuencia + ", descuento=" + descuento + ", envioGratis=" + envioGratis + ", regalo=" + regalo
				+ ", diasRestantes=" + diasRestantes + ", diasPromedio=" + diasPromedio + "]";
	}
}