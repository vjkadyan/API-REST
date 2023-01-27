package com.pedidos.api.sql.rowmapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.pedidos.api.comun.Cadena;
import com.pedidos.api.model.PyPedidoEnc;
/**
 * Definicion de la clase de PyPedidoEncRowMapper
 * @see <a href = "http://www.dcm.com" />Ver Pagina</a>
 */
public class PyPedidoEncRowMapper implements RowMapper<PyPedidoEnc>{
	private static final Logger LOG = Logger.getLogger(PyPedidoEncRowMapper.class);

    @Override
    public PyPedidoEnc mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        PyPedidoEnc pyPedidoEnc = new PyPedidoEnc();
        pyPedidoEnc.setOrgCode(Cadena.filtra(rs.getString("org_code")));
        pyPedidoEnc.setDivCode(Cadena.filtra(rs.getString("div_code")));
        pyPedidoEnc.setPedidoNum(rs.getLong("pedido_Num"));
        pyPedidoEnc.setCustNum(rs.getLong("cust_Num"));
        pyPedidoEnc.setClienteNum(rs.getLong("cliente_Num"));
        pyPedidoEnc.setDirNum(rs.getInt("dir_Num"));
        pyPedidoEnc.setFecha(Cadena.filtra(rs.getString("fecha")));
        pyPedidoEnc.setIdSuperpedido(rs.getLong("id_Superpedido"));
        pyPedidoEnc.setUsuario(rs.getLong("usuario"));
        pyPedidoEnc.setCentroCosto(Cadena.filtra(rs.getString("centro_Costo")));
        pyPedidoEnc.setOrdenCompra(Cadena.filtra(rs.getString("orden_Compra")));
        pyPedidoEnc.setObservaciones(Cadena.filtra(rs.getString("observaciones")));
        pyPedidoEnc.setEstatus(Cadena.filtra(rs.getString("estatus")));
        pyPedidoEnc.setEstEnvio(Cadena.filtra(rs.getString("est_Envio")));
        pyPedidoEnc.setImporte(rs.getDouble("importe"));
        pyPedidoEnc.setIva(rs.getDouble("iva"));
        pyPedidoEnc.setTipoEntrega(Cadena.filtra(rs.getString("tipo_Entrega")));
        pyPedidoEnc.setEvento(rs.getLong("evento"));
        pyPedidoEnc.setOrigen(Cadena.filtra(rs.getString("origen")));
        pyPedidoEnc.setRemFact(Cadena.filtra(rs.getString("rem_fact")));
        pyPedidoEnc.setShipVia(Cadena.filtra(rs.getString("ship_via")));
        pyPedidoEnc.setShipNum(rs.getInt("ship_Num"));
        
        
        return pyPedidoEnc;
    }

}
