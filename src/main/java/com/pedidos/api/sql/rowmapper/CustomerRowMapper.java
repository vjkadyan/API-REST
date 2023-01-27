package com.pedidos.api.sql.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pedidos.api.comun.Cadena;
import com.pedidos.api.model.Customer;

public class CustomerRowMapper implements RowMapper<Customer>{
	
	
	@Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
         
            Customer customer = new Customer();
            customer.setCustNum(rs.getInt("cust_num"));
            customer.setCustName(Cadena.filtra(rs.getString("cust_name")));
            customer.setEmailRed(Cadena.filtra(rs.getString("email_red")));
            customer.setStat(rs.getString("stat"));
            
            customer.setSortName(Cadena.filtra(rs.getString("sort_name")));
            
            customer.setLicence1(Cadena.filtra(rs.getString("licence1")));
            customer.setLicence2(Cadena.filtra(rs.getString("licence2")));
            customer.setAddress1(Cadena.filtra(rs.getString("address1")));
            customer.setAddress2(Cadena.filtra(rs.getString("address2")));
            customer.setCity(Cadena.filtra(rs.getString("city")));
            customer.setProvince(Cadena.filtra(rs.getString("province")));
            customer.setCountry(Cadena.filtra(rs.getString("country")));
            customer.setPostalCode(Cadena.filtra(rs.getString("postal_code")));
            customer.setPhone(Cadena.filtra(rs.getString("phone")));
            customer.setDuns(Cadena.filtra(rs.getString("duns")));
            customer.setCreditLimit(rs.getDouble("credit_limit"));
            
            customer.setArOwing(rs.getDouble("ar_owing"));
            customer.setArCurrent(rs.getDouble("ar_current"));
            customer.setAr30Days(rs.getDouble("ar_30_days"));
            customer.setAr60Days(rs.getDouble("ar_60_days"));
            customer.setAr90Days(rs.getDouble("ar_90_days"));
            customer.setAr120Days(rs.getDouble("ar_120_days"));
            
            
            customer.setTermCode(Cadena.filtra(rs.getString("term_code")));
            customer.setDigitov(Cadena.filtra(rs.getString("digitov")));
            
            return customer;
    }

}
