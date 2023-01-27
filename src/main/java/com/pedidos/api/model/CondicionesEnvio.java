package com.pedidos.api.model;


import java.sql.Date;

public class CondicionesEnvio {
	private String vehiculo;
	private String  maniobra;
	private String piecamion;
	private Date fechaEstimada;
	private String hora;
	
	/**
	 * @return the vehiculo
	 */
	public String getVehiculo() {
		return vehiculo;
	}
	/**
	 * @param vehiculo the vehiculo to set
	 */
	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}
	/**
	 * @return the maniobra
	 */
	public String getManiobra() {
		return maniobra;
	}
	/**
	 * @param maniobra the maniobra to set
	 */
	public void setManiobra(String maniobra) {
		this.maniobra = maniobra;
	}
	/**
	 * @return the piecamion
	 */
	public String getPiecamion() {
		return piecamion;
	}
	/**
	 * @param piecamion the piecamion to set
	 */
	public void setPiecamion(String piecamion) {
		this.piecamion = piecamion;
	}
	/**
	 * @return the fechaEstimada
	 */
	public Date getFechaEstimada() {
		return fechaEstimada;
	}
	/**
	 * @param fechaEstimada the fechaEstimada to set
	 */
	public void setFechaEstimada(Date fechaEstimada) {
		this.fechaEstimada = fechaEstimada;
	}
	/**
	 * @return the hora
	 */
	public String getHora() {
		return hora;
	}
	/**
	 * @param hora the hora to set
	 */
	public void setHora(String hora) {
		this.hora = hora;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CondicionesEnvio [vehiculo=" + vehiculo + ", maniobra="
				+ maniobra + ", piecamion=" + piecamion + ", fechaEstimada="
				+ fechaEstimada + ", hora=" + hora + "]";
	}
	
	
	
}
