package com.pedidos.api.model;


public class ZIntPagoL {
	
	private long folio;
	private long orderNum;
	private String orgCode;
	private String divCode;
	private String transType;
	private int transNum;
	private double transAmt;
	private String transDate;
	
	/**Atributos extras**/
	private OrderH orderH;
	
	
	public ZIntPagoL() {
	}

	
	
	public ZIntPagoL(long folio, long orderNum, String orgCode, String divCode, String transType, int transNum,
			double transAmt, String transDate, OrderH orderH) {
		super();
		this.folio = folio;
		this.orderNum = orderNum;
		this.orgCode = orgCode;
		this.divCode = divCode;
		this.transType = transType;
		this.transNum = transNum;
		this.transAmt = transAmt;
		this.transDate = transDate;
		this.orderH = orderH;
	}



	public long getFolio() {
		return folio;
	}


	public void setFolio(long folio) {
		this.folio = folio;
	}


	public long getOrderNum() {
		return orderNum;
	}


	public void setOrderNum(long orderNum) {
		this.orderNum = orderNum;
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


	public String getTransType() {
		return transType;
	}


	public void setTransType(String transType) {
		this.transType = transType;
	}


	public int getTransNum() {
		return transNum;
	}


	public void setTransNum(int transNum) {
		this.transNum = transNum;
	}


	public double getTransAmt() {
		return transAmt;
	}


	public void setTransAmt(double transAmt) {
		this.transAmt = transAmt;
	}


	public String getTransDate() {
		return transDate;
	}


	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}



	public OrderH getOrderH() {
		return orderH;
	}



	public void setOrderH(OrderH orderH) {
		this.orderH = orderH;
	}



	@Override
	public String toString() {
		return "ZIntPagoL [folio=" + folio + ", orderNum=" + orderNum + ", orgCode=" + orgCode + ", divCode=" + divCode
				+ ", transType=" + transType + ", transNum=" + transNum + ", transAmt=" + transAmt + ", transDate="
				+ transDate + ", orderH=" + orderH + "]";
	}
	
	
}