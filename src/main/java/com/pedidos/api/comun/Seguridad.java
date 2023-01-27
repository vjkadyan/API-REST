package com.pedidos.api.comun;

import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.log4j.Logger;
import com.auth0.jwt.internal.org.apache.commons.codec.binary.Base64;
import com.auth0.jwt.internal.org.bouncycastle.util.Arrays;

public class Seguridad {
	private static final Logger log = Logger.getLogger(Seguridad.class);
	private final static String secretKey = "ofigyudtsrcgehsqwea";


	public static void main(String[] args) {
		String usuario = "sisweb07@dcm.com.mx";
		String password = "sisweb07";
		
		log.info("usuario:"+usuario+":");
		log.info("password:"+password+":");
		
		usuario = Seguridad.Encriptar(usuario);
		password = Seguridad.Encriptar(password);
		
		log.info("usuarioEnc:"+usuario+":");
		log.info("passwordEnc:"+password+":");
		
	}
	
	public static String Encriptar(String texto)
	{
		String cadenaEncriptada = "";

		try
		{
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
			byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

			SecretKey key = new SecretKeySpec(keyBytes, "DESede");
			Cipher cipher = Cipher.getInstance("DESede");
			cipher.init(Cipher.ENCRYPT_MODE, key);

			byte[] plainTextBytes = texto.getBytes("utf-8");
			byte[] buf = cipher.doFinal(plainTextBytes);
			byte[] base64Bytes = Base64.encodeBase64(buf);
			cadenaEncriptada = new String(base64Bytes);

		}
		catch (Exception ex) 
		{
			log.error("Error al encriptar cadena");
		}
		return cadenaEncriptada;
	}
	
	public static String Desencriptar(String textoEncriptado) throws Exception {
        String cadenaDesEncriptada = "";
 
        try {
            byte[] message = Base64.decodeBase64(textoEncriptado.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
 
            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);
 
            byte[] plainText = decipher.doFinal(message);
 
            cadenaDesEncriptada = new String(plainText, "UTF-8");
 
        } catch(Exception ex) {}
        return cadenaDesEncriptada;
	}
}
