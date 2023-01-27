package com.pedidos.api.dao;

import java.sql.SQLException;
import java.util.List;

import com.pedidos.api.comun.DAO;
import com.pedidos.api.model.PyCelularSms;

public interface PyCelularSmsDao extends DAO<PyCelularSms> {
	 
		public List<PyCelularSms> getByIdRow(Long cliente_num) throws SQLException;

		public int getConsec(Long cliente_num) throws SQLException;

}
