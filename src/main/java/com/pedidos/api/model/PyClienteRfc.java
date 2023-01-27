package com.pedidos.api.model;

public class PyClienteRfc {
	private long rfcNum;
    private long clienteNum;
    private String nombre;
    private String address1;
    private String address2;
    private String colonia;
    private String city;
    private String province;
    private String postalCode;
    private String phone;
    private String contact;
    private String mPago;
    private String idUsoCfdi;
    private String clienteRfc;
     
    
    /**
	 * @param rfcNum
	 * @param clienteNum
	 */
    
    public PyClienteRfc(long clienteNum,long rfcNum) {
		super();
		this.clienteNum = clienteNum;
		this.rfcNum = rfcNum;
	}

    public PyClienteRfc() {
        super();
    }

	public long getRfcNum() {
		return rfcNum;
	}


	public void setRfcNum(long rfcNum) {
		this.rfcNum = rfcNum;
	}


	public long getClienteNum() {
		return clienteNum;
	}


	public void setClienteNum(long clienteNum) {
		this.clienteNum = clienteNum;
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


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getmPago() {
		return mPago;
	}


	public void setmPago(String mPago) {
		this.mPago = mPago;
	}


	public String getIdUsoCfdi() {
		return idUsoCfdi;
	}


	public void setIdUsoCfdi(String idUsoCfdi) {
		this.idUsoCfdi = idUsoCfdi;
	}


	public String getClienteRfc() {
		return clienteRfc;
	}


	public void setClienteRfc(String clienteRfc) {
		this.clienteRfc = clienteRfc;
	}


	@Override
	public String toString() {
		return "PyClienteRfc [rfcNum=" + rfcNum + ", clienteNum=" + clienteNum + ", nombre=" + nombre + ", address1="
				+ address1 + ", address2=" + address2 + ", colonia=" + colonia + ", city=" + city + ", province="
				+ province + ", postalCode=" + postalCode + ", phone=" + phone + ", contact=" + contact + ", mPago="
				+ mPago + ", idUsoCfdi=" + idUsoCfdi + ", clienteRfc=" + clienteRfc + "]";
	}
    
}
