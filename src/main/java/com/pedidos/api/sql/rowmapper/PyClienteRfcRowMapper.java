package com.pedidos.api.sql.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pedidos.api.comun.Cadena;
import com.pedidos.api.model.PyClienteRfc;



public class PyClienteRfcRowMapper implements RowMapper<PyClienteRfc>{
	@Override
    public PyClienteRfc mapRow(ResultSet rs, int rowNum) throws SQLException {
        
		PyClienteRfc pyclienteRfc = new PyClienteRfc();  
		pyclienteRfc.setRfcNum(rs.getLong("rfc_num"));
		pyclienteRfc.setClienteNum(rs.getLong("cliente_num"));
		pyclienteRfc.setNombre(Cadena.filtra(rs.getString("nombre")));
		pyclienteRfc.setAddress1(Cadena.filtra(rs.getString("address1")));
		pyclienteRfc.setAddress2(Cadena.filtra(rs.getString("address2")));
		pyclienteRfc.setColonia(Cadena.filtra(rs.getString("colonia")));
		pyclienteRfc.setCity(Cadena.filtra(rs.getString("city")));
		pyclienteRfc.setProvince(Cadena.filtra(rs.getString("province")));
		pyclienteRfc.setPostalCode(Cadena.filtra(rs.getString("postal_Code")));
		pyclienteRfc.setPhone(Cadena.filtra(rs.getString("phone")));
        pyclienteRfc.setContact(Cadena.filtra(rs.getString("contact")));
		pyclienteRfc.setmPago(Cadena.filtra(rs.getString("m_pago")));
		pyclienteRfc.setIdUsoCfdi(Cadena.filtra(rs.getString("id_uso_cfdi")));
		pyclienteRfc.setClienteRfc(Cadena.filtra(rs.getString("cliente_rfc")));
        
        return pyclienteRfc;
    }
}
