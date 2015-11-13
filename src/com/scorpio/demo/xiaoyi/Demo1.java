package com.scorpio.demo.xiaoyi;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.scorpio.demo.xiaoyi.bean.Block;

/**
 * 5*5的方格，从第一排第二个开始，每一个格只能走一次
 * @author yangyang
 *
 */
public class Demo1 {
	
	public static void main(String[] args) {
		Demo1 demo = new Demo1();
		demo.walk();
	}
	
	private int maxRow = 5;
	
	private int maxCol = 5;
	
	private String startStep = "1-3";
	
	private List<Block> rightSteps = new ArrayList<>();
	
	public void walk() {
		Block begin = new Block();
		begin.setCurStep(startStep);
		begin.setStep(startStep + ",");
		begin.getWalkedSteps().add(startStep);
		judgeIsRight(begin);
		if (rightSteps.size() != 0) {
			System.out.println("公布正确答案：");
			for (Block rightStep : rightSteps) {
				publishAnswer(rightStep);
			}
		} else {
			System.out.println("没有正确答案");
		}
	}
	
	private void judgeIsRight(Block step) {
		if (step != null) {
			String curStep = step.getCurStep();
			if (step.getWalkedSteps().size() == (maxRow * maxCol)) {
				rightSteps.add(step);
			}
			String[] split = curStep.split("-");
			// 获得当前步数的行
			int row = Integer.parseInt(split[0]);
			// 获得当前步数的列
			int col = Integer.parseInt(split[1]);
			// 上
			Block up = up(step, row, col);
			judgeIsRight(up);
			// 左
			Block left = left(step, row, col);
			judgeIsRight(left);
			// 下
			Block down = down(step, row, col);
			judgeIsRight(down);
			// 右
			Block right = right(step, row, col);
			judgeIsRight(right);
		}
	}
	
	private Block up(Block step, int row, int col) {
		if (row == 1) {
			return null;
		}
		String nowStep = (row - 1) + "-" + col;
		return checkStep(step, nowStep);
	}
	
	private Block down(Block step, int row, int col) {
		if (row == maxRow) {
			return null;
		}
		String nowStep = (row + 1) + "-" + col;
		return checkStep(step, nowStep);
	}
	
	private Block left(Block step, int row, int col) {
		if (col == 1) {
			return null;
		}
		String nowStep = row + "-" + (col - 1);
		return checkStep(step, nowStep);
	}
	
	private Block right(Block step, int row, int col) {
		if (col == maxCol) {
			return null;
		}
		String nowStep = row + "-" + (col + 1);
		return checkStep(step, nowStep);
	}
	
	private Block checkStep(Block step, String nowStep) {
		if (step.getWalkedSteps().contains(nowStep)) {
			return null;
		}
		Block newStep = new Block();
		String s = step.getStep();
		newStep.setStep(s + nowStep + ",");
		newStep.setCurStep(nowStep);
		List<String> walkedSteps = step.getWalkedSteps();
		List<String> tmp = new ArrayList<>();
		for (String string : walkedSteps) {
			tmp.add(string);
		}
		tmp.add(nowStep);
		newStep.setWalkedSteps(tmp);
		return newStep;
	}
	
	private void publishAnswer(Block step) {
		System.out.println("正确步骤：" + step.getStep().substring(0, step.getStep().length() - 1));
	}
	
}
