package com.pedidos.api.sql;

public enum PickUpSQL {
	PALABRA,
	PYPICKUPENC,
	UPDATEPALABRA,
	UPDATEFECHAINGRESO,
	LOGIN,
	NUMEROS,
	PEDIDOS,
	DETALLEPEDIDO,
	CAJASPEDIDO,
	SKUCAJA,
	EXISTECODIGO,
	EXISTEESCANEO,
	ACTUALIZOESCANEO,
	ACTUALIZOESCANEOESTATUS,
	INSERTFIRMA,
	UPDATEESTATUS,
	INVENTARIO,
	EXISTEESCANEOINV,
	INGRESARESCANEO,
	ACTIVIDADES,
	IMAGENESACTIVIDADES,
	SUBIREVIDENCIA,
	FECHAS,
	CONSULTATRACKING,
	INSERTATRACKING,
	VALIDAPRODUCTOFICHA,
	CONSULTAPRODUCTOMSI, 
	INSERTAPRODUCTOSMSI,
	ELIMINAPRODUCTOMSI;
	
	public String toString() {
		switch (this) {		
			case PALABRA:
				return "select pedido_num ,CASE WHEN (select COUNT(palabra) from py_pickup_palabras where palabra = codigo) > 0 THEN codigo ELSE (select  top 1 palabra from py_pickup_palabras ORDER BY newid()) END palabra from py_pickup_enc where invoie_num = (select RTRIM(LTRIM(RTRIM(LTRIM(CONVERT(varchar,serial_code)))+''+RTRIM(LTRIM(SUBSTRING(?,LEN(?)-5,LEN(?)))))) from zseries where reference =(select SUBSTRING(?,0,LEN(?)-5)))";
			case PYPICKUPENC:
				return "select pedido_num,invoie_num,cliente_num,nombre,pvs,fecha_factura,fecha_insert,estatus,codigo,correo,(select factura_l from fn_factura_l(invoie_num)) factura,CONVERT(date,GETDATE()) f_env_corr from py_pickup_enc where pedido_num = ?";
			case UPDATEPALABRA:
				return "update py_pickup_enc set codigo =? where pedido_num = ?";
			case UPDATEFECHAINGRESO:
				return "update py_pickup_escaneo set fecha_ingreso = GETDATE() where pedido_num = ?";
			case LOGIN:
				return "select c.num_empleado, (e.nombre+' '+apellido_p+' '+apellido_m) as nombre,puesto from usuario_crmtv c, empleados e  where e.num_empleado = c.num_empleado and c.usuario = ? ";
			case NUMEROS:
				return "select (select COUNT(p.pedido_num) from py_pickup_enc p left join py_pickup_firma f on p.pedido_num=f.pedido_num where f.pedido_num is null) pickUp,(select COUNT(*) from (select distinct e.caja,e.pedido_num from py_pickup_escaneo e left join py_pickup_firma f on e.pedido_num=f.pedido_num left join py_pickup_inventario i on e.pedido_num=i.pedido_num and i.fecha = CONVERT(date,GETDATE()) where f.pedido_num is null and i.pedido_num is null) c) inventario,(select COUNT(a.id) from py_pickup_actividades a left join (select MIN(hora) hora,fecha,id from py_pickup_actividades_evidencia where fecha = CONVERT(date,GETDATE()) group by fecha,id) e on a.id=e.id where e.id is null) mantenimiento";
			case PEDIDOS:
				return "select p.pedido_num,p.invoie_num,p.cliente_num,p.nombre,p.pvs,fecha_factura,p.fecha_insert,(select factura_l from fn_factura_l(p.invoie_num)) factura from py_pickup_enc p left join py_pickup_firma f on p.pedido_num=f.pedido_num where f.pedido_num is null";
			case DETALLEPEDIDO:
				return "select p.pedido_num ,d.item_num ,SUM(d.cantidad) cantidad, SUM(d.precio) precio, d.titulo, p.pvs, p.estatus, p.codigo from py_pickup_enc p inner join py_pickup_det d on p.pedido_num=d.pedido_num where p.pedido_num = ? group by p.pedido_num,d.item_num,d.titulo,p.pvs,p.estatus,p.codigo;";
			case CAJASPEDIDO:
				return "select SUM(e.cantidad) piezas,e.caja,e.estatus estC,p.estatus estP,p.nombre,p.fecha_factura,p.pvs,e.order_num from py_pickup_escaneo e inner join py_pickup_enc p on e.pedido_num=p.pedido_num where e.pedido_num = ? group by e.caja,e.estatus,p.estatus,p.nombre,p.fecha_factura,p.pvs,e.order_num order by e.caja asc";
			case SKUCAJA:
				return "select e.item_num,isnull((select top 1 titulo from py_pickup_det where pedido_num= e.pedido_num and item_num = e.item_num),'') titulo_m,e.cantidad,isnull((select d.precio/d.cantidad from (select sum(cantidad) cantidad,sum(precio*cantidad) precio from py_pickup_det where pedido_num= e.pedido_num and item_num = e.item_num) d),0) precio_m from py_pickup_escaneo e where e.pedido_num = ? and e.caja = ? and e.order_num = ?";
			case EXISTECODIGO:
				return "select pedido_num from py_pickup_enc where codigo = ? and pedido_num= ?";
			case EXISTEESCANEO:
				return "select distinct estatus from py_pickup_escaneo where pedido_num = ? and order_num = ? and caja = ?\n";
			case ACTUALIZOESCANEO:
				return "update py_pickup_escaneo set estatus ='E' where pedido_num =? and order_num = ? and caja = ?";
			case ACTUALIZOESCANEOESTATUS:
				return "IF NOT EXISTS(SELECT pedido_num FROM py_pickup_escaneo WHERE pedido_num =? and estatus ='P') BEGIN update py_pickup_enc set estatus = 'E' where pedido_num = ? END ELSE BEGIN update py_pickup_enc set estatus = estatus where pedido_num = ? END";
			case INSERTFIRMA:
				return "insert py_pickup_firma (pedido_num,firma,fecha) values(?,?,GETDATE())";
			case UPDATEESTATUS:
				return "update py_pickup_enc set estatus=? where pedido_num =?";
			case INVENTARIO:
				return "select distinct e.cajas,e.caja,e.pedido_num,e.order_num,e.fecha_ingreso from py_pickup_escaneo e left join py_pickup_firma f on e.pedido_num=f.pedido_num left join py_pickup_inventario i on e.pedido_num=i.pedido_num and e.caja=i.caja and i.fecha = CONVERT(date,?) where f.pedido_num is null and i.pedido_num is null order by e.pedido_num,e.caja";
			case EXISTEESCANEOINV:
				return "select isnull(i.pedido_num,0) escaneado,e.pedido_num from py_pickup_escaneo e left join py_pickup_inventario i on e.pedido_num=i.pedido_num and e.caja=i.caja and i.fecha = CONVERT(date,GETDATE()) where e.order_num = ? and e.caja = ?";
			case INGRESARESCANEO:
				return "INSERT INTO py_pickup_inventario (pedido_num,caja,fecha,hora,num_empleado) VALUES (?,?,CONVERT(date,GETDATE()),CONVERT(time,GETDATE()),?)\n";
			case ACTIVIDADES:
				return "select a.id,a.actividad,a.hora_inicio,a.hora_fin,isnull(e.id,0) isRegis,case when e.hora <= DATEADD(minute,10,a.hora_fin) then 'A' else 'N' end estatus from py_pickup_actividades a left join (select MIN(hora) hora,fecha,id from py_pickup_actividades_evidencia where fecha = CONVERT(date,GETDATE()) group by fecha,id) e on a.id=e.id";
			case IMAGENESACTIVIDADES:
				return "select e.imagen,e.fecha,e.hora,a.actividad from py_pickup_actividades_evidencia e inner join py_pickup_actividades a on e.id =a.id where e.id = ? and e.fecha = convert(date,GETDATE())";
			case SUBIREVIDENCIA:
				return  "insert into py_pickup_actividades_evidencia (id,fecha,hora,imagen) values (?,GETDATE(),GETDATE(),?)";
			case FECHAS:
				return "select CONVERT(date,dia) ini,CONVERT(date,DATEADD(day,1,dia),100) fin from (select GETDATE() dia) f";
			case INSERTATRACKING:
				return "insert into py_pickup_firma values (? ,? , GETDATE())";
			case CONSULTATRACKING:
				return "select top 10 * from py_pickup_firma where pedido_num = ?";
			case VALIDAPRODUCTOFICHA:
				return "select * from py_ficha_tecnica WHERE item_num = ?";
			case CONSULTAPRODUCTOMSI:
				return "select * from py_productos_msi WHERE item_num = ?";
			case INSERTAPRODUCTOSMSI:
				return "insert into py_productos_msi values (?)";
			case ELIMINAPRODUCTOMSI:
				return "delete py_productos_msi WHERE item_num = ?";		
		}
		return null;
	}
}
