package com.pedidos.api.comun;


import java.sql.SQLException;
import java.util.List;

public interface DAO<E> {
    
    /**
     * Metodo  para insertar un registro en la base de datos
     * @param entidad es un Objecto que se defina en la implementacion
     */
    void insertRow(E entidad) throws SQLException;
    /**
     * Metodo para borrar un registro en la base de datos
     * @param entidad es un Objecto que se defina en la implementacion
     * @return Long
     */
    int deleteRow(E entidad) throws SQLException;
    /**
     * Metodo para actualizar un registro en la base de datos
     * @param entidad es un Objecto que se defina en la implementacion
     */
    int updateRow(E entidad) throws SQLException;
    /**
     * Metodo para regresar un registro en la base de datos
     * @param entidad es un Objecto que se defina en la implementacion
     * @return Entidad
     */
    E getByIdRow(E entidad) throws SQLException;
    /**
     * Metodo para contar el numero de registros en la base de datos
     * @return Integer 
     */
    Integer countRow() throws SQLException;
    
    /**
     * Metodo que regresa todo los registros de la base de datos
     * @return List regresa una lista de Objetos del tipo definido 
     */
    List<E> getAllRow() throws SQLException;
}