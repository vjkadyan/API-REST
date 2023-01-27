package com.pedidos.api.sql;

public enum PyCelularSmsSQL {
	SELECT,
	INSERT,
	UPDATE,
	DROP,
	CONSEC_ID;
	 
	public String toString() {
		switch(this) {
			case SELECT:
				return " SELECT CELULAR_NUM, CLIENTE_NUM, FECHA_REGISTRO, CELULAR, STATUS FROM PY_CELULAR_SMS ";
			case INSERT:
				return " INSERT INTO PY_CELULAR_SMS (celular_num, cliente_num, fecha_registro, celular, status)VALUES (?,?,CONVERT(date,GETDATE()),?,?)";
			case UPDATE:
				return " UPDATE PY_CELULAR_SMS ";
			case DROP:
				return "";
			case CONSEC_ID:
				return "select top 1 (celular_num+1) as celular_num FROM PY_CELULAR_SMS where cliente_num = ? order by celular_num desc ";
		}
		return "";
	}
}
