package com.pedidos.api.model;

public class Zzzenvio {
	private long custNum;
	private int shipNum;
	private String postalCode;
	private long orderShip;
	private long orderNum;
	private String dateh;
	private String ip;
	
	/**ATRIBUTOS EXTRAS**/
	private OrderH envioH;
	private OrderL envioL;
	private Paquete paquete;
	
	/**
	 * @param orderShip
	 * @param orderNum
	 */
	public Zzzenvio(long orderShip, long orderNum) {
		super();
		this.orderShip = orderShip;
		this.orderNum = orderNum;
	}
	/**
	 * 
	 */
	public Zzzenvio() {
		super();
	}
	/**
	 * @return the custNum
	 */
	public long getCustNum() {
		return custNum;
	}
	/**
	 * @param custNum the custNum to set
	 */
	public void setCustNum(long custNum) {
		this.custNum = custNum;
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
	 * @return the orderShip
	 */
	public long getOrderShip() {
		return orderShip;
	}
	/**
	 * @param orderShip the orderShip to set
	 */
	public void setOrderShip(long orderShip) {
		this.orderShip = orderShip;
	}
	/**
	 * @return the orderNum
	 */
	public long getOrderNum() {
		return orderNum;
	}
	/**
	 * @param orderNum the orderNum to set
	 */
	public void setOrderNum(long orderNum) {
		this.orderNum = orderNum;
	}
	/**
	 * @return the dateh
	 */
	public String getDateh() {
		return dateh;
	}
	/**
	 * @param dateh the dateh to set
	 */
	public void setDateh(String dateh) {
		this.dateh = dateh;
	}
	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * @return the envioH
	 */
	public OrderH getEnvioH() {
		return envioH;
	}
	/**
	 * @param envioH the envioH to set
	 */
	public void setEnvioH(OrderH envioH) {
		this.envioH = envioH;
	}
	/**
	 * @return the envioL
	 */
	public OrderL getEnvioL() {
		return envioL;
	}
	/**
	 * @param envioL the envioL to set
	 */
	public void setEnvioL(OrderL envioL) {
		this.envioL = envioL;
	}
	/**
	 * @return the paquete
	 */
	public Paquete getPaquete() {
		return paquete;
	}
	/**
	 * @param paquete the paquete to set
	 */
	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Zzzenvio [custNum=" + custNum + ", shipNum=" + shipNum + ", postalCode=" + postalCode + ", orderShip="
				+ orderShip + ", orderNum=" + orderNum + ", dateh=" + dateh + ", ip=" + ip + ", envioH=" + envioH
				+ ", envioL=" + envioL + ", paquete=" + paquete + "]";
	}
	
	
	
	
	
	
	
	
	
}
