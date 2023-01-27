package com.pedidos.api.sql;

public enum PyTelefonoClienteSQL {
	 
	SELECT,
	INSERT,
	UPDATE;

	public String toString(){
		switch (this) {
		case INSERT:
			return " insert into py_telefono_cliente (telefono_num,cliente_num,usuario_num,telefono,extension,tipo_num,fecha_registro,status,rol_num) values ((select isnull((max(telefono_num)+1),1) from py_telefono_cliente where cliente_num = ?),?,?,?,?,?,GETDATE(),?,?) ";
		case UPDATE:
			return " update py_telefono_cliente ";
		case SELECT:
			return " Select telefono_num,cliente_num,usuario_num,telefono,extension,tipo_num,fecha_registro,status,rol_num from py_telefono_cliente ";
		}
		return"";
	}
	
}
