package com.pedidos.api.sql.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.pedidos.api.dao.CampoEntidadDao;
import com.pedidos.api.dao.CampoEntidadDaoImp;
import com.pedidos.api.model.CustGl;

public class CustGlRowMapper implements RowMapper<CustGl> {

	@Autowired
	private CampoEntidadDao campoEntidadDaoImp;

	private CustGl c = null;

	@Override
	public CustGl mapRow(ResultSet rs, int arg1) throws SQLException {
		c = new CustGl();

		try {
			campoEntidadDaoImp = new CampoEntidadDaoImp();
			campoEntidadDaoImp.CampoEntidad(CustGl.class, c, rs);
			// campoEntidadDaoImp.mensaje();
		} catch (IllegalArgumentException e) {
			throw new SQLException();
		} catch (IllegalAccessException e) {
			throw new SQLException();
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		}

		return c;
	}

	

}
