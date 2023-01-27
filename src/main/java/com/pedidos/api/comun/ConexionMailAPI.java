package com.pedidos.api.comun;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;

public class ConexionMailAPI {

	private static final Logger LOG = Logger.getLogger(ConexionMailAPI.class);

	public boolean sendMail(String variables) {
		URL u;
		InputStream is = null;
		DataInputStream dis;
		String s;
		variables = variables.replace("@", "%40");
		variables = variables.replaceAll("[+]", "%2B");
		variables = variables.replace(" ", "+");
		boolean ban = false;
		try {
			// u = new URL(Rutas.RUTA_P_PEDIDOS_NEW + "MandrilAPI/mailAPI" + variables);
			//u = new URL("http://192.10.1.213:8080/MandrilAPI/mailAPI" + variables);// PEGASO/PRODUCCION
			//u = new URL("http://192.10.2.166:8080/MandrilAPI/mailAPI" + variables);// LOCAL
			u = new URL("http://192.10.1.8:9081//MandrilAPI/mailAPI" + variables);// 
			LOG.info(u.toString());
			is = u.openStream();
			String ans = "";
			dis = new DataInputStream(new BufferedInputStream(is));
			while ((s = dis.readLine()) != null) {
				ans += s;
			}
			LOG.info("Answer : " + ans);
			if (ans.startsWith("Exito")) {
				ban = true;
			}
		} catch (MalformedURLException mue) {
			LOG.error("Ouch - a MalformedURLException happened.");
			mue.printStackTrace();
			return false;
		} catch (IOException ioe) {
			LOG.error("Oops- an IOException happened.");
			ioe.printStackTrace();
			return false;
		} finally {
			if (is != null)
				try {
					is.close();
					return ban;
				} catch (IOException e) {
					e.printStackTrace();
					return ban;
				}
		}
		return ban;
	}

	public static void main(String[] args) {
		String opt = "?opt=35";
		String mail = "&email=gustavo.p@pedidos.com.mx";
		String find = "&find=%26codigo";
		String change = "&change=1212";			
		String variables = opt + mail + find + change;
		ConexionMailAPI apiMail = new ConexionMailAPI();
		if (apiMail.sendMail(variables)) {
		} else {
			LOG.error("ERROR");
		}
	}
}