package com.pedidos.api.model;

import java.util.List;

public class PyUsuario {
    private long usuarioNum;
    private long clienteNum;
    private long custNum;
    private String usuario;
    private String password; 
    private String nombre;
    private String email;
    private String estatus;
    private String reserva;
    private String iva;
    private String claveIva;
    private double limiteCredito;
    private double creditoUtilizado;
    private String tipoUsuario;
    private String observacion;
    private String conPrecio;
    private String altadir;
    private String ultimaVis;
    private String ejecutiva;
    private String ext;
    private boolean afiliacion;
    private int favoritos;
    private int partidas;
    private String token;
    
    //Identifica un Usuario alterno de pedidos
    private String tipoUsuarioPed;
    private int nivelAcceso;
    private String identificador;
    private List<ModulosUsuario> listaModulos;
    private List<CorreosUsuario> listaCorreos;
    
    /**
	 * @param usuarioNum
	 */
	public PyUsuario(long usuarioNum) {
		super();
		this.usuarioNum = usuarioNum;
	}


	/**
     * 
     */
    public PyUsuario() {
        super();
    }
    
    
    /**
     * @return the usuarioNum
     */
    public long getUsuarioNum() {
        return usuarioNum;
    }
    /**
     * @param usuarioNum the usuarioNum to set
     */
    public void setUsuarioNum(long usuarioNum) {
        this.usuarioNum = usuarioNum;
    }
    /**
     * @return the clienteNum
     */
    public long getClienteNum() {
        return clienteNum;
    }
    /**
     * @param clienteNum the clienteNum to set
     */
    public void setClienteNum(long clienteNum) {
        this.clienteNum = clienteNum;
    }
    /**
     * @return the custNum
     */
    public long getCustNum() {
        return custNum;
    }
    /**
     * @param custNum the custNum to set
     */
    public void setCustNum(long custNum) {
        this.custNum = custNum;
    }
    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }
    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * @return the estatus
     */
    public String getEstatus() {
        return estatus;
    }
    /**
     * @param estatus the estatus to set
     */
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    /**
     * @return the reserva
     */
    public String getReserva() {
        return reserva;
    }
    /**
     * @param reserva the reserva to set
     */
    public void setReserva(String reserva) {
        this.reserva = reserva;
    }
    /**
     * @return the iva
     */
    public String getIva() {
        return iva;
    }
    /**
     * @param iva the iva to set
     */
    public void setIva(String iva) {
        this.iva = iva;
    }
    /**
     * @return the claveIva
     */
    public String getClaveIva() {
        return claveIva;
    }
    /**
     * @param claveIva the claveIva to set
     */
    public void setClaveIva(String claveIva) {
        this.claveIva = claveIva;
    }
    /**
     * @return the limiteCredito
     */
    public double getLimiteCredito() {
        return limiteCredito;
    }
    /**
     * @param limiteCredito the limiteCredito to set
     */
    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }
    /**
     * @return the creditoUtilizado
     */
    public double getCreditoUtilizado() {
        return creditoUtilizado;
    }
    /**
     * @param creditoUtilizado the creditoUtilizado to set
     */
    public void setCreditoUtilizado(double creditoUtilizado) {
        this.creditoUtilizado = creditoUtilizado;
    }
    /**
     * @return the tipoUsuario
     */
    public String getTipoUsuario() {
        return tipoUsuario;
    }
    /**
     * @param tipoUsuario the tipoUsuario to set
     */
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    /**
     * @return the observacion
     */
    public String getObservacion() {
        return observacion;
    }
    /**
     * @param observacion the observacion to set
     */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    /**
     * @return the conPrecio
     */
    public String getConPrecio() {
        return conPrecio;
    }
    /**
     * @param conPrecio the conPrecio to set
     */
    public void setConPrecio(String conPrecio) {
        this.conPrecio = conPrecio;
    }
    
    public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	/**
     * @return the altadir
     */
    public String getAltadir() {
        return altadir;
    }
    /**
     * @param altadir the altadir to set
     */
    public void setAltadir(String altadir) {
        this.altadir = altadir;
    }
    /**
     * @return the ultimaVis
     */
    public String getUltimaVis() {
        return ultimaVis;
    }
    /**
     * @param ultimaVis the ultimaVis to set
     */
    public void setUltimaVis(String ultimaVis) {
        this.ultimaVis = ultimaVis;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */

	public String getTipoUsuarioPed() {
		return tipoUsuarioPed;
	}

	public void setTipoUsuarioPed(String tipoUsuarioPed) {
		this.tipoUsuarioPed = tipoUsuarioPed;
	}

	public int getNivelAcceso() {
		return nivelAcceso;
	}

	public void setNivelAcceso(int nivelAcceso) {
		this.nivelAcceso = nivelAcceso;
	}

	@Override
	public String toString() {
		return "PyUsuario [usuarioNum=" + usuarioNum + ", clienteNum=" + clienteNum + ", custNum=" + custNum + ", usuario=" + usuario + ", password=" + password + ", nombre=" + nombre + ", email=" + email + ", estatus=" + estatus + ", reserva=" + reserva + ", iva=" + iva + ", claveIva=" + claveIva + ", limiteCredito=" + limiteCredito + ", creditoUtilizado=" + creditoUtilizado + ", tipoUsuario=" + tipoUsuario + ", observacion=" + observacion + ", conPrecio=" + conPrecio + ", altadir=" + altadir + ", ultimaVis=" + ultimaVis + ", tipoUsuarioPed=" + tipoUsuarioPed + ", nivelAcceso=" + nivelAcceso + ", identificador=" + identificador + ", listaModulos=" + listaModulos + ", listaCorreos=" + listaCorreos + "]";
	}

	public List<ModulosUsuario> getListaModulos() {
		return listaModulos;
	}
	
	public void setListaModulos(List<ModulosUsuario> listaModulos) {
		this.listaModulos = listaModulos;
	}

	public List<CorreosUsuario> getListaCorreos() {
		return listaCorreos;
	}

	public void setListaCorreos(List<CorreosUsuario> listaCorreos) {
		this.listaCorreos = listaCorreos;
	}
	
	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getEjecutiva() {
		return ejecutiva;
	}


	public void setEjecutiva(String ejecutiva) {
		this.ejecutiva = ejecutiva;
	}


	public String getExt() {
		return ext;
	}


	public void setExt(String ext) {
		this.ext = ext;
	}


	public boolean isAfiliacion() {
		return afiliacion;
	}


	public void setAfiliacion(boolean afiliacion) {
		this.afiliacion = afiliacion;
	}


	public int getFavoritos() {
		return favoritos;
	}


	public void setFavoritos(int favoritos) {
		this.favoritos = favoritos;
	}


	public int getPartidas() {
		return partidas;
	}


	public void setPartidas(int partidas) {
		this.partidas = partidas;
	}	
}
