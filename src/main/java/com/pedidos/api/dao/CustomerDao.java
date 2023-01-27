package com.pedidos.api.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.pedidos.api.comun.DAO;
import com.pedidos.api.model.Customer;

public interface CustomerDao extends DAO<Customer> {
	   /**
	    * Metodo que regresa una de lista de clientes que contengan la cadena custName
	    * @param custName cadena a buscar en el campo de razon social del cliente
	    * @return List lista de objetos del tipo Customer
	    */
	   public List<Customer> getByName(String custName) throws SQLException;
	   
	   /**
	    * Metodo que regresa si el numero de cliente es un cliente de credito 
	    * @param custNum es el numero de cliente
	    * @return un verdadero si es cliente de credito y un false si es cliente de contado
	    */
	   boolean isClienteCredito(long custNum) throws SQLException;
	   
	   
	   /**
	    * Metodo que regresa todos los clientes activos para registrarse en DCDI
	    * @return
	    * @throws SQLException
	    */
	   public List<Customer> getClientesActivosDCDI() throws SQLException;
	   
	   /**
	    * Metodo que genera contraseña aleatorea para clientes de DCDI
	    * @param sText
	    * @return
	    */
	   public String getPasswordDCDI(String sText);
	   
	   /**
	    * 
	    * @param custNum
	    * @return
	    */
	   public String getRFCDistribuidor(long custNum);
	   
	   
	   /**
	    * 
	    * @param custNum
	    * @return
	    */
	   public String getEmailCustomer(long custNum);
	   
	   
	   /**
	    * 
	    * @param custNum
	    * @return
	    */
	   public int eliminaCustomer(long custNum);
	   
	   
	   /**
	    * 
	    * @param custNum
	    * @return
	    */
	   public int eliminaCustomerInternet(long custNum);
	   
	   
	   /**
	    * Metodo para encriptar el numero de cliente y el tiempo de vida de la URL 
	    * @param custNum
	    * @return
	    */
	   public String getCustNumEncryptAESTime(long custNum);
	   
	   /**
	    * 
	    * @param custNum
	    * @param minute
	    * @return
	    */
	   public String getCustNumEncryptAESTime(long custNum,int minute);
	   
	   /**
	    * 
	    * @param cadena
	    * @return
	    */
	   public String getCustNumDecryptAESTime(String cadena);
	   
	   /**
	    * 
	    * @param custNum
	    * @param fecha
	    * @return
	    */
	   public boolean getFechaValida(long custNum,String fecha);
	   /**
	    * 
	    * @param custNum
	    * @return
	    */
	   public String getNombreCliente(long custNum);
	   /**
	    * 
	    * @param custNum
	    * @return
	    */
	   public boolean esBloqueoHP(long custNum);
	   /**
	    * 
	    * @param custNum
	    * @return
	    */
	   public boolean esBloqueoTonerHP(long custNum);
	   /**
	    * 
	    * @param customer
	    * @return
	    */
	   public Customer getCustomerXClienteNum(Customer customer);
	   
	   public Customer getDateCreated(Customer customer);
	   
	   public String getSlmnNum(long custNum);

	   public Customer getDireccion(long custNum);
	   
	   public boolean updateDatosFact(Customer customer);
	   
	   public List<Map<String, String>> getCollectorCustomer(long custNum)throws SQLException;

	   public String getGpoCliente(long custNum);
	   
	/**Obtener email del cliente*/
	   
	   public String getEmailCliente(long clienteNum);

	   String getRazonSocial(long custNum);
	   
	   public int updateToken(long custNum, String token);
	   
	   public String getDatosCliente(String token);
	   
	}
