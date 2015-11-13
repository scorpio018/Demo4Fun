package com.scorpio.demo.my.bean;

public class Uservo extends LogVoImpl {
	
	private String name;
	
	private String value;
	
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getValue() {
		return value;
	}



	public void setValue(String value) {
		this.value = value;
	}



	@Override
	public String getStringForLog() {
		String result = "name:" + name + ";value=" + value;
		return result;
	}

}
