package com.yys.bean;

public class City {
	private int id;
	private String city_name;
	private String city_code;
	private int province_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return city_name;
	}

	public void setName(String cityName) {
		this.city_name = cityName;
	}

	public String getCode() {
		return city_code;
	}

	public void setCode(String cityCode) {
		this.city_code = cityCode;
	}

	public int getProvinceId() {
		return province_id;
	}

	public void setProvinceId(int provinceId) {
		this.province_id = provinceId;
	}
}
