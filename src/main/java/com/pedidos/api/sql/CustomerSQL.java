package com.pedidos.api.sql;

public enum CustomerSQL {
	INSERT,
	UPDATE,
	CONSULTA,
	CONSULTA_RFC,
	CONSULTA_CUSTNUM,
	CONSULTA_EMAILRED,
	UPDATE_INACTIVAR,
	UPDATE_DATOSFACT,
	ELIMINAR_CUSTOMER_INTERNET,
	OBTENER_NOMBRE,
	OBTENER_BLOQUEO_HP,
	OBTENER_BLOQUEO_TONER_HP,
	OBTENER_SLMN_NUM,
	OBTENER_COLLECTOR,
	OBTENER_EMAIL_CLIENTE,
	CONSULTA_FECHA_CREACION,
	UPDATETOKEN,
	GETDATOSCLIENTE,
	INSCLIENTECODIGO,
	GETCLIENTECODIGO,
	GETCODIGO,
	UPDATEESTATUSCODIGO;
		
		public String toString(){
			switch (this) {
			case INSERT:
				return "INSERT INTO CUSTOMER (cust_num,cust_name,address1,address2,city,province,country, postal_code, phone,telex,fax,duns, ar_contact,op_contact,receiver,receiv_tel,buyer_tel,standard_order,sort_name, sales_id,sa_cust,cust_group, ppd_coll, dunning_code,tax_region,terr_code,credit_hold,credit_limit,credit_days,last_cred_review,rating, edi, ar_method, stat_freq, interest,term_code,slmn_num,licence2,po_required,print_invoice,back_order,pps_price,promote_price,order_confirm,charge_to,whse_code,ship_via,price_level,priority,language,ar_memo,op_memo,bb_vendor,coop_code,coop_vendor,stat,date_created,ar_owing,open_order,ptd_sales,lyptd_sales,ytd_sales,lytd_sales,ly_sales,ptd_credit,lyptd_credit,ytd_credit,lytd_credit,ly_credit,ptd_cost,lyptd_cost, ytd_cost,lytd_cost,ly_cost,ytd_no_sales,ly_no_sales,ytd_no_returns,ly_no_returns,largest_bal,date_largest_bal,last_amt_pay,last_date_pay,last_inv_amt,inv_date_last,avg_days_pay,last_aging,ar_future,ar_current,ar_30_days,ar_60_days,ar_90_days,ar_120_days,shipped_pending,order_note,tel_charge,sa_output,licence1,tax_status,inv_by_grp,plan_ord_flag,garan_code,acepta_bo,contrasena,estatus_red,email_red,ptje_cancela,slmn_2,slmn_3,digitov,recibe_pub,c_num_ext,c_num_int,lada_tel,ext_tel1,ext_tel2,ext_fax,stat_fraude ) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			case UPDATE:
				return "UPDATE CUSTOMER SET cust_name = ?, address1 =?, address2=?, city=?, province=?,postal_code=?,phone=?,ar_contact=? WHERE cust_num = ? ";
			case CONSULTA:
				return "Select cust_num,cust_name,email_red,stat, UPPER(REPLACE(REPLACE(REPLACE(sort_name,' ',''),'*',''),'-','')) as sort_name,licence1,licence2,address1,nvl(address2,'') as address2,city,province,country,postal_code,phone,duns,credit_limit,ar_owing,ar_current,ar_30_days,ar_60_days,ar_90_days,ar_120_days,term_code,digitov From customer";
			case CONSULTA_RFC:
				return "Select sort_name From customer Where cust_num = ?";
			case CONSULTA_EMAILRED:
				return "SELECT email_red FROM customer WHERE cust_num = ?";
			case UPDATE_INACTIVAR:
				return " UPDATE customer SET stat = 'I' WHERE cust_num = ? ";
			case UPDATE_DATOSFACT:
				return " UPDATE customer SET address1=?, postal_code=?, city=?, province=?, phone=?  WHERE cust_num = ? ";
			case ELIMINAR_CUSTOMER_INTERNET:
				return " DELETE FROM customer WHERE cust_num = ? ";
			case OBTENER_NOMBRE:
				return "SELECT cust_name FROM customer WHERE cust_num=? ";	
			case OBTENER_BLOQUEO_HP:
				return "SELECT 'OK' FROM hp_no WHERE cust_num=? AND stat='A'";
			case OBTENER_BLOQUEO_TONER_HP:
				return "SELECT 'OK' FROM hp_item_no WHERE cust_num=? AND stat='A'";
			case OBTENER_SLMN_NUM:
				return "SELECT c.slmn_num as slmn_num,grupo_ventas FROM customer c inner join slmn s on c.slmn_num=s.slmn_num WHERE c.cust_num=?";
			case OBTENER_COLLECTOR:
				return "select e.coll_num collNum,b.coll_name collName from customer_2 e,collector b where e.cust_num=? and b.coll_num = e.coll_num ";
			case OBTENER_EMAIL_CLIENTE:
				return "select email_red from customer where cust_num  = (select distinct cust_num from py_cliente where cliente_num = ?)";
			case CONSULTA_CUSTNUM:
				return "select cust_name from customer where cust_num = ?";
			case CONSULTA_FECHA_CREACION:
				return "select cust_num,date_created from customer";
			case UPDATETOKEN:
				return "update customer set order_note = ? where cust_num = ? ;";
			case GETDATOSCLIENTE:
				return "select a.email, a.password from py_usuario a inner join customer b on a.cliente_num = b.cust_num where b.order_note = ?;";
			case INSCLIENTECODIGO:
				return "insert into py_cliente_codigo(cliente_num,isEmpresa,codigo,estatus,fecha,correo,contrasena,usuario) values(?,?,?,?,GETDATE(),?,?,?);";
			case GETCLIENTECODIGO:
				return "select cliente_num,isEmpresa,codigo,estatus,fecha,correo,contrasena,usuario from py_cliente_codigo	where correo=?";			
			case GETCODIGO:
				return "select cliente_num,isEmpresa,codigo,estatus,fecha,correo,contrasena,usuario from py_cliente_codigo where codigo= ?";
			case UPDATEESTATUSCODIGO:
				return "update py_cliente_codigo set estatus = 'A' where codigo=?;";
			}
			return "";
		}

	}