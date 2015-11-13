package com.scorpio.demo.my;

import com.scorpio.demo.my.bean.DeptVo;
import com.scorpio.demo.my.bean.LogVoImpl;
import com.scorpio.demo.my.bean.Uservo;

public class LogDemo<T extends LogVoImpl> {
	public void saveLog(T vo) {
		String result = vo.getStringForLog();
		System.out.println(result);
	}
	
}
