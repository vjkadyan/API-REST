package com.pedidos.api.model;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RegistraUsuario {
	private String nombre;
	private long clienteNum;
	private long usuarioNum;
	private String puesto;
	private String tipoCuenta;
	private String correo;
	private String telefono;
	private String ext;
	private int tipoTel;
	private String password;
	private String color;
	private ArrayList<String> correos;
	private ArrayList<String> accesos;
	
	public RegistraUsuario(JSONObject usuario, String tipo)
	{
		ArrayList<String> correosArray = new ArrayList<String>();
		ArrayList<String> accesosArray = new ArrayList<String>();
		String variable = "op";
		
		try
		{
			if("Registro".equals(tipo))
			{
				variable = "op";
				this.nombre = usuario.getString("nombre").trim();
				this.puesto = usuario.getString("puesto").trim();
				this.telefono = usuario.getString("telefono").trim();
				this.ext = usuario.getString("ext").trim();
				this.tipoTel = usuario.getInt("tipoTel");
				this.password = usuario.getString("password").trim();
			}
			else
			{
				this.tipoCuenta = usuario.getString("tipoCuenta").trim();
				variable = "Mop";
			}
			this.correo = usuario.getString("correo").trim();
			this.color = usuario.getString("color").trim();
			this.clienteNum = usuario.getLong("clienteNum");
			this.usuarioNum = usuario.getLong("usuario");
			
			JSONArray correosJson = usuario.getJSONArray("correos");
			
			for(int x = 0; x < correosJson.length(); x++)
			{
				correosArray.add(correosJson.getString(x).trim().replace(variable, ""));
			}
			
			JSONArray accesosJson = usuario.getJSONArray("accesos");
			for(int x = 0; x < accesosJson.length(); x++)
			{
				accesosArray.add(accesosJson.getString(x).trim().replace(variable, ""));
			}
			
			this.correos = correosArray;
			this.accesos = accesosArray;
		}
		catch(JSONException e)
		{
			e.printStackTrace();
			this.nombre = "JSONExceptionError";
		}
	}

	
	public String getNombre() {
		return nombre;
	}

	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public long getClienteNum() {
		return clienteNum;
	}

	
	public void setClienteNum(long clienteNum) {
		this.clienteNum = clienteNum;
	}

	
	public long getUsuarioNum() {
		return usuarioNum;
	}

	
	public void setUsuarioNum(long usuarioNum) {
		this.usuarioNum = usuarioNum;
	}

	
	public String getPuesto() {
		return puesto;
	}

	
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	
	public String getTipoCuenta() {
		return tipoCuenta;
	}

	
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	
	public String getCorreo() {
		return correo;
	}

	
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	
	public String getTelefono() {
		return telefono;
	}

	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
	public String getExt() {
		return ext;
	}

	
	public void setExt(String ext) {
		this.ext = ext;
	}

	
	public int getTipoTel() {
		return tipoTel;
	}

	
	public void setTipoTel(int tipoTel) {
		this.tipoTel = tipoTel;
	}

	
	public String getPassword() {
		return password;
	}

	
	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getColor() {
		return color;
	}

	
	public void setColor(String color) {
		this.color = color;
	}

	
	public ArrayList<String> getCorreos() {
		return correos;
	}

	
	public void setCorreos(ArrayList<String> correos) {
		this.correos = correos;
	}

	
	public ArrayList<String> getAccesos() {
		return accesos;
	}

	
	public void setAccesos(ArrayList<String> accesos) {
		this.accesos = accesos;
	}


	@Override
	public String toString() {
		return "RegistraUsuario [nombre=" + nombre + ", clienteNum=" + clienteNum + ", usuarioNum=" + usuarioNum + ", puesto=" + puesto + ", tipoCuenta=" + tipoCuenta + ", correo=" + correo + ", telefono=" + telefono + ", ext=" + ext + ", tipoTel=" + tipoTel + ", password=" + password + ", color=" + color + ", correos=" + correos + ", accesos=" + accesos + "]";
	}
}
