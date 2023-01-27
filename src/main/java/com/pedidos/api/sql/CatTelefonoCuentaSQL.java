package com.pedidos.api.sql;

public enum CatTelefonoCuentaSQL {
	 
		SELECT,
		INSERT,
		UPDATE;
		
		public String toString(){
			switch (this) {
			case INSERT:
				return " insert into cat_telefono_cuenta (tipo_num, tipo, status) values (?,?,?) ";
			case UPDATE:
				return " update cat_telefono_cuenta ";
			case SELECT:
				return " Select tipo_num, tipo, status from cat_telefono_cuenta ";
			}
			return"";
		}
		
	}