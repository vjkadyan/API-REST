package com.pedidos.api.model;


import java.util.Date;

public class PyEnvioGratis {
	
	private String itemNum;
	private String envioGratis;
	private Date fechaAct;
	private String user;
	
	public PyEnvioGratis() {
		super();
	}

	public PyEnvioGratis(String itemNum, String envioGratis, Date fechaAct, String user) {
		super();
		this.itemNum = itemNum;
		this.envioGratis = envioGratis;
		this.fechaAct = fechaAct;
		this.user = user;
	}

	@Override
	public String toString() {
		return "PyEnvioGratis [itemNum=" + itemNum + ", envioGratis=" + envioGratis + ", fechaAct=" + fechaAct
				+ ", user=" + user + "]";
	}

	public String getItemNum() {
		return itemNum;
	}

	public void setItemNum(String itemNum) {
		this.itemNum = itemNum;
	}

	public String getEnvioGratis() {
		return envioGratis;
	}

	public void setEnvioGratis(String envioGratis) {
		this.envioGratis = envioGratis;
	}

	public Date getFechaAct() {
		return fechaAct;
	}

	public void setFechaAct(Date fechaAct) {
		this.fechaAct = fechaAct;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	
	
	

}
