package com.pedidos.api.model;


public class OrderL {
	private String orgCode;
	private String divCode;
	private String whseCode;
	private long invoiceNum;
	private long orderNum;
	private double lineNum;
	private String terminalNum;
	private int boNum;
	private String itemNum;
	private String sortName;
	private String dropShip;
	private String binLocation;
	private String nonStock;
	private String description;
	private String packDesc;
	private String sizeDesc;
	private String memo;
	private String sellUom;
	private double sellingMultiplier;
	private String priceUom;
	private double priceMultiplier;
	private double qtyOrdered;
	private double qtyCommitted;
	private double qtyShipped;
	private double qtyBo;
	private double weight;
	private double volume;
	private double grossPrice;
	private double bbAmount;
	private double coopAmt;
	private double discountAmt;
	private String discType;
	private String commAType;
	private double commAmt;
	private String commType;
	private double commVolume;
	private double commEarned;
	private double commableAmt;
	private String commGrossNet;
	private double cost;
	private double netPrice;
	private double extension;
	private double restockCharge;
	private String damaged;
	private String requestDate;
	private String serialItem;
	private String serialNum;
	private String promoCode;
	private String palletDesc;
	private double oldOrdered;
	private double oldCommitted;
	private String taxGrp1;
	private String taxGrp2;
	private double tax1Amt;
	private double tax2Amt;
	private String taxable;
	private String bin;
	private String groupCode;
	private String kitItem;
	private String compOption;
	private String reviewKit;
	private String printKit;
	private String printComp;
	private String compSeqPps;
	private String custItemNum;
	private String interItemNum;
	private String subbedItemNum;
	private String nsReq;
	private double multiplier;
	private String symbol;
	private double discountCas;
	private double discountMax;
	private long idSuperpedido;
	private String condicion;
	private String tipoArticulo;
	private String fam;
	private int ensId;
	private double porPronto;
	private String pronto;
	private double lastCostO;
	private int num;
	private String ventaUsd;
	
	private String desc;
	
