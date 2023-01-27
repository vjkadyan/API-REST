package com.pedidos.api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.core.SpringVersion;


public class Servicios {
	//Prod
		private static String urlServidor = "http://192.10.1.8:8081/Servicios";
	
	//URL GUS
		//private static String urlServidor = "http://192.10.2.166:8080/Servicios";
		

	public String POS(String xml,String requestMethod, String parametros) {
		String line = "";
		String json="";
		String url 		= urlServidor+parametros;
		String BASE64 	= "";
		String guia 	= "";
		StringBuilder result = new StringBuilder();
		try {
			URL Api = new URL(url);
			HttpURLConnection postConnection = (HttpURLConnection) Api.openConnection();
			postConnection.setConnectTimeout(20000); //set timeout to 5 seconds
			postConnection.setRequestMethod(requestMethod);
			postConnection.addRequestProperty("Accept", "application/json; charset=UTF-8");
			postConnection.addRequestProperty("Content-Type", "application/json; charset=utf-8");
			//postConnection.addRequestProperty("Charset", "UTF-8");;
			postConnection.setRequestProperty("Content-Length", "" + Integer.toString(xml.getBytes().length));
			//postConnection.setRequestProperty("Content-Language", "en-US");

			if(requestMethod == "POST") {
				postConnection.setUseCaches(false);
				postConnection.setDoInput(true);
				postConnection.setDoOutput(true);

				DataOutputStream dis = new DataOutputStream(postConnection.getOutputStream());
				dis.writeBytes(xml);
				dis.flush();
				dis.close();

				int code = postConnection.getResponseCode();
			
				InputStream input;
				if (code >= 400) {
					input = postConnection.getErrorStream();
				} else {
					input = postConnection.getInputStream();
				}

				BufferedReader docHtml = new BufferedReader(new InputStreamReader(input, "UTF-8"));

				
				String erro = "";

				while ((line = docHtml.readLine()) != null) {
					json = line;
				}
				
				docHtml.close();
				postConnection.disconnect();
			} else if (requestMethod == "GET" || requestMethod == "DELETE" ) {
			      try (BufferedReader reader = new BufferedReader(
		                  new InputStreamReader(postConnection.getInputStream()))) {
		          for (String line2; (line2 = reader.readLine()) != null; ) {
		              result.append(line2);
		          }
		      }
		      return result.toString();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
	
	
	public String PUT(String xml, String parametros) {
		String json="";
		try {
		//DEFINO LA URL
		String urlLive = urlServidor+parametros;
		HttpClient client = HttpClientBuilder.create().build();

		//AGREGO LOS PARAMETROS Y HEADERS AL OBJETO HTTPPOST
		HttpPut post = new HttpPut(urlLive);
		post.setHeader("Content-Type", "application/json; charset=UTF-8");
		StringEntity entity = new StringEntity(xml, Charset.forName("UTF-8"));
		entity.setContentType("application/json; charset=UTF-8");
		entity.setContentEncoding("UTF-8");
		post.setEntity(entity);
		//SE EJECUTA LA PETICION Y SE LEE LA RESPUESTA COMO JSON
		HttpResponse response = client.execute(post);
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		StringBuffer result = new StringBuffer();
		   String line = "";
		   while ((line = rd.readLine()) != null) {
		       json = line;
		   };
		} catch (Exception e) {
		e.printStackTrace();
		}
		return json;
	}

	 @Autowired
	 private JdbcTemplate jdbcTemplate;
	   public static void main(String[] args) throws Exception
	   {
		   System.out.println("version: " + SpringVersion.getVersion());
	   }

}
