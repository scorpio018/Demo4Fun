package com.scorpio.demo.my;

import com.scorpio.demo.my.bean.Uservo;

public class UserController {
	private LogDemo<Uservo> logDemo = new LogDemo<Uservo>();
	
	public void saveUser(Uservo user) throws Exception {
		System.out.println("保存用户成功");
		logDemo.saveLog(user);
	}
}
