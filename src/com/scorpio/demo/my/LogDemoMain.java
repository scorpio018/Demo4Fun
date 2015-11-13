package com.scorpio.demo.my;

import com.scorpio.demo.my.bean.DeptVo;
import com.scorpio.demo.my.bean.Uservo;

public class LogDemoMain {
	public static void main(String[] args) throws Exception {
		Uservo user = new Uservo();
		user.setName("yangyang");
		user.setValue("yy");
		
		DeptVo dept = new DeptVo();
		dept.setDeptId(0L);
		dept.setDeptName("北方网");
		
		UserController userController = new UserController();
		userController.saveUser(user);
		
		DeptController deptController = new DeptController();
		deptController.saveDept(dept);
	}
}
