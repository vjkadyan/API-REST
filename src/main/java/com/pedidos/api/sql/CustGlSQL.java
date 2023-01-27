package com.pedidos.api.sql;

public enum CustGlSQL {
	CONSULTA, OBTIENE_GL_CHARTI,

	INSERTA_CUST_GL;

	public String toString() {
		switch (this) {
			case CONSULTA:
				return "SELECT ORG_CODE, DIV_CODE, CUST_NUM, GL_CODE FROM CUST_GL ";
			case INSERTA_CUST_GL:
				return "INSERT INTO CUST_GL (ORG_CODE, DIV_CODE, CUST_NUM, GL_CODE) VALUES(?, ?, ?, ?);";
			case OBTIENE_GL_CHARTI:
				return "SELECT GL_CHARTI AS GL_CODE FROM GL_CHART_2 WHERE ORG_CODE = ? AND DIV_CODE= ?;";
		}
		return null;
	}
}
