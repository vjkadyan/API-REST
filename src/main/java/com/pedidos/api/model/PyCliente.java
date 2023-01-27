package com.pedidos.api.model;

import java.io.Serializable;

public class PyCliente implements Serializable{
	private static final long serialVersionUID = 2063229674989134454L;
	 
	private long clienteNum;
    private long custNum;
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
    private String modoPorcentaje;
    private String porcentaje;
    private String estatus;
    private String instrucCobro;
    private String remFact;
    private String clienteRfc;
    private String zona;
    private String directo;
    private String laboratorio;
    private double margenLab;
    private String apartado;
    private int claveHorario;
    private String pSupAlta;
    private int cantUsuAlta;
    private double costoEnvio;
    private int enviosGratis;
    private double montoEnvio;
    private int controlEnvios;
    private String tipoEntrega;
    private String credito;
    private String ultVisita;
    private String cuentaSoho;
    private String manejaCc;
    private String clasificacion;
    private String clase;
    private String tipo;
    private String remision;
    private String validadoCredito;
	
    public PyCliente() {
		super();
	}

	public PyCliente(long clienteNum, long custNum, String nombre,
			String address1, String address2, String colonia, String city,
			String province, String country, String postalCode, String phone,
			String fax, String contact, String puesto, String email,
			String modoPorcentaje, String porcentaje, String estatus,
			String instrucCobro, String remFact, String clienteRfc,
			String zona, String directo, String laboratorio, double margenLab,
			String apartado, int claveHorario, String pSupAlta,
			int cantUsuAlta, double costoEnvio, int enviosGratis,
			double montoEnvio, int controlEnvios, String tipoEntrega,
			String credito, String ultVisita, String cuentaSoho,
			String manejaCc, String clasificacion, String clase, String tipo,
			String remision, String validadoCredito) {
		super();
		this.clienteNum = clienteNum;
		this.custNum = custNum;
		this.nombre = nombre;
		this.address1 = address1;
		this.address2 = address2;
		this.colonia = colonia;
		this.city = city;
		this.province = province;
		this.country = country;
		this.postalCode = postalCode;
		this.phone = phone;
		this.fax = fax;
		this.contact = contact;
		this.puesto = puesto;
		this.email = email;
		this.modoPorcentaje = modoPorcentaje;
		this.porcentaje = porcentaje;
		this.estatus = estatus;
		this.instrucCobro = instrucCobro;
		this.remFact = remFact;
		this.clienteRfc = clienteRfc;
		this.zona = zona;
		this.directo = directo;
		this.laboratorio = laboratorio;
		this.margenLab = margenLab;
		this.apartado = apartado;
		this.claveHorario = claveHorario;
		this.pSupAlta = pSupAlta;
		this.cantUsuAlta = cantUsuAlta;
		this.costoEnvio = costoEnvio;
		this.enviosGratis = enviosGratis;
		this.montoEnvio = montoEnvio;
		this.controlEnvios = controlEnvios;
		this.tipoEntrega = tipoEntrega;
		this.credito = credito;
		this.ultVisita = ultVisita;
		this.cuentaSoho = cuentaSoho;
		this.manejaCc = manejaCc;
		this.clasificacion = clasificacion;
		this.clase = clase;
		this.tipo = tipo;
		this.remision = remision;
		this.validadoCredito = validadoCredito;
	}
	
	public PyCliente(long clienteNum) {
		super();
		this.clienteNum = clienteNum;
	}

	public long getClienteNum() {
		return clienteNum;
	}

	public void setClienteNum(long clienteNum) {
		this.clienteNum = clienteNum;
	}

	public long getCustNum() {
		return custNum;
	}

