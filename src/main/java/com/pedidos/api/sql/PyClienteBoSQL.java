package com.pedidos.api.sql;

public enum PyClienteBoSQL {
	CONSULTA,

	INSERTA_PY_CLIENTE_BO;

	public String toString() {
		switch (this) {
			case CONSULTA:
				return "SELECT CLIENTE_NUM, CUST_NUM, BACKORDER FROM PY_CLIENTE_BO ;";
			case INSERTA_PY_CLIENTE_BO:
				return "INSERT INTO PY_CLIENTE_BO (CLIENTE_NUM, CUST_NUM, BACKORDER) VALUES(?, ?, ?);";
		}

		return null;
	}
}
