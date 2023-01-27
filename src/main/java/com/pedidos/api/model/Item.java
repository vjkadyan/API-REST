package com.pedidos.api.model;

import java.util.List;

public class Item {
    private String itemNum;
    private String desc1;
    private String desc2;
    private String sortName;
    private String packDesc;
    private String sizeDesc;
    private String reportSeq;
    private String costCode;
    private double volume;
    private double netWeight;
    private double grossWeight;
    private String costMethod;
    private String commissFlag;
    private String trackSales;
    private String stockUom;
    private String alt1Uom;
    private String alt1Mult;
    private String alt1Type;
    private String alt2Uom;
    private String alt2Mult;
    private String alt2Type;
    private String alt3Uom;
    private String alt3Mult;
    private String alt3Type;
    private String alt4Uom;
    private String alt4Mult;
    private String alt4Type;
    private String alt5Uom;
    private String alt5Mult;
    private String alt5Type;
    private String saItem;
    private String saItem2;
    private String glCode;
    private String itemGroup;
    private String commissGroup;
    private String upc;
    private String salesId;
    private String manuCode;
    private String serialLot;
    private String itemType;
    private String memo1;
    private String memo2;
    private String memo3;
    private String dateCreated;
    private String stat;
    private String glInventory;
    private String decimalOption;
    private String prodCode;
    private String taxGrp1;
    private String taxGrp2;
    private String extendDesc;
    private String qtyParcel;
    private String parcelVal;
    private String warrantyDays;
    private String lotExpiryDays;
    private String msdsGroup;
    private String invoiceGrp;
    private String singleLot;
    private String trackLot;
    private String currCode;
    private String condicion;
    private String fam;
    private String tipoEnsamble;
    private String tipoArticulo;
    private String estatusProp;
    private String listable;
    private String codigoLargo;
    private String descAlmacen;
    private String porPronto;
    private String tope;
    private String limite;
    private String costoEnvio;
    private String ventaUsd;
    private String garantia;
    private String aceptaDev;
    private String claveAlmacen;
    private String subfamilia;
    private String descripcion;
    private String envioForaneo;
    private String envioSLocal;
    private String envioSForaneo;
    private String claveCartucho;
    
    private List<ItemW> listItemW;

    
    /**
     * Contructor de la clase Item
     * @param itemNum
     */
    public Item(String itemNum) {
        super();
        this.itemNum = itemNum;
    }

