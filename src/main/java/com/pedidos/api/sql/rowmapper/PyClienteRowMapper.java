package com.pedidos.api.sql.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pedidos.api.comun.Cadena;
import com.pedidos.api.model.PyCliente;

public class PyClienteRowMapper implements RowMapper<PyCliente> {

    @Override
    public PyCliente mapRow(ResultSet rs, int rowNum) throws SQLException {
     
        PyCliente pyCliente = new PyCliente();
        
        pyCliente.setClienteNum(rs.getLong("cliente_num"));
        pyCliente.setCustNum(rs.getLong("cust_num"));
        pyCliente.setNombre(Cadena.filtra(rs.getString("nombre")));
        pyCliente.setAddress1(Cadena.filtra(rs.getString("address1")));
        pyCliente.setAddress2(Cadena.filtra(rs.getString("address2")));
        pyCliente.setColonia(Cadena.filtra(rs.getString("colonia")));
        pyCliente.setCity(Cadena.filtra(rs.getString("city")));
        pyCliente.setProvince(Cadena.filtra(rs.getString("province")));
        pyCliente.setCountry(Cadena.filtra(rs.getString("country")));
        pyCliente.setPostalCode(Cadena.filtra(rs.getString("postal_code")));
        pyCliente.setPhone(Cadena.filtra(rs.getString("phone")));
        pyCliente.setFax(Cadena.filtra(rs.getString("fax")));
        pyCliente.setContact(Cadena.filtra(rs.getString("contact")));
        pyCliente.setPuesto(Cadena.filtra(rs.getString("puesto")));
        pyCliente.setEmail(Cadena.filtra(rs.getString("email")));
        pyCliente.setModoPorcentaje(Cadena.filtra(rs.getString("modo_porcentaje")));
        pyCliente.setEstatus(Cadena.filtra(rs.getString("estatus")));
        pyCliente.setInstrucCobro(Cadena.filtra(rs.getString("instruc_cobro")));
        pyCliente.setRemFact(Cadena.filtra(rs.getString("rem_fact")));
        pyCliente.setClienteRfc(Cadena.filtra(rs.getString("cliente_rfc")));
        pyCliente.setZona(Cadena.filtra(rs.getString("zona")));
        pyCliente.setDirecto(Cadena.filtra(rs.getString("directo")));
        pyCliente.setLaboratorio(Cadena.filtra(rs.getString("laboratorio")));
        pyCliente.setMargenLab(rs.getDouble("margen_lab"));
        pyCliente.setApartado(Cadena.filtra(rs.getString("apartado")));
        pyCliente.setClaveHorario(rs.getInt("clave_horario"));
        pyCliente.setPSupAlta(Cadena.filtra(rs.getString("p_sup_alta")));
        pyCliente.setCantUsuAlta(rs.getInt("cant_usu_alta"));
        pyCliente.setCostoEnvio(rs.getDouble("costo_envio"));
        pyCliente.setEnviosGratis(rs.getInt("envios_gratis"));
        pyCliente.setMontoEnvio(rs.getDouble("monto_envio"));
        pyCliente.setControlEnvios(rs.getInt("control_envios"));
        pyCliente.setTipoEntrega(Cadena.filtra(rs.getString("tipo_entrega")));
        pyCliente.setCredito(Cadena.filtra(rs.getString("credito")));
        pyCliente.setUltVisita(Cadena.filtra(rs.getString("ult_visita")));
        pyCliente.setCuentaSoho(Cadena.filtra(rs.getString("cuenta_soho")));
        pyCliente.setManejaCc(Cadena.filtra(rs.getString("maneja_cc")));
        pyCliente.setClasificacion(Cadena.filtra(rs.getString("clasificacion")));
        pyCliente.setClase(Cadena.filtra(rs.getString("clase")));
        pyCliente.setTipo(Cadena.filtra(rs.getString("tipo")));
        pyCliente.setRemision(Cadena.filtra(rs.getString("remision")));
        pyCliente.setValidadoCredito(Cadena.filtra(rs.getString("validado_credito")));
        
        
        return pyCliente;
    }

}
