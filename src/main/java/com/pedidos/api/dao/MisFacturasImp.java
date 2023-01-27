package com.pedidos.api.dao;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedidos.api.model.BitClienteRfc;
import com.pedidos.api.model.DatoFactNuevo;
import com.pedidos.api.model.DatosFacturacion;
import com.pedidos.api.model.DatosRefacturacion;
import com.pedidos.api.model.MisFacturas;
import com.pedidos.api.model.MisNotasCredito;
import com.pedidos.api.model.PyCliente;
import com.pedidos.api.model.PyClienteRfc;
import com.pedidos.api.model.PyMPago;
import com.pedidos.api.model.SatUsoCfdi;

@Service
public class MisFacturasImp implements MisFacturasDao{	
	@Autowired
	ObtieneMisFacturasDao misFacturasIfx;
	
	@Autowired
	private RegistroPedidos registroPedidosDao;
	
	public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    
	@Override
	public List<MisFacturas> consultaFacturas(long clienteNum, String fechaFacturas) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DatosFacturacion> obtieneRfcs(long clienteNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long corrigeSerie(String invoice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String agregaSerie(long invoice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String obtieneArchivo(long clienteNum, String invoice, String extension) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DatosFacturacion> obtieneDatosFacturacion(long clienteNum) {
		List<DatosFacturacion> listaRetorno = misFacturasIfx.obtieneDatosFacturacion(clienteNum);
		return listaRetorno;
	}

	@Override
	public List<SatUsoCfdi> obtieneCfdi(String tipoPersona) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DatosFacturacion consultaDatoFact(int rfcNum, String rfc, long clienteNum) {
		DatosFacturacion dato = misFacturasIfx.obtieneDatosFacturacion(rfcNum, rfc, clienteNum);
		return dato;
	}

	@Override
	public List<PyMPago> obtieneMPago() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DatosFacturacion> consultaCp(String cp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String guardaDatoFactNuevo(DatoFactNuevo dato) {
		String mensaje = "";
		boolean estatus = rfcValido(dato.getClienteRfc());
		if(estatus) {
			if(vacio(dato.getUsoCfdi())&&vacio(dato.getRazonSocial())&&vacio(dato.getTelefono())&&numero(dato.getTelefono())&&vacio(dato.getContact())&&vacio(dato.getDireccion())&&vacio(dato.getCp())&&numero(dato.getCp())&&vacio(dato.getColonia())&&vacio(dato.getEstado())&&vacio(dato.getDelegacion()))
			{
				//CORRECTO
				byte[] bytesDel = dato.getDelegacion().getBytes(ISO_8859_1); 
				String sDel = new String(bytesDel, UTF_8);
				dato.setDelegacion(sDel);
				
				byte[] bytesEst = dato.getEstado().getBytes(ISO_8859_1); 
				String sEst = new String(bytesEst, UTF_8);
				dato.setEstado(sEst);
			}
			else
			{
				mensaje="errorAlgunos campos estan vacios, o son incorrectos, favor de verificarlos";
				estatus = false;
			}		
		}
		else
		{
			mensaje = "errorRfc invalido";
		}
		if(estatus)
		{
			//VALIDA QUE YA EXISTA, EN PY CLIENTE NO SE MODIFICA NADA
			//VALIDA QUE EL CLIENTE EXISTA EN PY_CLIENTE
			PyCliente pyCliente = misFacturasIfx.obtieneDatosCliente(dato.getClienteNum());
			if(pyCliente.getClienteRfc().equals(dato.getClienteRfc()) || pyCliente.getClienteRfc() == dato.getClienteRfc())
			{
				mensaje = "errorEl Rfc ya existe y es el principal, no se puede modificar la informacion";
				estatus = false;
			}
			
			//VALIDA EN PY_CLIENTE_RFC
			if(estatus)
			{
				PyClienteRfc pyClienteRfc = new PyClienteRfc();
				pyClienteRfc.setClienteNum(dato.getClienteNum());
				pyClienteRfc.setIdUsoCfdi(dato.getUsoCfdi());
				pyClienteRfc.setNombre(corrigeAcentos(dato.getRazonSocial()));
				pyClienteRfc.setAddress1(corrigeAcentos(dato.getDireccion()));
				pyClienteRfc.setAddress2(corrigeAcentos(dato.getDireccion()));
				pyClienteRfc.setColonia(corrigeAcentos(dato.getColonia()));
				pyClienteRfc.setCity(dato.getDelegacion().toUpperCase());
				pyClienteRfc.setProvince(dato.getEstado().toUpperCase());
				pyClienteRfc.setPostalCode(dato.getCp());
				pyClienteRfc.setPhone(dato.getTelefono());
				pyClienteRfc.setContact(corrigeAcentos(dato.getContact()));
				pyClienteRfc.setmPago(Integer.toString(dato.getMpago()));
				pyClienteRfc.setClienteRfc(dato.getClienteRfc());
				
				PyClienteRfc pyClienteRfcCon = misFacturasIfx.obtieneDatosClienteRfc(dato.getClienteNum(),dato.getClienteRfc());
				if(pyClienteRfcCon.getClienteRfc() == null || "".equals(pyClienteRfcCon.getClienteRfc()) || pyClienteRfcCon.getClienteRfc() == "")
				{
					//NO EXISTE RFC, SE AGREGA NUEVO
					//INSERTA DATOS
					int inserta = 0;
					inserta = misFacturasIfx.insertaDatoFact(pyClienteRfc);
					if(inserta > 0)
					{
						mensaje = "correctoRFC agregado correctamente";
						registroPedidosDao.insertamembresiaClinte((int)dato.getClienteNum());
					}
					else
					{
						mensaje = "errorNo se pudo agregar el RFC nuevo";
					}
				}
				else
				{
					//YA EXISTE, SE ACTUALIZA
					//AGREGA A BITACORA
					BitClienteRfc bitacora = new BitClienteRfc();
					bitacora.setTipoBit("M");
					bitacora.setClienteNum(pyClienteRfcCon.getClienteNum());
					bitacora.setClienteRfc(pyClienteRfcCon.getClienteRfc());
					bitacora.setMensaje(pyClienteRfcCon.getRfcNum()+", "+pyClienteRfcCon.getNombre()+", "+pyClienteRfcCon.getAddress1() + 
							", "+pyClienteRfcCon.getColonia()+", "+pyClienteRfcCon.getCity()+", "+pyClienteRfcCon.getProvince()+", "+pyClienteRfcCon.getPostalCode());
					
					misFacturasIfx.agregaBitacoraRfc(bitacora);
					//ACTUALIZA
					int actualiza = misFacturasIfx.actualizaRfc(pyClienteRfc);
					if(actualiza < 0)
					{
						mensaje = "errorProblemas al actualizar el RFC nuevo";
					}
					else if(actualiza == 0)
					{
						mensaje = "errorNo se pudo actualizar el RFC nuevo";
					}
					else
					{
						mensaje = "correctoRFC actualizado correctamente";
						registroPedidosDao.insertamembresiaClinte((int)dato.getClienteNum());
					}
				}
			}
		}
		return mensaje;
	}

	@Override
	public String guardaDatoFactNuevoRefactura(DatosRefacturacion dato) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminaRfc(int rfcNum, String rfc, long clienteNum) {
		String mensaje = "";
		//AGREGA A BITACORA
		PyClienteRfc pyClienteRfcCon = misFacturasIfx.obtieneDatosClienteRfc(clienteNum,rfc);
		BitClienteRfc bitacora = new BitClienteRfc();
		bitacora.setTipoBit("E");
		bitacora.setClienteNum(pyClienteRfcCon.getClienteNum());
		bitacora.setClienteRfc(pyClienteRfcCon.getClienteRfc());
		bitacora.setMensaje(pyClienteRfcCon.getRfcNum()+", "+pyClienteRfcCon.getNombre()+", "+pyClienteRfcCon.getAddress1() + 
				", "+pyClienteRfcCon.getColonia()+", "+pyClienteRfcCon.getCity()+", "+pyClienteRfcCon.getProvince()+", "+pyClienteRfcCon.getPostalCode());

		misFacturasIfx.agregaBitacoraRfc(bitacora);
		//ELIMINA RFC
		int x = misFacturasIfx.eliminaRfc(rfcNum,clienteNum,rfc);
		switch(x)
		{
			case 0:
				mensaje = "errorAl eliminar el Rfc, por favor, comunicate con nosotros para mas informacion";
				break;
			case 1:
				mensaje = "correctoEl Rfc se elimino correctamente";
				break;
		}
		
		return mensaje; 
	}

	@Override
	public ArrayList<MisNotasCredito> consultaNotasC(long clienteNum, String fechaNotas) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MisNotasCredito> obtieneNotasByRfc(long clienteNum, String rfc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String obtieneRfcByRfcNum(long clienteNum, int rfcNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MisNotasCredito detalleNc(long clienteNum, String nc) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean rfcValido(String rfc) {
		String regex = "^([A-ZÑ&]{3,4})?(?:-?)?(\\d{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[12]\\d|3[01]))?(?:-?)?([A-Z\\d]{2})([A\\d])$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(rfc);
	    matcher.find();
		return matcher.matches();
	}
	
	public boolean vacio(String cadena)
	{
		if(cadena == "" || "".equals(cadena) || cadena == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public boolean numero(String cadena)
	{
		try
		{
			Long.parseLong(cadena);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public String corrigeAcentos(String cadena)
	{
		String resultado = cadena.replaceAll("Ã¡","á").replaceAll("Ã©","é").replaceAll("Ã­","í").replaceAll("Ã³","ó")
				.replaceAll("Ãº","ú").replaceAll("Ã","É").replaceAll("Ã","Ó").replaceAll("Ã","Ó").replaceAll("Ã","Ñ")
				.replaceAll("Ã±","ñ").replace("Ã?","Á");
		return resultado;
	}
}
