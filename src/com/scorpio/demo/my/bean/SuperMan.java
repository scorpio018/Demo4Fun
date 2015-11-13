package com.scorpio.demo.my.bean;

import com.scorpio.demo.my.inter.ActionInterface;

public class SuperMan extends Person implements ActionInterface {
	private boolean BlueBriefs;

	public final void fly() {
		System.out.println("超人会飞耶～～");
	}

	public final boolean isBlueBriefs() {
		return BlueBriefs;
	}

	public void setBlueBriefs(boolean blueBriefs) {
		BlueBriefs = blueBriefs;
	}

	@Override
	public void walk(int m) {
		// TODO Auto-generated method stub
		System.out.println("超人会走耶～～走了" + m + "米就走不动了！");
	}
}
