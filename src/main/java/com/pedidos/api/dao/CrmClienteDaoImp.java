package com.pedidos.api.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pedidos.api.model.CrmCliente;
import com.pedidos.api.sql.CrmClienteSQL;

@Service
public class CrmClienteDaoImp implements CrmClienteDao {

	private String Sqltot = "";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void insertRow(CrmCliente entidad) throws SQLException {
		Sqltot = CrmClienteSQL.INSERTA_CRM_CLIENTE.toString();
		jdbcTemplate.update(Sqltot,entidad.getCustNum(), entidad.getOrgCode(), entidad.getDivCode(), entidad.getRazonSocial(), entidad.getRfc(), entidad.getRazonComercial(), entidad.getCalleYNo(), entidad.getCalleYNoDos(), entidad.getCalleUno(), entidad.getCalleDos(), entidad.getCp(), entidad.getColonia(), entidad.getMunicipio(), entidad.getEstado(), entidad.getPais(), entidad.getTelUno(), entidad.getExtUno(), entidad.getTelDos(), entidad.getExtDos(), entidad.getTelTres(), entidad.getExtTres(), entidad.getFax(), entidad.getExtFax(), entidad.getSitioWeb(), entidad.getObtenido(), entidad.getGiro(), entidad.getSector(), entidad.getClasificacion(), entidad.getStatus(), entidad.getCapturista(), entidad.getFechaAlta(), entidad.getModificadoPor(), entidad.getFechaUlMod(), entidad.getTipoEmpresa(), entidad.getTipo(), entidad.getNombre(), entidad.getPaterno(), entidad.getMaterno(), entidad.getAsignadoA(), entidad.getActualizaStatus());
	}

	@Override
	public int deleteRow(CrmCliente entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRow(CrmCliente entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CrmCliente getByIdRow(CrmCliente entidad) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CrmCliente> getAllRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
