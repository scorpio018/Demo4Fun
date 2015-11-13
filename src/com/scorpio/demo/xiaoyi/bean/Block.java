package com.scorpio.demo.xiaoyi.bean;

import java.util.ArrayList;
import java.util.List;

public class Block {
	private String step;
	
	private String curStep;
	
	private List<String> walkedSteps = new ArrayList<>();
	
	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public String getCurStep() {
		return curStep;
	}

	public void setCurStep(String curStep) {
		this.curStep = curStep;
	}

	public List<String> getWalkedSteps() {
		return walkedSteps;
	}

	public void setWalkedSteps(List<String> walkedSteps) {
		this.walkedSteps = walkedSteps;
	}

}
