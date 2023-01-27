package com.pedidos.api.model;


import java.util.List;

public class OrderH {

	private String orgCode;
	private String divCode;
	private long orderNum;
	private String reference;
	private long boNum;
	private long invoiceNum;
	private long document;
	private String billNum;
	private String billDate;
	private String transType;
	private String opCommit;
	private String coopCode;
	private long custNum;
	private String bName;
	private String bAdd1;
	private String bAdd2;
	private String bCity;
	private String bProvince;
	private String bCountry;
	private String bPostalCode;
	private String saCust;
	private String opContact;
	private String customerPo;
	private String poDate;
	private int chargeTo;
	private int shipNum;
	private String sName;
	private String sAdd1;
	private String sAdd2;
	private String sCity;
	private String sProvince;
	private String sCountry;
	private String sPostalCode;
	private String orderDate;
	private String shipDate;
	private String requestDate;
	private String cancelDate;
	private int priceLevel;
	private String terminalNum;
	private String shipVia;
	private String userCode;
	private String slmn1;
	private int comm1;
	private String slmn2;
	private int comm2;
	private String slmn3;
	private int comm3;
	private String slmn4;
	private int comm4;
	private String ppdColl;
	private String fobDesc;
	private String termCode;
	private String discType;
	private double discount;
	private String arContact;
	private double totalWeight;
	private double totalVolume;
	private String memo;
	private String whseCode;
	private String creditCard;
	private String cardNumber;
	private String expiryDate;
	private String auth;
	private String ppsPrice;
	private double restockingCharge;
	private String stockCommitted;
	private double grossAmount;
	private double netAmount;
	private double totalDiscount;
	private double addCharges;
	private double cost;
	private double commableAmt;
	private double commEarned;
	private double possibleDisc;
	private String discDate;
	private String orderCode;
	private String dueDate;
	private int numPpsPrinted;
	private String invDate;
	private String confPrinted;
	private String orderRegister;
	private String ppsPrinted;
	private String lastPpsDate;
	private String holdOrder;
	private String creditAuthority;
	private String orderStatus;
	private String saUpdated;
	private String invRegister;
	private String canDate;
	private String cancelCode;
	private String shipStats;
	private String arAccount;
	private int qtyPallets;
	private String truckNum;
	private String cpcNum;
	private String appDate;
	private String appTime;
	private String appDoor;
	private int bidNum;
	private String taxRegion;
	private String licence1;
	private String licence2;
	private double tax1Amt;
	private double tax2Amt;
	private String taxStatus;
	private String orderType;
	private String delMethod;
	private String updInventory;
	private String inUseUser;
	private String inUseTerminal;
	private String prevStatus;
	private double discountCas;
	private String condicion;
	private String tipoArticulo;
	private long idSuperpedido;
	private String mensaje;
	private String ruta;
	private String horaRuta;
	private String permiteBo;
	private String entregaTotal;
	private double anticipo;
	private String horaCredito;
	private String horaAlmacen;
	private String autAlmacen;
	private double currMultiplier;
	private String horaReserva;
	private String creditPreAuth;
	private String fechaEntrega;
	private String horarioEntrega;
	private int motivoCode;

	private List<OrderL> listOrderL;

	/**
	 * 
	 */
	public OrderH() {
		super();
	}

	/**
	 * @param orgCode
	 * @param divCode
	 * @param orderNum
	 */
	public OrderH(String orgCode, String divCode, long orderNum) {
		super();
		this.orgCode = orgCode;
		this.divCode = divCode;
		this.orderNum = orderNum;
	}

	public OrderH(String orgCode, String divCode, long idSuperpedido, String shipVia, String ppdColl) {
		this.orgCode = orgCode;
		this.divCode = divCode;
		this.idSuperpedido = idSuperpedido;
		this.shipVia = shipVia;
		this.ppdColl = ppdColl;
	}

	/**
	 * @return the orgCode
	 */
	public String getOrgCode() {
		return orgCode;
	}

	/**
	 * @param orgCode
	 *            the orgCode to set
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
	 * @param divCode
	 *            the divCode to set
	 */
	public void setDivCode(String divCode) {
		this.divCode = divCode;
	}

	/**
	 * @return the orderNum
	 */
	public long getOrderNum() {
		return orderNum;
	}

	/**
	 * @param orderNum
	 *            the orderNum to set
	 */
	public void setOrderNum(long orderNum) {
		this.orderNum = orderNum;
	}

	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * @param reference
	 *            the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * @return the boNum
	 */
	public long getBoNum() {
		return boNum;
	}

	/**
	 * @param boNum
	 *            the boNum to set
	 */
	public void setBoNum(long boNum) {
		this.boNum = boNum;
	}

	/**
	 * @return the invoiceNum
	 */
	public long getInvoiceNum() {
		return invoiceNum;
	}

	/**
	 * @param invoiceNum
	 *            the invoiceNum to set
	 */
	public void setInvoiceNum(long invoiceNum) {
		this.invoiceNum = invoiceNum;
	}

	/**
	 * @return the document
	 */
	public long getDocument() {
		return document;
	}

	/**
	 * @param document
	 *            the document to set
	 */
	public void setDocument(long document) {
		this.document = document;
	}

