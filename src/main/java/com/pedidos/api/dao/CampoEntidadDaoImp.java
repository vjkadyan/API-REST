package com.pedidos.api.dao;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class CampoEntidadDaoImp implements CampoEntidadDao {

	private static final Logger log = Logger.getLogger("CampoEntidad");

	@SuppressWarnings("unchecked")
	@Override	
	public <E> E CampoEntidad(Class<E> tipo, Object nombre, ResultSet rs) throws IllegalArgumentException, IllegalAccessException, SQLException {

		Object value = null;
		for (Field campo : nombre.getClass().getDeclaredFields()) {
			campo.setAccessible(true);
			value = campo.getType();
//			log.info("Campo: " + campo.getName() + " Valor: " + value.toString());
			if ("class java.lang.String".equals(value.toString())) {
				campo.set(nombre, rs.getString(campo.getName().trim()));
			} else if ("int".equals(value.toString())) {
				campo.set(nombre, rs.getInt(campo.getName()));
			} else if ("short".equals(value.toString())) {
				campo.set(nombre, rs.getShort(campo.getName()));
			} else if ("class java.lang.Double".equals(value.toString())) {
				campo.set(nombre, rs.getDouble(campo.getName()));
			} else if ("clase java.util.date".equals(value.toString())) {
				campo.set(nombre, rs.getDate(campo.getName()));
			} else if ("long".equals(value.toString())) {
				campo.set(nombre, rs.getLong(campo.getName()));
			} else if ("class java.sql.Time".equals(value.toString())) {
				campo.set(nombre, rs.getTime(campo.getName()));
			} else if ("class java.sql.Date".equals(value.toString())) {
				campo.set(nombre, rs.getDate(campo.getName()));
			}

		}
		return (E) nombre;
	}

	@Override
	public void mensaje() {
		log.info("Si entre :D");

	}

}
