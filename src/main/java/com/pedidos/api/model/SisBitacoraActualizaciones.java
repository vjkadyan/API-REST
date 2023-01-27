package com.pedidos.api.model;


public class SisBitacoraActualizaciones {

	private int id_modulo;
	private int id_sub_modulo;
	private String ip;
	private String terminal;
	private int num_empleado;
	private String fecha;
	private String instruccion;

	public int getIdModulo() {
		return id_modulo;
	}

	public void setIdModulo(int id_modulo) {
		this.id_modulo = id_modulo;
	}

	public int getIdSubModulo() {
		return id_sub_modulo;
	}

	public void setIdSubModulo(int id_sub_modulo) {
		this.id_sub_modulo = id_sub_modulo;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public int getNumEmpleado() {
		return num_empleado;
	}

	public void setNumEmpleado(int num_empleado) {
		this.num_empleado = num_empleado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getInstruccion() {
		return instruccion;
	}

	public void setInstruccion(String instruccion) {
		this.instruccion = instruccion;
	}

	@Override
	public String toString() {
		return "SisBitacoraActualizaciones [id_modulo=" + id_modulo + ", id_sub_modulo=" + id_sub_modulo + ", ip=" + ip + ", terminal=" + terminal + ", num_empleado=" + num_empleado + ", fecha=" + fecha + ", instruccion=" + instruccion + "]";
	}

}