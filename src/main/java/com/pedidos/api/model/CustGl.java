package com.pedidos.api.model;

public class CustGl {

	private String org_code;
	private String div_code;
	private long cust_num;
	private String gl_code;


	public String getOrgCode() {
		return org_code;
	}

	public void setOrgCode(String org_code) {
		this.org_code = org_code;
	}

	public String getDivCode() {
		return div_code;
	}

	public void setDivCode(String div_code) {
		this.div_code = div_code;
	}

	public long getCustNum() {
		return cust_num;
	}

	public void setCustNum(long cust_num) {
		this.cust_num = cust_num;
	}

	public String getGlCode() {
		return gl_code;
	}

	public void setGlCode(String gl_code) {
		this.gl_code = gl_code;
	}

	@Override
	public String toString() {
		return "CustGl [org_code=" + org_code + ", div_code=" + div_code + ", cust_num=" + cust_num + ", gl_code=" + gl_code + "]";
	}

}
