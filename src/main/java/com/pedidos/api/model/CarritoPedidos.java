package com.pedidos.api.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CarritoPedidos {
	
	private List<String> emails;
	private int clienteNum;
	private int custNum;
	private List<CarritoPedidosItems> items;
	private int ejecutivo;
	private int dirNum;
	private int rfcNum;
	private String cuponDesc;
	private Integer idGuia;
	
	public CarritoPedidos() {
	}

	@JsonCreator
	public CarritoPedidos(@JsonProperty("emails") List<String> emails,
						@JsonProperty("clienteNum") int clienteNum, 
						@JsonProperty("custNum") int custNum, 
						@JsonProperty("items") List<CarritoPedidosItems> items, 
						@JsonProperty("ejecutivo") int ejecutivo,
						@JsonProperty("dirNum") int dirNum,
						@JsonProperty("cuponDesc") String cuponDesc,
						@JsonProperty("rfcNum") int rfcNum,
						@JsonProperty("idGuia") Integer idGuia) {
		this.emails = emails;
		this.clienteNum = clienteNum;
		this.custNum = custNum;
		this.items = items;
		this.ejecutivo = ejecutivo;
		this.dirNum = dirNum;
		this.rfcNum = rfcNum;
		this.cuponDesc = cuponDesc;
		this.idGuia = idGuia;
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public int getClienteNum() {
		return clienteNum;
	}

	public void setClienteNum(int clienteNum) {
		this.clienteNum = clienteNum;
	}

	public int getCustNum() {
		return custNum;
	}

	public void setCustNum(int custNum) {
		this.custNum = custNum;
	}

	public List<CarritoPedidosItems> getItems() {
		return items;
	}

	public void setItems(List<CarritoPedidosItems> items) {
		this.items = items;
	}

	public int getEjecutivo() {
		return ejecutivo;
	}

	public void setEjecutivo(int ejecutivo) {
		this.ejecutivo = ejecutivo;
	}

	public int getDirNum() {
		return dirNum;
	}

	public void setDirNum(int dirNum) {
		this.dirNum = dirNum;
	}

	public int getRfcNum() {
		return rfcNum;
	}

	public void setRfcNum(int rfcNum) {
		this.rfcNum = rfcNum;
	}

	public String getCuponDesc() {
		return cuponDesc;
	}

	public void setCuponDesc(String cuponDesc) {
		this.cuponDesc = cuponDesc;
	}

	public Integer getIdGuia() {
		return idGuia;
	}

	public void setIdGuia(Integer idGuia) {
		this.idGuia = idGuia;
	}

	@Override
	public String toString() {
		return "CarritoPedidos [emails=" + emails + ", clienteNum=" + clienteNum + ", custNum=" + custNum + ", items="
				+ items + ", ejecutivo=" + ejecutivo + ", dirNum=" + dirNum + ", rfcNum=" + rfcNum + ", cuponDesc="
				+ cuponDesc + ", idGuia=" + idGuia + "]";
	}
}
