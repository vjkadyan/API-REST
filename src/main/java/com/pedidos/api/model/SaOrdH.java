package com.pedidos.api.model;

public class SaOrdH {
	private String orgCode;
	private String divCode;
	private long custNum;
	private String bName;
	private long invoiceNum;
	private long orderNum;
	private String invDate;
	private String dueDate;
	private String transType;
	private double netAmount;
	private double tax1Amt;
	private double discount;
	private String shipVia;
	private String ppdColl;
	private long idSuperpedido;

	private String factura;
	private String var;
	
	private String serieFact;
	private String ligaFact;
	
	private String sAdd1;
	private String sAdd2;
	private String sColonia;
	private String sCity;
	private String sProvince;
	private String sCountry;
	private String sPostalCode;
	private String orderDate;
	
	public SaOrdH(String orgCode, String divCode, long orderNum) {
		super();
		this.orgCode = orgCode;
		this.divCode = divCode;
		this.orderNum = orderNum;
	}

	public SaOrdH(String orgCode, String divCode, long invoiceNum, String transType) {
		super();
		this.orgCode = orgCode;
		this.divCode = divCode;
		this.invoiceNum = invoiceNum;
		this.transType = transType;
	}

	public SaOrdH(String orgCode, String divCode, long idSuperpedido, String shipVia, String ppdColl) {
		this.orgCode = orgCode;
		this.divCode = divCode;
		this.idSuperpedido = idSuperpedido;
		this.shipVia = shipVia;
		this.ppdColl = ppdColl;
	}
	public SaOrdH() {
		super();
	}
	
	public String getsAdd1() {
		return sAdd1;
	}
	
	public void setsAdd1(String sAdd1) {
		this.sAdd1 = sAdd1;
	}
	
	public String getsAdd2() {
		return sAdd2;
	}
	
	public void setsAdd2(String sAdd2) {
		this.sAdd2 = sAdd2;
	}
	
	public String getsColonia() {
		return sColonia;
	}
	
	public void setsColonia(String sColonia) {
		this.sColonia = sColonia;
	}

	
	public String getsCity() {
		return sCity;
	}

	
	public void setsCity(String sCity) {
		this.sCity = sCity;
	}

	
	public String getsProvince() {
		return sProvince;
	}

	
	public void setsProvince(String sProvince) {
		this.sProvince = sProvince;
	}

	
	public String getsCountry() {
		return sCountry;
	}

	
	public void setsCountry(String sCountry) {
		this.sCountry = sCountry;
	}

	
	public String getsPostalCode() {
		return sPostalCode;
	}

	
	public void setsPostalCode(String sPostalCode) {
		this.sPostalCode = sPostalCode;
	}

	
	public String getOrderDate() {
		return orderDate;
	}

	
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getDivCode() {
		return divCode;
	}

	public void setDivCode(String divCode) {
		this.divCode = divCode;
	}

	public long getCustNum() {
		return custNum;
	}

	public void setCustNum(long custNum) {
		this.custNum = custNum;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public long getInvoiceNum() {
		return invoiceNum;
	}

	public void setInvoiceNum(long invoiceNum) {
		this.invoiceNum = invoiceNum;
	}

	public long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(long orderNum) {
		this.orderNum = orderNum;
	}

	public String getInvDate() {
		return invDate;
	}

	public void setInvDate(String invDate) {
		this.invDate = invDate;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}

	public double getTax1Amt() {
		return tax1Amt;
	}

	public void setTax1Amt(double tax1Amt) {
		this.tax1Amt = tax1Amt;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getFactura() {
		return factura;
	}

	public void setFactura(String factura) {
		this.factura = factura;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getShipVia() {
		return shipVia;
	}

	public void setShipVia(String shipVia) {
		this.shipVia = shipVia;
	}

	public String getPpdColl() {
		return ppdColl;
	}

	public void setPpdColl(String ppdColl) {
		this.ppdColl = ppdColl;
	}

	
	public long getIdSuperpedido() {
		return idSuperpedido;
	}

	
	public void setIdSuperpedido(long idSuperpedido) {
		this.idSuperpedido = idSuperpedido;
	}
	
	/*SerieFact*/
	public String getSerieFact() {
		return serieFact;
	}
	/**
	 * @param serieFact to set
	 */
	public void setSerieFact(String serieFact) {
		this.serieFact = serieFact;
	}
	

	/*LigaFactura*/
	public String getLigaFact() {
		return ligaFact;
	}
	/**
	 * @param serieFact to set
	 */
	public void setLigaFact(String ligaFact) {
		this.ligaFact = ligaFact;
	}

	@Override
	public String toString() {
		return "SaOrdH [orgCode=" + orgCode + ", divCode=" + divCode + ", custNum=" + custNum + ", bName=" + bName + ", invoiceNum=" + invoiceNum + ", orderNum=" + orderNum + ", invDate=" + invDate + ", dueDate=" + dueDate + ", transType=" + transType + ", netAmount=" + netAmount + ", tax1Amt=" + tax1Amt + ", discount=" + discount + ", shipVia=" + shipVia + ", ppdColl=" + ppdColl + ", idSuperpedido=" + idSuperpedido + ", factura=" + factura + ", var=" + var + ", serieFact=" + serieFact + ", ligaFact=" + ligaFact + ", sAdd1=" + sAdd1 + ", sAdd2=" + sAdd2 + ", sColonia=" + sColonia + ", sCity=" + sCity + ", sProvince=" + sProvince + ", sCountry=" + sCountry + ", sPostalCode=" + sPostalCode + ", orderDate=" + orderDate + "]";
	}
}
