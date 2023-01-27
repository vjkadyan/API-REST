package com.pedidos.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PyGuiasDirecciones {

	private int cliente_num;
	private String nombre;
	private String apellido;
	private String direccion;
	private String calle;
	private String num_ext;
	private String num_int;
	private String colonia;
	private int cp;
	private String estado;
	private String delegacion;
	private String entre_calles;
	private String obs;
	private String contacto;
	private String telefono;
	private String extension;
	private String tipo;
	
	public PyGuiasDirecciones() {
		
	}

	@JsonCreator
	public PyGuiasDirecciones(@JsonProperty("cliente_num") int cliente_num, @JsonProperty("nombre") String nombre,
			@JsonProperty("apellido") String apellido, @JsonProperty("direccion") String direccion, @JsonProperty("calle") String calle,
			@JsonProperty("num_ext") String num_ext, @JsonProperty("num_int") String num_int, @JsonProperty("colonia") String colonia,
			@JsonProperty("cp") int cp, @JsonProperty("estado") String estado,
			@JsonProperty("delegacion") String delegacion, @JsonProperty("entre_calles") String entre_calles, 
			@JsonProperty("obs") String obs, @JsonProperty("contacto") String contacto,
			@JsonProperty("telefono") String telefono, @JsonProperty("extension") String extension, @JsonProperty("tipo") String tipo) {
		super();
		this.cliente_num = cliente_num;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.calle = calle;
		this.num_ext = num_ext;
		this.num_int = num_int;
		this.colonia = colonia;
		this.cp = cp;
		this.estado = estado;
		this.delegacion = delegacion;
		this.entre_calles = entre_calles;
		this.obs = obs;
		this.contacto = contacto;
		this.telefono = telefono;
		this.extension = extension;
		this.tipo = tipo;
	}
	
	public int getCliente_num() {
		return cliente_num;
	}

	public void setCliente_num(int cliente_num) {
		this.cliente_num = cliente_num;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNum_ext() {
		return num_ext;
	}

	public void setNum_ext(String num_ext) {
		this.num_ext = num_ext;
	}

	public String getNum_int() {
		return num_int;
	}

	public void setNum_int(String num_int) {
		this.num_int = num_int;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDelegacion() {
		return delegacion;
	}

	public void setDelegacion(String delegacion) {
		this.delegacion = delegacion;
	}

	public String getEntre_calles() {
		return entre_calles;
	}

	public void setEntre_calles(String entre_calles) {
		this.entre_calles = entre_calles;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "{cliente_num:" + cliente_num + ", nombre:" + nombre + ", apellido:" + apellido + ", direccion:"
				+ direccion + ", calle:" + calle + ", num_ext:" + num_ext + ", num_int:" + num_int + ", colonia:"
				+ colonia + ", cp:" + cp + ", estado:" + estado + ", delegacion:" + delegacion + ", entre_calles:"
				+ entre_calles + ", obs:" + obs + ", contacto:" + contacto + ", telefono:" + telefono + ", extension:"
				+ extension + ", tipo:" + tipo + "}";
	}	
}
