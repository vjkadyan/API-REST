package com.pedidos.api.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.pedidos.api.model.TipoMiCuenta;

@Service
public class LectoresJsonImp implements LectoresJson{
	
	private static final Logger log = Logger.getLogger(LectoresJsonImp.class);

	@Override
	public JSONObject leeJson(HttpServletRequest request) {
		
		StringBuilder stringBuilder = new StringBuilder();  
	    BufferedReader bufferedReader = null;  
	    JSONObject jsonO = null;
	    try 
	    {  
	        InputStream inputStream = request.getInputStream();

	        if (inputStream != null)
	        {
	            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

	            char[] charBuffer = new char[128];
	            int bytesRead = -1;

	            while ((bytesRead = bufferedReader.read(charBuffer)) > 0)
	            {
	                stringBuilder.append(charBuffer, 0, bytesRead);
	            }
	        }
	        else
	        {
	        	stringBuilder.append("");
	        }
	        String jsonString = corrigeAcentos(stringBuilder.toString());
	        log.info("json:"+jsonString);
	        jsonO = new JSONObject(jsonString);
	    }
	    catch (IOException | JSONException ex)
	    {
	    	ex.printStackTrace();
	        log.error("Error al leer json");
	    }
		finally
		{
	        if (bufferedReader != null)
	        {
	            try
	            {
	            	bufferedReader.close();
	            }
	            catch (IOException ex)
	            {
	                log.error("Error cerrando herramientas");
	            }
	        }
	    }
	    return jsonO;
	}

	public String corrigeAcentos(String cadena)
	{
		String resultado = cadena
				.replaceAll("Ã¡","á").replaceAll("Ã©","é").replace("Ã\\u00ad","í").replaceAll("Ã³","ó").replaceAll("Ãº","ú")
				.replace("Ã\\u0081","Á").replaceAll("Ã","É").replace("Ã\\u008d", "Í").replaceAll("Ã","Ó").replaceAll("Ã","Ú")
				.replaceAll("Ã±","ñ").replaceAll("Ã","Ñ");
		log.info("corr:"+resultado);
		return resultado;
	}

	@Override
	public TipoMiCuenta leeRegistraMisDatos(String texto) {
		TipoMiCuenta tipoMiCuenta = new TipoMiCuenta();
		try {
			JSONObject jObj = new JSONObject(texto);

			tipoMiCuenta.setClienteNum(jObj.getLong("clienteNum"));
			tipoMiCuenta.setUsuarioNum(jObj.getLong("usuarioNum"));
			tipoMiCuenta.setNombre(jObj.getString("nombre"));
			tipoMiCuenta.setApellido(jObj.getString("apellido"));
			tipoMiCuenta.setEmpresa(jObj.getString("empresa"));
			tipoMiCuenta.setFechaNac(jObj.getString("fechaNac"));
//			tipoMiCuenta.setFechaReg(jObj.getString("asdasd"));
//			tipoMiCuenta.setEnviaMsg(jObj.getString("asdasd"));
//			tipoMiCuenta.setEntregaCliente(jObj.getString("asdasd"));
			tipoMiCuenta.setTipoCuenta(jObj.getString("tipoCuenta"));
//			tipoMiCuenta.setCelularPrinc(jObj.getString("asdasd"));
//			tipoMiCuenta.setTelefonoPrinc(jObj.getString("asdasd"));
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
		return tipoMiCuenta;
	}

}
