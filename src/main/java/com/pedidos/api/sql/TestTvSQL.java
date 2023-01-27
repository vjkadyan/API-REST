package com.pedidos.api.sql;

public enum TestTvSQL {
	CONSULTA,
	
	INSERTA_TEST_TV;

	public String toString() {
		switch (this) {
			case CONSULTA:
				return "SELECT CLIENTE_NUM, TEST1, TEST2, TEST3 FROM TEST_TV ;";
			case INSERTA_TEST_TV:
				return "INSERT INTO TEST_TV (CLIENTE_NUM, TEST1, TEST2, TEST3) VALUES(?, ?,?,?);";
		}
		return null;
	}
}
