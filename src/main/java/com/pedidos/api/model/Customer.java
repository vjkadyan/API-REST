package com.pedidos.api.model;

public class Customer{
    private long custNum;
    private String custName;
    private String address1;
    private String address2;
    private String city;
    private String province;
    private String country;
    private String postalCode;
    private String phone;
    private String telex;
    private String fax;
    private String duns;
    private String arContact;
    private String opContact;
    private String receiver;
    private String receivTel;
    private String buyerTel;
    private String standardOrder;
    private String sortName;
    private String salesId;
    private String saCust;
    private String custGroup;
    private String ppdColl;
    private String dunningCode;
    private String taxRegion;
    private String terrCode;
    private String creditHold;
    private double creditLimit;
    private int creditDays;
    private String lastCredReview;
    private String rating;
    private String edi;
    private String arMethod;
    private String statFreq;
    private String interest;
    private String termCode;
    private String slmnNum;
    private String licence2;
    private String poRequired;
    private String printInvoice;
    private String backOrder;
    private String ppsPrice;
    private String promotePrice;
    private String orderConfirm;
    private String chargeTo;
    private String whseCode;
    private String shipVia;
    private int priceLevel;
    private String priority;
    private String language;
    private String arMemo;
    private String opMemo;
    private String bbVendor;
    private String coopCode;
    private String coopVendor;
    private String stat;
    private String dateCreated;
    private double arOwing;
    private double openOrder;
    private double ptdSales;
    private double lyptdSales;
    private double ytdSales;
    private double lytdSales;
    private double lySales;
    private double ptdCredit;
    private double lyptdCredit;
    private double ytdCredit;
    private double lytdCredit;
    private double lyCredit;
    private double ptdCost;
    private double lyptdCost;
    private double ytdCost;
    private double lytdCost;
    private double lyCost;
    private int ytdNoSales;
    private int lyNoSales;
    private int ytdNoReturns;
    private int lyNoReturns;
    private double largestBal;
    private String dateLargestBal;
    private double lastAmtPay;
    private String lastDatePay;
    private double lastInvAmt;
    private String invDateLast;
    private int avgDaysPay;
    private String lastAging;
    private double arFuture;
    private double arCurrent;
    private double ar30Days;
    private double ar60Days;
    private double ar90Days;
    private double ar120Days;
    private double shippedPending;
    private String orderNote;
    private String telCharge;
    private String saOutput;
    private String licence1;
    private String taxStatus;
    private String invByGrp;
    private String planOrdFlag;
    private int garanCode;
    private String aceptaBo;
    private String contrasena;
    private String estatusRed;
    private String emailRed;
    private double ptjeCancela;
    private String slmn2;
    private String slmn3;
    private String digitov;
    private String recibePub;
    private String cNumExt;
    private String cNumInt;
    private String ladaTel;
    private int extTel1;
    private int extTel2;
    private int extFax;
    private String statFraude;

    
  
    
   

