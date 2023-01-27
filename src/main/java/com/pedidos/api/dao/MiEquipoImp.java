package com.pedidos.api.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pedidos.api.comun.Fecha;
import com.pedidos.api.model.CatCorreos;
import com.pedidos.api.model.CatModuloCuenta;
import com.pedidos.api.model.CatTelefonoCuenta;
import com.pedidos.api.model.CorreosUsuario;
import com.pedidos.api.model.ModulosUsuario;
import com.pedidos.api.model.PermisosCorreos;
import com.pedidos.api.model.PermisosModulos;
import com.pedidos.api.model.PyCelularSms;
import com.pedidos.api.model.PyTelefonoCliente;
import com.pedidos.api.model.PyUsuario;
import com.pedidos.api.model.PyUsuarioEquipo;
import com.pedidos.api.model.RegistraUsuario;
import com.pedidos.api.model.TipoMiCuenta;

@Service
public class MiEquipoImp implements MiEquipoDao {
	
	private static Logger log = Logger.getLogger(MiEquipoImp.class);
	
	@Autowired
	private PyUsuarioEquipoDao pyUsuarioEquipoDaoImp;
	
	@Autowired
	private ObtieneMiEquipoDao obtieneMiEquipoImp;
	
	@Autowired
	//@Qualifier("pyUsuarioImp")
	private PyUsuarioDao pyUsuarioDaoImp;
	
	@Autowired
	private PyClienteDao pyClienteImp;
	
	@Autowired
	private Fecha fechaImpl;
	
	@Autowired
	private CatCorreosDao catCorreosImp;
	
	@Autowired
	private PermisosCorreosDao permisosCorreosImp;
	
	@Autowired
	private CatModuloCuentaDao catModuloCuentaDaoImp;
	
	@Autowired
	private PermisosModulosDao permisosModulosImp;
	
	@Autowired
	private CatTelefonoCuentaDao catTelefonoCuentaDaoImp;
	
	@Autowired 
	private PyCelularSmsDao pyCelularSmsDaoImp;
	
	@Autowired
	private PyTelefonoClienteDao pytelefonoClienteDaoImp;
	
	@Autowired 
	private TipoMiCuentaDao tipoMiCuentaDaoImp;
	 
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public String obtieneTipoUsuario(long usuarioNum) throws SQLException {
		return pyUsuarioEquipoDaoImp.getTipoUsuario(usuarioNum);
	}
	
