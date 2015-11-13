package com.scorpio.demo.my;

import com.scorpio.demo.my.bean.DeptVo;

public class DeptController {
	private LogDemo<DeptVo> logDemo = new LogDemo<DeptVo>();
	
	public void saveDept(DeptVo dept) throws Exception {
		System.out.println("保存部门成功");
		logDemo.saveLog(dept);
	}
}
