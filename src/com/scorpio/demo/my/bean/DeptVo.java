package com.scorpio.demo.my.bean;

public class DeptVo extends LogVoImpl {

	private long deptId;

	private String deptName;

	public long getDeptId() {
		return deptId;
	}

	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String getStringForLog() {
//		String result = "deptId:" + deptId + ";deptName:" +deptName;
		String result = "修改部门：部门ID为【" + deptId + "】部门名称为【" +deptName + "】";
		
		return result;
	}

}
