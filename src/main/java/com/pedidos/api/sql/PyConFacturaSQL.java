package com.pedidos.api.sql;

public enum PyConFacturaSQL {
	CONSULTA,

	INSERTA_PY_CONFACTURA;

	public String toString() {
		switch (this) {
			case CONSULTA:
				return "SELECT CUST_NUM, FACTURA FROM PY_CONFACTURA ;";
			case INSERTA_PY_CONFACTURA:
				return "INSERT INTO PY_CONFACTURA (CUST_NUM, FACTURA) VALUES(?, ?);";
		}
		return null;
	}
}