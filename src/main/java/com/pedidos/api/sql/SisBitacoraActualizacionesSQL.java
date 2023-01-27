package com.pedidos.api.sql;

public enum SisBitacoraActualizacionesSQL {

	CONSULTA,
	INSERTA_SIS_BITACORA_ACTUALIZACIONES, 
	INSERTA_SIS_BITACORA_ACTUALIZACIONES2,
	CONSULTATOKEN,
	ACTUALIZATOKEN;

	public String toString() {
		switch (this) {
			case CONSULTA:
				return "SELECT ID_MODULO, ID_SUB_MODULO, IP, TERMINAL, NUM_EMPLEADO, FECHA, INSTRUCCION FROM SIS_BITACORA_ACTUALIZACIONES ";
			case INSERTA_SIS_BITACORA_ACTUALIZACIONES:
				return "INSERT INTO SIS_BITACORA_ACTUALIZACIONES (ID_MODULO, ID_SUB_MODULO, IP, TERMINAL, NUM_EMPLEADO, FECHA, INSTRUCCION) VALUES (?,?,?,?,?,?,?);";
			case INSERTA_SIS_BITACORA_ACTUALIZACIONES2:
				return "INSERT INTO SIS_BITACORA_ACTUALIZACIONES (ID_MODULO, ID_SUB_MODULO, IP, TERMINAL, NUM_EMPLEADO, FECHA, INSTRUCCION) VALUES (?,?,?,?,?,getdate(),?);";
			case CONSULTATOKEN:
				return "select token from py_token where id=? and CONVERT(date,fecha) = CONVERT(date,GETDATE()) and CONVERT(time,fecha) < CONVERT(time,DATEADD(HH,7,GETDATE()))";
			case ACTUALIZATOKEN:
				return "update py_token set fecha=GETDATE(),token=? where id=?";
		}
		return null;
	}
}
