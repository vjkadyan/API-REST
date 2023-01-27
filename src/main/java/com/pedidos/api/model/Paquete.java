package com.pedidos.api.model;


public class Paquete {

	private long paquete_Num;
	private String paqueteria;
	private long men_Code;
	private String item_Num;
	private String empresa;
	private int tipoServicio;
	private String calle;
	private String estado;
	private int cp;
	private String delegacion;
	private String colonia;
	private String contacto;
	private String telefono;
	private String ext;
	private String mail;
	private String credito;
	private String stat;
	private long valoracion;
	private int modelo;
	private String modoServ;
	private String express;

	public long getPaqueteNum() {
		return paquete_Num;
	}

	public void setPaqueteNum(long paqueteNum) {
		this.paquete_Num = paqueteNum;
	}

	public String getPaqueteria() {
		return paqueteria;
	}

	public void setPaqueteria(String paqueteria) {
		this.paqueteria = paqueteria;
	}

	public long getMenCode() {
		return men_Code;
	}

	public void setMenCode(long menCode) {
		this.men_Code = menCode;
	}

	public String getItemNum() {
		return item_Num;
	}

	public void setItemNum(String itemNum) {
		this.item_Num = itemNum;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public int getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(int tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getDelegacion() {
		return delegacion;
	}

	public void setDelegacion(String delegacion) {
		this.delegacion = delegacion;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getCredito() {
		return credito;
	}

	public void setCredito(String credito) {
		this.credito = credito;
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	public long getValoracion() {
		return valoracion;
	}

	public void setValoracion(long valoracion) {
		this.valoracion = valoracion;
	}

	public int getModelo() {
		return modelo;
	}

	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

	public String getModoServ() {
		return modoServ;
	}

	public void setModoServ(String modoServ) {
		this.modoServ = modoServ;
	}

	public String getExpress() {
		return express;
	}

	public void setExpress(String express) {
		this.express = express;
	}

	public Paquete(long paqueteNum, String paqueteria, long menCode, String itemNum, String empresa, int tipoServicio, String calle, String estado, int cp, String delegacion, String colonia, String contacto, String telefono, String ext, String mail, String credito, String stat, long valoracion, int modelo, String modoServ, String express) {
		this.paquete_Num = paqueteNum;
		this.paqueteria = paqueteria;
		this.men_Code = menCode;
		this.item_Num = itemNum;
		this.empresa = empresa;
		this.tipoServicio = tipoServicio;
		this.calle = calle;
		this.estado = estado;
		this.cp = cp;
		this.delegacion = delegacion;
		this.colonia = colonia;
		this.contacto = contacto;
		this.telefono = telefono;
		this.ext = ext;
		this.mail = mail;
		this.credito = credito;
		this.stat = stat;
		this.valoracion = valoracion;
		this.modelo = modelo;
		this.modoServ = modoServ;
		this.express = express;
	}

	public Paquete(String itemNum) {
		this.item_Num = itemNum;
	}

	public Paquete() {
	}

	@Override
	public String toString() {
		return "Paquete [paqueteNum=" + paquete_Num + ", paqueteria=" + paqueteria + ", menCode=" + men_Code + ", itemNum=" + item_Num + ", empresa=" + empresa + ", tipoServicio=" + tipoServicio + ", calle=" + calle + ", estado=" + estado + ", cp=" + cp + ", delegacion=" + delegacion + ", colonia=" + colonia + ", contacto=" + contacto + ", telefono=" + telefono + ", ext=" + ext + ", mail=" + mail + ", credito=" + credito + ", stat=" + stat + ", valoracion=" + valoracion + ", modelo=" + modelo + ", modoServ=" + modoServ + ", express=" + express + "]";
	}

}
