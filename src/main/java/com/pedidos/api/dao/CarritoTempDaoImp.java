package com.pedidos.api.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.pedidos.api.model.Carrito;
import com.pedidos.api.sql.CarritoTempSQL;

@Service
public class CarritoTempDaoImp implements CarritoTempDao {

	private String Sqltot = "";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insertRow(Carrito entidad) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteRow(Carrito entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRow(Carrito entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Carrito getByIdRow(Carrito entidad) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Carrito> getAllRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public int consultaPartidas(int cliente_num, int usuario_num, int usuario_temp, String base) throws SQLException {
		int partidas = 0;
		if("SQL".equals(base)) {
			SimpleJdbcCall actor = new SimpleJdbcCall(jdbcTemplate).withProcedureName("fn_log_carrito_pedidos");
			SqlParameterSource inParams = new MapSqlParameterSource()
			.addValue("cliente_num_p", cliente_num).addValue("usuario_num_p", usuario_num)
			.addValue("usuario_num_tmp_p", usuario_temp);
			Map<String, Object> outParams = actor.execute(inParams);
			partidas = (int) outParams.get("respuesta");
		}else {
			Sqltot = CarritoTempSQL.CONSULTA_PARTIDAS.toString();
			SqlRowSet rs = jdbcTemplate.queryForRowSet(Sqltot,cliente_num,usuario_num,usuario_temp);
			while(rs.next()) {
				partidas = rs.getInt(1);
			}
		}
		
		return partidas;
	}

}
