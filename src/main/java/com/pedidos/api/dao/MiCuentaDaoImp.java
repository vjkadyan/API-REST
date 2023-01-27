package com.pedidos.api.dao;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pedidos.api.model.PyUsuario;

@Service
public class MiCuentaDaoImp implements MiCuentaDao {
	
	private static Logger log = Logger.getLogger(MiCuentaDaoImp.class);
	
	@Autowired
//	@Qualifier("pyUsuarioImp")
	private PyUsuarioDao pyUsuarioDaoImp;

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public int cambioContrasena2(String email,String contrasenaN,String contrasenaN2) throws SQLException {
		PyUsuario pyUsuario = new PyUsuario();
		int isUpdate = 0;
		if (contrasenaN.trim().equals(contrasenaN2.trim())) {
			pyUsuario.setPassword(contrasenaN.trim());
			pyUsuario.setEmail(email.trim());
			isUpdate = pyUsuarioDaoImp.actualizarPassword2(pyUsuario);
		} else {
			isUpdate = -1;
		}
		log.info("respuesta actualizacion : " + isUpdate);
		return isUpdate;
	}
}
