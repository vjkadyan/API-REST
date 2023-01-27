package com.pedidos.api.comun;


import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;

/**
 * Esta clase sirve para filtrar las cadenas que estan en nulos.
 */
public class Cadena {

	private static final String ACENTOS         = "ÁÀÉÈÍÏÓÒÚÜáàèéíìïóòúüñç";
	private static final String REEPLAZAACENTOS = "*A*E*I*O*U*ae**i**ou*nc";
    private Cadena(){
    }
    /**
     * Medodo que sirve para quitar los espacios en blanco al inicio y final de una cadena. Si el valor de la cadena es nulo te regresa vacio
     * @param cadena
     * @return cadena
     */
    public static String filtra(String cadena){
        String regreso = "";
        if(cadena != null){
            regreso = cadena.trim();
        }
        return regreso;
    }
    
    /**
     * Medodo que sirve para quitar los espacios en blanco al inicio y final de una cadena. Si el valor de la cadena es nulo te regresa el valor asignado
     * @param cadena 
     * @param valor
     * @return cadena o valor
     */
    public static String filtra(String cadena,String valor){
        String regreso = valor;
        if(cadena != null){
            regreso = Cadena.filtra(cadena);
        }
        return regreso;
    }
    
    
    public static String filtraEspacios(String cadena){
    	
    	String texto = "";
    	cadena = Cadena.filtra(cadena);
    	
    	StringTokenizer tokens = new StringTokenizer(cadena);
        while(tokens.hasMoreTokens()){
            texto += " "+tokens.nextToken();
        }
        texto = texto.toString();
        texto = Cadena.filtra(texto);
            	
    	return texto.toUpperCase();
    }
    
        
    public static int getTotalPalabras(String cadena){
    	StringTokenizer tokens = new StringTokenizer(cadena);
    	return tokens.countTokens();
    }
    
    
    public static String reemplazaAcentos(String cadena){
    	cadena = Cadena.filtra(cadena);
    	if(!"".equals(cadena)){
    		for(int x=0;x<Cadena.ACENTOS.length();x++){
    			cadena = cadena.replaceAll(Cadena.ACENTOS.substring(x, x+1),Cadena.REEPLAZAACENTOS.substring(x, x+1));
    		}
    	}
    	return cadena;
    }
    
    
    public static String codificacionCorrecta(String cadena){
		byte ptext[];
		try {
			ptext = cadena.getBytes("ISO_8859_1");
			String cadenaConAcentos = new String(ptext, "UTF-8");
			return cadenaConAcentos;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		} 
		
	}
    
    
}