	/**
	 * 
	 */
	public OrderL() {
		super();
	}
	/**
	 * @param orgCode
	 * @param divCode
	 * @param orderNum
	 * @param lineNum
	 * @param boNum
	 */
	public OrderL(String orgCode, String divCode, long orderNum,
			double lineNum, int boNum) {
		super();
		this.orgCode = orgCode;
		this.divCode = divCode;
		this.orderNum = orderNum;
		this.lineNum = lineNum;
		this.boNum = boNum;
	}
	/**
	 * @return the orgCode
	 */
	public String getOrgCode() {
		return orgCode;
	}
	/**
	 * @param orgCode the orgCode to set
	 */
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	/**
	 * @return the divCode
	 */
	public String getDivCode() {
		return divCode;
	}
	/**
	 * @param divCode the divCode to set
	 */
	public void setDivCode(String divCode) {
		this.divCode = divCode;
	}
	/**
	 * @return the whseCode
	 */
	public String getWhseCode() {
		return whseCode;
	}
	/**
	 * @param whseCode the whseCode to set
	 */
	public void setWhseCode(String whseCode) {
		this.whseCode = whseCode;
	}
	/**
	 * @return the invoiceNum
	 */
	public long getInvoiceNum() {
		return invoiceNum;
	}
	/**
	 * @param invoiceNum the invoiceNum to set
	 */
	public void setInvoiceNum(long invoiceNum) {
		this.invoiceNum = invoiceNum;
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
	 * @return the lineNum
	 */
	public double getLineNum() {
		return lineNum;
	}
	/**
	 * @param lineNum the lineNum to set
	 */
	public void setLineNum(double lineNum) {
		this.lineNum = lineNum;
	}
	/**
	 * @return the terminalNum
	 */
	public String getTerminalNum() {
		return terminalNum;
	}
	/**
	 * @param terminalNum the terminalNum to set
	 */
	public void setTerminalNum(String terminalNum) {
		this.terminalNum = terminalNum;
	}
	/**
	 * @return the boNum
	 */
	public int getBoNum() {
		return boNum;
	}
	/**
	 * @param boNum the boNum to set
	 */
	public void setBoNum(int boNum) {
		this.boNum = boNum;
	}
	/**
	 * @return the itemNum
	 */
	public String getItemNum() {
		return itemNum;
	}
	/**
	 * @param itemNum the itemNum to set
	 */
	public void setItemNum(String itemNum) {
		this.itemNum = itemNum;
	}
	/**
	 * @return the sortName
	 */
	public String getSortName() {
		return sortName;
	}
	/**
	 * @param sortName the sortName to set
	 */
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	/**
	 * @return the dropShip
	 */
	public String getDropShip() {
		return dropShip;
	}
	/**
	 * @param dropShip the dropShip to set
	 */
	public void setDropShip(String dropShip) {
		this.dropShip = dropShip;
	}
	/**
	 * @return the binLocation
	 */
	public String getBinLocation() {
		return binLocation;
	}
	/**
	 * @param binLocation the binLocation to set
	 */
	public void setBinLocation(String binLocation) {
		this.binLocation = binLocation;
	}
	/**
	 * @return the nonStock
	 */
	public String getNonStock() {
		return nonStock;
	}
	/**
	 * @param nonStock the nonStock to set
	 */
	public void setNonStock(String nonStock) {
		this.nonStock = nonStock;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the packDesc
	 */
	public String getPackDesc() {
		return packDesc;
	}
	/**
	 * @param packDesc the packDesc to set
	 */
	public void setPackDesc(String packDesc) {
		this.packDesc = packDesc;
	}
	/**
	 * @return the sizeDesc
	 */
	public String getSizeDesc() {
		return sizeDesc;
	}
	/**
	 * @param sizeDesc the sizeDesc to set
	 */
	public void setSizeDesc(String sizeDesc) {
		this.sizeDesc = sizeDesc;
	}
	/**
	 * @return the memo
	 */
	public String getMemo() {
		return memo;
	}
	/**
	 * @param memo the memo to set
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}
	/**
	 * @return the sellUom
	 */
	public String getSellUom() {
		return sellUom;
	}
	/**
	 * @param sellUom the sellUom to set
	 */
	public void setSellUom(String sellUom) {
		this.sellUom = sellUom;
	}
	/**
	 * @return the sellingMultiplier
	 */
	public double getSellingMultiplier() {
		return sellingMultiplier;
	}
	/**
	 * @param sellingMultiplier the sellingMultiplier to set
	 */
	public void setSellingMultiplier(double sellingMultiplier) {
		this.sellingMultiplier = sellingMultiplier;
	}
	/**
	 * @return the priceUom
	 */
	public String getPriceUom() {
		return priceUom;
	}
	/**
	 * @param priceUom the priceUom to set
	 */
	public void setPriceUom(String priceUom) {
		this.priceUom = priceUom;
	}
	/**
	 * @return the priceMultiplier
	 */
	public double getPriceMultiplier() {
		return priceMultiplier;
	}
	/**
	 * @param priceMultiplier the priceMultiplier to set
	 */
	public void setPriceMultiplier(double priceMultiplier) {
		this.priceMultiplier = priceMultiplier;
	}
	/**
	 * @return the qtyOrdered
	 */
	public double getQtyOrdered() {
		return qtyOrdered;
	}
	/**
	 * @param qtyOrdered the qtyOrdered to set
	 */
	public void setQtyOrdered(double qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}
	/**
	 * @return the qtyCommitted
	 */
	public double getQtyCommitted() {
		return qtyCommitted;
	}
	/**
	 * @param qtyCommitted the qtyCommitted to set
	 */
	public void setQtyCommitted(double qtyCommitted) {
		this.qtyCommitted = qtyCommitted;
	}
	/**
	 * @return the qtyShipped
	 */
	public double getQtyShipped() {
		return qtyShipped;
	}
	/**
	 * @param qtyShipped the qtyShipped to set
	 */
	public void setQtyShipped(double qtyShipped) {
		this.qtyShipped = qtyShipped;
	}
	/**
	 * @return the qtyBo
	 */
	public double getQtyBo() {
		return qtyBo;
	}
	/**
	 * @param qtyBo the qtyBo to set
	 */
	public void setQtyBo(double qtyBo) {
		this.qtyBo = qtyBo;
	}
	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	/**
	 * @return the volume
	 */
	public double getVolume() {
		return volume;
	}
	/**
	 * @param volume the volume to set
	 */
	public void setVolume(double volume) {
		this.volume = volume;
	}
	/**
	 * @return the grossPrice
	 */
	public double getGrossPrice() {
		return grossPrice;
	}
	/**
	 * @param grossPrice the grossPrice to set
	 */
	public void setGrossPrice(double grossPrice) {
		this.grossPrice = grossPrice;
	}
	/**
	 * @return the bbAmount
	 */
	public double getBbAmount() {
		return bbAmount;
	}
	/**
	 * @param bbAmount the bbAmount to set
	 */
	public void setBbAmount(double bbAmount) {
		this.bbAmount = bbAmount;
	}
	/**
	 * @return the coopAmt
	 */
	public double getCoopAmt() {
		return coopAmt;
	}
	/**
	 * @param coopAmt the coopAmt to set
	 */
	public void setCoopAmt(double coopAmt) {
		this.coopAmt = coopAmt;
	}
	/**
	 * @return the discountAmt
	 */
	public double getDiscountAmt() {
		return discountAmt;
	}
	/**
	 * @param discountAmt the discountAmt to set
	 */
	public void setDiscountAmt(double discountAmt) {
		this.discountAmt = discountAmt;
	}
	/**
	 * @return the discType
	 */
	public String getDiscType() {
		return discType;
	}
	/**
	 * @param discType the discType to set
	 */
	public void setDiscType(String discType) {
		this.discType = discType;
	}
	/**
	 * @return the commAType
	 */
	public String getCommAType() {
		return commAType;
	}
	/**
	 * @param commAType the commAType to set
	 */
	public void setCommAType(String commAType) {
		this.commAType = commAType;
	}
	/**
	 * @return the commAmt
	 */
	public double getCommAmt() {
		return commAmt;
	}
	/**
	 * @param commAmt the commAmt to set
	 */
	public void setCommAmt(double commAmt) {
		this.commAmt = commAmt;
	}
	/**
	 * @return the commType
	 */
	public String getCommType() {
		return commType;
	}
	/**
	 * @param commType the commType to set
	 */
	public void setCommType(String commType) {
		this.commType = commType;
	}
	/**
	 * @return the commVolume
	 */
	public double getCommVolume() {
		return commVolume;
	}
	/**
	 * @param commVolume the commVolume to set
	 */
	public void setCommVolume(double commVolume) {
		this.commVolume = commVolume;
	}
	/**
	 * @return the commEarned
	 */
	public double getCommEarned() {
		return commEarned;
	}
	/**
	 * @param commEarned the commEarned to set
	 */
	public void setCommEarned(double commEarned) {
		this.commEarned = commEarned;
	}
	/**
	 * @return the commableAmt
	 */
	public double getCommableAmt() {
		return commableAmt;
	}
	/**
	 * @param commableAmt the commableAmt to set
	 */
	public void setCommableAmt(double commableAmt) {
		this.commableAmt = commableAmt;
	}
	/**
	 * @return the commGrossNet
	 */
	public String getCommGrossNet() {
		return commGrossNet;
	}
	/**
	 * @param commGrossNet the commGrossNet to set
	 */
	public void setCommGrossNet(String commGrossNet) {
		this.commGrossNet = commGrossNet;
	}
	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	/**
	 * @return the netPrice
	 */
	public double getNetPrice() {
		return netPrice;
	}
	/**
	 * @param netPrice the netPrice to set
	 */
	public void setNetPrice(double netPrice) {
		this.netPrice = netPrice;
	}
	/**
	 * @return the extension
	 */
	public double getExtension() {
		return extension;
	}
	/**
	 * @param extension the extension to set
	 */
	public void setExtension(double extension) {
		this.extension = extension;
	}
	/**
	 * @return the restockCharge
	 */
	public double getRestockCharge() {
		return restockCharge;
	}
	/**
	 * @param restockCharge the restockCharge to set
	 */
	public void setRestockCharge(double restockCharge) {
		this.restockCharge = restockCharge;
	}
	/**
	 * @return the damaged
	 */
	public String getDamaged() {
		return damaged;
	}
	/**
	 * @param damaged the damaged to set
	 */
	public void setDamaged(String damaged) {
		this.damaged = damaged;
	}
	/**
	 * @return the requestDate
	 */
	public String getRequestDate() {
		return requestDate;
	}
	/**
	 * @param requestDate the requestDate to set
	 */
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	/**
	 * @return the serialItem
	 */
	public String getSerialItem() {
		return serialItem;
	}
	/**
	 * @param serialItem the serialItem to set
	 */
	public void setSerialItem(String serialItem) {
		this.serialItem = serialItem;
	}
	/**
	 * @return the serialNum
	 */
	public String getSerialNum() {
		return serialNum;
	}
	/**
	 * @param serialNum the serialNum to set
	 */
	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}
	/**
	 * @return the promoCode
	 */
	public String getPromoCode() {
		return promoCode;
	}
	/**
	 * @param promoCode the promoCode to set
	 */
	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}
	/**
	 * @return the palletDesc
	 */
	public String getPalletDesc() {
		return palletDesc;
	}
	/**
	 * @param palletDesc the palletDesc to set
	 */
	public void setPalletDesc(String palletDesc) {
		this.palletDesc = palletDesc;
	}
	/**
	 * @return the oldOrdered
	 */
	public double getOldOrdered() {
		return oldOrdered;
	}
	/**
	 * @param oldOrdered the oldOrdered to set
	 */
	public void setOldOrdered(double oldOrdered) {
		this.oldOrdered = oldOrdered;
	}
	/**
	 * @return the oldCommitted
	 */
	public double getOldCommitted() {
		return oldCommitted;
	}
	/**
	 * @param oldCommitted the oldCommitted to set
	 */
	public void setOldCommitted(double oldCommitted) {
		this.oldCommitted = oldCommitted;
	}
	/**
	 * @return the taxGrp1
	 */
	public String getTaxGrp1() {
		return taxGrp1;
	}
	/**
	 * @param taxGrp1 the taxGrp1 to set
	 */
	public void setTaxGrp1(String taxGrp1) {
		this.taxGrp1 = taxGrp1;
	}
	/**
	 * @return the taxGrp2
	 */
	public String getTaxGrp2() {
		return taxGrp2;
	}
	/**
	 * @param taxGrp2 the taxGrp2 to set
	 */
	public void setTaxGrp2(String taxGrp2) {
		this.taxGrp2 = taxGrp2;
	}
	/**
	 * @return the tax1Amt
	 */
	public double getTax1Amt() {
		return tax1Amt;
	}
	/**
	 * @param tax1Amt the tax1Amt to set
	 */
	public void setTax1Amt(double tax1Amt) {
		this.tax1Amt = tax1Amt;
	}
	/**
	 * @return the tax2Amt
	 */
	public double getTax2Amt() {
		return tax2Amt;
	}
	/**
	 * @param tax2Amt the tax2Amt to set
	 */
	public void setTax2Amt(double tax2Amt) {
		this.tax2Amt = tax2Amt;
	}
	/**
	 * @return the taxable
	 */
	public String getTaxable() {
		return taxable;
	}
	/**
	 * @param taxable the taxable to set
	 */
	public void setTaxable(String taxable) {
		this.taxable = taxable;
	}
	/**
	 * @return the bin
	 */
	public String getBin() {
		return bin;
	}
	/**
	 * @param bin the bin to set
	 */
	public void setBin(String bin) {
		this.bin = bin;
	}
	/**
	 * @return the groupCode
	 */
	public String getGroupCode() {
		return groupCode;
	}
	/**
	 * @param groupCode the groupCode to set
	 */
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	/**
	 * @return the kitItem
	 */
	public String getKitItem() {
		return kitItem;
	}
	/**
	 * @param kitItem the kitItem to set
	 */
	public void setKitItem(String kitItem) {
		this.kitItem = kitItem;
	}
	/**
	 * @return the compOption
	 */
	public String getCompOption() {
		return compOption;
	}
	/**
	 * @param compOption the compOption to set
	 */
	public void setCompOption(String compOption) {
		this.compOption = compOption;
	}
	/**
	 * @return the reviewKit
	 */
	public String getReviewKit() {
		return reviewKit;
	}
	/**
	 * @param reviewKit the reviewKit to set
	 */
	public void setReviewKit(String reviewKit) {
		this.reviewKit = reviewKit;
	}
	/**
	 * @return the printKit
	 */
	public String getPrintKit() {
		return printKit;
	}
	/**
	 * @param printKit the printKit to set
	 */
	public void setPrintKit(String printKit) {
		this.printKit = printKit;
	}
	/**
	 * @return the printComp
	 */
	public String getPrintComp() {
		return printComp;
	}
	/**
	 * @param printComp the printComp to set
	 */
	public void setPrintComp(String printComp) {
		this.printComp = printComp;
	}
	/**
	 * @return the compSeqPps
	 */
	public String getCompSeqPps() {
		return compSeqPps;
	}
	/**
	 * @param compSeqPps the compSeqPps to set
	 */
	public void setCompSeqPps(String compSeqPps) {
		this.compSeqPps = compSeqPps;
	}
	/**
	 * @return the custItemNum
	 */
	public String getCustItemNum() {
		return custItemNum;
	}
	/**
	 * @param custItemNum the custItemNum to set
	 */
	public void setCustItemNum(String custItemNum) {
		this.custItemNum = custItemNum;
	}
	/**
	 * @return the interItemNum
	 */
	public String getInterItemNum() {
		return interItemNum;
	}
	/**
	 * @param interItemNum the interItemNum to set
	 */
	public void setInterItemNum(String interItemNum) {
		this.interItemNum = interItemNum;
	}
	/**
	 * @return the subbedItemNum
	 */
	public String getSubbedItemNum() {
		return subbedItemNum;
	}
	/**
	 * @param subbedItemNum the subbedItemNum to set
	 */
	public void setSubbedItemNum(String subbedItemNum) {
		this.subbedItemNum = subbedItemNum;
	}
	/**
	 * @return the nsReq
	 */
	public String getNsReq() {
		return nsReq;
	}
	/**
	 * @param nsReq the nsReq to set
	 */
	public void setNsReq(String nsReq) {
		this.nsReq = nsReq;
	}
	/**
	 * @return the multiplier
	 */
	public double getMultiplier() {
		return multiplier;
	}
	/**
	 * @param multiplier the multiplier to set
	 */
	public void setMultiplier(double multiplier) {
		this.multiplier = multiplier;
	}
	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}
	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	/**
	 * @return the discountCas
	 */
	public double getDiscountCas() {
		return discountCas;
	}
	/**
	 * @param discountCas the discountCas to set
	 */
	public void setDiscountCas(double discountCas) {
		this.discountCas = discountCas;
	}
	/**
	 * @return the discountMax
	 */
	public double getDiscountMax() {
		return discountMax;
	}
	/**
	 * @param discountMax the discountMax to set
	 */
	public void setDiscountMax(double discountMax) {
		this.discountMax = discountMax;
	}
	/**
	 * @return the idSuperpedido
	 */
	public long getIdSuperpedido() {
		return idSuperpedido;
	}
	/**
	 * @param idSuperpedido the idSuperpedido to set
	 */
	public void setIdSuperpedido(long idSuperpedido) {
		this.idSuperpedido = idSuperpedido;
	}
	/**
	 * @return the condicion
	 */
	public String getCondicion() {
		return condicion;
	}
	/**
	 * @param condicion the condicion to set
	 */
	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}
	/**
	 * @return the tipoArticulo
	 */
	public String getTipoArticulo() {
		return tipoArticulo;
	}
	/**
	 * @param tipoArticulo the tipoArticulo to set
	 */
	public void setTipoArticulo(String tipoArticulo) {
		this.tipoArticulo = tipoArticulo;
	}
	/**
	 * @return the fam
	 */
	public String getFam() {
		return fam;
	}
	/**
	 * @param fam the fam to set
	 */
	public void setFam(String fam) {
		this.fam = fam;
	}
	/**
	 * @return the ensId
	 */
	public int getEnsId() {
		return ensId;
	}
	/**
	 * @param ensId the ensId to set
	 */
	public void setEnsId(int ensId) {
		this.ensId = ensId;
	}
	/**
	 * @return the porPronto
	 */
	public double getPorPronto() {
		return porPronto;
	}
	/**
	 * @param porPronto the porPronto to set
	 */
	public void setPorPronto(double porPronto) {
		this.porPronto = porPronto;
	}
	/**
	 * @return the pronto
	 */
	public String getPronto() {
		return pronto;
	}
	/**
	 * @param pronto the pronto to set
	 */
	public void setPronto(String pronto) {
		this.pronto = pronto;
	}
	/**
	 * @return the lastCostO
	 */
	public double getLastCostO() {
		return lastCostO;
	}
	/**
	 * @param lastCostO the lastCostO to set
	 */
	public void setLastCostO(double lastCostO) {
		this.lastCostO = lastCostO;
	}
	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}
	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}
	/**
	 * @return the ventaUsd
	 */
	public String getVentaUsd() {
		return ventaUsd;
	}
	/**
	 * @param ventaUsd the ventaUsd to set
	 */
	public void setVentaUsd(String ventaUsd) {
		this.ventaUsd = ventaUsd;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "OrderL [orgCode=" + orgCode + ", divCode=" + divCode + ", whseCode=" + whseCode + ", invoiceNum="
				+ invoiceNum + ", orderNum=" + orderNum + ", lineNum=" + lineNum + ", terminalNum=" + terminalNum
				+ ", boNum=" + boNum + ", itemNum=" + itemNum + ", sortName=" + sortName + ", dropShip=" + dropShip
				+ ", binLocation=" + binLocation + ", nonStock=" + nonStock + ", description=" + description
				+ ", packDesc=" + packDesc + ", sizeDesc=" + sizeDesc + ", memo=" + memo + ", sellUom=" + sellUom
				+ ", sellingMultiplier=" + sellingMultiplier + ", priceUom=" + priceUom + ", priceMultiplier="
				+ priceMultiplier + ", qtyOrdered=" + qtyOrdered + ", qtyCommitted=" + qtyCommitted + ", qtyShipped="
				+ qtyShipped + ", qtyBo=" + qtyBo + ", weight=" + weight + ", volume=" + volume + ", grossPrice="
				+ grossPrice + ", bbAmount=" + bbAmount + ", coopAmt=" + coopAmt + ", discountAmt=" + discountAmt
				+ ", discType=" + discType + ", commAType=" + commAType + ", commAmt=" + commAmt + ", commType="
				+ commType + ", commVolume=" + commVolume + ", commEarned=" + commEarned + ", commableAmt="
				+ commableAmt + ", commGrossNet=" + commGrossNet + ", cost=" + cost + ", netPrice=" + netPrice
				+ ", extension=" + extension + ", restockCharge=" + restockCharge + ", damaged=" + damaged
				+ ", requestDate=" + requestDate + ", serialItem=" + serialItem + ", serialNum=" + serialNum
				+ ", promoCode=" + promoCode + ", palletDesc=" + palletDesc + ", oldOrdered=" + oldOrdered
				+ ", oldCommitted=" + oldCommitted + ", taxGrp1=" + taxGrp1 + ", taxGrp2=" + taxGrp2 + ", tax1Amt="
				+ tax1Amt + ", tax2Amt=" + tax2Amt + ", taxable=" + taxable + ", bin=" + bin + ", groupCode="
				+ groupCode + ", kitItem=" + kitItem + ", compOption=" + compOption + ", reviewKit=" + reviewKit
				+ ", printKit=" + printKit + ", printComp=" + printComp + ", compSeqPps=" + compSeqPps
				+ ", custItemNum=" + custItemNum + ", interItemNum=" + interItemNum + ", subbedItemNum=" + subbedItemNum
				+ ", nsReq=" + nsReq + ", multiplier=" + multiplier + ", symbol=" + symbol + ", discountCas="
				+ discountCas + ", discountMax=" + discountMax + ", idSuperpedido=" + idSuperpedido + ", condicion="
				+ condicion + ", tipoArticulo=" + tipoArticulo + ", fam=" + fam + ", ensId=" + ensId + ", porPronto="
				+ porPronto + ", pronto=" + pronto + ", lastCostO=" + lastCostO + ", num=" + num + ", ventaUsd="
				+ ventaUsd + ", desc=" + desc + "]";
	}
	
	
	
	
}
