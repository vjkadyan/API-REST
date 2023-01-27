package com.pedidos.api.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TipoMiCuenta {
 
	private Long clienteNum;
	private Long usuarioNum;
	private String nombre;
	private String apellido;
	private String empresa;
	private String fechaNac;
	private String fechaReg;
	private String enviaMsg;
	private String entregaCliente;
	private String tipoCuenta;
	private String celularPrinc;
	private String telefonoPrinc;

	public TipoMiCuenta() {

	}

	@JsonCreator
	public TipoMiCuenta(@JsonProperty("clienteNum") Long clienteNum, @JsonProperty("usuarioNum") Long usuarioNum,
			@JsonProperty("nombre") String nombre, @JsonProperty("apellido") String apellido, @JsonProperty("empresa") String empresa,
			@JsonProperty("fechaNac") String fechaNac, @JsonProperty("fechaReg") String fechaReg, @JsonProperty("enviaMsg") String enviaMsg,
			@JsonProperty("entregaCliente") String entregaCliente, @JsonProperty("tipoCuenta") String tipoCuenta,
			@JsonProperty("celularPrinc") String celularPrinc, @JsonProperty("telefonoPrinc") String telefonoPrinc) {
		super();
		this.clienteNum = clienteNum;
		this.usuarioNum = usuarioNum;
		this.nombre = nombre;
		this.apellido = apellido;
		this.empresa = empresa;
		this.fechaNac = fechaNac;
		this.fechaReg = fechaReg;
		this.enviaMsg = enviaMsg;
		this.entregaCliente = entregaCliente;
		this.tipoCuenta = tipoCuenta;
		this.celularPrinc = celularPrinc;
		this.telefonoPrinc = telefonoPrinc;
	}
	

	public TipoMiCuenta(String vacio) {
		super();
		this.clienteNum = 0L;
		this.usuarioNum = 0L;
		this.nombre = vacio;
		this.apellido = vacio;
		this.empresa = vacio;
		this.fechaNac = vacio;
		this.fechaReg = vacio;
		this.enviaMsg = vacio;
		this.entregaCliente = vacio;
		this.tipoCuenta = vacio;
		this.celularPrinc = vacio;
		this.telefonoPrinc = vacio;
	}

	public Long getClienteNum() {
		return clienteNum;
	}

	public void setClienteNum(Long clienteNum) {
		this.clienteNum = clienteNum;
	}

	public Long getUsuarioNum() {
		return usuarioNum;
	}

	public void setUsuarioNum(Long usuarioNum) {
		this.usuarioNum = usuarioNum;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(String fechaReg) {
		this.fechaReg = fechaReg;
	}

	public String getEnviaMsg() {
		return enviaMsg;
	}

	public void setEnviaMsg(String enviaMsg) {
		this.enviaMsg = enviaMsg;
	}

	public String getEntregaCliente() {
		return entregaCliente;
	}

	public void setEntregaCliente(String entregaCliente) {
		this.entregaCliente = entregaCliente;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public String getCelularPrinc() {
		return celularPrinc;
	}

	public void setCelularPrinc(String celularPrinc) {
		this.celularPrinc = celularPrinc;
	}

	public String getTelefonoPrinc() {
		return telefonoPrinc;
	}

	public void setTelefonoPrinc(String telefonoPrinc) {
		this.telefonoPrinc = telefonoPrinc;
	}

	@Override
	public String toString() {
		return "{clienteNum:" + clienteNum + ", usuarioNum:" + usuarioNum + ", nombre:" + nombre + ", apellido:"
				+ apellido + ", empresa:" + empresa + ", fechaNac:" + fechaNac + ", fechaReg:" + fechaReg
				+ ", enviaMsg:" + enviaMsg + ", entregaCliente:" + entregaCliente + ", tipoCuenta:" + tipoCuenta
				+ ", celularPrinc:" + celularPrinc + ", telefonoPrinc:" + telefonoPrinc + "}";
	}

}