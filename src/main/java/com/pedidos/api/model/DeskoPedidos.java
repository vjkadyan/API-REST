package com.pedidos.api.model;

import java.util.List;

import com.auth0.jwt.internal.com.fasterxml.jackson.annotation.JsonProperty;

public class DeskoPedidos {
	
	private List<DeskoItems> items;
	private long clienteNum;

	public DeskoPedidos() {
		super();
	}
	public DeskoPedidos(@JsonProperty ("items") List<DeskoItems> items) {
		super();
		this.items = items;
	}
	public List<DeskoItems> getItems() {
		return items;
	}
	public void setItems(List<DeskoItems> items) {
		this.items = items;
	}
	public long getClienteNum() {
		return clienteNum;
	}
	public void setClienteNum(long clienteNum) {
		this.clienteNum = clienteNum;
	}
	
	public String toString() {
		String deskoPedidos =  "DeskoPEdidos [ { items :  " + items + " , cliente_num : " + clienteNum + "} ]";
		return deskoPedidos;
	}
}