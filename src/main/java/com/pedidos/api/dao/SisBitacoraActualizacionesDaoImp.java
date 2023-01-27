package com.pedidos.api.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.pedidos.api.model.SisBitacoraActualizaciones;
import com.pedidos.api.sql.SisBitacoraActualizacionesSQL;

@Service
public class SisBitacoraActualizacionesDaoImp implements SisBitacoraActualizacionesDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String Sqltot = "";
	
	@Override
	public int insertarBitacora(SisBitacoraActualizaciones entidad) throws SQLException {
		Sqltot = SisBitacoraActualizacionesSQL.INSERTA_SIS_BITACORA_ACTUALIZACIONES2.toString();
		return jdbcTemplate.update(Sqltot, entidad.getIdModulo(), entidad.getIdSubModulo(), entidad.getIp(), entidad.getTerminal(), entidad.getNumEmpleado(), entidad.getInstruccion());
	}

	@Override
	public void insertRow(SisBitacoraActualizaciones entidad) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteRow(SisBitacoraActualizaciones entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRow(SisBitacoraActualizaciones entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SisBitacoraActualizaciones getByIdRow(SisBitacoraActualizaciones entidad) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SisBitacoraActualizaciones> getAllRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