	/**
	 * @return the billNum
	 */
	public String getBillNum() {
		return billNum;
	}

	/**
	 * @param billNum
	 *            the billNum to set
	 */
	public void setBillNum(String billNum) {
		this.billNum = billNum;
	}

	/**
	 * @return the billDate
	 */
	public String getBillDate() {
		return billDate;
	}

	/**
	 * @param billDate
	 *            the billDate to set
	 */
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	/**
	 * @return the transType
	 */
	public String getTransType() {
		return transType;
	}

	/**
	 * @param transType
	 *            the transType to set
	 */
	public void setTransType(String transType) {
		this.transType = transType;
	}

	/**
	 * @return the opCommit
	 */
	public String getOpCommit() {
		return opCommit;
	}

	/**
	 * @param opCommit
	 *            the opCommit to set
	 */
	public void setOpCommit(String opCommit) {
		this.opCommit = opCommit;
	}

	/**
	 * @return the coopCode
	 */
	public String getCoopCode() {
		return coopCode;
	}

	/**
	 * @param coopCode
	 *            the coopCode to set
	 */
	public void setCoopCode(String coopCode) {
		this.coopCode = coopCode;
	}

	/**
	 * @return the custNum
	 */
	public long getCustNum() {
		return custNum;
	}

	/**
	 * @param custNum
	 *            the custNum to set
	 */
	public void setCustNum(long custNum) {
		this.custNum = custNum;
	}

	/**
	 * @return the bName
	 */
	public String getbName() {
		return bName;
	}

	/**
	 * @param bName
	 *            the bName to set
	 */
	public void setbName(String bName) {
		this.bName = bName;
	}

	/**
	 * @return the bAdd1
	 */
	public String getbAdd1() {
		return bAdd1;
	}

	/**
	 * @param bAdd1
	 *            the bAdd1 to set
	 */
	public void setbAdd1(String bAdd1) {
		this.bAdd1 = bAdd1;
	}

	/**
	 * @return the bAdd2
	 */
	public String getbAdd2() {
		return bAdd2;
	}

	/**
	 * @param bAdd2
	 *            the bAdd2 to set
	 */
	public void setbAdd2(String bAdd2) {
		this.bAdd2 = bAdd2;
	}

	/**
	 * @return the bCity
	 */
	public String getbCity() {
		return bCity;
	}

	/**
	 * @param bCity
	 *            the bCity to set
	 */
	public void setbCity(String bCity) {
		this.bCity = bCity;
	}

	/**
	 * @return the bProvince
	 */
	public String getbProvince() {
		return bProvince;
	}

	/**
	 * @param bProvince
	 *            the bProvince to set
	 */
	public void setbProvince(String bProvince) {
		this.bProvince = bProvince;
	}

	/**
	 * @return the bCountry
	 */
	public String getbCountry() {
		return bCountry;
	}

	/**
	 * @param bCountry
	 *            the bCountry to set
	 */
	public void setbCountry(String bCountry) {
		this.bCountry = bCountry;
	}

	/**
	 * @return the bPostalCode
	 */
	public String getbPostalCode() {
		return bPostalCode;
	}

	/**
	 * @param bPostalCode
	 *            the bPostalCode to set
	 */
	public void setbPostalCode(String bPostalCode) {
		this.bPostalCode = bPostalCode;
	}

	/**
	 * @return the saCust
	 */
	public String getSaCust() {
		return saCust;
	}

	/**
	 * @param saCust
	 *            the saCust to set
	 */
	public void setSaCust(String saCust) {
		this.saCust = saCust;
	}

	/**
	 * @return the opContact
	 */
	public String getOpContact() {
		return opContact;
	}

	/**
	 * @param opContact
	 *            the opContact to set
	 */
	public void setOpContact(String opContact) {
		this.opContact = opContact;
	}

	/**
	 * @return the customerPo
	 */
	public String getCustomerPo() {
		return customerPo;
	}

	/**
	 * @param customerPo
	 *            the customerPo to set
	 */
	public void setCustomerPo(String customerPo) {
		this.customerPo = customerPo;
	}

	/**
	 * @return the poDate
	 */
	public String getPoDate() {
		return poDate;
	}

	/**
	 * @param poDate
	 *            the poDate to set
	 */
	public void setPoDate(String poDate) {
		this.poDate = poDate;
	}

	/**
	 * @return the chargeTo
	 */
	public int getChargeTo() {
		return chargeTo;
	}

	/**
	 * @param chargeTo
	 *            the chargeTo to set
	 */
	public void setChargeTo(int chargeTo) {
		this.chargeTo = chargeTo;
	}

	/**
	 * @return the shipNum
	 */
	public int getShipNum() {
		return shipNum;
	}

	/**
	 * @param shipNum
	 *            the shipNum to set
	 */
	public void setShipNum(int shipNum) {
		this.shipNum = shipNum;
	}

	/**
	 * @return the sName
	 */
	public String getsName() {
		return sName;
	}

	/**
	 * @param sName
	 *            the sName to set
	 */
	public void setsName(String sName) {
		this.sName = sName;
	}

