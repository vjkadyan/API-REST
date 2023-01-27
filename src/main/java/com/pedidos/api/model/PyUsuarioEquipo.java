package com.pedidos.api.model;

public class PyUsuarioEquipo {
	 
		private Long clienteNum;
		private Long usuarioNum;
		private String cargo;
		private int accionNum;
		private String fechaRegistro;
		private String identificador;
		private String celularPrinc;
		private String telefonoPrinc;
		private String status;
		
		private String nombre;
		private String apellido;
		private String empresa;
		private String tipoCuenta;
		
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
		
		public String getCargo() {
			return cargo;
		}
		
		public void setCargo(String cargo) {
			this.cargo = cargo;
		}
		
		public int getAccionNum() {
			return accionNum;
		}
		
		public void setAccionNum(int accionNum) {
			this.accionNum = accionNum;
		}
		
		public String getFechaRegistro() {
			return fechaRegistro;
		}
		
		public void setFechaRegistro(String fechaRegistro) {
			this.fechaRegistro = fechaRegistro;
		}
		
		public String getIdentificador() {
			return identificador;
		}
		
		public void setIdentificador(String identificador) {
			this.identificador = identificador;
		}
		
		public String getStatus() {
			return status;
		}
		
		public void setStatus(String status) {
			this.status = status;
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
			return "PyUsuarioEquipo [clienteNum=" + clienteNum + ", usuarioNum=" + usuarioNum + ", cargo=" + cargo + ", accionNum=" + accionNum + ", fechaRegistro=" + fechaRegistro + ", identificador=" + identificador + ", celularPrinc=" + celularPrinc + ", telefonoPrinc=" + telefonoPrinc + ", status=" + status + ", nombre=" + nombre + ", apellido=" + apellido + ", empresa=" + empresa + ", tipoCuenta=" + tipoCuenta + "]";
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

		
		public String getTipoCuenta() {
			return tipoCuenta;
		}

		
		public void setTipoCuenta(String tipoCuenta) {
			this.tipoCuenta = tipoCuenta;
		}
		
	}