    /**
     * Controcutor de la clase Item
     */
    public Item() {
        super();
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
     * @return the desc1
     */
    public String getDesc1() {
        return desc1;
    }

    /**
     * @param desc1 the desc1 to set
     */
    public void setDesc1(String desc1) {
        this.desc1 = desc1;
    }

    /**
     * @return the desc2
     */
    public String getDesc2() {
        return desc2;
    }

    /**
     * @param desc2 the desc2 to set
     */
    public void setDesc2(String desc2) {
        this.desc2 = desc2;
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
     * @return the reportSeq
     */
    public String getReportSeq() {
        return reportSeq;
    }

    /**
     * @param reportSeq the reportSeq to set
     */
    public void setReportSeq(String reportSeq) {
        this.reportSeq = reportSeq;
    }

    /**
     * @return the costCode
     */
    public String getCostCode() {
        return costCode;
    }

    /**
     * @param costCode the costCode to set
     */
    public void setCostCode(String costCode) {
        this.costCode = costCode;
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
     * @return the netWeight
     */
    public double getNetWeight() {
        return netWeight;
    }

    /**
     * @param netWeight the netWeight to set
     */
    public void setNetWeight(double netWeight) {
        this.netWeight = netWeight;
    }

    /**
     * @return the grossWeight
     */
    public double getGrossWeight() {
        return grossWeight;
    }

    /**
     * @param grossWeight the grossWeight to set
     */
    public void setGrossWeight(double grossWeight) {
        this.grossWeight = grossWeight;
    }

    /**
     * @return the costMethod
     */
    public String getCostMethod() {
        return costMethod;
    }

    /**
     * @param costMethod the costMethod to set
     */
    public void setCostMethod(String costMethod) {
        this.costMethod = costMethod;
    }

    /**
     * @return the commissFlag
     */
    public String getCommissFlag() {
        return commissFlag;
    }

    /**
     * @param commissFlag the commissFlag to set
     */
    public void setCommissFlag(String commissFlag) {
        this.commissFlag = commissFlag;
    }

    /**
     * @return the trackSales
     */
    public String getTrackSales() {
        return trackSales;
    }

    /**
     * @param trackSales the trackSales to set
     */
    public void setTrackSales(String trackSales) {
        this.trackSales = trackSales;
    }

    /**
     * @return the stockUom
     */
    public String getStockUom() {
        return stockUom;
    }

    /**
     * @param stockUom the stockUom to set
     */
    public void setStockUom(String stockUom) {
        this.stockUom = stockUom;
    }

    /**
     * @return the alt1Uom
     */
    public String getAlt1Uom() {
        return alt1Uom;
    }

    /**
     * @param alt1Uom the alt1Uom to set
     */
    public void setAlt1Uom(String alt1Uom) {
        this.alt1Uom = alt1Uom;
    }

    /**
     * @return the alt1Mult
     */
    public String getAlt1Mult() {
        return alt1Mult;
    }

    /**
     * @param alt1Mult the alt1Mult to set
     */
    public void setAlt1Mult(String alt1Mult) {
        this.alt1Mult = alt1Mult;
    }

    /**
     * @return the alt1Type
     */
    public String getAlt1Type() {
        return alt1Type;
    }

    /**
     * @param alt1Type the alt1Type to set
     */
    public void setAlt1Type(String alt1Type) {
        this.alt1Type = alt1Type;
    }

    /**
     * @return the alt2Uom
     */
    public String getAlt2Uom() {
        return alt2Uom;
    }

    /**
     * @param alt2Uom the alt2Uom to set
     */
    public void setAlt2Uom(String alt2Uom) {
        this.alt2Uom = alt2Uom;
    }

    /**
     * @return the alt2Mult
     */
    public String getAlt2Mult() {
        return alt2Mult;
    }

    /**
     * @param alt2Mult the alt2Mult to set
     */
    public void setAlt2Mult(String alt2Mult) {
        this.alt2Mult = alt2Mult;
    }

    /**
     * @return the alt2Type
     */
    public String getAlt2Type() {
        return alt2Type;
    }

    /**
     * @param alt2Type the alt2Type to set
     */
    public void setAlt2Type(String alt2Type) {
        this.alt2Type = alt2Type;
    }

    /**
     * @return the alt3Uom
     */
    public String getAlt3Uom() {
        return alt3Uom;
    }

    /**
     * @param alt3Uom the alt3Uom to set
     */
    public void setAlt3Uom(String alt3Uom) {
        this.alt3Uom = alt3Uom;
    }

    /**
     * @return the alt3Mult
     */
    public String getAlt3Mult() {
        return alt3Mult;
    }

    /**
     * @param alt3Mult the alt3Mult to set
     */
    public void setAlt3Mult(String alt3Mult) {
        this.alt3Mult = alt3Mult;
    }

    /**
     * @return the alt3Type
     */
    public String getAlt3Type() {
        return alt3Type;
    }

    /**
     * @param alt3Type the alt3Type to set
     */
    public void setAlt3Type(String alt3Type) {
        this.alt3Type = alt3Type;
    }

    /**
     * @return the alt4Uom
     */
    public String getAlt4Uom() {
        return alt4Uom;
    }

    /**
     * @param alt4Uom the alt4Uom to set
     */
    public void setAlt4Uom(String alt4Uom) {
        this.alt4Uom = alt4Uom;
    }

    /**
     * @return the alt4Mult
     */
    public String getAlt4Mult() {
        return alt4Mult;
    }

    /**
     * @param alt4Mult the alt4Mult to set
     */
    public void setAlt4Mult(String alt4Mult) {
        this.alt4Mult = alt4Mult;
    }

    /**
     * @return the alt4Type
     */
    public String getAlt4Type() {
        return alt4Type;
    }

    /**
     * @param alt4Type the alt4Type to set
     */
    public void setAlt4Type(String alt4Type) {
        this.alt4Type = alt4Type;
    }

    /**
     * @return the alt5Uom
     */
    public String getAlt5Uom() {
        return alt5Uom;
    }

    /**
     * @param alt5Uom the alt5Uom to set
     */
    public void setAlt5Uom(String alt5Uom) {
        this.alt5Uom = alt5Uom;
    }

    /**
     * @return the alt5Mult
     */
    public String getAlt5Mult() {
        return alt5Mult;
    }

    /**
     * @param alt5Mult the alt5Mult to set
     */
    public void setAlt5Mult(String alt5Mult) {
        this.alt5Mult = alt5Mult;
    }

    /**
     * @return the alt5Type
     */
    public String getAlt5Type() {
        return alt5Type;
    }

    /**
     * @param alt5Type the alt5Type to set
     */
    public void setAlt5Type(String alt5Type) {
        this.alt5Type = alt5Type;
    }

    /**
     * @return the saItem
     */
    public String getSaItem() {
        return saItem;
    }

    /**
     * @param saItem the saItem to set
     */
    public void setSaItem(String saItem) {
        this.saItem = saItem;
    }

    /**
     * @return the saItem2
     */
    public String getSaItem2() {
        return saItem2;
    }

    /**
     * @param saItem2 the saItem2 to set
     */
    public void setSaItem2(String saItem2) {
        this.saItem2 = saItem2;
    }

    /**
     * @return the glCode
     */
    public String getGlCode() {
        return glCode;
    }

    /**
     * @param glCode the glCode to set
     */
    public void setGlCode(String glCode) {
        this.glCode = glCode;
    }

    /**
     * @return the itemGroup
     */
    public String getItemGroup() {
        return itemGroup;
    }

    /**
     * @param itemGroup the itemGroup to set
     */
    public void setItemGroup(String itemGroup) {
        this.itemGroup = itemGroup;
    }

    /**
     * @return the commissGroup
     */
    public String getCommissGroup() {
        return commissGroup;
    }

    /**
     * @param commissGroup the commissGroup to set
     */
    public void setCommissGroup(String commissGroup) {
        this.commissGroup = commissGroup;
    }

    /**
     * @return the upc
     */
    public String getUpc() {
        return upc;
    }

    /**
     * @param upc the upc to set
     */
    public void setUpc(String upc) {
        this.upc = upc;
    }

    /**
     * @return the salesId
     */
    public String getSalesId() {
        return salesId;
    }

    /**
     * @param salesId the salesId to set
     */
    public void setSalesId(String salesId) {
        this.salesId = salesId;
    }

    /**
     * @return the manuCode
     */
    public String getManuCode() {
        return manuCode;
    }

    /**
     * @param manuCode the manuCode to set
     */
    public void setManuCode(String manuCode) {
        this.manuCode = manuCode;
    }

    /**
     * @return the serialLot
     */
    public String getSerialLot() {
        return serialLot;
    }

    /**
     * @param serialLot the serialLot to set
     */
    public void setSerialLot(String serialLot) {
        this.serialLot = serialLot;
    }

    /**
     * @return the itemType
     */
    public String getItemType() {
        return itemType;
    }

    /**
     * @param itemType the itemType to set
     */
    public void setItemType(String itemType) {
        this.itemType = itemType;
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
     * @return the stat
     */
    public String getStat() {
        return stat;
    }

    /**
     * @param stat the stat to set
     */
    public void setStat(String stat) {
        this.stat = stat;
    }

    /**
     * @return the glInventory
     */
    public String getGlInventory() {
        return glInventory;
    }

    /**
     * @param glInventory the glInventory to set
     */
    public void setGlInventory(String glInventory) {
        this.glInventory = glInventory;
    }

    /**
     * @return the decimalOption
     */
    public String getDecimalOption() {
        return decimalOption;
    }

    /**
     * @param decimalOption the decimalOption to set
     */
    public void setDecimalOption(String decimalOption) {
        this.decimalOption = decimalOption;
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
     * @return the extendDesc
     */
    public String getExtendDesc() {
        return extendDesc;
    }

    /**
     * @param extendDesc the extendDesc to set
     */
    public void setExtendDesc(String extendDesc) {
        this.extendDesc = extendDesc;
    }

    /**
     * @return the qtyParcel
     */
    public String getQtyParcel() {
        return qtyParcel;
    }

    /**
     * @param qtyParcel the qtyParcel to set
     */
    public void setQtyParcel(String qtyParcel) {
        this.qtyParcel = qtyParcel;
    }

    /**
     * @return the parcelVal
     */
    public String getParcelVal() {
        return parcelVal;
    }

    /**
     * @param parcelVal the parcelVal to set
     */
    public void setParcelVal(String parcelVal) {
        this.parcelVal = parcelVal;
    }

    /**
     * @return the warrantyDays
     */
    public String getWarrantyDays() {
        return warrantyDays;
    }

    /**
     * @param warrantyDays the warrantyDays to set
     */
    public void setWarrantyDays(String warrantyDays) {
        this.warrantyDays = warrantyDays;
    }

    /**
     * @return the lotExpiryDays
     */
    public String getLotExpiryDays() {
        return lotExpiryDays;
    }

    /**
     * @param lotExpiryDays the lotExpiryDays to set
     */
    public void setLotExpiryDays(String lotExpiryDays) {
        this.lotExpiryDays = lotExpiryDays;
    }

    /**
     * @return the msdsGroup
     */
    public String getMsdsGroup() {
        return msdsGroup;
    }

    /**
     * @param msdsGroup the msdsGroup to set
     */
    public void setMsdsGroup(String msdsGroup) {
        this.msdsGroup = msdsGroup;
    }

    /**
     * @return the invoiceGrp
     */
    public String getInvoiceGrp() {
        return invoiceGrp;
    }

    /**
     * @param invoiceGrp the invoiceGrp to set
     */
    public void setInvoiceGrp(String invoiceGrp) {
        this.invoiceGrp = invoiceGrp;
    }

    /**
     * @return the singleLot
     */
    public String getSingleLot() {
        return singleLot;
    }

    /**
     * @param singleLot the singleLot to set
     */
    public void setSingleLot(String singleLot) {
        this.singleLot = singleLot;
    }

    /**
     * @return the trackLot
     */
    public String getTrackLot() {
        return trackLot;
    }

    /**
     * @param trackLot the trackLot to set
     */
    public void setTrackLot(String trackLot) {
        this.trackLot = trackLot;
    }

    /**
     * @return the currCode
     */
    public String getCurrCode() {
        return currCode;
    }

    /**
     * @param currCode the currCode to set
     */
    public void setCurrCode(String currCode) {
        this.currCode = currCode;
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
     * @return the tipoEnsamble
     */
    public String getTipoEnsamble() {
        return tipoEnsamble;
    }

    /**
     * @param tipoEnsamble the tipoEnsamble to set
     */
    public void setTipoEnsamble(String tipoEnsamble) {
        this.tipoEnsamble = tipoEnsamble;
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
     * @return the estatusProp
     */
    public String getEstatusProp() {
        return estatusProp;
    }

    /**
     * @param estatusProp the estatusProp to set
     */
    public void setEstatusProp(String estatusProp) {
        this.estatusProp = estatusProp;
    }

    /**
     * @return the listable
     */
    public String getListable() {
        return listable;
    }

    /**
     * @param listable the listable to set
     */
    public void setListable(String listable) {
        this.listable = listable;
    }

    /**
     * @return the codigoLargo
     */
    public String getCodigoLargo() {
        return codigoLargo;
    }

    /**
     * @param codigoLargo the codigoLargo to set
     */
    public void setCodigoLargo(String codigoLargo) {
        this.codigoLargo = codigoLargo;
    }

    /**
     * @return the descAlmacen
     */
    public String getDescAlmacen() {
        return descAlmacen;
    }

    /**
     * @param descAlmacen the descAlmacen to set
     */
    public void setDescAlmacen(String descAlmacen) {
        this.descAlmacen = descAlmacen;
    }

    /**
     * @return the porPronto
     */
    public String getPorPronto() {
        return porPronto;
    }

    /**
     * @param porPronto the porPronto to set
     */
    public void setPorPronto(String porPronto) {
        this.porPronto = porPronto;
    }

    /**
     * @return the tope
     */
    public String getTope() {
        return tope;
    }

    /**
     * @param tope the tope to set
     */
    public void setTope(String tope) {
        this.tope = tope;
    }

    /**
     * @return the limite
     */
    public String getLimite() {
        return limite;
    }

    /**
     * @param limite the limite to set
     */
    public void setLimite(String limite) {
        this.limite = limite;
    }

    /**
     * @return the costoEnvio
     */
    public String getCostoEnvio() {
        return costoEnvio;
    }

    /**
     * @param costoEnvio the costoEnvio to set
     */
    public void setCostoEnvio(String costoEnvio) {
        this.costoEnvio = costoEnvio;
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

    /**
     * @return the garantia
     */
    public String getGarantia() {
        return garantia;
    }

    /**
     * @param garantia the garantia to set
     */
    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    /**
     * @return the aceptaDev
     */
    public String getAceptaDev() {
        return aceptaDev;
    }

    /**
     * @param aceptaDev the aceptaDev to set
     */
    public void setAceptaDev(String aceptaDev) {
        this.aceptaDev = aceptaDev;
    }

    /**
     * @return the claveAlmacen
     */
    public String getClaveAlmacen() {
        return claveAlmacen;
    }

    /**
     * @param claveAlmacen the claveAlmacen to set
     */
    public void setClaveAlmacen(String claveAlmacen) {
        this.claveAlmacen = claveAlmacen;
    }

    /**
     * @return the subfamilia
     */
    public String getSubfamilia() {
        return subfamilia;
    }

    /**
     * @param subfamilia the subfamilia to set
     */
    public void setSubfamilia(String subfamilia) {
        this.subfamilia = subfamilia;
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
     * @return the envioForaneo
     */
    public String getEnvioForaneo() {
        return envioForaneo;
    }

    /**
     * @param envioForaneo the envioForaneo to set
     */
    public void setEnvioForaneo(String envioForaneo) {
        this.envioForaneo = envioForaneo;
    }

    /**
     * @return the envioSLocal
     */
    public String getEnvioSLocal() {
        return envioSLocal;
    }

    /**
     * @param envioSLocal the envioSLocal to set
     */
    public void setEnvioSLocal(String envioSLocal) {
        this.envioSLocal = envioSLocal;
    }

    /**
     * @return the envioSForaneo
     */
    public String getEnvioSForaneo() {
        return envioSForaneo;
    }

    /**
     * @param envioSForaneo the envioSForaneo to set
     */
    public void setEnvioSForaneo(String envioSForaneo) {
        this.envioSForaneo = envioSForaneo;
    }

    /**
     * @return the claveCartucho
     */
    public String getClaveCartucho() {
        return claveCartucho;
    }

    /**
     * @param claveCartucho the claveCartucho to set
     */
    public void setClaveCartucho(String claveCartucho) {
        this.claveCartucho = claveCartucho;
    }

    /**
     * @return the listItemW
     */
    public List<ItemW> getListItemW() {
        return listItemW;
    }

    /**
     * @param listItemW the listItemW to set
     */
    public void setListItemW(List<ItemW> listItemW) {
        this.listItemW = listItemW;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Item [itemNum=" + itemNum + ", desc1=" + desc1 + ", desc2="
                + desc2 + ", sortName=" + sortName + ", packDesc=" + packDesc
                + ", sizeDesc=" + sizeDesc + ", reportSeq=" + reportSeq
                + ", costCode=" + costCode + ", volume=" + volume
                + ", netWeight=" + netWeight + ", grossWeight=" + grossWeight
                + ", costMethod=" + costMethod + ", commissFlag=" + commissFlag
                + ", trackSales=" + trackSales + ", stockUom=" + stockUom
                + ", alt1Uom=" + alt1Uom + ", alt1Mult=" + alt1Mult
                + ", alt1Type=" + alt1Type + ", alt2Uom=" + alt2Uom
                + ", alt2Mult=" + alt2Mult + ", alt2Type=" + alt2Type
                + ", alt3Uom=" + alt3Uom + ", alt3Mult=" + alt3Mult
                + ", alt3Type=" + alt3Type + ", alt4Uom=" + alt4Uom
                + ", alt4Mult=" + alt4Mult + ", alt4Type=" + alt4Type
                + ", alt5Uom=" + alt5Uom + ", alt5Mult=" + alt5Mult
                + ", alt5Type=" + alt5Type + ", saItem=" + saItem
                + ", saItem2=" + saItem2 + ", glCode=" + glCode
                + ", itemGroup=" + itemGroup + ", commissGroup=" + commissGroup
                + ", upc=" + upc + ", salesId=" + salesId + ", manuCode="
                + manuCode + ", serialLot=" + serialLot + ", itemType="
                + itemType + ", memo1=" + memo1 + ", memo2=" + memo2
                + ", memo3=" + memo3 + ", dateCreated=" + dateCreated
                + ", stat=" + stat + ", glInventory=" + glInventory
                + ", decimalOption=" + decimalOption + ", prodCode=" + prodCode
                + ", taxGrp1=" + taxGrp1 + ", taxGrp2=" + taxGrp2
                + ", extendDesc=" + extendDesc + ", qtyParcel=" + qtyParcel
                + ", parcelVal=" + parcelVal + ", warrantyDays=" + warrantyDays
                + ", lotExpiryDays=" + lotExpiryDays + ", msdsGroup="
                + msdsGroup + ", invoiceGrp=" + invoiceGrp + ", singleLot="
                + singleLot + ", trackLot=" + trackLot + ", currCode="
                + currCode + ", condicion=" + condicion + ", fam=" + fam
                + ", tipoEnsamble=" + tipoEnsamble + ", tipoArticulo="
                + tipoArticulo + ", estatusProp=" + estatusProp + ", listable="
                + listable + ", codigoLargo=" + codigoLargo + ", descAlmacen="
                + descAlmacen + ", porPronto=" + porPronto + ", tope=" + tope
                + ", limite=" + limite + ", costoEnvio=" + costoEnvio
                + ", ventaUsd=" + ventaUsd + ", garantia=" + garantia
                + ", aceptaDev=" + aceptaDev + ", claveAlmacen=" + claveAlmacen
                + ", subfamilia=" + subfamilia + ", descripcion=" + descripcion
                + ", envioForaneo=" + envioForaneo + ", envioSLocal="
                + envioSLocal + ", envioSForaneo=" + envioSForaneo
                + ", claveCartucho=" + claveCartucho + ", listItemW="
                + listItemW + "]";
    }
    
}