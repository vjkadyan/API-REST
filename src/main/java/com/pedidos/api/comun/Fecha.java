package com.pedidos.api.comun;


import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
//import mx.com.dcm.ventas.implementacion.SaOrdHDaoImp;

/**
 * Esta clase sirve para el manejo eficiente de las fechas
 * 
 * @see <a href = "http://www.dcm.com" />Ver Pagina</a>
 */
@Component
public class Fecha {
	//private static final Logger log = Logger.getLogger(SaOrdHDaoImp.class);

	public static final String DDMMYYYY = "dd/MM/yyyy";
	public static final String YYYYMMDD = "yyyy-MM-dd";
	public static final String MMDDYYYY = "MM/dd/yyyy"; //INFORMIX
	public static final String MES = "MM";
	public static final String YEAR = "yyyy";
	private static final int TAMANO = 2;

	private SimpleDateFormat sdf;
	private Date fechaVal;
	private String formatoFecha;
	private Calendar c;

	/**
	 * Constructor
	 */
	public Fecha() {
		sdf = new SimpleDateFormat(Fecha.DDMMYYYY);
	}

	/**
	 * Metodo que define en que formato recibe la fecha
	 * 
	 * @param formatoFecha
	 *            es una cadena que recibe el formato de las fechas DDMMYYYY = 'dd/MM/yyyy' , YYYYMMDD = 'yyyy-MM-dd' , MMDDYYYY ='MM/dd/yyyy' , MES = 'MM' ,YEAR = 'yyyy'
	 * 
	 */
	public void setFormatoFecha(String formatoFecha) {
		this.formatoFecha = formatoFecha;
	}

	/**
	 * Retorna el formatoFecha que se a estado usando
	 * 
	 * @return formatoFecha
	 */
	public String getFormatoFecha() {
		return this.formatoFecha;
	}

	/**
	 * Metodo que sirve para insertar la fecha
	 * 
	 * @param fechaVal
	 */
	public void setFecha(Date fechaVal) {
		this.fechaVal = fechaVal;
	}

	/**
	 * Metodo que sirve para obtener la fecha en un objeto Date
	 * 
	 * @return fecha
	 */
	public Date getFechaDate() {
		return this.fechaVal;
	}

	/**
	 * Metodo que inserta la fecha pero deber&aacute; de respetar el formatoFecha de la fecha para que no marque una Exception
	 * 
	 * @param lFecha
	 *            es la fecha en cadena
	 */
	public void setFecha(String lFecha) {
		this.sdf = new SimpleDateFormat(this.formatoFecha);
		this.fechaVal = sdf.parse(lFecha, new ParsePosition(0));
	}

	/**
	 * Obtiene la fecha en el formatoFecha solicitado
	 * 
	 * @param formatoFecha
	 * @return String Fecha
	 **/
	public String getFecha(String formatoFecha) {
		//log.info(formatoFecha);
		this.sdf = new SimpleDateFormat(formatoFecha);
		return this.sdf.format(this.fechaVal);
	}

	/***
	 * @param numDias
	 * @param formatoFecha
	 * @return arreglo de string
	 */
	public String[] getFechaActualAddDias(int numDias, String formatoFecha) {
		String[] fecha = new String[Fecha.TAMANO];
		c = Calendar.getInstance();

		this.setFecha(c.getTime());
		fecha[1] = this.getFecha(formatoFecha);

		c.add(Calendar.DATE, numDias);

		this.setFecha(c.getTime());
		fecha[0] = this.getFecha(formatoFecha);

		return fecha;
	}

	/**
	 * Obtiene la fecha en el formatoFecha que a sido configurado previamente
	 * 
	 * @return fechaVal
	 **/
	public String getFecha() {
		this.sdf = new SimpleDateFormat(this.formatoFecha);
		return this.sdf.format(this.fechaVal);
	}

	/**
	 * Regresa la fecha de hoy del sistema
	 * 
	 * @return fecha del sistema
	 **/
	public String getFechaHoy() {
		c = Calendar.getInstance();
		this.setFecha(c.getTime());
		this.sdf = new SimpleDateFormat(this.formatoFecha);
		return this.sdf.format(fechaVal);
	}

	/**
	 * Regresa la fecha de hoy del sistema
	 * 
	 * @param fecha
	 *            se debe de pasar la fecha en el formatoFecha definido
	 * @return fecha del sistema
	 */
	public String getFecha(Date fecha) {
		this.sdf = new SimpleDateFormat(this.formatoFecha);
		return this.sdf.format(fecha);

	}

	/**
	 * Regresa la fecha de un dia anterior al del Sistema
	 * 
	 * @return fecha
	 */
	public String getFechaAyer() {
		String lstrformatoFecha = this.formatoFecha;
		this.formatoFecha = "yyyy D";
		int liDia = (new Integer(this.getFechaHoy().substring(4).trim())).intValue() - 1;
		String fechaHoy = this.getFechaHoy().substring(0, 4) + " " + liDia;
		this.setFecha(fechaHoy);
		this.setFormatoFecha(lstrformatoFecha);
		return getFecha();
	}

	public int diasEntreDosFechas(String fechaFinal, String fechaInicial) {
		SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
		int diferencia = 0;
		try {
			Date fecha1 = myFormat.parse(fechaInicial);
			Date fecha2 = myFormat.parse(fechaFinal);
			long resta = fecha2.getTime() - fecha1.getTime();
			// log.info ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
			diferencia = (int) TimeUnit.DAYS.convert(resta, TimeUnit.MILLISECONDS);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return diferencia;
	}

	public String comparaFechas(String fechaFinal, String fechaInicial) {
		SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
		String fecha = "";
		int diferencia = 0;
		try {
			Date fecha1 = myFormat.parse(fechaInicial);
			Date fecha2 = myFormat.parse(fechaFinal);
			long resta = fecha2.getTime() - fecha1.getTime();
			// log.info ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
			diferencia = (int) TimeUnit.DAYS.convert(resta, TimeUnit.MILLISECONDS);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (diferencia > 0) {
			fecha = fechaFinal;
		} else {
			fecha = fechaInicial;
		}
		return fecha;
	}

	public String agregarDiasAFecha(String fechaInicial, int dias) {
		SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
		String fecha = "";
		try {
			Date fecha1 = myFormat.parse(fechaInicial);
			c.setTime(fecha1);
			c.add(Calendar.DATE, dias);
			fecha = myFormat.format(c.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return fecha;
	}

	/**
	 * Realiza el cambio de formato de una fecha establecida
	 * 
	 * @param String
	 *            lstrOriginal Contiene el formato original la fecha a transformar
	 * @param String
	 *            lstrNuevo Contiene el formato al que se desea cambiar
	 * @param String
	 *            lstrFecha Fecha que se va a transformar
	 * @return String Fecha Transformada
	 **/
	public String CambiaFormatoFecha(String lstrOriginal, String lstrNuevo, String lstrFecha) {
		// "yyMMdd" //"dd/MM/yyyy"
		SimpleDateFormat lsdfFecha = new SimpleDateFormat(lstrOriginal);
		java.util.Date lfecOriginal = lsdfFecha.parse(lstrFecha, new ParsePosition(0));
		SimpleDateFormat lsdfNuevo = new SimpleDateFormat(lstrNuevo);
		return (lsdfNuevo.format(lfecOriginal));
	}
	
	public static void main(String[] args) {
		Fecha f = new Fecha();
//		String fecha = f.getFecha("MM/DD/YYYY hh:mm:ss");
//		f.setFormatoFecha("MMDD/YYYY hh:mm:ss");
		f.setFecha(new Date());
		//log.info(f.getFecha());
	}
}
