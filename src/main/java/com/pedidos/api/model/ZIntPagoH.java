package com.pedidos.api.model;


public class ZIntPagoH {

	private long folio;
	private long custNum;
	private String fechaDep;
	private String fechaReal;
	private String slmnNum;
	private String fechaReg;
	private double monto;
	private String banco;
	private String sbc;
	private String comentario;
	private long aplicacion;
	private String reprog;
	private long sf;
	private String genSF;
	private double montoSF;
	private String fechaSF;
	private String usuSF;
	private long folioOp;
	
	
	public ZIntPagoH() {
	}


	public ZIntPagoH(long folio, long custNum, String fechaDep,
			String fechaReal, String slmnNum, String fechaReg, double monto,
			String banco, String sbc, String comentario, long aplicacion,
			String reprog, long sf, String genSF, double montoSF,
			String fechaSF, String usuSF, long folioOp) {
		super();
		this.folio = folio;
		this.custNum = custNum;
		this.fechaDep = fechaDep;
		this.fechaReal = fechaReal;
		this.slmnNum = slmnNum;
		this.fechaReg = fechaReg;
		this.monto = monto;
		this.banco = banco;
		this.sbc = sbc;
		this.comentario = comentario;
		this.aplicacion = aplicacion;
		this.reprog = reprog;
		this.sf = sf;
		this.genSF = genSF;
		this.montoSF = montoSF;
		this.fechaSF = fechaSF;
		this.usuSF = usuSF;
		this.folioOp = folioOp;
	}


	public long getFolio() {
		return folio;
	}


	public void setFolio(long folio) {
		this.folio = folio;
	}


	public long getCustNum() {
		return custNum;
	}


	public void setCustNum(long custNum) {
		this.custNum = custNum;
	}


	public String getFechaDep() {
		return fechaDep;
	}


	public void setFechaDep(String fechaDep) {
		this.fechaDep = fechaDep;
	}


	public String getFechaReal() {
		return fechaReal;
	}


	public void setFechaReal(String fechaReal) {
		this.fechaReal = fechaReal;
	}


	public String getSlmnNum() {
		return slmnNum;
	}


	public void setSlmnNum(String slmnNum) {
		this.slmnNum = slmnNum;
	}


	public String getFechaReg() {
		return fechaReg;
	}


	public void setFechaReg(String fechaReg) {
		this.fechaReg = fechaReg;
	}


	public double getMonto() {
		return monto;
	}


	public void setMonto(double monto) {
		this.monto = monto;
	}


	public String getBanco() {
		return banco;
	}


	public void setBanco(String banco) {
		this.banco = banco;
	}


	public String getSbc() {
		return sbc;
	}


	public void setSbc(String sbc) {
		this.sbc = sbc;
	}


	public String getComentario() {
		return comentario;
	}


	public void setComentario(String comentario) {
		this.comentario = comentario;
	}


	public long getAplicacion() {
		return aplicacion;
	}


	public void setAplicacion(long aplicacion) {
		this.aplicacion = aplicacion;
	}


	public String getReprog() {
		return reprog;
	}


	public void setReprog(String reprog) {
		this.reprog = reprog;
	}


	public long getSf() {
		return sf;
	}


	public void setSf(long sf) {
		this.sf = sf;
	}


	public String getGenSF() {
		return genSF;
	}


	public void setGenSF(String genSF) {
		this.genSF = genSF;
	}


	public double getMontoSF() {
		return montoSF;
	}


	public void setMontoSF(double montoSF) {
		this.montoSF = montoSF;
	}


	public String getFechaSF() {
		return fechaSF;
	}


	public void setFechaSF(String fechaSF) {
		this.fechaSF = fechaSF;
	}


	public String getUsuSF() {
		return usuSF;
	}


	public void setUsuSF(String usuSF) {
		this.usuSF = usuSF;
	}


	public long getFolioOp() {
		return folioOp;
	}


	public void setFolioOp(long folioOp) {
		this.folioOp = folioOp;
	}


	@Override
	public String toString() {
		return "ZIntPagoH [folio=" + folio + ", custNum=" + custNum
				+ ", fechaDep=" + fechaDep + ", fechaReal=" + fechaReal
				+ ", slmnNum=" + slmnNum + ", fechaReg=" + fechaReg
				+ ", monto=" + monto + ", banco=" + banco + ", sbc=" + sbc
				+ ", comentario=" + comentario + ", aplicacion=" + aplicacion
				+ ", reprog=" + reprog + ", sf=" + sf + ", genSF=" + genSF
				+ ", montoSF=" + montoSF + ", fechaSF=" + fechaSF + ", usuSF="
				+ usuSF + ", folioOp=" + folioOp + "]";
	}
	
	
	
	
}
