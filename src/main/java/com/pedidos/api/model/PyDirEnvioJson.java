package com.pedidos.api.model;


import com.auth0.jwt.internal.com.fasterxml.jackson.annotation.JsonCreator;
import com.auth0.jwt.internal.com.fasterxml.jackson.annotation.JsonProperty;

public class PyDirEnvioJson { 
    private long dirNum;
    private long clienteNum;
    private String nombre;
    private String address1;
    private String address2;
    private String colonia;
    private String city;
    private String province;
    private String country;
    private String postalCode;
    private String phone;
    private String fax;
    private String contact;
    private String puesto;
    private String email;
    private String zonaEnvio;
    private String estatus;
    private String instrEntrega;
    private String entreCalle1;
    private String entreCalle2;
    private String piso;
    private String interior;
    private String exterior;
    private String extension;
    private long numEnvio;
    private long clave;
    private long shipNum;
    
    @JsonCreator
    public PyDirEnvioJson(	@JsonProperty("dirNum") long dirNum,
    						@JsonProperty("clienteNum") long clienteNum,
    						@JsonProperty("nombre") String nombre,
    						@JsonProperty("address1") String address1,
    						@JsonProperty("address2") String address2,
    						@JsonProperty("colonia") String colonia,
    						@JsonProperty("city") String city,
    						@JsonProperty("province") String province,
    						@JsonProperty("country") String country,
    						@JsonProperty("postalCode") String postalCode,
    						@JsonProperty("phone") String phone,
						    @JsonProperty("fax") String fax,
						    @JsonProperty("contact") String contact,
						    @JsonProperty("puesto") String puesto,
						    @JsonProperty("email") String email,
						    @JsonProperty("zonaEnvio") String zonaEnvio,
						    @JsonProperty("estatus") String estatus,
						    @JsonProperty("instrEntrega") String instrEntrega,
						    @JsonProperty("entreCalle1") String entreCalle1,
						    @JsonProperty("entreCalle2") String entreCalle2,
						    @JsonProperty("piso") String piso,
						    @JsonProperty("interior") String interior,
						    @JsonProperty("exterior") String exterior,
						    @JsonProperty("extension") String extension,
						    @JsonProperty("numEnvio") long numEnvio,
						    @JsonProperty("clave") long clave,
						    @JsonProperty("shipNum") long shipNum)
    {
    	this.clienteNum = clienteNum;
    	this.nombre = nombre;
    	this.address1 = address1.trim();
    	this.address2 = address2.trim();
    	this.colonia = colonia.trim();
    	this.city = city.trim();
    	this.province = province.trim();
    	this.country = country.trim();
    	this.postalCode = postalCode.trim();
    	this.phone = phone.trim();
    	this.fax = fax.trim();
    	this.contact = contact.trim();
    	this.puesto = puesto.trim();
    	this.email = email.trim();
    	this.zonaEnvio = zonaEnvio.trim();
    	this.estatus = estatus.trim();
    	this.instrEntrega = instrEntrega.trim();
    	this.entreCalle1 = entreCalle1.trim();
    	this.entreCalle2 = entreCalle2.trim();
    	this.piso = piso.trim();
    	this.interior = interior.trim();
    	this.exterior = exterior.trim();
    	this.extension = extension.trim();
    	this.numEnvio = numEnvio;
    	this.clave = clave;
    	this.shipNum = shipNum;
    }
    
    
	public String getExterior() {
		return exterior;
	}

	
	public void setExterior(String exterior) {
		this.exterior = exterior;
	}

	/**
	 * @param dirNum
	 * @param clienteNum
	 */
	public PyDirEnvioJson(long clienteNum,long dirNum) {
		super();
		this.clienteNum = clienteNum;
		this.dirNum = dirNum;
	}


