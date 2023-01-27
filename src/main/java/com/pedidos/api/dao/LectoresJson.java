package com.pedidos.api.dao;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import com.pedidos.api.model.TipoMiCuenta;

public interface LectoresJson {
	public JSONObject leeJson(HttpServletRequest request);
	public String corrigeAcentos(String cadena);
	public TipoMiCuenta leeRegistraMisDatos(String texto);
}
