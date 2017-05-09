package com.yys.bean;

public class Province {

	private int id;
	private String province_name;
	private String province_code;

	public String getName() {
		return province_name;
	}

	public void setName(String name) {
		this.province_name = name;
	}

	public String getCode() {
		return province_code;
	}

	public void setCode(String code) {
		this.province_code = code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
