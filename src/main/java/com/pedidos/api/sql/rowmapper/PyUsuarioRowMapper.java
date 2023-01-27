package com.pedidos.api.sql.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pedidos.api.comun.Cadena;
import com.pedidos.api.model.PyUsuario;

public class PyUsuarioRowMapper implements RowMapper<PyUsuario>{

    @Override
    public PyUsuario mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        PyUsuario pyUsuario = new PyUsuario();
        
        pyUsuario.setUsuarioNum(rs.getLong("usuario_num"));
        pyUsuario.setClienteNum(rs.getLong("cliente_num"));
        pyUsuario.setCustNum(rs.getLong("cust_num"));
        
        pyUsuario.setUsuario(Cadena.filtra(rs.getString("usuario")));
        pyUsuario.setPassword(Cadena.filtra(rs.getString("password")));
        pyUsuario.setNombre(Cadena.filtra(rs.getString("nombre")));
        
        pyUsuario.setEmail(Cadena.filtra(rs.getString("email")));
        pyUsuario.setEstatus(Cadena.filtra(rs.getString("estatus")));
        pyUsuario.setReserva(Cadena.filtra(rs.getString("reserva")));
        pyUsuario.setTipoUsuario(Cadena.filtra(rs.getString("tipo_usuario")));
        pyUsuario.setConPrecio(Cadena.filtra(rs.getString("con_precio")));
        
        /*
        
        pyUsuario.setIva(Cadena.filtra(rs.getString("iva")));
        pyUsuario.setClaveIva(Cadena.filtra(rs.getString("clave_iva")));
        pyUsuario.setLimiteCredito(rs.getDouble("limite_credito"));
        pyUsuario.setCreditoUtilizado(rs.getDouble("credito_utilizado"));
        pyUsuario.setTipoUsuario(Cadena.filtra(rs.getString("tipo_usuario")));
        pyUsuario.setObservacion(Cadena.filtra(rs.getString("observacion")));
        
        pyUsuario.setAltadir(Cadena.filtra(rs.getString("altadir")));
        pyUsuario.setUltimaVis(Cadena.filtra(rs.getString("ultima_vis")));
        */
        return pyUsuario;
    }

}
