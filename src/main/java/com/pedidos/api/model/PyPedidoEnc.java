package com.pedidos.api.model;


import java.util.List;

import org.springframework.context.annotation.Bean;
/**
 * Definicion de la clase de PyPedidoEnc
 */
public class PyPedidoEnc implements Cloneable {
    private String orgCode;
    private String divCode;
    private Long pedidoNum;
    private Long custNum;
    private Long clienteNum;
    private int dirNum;
    private String fecha;
    private Long idSuperpedido;
    private Long usuario;
    private String centroCosto;
    private String ordenCompra;
    private String observaciones;
    private String estatus;
    private String estEnvio;
    private double importe;
    private double iva;
    private String tipoEntrega;
    private Long evento;
    private String origen;
    private String remFact;
    private String shipVia;
    private int shipNum;
    private String pl;
    private String urgente;
    private boolean esEjecutivo;
	private double importeDist;
    private double ivaDist;
    private List<PyPedidoDet> listPyPedidoDet;
    private String tipo;
    private String cambioPrecio;
    private String pedidoDC;
    private String nombreUsuario;
    private String nombreCliente;
    private List<PyPedidoDet> listpedidoDetSoloCDMX;
    private String fechaSeg;
    private long customerPo;
    private long termCode;
    private String fechaFacturacion;
    private int numFactura;
    private long orderNum;
    
    private String ruta;
    private String horaRuta;
    private String orderStatus;
    private String horaCredito;
    
    private Zzzenvio zEnvio;
    private List<ZIntPagoL> zPagosL;
    private ZIntPagoH zPagoH;
    private String localForaneo;
   

	/**ATRIBUTOS EXTRAS**/
    private List<OrderL> listaBodegas;
    private String ligaFactura;
    private List<String> ligasFacturas;
    private List<String> locaCodes;
    private List<String> bodegas;
    private List<Integer> listaFacturas;
    private String locaCodeD;
    private long piezas;
    private long facturaDC;
    private String estatusEntrega;
    private String fechaCancelacion;
    private String producto;
    private int numProductos;
    private double sumaA;
    private double sumaC;
    private double sumaE;
    private double sumaivaA;
    private double sumaivaC;
    private double sumaivaE;
    private int sumapA;
    private int sumapC;
    private int sumapE;
    private String calle;
    private String address1;
    private String address2;
    private String colonia;
    private String city;
    private String province;
    private String country;
    private String postal_code;
    private String guia;
    private String paqueteria;
    private String numeroguia;
    private List<CondicionesEnvio> datosM;
    private List<String> vehiculo;
    private Long ordership;
    private String fecharegresiva;
    private String fechaEstimada;
    private String bodega;
    private String pedidoDCBodega;
    private String facturaPDF;
    private List<String> factura;
    
    public long getFacturaDC() {
		return facturaDC;
	}

	public void setFacturaDC(long facturaDC) {
		this.facturaDC = facturaDC;
	}


    private String rutaPdf;
    
    private int idBigDeal = 0;
	/**
	 * @return the bodega
	 */
    
    
    
	public String getBodega() {
		return bodega;
	}


	public String getRutaPdf() {
		return rutaPdf;
	}


	public void setRutaPdf(String rutaPdf) {
		this.rutaPdf = rutaPdf;
	}


	/**
	 * @param bodega the bodega to set
	 */
	public void setBodega(String bodega) {
		this.bodega = bodega;
	}


	/**
	 * @return the pedidoDCBodega
	 */
	public String getPedidoDCBodega() {
		return pedidoDCBodega;
	}


	/**
	 * @param pedidoDCBodega the pedidoDCBodega to set
	 */
	public void setPedidoDCBodega(String pedidoDCBodega) {
		this.pedidoDCBodega = pedidoDCBodega;
	}


	/**
	 * @return the facturaPDF
	 */
	public String getFacturaPDF() {
		return facturaPDF;
	}


	/**
	 * @param facturaPDF the facturaPDF to set
	 */
	public void setFacturaPDF(String facturaPDF) {
		this.facturaPDF = facturaPDF;
	}


	/**
	 * @return the factura
	 */
	public List<String> getFactura() {
		return factura;
	}


