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
import com.pedidos.api.model.ModulosUsuario;
import com.pedidos.api.model.ObtieneMiEquipo;
import com.pedidos.api.sql.ObtieneMiEquipoSql;

@Service
public class ObtieneMiEquipoImp implements ObtieneMiEquipoDao{
	
	private static final Logger log = Logger.getLogger(PyUsuarioEquipoDaoImp.class);
	private String sqlTot = "";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int getAccionUsuario(long usuarioNum, String tipoUsuario) throws SQLException {
		int accion = 0;
		SqlRowSet rs = null;
		if("equipo".equals(tipoUsuario))
		{
			sqlTot = ObtieneMiEquipoSql.SELECT_ACCION_EQUIPO.toString() + "('usuario_num = "+usuarioNum+"');";
			rs = jdbcTemplate.queryForRowSet(sqlTot);
			if(rs.next())
			{
				accion = rs.getInt("accion_num");
			}
		}
		else
		{
			sqlTot = ObtieneMiEquipoSql.SELECT_ACCION_OTRO.toString();
			rs = jdbcTemplate.queryForRowSet(sqlTot,tipoUsuario);
			if(rs.next())
			{
				accion = rs.getInt("acm_num");
			}
		}
		log.info("ObtieneMiEquipoImp getAccionUsuario:"+ tipoUsuario + ":"+sqlTot);
		return accion;
	}
	
	@Override
	public List<ModulosUsuario> getModulosUsuario(long usuarioNum, String tipoUsuario) throws SQLException{
		List<ModulosUsuario> listaModulos = new LinkedList<ModulosUsuario>();
		ModulosUsuario modulo = null;
		SqlRowSet rs = null;
		switch(tipoUsuario)
		{
			case "equipo":
				sqlTot = ObtieneMiEquipoSql.SELECT_T_EQUIPO_M.toString();
				rs = jdbcTemplate.queryForRowSet(sqlTot,usuarioNum);
				break;
			case "administrador":
				sqlTot = ObtieneMiEquipoSql.SELECT_T_ADMIN_M.toString();
				rs = jdbcTemplate.queryForRowSet(sqlTot);
				break;
			case "nuevo":
			case "tienda virtual":
				sqlTot = ObtieneMiEquipoSql.SELECT_T_TV_M.toString();
				rs = jdbcTemplate.queryForRowSet(sqlTot,tipoUsuario);
				break;
			default:
				return null;
		}
		log.info("ObtieneMiEquipoImp getModulosUsuario:"+sqlTot);
		while(rs.next())
		{
			modulo = null;
			modulo = new ModulosUsuario();
			modulo.setModuloNum(rs.getInt("modulo_num"));
			modulo.setNombreMod(rs.getString("nombre_mod").trim());
			modulo.setClave(rs.getString("clave").trim());
			modulo.setUrl(rs.getString("url").trim());
			modulo.setImg(rs.getString("img").trim());
			modulo.setAcceso(rs.getString("acceso").trim());
			listaModulos.add(modulo);
		}
		return listaModulos;
	}
	
	@Override
	public List<CorreosUsuario> getCorreosUsuario(long usuarioNum, String tipoUsuario) throws SQLException{
		List<CorreosUsuario> listaCorreos = new LinkedList<CorreosUsuario>();
		CorreosUsuario correo = null;
		SqlRowSet rs = null;
		switch(tipoUsuario)
		{
			case "equipo":
				sqlTot = ObtieneMiEquipoSql.SELECT_T_EQUIPO_C.toString();
				rs = jdbcTemplate.queryForRowSet(sqlTot,usuarioNum);
				break;
			case "administrador":
			case "nuevo":
				sqlTot = ObtieneMiEquipoSql.SELECT_T_TIPO_C.toString();
				rs = jdbcTemplate.queryForRowSet(sqlTot,tipoUsuario);
				break;
			case "tienda virtual":
				return listaCorreos;
			default:
				return null;
		}
		log.info("ObtieneMiEquipoImp getCorreosUsuario:"+sqlTot);
		while(rs.next())
		{
			correo = null;
			correo = new CorreosUsuario();
			correo.setCorreoNum(rs.getInt("correo_num"));
			correo.setNombre(rs.getString("nombre_correo").trim().replace("Rmas", "Garantias y Devoluciones"));
			correo.setNombreCorreo(rs.getString("nombre_correo").trim());
			correo.setAcceso(rs.getString("acceso").trim());
			listaCorreos.add(correo);
		}
		return listaCorreos;
	}
	
	@Override
	public long perteneceEquipo(String correo, long usuarioNum) throws SQLException {
		long usuario = 0;
		sqlTot = ObtieneMiEquipoSql.PERTENECE_EQUIPO.toString();
		log.info(correo + " pertence al equipo de " + usuarioNum + ", " + sqlTot);
		SqlRowSet rs = this.jdbcTemplate.queryForRowSet(sqlTot,correo, usuarioNum);
		if(rs.next())
		{
			if(rs.getLong("usuario_num") > 0)
			{
				usuario = rs.getLong("usuario_num");
			}
		}
		return usuario;
	}

	@Override
	public void insertRow(ObtieneMiEquipo entidad) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteRow(ObtieneMiEquipo entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRow(ObtieneMiEquipo entidad) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ObtieneMiEquipo getByIdRow(ObtieneMiEquipo entidad) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ObtieneMiEquipo> getAllRow() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
