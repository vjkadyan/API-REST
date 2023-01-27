package com.pedidos.api.sql;


public enum TipoMiCuentaSQL {
 
	SELECT, UPDATE, INSERT;
	public String toString() {
		switch(this) {
			case SELECT:
				return "SELECT cliente_num, usuario_num, nombre, apellido, empresa, to_char(fecha_nac, '%Y-%m-%d') as fecha_nac, fecha_reg, envia_msg, entrega_clientes, tipo_cuenta, telefono_princ, celular_princ from tipo_mi_cuenta ";
			case UPDATE:
				return "UPDATE tipo_mi_cuenta " ;
			case INSERT:
			 return "INSERT INTO tipo_mi_cuenta (cliente_num, usuario_num, nombre, apellido, empresa, fecha_nac, fecha_reg, envia_msg, entrega_clientes, tipo_cuenta) values (?,?,?,?,?,?,current,?,?,?) ";
		}
		return "";
	}
	
}