    /**
	 * @param custNum
	 * @param custName
	 * @param slmnNum
	 */
	public Customer(long custNum, String custName, String slmnNum) {
		super();
		this.custNum = custNum;
		this.custName = custName;
		this.slmnNum = slmnNum;
	}
	/**
	 * @param custNum
	 */
	public Customer(long custNum) {
		super();
		this.custNum = custNum;
	}
	/**
	 * 
	 */
	public Customer() {
		super();
	}
	public long getCustNum() {
        return custNum;
    }
    public void setCustNum(long custNum) {
        this.custNum = custNum;
    }
    public String getCustName() {
        return custName;
    }
    public void setCustName(String custName) {
        this.custName = custName;
    }
    public String getAddress1() {
        return address1;
    }
    public void setAddress1(String address1) {
        this.address1 = address1;
    }
    public String getAddress2() {
        return address2;
    }
    public void setAddress2(String address2) {
        this.address2 = address2;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getTelex() {
        return telex;
    }
    public void setTelex(String telex) {
        this.telex = telex;
    }
    public String getFax() {
        return fax;
    }
    public void setFax(String fax) {
        this.fax = fax;
    }
    public String getDuns() {
        return duns;
    }
    public void setDuns(String duns) {
        this.duns = duns;
    }
    public String getArContact() {
        return arContact;
    }
    public void setArContact(String arContact) {
        this.arContact = arContact;
    }
    public String getOpContact() {
        return opContact;
    }
    public void setOpContact(String opContact) {
        this.opContact = opContact;
    }
    public String getReceiver() {
        return receiver;
    }
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    public String getReceivTel() {
        return receivTel;
    }
    public void setReceivTel(String receivTel) {
        this.receivTel = receivTel;
    }
    public String getBuyerTel() {
        return buyerTel;
    }
    public void setBuyerTel(String buyerTel) {
        this.buyerTel = buyerTel;
    }
    public String getStandardOrder() {
        return standardOrder;
    }
    public void setStandardOrder(String standardOrder) {
        this.standardOrder = standardOrder;
    }
    public String getSortName() {
        return sortName;
    }
    public void setSortName(String sortName) {
        this.sortName = sortName;
    }
    public String getSalesId() {
        return salesId;
    }
    public void setSalesId(String salesId) {
        this.salesId = salesId;
    }
    public String getSaCust() {
        return saCust;
    }
    public void setSaCust(String saCust) {
        this.saCust = saCust;
    }
    public String getCustGroup() {
        return custGroup;
    }
    public void setCustGroup(String custGroup) {
        this.custGroup = custGroup;
    }
    public String getPpdColl() {
        return ppdColl;
    }
    public void setPpdColl(String ppdColl) {
        this.ppdColl = ppdColl;
    }
    public String getDunningCode() {
        return dunningCode;
    }
    public void setDunningCode(String dunningCode) {
        this.dunningCode = dunningCode;
    }
    public String getTaxRegion() {
        return taxRegion;
    }
    public void setTaxRegion(String taxRegion) {
        this.taxRegion = taxRegion;
    }
    public String getTerrCode() {
        return terrCode;
    }
    public void setTerrCode(String terrCode) {
        this.terrCode = terrCode;
    }
    public String getCreditHold() {
        return creditHold;
    }
    public void setCreditHold(String creditHold) {
        this.creditHold = creditHold;
    }
    public double getCreditLimit() {
        return creditLimit;
    }
    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }
    public int getCreditDays() {
        return creditDays;
    }
    public void setCreditDays(int creditDays) {
        this.creditDays = creditDays;
    }
    public String getLastCredReview() {
        return lastCredReview;
    }
    public void setLastCredReview(String lastCredReview) {
        this.lastCredReview = lastCredReview;
    }
    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }
    public String getEdi() {
        return edi;
    }
    public void setEdi(String edi) {
        this.edi = edi;
    }
    public String getArMethod() {
        return arMethod;
    }
    public void setArMethod(String arMethod) {
        this.arMethod = arMethod;
    }
    public String getStatFreq() {
        return statFreq;
    }
    public void setStatFreq(String statFreq) {
        this.statFreq = statFreq;
    }
    public String getInterest() {
        return interest;
    }
    public void setInterest(String interest) {
        this.interest = interest;
    }
    public String getTermCode() {
        return termCode;
    }
    public void setTermCode(String termCode) {
        this.termCode = termCode;
    }
    public String getSlmnNum() {
        return slmnNum;
    }
    public void setSlmnNum(String slmnNum) {
        this.slmnNum = slmnNum;
    }
    public String getLicence2() {
        return licence2;
    }
    public void setLicence2(String licence2) {
        this.licence2 = licence2;
    }
    public String getPoRequired() {
        return poRequired;
    }
    public void setPoRequired(String poRequired) {
        this.poRequired = poRequired;
    }
    public String getPrintInvoice() {
        return printInvoice;
    }
    public void setPrintInvoice(String printInvoice) {
        this.printInvoice = printInvoice;
    }
    public String getBackOrder() {
        return backOrder;
    }
    public void setBackOrder(String backOrder) {
        this.backOrder = backOrder;
    }
    public String getPpsPrice() {
        return ppsPrice;
    }
    public void setPpsPrice(String ppsPrice) {
        this.ppsPrice = ppsPrice;
    }
    public String getPromotePrice() {
        return promotePrice;
    }
    public void setPromotePrice(String promotePrice) {
        this.promotePrice = promotePrice;
    }
    public String getOrderConfirm() {
        return orderConfirm;
    }
    public void setOrderConfirm(String orderConfirm) {
        this.orderConfirm = orderConfirm;
    }
    public String getChargeTo() {
        return chargeTo;
    }
    public void setChargeTo(String chargeTo) {
        this.chargeTo = chargeTo;
    }
    public String getWhseCode() {
        return whseCode;
    }
    public void setWhseCode(String whseCode) {
        this.whseCode = whseCode;
    }
    public String getShipVia() {
        return shipVia;
    }
    public void setShipVia(String shipVia) {
        this.shipVia = shipVia;
    }
    public int getPriceLevel() {
        return priceLevel;
    }
    public void setPriceLevel(int priceLevel) {
        this.priceLevel = priceLevel;
    }
    public String getPriority() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public String getArMemo() {
        return arMemo;
    }
    public void setArMemo(String arMemo) {
        this.arMemo = arMemo;
    }
    public String getOpMemo() {
        return opMemo;
    }
    public void setOpMemo(String opMemo) {
        this.opMemo = opMemo;
    }
    public String getBbVendor() {
        return bbVendor;
    }
    public void setBbVendor(String bbVendor) {
        this.bbVendor = bbVendor;
    }
    public String getCoopCode() {
        return coopCode;
    }
    public void setCoopCode(String coopCode) {
        this.coopCode = coopCode;
    }
    public String getCoopVendor() {
        return coopVendor;
    }
    public void setCoopVendor(String coopVendor) {
        this.coopVendor = coopVendor;
    }
    public String getStat() {
        return stat;
    }
    public void setStat(String stat) {
        this.stat = stat;
    }
    public String getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
    public double getArOwing() {
        return arOwing;
    }
    public void setArOwing(double arOwing) {
        this.arOwing = arOwing;
    }
    public double getOpenOrder() {
        return openOrder;
    }
    public void setOpenOrder(double openOrder) {
        this.openOrder = openOrder;
    }
    public double getPtdSales() {
        return ptdSales;
    }
    public void setPtdSales(double ptdSales) {
        this.ptdSales = ptdSales;
    }
    public double getLyptdSales() {
        return lyptdSales;
    }
    public void setLyptdSales(double lyptdSales) {
        this.lyptdSales = lyptdSales;
    }
    public double getYtdSales() {
        return ytdSales;
    }
    public void setYtdSales(double ytdSales) {
        this.ytdSales = ytdSales;
    }
    public double getLytdSales() {
        return lytdSales;
    }
    public void setLytdSales(double lytdSales) {
        this.lytdSales = lytdSales;
    }
    public double getLySales() {
        return lySales;
    }
    public void setLySales(double lySales) {
        this.lySales = lySales;
    }
    public double getPtdCredit() {
        return ptdCredit;
    }
    public void setPtdCredit(double ptdCredit) {
        this.ptdCredit = ptdCredit;
    }
    public double getLyptdCredit() {
        return lyptdCredit;
    }
    public void setLyptdCredit(double lyptdCredit) {
        this.lyptdCredit = lyptdCredit;
    }
    public double getYtdCredit() {
        return ytdCredit;
    }
    public void setYtdCredit(double ytdCredit) {
        this.ytdCredit = ytdCredit;
    }
    public double getLytdCredit() {
        return lytdCredit;
    }
    public void setLytdCredit(double lytdCredit) {
        this.lytdCredit = lytdCredit;
    }
    public double getLyCredit() {
        return lyCredit;
    }
    public void setLyCredit(double lyCredit) {
        this.lyCredit = lyCredit;
    }
    public double getPtdCost() {
        return ptdCost;
    }
    public void setPtdCost(double ptdCost) {
        this.ptdCost = ptdCost;
    }
    public double getLyptdCost() {
        return lyptdCost;
    }
    public void setLyptdCost(double lyptdCost) {
        this.lyptdCost = lyptdCost;
    }
    public double getYtdCost() {
        return ytdCost;
    }
    public void setYtdCost(double ytdCost) {
        this.ytdCost = ytdCost;
    }
    public double getLytdCost() {
        return lytdCost;
    }
    public void setLytdCost(double lytdCost) {
        this.lytdCost = lytdCost;
    }
    public double getLyCost() {
        return lyCost;
    }
    public void setLyCost(double lyCost) {
        this.lyCost = lyCost;
    }
    public int getYtdNoSales() {
        return ytdNoSales;
    }
    public void setYtdNoSales(int ytdNoSales) {
        this.ytdNoSales = ytdNoSales;
    }
    public int getLyNoSales() {
        return lyNoSales;
    }
    public void setLyNoSales(int lyNoSales) {
        this.lyNoSales = lyNoSales;
    }
    public int getYtdNoReturns() {
        return ytdNoReturns;
    }
    public void setYtdNoReturns(int ytdNoReturns) {
        this.ytdNoReturns = ytdNoReturns;
    }
    public int getLyNoReturns() {
        return lyNoReturns;
    }
    public void setLyNoReturns(int lyNoReturns) {
        this.lyNoReturns = lyNoReturns;
    }
    public double getLargestBal() {
        return largestBal;
    }
    public void setLargestBal(double largestBal) {
        this.largestBal = largestBal;
    }
    public String getDateLargestBal() {
        return dateLargestBal;
    }
    public void setDateLargestBal(String dateLargestBal) {
        this.dateLargestBal = dateLargestBal;
    }
    public double getLastAmtPay() {
        return lastAmtPay;
    }
    public void setLastAmtPay(double lastAmtPay) {
        this.lastAmtPay = lastAmtPay;
    }
    public String getLastDatePay() {
        return lastDatePay;
    }
    public void setLastDatePay(String lastDatePay) {
        this.lastDatePay = lastDatePay;
    }
    public double getLastInvAmt() {
        return lastInvAmt;
    }
    public void setLastInvAmt(double lastInvAmt) {
        this.lastInvAmt = lastInvAmt;
    }
    public String getInvDateLast() {
        return invDateLast;
    }
    public void setInvDateLast(String invDateLast) {
        this.invDateLast = invDateLast;
    }
    public int getAvgDaysPay() {
        return avgDaysPay;
    }
    public void setAvgDaysPay(int avgDaysPay) {
        this.avgDaysPay = avgDaysPay;
    }
    public String getLastAging() {
        return lastAging;
    }
    public void setLastAging(String lastAging) {
        this.lastAging = lastAging;
    }
    public double getArFuture() {
        return arFuture;
    }
    public void setArFuture(double arFuture) {
        this.arFuture = arFuture;
    }
    public double getArCurrent() {
        return arCurrent;
    }
    public void setArCurrent(double arCurrent) {
        this.arCurrent = arCurrent;
    }
    public double getAr30Days() {
        return ar30Days;
    }
    public void setAr30Days(double ar30Days) {
        this.ar30Days = ar30Days;
    }
    public double getAr60Days() {
        return ar60Days;
    }
    public void setAr60Days(double ar60Days) {
        this.ar60Days = ar60Days;
    }
    public double getAr90Days() {
        return ar90Days;
    }
    public void setAr90Days(double ar90Days) {
        this.ar90Days = ar90Days;
    }
    public double getAr120Days() {
        return ar120Days;
    }
    public void setAr120Days(double ar120Days) {
        this.ar120Days = ar120Days;
    }
    public double getShippedPending() {
        return shippedPending;
    }
    public void setShippedPending(double shippedPending) {
        this.shippedPending = shippedPending;
    }
    public String getOrderNote() {
        return orderNote;
    }
    public void setOrderNote(String orderNote) {
        this.orderNote = orderNote;
    }
    public String getTelCharge() {
        return telCharge;
    }
    public void setTelCharge(String telCharge) {
        this.telCharge = telCharge;
    }
    public String getSaOutput() {
        return saOutput;
    }
    public void setSaOutput(String saOutput) {
        this.saOutput = saOutput;
    }
    public String getLicence1() {
        return licence1;
    }
    public void setLicence1(String licence1) {
        this.licence1 = licence1;
    }
    public String getTaxStatus() {
        return taxStatus;
    }
    public void setTaxStatus(String taxStatus) {
        this.taxStatus = taxStatus;
    }
    public String getInvByGrp() {
        return invByGrp;
    }
    public void setInvByGrp(String invByGrp) {
        this.invByGrp = invByGrp;
    }
    public String getPlanOrdFlag() {
        return planOrdFlag;
    }
    public void setPlanOrdFlag(String planOrdFlag) {
        this.planOrdFlag = planOrdFlag;
    }
    public int getGaranCode() {
        return garanCode;
    }
    public void setGaranCode(int garanCode) {
        this.garanCode = garanCode;
    }
    public String getAceptaBo() {
        return aceptaBo;
    }
    public void setAceptaBo(String aceptaBo) {
        this.aceptaBo = aceptaBo;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public String getEstatusRed() {
        return estatusRed;
    }
    public void setEstatusRed(String estatusRed) {
        this.estatusRed = estatusRed;
    }
    public String getEmailRed() {
        return emailRed;
    }
    public void setEmailRed(String emailRed) {
        this.emailRed = emailRed;
    }
    public double getPtjeCancela() {
        return ptjeCancela;
    }
    public void setPtjeCancela(double ptjeCancela) {
        this.ptjeCancela = ptjeCancela;
    }
    public String getSlmn2() {
        return slmn2;
    }
    public void setSlmn2(String slmn2) {
        this.slmn2 = slmn2;
    }
    public String getSlmn3() {
        return slmn3;
    }
    public void setSlmn3(String slmn3) {
        this.slmn3 = slmn3;
    }
    public String getDigitov() {
        return digitov;
    }
    public void setDigitov(String digitov) {
        this.digitov = digitov;
    }
    public String getRecibePub() {
        return recibePub;
    }
    public void setRecibePub(String recibePub) {
        this.recibePub = recibePub;
    }
    public String getcNumExt() {
        return cNumExt;
    }
    public void setcNumExt(String cNumExt) {
        this.cNumExt = cNumExt;
    }
    public String getcNumInt() {
        return cNumInt;
    }
    public void setcNumInt(String cNumInt) {
        this.cNumInt = cNumInt;
    }
    public String getLadaTel() {
        return ladaTel;
    }
    public void setLadaTel(String ladaTel) {
        this.ladaTel = ladaTel;
    }
    public int getExtTel1() {
        return extTel1;
    }
    public void setExtTel1(int extTel1) {
        this.extTel1 = extTel1;
    }
    public int getExtTel2() {
        return extTel2;
    }
    public void setExtTel2(int extTel2) {
        this.extTel2 = extTel2;
    }
    public int getExtFax() {
        return extFax;
    }
    public void setExtFax(int extFax) {
        this.extFax = extFax;
    }
    public String getStatFraude() {
        return statFraude;
    }
    public void setStatFraude(String statFraude) {
        this.statFraude = statFraude;
    }
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [custNum=" + custNum + ", custName=" + custName
				+ ", address1=" + address1 + ", address2=" + address2
				+ ", city=" + city + ", province=" + province + ", country="
				+ country + ", postalCode=" + postalCode + ", phone=" + phone
				+ ", telex=" + telex + ", fax=" + fax + ", duns=" + duns
				+ ", arContact=" + arContact + ", opContact=" + opContact
				+ ", receiver=" + receiver + ", receivTel=" + receivTel
				+ ", buyerTel=" + buyerTel + ", standardOrder=" + standardOrder
				+ ", sortName=" + sortName + ", salesId=" + salesId
				+ ", saCust=" + saCust + ", custGroup=" + custGroup
				+ ", ppdColl=" + ppdColl + ", dunningCode=" + dunningCode
				+ ", taxRegion=" + taxRegion + ", terrCode=" + terrCode
				+ ", creditHold=" + creditHold + ", creditLimit=" + creditLimit
				+ ", creditDays=" + creditDays + ", lastCredReview="
				+ lastCredReview + ", rating=" + rating + ", edi=" + edi
				+ ", arMethod=" + arMethod + ", statFreq=" + statFreq
				+ ", interest=" + interest + ", termCode=" + termCode
				+ ", slmnNum=" + slmnNum + ", licence2=" + licence2
				+ ", poRequired=" + poRequired + ", printInvoice="
				+ printInvoice + ", backOrder=" + backOrder + ", ppsPrice="
				+ ppsPrice + ", promotePrice=" + promotePrice
				+ ", orderConfirm=" + orderConfirm + ", chargeTo=" + chargeTo
				+ ", whseCode=" + whseCode + ", shipVia=" + shipVia
				+ ", priceLevel=" + priceLevel + ", priority=" + priority
				+ ", language=" + language + ", arMemo=" + arMemo + ", opMemo="
				+ opMemo + ", bbVendor=" + bbVendor + ", coopCode=" + coopCode
				+ ", coopVendor=" + coopVendor + ", stat=" + stat
				+ ", dateCreated=" + dateCreated + ", arOwing=" + arOwing
				+ ", openOrder=" + openOrder + ", ptdSales=" + ptdSales
				+ ", lyptdSales=" + lyptdSales + ", ytdSales=" + ytdSales
				+ ", lytdSales=" + lytdSales + ", lySales=" + lySales
				+ ", ptdCredit=" + ptdCredit + ", lyptdCredit=" + lyptdCredit
				+ ", ytdCredit=" + ytdCredit + ", lytdCredit=" + lytdCredit
				+ ", lyCredit=" + lyCredit + ", ptdCost=" + ptdCost
				+ ", lyptdCost=" + lyptdCost + ", ytdCost=" + ytdCost
				+ ", lytdCost=" + lytdCost + ", lyCost=" + lyCost
				+ ", ytdNoSales=" + ytdNoSales + ", lyNoSales=" + lyNoSales
				+ ", ytdNoReturns=" + ytdNoReturns + ", lyNoReturns="
				+ lyNoReturns + ", largestBal=" + largestBal
				+ ", dateLargestBal=" + dateLargestBal + ", lastAmtPay="
				+ lastAmtPay + ", lastDatePay=" + lastDatePay + ", lastInvAmt="
				+ lastInvAmt + ", invDateLast=" + invDateLast + ", avgDaysPay="
				+ avgDaysPay + ", lastAging=" + lastAging + ", arFuture="
				+ arFuture + ", arCurrent=" + arCurrent + ", ar30Days="
				+ ar30Days + ", ar60Days=" + ar60Days + ", ar90Days="
				+ ar90Days + ", ar120Days=" + ar120Days + ", shippedPending="
				+ shippedPending + ", orderNote=" + orderNote + ", telCharge="
				+ telCharge + ", saOutput=" + saOutput + ", licence1="
				+ licence1 + ", taxStatus=" + taxStatus + ", invByGrp="
				+ invByGrp + ", planOrdFlag=" + planOrdFlag + ", garanCode="
				+ garanCode + ", aceptaBo=" + aceptaBo + ", contrasena="
				+ contrasena + ", estatusRed=" + estatusRed + ", emailRed="
				+ emailRed + ", ptjeCancela=" + ptjeCancela + ", slmn2="
				+ slmn2 + ", slmn3=" + slmn3 + ", digitov=" + digitov
				+ ", recibePub=" + recibePub + ", cNumExt=" + cNumExt
				+ ", cNumInt=" + cNumInt + ", ladaTel=" + ladaTel
				+ ", extTel1=" + extTel1 + ", extTel2=" + extTel2 + ", extFax="
				+ extFax + ", statFraude=" + statFraude + "]";
	}
    
    
}
