package com.pedidos.api.dao;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.pedidos.api.model.CorreosUsuario;
import com.pedidos.api.model.PyUsuarioEquipo;
import com.pedidos.api.sql.ObtieneMiEquipoSql;
import com.pedidos.api.sql.PyUsuarioEquipoSQL;

@Service
public class PyUsuarioEquipoDaoImp implements PyUsuarioEquipoDao {
	
	private static final Logger LOG = Logger.getLogger(PyUsuarioEquipoDaoImp.class);
	private String sqlTot = "";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public String getTipoUsuario(long usuarioNum) {
		sqlTot = PyUsuarioEquipoSQL.TIPO_USUARIO.toString();
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sqlTot, usuarioNum);
		String tipoUsuario = "";
		if(rs.next())
		{
			tipoUsuario = rs.getString("tipo_usuario").trim();
		}
		return tipoUsuario;
	}
	

	@Override
	public String obtieneIdentificador(long usuarioNum) throws SQLException {
		sqlTot = PyUsuarioEquipoSQL.IDENTIFICADOR.toString();
		String identificador = "96, 124, 255";
		LOG.info("Identificador de " + usuarioNum + ", " + sqlTot);
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sqlTot,usuarioNum);
		if(rs.next())
		{
			identificador = rs.getString("identificador");
		}
		return identificador;
	}
	
	@Override
	public int updateColor(PyUsuarioEquipo pyUsuarioE) {
		sqlTot = PyUsuarioEquipoSQL.UPD_IDENTIFICADOR.toString();
		return this.jdbcTemplate.queryForObject(sqlTot, new Object[] {pyUsuarioE.getUsuarioNum(), pyUsuarioE.getIdentificador()}, Integer.class);
	}

	@Override
	public void insertRow(PyUsuarioEquipo entidad) throws SQLException {
		LOG.info("PyUsuarioEquipoDaoImp.insertRow " + entidad.toString());
		sqlTot = PyUsuarioEquipoSQL.INSERT.toString();
		jdbcTemplate.queryForObject(sqlTot, new Object[] {entidad.getClienteNum(),entidad.getUsuarioNum(),entidad.getCargo(),entidad.getAccionNum(),entidad.getIdentificador(),entidad.getStatus()}, Integer.class);
	}

	@Override
	public int deleteRow(PyUsuarioEquipo entidad) throws SQLException {
		sqlTot = PyUsuarioEquipoSQL.DELETE.toString();
		LOG.info("delete:"+sqlTot+",u:"+entidad.getUsuarioNum());
		return jdbcTemplate.queryForObject(sqlTot, new Object[] {entidad.getUsuarioNum()}, Integer.class);
	}
	
	@Override
	public int estatusUsuario(long usuarioMod, String estatus) throws SQLException{
		sqlTot = PyUsuarioEquipoSQL.ESTATUS_USUARIO.toString();
		return this.jdbcTemplate.queryForObject(sqlTot, new Object[] {usuarioMod, estatus}, Integer.class);
	}
	
	@Override
	public PyUsuarioEquipo getByUsuario(long usuarioNum) throws SQLException {
		sqlTot = PyUsuarioEquipoSQL.SELECT_USUARIO.toString();
		SqlRowSet rs = this.jdbcTemplate.queryForRowSet(sqlTot, usuarioNum);
		PyUsuarioEquipo pyUsuarioEquipo = new PyUsuarioEquipo();
		if(rs.next())
		{
			pyUsuarioEquipo.setClienteNum(rs.getLong("cliente_num"));
			pyUsuarioEquipo.setUsuarioNum(rs.getLong("usuario_num"));
			pyUsuarioEquipo.setCargo(rs.getString("cargo").trim());
			pyUsuarioEquipo.setAccionNum(rs.getInt("accion_num"));
			pyUsuarioEquipo.setFechaRegistro(rs.getString("fecha_registro_ymd").trim());
			pyUsuarioEquipo.setIdentificador(rs.getString("identificador").trim());
			pyUsuarioEquipo.setCelularPrinc(rs.getString("celular_princ"));
			pyUsuarioEquipo.setTelefonoPrinc(rs.getString("telefono_princ"));
			pyUsuarioEquipo.setStatus(rs.getString("status").trim());
			pyUsuarioEquipo.setNombre(rs.getString("nombre").trim());
			pyUsuarioEquipo.setEmpresa(rs.getString("empresa").trim());
			pyUsuarioEquipo.setTipoCuenta(rs.getString("tipo_cuenta").trim());
		}
		else
		{
			pyUsuarioEquipo = null;
		}
		return pyUsuarioEquipo;
	}

	@Override
	public int updateRow(PyUsuarioEquipo entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PyUsuarioEquipo getByIdRow(PyUsuarioEquipo entidad) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PyUsuarioEquipo> getAllRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