	public void setCustNum(long custNum) {
		this.custNum = custNum;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getModoPorcentaje() {
		return modoPorcentaje;
	}

	public void setModoPorcentaje(String modoPorcentaje) {
		this.modoPorcentaje = modoPorcentaje;
	}

	public String getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(String porcentaje) {
		this.porcentaje = porcentaje;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getInstrucCobro() {
		return instrucCobro;
	}

	public void setInstrucCobro(String instrucCobro) {
		this.instrucCobro = instrucCobro;
	}

	public String getRemFact() {
		return remFact;
	}

	public void setRemFact(String remFact) {
		this.remFact = remFact;
	}

	public String getClienteRfc() {
		return clienteRfc;
	}

	public void setClienteRfc(String clienteRfc) {
		this.clienteRfc = clienteRfc;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getDirecto() {
		return directo;
	}

	public void setDirecto(String directo) {
		this.directo = directo;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public double getMargenLab() {
		return margenLab;
	}

	public void setMargenLab(double margenLab) {
		this.margenLab = margenLab;
	}

	public String getApartado() {
		return apartado;
	}

	public void setApartado(String apartado) {
		this.apartado = apartado;
	}

	public int getClaveHorario() {
		return claveHorario;
	}

	public void setClaveHorario(int claveHorario) {
		this.claveHorario = claveHorario;
	}

	public String getPSupAlta() {
		return pSupAlta;
	}

	public void setPSupAlta(String pSupAlta) {
		this.pSupAlta = pSupAlta;
	}

	public int getCantUsuAlta() {
		return cantUsuAlta;
	}

	public void setCantUsuAlta(int cantUsuAlta) {
		this.cantUsuAlta = cantUsuAlta;
	}

	public double getCostoEnvio() {
		return costoEnvio;
	}

	public void setCostoEnvio(double costoEnvio) {
		this.costoEnvio = costoEnvio;
	}

	public int getEnviosGratis() {
		return enviosGratis;
	}

	public void setEnviosGratis(int enviosGratis) {
		this.enviosGratis = enviosGratis;
	}

	public double getMontoEnvio() {
		return montoEnvio;
	}

	public void setMontoEnvio(double montoEnvio) {
		this.montoEnvio = montoEnvio;
	}

	public int getControlEnvios() {
		return controlEnvios;
	}

	public void setControlEnvios(int controlEnvios) {
		this.controlEnvios = controlEnvios;
	}

	public String getTipoEntrega() {
		return tipoEntrega;
	}

	public void setTipoEntrega(String tipoEntrega) {
		this.tipoEntrega = tipoEntrega;
	}

	public String getCredito() {
		return credito;
	}

	public void setCredito(String credito) {
		this.credito = credito;
	}

	public String getUltVisita() {
		return ultVisita;
	}

	public void setUltVisita(String ultVisita) {
		this.ultVisita = ultVisita;
	}

	public String getCuentaSoho() {
		return cuentaSoho;
	}

	public void setCuentaSoho(String cuentaSoho) {
		this.cuentaSoho = cuentaSoho;
	}

	public String getManejaCc() {
		return manejaCc;
	}

	public void setManejaCc(String manejaCc) {
		this.manejaCc = manejaCc;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRemision() {
		return remision;
	}

	public void setRemision(String remision) {
		this.remision = remision;
	}

	public String getValidadoCredito() {
		return validadoCredito;
	}

	public void setValidadoCredito(String validadoCredito) {
		this.validadoCredito = validadoCredito;
	}

	@Override
	public String toString() {
		return "PyCliente [clienteNum=" + clienteNum + ", custNum=" + custNum
				+ ", nombre=" + nombre + ", address1=" + address1
				+ ", address2=" + address2 + ", colonia=" + colonia + ", city="
				+ city + ", province=" + province + ", country=" + country
				+ ", postalCode=" + postalCode + ", phone=" + phone + ", fax="
				+ fax + ", contact=" + contact + ", puesto=" + puesto
				+ ", email=" + email + ", modoPorcentaje=" + modoPorcentaje
				+ ", porcentaje=" + porcentaje + ", estatus=" + estatus
				+ ", instrucCobro=" + instrucCobro + ", remFact=" + remFact
				+ ", clienteRfc=" + clienteRfc + ", zona=" + zona
				+ ", directo=" + directo + ", laboratorio=" + laboratorio
				+ ", margenLab=" + margenLab + ", apartado=" + apartado
				+ ", claveHorario=" + claveHorario + ", pSupAlta=" + pSupAlta
				+ ", cantUsuAlta=" + cantUsuAlta + ", costoEnvio=" + costoEnvio
				+ ", enviosGratis=" + enviosGratis + ", montoEnvio="
				+ montoEnvio + ", controlEnvios=" + controlEnvios
				+ ", tipoEntrega=" + tipoEntrega + ", credito=" + credito
				+ ", ultVisita=" + ultVisita + ", cuentaSoho=" + cuentaSoho
				+ ", manejaCc=" + manejaCc + ", clasificacion=" + clasificacion
				+ ", clase=" + clase + ", tipo=" + tipo + ", remision="
				+ remision + ", validadoCredito=" + validadoCredito + "]";
	}
    
    
}
