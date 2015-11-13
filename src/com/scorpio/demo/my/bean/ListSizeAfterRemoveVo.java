package com.scorpio.demo.my.bean;

public class ListSizeAfterRemoveVo {
	private int id;
	
	private String savedVoStr;// 当前对象的数据是由哪个对象存入的（一共有三种状态：1、两个共同存的；2、A1存的；3、A2存的）
	
	private int calcCount;
	
	private int infoCount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCalcCount() {
		return calcCount;
	}

	public String getSavedVoStr() {
		return savedVoStr;
	}

	public void setSavedVoStr(String savedVoStr) {
		this.savedVoStr = savedVoStr;
	}

	public void setCalcCount(int calcCount) {
		this.calcCount = calcCount;
	}

	public int getInfoCount() {
		return infoCount;
	}

	public void setInfoCount(int infoCount) {
		this.infoCount = infoCount;
	}
	
	
}
