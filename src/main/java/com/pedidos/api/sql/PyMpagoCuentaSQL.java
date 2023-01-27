package com.pedidos.api.sql;

public enum PyMpagoCuentaSQL {
	CONSULTA,

	INSERTA_PY_MPAGO_CUENTA;

	public String toString() {
		switch (this) {
			case CONSULTA:
				return "SELECT CLIENTE_NUM,CUENTA FROM PY_MPAGO_CUENTA ;";
			case INSERTA_PY_MPAGO_CUENTA:
				return "INSERT INTO PY_MPAGO_CUENTA (CLIENTE_NUM, CUENTA) VALUES(?, ?);";
		}
		return null;
	}
}
