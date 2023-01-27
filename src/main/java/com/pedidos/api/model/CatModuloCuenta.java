package com.pedidos.api.model;

public class CatModuloCuenta {
	 
		private int moduloNum;
		private String nombreMod;
		private String clave;
		private String url;
		private String img;
		private String status;
		
		public int getModuloNum() {
			return moduloNum;
		}
		
		public void setModuloNum(int moduloNum) {
			this.moduloNum = moduloNum;
		}
		
		public String getNombreMod() {
			return nombreMod;
		}
		
		public void setNombreMod(String nombreMod) {
			this.nombreMod = nombreMod;
		}
		
		public String getClave() {
			return clave;
		}
		
		public void setClave(String clave) {
			this.clave = clave;
		}
		
		public String getUrl() {
			return url;
		}
		
		public void setUrl(String url) {
			this.url = url;
		}
		
		public String getImg() {
			return img;
		}
		
		public void setImg(String img) {
			this.img = img;
		}
		
		public String getStatus() {
			return status;
		}
		
		public void setStatus(String status) {
			this.status = status;
		}
		@Override
		public String toString() {
			return "CatModuloCuenta [moduloNum=" + moduloNum + ", nombreMod=" + nombreMod + ", clave=" + clave + ", url=" + url + ", img=" + img + ", status=" + status + "]";
		}
	}