	/**
	 * @return the sAdd1
	 */
	public String getsAdd1() {
		return sAdd1;
	}

	/**
	 * @param sAdd1
	 *            the sAdd1 to set
	 */
	public void setsAdd1(String sAdd1) {
		this.sAdd1 = sAdd1;
	}

	/**
	 * @return the sAdd2
	 */
	public String getsAdd2() {
		return sAdd2;
	}

	/**
	 * @param sAdd2
	 *            the sAdd2 to set
	 */
	public void setsAdd2(String sAdd2) {
		this.sAdd2 = sAdd2;
	}

	/**
	 * @return the sCity
	 */
	public String getsCity() {
		return sCity;
	}

	/**
	 * @param sCity
	 *            the sCity to set
	 */
	public void setsCity(String sCity) {
		this.sCity = sCity;
	}

	/**
	 * @return the sProvince
	 */
	public String getsProvince() {
		return sProvince;
	}

	/**
	 * @param sProvince
	 *            the sProvince to set
	 */
	public void setsProvince(String sProvince) {
		this.sProvince = sProvince;
	}

	/**
	 * @return the sCountry
	 */
	public String getsCountry() {
		return sCountry;
	}

	/**
	 * @param sCountry
	 *            the sCountry to set
	 */
	public void setsCountry(String sCountry) {
		this.sCountry = sCountry;
	}

	/**
	 * @return the sPostalCode
	 */
	public String getsPostalCode() {
		return sPostalCode;
	}

	/**
	 * @param sPostalCode
	 *            the sPostalCode to set
	 */
	public void setsPostalCode(String sPostalCode) {
		this.sPostalCode = sPostalCode;
	}

	/**
	 * @return the orderDate
	 */
	public String getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate
	 *            the orderDate to set
	 */
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the shipDate
	 */
	public String getShipDate() {
		return shipDate;
	}

