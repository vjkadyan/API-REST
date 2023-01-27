package com.pedidos.api.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.pedidos.api.model.ResenaPedidos;
import com.pedidos.api.sql.ResenasPedidosSql;

@Service
public class ObtieneResenaPedidosImp implements ObtieneResenasDao{

	private static final Logger log = Logger.getLogger(ObtieneResenaPedidosImp.class);
	String sql = "";

//	@Autowired
//	@Qualifier("pyLayoutEjecutivaImp")
//	private PyLayoutEjecutivaDao pyLayoutEjecutiva;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public ResenaPedidos getByCliente(long clienteNum) {
		ResenaPedidos resena = new ResenaPedidos();
		sql = ResenasPedidosSql.CONSULTA_ULTIMO_EJECUTIVO.toString();
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, clienteNum);
		if(rs.next())
		{
			resena.setSlmn(rs.getInt("slmn"));
			resena.setFecha(rs.getString("fecha").trim());
			resena.setPedidoNum(rs.getLong("pedido_num"));
			resena.setNombre(rs.getString("nombre").trim());
			resena.setEmail(rs.getString("email").trim());
			resena.setExt((rs.getString("ext")==null)?"":rs.getString("ext").trim());
			resena.setStat(rs.getString("stat").trim());
			resena.setCkase(rs.getString("ckase").trim());
		}
		else
		{
			resena.setSlmn(-1);
		}
		log.info(resena.toString());
		return resena;
	}

	@Override
	public void insertRow(ResenaPedidos entidad) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteRow(ResenaPedidos entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRow(ResenaPedidos entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResenaPedidos getByIdRow(ResenaPedidos entidad) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResenaPedidos> getAllRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
