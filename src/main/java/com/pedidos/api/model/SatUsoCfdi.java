package com.pedidos.api.model;

public class SatUsoCfdi {
	private String idUsu;
	private String descripcion;
	private String apPfisica;
	private String apPmoral;
	public SatUsoCfdi() {
		super();
	} 
	public SatUsoCfdi(String idUsu, String descripcion, String apPfisica,
			String apPmoral) {
		super();
		this.idUsu = idUsu;
		this.descripcion = descripcion;
		this.apPfisica = apPfisica;
		this.apPmoral = apPmoral;
	}
	/**
	 * @return the idUsu
	 */
	public String getIdUsu() {
		return idUsu;
	}
	/**
	 * @param idUsu the idUsu to set
	 */
	public void setIdUsu(String idUsu) {
		this.idUsu = idUsu;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the apPfisica
	 */
	public String getApPfisica() {
		return apPfisica;
	}
	/**
	 * @param apPfisica the apPfisica to set
	 */
	public void setApPfisica(String apPfisica) {
		this.apPfisica = apPfisica;
	}
	/**
	 * @return the apPmoral
	 */
	public String getApPmoral() {
		return apPmoral;
	}
	/**
	 * @param apPmoral the apPmoral to set
	 */
	public void setApPmoral(String apPmoral) {
		this.apPmoral = apPmoral;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SatUsoCfdi [idUsu=" + idUsu + ", descripcion=" + descripcion
				+ ", apPfisica=" + apPfisica + ", apPmoral=" + apPmoral + "]";
	}
}