	/**
	 * @param factura the factura to set
	 */
	public void setFactura(List<String> factura) {
		this.factura = factura;
	}


	/**
	 * @return the fechaEstimada
	 */
	public String getFechaEstimada() {
		return fechaEstimada;
	}


	/**
	 * @param fechaEstimada the fechaEstimada to set
	 */
	public void setFechaEstimada(String fechaEstimada) {
		this.fechaEstimada = fechaEstimada;
	}


	/**
	 * @return the fecharegresiva
	 */
	public String getFecharegresiva() {
		return fecharegresiva;
	}


	/**
	 * @param fecharegresiva the fecharegresiva to set
	 */
	public void setFecharegresiva(String fecharegresiva) {
		this.fecharegresiva = fecharegresiva;
	}


	/**
	 * @return the ordership
	 */
	public Long getOrdership() {
		return ordership;
	}


	/**
	 * @param ordership the ordership to set
	 */
	public void setOrdership(Long ordership) {
		this.ordership = ordership;
	}


	/**
	 * @return the numeroguia
	 */
	public String getNumeroguia() {
		return numeroguia;
	}


	/**
	 * @param numeroguia the numeroguia to set
	 */
	public void setNumeroguia(String numeroguia) {
		this.numeroguia = numeroguia;
	}


	/**
	 * @return the datosM
	 */
	public List<CondicionesEnvio> getDatosM() {
		return datosM;
	}


	/**
	 * @param datosM the datosM to set
	 */
	public void setDatosM(List<CondicionesEnvio> datosM) {
		this.datosM = datosM;
	}


	/**
	 * @return the vehiculo
	 */
	public List<String> getVehiculo() {
		return vehiculo;
	}


	/**
	 * @param vehiculo the vehiculo to set
	 */
	public void setVehiculo(List<String> vehiculo) {
		this.vehiculo = vehiculo;
	}


	/**
	 * @return the paqueteria
	 */
	public String getPaqueteria() {
		return paqueteria;
	}


	/**
	 * @param paqueteria the paqueteria to set
	 */
	public void setPaqueteria(String paqueteria) {
		this.paqueteria = paqueteria;
	}


	/**
	 * @return the guia
	 */
	public String getGuia() {
		return guia;
	}


	/**
	 * @param guia the guia to set
	 */
	public void setGuia(String guia) {
		this.guia = guia;
	}


	/**
	 * @return the calle
	 */
	public String getCalle() {
		return calle;
	}


