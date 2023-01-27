package com.pedidos.api.dao;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pedidos.api.model.PyLayoutEjecutiva;
import com.pedidos.api.sql.PyLayoutEjecutivaSql;

@Service
public class PyLayoutEjecutivaImp implements PyLayoutEjecutivaDao{
	
	private static final Logger log = Logger.getLogger(PyLayoutEjecutivaImp.class);
	String sql = "";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public List<PyLayoutEjecutiva> getAllCliente(long clienteNum, int empleadoNum)
	{
		PyLayoutEjecutiva ejecutivo = null;
		List<PyLayoutEjecutiva> listaEjecutiva = new LinkedList<PyLayoutEjecutiva>();
		
		sql = PyLayoutEjecutivaSql.CONSULTA.toString() + " where cliente_num = ? and empleado_num = ? order by fecha desc; ";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, clienteNum, empleadoNum);
		while(rs.next())
		{
			ejecutivo = new PyLayoutEjecutiva();
			ejecutivo.setFecha(rs.getString("fecha").trim());
			ejecutivo.setClienteNum(rs.getInt("cliente_num"));
			ejecutivo.setEmpleadoNum(rs.getInt("empleado_num"));
			ejecutivo.setCalificacion(rs.getInt("calificacion"));
			ejecutivo.setComentario(rs.getString("comentario").trim());
			listaEjecutiva.add(ejecutivo);
		}
		if(listaEjecutiva.size() <= 0)
		{
			ejecutivo = new PyLayoutEjecutiva();
			listaEjecutiva = new LinkedList<PyLayoutEjecutiva>();
			ejecutivo.setComentario("NOENCONTRADO");
			listaEjecutiva.add(ejecutivo);
		}
		log.info(ejecutivo.toString());
		
		return listaEjecutiva;
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public int insertResenaEjecutivo(PyLayoutEjecutiva ejecutivo) {
		sql = PyLayoutEjecutivaSql.INSERTA.toString();
		return jdbcTemplate.update(sql, ejecutivo.getClienteNum(),ejecutivo.getEmpleadoNum(),ejecutivo.getCalificacion(),ejecutivo.getComentario());
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public PyLayoutEjecutiva getByIdRow(PyLayoutEjecutiva entidad) {
		//TODO Au
		return null;
	}
	
	@Override
	public List<PyLayoutEjecutiva> getAllRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void insertRow(PyLayoutEjecutiva entidad) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteRow(PyLayoutEjecutiva entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRow(PyLayoutEjecutiva entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Integer countRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PyLayoutEjecutiva getByDate(PyLayoutEjecutiva entidad) {
		// TODO Auto-generated method stub
		return null;
	}

}
