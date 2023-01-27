package com.pedidos.api.model;


public class ItemW {
    private String whseCode;
    private String itemNum;
    private String subItem;
    private String binCode;
    private String bin;
    private String eoq;
    private String eoqClass;
    private String minQty;
    private String maxQty;
    private String leadTime;
    private double listPrice;
    private String palletDesc;
    private String allowBo;
    private String abcClass;
    private String vendorNum;
    private String vendorItem;
    private String vendorDesc;
    private String memo1;
    private String memo2;
    private String memo3;
    private String dateCreated;
    private String custOrders;
    private double onHand;
    private double level1Commit;
    private double level2Commit;
    private String futureOrder;
    private String tferIn;
    private String tferOut;
    private double tfer1Commit;
    private double tfer2Commit;
    private String tferTransit;
    private String damaged;
    private String onPurchase;
    private String dropShip;
    private String issued;
    private double lastCost;
    private double avgCost;
    private double fifoCost;
    private double standardCost;
    private String datePoLast;
    private String qtyPoLast;
    private String dateCountLast;
    private String qtyCountLast;
    private String dateSaleLast;
    private String qtySaleLast;
    private String dateAdjLast;
    private String qtyAdjLast;
    private String dateProdLast;
    private String qtyProdLast;
    private String ptdBo;
    private String lyptdBo;
    private String ytdBo;
    private String lytdBo;
    private String lyBo;
    private String llyBo;
    private String ptdCost;
    private String lyptdCost;
    private String ytdCost;
    private String lytdCost;
    private String lyCost;
    private String llyCost;
    private String ptdDropShip;
    private String lyptdDropShip;
    private String ytdDropShip;
    private String lytdDropShip;
    private String lyDropShip;
    private String llyDropShip;
    private String ptdPurchased;
    private String lyptdPurchased;
    private String ytdPurchased;
    private String lytdPurchased;
    private String lyPurchased;
    private String llyPurchased;
    private String ptdReceived;
    private String lyptdReceived;
    private String ytdReceived;
    private String lytdReceived;
    private String lyReceived;
    private String llyReceived;
    private String ptdTransferred;
    private String lyptdTransferred;
    private String ytdTransferred;
    private String lytdTransferred;
    private String lyTransferred;
    private String llyTransferred;
    private String ptdShipped;
    private String lyptdShipped;
    private String ytdShipped;
    private String lytdShipped;
    private String lyShipped;
    private String llyShipped;
    private String ptdReturned;
    private String lyptdReturned;
    private String ytdReturned;
    private String lytdReturned;
    private String lyReturned;
    private String llyReturned;
    private String ptdAdjusted;
    private String lyptdAdjusted;
    private String ytdAdjusted;
    private String lytdAdjusted;
    private String lyAdjusted;
    private String llyAdjusted;
    private String ptdDamaged;
    private String lyptdDamaged;
    private String ytdDamaged;
    private String lytdDamaged;
    private String lyDamaged;
    private String llyDamaged;
    private String ptdUsed;
    private String lyptdUsed;
    private String ytdUsed;
    private String lytdUsed;
    private String lyUsed;
    private String llyUsed;
    private String ptdProduced;
    private String lyptdProduced;
    private String ytdProduced;
    private String lytdProduced;
    private String lyProduced;
    private String llyProduced;
    private String ptdPoReturn;
    private String lyptdPoReturn;
    private String ytdPoReturn;
    private String lytdPoReturn;
    private String lyPoReturn;
    private String llyPoReturn;
    private String ytdCountAdj;
    private String lyCountAdj;
    private String vendorStock;
    private String taxGrp1;
    private String taxGrp2;
    private String taxable;
    private String orgCode;
    private String taxRegion;
    private String prodCode;
    private String groupCode;
    private String replCode;
    private String autoCal;
    private String mthForecast;
    private String orderPoint;
    private String lastForDate;
    private String lastReqDate;
    private String holdLots;
    private String marginProtect;
    private String marginSale;
    private String sobrepedido;
    private String diasSobrepedido;
    private String fechaProxima;
    private String tieneExistencia;
    
    

    
    /**
     * 
     */
    public ItemW() {
        super();
    }
    
    
    
    
    /**
     * @param whseCode
     * @param itemNum
     */
    public ItemW(String whseCode, String itemNum) {
        super();
        this.whseCode = whseCode;
        this.itemNum = itemNum;
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
     * @return the subItem
     */
    public String getSubItem() {
        return subItem;
    }
    /**
     * @param subItem the subItem to set
     */
    public void setSubItem(String subItem) {
        this.subItem = subItem;
    }
    /**
     * @return the binCode
     */
    public String getBinCode() {
        return binCode;
    }
    /**
     * @param binCode the binCode to set
     */
    public void setBinCode(String binCode) {
        this.binCode = binCode;
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
     * @return the eoq
     */
    public String getEoq() {
        return eoq;
    }
    /**
     * @param eoq the eoq to set
     */
    public void setEoq(String eoq) {
        this.eoq = eoq;
    }
    /**
     * @return the eoqClass
     */
    public String getEoqClass() {
        return eoqClass;
    }
    /**
     * @param eoqClass the eoqClass to set
     */
    public void setEoqClass(String eoqClass) {
        this.eoqClass = eoqClass;
    }
    /**
     * @return the minQty
     */
    public String getMinQty() {
        return minQty;
    }
    /**
     * @param minQty the minQty to set
     */
    public void setMinQty(String minQty) {
        this.minQty = minQty;
    }
    /**
     * @return the maxQty
     */
    public String getMaxQty() {
        return maxQty;
    }
    /**
     * @param maxQty the maxQty to set
     */
    public void setMaxQty(String maxQty) {
        this.maxQty = maxQty;
    }
    /**
     * @return the leadTime
     */
    public String getLeadTime() {
        return leadTime;
    }
    /**
     * @param leadTime the leadTime to set
     */
    public void setLeadTime(String leadTime) {
        this.leadTime = leadTime;
    }
    /**
     * @return the listPrice
     */
    public double getListPrice() {
        return listPrice;
    }
    /**
     * @param listPrice the listPrice to set
     */
    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
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
     * @return the allowBo
     */
    public String getAllowBo() {
        return allowBo;
    }
    /**
     * @param allowBo the allowBo to set
     */
    public void setAllowBo(String allowBo) {
        this.allowBo = allowBo;
    }
    /**
     * @return the abcClass
     */
    public String getAbcClass() {
        return abcClass;
    }
    /**
     * @param abcClass the abcClass to set
     */
    public void setAbcClass(String abcClass) {
        this.abcClass = abcClass;
    }
    /**
     * @return the vendorNum
     */
    public String getVendorNum() {
        return vendorNum;
    }
    /**
     * @param vendorNum the vendorNum to set
     */
    public void setVendorNum(String vendorNum) {
        this.vendorNum = vendorNum;
    }
    /**
     * @return the vendorItem
     */
    public String getVendorItem() {
        return vendorItem;
    }
    /**
     * @param vendorItem the vendorItem to set
     */
    public void setVendorItem(String vendorItem) {
        this.vendorItem = vendorItem;
    }
    /**
     * @return the vendorDesc
     */
    public String getVendorDesc() {
        return vendorDesc;
    }
    /**
     * @param vendorDesc the vendorDesc to set
     */
    public void setVendorDesc(String vendorDesc) {
        this.vendorDesc = vendorDesc;
    }
    /**
     * @return the memo1
     */
    public String getMemo1() {
        return memo1;
    }
    /**
     * @param memo1 the memo1 to set
     */
    public void setMemo1(String memo1) {
        this.memo1 = memo1;
    }
    /**
     * @return the memo2
     */
    public String getMemo2() {
        return memo2;
    }
    /**
     * @param memo2 the memo2 to set
     */
    public void setMemo2(String memo2) {
        this.memo2 = memo2;
    }
    /**
     * @return the memo3
     */
    public String getMemo3() {
        return memo3;
    }
    /**
     * @param memo3 the memo3 to set
     */
    public void setMemo3(String memo3) {
        this.memo3 = memo3;
    }
    /**
     * @return the dateCreated
     */
    public String getDateCreated() {
        return dateCreated;
    }
    /**
     * @param dateCreated the dateCreated to set
     */
    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
    /**
     * @return the custOrders
     */
    public String getCustOrders() {
        return custOrders;
    }
    /**
     * @param custOrders the custOrders to set
     */
    public void setCustOrders(String custOrders) {
        this.custOrders = custOrders;
    }
    /**
     * @return the onHand
     */
    public double getOnHand() {
        return onHand;
    }
    /**
     * @param onHand the onHand to set
     */
    public void setOnHand(double onHand) {
        this.onHand = onHand;
    }
    /**
     * @return the level1Commit
     */
    public double getLevel1Commit() {
        return level1Commit;
    }
    /**
     * @param level1Commit the level1Commit to set
     */
    public void setLevel1Commit(double level1Commit) {
        this.level1Commit = level1Commit;
    }
    /**
     * @return the level2Commit
     */
    public double getLevel2Commit() {
        return level2Commit;
    }
    /**
     * @param level2Commit the level2Commit to set
     */
    public void setLevel2Commit(double level2Commit) {
        this.level2Commit = level2Commit;
    }
    /**
     * @return the futureOrder
     */
    public String getFutureOrder() {
        return futureOrder;
    }
    /**
     * @param futureOrder the futureOrder to set
     */
    public void setFutureOrder(String futureOrder) {
        this.futureOrder = futureOrder;
    }
    /**
     * @return the tferIn
     */
    public String getTferIn() {
        return tferIn;
    }
    /**
     * @param tferIn the tferIn to set
     */
    public void setTferIn(String tferIn) {
        this.tferIn = tferIn;
    }
    /**
     * @return the tferOut
     */
    public String getTferOut() {
        return tferOut;
    }
    /**
     * @param tferOut the tferOut to set
     */
    public void setTferOut(String tferOut) {
        this.tferOut = tferOut;
    }
    /**
     * @return the tfer1Commit
     */
    public double getTfer1Commit() {
        return tfer1Commit;
    }
    /**
     * @param tfer1Commit the tfer1Commit to set
     */
    public void setTfer1Commit(double tfer1Commit) {
        this.tfer1Commit = tfer1Commit;
    }
    /**
     * @return the tfer2Commit
     */
    public double getTfer2Commit() {
        return tfer2Commit;
    }
    /**
     * @param tfer2Commit the tfer2Commit to set
     */
    public void setTfer2Commit(double tfer2Commit) {
        this.tfer2Commit = tfer2Commit;
    }
    /**
     * @return the tferTransit
     */
    public String getTferTransit() {
        return tferTransit;
    }
    /**
     * @param tferTransit the tferTransit to set
     */
    public void setTferTransit(String tferTransit) {
        this.tferTransit = tferTransit;
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
     * @return the onPurchase
     */
    public String getOnPurchase() {
        return onPurchase;
    }
    /**
     * @param onPurchase the onPurchase to set
     */
    public void setOnPurchase(String onPurchase) {
        this.onPurchase = onPurchase;
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
     * @return the issued
     */
    public String getIssued() {
        return issued;
    }
    /**
     * @param issued the issued to set
     */
    public void setIssued(String issued) {
        this.issued = issued;
    }
    /**
     * @return the lastCost
     */
    public double getLastCost() {
        return lastCost;
    }
    /**
     * @param lastCost the lastCost to set
     */
    public void setLastCost(double lastCost) {
        this.lastCost = lastCost;
    }
    /**
     * @return the avgCost
     */
    public double getAvgCost() {
        return avgCost;
    }
    /**
     * @param avgCost the avgCost to set
     */
    public void setAvgCost(double avgCost) {
        this.avgCost = avgCost;
    }
    /**
     * @return the fifoCost
     */
    public double getFifoCost() {
        return fifoCost;
    }
    /**
     * @param fifoCost the fifoCost to set
     */
    public void setFifoCost(double fifoCost) {
        this.fifoCost = fifoCost;
    }
    /**
     * @return the standardCost
     */
    public double getStandardCost() {
        return standardCost;
    }
    /**
     * @param standardCost the standardCost to set
     */
    public void setStandardCost(double standardCost) {
        this.standardCost = standardCost;
    }
    /**
     * @return the datePoLast
     */
    public String getDatePoLast() {
        return datePoLast;
    }
    /**
     * @param datePoLast the datePoLast to set
     */
    public void setDatePoLast(String datePoLast) {
        this.datePoLast = datePoLast;
    }
    /**
     * @return the qtyPoLast
     */
    public String getQtyPoLast() {
        return qtyPoLast;
    }
    /**
     * @param qtyPoLast the qtyPoLast to set
     */
    public void setQtyPoLast(String qtyPoLast) {
        this.qtyPoLast = qtyPoLast;
    }
    /**
     * @return the dateCountLast
     */
    public String getDateCountLast() {
        return dateCountLast;
    }
    /**
     * @param dateCountLast the dateCountLast to set
     */
    public void setDateCountLast(String dateCountLast) {
        this.dateCountLast = dateCountLast;
    }
    /**
     * @return the qtyCountLast
     */
    public String getQtyCountLast() {
        return qtyCountLast;
    }
    /**
     * @param qtyCountLast the qtyCountLast to set
     */
    public void setQtyCountLast(String qtyCountLast) {
        this.qtyCountLast = qtyCountLast;
    }
    /**
     * @return the dateSaleLast
     */
    public String getDateSaleLast() {
        return dateSaleLast;
    }
    /**
     * @param dateSaleLast the dateSaleLast to set
     */
    public void setDateSaleLast(String dateSaleLast) {
        this.dateSaleLast = dateSaleLast;
    }
    /**
     * @return the qtySaleLast
     */
    public String getQtySaleLast() {
        return qtySaleLast;
    }
    /**
     * @param qtySaleLast the qtySaleLast to set
     */
    public void setQtySaleLast(String qtySaleLast) {
        this.qtySaleLast = qtySaleLast;
    }
    /**
     * @return the dateAdjLast
     */
    public String getDateAdjLast() {
        return dateAdjLast;
    }
    /**
     * @param dateAdjLast the dateAdjLast to set
     */
    public void setDateAdjLast(String dateAdjLast) {
        this.dateAdjLast = dateAdjLast;
    }
    /**
     * @return the qtyAdjLast
     */
    public String getQtyAdjLast() {
        return qtyAdjLast;
    }
    /**
     * @param qtyAdjLast the qtyAdjLast to set
     */
    public void setQtyAdjLast(String qtyAdjLast) {
        this.qtyAdjLast = qtyAdjLast;
    }
    /**
     * @return the dateProdLast
     */
    public String getDateProdLast() {
        return dateProdLast;
    }
    /**
     * @param dateProdLast the dateProdLast to set
     */
    public void setDateProdLast(String dateProdLast) {
        this.dateProdLast = dateProdLast;
    }
    /**
     * @return the qtyProdLast
     */
    public String getQtyProdLast() {
        return qtyProdLast;
    }
    /**
     * @param qtyProdLast the qtyProdLast to set
     */
    public void setQtyProdLast(String qtyProdLast) {
        this.qtyProdLast = qtyProdLast;
    }
    /**
     * @return the ptdBo
     */
    public String getPtdBo() {
        return ptdBo;
    }
    /**
     * @param ptdBo the ptdBo to set
     */
    public void setPtdBo(String ptdBo) {
        this.ptdBo = ptdBo;
    }
    /**
     * @return the lyptdBo
     */
    public String getLyptdBo() {
        return lyptdBo;
    }
    /**
     * @param lyptdBo the lyptdBo to set
     */
    public void setLyptdBo(String lyptdBo) {
        this.lyptdBo = lyptdBo;
    }
    /**
     * @return the ytdBo
     */
    public String getYtdBo() {
        return ytdBo;
    }
    /**
     * @param ytdBo the ytdBo to set
     */
    public void setYtdBo(String ytdBo) {
        this.ytdBo = ytdBo;
    }
    /**
     * @return the lytdBo
     */
    public String getLytdBo() {
        return lytdBo;
    }
    /**
     * @param lytdBo the lytdBo to set
     */
    public void setLytdBo(String lytdBo) {
        this.lytdBo = lytdBo;
    }
    /**
     * @return the lyBo
     */
    public String getLyBo() {
        return lyBo;
    }
    /**
     * @param lyBo the lyBo to set
     */
    public void setLyBo(String lyBo) {
        this.lyBo = lyBo;
    }
    /**
     * @return the llyBo
     */
    public String getLlyBo() {
        return llyBo;
    }
    /**
     * @param llyBo the llyBo to set
     */
    public void setLlyBo(String llyBo) {
        this.llyBo = llyBo;
    }
    /**
     * @return the ptdCost
     */
    public String getPtdCost() {
        return ptdCost;
    }
    /**
     * @param ptdCost the ptdCost to set
     */
    public void setPtdCost(String ptdCost) {
        this.ptdCost = ptdCost;
    }
    /**
     * @return the lyptdCost
     */
    public String getLyptdCost() {
        return lyptdCost;
    }
    /**
     * @param lyptdCost the lyptdCost to set
     */
    public void setLyptdCost(String lyptdCost) {
        this.lyptdCost = lyptdCost;
    }
    /**
     * @return the ytdCost
     */
    public String getYtdCost() {
        return ytdCost;
    }
    /**
     * @param ytdCost the ytdCost to set
     */
    public void setYtdCost(String ytdCost) {
        this.ytdCost = ytdCost;
    }
    /**
     * @return the lytdCost
     */
    public String getLytdCost() {
        return lytdCost;
    }
    /**
     * @param lytdCost the lytdCost to set
     */
    public void setLytdCost(String lytdCost) {
        this.lytdCost = lytdCost;
    }
    /**
     * @return the lyCost
     */
    public String getLyCost() {
        return lyCost;
    }
    /**
     * @param lyCost the lyCost to set
     */
    public void setLyCost(String lyCost) {
        this.lyCost = lyCost;
    }
    /**
     * @return the llyCost
     */
    public String getLlyCost() {
        return llyCost;
    }
    /**
     * @param llyCost the llyCost to set
     */
    public void setLlyCost(String llyCost) {
        this.llyCost = llyCost;
    }
    /**
     * @return the ptdDropShip
     */
    public String getPtdDropShip() {
        return ptdDropShip;
    }
    /**
     * @param ptdDropShip the ptdDropShip to set
     */
    public void setPtdDropShip(String ptdDropShip) {
        this.ptdDropShip = ptdDropShip;
    }
    /**
     * @return the lyptdDropShip
     */
    public String getLyptdDropShip() {
        return lyptdDropShip;
    }
    /**
     * @param lyptdDropShip the lyptdDropShip to set
     */
    public void setLyptdDropShip(String lyptdDropShip) {
        this.lyptdDropShip = lyptdDropShip;
    }
    /**
     * @return the ytdDropShip
     */
    public String getYtdDropShip() {
        return ytdDropShip;
    }
    /**
     * @param ytdDropShip the ytdDropShip to set
     */
    public void setYtdDropShip(String ytdDropShip) {
        this.ytdDropShip = ytdDropShip;
    }
    /**
     * @return the lytdDropShip
     */
    public String getLytdDropShip() {
        return lytdDropShip;
    }
    /**
     * @param lytdDropShip the lytdDropShip to set
     */
    public void setLytdDropShip(String lytdDropShip) {
        this.lytdDropShip = lytdDropShip;
    }
    /**
     * @return the lyDropShip
     */
    public String getLyDropShip() {
        return lyDropShip;
    }
    /**
     * @param lyDropShip the lyDropShip to set
     */
    public void setLyDropShip(String lyDropShip) {
        this.lyDropShip = lyDropShip;
    }
    /**
     * @return the llyDropShip
     */
    public String getLlyDropShip() {
        return llyDropShip;
    }
    /**
     * @param llyDropShip the llyDropShip to set
     */
    public void setLlyDropShip(String llyDropShip) {
        this.llyDropShip = llyDropShip;
    }
    /**
     * @return the ptdPurchased
     */
    public String getPtdPurchased() {
        return ptdPurchased;
    }
    /**
     * @param ptdPurchased the ptdPurchased to set
     */
    public void setPtdPurchased(String ptdPurchased) {
        this.ptdPurchased = ptdPurchased;
    }
    /**
     * @return the lyptdPurchased
     */
    public String getLyptdPurchased() {
        return lyptdPurchased;
    }
    /**
     * @param lyptdPurchased the lyptdPurchased to set
     */
    public void setLyptdPurchased(String lyptdPurchased) {
        this.lyptdPurchased = lyptdPurchased;
    }
    /**
     * @return the ytdPurchased
     */
    public String getYtdPurchased() {
        return ytdPurchased;
    }
    /**
     * @param ytdPurchased the ytdPurchased to set
     */
    public void setYtdPurchased(String ytdPurchased) {
        this.ytdPurchased = ytdPurchased;
    }
    /**
     * @return the lytdPurchased
     */
    public String getLytdPurchased() {
        return lytdPurchased;
    }
    /**
     * @param lytdPurchased the lytdPurchased to set
     */
    public void setLytdPurchased(String lytdPurchased) {
        this.lytdPurchased = lytdPurchased;
    }
    /**
     * @return the lyPurchased
     */
    public String getLyPurchased() {
        return lyPurchased;
    }
    /**
     * @param lyPurchased the lyPurchased to set
     */
    public void setLyPurchased(String lyPurchased) {
        this.lyPurchased = lyPurchased;
    }
    /**
     * @return the llyPurchased
     */
    public String getLlyPurchased() {
        return llyPurchased;
    }
    /**
     * @param llyPurchased the llyPurchased to set
     */
    public void setLlyPurchased(String llyPurchased) {
        this.llyPurchased = llyPurchased;
    }
    /**
     * @return the ptdReceived
     */
    public String getPtdReceived() {
        return ptdReceived;
    }
    /**
     * @param ptdReceived the ptdReceived to set
     */
    public void setPtdReceived(String ptdReceived) {
        this.ptdReceived = ptdReceived;
    }
    /**
     * @return the lyptdReceived
     */
    public String getLyptdReceived() {
        return lyptdReceived;
    }
    /**
     * @param lyptdReceived the lyptdReceived to set
     */
    public void setLyptdReceived(String lyptdReceived) {
        this.lyptdReceived = lyptdReceived;
    }
    /**
     * @return the ytdReceived
     */
    public String getYtdReceived() {
        return ytdReceived;
    }
    /**
     * @param ytdReceived the ytdReceived to set
     */
    public void setYtdReceived(String ytdReceived) {
        this.ytdReceived = ytdReceived;
    }
    /**
     * @return the lytdReceived
     */
    public String getLytdReceived() {
        return lytdReceived;
    }
    /**
     * @param lytdReceived the lytdReceived to set
     */
    public void setLytdReceived(String lytdReceived) {
        this.lytdReceived = lytdReceived;
    }
    /**
     * @return the lyReceived
     */
    public String getLyReceived() {
        return lyReceived;
    }
    /**
     * @param lyReceived the lyReceived to set
     */
    public void setLyReceived(String lyReceived) {
        this.lyReceived = lyReceived;
    }
    /**
     * @return the llyReceived
     */
    public String getLlyReceived() {
        return llyReceived;
    }
    /**
     * @param llyReceived the llyReceived to set
     */
    public void setLlyReceived(String llyReceived) {
        this.llyReceived = llyReceived;
    }
    /**
     * @return the ptdTransferred
     */
    public String getPtdTransferred() {
        return ptdTransferred;
    }
    /**
     * @param ptdTransferred the ptdTransferred to set
     */
    public void setPtdTransferred(String ptdTransferred) {
        this.ptdTransferred = ptdTransferred;
    }
    /**
     * @return the lyptdTransferred
     */
    public String getLyptdTransferred() {
        return lyptdTransferred;
    }
    /**
     * @param lyptdTransferred the lyptdTransferred to set
     */
    public void setLyptdTransferred(String lyptdTransferred) {
        this.lyptdTransferred = lyptdTransferred;
    }
    /**
     * @return the ytdTransferred
     */
    public String getYtdTransferred() {
        return ytdTransferred;
    }
    /**
     * @param ytdTransferred the ytdTransferred to set
     */
    public void setYtdTransferred(String ytdTransferred) {
        this.ytdTransferred = ytdTransferred;
    }
    /**
     * @return the lytdTransferred
     */
    public String getLytdTransferred() {
        return lytdTransferred;
    }
    /**
     * @param lytdTransferred the lytdTransferred to set
     */
    public void setLytdTransferred(String lytdTransferred) {
        this.lytdTransferred = lytdTransferred;
    }
    /**
     * @return the lyTransferred
     */
    public String getLyTransferred() {
        return lyTransferred;
    }
    /**
     * @param lyTransferred the lyTransferred to set
     */
    public void setLyTransferred(String lyTransferred) {
        this.lyTransferred = lyTransferred;
    }
    /**
     * @return the llyTransferred
     */
    public String getLlyTransferred() {
        return llyTransferred;
    }
    /**
     * @param llyTransferred the llyTransferred to set
     */
    public void setLlyTransferred(String llyTransferred) {
        this.llyTransferred = llyTransferred;
    }
    /**
     * @return the ptdShipped
     */
    public String getPtdShipped() {
        return ptdShipped;
    }
    /**
     * @param ptdShipped the ptdShipped to set
     */
    public void setPtdShipped(String ptdShipped) {
        this.ptdShipped = ptdShipped;
    }
    /**
     * @return the lyptdShipped
     */
    public String getLyptdShipped() {
        return lyptdShipped;
    }
    /**
     * @param lyptdShipped the lyptdShipped to set
     */
    public void setLyptdShipped(String lyptdShipped) {
        this.lyptdShipped = lyptdShipped;
    }
    /**
     * @return the ytdShipped
     */
    public String getYtdShipped() {
        return ytdShipped;
    }
    /**
     * @param ytdShipped the ytdShipped to set
     */
    public void setYtdShipped(String ytdShipped) {
        this.ytdShipped = ytdShipped;
    }
    /**
     * @return the lytdShipped
     */
    public String getLytdShipped() {
        return lytdShipped;
    }
    /**
     * @param lytdShipped the lytdShipped to set
     */
    public void setLytdShipped(String lytdShipped) {
        this.lytdShipped = lytdShipped;
    }
    /**
     * @return the lyShipped
     */
    public String getLyShipped() {
        return lyShipped;
    }
    /**
     * @param lyShipped the lyShipped to set
     */
    public void setLyShipped(String lyShipped) {
        this.lyShipped = lyShipped;
    }
    /**
     * @return the llyShipped
     */
    public String getLlyShipped() {
        return llyShipped;
    }
    /**
     * @param llyShipped the llyShipped to set
     */
    public void setLlyShipped(String llyShipped) {
        this.llyShipped = llyShipped;
    }
    /**
     * @return the ptdReturned
     */
    public String getPtdReturned() {
        return ptdReturned;
    }
    /**
     * @param ptdReturned the ptdReturned to set
     */
    public void setPtdReturned(String ptdReturned) {
        this.ptdReturned = ptdReturned;
    }
    /**
     * @return the lyptdReturned
     */
    public String getLyptdReturned() {
        return lyptdReturned;
    }
    /**
     * @param lyptdReturned the lyptdReturned to set
     */
    public void setLyptdReturned(String lyptdReturned) {
        this.lyptdReturned = lyptdReturned;
    }
    /**
     * @return the ytdReturned
     */
    public String getYtdReturned() {
        return ytdReturned;
    }
    /**
     * @param ytdReturned the ytdReturned to set
     */
    public void setYtdReturned(String ytdReturned) {
        this.ytdReturned = ytdReturned;
    }
    /**
     * @return the lytdReturned
     */
    public String getLytdReturned() {
        return lytdReturned;
    }
    /**
     * @param lytdReturned the lytdReturned to set
     */
    public void setLytdReturned(String lytdReturned) {
        this.lytdReturned = lytdReturned;
    }
    /**
     * @return the lyReturned
     */
    public String getLyReturned() {
        return lyReturned;
    }
    /**
     * @param lyReturned the lyReturned to set
     */
    public void setLyReturned(String lyReturned) {
        this.lyReturned = lyReturned;
    }
    /**
     * @return the llyReturned
     */
    public String getLlyReturned() {
        return llyReturned;
    }
    /**
     * @param llyReturned the llyReturned to set
     */
    public void setLlyReturned(String llyReturned) {
        this.llyReturned = llyReturned;
    }
    /**
     * @return the ptdAdjusted
     */
    public String getPtdAdjusted() {
        return ptdAdjusted;
    }
    /**
     * @param ptdAdjusted the ptdAdjusted to set
     */
    public void setPtdAdjusted(String ptdAdjusted) {
        this.ptdAdjusted = ptdAdjusted;
    }
    /**
     * @return the lyptdAdjusted
     */
    public String getLyptdAdjusted() {
        return lyptdAdjusted;
    }
    /**
     * @param lyptdAdjusted the lyptdAdjusted to set
     */
    public void setLyptdAdjusted(String lyptdAdjusted) {
        this.lyptdAdjusted = lyptdAdjusted;
    }
    /**
     * @return the ytdAdjusted
     */
    public String getYtdAdjusted() {
        return ytdAdjusted;
    }
    /**
     * @param ytdAdjusted the ytdAdjusted to set
     */
    public void setYtdAdjusted(String ytdAdjusted) {
        this.ytdAdjusted = ytdAdjusted;
    }
    /**
     * @return the lytdAdjusted
     */
    public String getLytdAdjusted() {
        return lytdAdjusted;
    }
    /**
     * @param lytdAdjusted the lytdAdjusted to set
     */
    public void setLytdAdjusted(String lytdAdjusted) {
        this.lytdAdjusted = lytdAdjusted;
    }
    /**
     * @return the lyAdjusted
     */
    public String getLyAdjusted() {
        return lyAdjusted;
    }
    /**
     * @param lyAdjusted the lyAdjusted to set
     */
    public void setLyAdjusted(String lyAdjusted) {
        this.lyAdjusted = lyAdjusted;
    }
    /**
     * @return the llyAdjusted
     */
    public String getLlyAdjusted() {
        return llyAdjusted;
    }
    /**
     * @param llyAdjusted the llyAdjusted to set
     */
    public void setLlyAdjusted(String llyAdjusted) {
        this.llyAdjusted = llyAdjusted;
    }
    /**
     * @return the ptdDamaged
     */
    public String getPtdDamaged() {
        return ptdDamaged;
    }
    /**
     * @param ptdDamaged the ptdDamaged to set
     */
    public void setPtdDamaged(String ptdDamaged) {
        this.ptdDamaged = ptdDamaged;
    }
    /**
     * @return the lyptdDamaged
     */
    public String getLyptdDamaged() {
        return lyptdDamaged;
    }
    /**
     * @param lyptdDamaged the lyptdDamaged to set
     */
    public void setLyptdDamaged(String lyptdDamaged) {
        this.lyptdDamaged = lyptdDamaged;
    }
    /**
     * @return the ytdDamaged
     */
    public String getYtdDamaged() {
        return ytdDamaged;
    }
    /**
     * @param ytdDamaged the ytdDamaged to set
     */
    public void setYtdDamaged(String ytdDamaged) {
        this.ytdDamaged = ytdDamaged;
    }
    /**
     * @return the lytdDamaged
     */
    public String getLytdDamaged() {
        return lytdDamaged;
    }
    /**
     * @param lytdDamaged the lytdDamaged to set
     */
    public void setLytdDamaged(String lytdDamaged) {
        this.lytdDamaged = lytdDamaged;
    }
    /**
     * @return the lyDamaged
     */
    public String getLyDamaged() {
        return lyDamaged;
    }
    /**
     * @param lyDamaged the lyDamaged to set
     */
    public void setLyDamaged(String lyDamaged) {
        this.lyDamaged = lyDamaged;
    }
    /**
     * @return the llyDamaged
     */
    public String getLlyDamaged() {
        return llyDamaged;
    }
    /**
     * @param llyDamaged the llyDamaged to set
     */
    public void setLlyDamaged(String llyDamaged) {
        this.llyDamaged = llyDamaged;
    }
    /**
     * @return the ptdUsed
     */
    public String getPtdUsed() {
        return ptdUsed;
    }
    /**
     * @param ptdUsed the ptdUsed to set
     */
    public void setPtdUsed(String ptdUsed) {
        this.ptdUsed = ptdUsed;
    }
    /**
     * @return the lyptdUsed
     */
    public String getLyptdUsed() {
        return lyptdUsed;
    }
    /**
     * @param lyptdUsed the lyptdUsed to set
     */
    public void setLyptdUsed(String lyptdUsed) {
        this.lyptdUsed = lyptdUsed;
    }
    /**
     * @return the ytdUsed
     */
    public String getYtdUsed() {
        return ytdUsed;
    }
    /**
     * @param ytdUsed the ytdUsed to set
     */
    public void setYtdUsed(String ytdUsed) {
        this.ytdUsed = ytdUsed;
    }
    /**
     * @return the lytdUsed
     */
    public String getLytdUsed() {
        return lytdUsed;
    }
    /**
     * @param lytdUsed the lytdUsed to set
     */
    public void setLytdUsed(String lytdUsed) {
        this.lytdUsed = lytdUsed;
    }
    /**
     * @return the lyUsed
     */
    public String getLyUsed() {
        return lyUsed;
    }
    /**
     * @param lyUsed the lyUsed to set
     */
    public void setLyUsed(String lyUsed) {
        this.lyUsed = lyUsed;
    }
    /**
     * @return the llyUsed
     */
    public String getLlyUsed() {
        return llyUsed;
    }
    /**
     * @param llyUsed the llyUsed to set
     */
    public void setLlyUsed(String llyUsed) {
        this.llyUsed = llyUsed;
    }
    /**
     * @return the ptdProduced
     */
    public String getPtdProduced() {
        return ptdProduced;
    }
    /**
     * @param ptdProduced the ptdProduced to set
     */
    public void setPtdProduced(String ptdProduced) {
        this.ptdProduced = ptdProduced;
    }
    /**
     * @return the lyptdProduced
     */
    public String getLyptdProduced() {
        return lyptdProduced;
    }
    /**
     * @param lyptdProduced the lyptdProduced to set
     */
    public void setLyptdProduced(String lyptdProduced) {
        this.lyptdProduced = lyptdProduced;
    }
    /**
     * @return the ytdProduced
     */
    public String getYtdProduced() {
        return ytdProduced;
    }
    /**
     * @param ytdProduced the ytdProduced to set
     */
    public void setYtdProduced(String ytdProduced) {
        this.ytdProduced = ytdProduced;
    }
    /**
     * @return the lytdProduced
     */
    public String getLytdProduced() {
        return lytdProduced;
    }
    /**
     * @param lytdProduced the lytdProduced to set
     */
    public void setLytdProduced(String lytdProduced) {
        this.lytdProduced = lytdProduced;
    }
    /**
     * @return the lyProduced
     */
    public String getLyProduced() {
        return lyProduced;
    }
    /**
     * @param lyProduced the lyProduced to set
     */
    public void setLyProduced(String lyProduced) {
        this.lyProduced = lyProduced;
    }
    /**
     * @return the llyProduced
     */
    public String getLlyProduced() {
        return llyProduced;
    }
    /**
     * @param llyProduced the llyProduced to set
     */
    public void setLlyProduced(String llyProduced) {
        this.llyProduced = llyProduced;
    }
    /**
     * @return the ptdPoReturn
     */
    public String getPtdPoReturn() {
        return ptdPoReturn;
    }
    /**
     * @param ptdPoReturn the ptdPoReturn to set
     */
    public void setPtdPoReturn(String ptdPoReturn) {
        this.ptdPoReturn = ptdPoReturn;
    }
    /**
     * @return the lyptdPoReturn
     */
    public String getLyptdPoReturn() {
        return lyptdPoReturn;
    }
    /**
     * @param lyptdPoReturn the lyptdPoReturn to set
     */
    public void setLyptdPoReturn(String lyptdPoReturn) {
        this.lyptdPoReturn = lyptdPoReturn;
    }
    /**
     * @return the ytdPoReturn
     */
    public String getYtdPoReturn() {
        return ytdPoReturn;
    }
    /**
     * @param ytdPoReturn the ytdPoReturn to set
     */
    public void setYtdPoReturn(String ytdPoReturn) {
        this.ytdPoReturn = ytdPoReturn;
    }
    /**
     * @return the lytdPoReturn
     */
    public String getLytdPoReturn() {
        return lytdPoReturn;
    }
    /**
     * @param lytdPoReturn the lytdPoReturn to set
     */
    public void setLytdPoReturn(String lytdPoReturn) {
        this.lytdPoReturn = lytdPoReturn;
    }
    /**
     * @return the lyPoReturn
     */
    public String getLyPoReturn() {
        return lyPoReturn;
    }
    /**
     * @param lyPoReturn the lyPoReturn to set
     */
    public void setLyPoReturn(String lyPoReturn) {
        this.lyPoReturn = lyPoReturn;
    }
    /**
     * @return the llyPoReturn
     */
    public String getLlyPoReturn() {
        return llyPoReturn;
    }
    /**
     * @param llyPoReturn the llyPoReturn to set
     */
    public void setLlyPoReturn(String llyPoReturn) {
        this.llyPoReturn = llyPoReturn;
    }
    /**
     * @return the ytdCountAdj
     */
    public String getYtdCountAdj() {
        return ytdCountAdj;
    }
    /**
     * @param ytdCountAdj the ytdCountAdj to set
     */
    public void setYtdCountAdj(String ytdCountAdj) {
        this.ytdCountAdj = ytdCountAdj;
    }
    /**
     * @return the lyCountAdj
     */
    public String getLyCountAdj() {
        return lyCountAdj;
    }
    /**
     * @param lyCountAdj the lyCountAdj to set
     */
    public void setLyCountAdj(String lyCountAdj) {
        this.lyCountAdj = lyCountAdj;
    }
    /**
     * @return the vendorStock
     */
    public String getVendorStock() {
        return vendorStock;
    }
    /**
     * @param vendorStock the vendorStock to set
     */
    public void setVendorStock(String vendorStock) {
        this.vendorStock = vendorStock;
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
     * @return the taxRegion
     */
    public String getTaxRegion() {
        return taxRegion;
    }
    /**
     * @param taxRegion the taxRegion to set
     */
    public void setTaxRegion(String taxRegion) {
        this.taxRegion = taxRegion;
    }
    /**
     * @return the prodCode
     */
    public String getProdCode() {
        return prodCode;
    }
    /**
     * @param prodCode the prodCode to set
     */
    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
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
     * @return the replCode
     */
    public String getReplCode() {
        return replCode;
    }
    /**
     * @param replCode the replCode to set
     */
    public void setReplCode(String replCode) {
        this.replCode = replCode;
    }
    /**
     * @return the autoCal
     */
    public String getAutoCal() {
        return autoCal;
    }
    /**
     * @param autoCal the autoCal to set
     */
    public void setAutoCal(String autoCal) {
        this.autoCal = autoCal;
    }
    /**
     * @return the mthForecast
     */
    public String getMthForecast() {
        return mthForecast;
    }
    /**
     * @param mthForecast the mthForecast to set
     */
    public void setMthForecast(String mthForecast) {
        this.mthForecast = mthForecast;
    }
    /**
     * @return the orderPoint
     */
    public String getOrderPoint() {
        return orderPoint;
    }
    /**
     * @param orderPoint the orderPoint to set
     */
    public void setOrderPoint(String orderPoint) {
        this.orderPoint = orderPoint;
    }
    /**
     * @return the lastForDate
     */
    public String getLastForDate() {
        return lastForDate;
    }
    /**
     * @param lastForDate the lastForDate to set
     */
    public void setLastForDate(String lastForDate) {
        this.lastForDate = lastForDate;
    }
    /**
     * @return the lastReqDate
     */
    public String getLastReqDate() {
        return lastReqDate;
    }
    /**
     * @param lastReqDate the lastReqDate to set
     */
    public void setLastReqDate(String lastReqDate) {
        this.lastReqDate = lastReqDate;
    }
    /**
     * @return the holdLots
     */
    public String getHoldLots() {
        return holdLots;
    }
    /**
     * @param holdLots the holdLots to set
     */
    public void setHoldLots(String holdLots) {
        this.holdLots = holdLots;
    }
    /**
     * @return the marginProtect
     */
    public String getMarginProtect() {
        return marginProtect;
    }
    /**
     * @param marginProtect the marginProtect to set
     */
    public void setMarginProtect(String marginProtect) {
        this.marginProtect = marginProtect;
    }
    /**
     * @return the marginSale
     */
    public String getMarginSale() {
        return marginSale;
    }
    /**
     * @param marginSale the marginSale to set
     */
    public void setMarginSale(String marginSale) {
        this.marginSale = marginSale;
    }
    /**
     * @return the sobrepedido
     */
    public String getSobrepedido() {
        return sobrepedido;
    }
    /**
     * @param sobrepedido the sobrepedido to set
     */
    public void setSobrepedido(String sobrepedido) {
        this.sobrepedido = sobrepedido;
    }
    /**
     * @return the diasSobrepedido
     */
    public String getDiasSobrepedido() {
        return diasSobrepedido;
    }
    /**
     * @param diasSobrepedido the diasSobrepedido to set
     */
    public void setDiasSobrepedido(String diasSobrepedido) {
        this.diasSobrepedido = diasSobrepedido;
    }
    /**
     * @return the fechaProxima
     */
    public String getFechaProxima() {
        return fechaProxima;
    }
    /**
     * @param fechaProxima the fechaProxima to set
     */
    public void setFechaProxima(String fechaProxima) {
        this.fechaProxima = fechaProxima;
    }
    
    
    
    
    public String getTieneExistencia() {
		return tieneExistencia;
	}




	public void setTieneExistencia(String tieneExistencia) {
		this.tieneExistencia = tieneExistencia;
	}




	@Override
	public String toString() {
		return "ItemW [whseCode=" + whseCode + ", itemNum=" + itemNum
				+ ", subItem=" + subItem + ", binCode=" + binCode + ", bin="
				+ bin + ", eoq=" + eoq + ", eoqClass=" + eoqClass + ", minQty="
				+ minQty + ", maxQty=" + maxQty + ", leadTime=" + leadTime
				+ ", listPrice=" + listPrice + ", palletDesc=" + palletDesc
				+ ", allowBo=" + allowBo + ", abcClass=" + abcClass
				+ ", vendorNum=" + vendorNum + ", vendorItem=" + vendorItem
				+ ", vendorDesc=" + vendorDesc + ", memo1=" + memo1
				+ ", memo2=" + memo2 + ", memo3=" + memo3 + ", dateCreated="
				+ dateCreated + ", custOrders=" + custOrders + ", onHand="
				+ onHand + ", level1Commit=" + level1Commit + ", level2Commit="
				+ level2Commit + ", futureOrder=" + futureOrder + ", tferIn="
				+ tferIn + ", tferOut=" + tferOut + ", tfer1Commit="
				+ tfer1Commit + ", tfer2Commit=" + tfer2Commit
				+ ", tferTransit=" + tferTransit + ", damaged=" + damaged
				+ ", onPurchase=" + onPurchase + ", dropShip=" + dropShip
				+ ", issued=" + issued + ", lastCost=" + lastCost
				+ ", avgCost=" + avgCost + ", fifoCost=" + fifoCost
				+ ", standardCost=" + standardCost + ", datePoLast="
				+ datePoLast + ", qtyPoLast=" + qtyPoLast + ", dateCountLast="
				+ dateCountLast + ", qtyCountLast=" + qtyCountLast
				+ ", dateSaleLast=" + dateSaleLast + ", qtySaleLast="
				+ qtySaleLast + ", dateAdjLast=" + dateAdjLast
				+ ", qtyAdjLast=" + qtyAdjLast + ", dateProdLast="
				+ dateProdLast + ", qtyProdLast=" + qtyProdLast + ", ptdBo="
				+ ptdBo + ", lyptdBo=" + lyptdBo + ", ytdBo=" + ytdBo
				+ ", lytdBo=" + lytdBo + ", lyBo=" + lyBo + ", llyBo=" + llyBo
				+ ", ptdCost=" + ptdCost + ", lyptdCost=" + lyptdCost
				+ ", ytdCost=" + ytdCost + ", lytdCost=" + lytdCost
				+ ", lyCost=" + lyCost + ", llyCost=" + llyCost
				+ ", ptdDropShip=" + ptdDropShip + ", lyptdDropShip="
				+ lyptdDropShip + ", ytdDropShip=" + ytdDropShip
				+ ", lytdDropShip=" + lytdDropShip + ", lyDropShip="
				+ lyDropShip + ", llyDropShip=" + llyDropShip
				+ ", ptdPurchased=" + ptdPurchased + ", lyptdPurchased="
				+ lyptdPurchased + ", ytdPurchased=" + ytdPurchased
				+ ", lytdPurchased=" + lytdPurchased + ", lyPurchased="
				+ lyPurchased + ", llyPurchased=" + llyPurchased
				+ ", ptdReceived=" + ptdReceived + ", lyptdReceived="
				+ lyptdReceived + ", ytdReceived=" + ytdReceived
				+ ", lytdReceived=" + lytdReceived + ", lyReceived="
				+ lyReceived + ", llyReceived=" + llyReceived
				+ ", ptdTransferred=" + ptdTransferred + ", lyptdTransferred="
				+ lyptdTransferred + ", ytdTransferred=" + ytdTransferred
				+ ", lytdTransferred=" + lytdTransferred + ", lyTransferred="
				+ lyTransferred + ", llyTransferred=" + llyTransferred
				+ ", ptdShipped=" + ptdShipped + ", lyptdShipped="
				+ lyptdShipped + ", ytdShipped=" + ytdShipped
				+ ", lytdShipped=" + lytdShipped + ", lyShipped=" + lyShipped
				+ ", llyShipped=" + llyShipped + ", ptdReturned=" + ptdReturned
				+ ", lyptdReturned=" + lyptdReturned + ", ytdReturned="
				+ ytdReturned + ", lytdReturned=" + lytdReturned
				+ ", lyReturned=" + lyReturned + ", llyReturned=" + llyReturned
				+ ", ptdAdjusted=" + ptdAdjusted + ", lyptdAdjusted="
				+ lyptdAdjusted + ", ytdAdjusted=" + ytdAdjusted
				+ ", lytdAdjusted=" + lytdAdjusted + ", lyAdjusted="
				+ lyAdjusted + ", llyAdjusted=" + llyAdjusted + ", ptdDamaged="
				+ ptdDamaged + ", lyptdDamaged=" + lyptdDamaged
				+ ", ytdDamaged=" + ytdDamaged + ", lytdDamaged=" + lytdDamaged
				+ ", lyDamaged=" + lyDamaged + ", llyDamaged=" + llyDamaged
				+ ", ptdUsed=" + ptdUsed + ", lyptdUsed=" + lyptdUsed
				+ ", ytdUsed=" + ytdUsed + ", lytdUsed=" + lytdUsed
				+ ", lyUsed=" + lyUsed + ", llyUsed=" + llyUsed
				+ ", ptdProduced=" + ptdProduced + ", lyptdProduced="
				+ lyptdProduced + ", ytdProduced=" + ytdProduced
				+ ", lytdProduced=" + lytdProduced + ", lyProduced="
				+ lyProduced + ", llyProduced=" + llyProduced
				+ ", ptdPoReturn=" + ptdPoReturn + ", lyptdPoReturn="
				+ lyptdPoReturn + ", ytdPoReturn=" + ytdPoReturn
				+ ", lytdPoReturn=" + lytdPoReturn + ", lyPoReturn="
				+ lyPoReturn + ", llyPoReturn=" + llyPoReturn
				+ ", ytdCountAdj=" + ytdCountAdj + ", lyCountAdj=" + lyCountAdj
				+ ", vendorStock=" + vendorStock + ", taxGrp1=" + taxGrp1
				+ ", taxGrp2=" + taxGrp2 + ", taxable=" + taxable
				+ ", orgCode=" + orgCode + ", taxRegion=" + taxRegion
				+ ", prodCode=" + prodCode + ", groupCode=" + groupCode
				+ ", replCode=" + replCode + ", autoCal=" + autoCal
				+ ", mthForecast=" + mthForecast + ", orderPoint=" + orderPoint
				+ ", lastForDate=" + lastForDate + ", lastReqDate="
				+ lastReqDate + ", holdLots=" + holdLots + ", marginProtect="
				+ marginProtect + ", marginSale=" + marginSale
				+ ", sobrepedido=" + sobrepedido + ", diasSobrepedido="
				+ diasSobrepedido + ", fechaProxima=" + fechaProxima
				+ ", totalExistencia=" + tieneExistencia + "]";
	}




	/* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    
}