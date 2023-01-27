package com.pedidos.api.model;

import org.apache.log4j.Logger;

import com.pedidos.api.comun.Cadena;

public class PyPedidoDet {
	private static final Logger LOG = Logger.getLogger(PyPedidoDet.class);
    private String orgCode;
    private String divCode;
    private Long pedidoNum;
    private double renglonNum;
    private String itemNum;
    private String claveClien;
    private int cantidad;
    private String currCode;
    private double precio;
    private String centroCosto;
    private String estatus;
    private double tipoCambio;
    private String descCartucho;
    private double iva;
    private int ensid;
    private double precioListDist;
	private double precioList;
    private double precioDist;
    private double precioAlDist;
	private double ivaDist;
	
	private int cantidadexist;
	
	@SuppressWarnings("unused")
	private double ivaAlDist;
    private double margen;
    private double descuento;
    private double descDist;

	private String locationItem;
    private Item   item;
    private String imagen;
    private String linea;
    private String familia;
    private String marca;
	private double costoStandard;
    private double ultimoCosto;
    private double costoPromedio;
    
	private double MGVenta;
    private double MGUltimoCosto;
    private double MGPromedio;
    private double MGLineaMarca;
    private double MGLineaCliente;
    private double MGLinea;
    private double MGMinimo;
    private double margenCliente;
    private double margenDist;
    private String mensaje;
    private String proyectoLicitacion;
    private String urgente;
    private long usuarioNum;
    