	@Override
	public int getAccionUsuario(long usuarioNum, String tipoUsuario) throws SQLException {
		return obtieneMiEquipoImp.getAccionUsuario(usuarioNum, tipoUsuario);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public List<ModulosUsuario> obtieneModulosUsuario(long usuarioNum, String tipoUsuario) throws SQLException {
		return obtieneMiEquipoImp.getModulosUsuario(usuarioNum, tipoUsuario);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public List<CorreosUsuario> obtieneCorreosUsuario(long usuarioNum, String tipoUsuario) throws SQLException {
		return obtieneMiEquipoImp.getCorreosUsuario(usuarioNum, tipoUsuario);
	}
	
	@Override
	public String obtieneIdentificador(long usuarioNum, String tipoUsuario) throws SQLException {
		String identificador = "38, 79, 116";
		if("equipo".equals(tipoUsuario))
		{
			identificador = pyUsuarioEquipoDaoImp.obtieneIdentificador(usuarioNum);
		}
		return identificador;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public String registraUsuario(JSONObject usuarioJson, int usuario_num) throws SQLException {
		String mensaje = "";
		RegistraUsuario usuario = new RegistraUsuario(usuarioJson, "Registro");
		log.info("insertar:"+usuario);
		if(!"JSONExceptionError".equals(usuario.getNombre()))
		{
			PyUsuario existeUsuario = pyUsuarioDaoImp.existeUsuario(usuario.getCorreo(), 38000);
			boolean pyCliente = pyClienteImp.existePyCliente(usuario.getCorreo(), 38000);
			
			if (existeUsuario == null && pyCliente == false)
			{
				//SE PUEDE AGREGAR, CONSULTA EL DEL ADMINISTRADOR PARA CLONARLO
				PyUsuario pyUsuarioOriginal = pyUsuarioDaoImp.getByUserUsuarioNum(usuario.getUsuarioNum());
				PyUsuario pyUsuarioEntidad = new PyUsuario();
				log.info("Original:"+pyUsuarioOriginal.toString());

				long clienteNum = usuario.getClienteNum();
				long usuarioNum = usuario_num;
				
//											CREA USUARIO - INSERTA PY_USUARIO IFX Y ATN
				fechaImpl.setFormatoFecha("dd-MM-yyyy");
				pyUsuarioEntidad.setUsuarioNum(usuarioNum);
				pyUsuarioEntidad.setClienteNum(clienteNum);
				pyUsuarioEntidad.setCustNum(pyUsuarioOriginal.getCustNum());
				pyUsuarioEntidad.setUsuario(usuario.getCorreo());
				pyUsuarioEntidad.setPassword(usuario.getPassword());
				pyUsuarioEntidad.setNombre(usuario.getNombre());
				pyUsuarioEntidad.setEmail(usuario.getCorreo());
				pyUsuarioEntidad.setEstatus(pyUsuarioOriginal.getEstatus().trim());
				pyUsuarioEntidad.setReserva(pyUsuarioOriginal.getReserva().trim());
				pyUsuarioEntidad.setIva(pyUsuarioOriginal.getIva().trim());
				pyUsuarioEntidad.setClaveIva(pyUsuarioOriginal.getClaveIva().trim());
				pyUsuarioEntidad.setLimiteCredito(pyUsuarioOriginal.getLimiteCredito());
				pyUsuarioEntidad.setCreditoUtilizado(pyUsuarioOriginal.getCreditoUtilizado());
				pyUsuarioEntidad.setTipoUsuario(pyUsuarioOriginal.getTipoUsuario().trim());
				pyUsuarioEntidad.setObservacion(pyUsuarioOriginal.getObservacion().trim());
				pyUsuarioEntidad.setConPrecio(pyUsuarioOriginal.getConPrecio().trim());
				pyUsuarioEntidad.setAltadir(pyUsuarioOriginal.getAltadir().trim());
				pyUsuarioEntidad.setUltimaVis(fechaImpl.getFechaHoy());
				pyUsuarioDaoImp.insertPyUsuario(pyUsuarioEntidad);
				
//											INSERTA EQUIPO - INSERTA EN PY_USUARIO_EQUIPO
				PyUsuarioEquipo entidadPUE = new PyUsuarioEquipo();
				entidadPUE.setClienteNum(clienteNum);
				entidadPUE.setUsuarioNum(usuarioNum);
				entidadPUE.setCargo(usuario.getPuesto());
				entidadPUE.setAccionNum(4); //NIVEL DE PERMISO CAT_ACCION_CUENTA
				entidadPUE.setIdentificador(usuario.getColor());
				entidadPUE.setStatus("A");
				pyUsuarioEquipoDaoImp.insertRow(entidadPUE);

//											INSERTA PERMISOS C Y M
				//CONSULTA (cat_correos)
				String correos = "";
				int lenCorreos = usuario.getCorreos().size();
				for(int cont = 0; cont < lenCorreos; cont++)
				{
					correos += "'"+usuario.getCorreos().get(cont)+"'"+((cont < lenCorreos-1)?",":"");
				}
				List<CatCorreos> listaCorreos = catCorreosImp.getCorreos(correos);
				
				//INSERTA LOS PERMISOS EN CORREOS (permisos_correos)
				PermisosCorreos entidadCorreos = new PermisosCorreos();
				for(CatCorreos correo : listaCorreos)
				{
					entidadCorreos = null;
					entidadCorreos = new PermisosCorreos();
					entidadCorreos.setClienteNum(clienteNum);
					entidadCorreos.setUsuarioNum(usuarioNum);
					entidadCorreos.setCorreoNum(correo.getCorreoNum());
					entidadCorreos.setStatus("A");      
					permisosCorreosImp.insertRow(entidadCorreos);
				}

				//CONSULTA (cat_modulo_cuenta)
				String modulos = "'MisDatos','Favoritos','Listas','Recomendados',";//AGREGA POR DEFAULT MIS DATOS
				int lenModulos = usuario.getAccesos().size();
				for(int cont = 0; cont < lenModulos; cont++)
				{
					modulos += "'"+usuario.getAccesos().get(cont)+"'"+((cont < lenModulos-1)?",":"");
				}
				List<CatModuloCuenta> listaModulos = catModuloCuentaDaoImp.listaModulos(modulos);
				
				//INSERTA LOS PERMISOS EN MODULOS (permisos_modulos)
				PermisosModulos entidadModulos = new PermisosModulos();
				for(CatModuloCuenta modulo : listaModulos)
				{
					entidadModulos = null;
					entidadModulos = new PermisosModulos();
					entidadModulos.setClienteNum(clienteNum);
					entidadModulos.setUsuarioNum(usuarioNum);
					entidadModulos.setModuloNum(modulo.getModuloNum());
					entidadModulos.setStatus("A");
					permisosModulosImp.insertRow(entidadModulos);
				}
				
				//AGREGA TELEFONO
				PyTelefonoCliente pyTelefonoCEntidad = new PyTelefonoCliente();
				pyTelefonoCEntidad.setClienteNum(clienteNum);
				pyTelefonoCEntidad.setUsuarioNum(usuarioNum);
				pyTelefonoCEntidad.setTelefono(usuario.getTelefono());
				pyTelefonoCEntidad.setExtension(usuario.getExt());
				pyTelefonoCEntidad.setTipoNum(usuario.getTipoTel());
				pyTelefonoCEntidad.setStatus("A");
				pyTelefonoCEntidad.setRolNum(0);
				agregaTelCel(pyTelefonoCEntidad);
				
				mensaje = "Correcto";
			}
			else
			{
				mensaje = "ERROREl correo ya tiene asignada una cuenta, proporciona otro";
			}
		}
		else
		{
			mensaje = "ERROROcurrio un problema al agregar aL usuario";
		}
		
		return mensaje;
	}
	
	public int agregaTelCel(PyTelefonoCliente pyTelefonoCliente) throws SQLException {
		CatTelefonoCuenta catTelefonoCuenta = new CatTelefonoCuenta();
		PyCelularSms pyCelularSms = new PyCelularSms();
		catTelefonoCuenta.setTipoNum(pyTelefonoCliente.getTipoNum());
		catTelefonoCuenta = catTelefonoCuentaDaoImp.getByIdRow(catTelefonoCuenta);
		if (catTelefonoCuenta.getTipo().contains("cel") || catTelefonoCuenta.getTipo().contains("Cel")) {
			int celularNum = pyCelularSmsDaoImp.getConsec(pyTelefonoCliente.getClienteNum());
			pyCelularSms.setCelular_num(celularNum);
			pyCelularSms.setCelular(pyTelefonoCliente.getTelefono());
			pyCelularSms.setCliente_num(pyTelefonoCliente.getClienteNum());
			pyCelularSms.setStatus("A");
			pyCelularSmsDaoImp.insertRow(pyCelularSms);
			return 1;
		} else {
			pytelefonoClienteDaoImp.insertRow(pyTelefonoCliente);
			return 1;
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public String modificaUsuario(JSONObject usuarioJson) throws SQLException {
		String mensaje = "Ok";
		RegistraUsuario usuario = new RegistraUsuario(usuarioJson, "Modifica");
		log.info("Es:"+usuario.toString());
		long usuarioMod = obtieneMiEquipoImp.perteneceEquipo(usuario.getCorreo(), usuario.getUsuarioNum());
		if((usuarioMod > 0) && "administrador".equals(usuario.getTipoCuenta()))
		{
			log.info("pertenece:" + usuarioMod);
			
			//ACTUALIZA COLOR
			PyUsuarioEquipo pyUsuarioE = new PyUsuarioEquipo();
			pyUsuarioE.setUsuarioNum(usuarioMod);
			pyUsuarioE.setIdentificador(usuario.getColor());
			pyUsuarioEquipoDaoImp.updateColor(pyUsuarioE);
			
			//CONSULTA (cat_correos)
			String correos = "";
			int lenCorreos = usuario.getCorreos().size();
			for(int cont = 0; cont < lenCorreos; cont++)
			{
				correos += "'"+usuario.getCorreos().get(cont)+"'"+((cont < lenCorreos-1)?",":"");
			}
			List<CatCorreos> listaCorreos = catCorreosImp.getCorreos(correos);
			PermisosCorreos entidadCorreos = new PermisosCorreos();
			
			//ELIMINA PERMISOS ANTERIORES
			entidadCorreos.setUsuarioNum(usuarioMod);
			int perC = permisosCorreosImp.deleteRow(entidadCorreos);
			log.info("perC:"+perC);
			if(perC > 0)
			{
				//INSERTA LOS PERMISOS EN CORREOS (permisos_correos)
				for(CatCorreos correo : listaCorreos)
				{
					entidadCorreos = null;
					entidadCorreos = new PermisosCorreos();
					entidadCorreos.setClienteNum(usuario.getClienteNum());
					entidadCorreos.setUsuarioNum(usuarioMod);
					entidadCorreos.setCorreoNum(correo.getCorreoNum());
					entidadCorreos.setStatus("A");
					permisosCorreosImp.insertRow(entidadCorreos);
				}
	
				//CONSULTA (cat_modulo_cuenta)
				String modulos = "'MisDatos',";//AGREGA POR DEFAULT MIS DATOS
				int lenModulos = usuario.getAccesos().size();
				for(int cont = 0; cont < lenModulos; cont++)
				{
					modulos += "'"+usuario.getAccesos().get(cont)+"'"+((cont < lenModulos-1)?",":"");
				}
				List<CatModuloCuenta> listaModulos = catModuloCuentaDaoImp.listaModulos(modulos);
				
				//INSERTA LOS PERMISOS EN MODULOS (permisos_modulos)
				PermisosModulos entidadModulos = new PermisosModulos();
				
				//ELIMINA PERMISOS ANTERIORES
				entidadModulos.setUsuarioNum(usuarioMod);
				int perM = permisosModulosImp.deleteRow(entidadModulos);
				log.info("preM:"+perM);
				if(perM > 0)
				{
					for(CatModuloCuenta modulo : listaModulos)
					{
						entidadModulos = null;
						entidadModulos = new PermisosModulos();
						entidadModulos.setClienteNum(usuario.getClienteNum());
						entidadModulos.setUsuarioNum(usuarioMod);
						entidadModulos.setModuloNum(modulo.getModuloNum());
						entidadModulos.setStatus("A");
						permisosModulosImp.insertRow(entidadModulos);
					}
				}
				else
				{
					mensaje = "ERROR Ocurrio un problema al actualizar al usuario ";
				}
			}
			else
			{
				mensaje = "ERROR Ocurrio un problema al actualizar al usuario ";
			}
		}
		else
		{
			mensaje = "ERROR El usuario a modificar no es parte de su equipo";
		}
		return mensaje;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public String estatusUsuario(JSONObject usuarioJson, String tipoEstatus)  throws SQLException {
		String mensaje = "Ok";
		try
		{
			String correo = usuarioJson.getString("correo").trim();
			long usuarioNum = usuarioJson.getLong("usuario");
			String tipoCuenta = usuarioJson.getString("tipoCuenta").trim();
			long clienteNum = usuarioJson.getLong("clienteNum");
			
			long usuarioMod = obtieneMiEquipoImp.perteneceEquipo(correo, usuarioNum);
			if((usuarioMod > 0) && "administrador".equals(tipoCuenta))
			{
				//PY_USUARIO
				PyUsuario pyEntidad = new PyUsuario();
				pyEntidad.setClienteNum(clienteNum);
				pyEntidad.setUsuarioNum(usuarioMod);
				pyEntidad.setCustNum(38000);
				pyEntidad.setEstatus(tipoEstatus);
				int pui = pyUsuarioDaoImp.estatusUsuario(pyEntidad);
				log.info("actualizados a "+tipoEstatus+" py_usuario:"+pui + ", usuario:"+usuarioMod);
				
				//PY_USUARIO_EQUIPO
				int pyei = pyUsuarioEquipoDaoImp.estatusUsuario(usuarioMod, tipoEstatus);
				log.info("actualizados a "+tipoEstatus+" py_usuario_equipo:"+pyei + ", usuario:"+usuarioMod);
				
				//PERMISOS_MODULOS
				int pmi = permisosModulosImp.estatusUsuario(usuarioMod, tipoEstatus);
				log.info("actualizados a "+tipoEstatus+" permisos_modulos:"+pmi + ", usuario:"+usuarioMod);
				
				//PERMISOS_CORREOS
				int pci = permisosCorreosImp.estatusUsuario(usuarioMod, tipoEstatus);
				log.info("actualizados a "+tipoEstatus+" permisos_correos:"+pci + ", usuario:"+usuarioMod);
				
				mensaje = "Actualizado correctamente";
			}
			else
			{
				if("I".equals(tipoEstatus))
				{
					mensaje = "ERROREl usuario a desactivar no es parte de su equipo";
				}
				else if("A".equals(tipoEstatus))
				{
					mensaje = "ERROREl usuario a activar no es parte de su equipo";
				}
			}
		}
		catch(JSONException e)
		{
			log.error("Error al convertir el json " + e.getMessage());
			e.printStackTrace();
			if("I".equals(tipoEstatus))
			{
				mensaje = "ERROROcurrio un problema al desactivar aL usuario";
			}
			else if("A".equals(tipoEstatus))
			{
				mensaje = "ERROROcurrio un problema al activar aL usuario";
			}
		}
		return mensaje;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public String asignaAdmin(JSONObject usuarioJson) {

		String mensaje = "Ok";
		try
		{
			String correo = usuarioJson.getString("correo").trim();
			long usuarioNum = usuarioJson.getLong("usuario");
			String tipoCuenta = usuarioJson.getString("tipoCuenta").trim();
			long clienteNum = usuarioJson.getLong("clienteNum");
			String cargo = usuarioJson.getString("cargo");
			
			long usuarioMod = obtieneMiEquipoImp.perteneceEquipo(correo, usuarioNum);
			if((usuarioMod > 0) && "administrador".equals(tipoCuenta))
			{
				//VALIDA QUE ESTÉ ACTIVO EL USUARIO
				//CONSULTA ADMIN NUEVO
				PyUsuarioEquipo pyUsuarioEqN = pyUsuarioEquipoDaoImp.getByUsuario(usuarioMod);
				//PyUsuario pyUsuarioN = pyUsuarioDaoImp.getByUserUsuarioNum(usuarioMod);
				if("A".equals(pyUsuarioEqN.getStatus()))
				{
					//CONSULTA ADMIN ACTUAL
					//TipoMiCuenta tipoMiCuentaA = tipoMiCuentaDaoImp.getByUsuario(usuarioNum);
					//PyUsuario pyUsuarioA = pyUsuarioDaoImp.getByUserUsuarioNum(usuarioNum);
					
					//CONSULTA LOS NUEVOS PERMISOS QUE AGREGARÁ, QUEDARÁ COMO USUARIO NUEVO
					List<CorreosUsuario> listaCorrA = obtieneCorreosUsuario(usuarioNum, "nuevo");
					List<ModulosUsuario> listaModA = obtieneModulosUsuario(usuarioNum, "nuevo");
	
					PyUsuarioEquipo entidadPUE = new PyUsuarioEquipo();
					entidadPUE.setClienteNum(clienteNum);
					entidadPUE.setUsuarioNum(usuarioNum);
					entidadPUE.setCargo(cargo);
					entidadPUE.setAccionNum(4);
					entidadPUE.setIdentificador("96, 124, 255");
					entidadPUE.setStatus("A");
					log.info("entidadPUE:"+entidadPUE.toString());
					pyUsuarioEquipoDaoImp.insertRow(entidadPUE);
					
					//AGREGA LOS NUEVOS PERMISOS AL ADMIN QUE SE ELIMINA
					for(CorreosUsuario correos :listaCorrA)
					{
						if("S".equals(correos.getAcceso()))
						{
							PermisosCorreos entidadC = new PermisosCorreos();
							entidadC.setClienteNum(clienteNum);
							entidadC.setUsuarioNum(usuarioNum);
							entidadC.setCorreoNum(correos.getCorreoNum());
							entidadC.setStatus("A");
							log.info("nuevos correos:"+entidadC.toString());
							permisosCorreosImp.insertRow(entidadC);
						}
					}
					
					for(ModulosUsuario modulos :listaModA)
					{
						if("S".equals(modulos.getAcceso()))
						{
							PermisosModulos entidadM = new PermisosModulos();
							entidadM.setClienteNum(clienteNum);
							entidadM.setUsuarioNum(usuarioNum);
							entidadM.setModuloNum(modulos.getModuloNum());
							entidadM.setStatus("A");
							log.info("nuevos accesos:"+entidadM.toString());
							permisosModulosImp.insertRow(entidadM);
						}
					}
					
					
					//ELIMINA PERMISOS ANTERIORES DEL NUEVO ADMIN
					permisosCorreosImp.deleteByUsuario(usuarioMod);
					permisosModulosImp.deleteByUsuario(usuarioMod);
					pyUsuarioEquipoDaoImp.deleteRow(pyUsuarioEqN);
					log.info("elimino c m pue");
					
					//ACTUALIZA TIPO_MI_CUENTA CON EL NUEVO ADMIN
					TipoMiCuenta entidadTCA = new TipoMiCuenta();
					entidadTCA.setUsuarioNum(pyUsuarioEqN.getUsuarioNum());
					String[] nombreC = pyUsuarioEqN.getNombre().split(" ");
					String nombre = "";
					String apellido = "";
					for(int x = 0; x < nombreC.length; x++)
					{
						if(x == 0)
						{
							nombre = nombreC[x];
						}
						else
						{
							apellido += nombreC[x] + " ";
						}
					}
					entidadTCA.setNombre(nombre);
					entidadTCA.setApellido(apellido);
					
					entidadTCA.setCelularPrinc(pyUsuarioEqN.getCelularPrinc());
					entidadTCA.setTelefonoPrinc(pyUsuarioEqN.getTelefonoPrinc());
					log.info("entidadTCA:"+entidadTCA.toString());
					tipoMiCuentaDaoImp.updateAdmin(entidadTCA,usuarioNum);
				}
				else
				{
					mensaje = "ERROREl usuario se encuentra desactivado, activelo para poder asignarlo como administrador";
				}
			}
			else
			{
				mensaje = "ERROREl usuario no pertenece al equipo, no se proceso el cambio";
			}
		}
		catch(JSONException | SQLException e)
		{
			log.error("Error al convertir el json " + e.getMessage());
			e.printStackTrace();
			mensaje = "ERROROcurrio un problema al asignar administrador al usuario";
		}
		return mensaje;
	}
}
