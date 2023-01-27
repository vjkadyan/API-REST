package com.pedidos.api.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pedidos.api.comun.ConexionMailAPI;
import com.pedidos.api.model.PyClienteCodigo;
import com.pedidos.api.sql.CustomerSQL;

@Service
public class PyClienteCodigoImp {
	private static final Logger LOG = Logger.getLogger(CustomerDaoImp.class);
	private String sqlTot ="";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional (propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void insertRow(PyClienteCodigo entidad) throws SQLException {
		sqlTot = CustomerSQL.INSCLIENTECODIGO.toString();
		jdbcTemplate.update(sqlTot, entidad.getCliente_num(),entidad.getIsEmpresa(),entidad.getCodigo(),entidad.getEstatus(),entidad.getCorreo(),entidad.getContrasena(),entidad.getUsuario());
	}
	
	@Transactional (propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public boolean UpdateEstatus(String codigo) throws SQLException {
		sqlTot = CustomerSQL.UPDATEESTATUSCODIGO.toString();
		int disUpdate= jdbcTemplate.update(sqlTot, codigo);
		return (disUpdate > 0);
	}
	
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public PyClienteCodigo DataPyClienteCodigo(String correo) throws SQLException {
		PyClienteCodigo cliente = new PyClienteCodigo();
		sqlTot = CustomerSQL.GETCLIENTECODIGO.toString();
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sqlTot,correo);
		if (rs.next()) {
			cliente.setCliente_num(rs.getLong("cliente_num"));
			cliente.setIsEmpresa(rs.getString("isEmpresa"));
			cliente.setCodigo(rs.getString("codigo"));
			cliente.setEstatus(rs.getString("estatus"));
			cliente.setFecha(rs.getString("fecha"));
			cliente.setCorreo(rs.getString("correo"));
			cliente.setContrasena(rs.getString("contrasena"));
			cliente.setUsuario(rs.getString("usuario"));
		}
		return cliente;
	}
	
	public String codigo() {
		String codigo = "";
		try {	
			List<String> numeros = new ArrayList<String>();
			boolean isCorrecto = false;
			while(!isCorrecto) {
				for (int i = 0; i < 6; i++) {
					numeros.add( (((int)(Math.random()*10))+"").substring(0,1));
				}				
				if(numeros.size() == 6) {				
					try {
						codigo			= numeros.toString().replace("[","" ).replace("]","" ).replace(",","").replace(" ","").trim();
						int codigoInt   = Integer.parseInt(codigo);
					} catch (Exception e) {
						codigo			= "";
					}
				}else {
					codigo			= "";
				}
				
				if(!"".equals(codigo)) {
					isCorrecto	= (existeCodigo(codigo,"").getEstatus() == null);
				}				
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return codigo;
	}
	
	@Transactional(isolation = Isolation.READ_UNCOMMITTED)
	public PyClienteCodigo existeCodigo(String codigo, String correo) {
		PyClienteCodigo cliente = new PyClienteCodigo();
		try {
			sqlTot = CustomerSQL.GETCODIGO.toString();
			sqlTot = ("".equals(correo))?sqlTot:sqlTot+" and correo='"+correo+"'";
			SqlRowSet rs = jdbcTemplate.queryForRowSet(sqlTot,codigo);
			if (rs.next()) {
				cliente.setCliente_num(rs.getLong("cliente_num"));
				cliente.setIsEmpresa(rs.getString("isEmpresa"));
				cliente.setCodigo(rs.getString("codigo"));
				cliente.setEstatus(rs.getString("estatus"));
				cliente.setFecha(rs.getString("fecha"));
				cliente.setCorreo(rs.getString("correo"));
				cliente.setContrasena(rs.getString("contrasena"));
				cliente.setUsuario(rs.getString("usuario"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cliente;
	}
	
	
	public String reenviarCodigo(PyClienteCodigo cliente) {
		String isEnviado= "";
		try {		
			if (cliente.getEstatus() != null) {
				if("I".equals(cliente.getEstatus())) {
					if(enviarCorreo(cliente.getCorreo(),cliente.getCodigo())) {
						isEnviado="Enviado";
					}else {
						isEnviado="Error al Enviar";
					}
				}else {
					isEnviado="El Correo esta Verificado";
				}
			}else {
				isEnviado="El correo no cuenta con un codigo";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isEnviado;
	}
	
	public boolean enviarCorreo(String email, String codigo) {
		boolean isEnviado = false;
		try {
			String opt = "?opt=35";
			String mail = "&email=" + email;
			String find = "&find=%26codigo";
			String change = "&change="+codigo;			
			String variables = opt + mail + find + change;			
			ConexionMailAPI apiMail = new ConexionMailAPI();
			apiMail.sendMail(variables);
			isEnviado=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isEnviado;
	}
	
	public boolean enviarCorreoBienvenida(String email, String usuario) {
		boolean isEnviado = false;
		try {
			String opt = "?opt=36";
			String mail = "&email=" + email;
			String find = "&find=%26usuario";
			String change = "&change="+usuario;			
			String variables = opt + mail + find + change;			
			ConexionMailAPI apiMail = new ConexionMailAPI();
			apiMail.sendMail(variables);
			isEnviado=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isEnviado;
	}
	
	public static void main(String arg[]) {
		PyClienteCodigoImp p = new PyClienteCodigoImp();
		System.out.println(p.codigo()); 
				
	}
}