	/**
	 * @param shipDate
	 *            the shipDate to set
	 */
	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}

	/**
	 * @return the requestDate
	 */
	public String getRequestDate() {
		return requestDate;
	}

	/**
	 * @param requestDate
	 *            the requestDate to set
	 */
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	/**
	 * @return the cancelDate
	 */
	public String getCancelDate() {
		return cancelDate;
	}

	/**
	 * @param cancelDate
	 *            the cancelDate to set
	 */
	public void setCancelDate(String cancelDate) {
		this.cancelDate = cancelDate;
	}

	/**
	 * @return the priceLevel
	 */
	public int getPriceLevel() {
		return priceLevel;
	}

	/**
	 * @param priceLevel
	 *            the priceLevel to set
	 */
	public void setPriceLevel(int priceLevel) {
		this.priceLevel = priceLevel;
	}

	/**
	 * @return the terminalNum
	 */
	public String getTerminalNum() {
		return terminalNum;
	}

	/**
	 * @param terminalNum
	 *            the terminalNum to set
	 */
	public void setTerminalNum(String terminalNum) {
		this.terminalNum = terminalNum;
	}

	/**
	 * @return the shipVia
	 */
	public String getShipVia() {
		return shipVia;
	}

	/**
	 * @param shipVia
	 *            the shipVia to set
	 */
	public void setShipVia(String shipVia) {
		this.shipVia = shipVia;
	}

	/**
	 * @return the userCode
	 */
	public String getUserCode() {
		return userCode;
	}

	/**
	 * @param userCode
	 *            the userCode to set
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	/**
	 * @return the slmn1
	 */
	public String getSlmn1() {
		return slmn1;
	}

	/**
	 * @param slmn1
	 *            the slmn1 to set
	 */
	public void setSlmn1(String slmn1) {
		this.slmn1 = slmn1;
	}

	/**
	 * @return the comm1
	 */
	public int getComm1() {
		return comm1;
	}

	/**
	 * @param comm1
	 *            the comm1 to set
	 */
	public void setComm1(int comm1) {
		this.comm1 = comm1;
	}

	/**
	 * @return the slmn2
	 */
	public String getSlmn2() {
		return slmn2;
	}

	/**
	 * @param slmn2
	 *            the slmn2 to set
	 */
	public void setSlmn2(String slmn2) {
		this.slmn2 = slmn2;
	}

	/**
	 * @return the comm2
	 */
	public int getComm2() {
		return comm2;
	}

	/**
	 * @param comm2
	 *            the comm2 to set
	 */
	public void setComm2(int comm2) {
		this.comm2 = comm2;
	}

	/**
	 * @return the slmn3
	 */
	public String getSlmn3() {
		return slmn3;
	}

	/**
	 * @param slmn3
	 *            the slmn3 to set
	 */
	public void setSlmn3(String slmn3) {
		this.slmn3 = slmn3;
	}

	/**
	 * @return the comm3
	 */
	public int getComm3() {
		return comm3;
	}

	/**
	 * @param comm3
	 *            the comm3 to set
	 */
	public void setComm3(int comm3) {
		this.comm3 = comm3;
	}

	/**
	 * @return the slmn4
	 */
	public String getSlmn4() {
		return slmn4;
	}

	/**
	 * @param slmn4
	 *            the slmn4 to set
	 */
	public void setSlmn4(String slmn4) {
		this.slmn4 = slmn4;
	}

	/**
	 * @return the comm4
	 */
	public int getComm4() {
		return comm4;
	}

	/**
	 * @param comm4
	 *            the comm4 to set
	 */
	public void setComm4(int comm4) {
		this.comm4 = comm4;
	}

	/**
	 * @return the ppdColl
	 */
	public String getPpdColl() {
		return ppdColl;
	}

	/**
	 * @param ppdColl
	 *            the ppdColl to set
	 */
	public void setPpdColl(String ppdColl) {
		this.ppdColl = ppdColl;
	}

	/**
	 * @return the fobDesc
	 */
	public String getFobDesc() {
		return fobDesc;
	}

	/**
	 * @param fobDesc
	 *            the fobDesc to set
	 */
	public void setFobDesc(String fobDesc) {
		this.fobDesc = fobDesc;
	}

	/**
	 * @return the termCode
	 */
	public String getTermCode() {
		return termCode;
	}

	/**
	 * @param termCode
	 *            the termCode to set
	 */
	public void setTermCode(String termCode) {
		this.termCode = termCode;
	}

	/**
	 * @return the discType
	 */
	public String getDiscType() {
		return discType;
	}

	/**
	 * @param discType
	 *            the discType to set
	 */
	public void setDiscType(String discType) {
		this.discType = discType;
	}

	/**
	 * @return the discount
	 */
	public double getDiscount() {
		return discount;
	}

	/**
	 * @param discount
	 *            the discount to set
	 */
	public void setDiscount(double discount) {
		this.discount = discount;
	}

	/**
	 * @return the arContact
	 */
	public String getArContact() {
		return arContact;
	}

	/**
	 * @param arContact
	 *            the arContact to set
	 */
	public void setArContact(String arContact) {
		this.arContact = arContact;
	}

	/**
	 * @return the totalWeight
	 */
	public double getTotalWeight() {
		return totalWeight;
	}

	/**
	 * @param totalWeight
	 *            the totalWeight to set
	 */
	public void setTotalWeight(double totalWeight) {
		this.totalWeight = totalWeight;
	}

	/**
	 * @return the totalVolume
	 */
	public double getTotalVolume() {
		return totalVolume;
	}

	/**
	 * @param totalVolume
	 *            the totalVolume to set
	 */
	public void setTotalVolume(double totalVolume) {
		this.totalVolume = totalVolume;
	}

	/**
	 * @return the memo
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * @param memo
	 *            the memo to set
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * @return the whseCode
	 */
	public String getWhseCode() {
		return whseCode;
	}

	/**
	 * @param whseCode
	 *            the whseCode to set
	 */
	public void setWhseCode(String whseCode) {
		this.whseCode = whseCode;
	}

	/**
	 * @return the creditCard
	 */
	public String getCreditCard() {
		return creditCard;
	}

	/**
	 * @param creditCard
	 *            the creditCard to set
	 */
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber
	 *            the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * @return the expiryDate
	 */
	public String getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param expiryDate
	 *            the expiryDate to set
	 */
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the auth
	 */
	public String getAuth() {
		return auth;
	}

	/**
	 * @param auth
	 *            the auth to set
	 */
	public void setAuth(String auth) {
		this.auth = auth;
	}

	/**
	 * @return the ppsPrice
	 */
	public String getPpsPrice() {
		return ppsPrice;
	}

	/**
	 * @param ppsPrice
	 *            the ppsPrice to set
	 */
	public void setPpsPrice(String ppsPrice) {
		this.ppsPrice = ppsPrice;
	}

	/**
	 * @return the restockingCharge
	 */
	public double getRestockingCharge() {
		return restockingCharge;
	}

	/**
	 * @param restockingCharge
	 *            the restockingCharge to set
	 */
	public void setRestockingCharge(double restockingCharge) {
		this.restockingCharge = restockingCharge;
	}

	/**
	 * @return the stockCommitted
	 */
	public String getStockCommitted() {
		return stockCommitted;
	}

	/**
	 * @param stockCommitted
	 *            the stockCommitted to set
	 */
	public void setStockCommitted(String stockCommitted) {
		this.stockCommitted = stockCommitted;
	}

	/**
	 * @return the grossAmount
	 */
	public double getGrossAmount() {
		return grossAmount;
	}

	/**
	 * @param grossAmount
	 *            the grossAmount to set
	 */
	public void setGrossAmount(double grossAmount) {
		this.grossAmount = grossAmount;
	}

	/**
	 * @return the netAmount
	 */
	public double getNetAmount() {
		return netAmount;
	}

	/**
	 * @param netAmount
	 *            the netAmount to set
	 */
	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}

	/**
	 * @return the totalDiscount
	 */
	public double getTotalDiscount() {
		return totalDiscount;
	}

	/**
	 * @param totalDiscount
	 *            the totalDiscount to set
	 */
	public void setTotalDiscount(double totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	/**
	 * @return the addCharges
	 */
	public double getAddCharges() {
		return addCharges;
	}

	/**
	 * @param addCharges
	 *            the addCharges to set
	 */
	public void setAddCharges(double addCharges) {
		this.addCharges = addCharges;
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param cost
	 *            the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * @return the commableAmt
	 */
	public double getCommableAmt() {
		return commableAmt;
	}

	/**
	 * @param commableAmt
	 *            the commableAmt to set
	 */
	public void setCommableAmt(double commableAmt) {
		this.commableAmt = commableAmt;
	}

	/**
	 * @return the commEarned
	 */
	public double getCommEarned() {
		return commEarned;
	}

	/**
	 * @param commEarned
	 *            the commEarned to set
	 */
	public void setCommEarned(double commEarned) {
		this.commEarned = commEarned;
	}

	/**
	 * @return the possibleDisc
	 */
	public double getPossibleDisc() {
		return possibleDisc;
	}

	/**
	 * @param possibleDisc
	 *            the possibleDisc to set
	 */
	public void setPossibleDisc(double possibleDisc) {
		this.possibleDisc = possibleDisc;
	}

	/**
	 * @return the discDate
	 */
	public String getDiscDate() {
		return discDate;
	}

	/**
	 * @param discDate
	 *            the discDate to set
	 */
	public void setDiscDate(String discDate) {
		this.discDate = discDate;
	}

	/**
	 * @return the orderCode
	 */
	public String getOrderCode() {
		return orderCode;
	}

	/**
	 * @param orderCode
	 *            the orderCode to set
	 */
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	/**
	 * @return the dueDate
	 */
	public String getDueDate() {
		return dueDate;
	}

	/**
	 * @param dueDate
	 *            the dueDate to set
	 */
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * @return the numPpsPrinted
	 */
	public int getNumPpsPrinted() {
		return numPpsPrinted;
	}

	/**
	 * @param numPpsPrinted
	 *            the numPpsPrinted to set
	 */
	public void setNumPpsPrinted(int numPpsPrinted) {
		this.numPpsPrinted = numPpsPrinted;
	}

	/**
	 * @return the invDate
	 */
	public String getInvDate() {
		return invDate;
	}

	/**
	 * @param invDate
	 *            the invDate to set
	 */
	public void setInvDate(String invDate) {
		this.invDate = invDate;
	}

	/**
	 * @return the confPrinted
	 */
	public String getConfPrinted() {
		return confPrinted;
	}

	/**
	 * @param confPrinted
	 *            the confPrinted to set
	 */
	public void setConfPrinted(String confPrinted) {
		this.confPrinted = confPrinted;
	}

	/**
	 * @return the orderRegister
	 */
	public String getOrderRegister() {
		return orderRegister;
	}

	/**
	 * @param orderRegister
	 *            the orderRegister to set
	 */
	public void setOrderRegister(String orderRegister) {
		this.orderRegister = orderRegister;
	}

	/**
	 * @return the ppsPrinted
	 */
	public String getPpsPrinted() {
		return ppsPrinted;
	}

	/**
	 * @param ppsPrinted
	 *            the ppsPrinted to set
	 */
	public void setPpsPrinted(String ppsPrinted) {
		this.ppsPrinted = ppsPrinted;
	}

	/**
	 * @return the lastPpsDate
	 */
	public String getLastPpsDate() {
		return lastPpsDate;
	}

	/**
	 * @param lastPpsDate
	 *            the lastPpsDate to set
	 */
	public void setLastPpsDate(String lastPpsDate) {
		this.lastPpsDate = lastPpsDate;
	}

	/**
	 * @return the holdOrder
	 */
	public String getHoldOrder() {
		return holdOrder;
	}

	/**
	 * @param holdOrder
	 *            the holdOrder to set
	 */
	public void setHoldOrder(String holdOrder) {
		this.holdOrder = holdOrder;
	}

	/**
	 * @return the creditAuthority
	 */
	public String getCreditAuthority() {
		return creditAuthority;
	}

	/**
	 * @param creditAuthority
	 *            the creditAuthority to set
	 */
	public void setCreditAuthority(String creditAuthority) {
		this.creditAuthority = creditAuthority;
	}

	/**
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}

	/**
	 * @param orderStatus
	 *            the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * @return the saUpdated
	 */
	public String getSaUpdated() {
		return saUpdated;
	}

	/**
	 * @param saUpdated
	 *            the saUpdated to set
	 */
	public void setSaUpdated(String saUpdated) {
		this.saUpdated = saUpdated;
	}

	/**
	 * @return the invRegister
	 */
	public String getInvRegister() {
		return invRegister;
	}

	/**
	 * @param invRegister
	 *            the invRegister to set
	 */
	public void setInvRegister(String invRegister) {
		this.invRegister = invRegister;
	}

	/**
	 * @return the canDate
	 */
	public String getCanDate() {
		return canDate;
	}

	/**
	 * @param canDate
	 *            the canDate to set
	 */
	public void setCanDate(String canDate) {
		this.canDate = canDate;
	}

	/**
	 * @return the cancelCode
	 */
	public String getCancelCode() {
		return cancelCode;
	}

	/**
	 * @param cancelCode
	 *            the cancelCode to set
	 */
	public void setCancelCode(String cancelCode) {
		this.cancelCode = cancelCode;
	}

	/**
	 * @return the shipStats
	 */
	public String getShipStats() {
		return shipStats;
	}

	/**
	 * @param shipStats
	 *            the shipStats to set
	 */
	public void setShipStats(String shipStats) {
		this.shipStats = shipStats;
	}

	/**
	 * @return the arAccount
	 */
	public String getArAccount() {
		return arAccount;
	}

	/**
	 * @param arAccount
	 *            the arAccount to set
	 */
	public void setArAccount(String arAccount) {
		this.arAccount = arAccount;
	}

	/**
	 * @return the qtyPallets
	 */
	public int getQtyPallets() {
		return qtyPallets;
	}

	/**
	 * @param qtyPallets
	 *            the qtyPallets to set
	 */
	public void setQtyPallets(int qtyPallets) {
		this.qtyPallets = qtyPallets;
	}

	/**
	 * @return the truckNum
	 */
	public String getTruckNum() {
		return truckNum;
	}

	/**
	 * @param truckNum
	 *            the truckNum to set
	 */
	public void setTruckNum(String truckNum) {
		this.truckNum = truckNum;
	}

	/**
	 * @return the cpcNum
	 */
	public String getCpcNum() {
		return cpcNum;
	}

	/**
	 * @param cpcNum
	 *            the cpcNum to set
	 */
	public void setCpcNum(String cpcNum) {
		this.cpcNum = cpcNum;
	}

	/**
	 * @return the appDate
	 */
	public String getAppDate() {
		return appDate;
	}

	/**
	 * @param appDate
	 *            the appDate to set
	 */
	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}

	/**
	 * @return the appTime
	 */
	public String getAppTime() {
		return appTime;
	}

	/**
	 * @param appTime
	 *            the appTime to set
	 */
	public void setAppTime(String appTime) {
		this.appTime = appTime;
	}

	/**
	 * @return the appDoor
	 */
	public String getAppDoor() {
		return appDoor;
	}

	/**
	 * @param appDoor
	 *            the appDoor to set
	 */
	public void setAppDoor(String appDoor) {
		this.appDoor = appDoor;
	}

	/**
	 * @return the bidNum
	 */
	public int getBidNum() {
		return bidNum;
	}

	/**
	 * @param bidNum
	 *            the bidNum to set
	 */
	public void setBidNum(int bidNum) {
		this.bidNum = bidNum;
	}

	/**
	 * @return the taxRegion
	 */
	public String getTaxRegion() {
		return taxRegion;
	}

	/**
	 * @param taxRegion
	 *            the taxRegion to set
	 */
	public void setTaxRegion(String taxRegion) {
		this.taxRegion = taxRegion;
	}

	/**
	 * @return the licence1
	 */
	public String getLicence1() {
		return licence1;
	}

	/**
	 * @param licence1
	 *            the licence1 to set
	 */
	public void setLicence1(String licence1) {
		this.licence1 = licence1;
	}

	/**
	 * @return the licence2
	 */
	public String getLicence2() {
		return licence2;
	}

	/**
	 * @param licence2
	 *            the licence2 to set
	 */
	public void setLicence2(String licence2) {
		this.licence2 = licence2;
	}

	/**
	 * @return the tax1Amt
	 */
	public double getTax1Amt() {
		return tax1Amt;
	}

	/**
	 * @param tax1Amt
	 *            the tax1Amt to set
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
	 * @param tax2Amt
	 *            the tax2Amt to set
	 */
	public void setTax2Amt(double tax2Amt) {
		this.tax2Amt = tax2Amt;
	}

	/**
	 * @return the taxStatus
	 */
	public String getTaxStatus() {
		return taxStatus;
	}

	/**
	 * @param taxStatus
	 *            the taxStatus to set
	 */
	public void setTaxStatus(String taxStatus) {
		this.taxStatus = taxStatus;
	}

	/**
	 * @return the orderType
	 */
	public String getOrderType() {
		return orderType;
	}

	/**
	 * @param orderType
	 *            the orderType to set
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	/**
	 * @return the delMethod
	 */
	public String getDelMethod() {
		return delMethod;
	}

	/**
	 * @param delMethod
	 *            the delMethod to set
	 */
	public void setDelMethod(String delMethod) {
		this.delMethod = delMethod;
	}

	/**
	 * @return the updInventory
	 */
	public String getUpdInventory() {
		return updInventory;
	}

	/**
	 * @param updInventory
	 *            the updInventory to set
	 */
	public void setUpdInventory(String updInventory) {
		this.updInventory = updInventory;
	}

	/**
	 * @return the inUseUser
	 */
	public String getInUseUser() {
		return inUseUser;
	}

	/**
	 * @param inUseUser
	 *            the inUseUser to set
	 */
	public void setInUseUser(String inUseUser) {
		this.inUseUser = inUseUser;
	}

	/**
	 * @return the inUseTerminal
	 */
	public String getInUseTerminal() {
		return inUseTerminal;
	}

	/**
	 * @param inUseTerminal
	 *            the inUseTerminal to set
	 */
	public void setInUseTerminal(String inUseTerminal) {
		this.inUseTerminal = inUseTerminal;
	}

	/**
	 * @return the prevStatus
	 */
	public String getPrevStatus() {
		return prevStatus;
	}

	/**
	 * @param prevStatus
	 *            the prevStatus to set
	 */
	public void setPrevStatus(String prevStatus) {
		this.prevStatus = prevStatus;
	}

	/**
	 * @return the discountCas
	 */
	public double getDiscountCas() {
		return discountCas;
	}

	/**
	 * @param discountCas
	 *            the discountCas to set
	 */
	public void setDiscountCas(double discountCas) {
		this.discountCas = discountCas;
	}

	/**
	 * @return the condicion
	 */
	public String getCondicion() {
		return condicion;
	}

	/**
	 * @param condicion
	 *            the condicion to set
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
	 * @param tipoArticulo
	 *            the tipoArticulo to set
	 */
	public void setTipoArticulo(String tipoArticulo) {
		this.tipoArticulo = tipoArticulo;
	}

	/**
	 * @return the idSuperpedido
	 */
	public long getIdSuperpedido() {
		return idSuperpedido;
	}

	/**
	 * @param idSuperpedido
	 *            the idSuperpedido to set
	 */
	public void setIdSuperpedido(long idSuperpedido) {
		this.idSuperpedido = idSuperpedido;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje
	 *            the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the ruta
	 */
	public String getRuta() {
		return ruta;
	}

	/**
	 * @param ruta
	 *            the ruta to set
	 */
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	/**
	 * @return the horaRuta
	 */
	public String getHoraRuta() {
		return horaRuta;
	}

	/**
	 * @param horaRuta
	 *            the horaRuta to set
	 */
	public void setHoraRuta(String horaRuta) {
		this.horaRuta = horaRuta;
	}

	/**
	 * @return the permiteBo
	 */
	public String getPermiteBo() {
		return permiteBo;
	}

	/**
	 * @param permiteBo
	 *            the permiteBo to set
	 */
	public void setPermiteBo(String permiteBo) {
		this.permiteBo = permiteBo;
	}

	/**
	 * @return the entregaTotal
	 */
	public String getEntregaTotal() {
		return entregaTotal;
	}

	/**
	 * @param entregaTotal
	 *            the entregaTotal to set
	 */
	public void setEntregaTotal(String entregaTotal) {
		this.entregaTotal = entregaTotal;
	}

	/**
	 * @return the anticipo
	 */
	public double getAnticipo() {
		return anticipo;
	}

	/**
	 * @param anticipo
	 *            the anticipo to set
	 */
	public void setAnticipo(double anticipo) {
		this.anticipo = anticipo;
	}

	/**
	 * @return the horaCredito
	 */
	public String getHoraCredito() {
		return horaCredito;
	}

	/**
	 * @param horaCredito
	 *            the horaCredito to set
	 */
	public void setHoraCredito(String horaCredito) {
		this.horaCredito = horaCredito;
	}

	/**
	 * @return the horaAlmacen
	 */
	public String getHoraAlmacen() {
		return horaAlmacen;
	}

	/**
	 * @param horaAlmacen
	 *            the horaAlmacen to set
	 */
	public void setHoraAlmacen(String horaAlmacen) {
		this.horaAlmacen = horaAlmacen;
	}

	/**
	 * @return the autAlmacen
	 */
	public String getAutAlmacen() {
		return autAlmacen;
	}

	/**
	 * @param autAlmacen
	 *            the autAlmacen to set
	 */
	public void setAutAlmacen(String autAlmacen) {
		this.autAlmacen = autAlmacen;
	}

	/**
	 * @return the currMultiplier
	 */
	public double getCurrMultiplier() {
		return currMultiplier;
	}

	/**
	 * @param currMultiplier
	 *            the currMultiplier to set
	 */
	public void setCurrMultiplier(double currMultiplier) {
		this.currMultiplier = currMultiplier;
	}

	/**
	 * @return the horaReserva
	 */
	public String getHoraReserva() {
		return horaReserva;
	}

	/**
	 * @param horaReserva
	 *            the horaReserva to set
	 */
	public void setHoraReserva(String horaReserva) {
		this.horaReserva = horaReserva;
	}

	/**
	 * @return the creditPreAuth
	 */
	public String getCreditPreAuth() {
		return creditPreAuth;
	}

	/**
	 * @param creditPreAuth
	 *            the creditPreAuth to set
	 */
	public void setCreditPreAuth(String creditPreAuth) {
		this.creditPreAuth = creditPreAuth;
	}

	/**
	 * @return the fechaEntrega
	 */
	public String getFechaEntrega() {
		return fechaEntrega;
	}

	/**
	 * @param fechaEntrega
	 *            the fechaEntrega to set
	 */
	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	/**
	 * @return the horarioEntrega
	 */
	public String getHorarioEntrega() {
		return horarioEntrega;
	}

	/**
	 * @param horarioEntrega
	 *            the horarioEntrega to set
	 */
	public void setHorarioEntrega(String horarioEntrega) {
		this.horarioEntrega = horarioEntrega;
	}

	/**
	 * @return the motivoCode
	 */
	public int getMotivoCode() {
		return motivoCode;
	}

	/**
	 * @param motivoCode
	 *            the motivoCode to set
	 */
	public void setMotivoCode(int motivoCode) {
		this.motivoCode = motivoCode;
	}

	/**
	 * @return the listOrderL
	 */
	public List<OrderL> getListOrderL() {
		return listOrderL;
	}

	/**
	 * @param listOrderL
	 *            the listOrderL to set
	 */
	public void setListOrderL(List<OrderL> listOrderL) {
		this.listOrderL = listOrderL;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderH [orgCode=" + orgCode + ", divCode=" + divCode + ", orderNum=" + orderNum + ", reference=" + reference + ", boNum=" + boNum + ", invoiceNum=" + invoiceNum + ", document=" + document + ", billNum=" + billNum + ", billDate=" + billDate + ", transType=" + transType + ", opCommit=" + opCommit + ", coopCode=" + coopCode + ", custNum=" + custNum + ", bName=" + bName + ", bAdd1=" + bAdd1 + ", bAdd2=" + bAdd2 + ", bCity=" + bCity + ", bProvince=" + bProvince + ", bCountry=" + bCountry + ", bPostalCode=" + bPostalCode + ", saCust=" + saCust + ", opContact=" + opContact + ", customerPo=" + customerPo + ", poDate=" + poDate + ", chargeTo=" + chargeTo + ", shipNum=" + shipNum + ", sName=" + sName + ", sAdd1=" + sAdd1 + ", sAdd2=" + sAdd2 + ", sCity=" + sCity + ", sProvince=" + sProvince + ", sCountry=" + sCountry + ", sPostalCode=" + sPostalCode + ", orderDate=" + orderDate + ", shipDate=" + shipDate + ", requestDate=" + requestDate + ", cancelDate=" + cancelDate + ", priceLevel=" + priceLevel + ", terminalNum=" + terminalNum + ", shipVia=" + shipVia + ", userCode=" + userCode + ", slmn1=" + slmn1 + ", comm1=" + comm1 + ", slmn2=" + slmn2 + ", comm2=" + comm2 + ", slmn3=" + slmn3 + ", comm3=" + comm3 + ", slmn4=" + slmn4 + ", comm4=" + comm4 + ", ppdColl=" + ppdColl + ", fobDesc=" + fobDesc + ", termCode=" + termCode + ", discType=" + discType + ", discount=" + discount + ", arContact=" + arContact + ", totalWeight=" + totalWeight + ", totalVolume=" + totalVolume + ", memo=" + memo + ", whseCode=" + whseCode + ", creditCard=" + creditCard + ", cardNumber=" + cardNumber + ", expiryDate=" + expiryDate + ", auth=" + auth + ", ppsPrice=" + ppsPrice + ", restockingCharge=" + restockingCharge + ", stockCommitted=" + stockCommitted + ", grossAmount=" + grossAmount + ", netAmount=" + netAmount + ", totalDiscount=" + totalDiscount + ", addCharges=" + addCharges + ", cost=" + cost + ", commableAmt=" + commableAmt + ", commEarned=" + commEarned + ", possibleDisc=" + possibleDisc + ", discDate=" + discDate + ", orderCode=" + orderCode + ", dueDate=" + dueDate + ", numPpsPrinted=" + numPpsPrinted + ", invDate=" + invDate + ", confPrinted=" + confPrinted + ", orderRegister=" + orderRegister + ", ppsPrinted=" + ppsPrinted + ", lastPpsDate=" + lastPpsDate + ", holdOrder=" + holdOrder + ", creditAuthority=" + creditAuthority + ", orderStatus=" + orderStatus + ", saUpdated=" + saUpdated + ", invRegister=" + invRegister + ", canDate=" + canDate + ", cancelCode=" + cancelCode + ", shipStats=" + shipStats + ", arAccount=" + arAccount + ", qtyPallets=" + qtyPallets + ", truckNum=" + truckNum + ", cpcNum=" + cpcNum + ", appDate=" + appDate + ", appTime=" + appTime + ", appDoor=" + appDoor + ", bidNum=" + bidNum + ", taxRegion=" + taxRegion + ", licence1=" + licence1 + ", licence2=" + licence2 + ", tax1Amt=" + tax1Amt + ", tax2Amt=" + tax2Amt + ", taxStatus=" + taxStatus + ", orderType=" + orderType + ", delMethod=" + delMethod + ", updInventory="
				+ updInventory + ", inUseUser=" + inUseUser + ", inUseTerminal=" + inUseTerminal + ", prevStatus=" + prevStatus + ", discountCas=" + discountCas + ", condicion=" + condicion + ", tipoArticulo=" + tipoArticulo + ", idSuperpedido=" + idSuperpedido + ", mensaje=" + mensaje + ", ruta=" + ruta + ", horaRuta=" + horaRuta + ", permiteBo=" + permiteBo + ", entregaTotal=" + entregaTotal + ", anticipo=" + anticipo + ", horaCredito=" + horaCredito + ", horaAlmacen=" + horaAlmacen + ", autAlmacen=" + autAlmacen + ", currMultiplier=" + currMultiplier + ", horaReserva=" + horaReserva + ", creditPreAuth=" + creditPreAuth + ", fechaEntrega=" + fechaEntrega + ", horarioEntrega=" + horarioEntrega + ", motivoCode=" + motivoCode + "]";
	}

}
