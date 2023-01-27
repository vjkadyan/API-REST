package com.pedidos.api.dao;

import com.pedidos.api.comun.DAO;
import com.pedidos.api.model.ResenaPedidos;

public interface ObtieneResenasDao extends DAO<ResenaPedidos>{
	public ResenaPedidos getByCliente(long clienteNum);
//	public int insertaResenaEjecutivo(PyLayoutEjecutiva ejecutivo);
//	public ResenaTransportista getUltimoEntregado(List<SaOrdH> invoices);
//	public PyPedidoHelp getByRowPyPedidoHelp(PyPedidoHelp entidad) throws SQLException;
//	public void insertaPyPedidoHelp(PyPedidoHelp entidad) throws SQLException;
//	public void actualizaPyPedidoHelp(PyPedidoHelp entidad) throws SQLException;
}