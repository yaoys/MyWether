package com.yys.bean;

public class County {
	private int id;
	private String countyName;
	private String countyCode;
	private int city_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return countyName;
	}

	public void setName(String countyName) {
		this.countyName = countyName;
	}

	public String getCode() {
		return countyCode;
	}

	public void setCode(String countyCode) {
		this.countyCode = countyCode;
	}

	public int getCityId() {
		return city_id;
	}

	public void setCityId(int cityId) {
		this.city_id = cityId;
	}
}