	/**
     * 
     */
    public PyDirEnvioJson() {
        super();
    }
    
    
    /**
     * @return the dirNum
     */
    public long getDirNum() {
        return dirNum;
    }
    /**
     * @param dirNum the dirNum to set
     */
    public void setDirNum(long dirNum) {
        this.dirNum = dirNum;
    }
    /**
     * @return the clienteNum
     */
    public long getClienteNum() {
        return clienteNum;
    }
    /**
     * @param clienteNum the clienteNum to set
     */
    public void setClienteNum(long clienteNum) {
        this.clienteNum = clienteNum;
    }
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
     * @return the postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }
    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }
    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
     * @return the fax
     */
    public String getFax() {
        return fax;
    }
    /**
     * @param fax the fax to set
     */
    public void setFax(String fax) {
        this.fax = fax;
    }
    /**
     * @return the contact
     */
    public String getContact() {
        return contact;
    }
    /**
     * @param contact the contact to set
     */
    public void setContact(String contact) {
        this.contact = contact;
    }
    /**
     * @return the puesto
     */
    public String getPuesto() {
        return puesto;
    }
    /**
     * @param puesto the puesto to set
     */
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * @return the zonaEnvio
     */
    public String getZonaEnvio() {
        return zonaEnvio;
    }
    /**
     * @param zonaEnvio the zonaEnvio to set
     */
    public void setZonaEnvio(String zonaEnvio) {
        this.zonaEnvio = zonaEnvio;
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
     * @return the instrEntrega
     */
    public String getInstrEntrega() {
        return instrEntrega;
    }
    /**
     * @param instrEntrega the instrEntrega to set
     */
    public void setInstrEntrega(String instrEntrega) {
        this.instrEntrega = instrEntrega;
    }
    /**
     * @return the entreCalle1
     */
    public String getEntreCalle1() {
        return entreCalle1;
    }
    /**
     * @param entreCalle1 the entreCalle1 to set
     */
    public void setEntreCalle1(String entreCalle1) {
        this.entreCalle1 = entreCalle1;
    }
    /**
     * @return the entreCalle2
     */
    public String getEntreCalle2() {
        return entreCalle2;
    }
    /**
     * @param entreCalle2 the entreCalle2 to set
     */
    public void setEntreCalle2(String entreCalle2) {
        this.entreCalle2 = entreCalle2;
    }
    /**
     * @return the piso
     */
    public String getPiso() {
        return piso;
    }
    /**
     * @param piso the piso to set
     */
    public void setPiso(String piso) {
        this.piso = piso;
    }
    /**
     * @return the interior
     */
    public String getInterior() {
        return interior;
    }
    /**
     * @param interior the interior to set
     */
    public void setInterior(String interior) {
        this.interior = interior;
    }
    /**
     * @return the extension
     */
    public String getExtension() {
        return extension;
    }
    /**
     * @param extension the extension to set
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }
    /**
     * @return the numEnvio
     */
    public long getNumEnvio() {
        return numEnvio;
    }
    /**
     * @param numEnvio the numEnvio to set
     */
    public void setNumEnvio(long numEnvio) {
        this.numEnvio = numEnvio;
    }
    /**
     * @return the clave
     */
    public long getClave() {
        return clave;
    }
    /**
     * @param clave the clave to set
     */
    public void setClave(long clave) {
        this.clave = clave;
    }
    
    
    
    public long getShipNum() {
		return shipNum;
	}


	public void setShipNum(long shipNum) {
		this.shipNum = shipNum;
	}


	@Override
	public String toString() {
		return "{dirNum:" + dirNum + ", clienteNum:" + clienteNum + ", nombre:" + nombre + ", address1:" + address1
				+ ", address2:" + address2 + ", colonia:" + colonia + ", city:" + city + ", province:" + province
				+ ", country:" + country + ", postalCode:" + postalCode + ", phone:" + phone + ", fax:" + fax
				+ ", contact:" + contact + ", puesto:" + puesto + ", email:" + email + ", zonaEnvio:" + zonaEnvio
				+ ", estatus:" + estatus + ", instrEntrega:" + instrEntrega + ", entreCalle1:" + entreCalle1
				+ ", entreCalle2:" + entreCalle2 + ", piso:" + piso + ", interior:" + interior + ", exterior:"
				+ exterior + ", extension:" + extension + ", numEnvio:" + numEnvio + ", clave:" + clave + ", shipNum:"
				+ shipNum + "}";
	}

}
