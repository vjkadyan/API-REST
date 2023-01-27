package com.pedidos.api.model;

public class TestTv {

	private long cliente_num;
	private String test1;
	private String test2;
	private String test3;

	public TestTv() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestTv(int cliente_num, String test1, String test2, String test3) {
		super();
		this.cliente_num = cliente_num;
		this.test1 = test1;
		this.test2 = test2;
		this.test3 = test3;
	}

	public long getClienteNum() {
		return cliente_num;
	}

	public void setClienteNum(long cliente_num) {
		this.cliente_num = cliente_num;
	}

	public String getTest1() {
		return test1;
	}

	public void setTest1(String test1) {
		this.test1 = test1;
	}

	public String getTest2() {
		return test2;
	}

	public void setTest2(String test2) {
		this.test2 = test2;
	}

	public String getTest3() {
		return test3;
	}

	public void setTest3(String test3) {
		this.test3 = test3;
	}

	@Override
	public String toString() {
		return "TestTv [cliente_num=" + cliente_num + ", test1=" + test1 + ", test2=" + test2 + ", test3=" + test3 + "]";
	}

}