	/**
	 * @return the cantidadexist
	 */
	public int getCantidadexist() {
		return cantidadexist;
	}
	/**
	 * @param cantidadexist the cantidadexist to set
	 */
	public void setCantidadexist(int cantidadexist) {
		this.cantidadexist = cantidadexist;
	}
    public double getPrecioAlDist() {
		return precioAlDist;
	}
	public void setPrecioAlDist(double precioAlDist) {
		this.precioAlDist = precioAlDist;
	}
	public double getMargenCliente() {
		return margenCliente;
	}
	public void setMargenCliente(double margenCliente) {
		this.margenCliente = margenCliente;
	}
    public double getMargenDist() {
		return margenDist;
	}
	public void setMargenDist(double margenDist) {
		this.margenDist = margenDist;
	}
    public String getFamilia() {
		return familia;
	}
	public void setFamilia(String familia) {
		this.familia = familia;
	}
	public String getProyectoLicitacion() {
		return proyectoLicitacion;
	}
	public void setProyectoLicitacion(String proyectoLicitacion) {
		this.proyectoLicitacion = proyectoLicitacion;
	}
	public String getUrgente() {
		return urgente;
	}
	public void setUrgente(String urgente) {
		this.urgente = urgente;
	}
	public static Logger getLog() {
		return LOG;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getLinea() {
		return linea;
	}
	public void setLinea(String linea) {
		this.linea = linea;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setMGMinimo(double mGMinimo) {
		MGMinimo = mGMinimo;
	}
    public double getMGMinimo() {
		return MGMinimo;
	}
	public double getDescDist() {
		return descDist;
	}
	public void setDescDist(double descDist) {
		this.descDist = descDist;
	}
	public void setMGMinimo() {
		LOG.info(this.getMGLinea()+","+this.getMGLineaMarca()+","+this.getMGLineaCliente());
		MGMinimo=this.getMGLineaCliente()==0?this.getMGLineaMarca()==0?this.getMGLinea():this.getMGLineaMarca():this.getMGLineaCliente();
		MGMinimo=MGMinimo<2.2?2.2:MGMinimo;
	}
	public void setMGMinimo(String linea) {
		linea=Cadena.filtra(linea);
		LOG.info(this.getMGLinea()+","+this.getMGLineaMarca()+","+this.getMGLineaCliente());
		MGMinimo=0;
		MGMinimo=this.getMGLineaCliente()==0?this.getMGLineaMarca()==0?this.getMGLinea():this.getMGLineaMarca():this.getMGLineaCliente();
		LOG.info("MG: "+MGMinimo+",linea: "+linea);
		if(MGMinimo==0){
			if("C1".equals(linea)){
				MGMinimo = 3.0;
			}else if("E1".equals(linea)){
				MGMinimo = 4.0;
			}else if( "CPC1".equals(linea) || "O1".equals(linea) || "A1".equals(linea) ||
			          "RI1".equals(linea) || "S1".equals(linea) || "CES".equals(linea) ||
			          "LZE".equals(linea)){
				MGMinimo = 5.0;
			}else if("PAP1".equals(linea) || "AL1".equals(linea) || "MDO1".equals(linea) || "DAV1".equals(linea)){
				MGMinimo = 7.0;
			}else{
				MGMinimo = 2.2;
			}
		}
		MGMinimo=MGMinimo<2.2?2.2:MGMinimo;
	}
	public double getMGLinea() {
		return MGLinea;
	}
	public void setMGLinea(double mGLinea) {
		MGLinea = mGLinea;
	}
	public double getMGLineaMarca() {
		return MGLineaMarca;
	}
	public void setMGLineaMarca(double mGLineaMarca) {
		MGLineaMarca = mGLineaMarca;
	}
	public double getMGLineaCliente() {
		return MGLineaCliente;
	}
	public void setMGLineaCliente(double mGLineaCliente) {
		MGLineaCliente = mGLineaCliente;
	}
	public double getMGVenta() {
		return MGVenta;
	}
	public void setMGVenta(double mGVenta) {
		MGVenta = mGVenta;
	}
	public double getMGUltimoCosto() {
		return MGUltimoCosto;
	}
	public void setMGUltimoCosto(double mGUltimoCosto) {
		MGUltimoCosto = mGUltimoCosto;
	}
	public double getMGPromedio() {
		return MGPromedio;
	}
	public void setMGPromedio(double mGPromedio) {
		MGPromedio = mGPromedio;
	}
	public double getCostoStandard() {
		return costoStandard;
	}
	public void setCostoStandard(double costoStandard) {
		this.costoStandard = costoStandard;
	}
	public double getUltimoCosto() {
		return ultimoCosto;
	}
	public void setUltimoCosto(double ultimoCosto) {
		this.ultimoCosto = ultimoCosto;
	}
	public double getCostoPromedio() {
		return costoPromedio;
	}
	public void setCostoPromedio(double costoPromedio) {
		this.costoPromedio = costoPromedio;
	}
	/**
     * @param pedidoNum
     */
    public PyPedidoDet(Long pedidoNum) {
        super();
        this.pedidoNum = pedidoNum;
    }
    /**
     * 
     */
    public PyPedidoDet() {
        super();
    }
        
    /**
	 * @param pedidoNum
	 * @param renglonNum
	 */
	public PyPedidoDet(Long pedidoNum, double renglonNum) {
		super();
		this.pedidoNum = pedidoNum;
		this.renglonNum = renglonNum;
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
     * @return the renglonNum
     */
    public double getRenglonNum() {
        return renglonNum;
    }
    /**
     * @param renglonNum the renglonNum to set
     */
    public void setRenglonNum(double renglonNum) {
        this.renglonNum = renglonNum;
    }
    /**
     * @return the itemNum
     */
    public String getItemNum() {
        return itemNum;
    }
    /**
     * @param itemNum the itemNum to set
     */
    public void setItemNum(String itemNum) {
        this.itemNum = itemNum;
    }
    /**
     * @return the claveClien
     */
    public String getClaveClien() {
        return claveClien;
    }
    /**
     * @param claveClien the claveClien to set
     */
    public void setClaveClien(String claveClien) {
        this.claveClien = claveClien;
    }
    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }
    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    /**
     * @return the currCode
     */
    public String getCurrCode() {
        return currCode;
    }
    /**
     * @param currCode the currCode to set
     */
    public void setCurrCode(String currCode) {
        this.currCode = currCode;
    }
    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }
    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
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
     * @return the tipoCambio
     */
    public double getTipoCambio() {
        return tipoCambio;
    }
    /**
     * @param tipoCambio the tipoCambio to set
     */
    public void setTipoCambio(double tipoCambio) {
        this.tipoCambio = tipoCambio;
    }
    /**
     * @return the descCartucho
     */
    public String getDescCartucho() {
        return descCartucho;
    }
    /**
     * @param descCartucho the descCartucho to set
     */
    public void setDescCartucho(String descCartucho) {
        this.descCartucho = descCartucho;
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
     * @return the ensid
     */
    public int getEnsid() {
        return ensid;
    }
    /**
     * @param ensid the ensid to set
     */
    public void setEnsid(int ensid) {
        this.ensid = ensid;
    }
    
        
    /**
     * @return the locationItem
     */
    public String getLocationItem() {
        return locationItem;
    }
    /**
     * @param locationItem the locationItem to set
     */
    public void setLocationItem(String locationItem) {
        this.locationItem = locationItem;
    }
    /**
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}
	/**
	 * @param item the item to set
	 */
	public void setItem(Item item) {
		this.item = item;
	}
	/**
	 * @return the imagen
	 */
	public String getImagen() {
		return imagen;
	}
	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	/**
	 * @return the precioDist
	 */
	public double getPrecioDist() {
		return precioDist;
	}
	/**
	 * @param precioDist the precioDist to set
	 */
	public void setPrecioDist(double precioDist) {
		this.precioDist = precioDist;
	}
	
	
	
	
	/**
	 * @return the margen
	 */
	public double getMargen() {
		return margen;
	}
	/**
	 * @param margen the margen to set
	 */
	public void setMargen(double margen) {
		this.margen = margen;
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
	/**
	 * @return the descuento
	 */
	public double getDescuento() {
		return descuento;
	}
	/**
	 * @param descuento the descuento to set
	 */
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	/**
	 * @return the precioList
	 */
	public double getPrecioList() {
		return precioList;
	}
	/**
	 * @param precioList the precioList to set
	 */
	public void setPrecioList(double precioList) {
		this.precioList = precioList;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	  /**
		 * @return the precioListDist
	 */
	public double getPrecioListDist() {
		return precioListDist;
	}
	/**
	 * @param precioListDist the precioListDist to set
	 */
	public void setPrecioListDist(double precioListDist) {
		this.precioListDist = precioListDist;
	}
	
	
	public long getUsuarioNum() {
		return usuarioNum;
	}
	public void setUsuarioNum(long usuarioNum) {
		this.usuarioNum = usuarioNum;
	}
	@Override
	public String toString() {
		return "PyPedidoDet [orgCode=" + orgCode + ", divCode=" + divCode
				+ ", pedidoNum=" + pedidoNum + ", renglonNum=" + renglonNum
				+ ", itemNum=" + itemNum + ", claveClien=" + claveClien
				+ ", cantidad=" + cantidad + ", currCode=" + currCode
				+ ", precio=" + precio + ", centroCosto=" + centroCosto
				+ ", estatus=" + estatus + ", tipoCambio=" + tipoCambio
				+ ", descCartucho=" + descCartucho + ", iva=" + iva
				+ ", ensid=" + ensid + ", precioList=" + precioList
				+ ", precioDist=" + precioDist + ", ivaDist=" + ivaDist+",cantidadexist="+cantidadexist
				+ ", margen=" + margen + ", descuento=" + descuento
				+ ", locationItem=" + locationItem + ", item=" + item
				+ ", imagen=" + imagen + ", getOrgCode()=" + getOrgCode()
				+ ", getDivCode()=" + getDivCode() + ", getPedidoNum()="
				+ getPedidoNum() + ", getRenglonNum()=" + getRenglonNum()
				+ ", getItemNum()=" + getItemNum() + ", getClaveClien()="
				+ getClaveClien() + ", getCantidad()=" + getCantidad()
				+ ", getCurrCode()=" + getCurrCode() + ", getPrecio()="
				+ getPrecio() + ", getCentroCosto()=" + getCentroCosto()
				+ ", getEstatus()=" + getEstatus() + ", getTipoCambio()="
				+ getTipoCambio() + ", getDescCartucho()=" + getDescCartucho()
				+ ", getIva()=" + getIva() + ", getEnsid()=" + getEnsid()
				+ ", getLocationItem()=" + getLocationItem() + ", getItem()="
				+ getItem() + ", getImagen()=" + getImagen()
				+ ", getPrecioDist()=" + getPrecioDist() + ", getMargen()="
				+ getMargen() + ", getIvaDist()=" + getIvaDist()
				+ ", getDescuento()=" + getDescuento() + ", getPrecioList()="
				+ getPrecioList() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

    
}
