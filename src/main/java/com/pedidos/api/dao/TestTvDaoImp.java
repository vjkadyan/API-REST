package com.pedidos.api.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pedidos.api.model.TestTv;
import com.pedidos.api.sql.TestTvSQL;

@Service
public class TestTvDaoImp implements TestTvDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private String sqltot = "";

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void insertRow(TestTv entidad) throws SQLException {
		sqltot = TestTvSQL.INSERTA_TEST_TV.toString();
		jdbcTemplate.update(sqltot, entidad.getClienteNum(), entidad.getTest1(), entidad.getTest2(), entidad.getTest3());
	}

	@Override
	public int deleteRow(TestTv entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRow(TestTv entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TestTv getByIdRow(TestTv entidad) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TestTv> getAllRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
