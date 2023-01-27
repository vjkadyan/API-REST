package com.pedidos.api.sql;

public enum PyClienteMpagoSQL {
	CONSULTA,

	INSERTA_PY_CLIENTE_MPAGO;

	public String toString() {

		switch (this) {
			case CONSULTA:
				return "SELECT CLIENTE_NUM,MPAGO FROM PY_CLIENTE_MPAGO ;";
			case INSERTA_PY_CLIENTE_MPAGO:
				return "INSERT INTO PY_CLIENTE_MPAGO (CLIENTE_NUM, MPAGO) VALUES(?, ?);";
		}
		return null;
	}
}
