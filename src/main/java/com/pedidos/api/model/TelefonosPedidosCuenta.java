package com.pedidos.api.model;


import java.util.List;

public class TelefonosPedidosCuenta {
	
	private List<PyTelefonoCliente> ListPyTelefonoCliente;
	private List<PyCelularSms> listPyCelularSms;
	
	public TelefonosPedidosCuenta() {
		super();
	}
	
	public TelefonosPedidosCuenta(List<PyTelefonoCliente> listPyTelefonoCliente, List<PyCelularSms> listPyCelularSms) {
		super();
		ListPyTelefonoCliente = listPyTelefonoCliente;
		this.listPyCelularSms = listPyCelularSms;
	}
	
	public List<PyTelefonoCliente> getListPyTelefonoCliente() {
		return ListPyTelefonoCliente;
	}
	public void setListPyTelefonoCliente(List<PyTelefonoCliente> listPyTelefonoCliente) {
		ListPyTelefonoCliente = listPyTelefonoCliente;
	}
	public List<PyCelularSms> getListPyCelularSms() {
		return listPyCelularSms;
	}
	public void setListPyCelularSms(List<PyCelularSms> listPyCelularSms) {
		this.listPyCelularSms = listPyCelularSms;
	}

	@Override
	public String toString() {
		return "{ListPyTelefonoCliente:" + ListPyTelefonoCliente + ", listPyCelularSms:" + listPyCelularSms + "}";
	}

}