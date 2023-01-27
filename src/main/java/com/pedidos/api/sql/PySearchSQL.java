package com.pedidos.api.sql;


public enum PySearchSQL {
	
	SELECT,
	UPDATE,
	INSERT,
	DELETE,
	FINDONE;

	public String toString(){
		switch (this) {
		case SELECT:
			return "select * from py_search ";
		case FINDONE:
			return "select url from py_search where item_num = ?";
		}
		return "";
	}
	
}
