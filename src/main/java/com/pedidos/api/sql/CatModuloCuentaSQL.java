package com.pedidos.api.sql;

public enum CatModuloCuentaSQL {
	 
		SELECT_STATUS,
		SELECT_MODULO,
		SELECT_CVE,
		INSERT;
		
//		EAGLE SECURE
		public String toString(){
			switch (this) {
			case INSERT:
				return " exec fn_ins_cat_modulo_cuenta ?, ?, ?, ?, ?, ?; ";
			case SELECT_STATUS:
				return " exec fn_getbyst_cat_modulo_cuenta 'A'; ";
			case SELECT_MODULO:
				return " exec fn_getbymod_cat_modulo_cuenta ?; ";
			case SELECT_CVE:
				return "select modulo_num,nombre_mod,clave,url,img,status from cat_modulo_cuenta";
			}
			return"";
		}
		
//		EAGLE
//		public String toString(){
//			switch (this) {
//			case INSERT:
//				return " insert into cat_modulo_cuenta (modulo_num,nombre_mod,clave,url,img,status) values (?,?,?,?,?,?) ";
//			case SELECT:
//				return " Select modulo_num,nombre_mod,clave,url,img,status from cat_modulo_cuenta ";
//			case SELECT_CVE:
//				return " select modulo_num,nombre_mod,clave,url,img,status from cat_modulo_cuenta  Where clave in() order by modulo_num asc ";
//			}
//			return"";
//		}
		
	}