	/**
	 * @param calle the calle to set
	 */
	public void setCalle(String calle) {
		this.calle = calle;
	}


	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}


	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}


	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}


	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}


	/**
	 * @return the colonia
	 */
	public String getColonia() {
		return colonia;
	}


	/**
	 * @param colonia the colonia to set
	 */
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}


	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}


	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}


	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}


	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}


	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}


	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}


	/**
	 * @return the postal_code
	 */
	public String getPostal_code() {
		return postal_code;
	}


	/**
	 * @param postal_code the postal_code to set
	 */
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}


	/**
	 * @return the listaFacturas
	 */
	public List<Integer> getListaFacturas() {
		return listaFacturas;
	}


	/**
	 * @param listaFacturas the listaFacturas to set
	 */
	public void setListaFacturas(List<Integer> listaFacturas) {
		this.listaFacturas = listaFacturas;
	}


	/**
	 * @return the sumapA
	 */
	public int getSumapA() {
		return sumapA;
	}


	/**
	 * @param sumapA the sumapA to set
	 */
	public void setSumapA(int sumapA) {
		this.sumapA = sumapA;
	}


	/**
	 * @return the sumapC
	 */
	public int getSumapC() {
		return sumapC;
	}


	/**
	 * @param sumapC the sumapC to set
	 */
	public void setSumapC(int sumapC) {
		this.sumapC = sumapC;
	}


	/**
	 * @return the sumapE
	 */
	public int getSumapE() {
		return sumapE;
	}


	/**
	 * @param sumapE the sumapE to set
	 */
	public void setSumapE(int sumapE) {
		this.sumapE = sumapE;
	}


	/**
	 * @return the sumaivaA
	 */
	public double getSumaivaA() {
		return sumaivaA;
	}


	/**
	 * @param sumaivaA the sumaivaA to set
	 */
	public void setSumaivaA(double sumaivaA) {
		this.sumaivaA = sumaivaA;
	}


	/**
	 * @return the sumaivaC
	 */
	public double getSumaivaC() {
		return sumaivaC;
	}


	/**
	 * @param sumaivaC the sumaivaC to set
	 */
	public void setSumaivaC(double sumaivaC) {
		this.sumaivaC = sumaivaC;
	}


	/**
	 * @return the sumaivaE
	 */
	public double getSumaivaE() {
		return sumaivaE;
	}


	/**
	 * @param sumaivaE the sumaivaE to set
	 */
	public void setSumaivaE(double sumaivaE) {
		this.sumaivaE = sumaivaE;
	}


	/**
	 * @return the sumaA
	 */
	public Double getSumaA() {
		return sumaA;
	}


	/**
	 * @param sumaA the sumaA to set
	 */
	public void setSumaA(Double sumaA) {
		this.sumaA = sumaA;
	}


	/**
	 * @return the sumaC
	 */
	public Double getSumaC() {
		return sumaC;
	}


	/**
	 * @param sumaC the sumaC to set
	 */
	public void setSumaC(Double sumaC) {
		this.sumaC = sumaC;
	}


	/**
	 * @return the sumaE
	 */
	public Double getSumaE() {
		return sumaE;
	}


	/**
	 * @param sumaE the sumaE to set
	 */
	public void setSumaE(Double sumaE) {
		this.sumaE = sumaE;
	}


	/**
	 * @return the bodegas
	 */
	public List<String> getBodegas() {
		return bodegas;
	}


	/**
	 * @param bodegas the bodegas to set
	 */
	public void setBodegas(List<String> bodegas) {
		this.bodegas = bodegas;
	}


	/**
	 * @return the numproductos
	 */
	public int getNumproductos() {
		return numProductos;
	}


	/**
	 * @param numproductos the numproductos to set
	 */
	public void setNumproductos(int numProductos) {
		this.numProductos = numProductos;
	}


	/**
	 * @return the producto
	 */
	public String getProducto() {
		return producto;
	}


	/**
	 * @param producto the producto to set
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getEstatusEntrega() {
		return estatusEntrega;
	}


	public int getNumFactura() {
		return numFactura;
	}


	public void setNumFactura(int numFactura) {
		this.numFactura = numFactura;
	}


	public String getLocalForaneo() {
		return localForaneo;
	}

	public void setLocalForaneo(String localForaneo) {
		this.localForaneo = localForaneo;
	}
	public void setEstatusEntrega(String estatusEntrega) {
		this.estatusEntrega = estatusEntrega;
	}

	/**
	 * @return the esEjecutivo
	 */
	public boolean isEsEjecutivo() {
		return esEjecutivo;
	}

	/**
	 * @param esEjecutivo the esEjecutivo to set
	 */
	public void setEsEjecutivo(boolean esEjecutivo) {
		this.esEjecutivo = esEjecutivo;
	}

	public String getPl() {
		return pl;
	}

	public void setPl(String pl) {
		this.pl = pl;
	}

	public String getUrgente() {
		return urgente;
	}

	public void setUrgente(String urgente) {
		this.urgente = urgente;
	}
   
    /**
     * @param pedidoNum
     */
    public PyPedidoEnc(Long pedidoNum) {
        super();
        this.pedidoNum = pedidoNum;
    }
    
    /**
     * 
     */
    public PyPedidoEnc() {
        super();
    }
    
    
    
    
    
    public PyPedidoEnc(Long pedidoNum, String shipVia) {
		this.pedidoNum = pedidoNum;
		this.shipVia = shipVia;
	}


	/**
     * @return the listPyPedidoDet
     */
    public List<PyPedidoDet> getListPyPedidoDet() {
        return listPyPedidoDet;
    }
    /**
     * @param listPyPedidoDet the listPyPedidoDet to set
     */
    public void setListPyPedidoDet(List<PyPedidoDet> listPyPedidoDet) {
        this.listPyPedidoDet = listPyPedidoDet;
    }
    /** 
     * @return the orgCode
     */
    public String getOrgCode() {
        return orgCode;
    }
    /**
     * @param orgCode the orgCode to set
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }
    /**
     * @return the divCode
     */
    public String getDivCode() {
        return divCode;
    }
    /**
     * @param divCode the divCode to set
     */
    public void setDivCode(String divCode) {
        this.divCode = divCode;
    }
    /**
     * @return the pedidoNum
     */
    public Long getPedidoNum() {
        return pedidoNum;
    }
   
    /**
     * @param pedidoNum the pedidoNum to set
     */
    public void setPedidoNum(Long pedidoNum) {
        this.pedidoNum = pedidoNum;
    }
    /**
     * @return the custNum
     */
    public Long getCustNum() {
        return custNum;
    }
    /**
     * @param custNum the custNum to set
     */
    public void setCustNum(Long custNum) {
        this.custNum = custNum;
    }
    /**
     * @return the clienteNum
     */
    public Long getClienteNum() {
        return clienteNum;
    }
    /**
     * @param clienteNum the clienteNum to set
     */
    public void setClienteNum(Long clienteNum) {
        this.clienteNum = clienteNum;
    }
    /**
     * @return the dirNum
     */
    public int getDirNum() {
        return dirNum;
    }
    /**
     * @param dirNum the dirNum to set
     */
    public void setDirNum(int dirNum) {
        this.dirNum = dirNum;
    }
    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }
    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    /**
     * @return the idSuperpedido
     */
    public Long getIdSuperpedido() {
        return idSuperpedido;
    }
    /**
     * @param idSuperpedido the idSuperpedido to set
     */
    public void setIdSuperpedido(Long idSuperpedido) {
        this.idSuperpedido = idSuperpedido;
    }
    /**
     * @return the usuario
     */
    public Long getUsuario() {
        return usuario;
    }
    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }
    /**
     * @return the centroCosto
     */
    public String getCentroCosto() {
        return centroCosto;
    }
    /**
     * @param centroCosto the centroCosto to set
     */
    public void setCentroCosto(String centroCosto) {
        this.centroCosto = centroCosto;
    }
    /**
     * @return the ordenCompra
     */
    public String getOrdenCompra() {
        return ordenCompra;
    }
    /**
     * @param ordenCompra the ordenCompra to set
     */
    public void setOrdenCompra(String ordenCompra) {
        this.ordenCompra = ordenCompra;
    }
    /**
     * @return the observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }
    /**
     * @param observaciones the observaciones to set
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    /**
     * @return the estatus
     */
    public String getEstatus() {
        return estatus;
    }
    /**
     * @param estatus the estatus to set
     */
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    /**
     * @return the estEnvio
     */
    public String getEstEnvio() {
        return estEnvio;
    }
    /**
     * @param estEnvio the estEnvio to set
     */
    public void setEstEnvio(String estEnvio) {
        this.estEnvio = estEnvio;
    }
    /**
     * @return the importe
     */
    public double getImporte() {
        return importe;
    }
    /**
     * @param importe the importe to set
     */
    public void setImporte(double importe) {
        this.importe = importe;
    }
    /**
     * @return the iva
     */
    public double getIva() {
        return iva;
    }
    /**
     * @param iva the iva to set
     */
    public void setIva(double iva) {
        this.iva = iva;
    }
    /**
     * @return the tipoEntrega
     */
    public String getTipoEntrega() {
        return tipoEntrega;
    }
    /**
     * @param tipoEntrega the tipoEntrega to set
     */
    public void setTipoEntrega(String tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }
    /**
     * @return the evento
     */
    public Long getEvento() {
        return evento;
    }
    /**
     * @param evento the evento to set
     */
    public void setEvento(Long evento) {
        this.evento = evento;
    }
    /**
     * @return the origen
     */
    public String getOrigen() {
        return origen;
    }
    /**
     * @param origen the origen to set
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }
    /**
     * @return the remFact
     */
    public String getRemFact() {
        return remFact;
    }
    /**
     * @param remFact the remFact to set
     */
    public void setRemFact(String remFact) {
        this.remFact = remFact;
    }
    /**
     * @return the shipVia
     */
    public String getShipVia() {
        return shipVia;
    }
    /**
     * @param shipVia the shipVia to set
     */
    public void setShipVia(String shipVia) {
        this.shipVia = shipVia;
    }
    /**
     * @return the shipNum
     */
    public int getShipNum() {
        return shipNum;
    }
    /**
     * @param shipNum the shipNum to set
     */
    public void setShipNum(int shipNum) {
        this.shipNum = shipNum;
    }

	/**
	 * @return the importeDist
	 */
	public double getImporteDist() {
		return importeDist;
	}

	/**
	 * @param importeDist the importeDist to set
	 */
	public void setImporteDist(double importeDist) {
		this.importeDist = importeDist;
	}

	/**
	 * @return the ivaDist
	 */
	public double getIvaDist() {
		return ivaDist;
	}

	/**
	 * @param ivaDist the ivaDist to set
	 */
	public void setIvaDist(double ivaDist) {
		this.ivaDist = ivaDist;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCambioPrecio() {
		return cambioPrecio;
	}

	public void setCambioPrecio(String cambioPrecio) {
		this.cambioPrecio = cambioPrecio;
	}

	public String getPedidoDC() {
		return pedidoDC;
	}

	public void setPedidoDC(String pedidoDC) {
		this.pedidoDC = pedidoDC;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public List<PyPedidoDet> getListpedidoDetSoloCDMX() {
		return listpedidoDetSoloCDMX;
	}

	public void setListpedidoDetSoloCDMX(List<PyPedidoDet> listpedidoDetSoloCDMX) {
		this.listpedidoDetSoloCDMX = listpedidoDetSoloCDMX;
	}

	public String getFechaSeg() {
		return fechaSeg;
	}

	public void setFechaSeg(String fechaSeg) {
		this.fechaSeg = fechaSeg;
	}

	public long getCustomerPo() {
		return customerPo;
	}

	public void setCustomerPo(long customerPo) {
		this.customerPo = customerPo;
	}

	public List<OrderL> getListaBodegas() {
		return listaBodegas;
	}
	
	public long getTermCode() {
		return termCode;
	}

	public void setTermCode(long termCode) {
		this.termCode = termCode;
	}

	public String getFechaFacturacion() {
		return fechaFacturacion;
	}

	public void setFechaFacturacion(String fechaFacturacion) {
		this.fechaFacturacion = fechaFacturacion;
	}

	
	public void setListaBodegas(List<OrderL> listaBodegas) {
		this.listaBodegas = listaBodegas;
	}

	/**
	 * @return the zEnvio
	 */
	public Zzzenvio getzEnvio() {
		return zEnvio;
	}

	/**
	 * @param zEnvio the zEnvio to set
	 */
	public void setzEnvio(Zzzenvio zEnvio) {
		this.zEnvio = zEnvio;
	}

	/**
	 * @return the zPagosL
	 */
	public List<ZIntPagoL> getzPagosL() {
		return zPagosL;
	}

	/**
	 * @param zPagosL the zPagosL to set
	 */
	public void setzPagosL(List<ZIntPagoL> zPagosL) {
		this.zPagosL = zPagosL;
	}

	/**
	 * @return the zPagoH
	 */
	public ZIntPagoH getzPagoH() {
		return zPagoH;
	}

	/**
	 * @param zPagoH the zPagoH to set
	 */
	public void setzPagoH(ZIntPagoH zPagoH) {
		this.zPagoH = zPagoH;
	}

	/**
	 * @return the ruta
	 */
	public String getRuta() {
		return ruta;
	}

	/**
	 * @param ruta the ruta to set
	 */
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	/**
	 * @return the horaRuta
	 */
	public String getHoraRuta() {
		return horaRuta;
	}

	/**
	 * @param horaRuta the horaRuta to set
	 */
	public void setHoraRuta(String horaRuta) {
		this.horaRuta = horaRuta;
	}

	/**
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}

	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * @return the horaCredito
	 */
	public String getHoraCredito() {
		return horaCredito;
	}

	/**
	 * @param horaCredito the horaCredito to set
	 */
	public void setHoraCredito(String horaCredito) {
		this.horaCredito = horaCredito;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */

	/**
	 * @return the ligaFactura
	 */
	public String getLigaFactura() {
		return ligaFactura;
	}

	/**
	 * @param ligaFactura the ligaFactura to set
	 */
	public void setLigaFactura(String ligaFactura) {
		this.ligaFactura = ligaFactura;
	}

	/**
	 * @return the locaCodes
	 */
	public List<String> getLocaCodes() {
		return locaCodes;
	}

	/**
	 * @param locaCodes the locaCodes to set
	 */
	public void setLocaCodes(List<String> locaCodes) {
		this.locaCodes = locaCodes;
	}

	/**
	 * @return the locaCodeD
	 */
	public String getLocaCodeD() {
		return locaCodeD;
	}

	/**
	 * @param locaCodeD the locaCodeD to set
	 */
	public void setLocaCodeD(String locaCodeD) {
		this.locaCodeD = locaCodeD;
	}

	/**
	 * @return the ligasFacturas
	 */
	public List<String> getLigasFacturas() {
		return ligasFacturas;
	}

	/**
	 * @param ligasFacturas the ligasFacturas to set
	 */
	public void setLigasFacturas(List<String> ligasFacturas) {
		this.ligasFacturas = ligasFacturas;
	}
	
	 

	/**
	 * @return the piezas
	 */
	public long getPiezas() {
		return piezas;
	}

	/**
	 * @param piezas the piezas to set
	 */
	public void setPiezas(long piezas) {
		this.piezas = piezas;
	}

	public long getOrderNum() {
		return orderNum;
	}


	public void setOrderNum(long orderNum) {
		this.orderNum = orderNum;
	}


	/**
	 * @return the fechaCancelacion
	 */
	public String getFechaCancelacion() {
		return fechaCancelacion;
	}


	/**
	 * @param fechaCancelacion the fechaCancelacion to set
	 */
	public void setFechaCancelacion(String fechaCancelacion) {
		this.fechaCancelacion = fechaCancelacion;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	


	public int getIdBigDeal() {
		return idBigDeal;
	}


	public void setIdBigDeal(int idBigDeal) {
		this.idBigDeal = idBigDeal;
	}


	@Override
	public String toString() {
		return "PyPedidoEnc [orgCode=" + orgCode + ", divCode=" + divCode
				+ ", pedidoNum=" + pedidoNum + ", custNum=" + custNum
				+ ", clienteNum=" + clienteNum + ", dirNum=" + dirNum
				+ ", fecha=" + fecha + ", idSuperpedido=" + idSuperpedido
				+ ", usuario=" + usuario + ", centroCosto=" + centroCosto
				+ ", ordenCompra=" + ordenCompra + ", observaciones="
				+ observaciones + ", estatus=" + estatus + ", estEnvio="
				+ estEnvio + ", importe=" + importe + ", iva=" + iva
				+ ", tipoEntrega=" + tipoEntrega + ", evento=" + evento
				+ ", origen=" + origen + ", remFact=" + remFact + ", shipVia="
				+ shipVia + ", shipNum=" + shipNum + ", pl=" + pl
				+ ", urgente=" + urgente + ", esEjecutivo=" + esEjecutivo
				+ ", importeDist=" + importeDist + ", ivaDist=" + ivaDist
				+ ", listPyPedidoDet=" + listPyPedidoDet + ", tipo=" + tipo
				+ ", cambioPrecio=" + cambioPrecio + ", pedidoDC=" + pedidoDC
				+ ", nombreUsuario=" + nombreUsuario + ", nombreCliente="
				+ nombreCliente + ", listpedidoDetSoloCDMX="
				+ listpedidoDetSoloCDMX + ", fechaSeg=" + fechaSeg
				+ ", customerPo=" + customerPo + ", termCode=" + termCode
				+ ", fechaFacturacion=" + fechaFacturacion + ", numFactura="
				+ numFactura + ", orderNum=" + orderNum + ", ruta=" + ruta
				+ ", horaRuta=" + horaRuta + ", orderStatus=" + orderStatus
				+ ", horaCredito=" + horaCredito + ", zEnvio=" + zEnvio
				+ ", zPagosL=" + zPagosL + ", zPagoH=" + zPagoH
				+ ", localForaneo=" + localForaneo + ", listaBodegas="
				+ listaBodegas + ", ligaFactura=" + ligaFactura
				+ ", ligasFacturas=" + ligasFacturas + ", locaCodes="
				+ locaCodes + ", bodegas=" + bodegas + ", listaFacturas="
				+ listaFacturas + ", locaCodeD=" + locaCodeD
				+ ", estatusEntrega=" + estatusEntrega + ", fechaCancelacion="
				+ fechaCancelacion + ", producto=" + producto
				+ ", numProductos=" + numProductos + ", sumaA=" + sumaA
				+ ", sumaC=" + sumaC + ", sumaE=" + sumaE + ", sumaivaA="
				+ sumaivaA + ", sumaivaC=" + sumaivaC + ", sumaivaE="
				+ sumaivaE + ", sumapA=" + sumapA + ", sumapC=" + sumapC
				+ ", sumapE=" + sumapE + ", calle=" + calle + ", address1="
				+ address1 + ", address2=" + address2 + ", colonia=" + colonia
				+ ", city=" + city + ", province=" + province + ", country="
				+ country + ", postal_code=" + postal_code + ", guia=" + guia
				+ ", paqueteria=" + paqueteria + ", numeroguia=" + numeroguia
				+ ", datosM=" + datosM + ", vehiculo=" + vehiculo
				+ ", ordership=" + ordership + ", fecharegresiva="
				+ fecharegresiva + ", fechaEstimada=" + fechaEstimada
				+ ", bodega=" + bodega + ", pedidoDCBodega=" + pedidoDCBodega
				+ ", facturaPDF=" + facturaPDF + ", factura=" + factura
				+ ", rutaPdf=" + rutaPdf + "]";
	}

	/*Genera un clon del objeto de pyPedidoEnc enviado, favor de mantener actualizado si se agregan mas campos para asegurar una copia optima*/

	public PyPedidoEnc(PyPedidoEnc pyPedidoEnc) {
		super();
		this.orgCode = pyPedidoEnc.getOrgCode();
		this.divCode = pyPedidoEnc.getDivCode();
		this.pedidoNum = pyPedidoEnc.getPedidoNum();
		this.custNum = pyPedidoEnc.getCustNum();
		this.clienteNum = pyPedidoEnc.getClienteNum();
		this.dirNum = pyPedidoEnc.getDirNum();
		this.fecha = pyPedidoEnc.getFecha();
		this.idSuperpedido = pyPedidoEnc.getIdSuperpedido();
		this.usuario = pyPedidoEnc.getUsuario();
		this.centroCosto = pyPedidoEnc.getCentroCosto();
		this.ordenCompra = pyPedidoEnc.getOrdenCompra();
		this.observaciones = pyPedidoEnc.getObservaciones();
		this.estatus = pyPedidoEnc.getEstatus();
		this.estEnvio = pyPedidoEnc.getEstEnvio();
		this.importe = pyPedidoEnc.getImporte();
		this.iva = pyPedidoEnc.getIva();
		this.tipoEntrega = pyPedidoEnc.getTipoEntrega();
		this.evento = pyPedidoEnc.getEvento();
		this.origen = pyPedidoEnc.getOrigen();
		this.remFact = pyPedidoEnc.getRemFact();
		this.shipVia = pyPedidoEnc.getShipVia();
		this.shipNum = pyPedidoEnc.getShipNum();
		this.pl = pyPedidoEnc.getPl();
		this.urgente = pyPedidoEnc.getUrgente();
		this.esEjecutivo = pyPedidoEnc.isEsEjecutivo();
		this.importeDist = pyPedidoEnc.getImporteDist();
		this.ivaDist = pyPedidoEnc.getIvaDist();
		this.listPyPedidoDet = pyPedidoEnc.getListPyPedidoDet();
		this.tipo = pyPedidoEnc.getTipo();
		this.cambioPrecio = pyPedidoEnc.getCambioPrecio();
		this.pedidoDC = pyPedidoEnc.getPedidoDC();
		this.nombreUsuario = pyPedidoEnc.getNombreUsuario();
		this.nombreCliente = pyPedidoEnc.getNombreCliente();
		this.listpedidoDetSoloCDMX = pyPedidoEnc.getListpedidoDetSoloCDMX();
		this.fechaSeg = pyPedidoEnc.getFechaSeg();
		this.customerPo = pyPedidoEnc.getCustomerPo();
		this.termCode = pyPedidoEnc.getTermCode();
		this.fechaFacturacion = pyPedidoEnc.getFechaFacturacion();
		this.numFactura = pyPedidoEnc.getNumFactura();
		this.orderNum = pyPedidoEnc.getOrderNum();
		this.ruta = pyPedidoEnc.getRuta();
		this.horaRuta = pyPedidoEnc.getHoraRuta();
		this.orderStatus = pyPedidoEnc.getOrderStatus();
		this.horaCredito = pyPedidoEnc.getHoraCredito();
		this.zEnvio = pyPedidoEnc.getzEnvio();
		this.zPagosL = pyPedidoEnc.getzPagosL();
		this.zPagoH = pyPedidoEnc.getzPagoH();
		this.localForaneo = pyPedidoEnc.getLocalForaneo();
		this.listaBodegas = pyPedidoEnc.getListaBodegas();
		this.ligaFactura = pyPedidoEnc.getLigaFactura();
		this.ligasFacturas = pyPedidoEnc.getLigasFacturas();
		this.locaCodes = pyPedidoEnc.getLocaCodes();
		this.bodegas = pyPedidoEnc.getBodegas();
		this.listaFacturas = pyPedidoEnc.getListaFacturas();
		this.locaCodeD = pyPedidoEnc.getLocaCodeD();
		this.estatusEntrega = pyPedidoEnc.getEstatusEntrega();
		this.fechaCancelacion = pyPedidoEnc.getFechaCancelacion();
		this.producto = pyPedidoEnc.getProducto();
		this.numProductos = pyPedidoEnc.getNumproductos();
		this.sumaA = pyPedidoEnc.getSumaA();
		this.sumaC = pyPedidoEnc.getSumaC();
		this.sumaE = pyPedidoEnc.getSumaE();
		this.sumaivaA = pyPedidoEnc.getSumaivaA();
		this.sumaivaC = pyPedidoEnc.getSumaivaC();
		this.sumaivaE = pyPedidoEnc.getSumaivaE();
		this.sumapA = pyPedidoEnc.getSumapA();
		this.sumapC = pyPedidoEnc.getSumapC();
		this.sumapE = pyPedidoEnc.getSumapE();
		this.calle = pyPedidoEnc.getCalle();
		this.address1 = pyPedidoEnc.getAddress1();
		this.address2 = pyPedidoEnc.getAddress2();
		this.colonia = pyPedidoEnc.getColonia();
		this.city = pyPedidoEnc.getCity();
		this.province = pyPedidoEnc.getProvince();
		this.country = pyPedidoEnc.getCountry();
		this.postal_code = pyPedidoEnc.getPostal_code();
		this.guia = pyPedidoEnc.getGuia();
		this.paqueteria = pyPedidoEnc.getPaqueteria();
		this.numeroguia = pyPedidoEnc.getNumeroguia();
		this.datosM = pyPedidoEnc.getDatosM();
		this.vehiculo = pyPedidoEnc.getVehiculo();
		this.ordership = pyPedidoEnc.getOrdership();
		this.fecharegresiva = pyPedidoEnc.getFecharegresiva();
		this.fechaEstimada = pyPedidoEnc.getFechaEstimada();
		this.bodega = pyPedidoEnc.getBodega();
		this.pedidoDCBodega = pyPedidoEnc.getPedidoDCBodega();
		this.facturaPDF = pyPedidoEnc.getFacturaPDF();
		this.factura = pyPedidoEnc.getFactura();
		this.rutaPdf = pyPedidoEnc.getRutaPdf();
		this.idBigDeal = pyPedidoEnc.getIdBigDeal();
	}

	
}
