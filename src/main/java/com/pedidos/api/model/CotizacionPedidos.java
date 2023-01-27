package com.pedidos.api.model;

import java.util.List;

public class CotizacionPedidos {
	
	private List<String> emails;
	private int clienteNum;
	private int custNum;
	private List<CotizacionItems> items;
	private int ejecutivo;
	private int dirNum;
	private long pedidoNum;
	private String nombre;
	private String pass;
	private String usuario;
	private CotizacionEjecutivod ejecutivod;
	private CotizacionEncabezado encabezado;
	
	public CotizacionPedidos() {
	}

	public CotizacionPedidos(List<String> emails, int clienteNum, int custNum, List<CotizacionItems> items, int ejecutivo,
			int dirNum, CotizacionEjecutivod ejecutivod, CotizacionEncabezado encabezado) {
		super();
		this.emails = emails;
		this.clienteNum = clienteNum;
		this.custNum = custNum;
		this.items = items;
		this.ejecutivo = ejecutivo;
		this.dirNum = dirNum;
		this.ejecutivod = ejecutivod;
		this.encabezado = encabezado;
	}

	public long getPedidoNum() {
		return pedidoNum;
	}

	public void setPedidoNum(long pedidoNum) {
		this.pedidoNum = pedidoNum;
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

	public List<CotizacionItems> getItems() {
		return items;
	}

	public void setItems(List<CotizacionItems> items) {
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

	public CotizacionEjecutivod getEjecutivod() {
		return ejecutivod;
	}

	public void setEjecutivod(CotizacionEjecutivod ejecutivod) {
		this.ejecutivod = ejecutivod;
	}

	public CotizacionEncabezado getEncabezado() {
		return encabezado;
	}

	public void setEncabezado(CotizacionEncabezado encabezado) {
		this.encabezado = encabezado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "CotizacionPedidos [emails=" + emails + ", clienteNum=" + clienteNum + ", custNum=" + custNum
				+ ", items=" + items + ", ejecutivo=" + ejecutivo + ", dirNum=" + dirNum + ", pedidoNum=" + pedidoNum
				+ ", nombre=" + nombre + ", pass=" + pass + ", usuario=" + usuario + ", ejecutivod=" + ejecutivod
				+ ", encabezado=" + encabezado + "]";
	}
}
