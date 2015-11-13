package com.scorpio.demo.my;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.scorpio.demo.my.bean.ListSizeAfterRemoveVo;

public class ListSizeAfterRemove {
	private Random rd = new Random();
	
	public int randomCount() {
		return rd.nextInt(11);
	}
	
	public List<ListSizeAfterRemoveVo> initData(int startId, int endId, int step) {
		List<ListSizeAfterRemoveVo> vos = new ArrayList<ListSizeAfterRemoveVo>();
		for (int i = startId; i < endId; i = i + step) {
			ListSizeAfterRemoveVo vo = new ListSizeAfterRemoveVo();
			vo.setId(i);
			vo.setCalcCount(randomCount());
			vo.setInfoCount(randomCount());
			vos.add(vo);
		}
		return vos;
	}
	
	public List<ListSizeAfterRemoveVo> initData(List<ListSizeAfterRemoveVo> a1, List<ListSizeAfterRemoveVo> a2, List<ListSizeAfterRemoveVo> resultVos) {
		if (a1.size() != 0 && a2.size() != 0) {
			ListSizeAfterRemoveVo tmp1 = a1.get(0);
			ListSizeAfterRemoveVo tmp2 = a2.get(0);
			if (tmp1.getId() == tmp2.getId()) {
				ListSizeAfterRemoveVo result = new ListSizeAfterRemoveVo();
				result.setId(tmp1.getId());
				result.setCalcCount(tmp1.getCalcCount() + tmp2.getCalcCount());
				result.setInfoCount(tmp1.getInfoCount() + tmp2.getInfoCount());
				result.setSavedVoStr("a1和a2共同存的");
				resultVos.add(result);
				a1.remove(0);
				a2.remove(0);
				return initData(a1, a2, resultVos);
			} else {
				for (ListSizeAfterRemoveVo vo : a1) {
					if (vo.getId() == tmp2.getId()) {
						return dealA1(tmp1, a1, a2, resultVos);
					}
				}
				
				for (ListSizeAfterRemoveVo vo : a2) {
					if (vo.getId() == tmp1.getId()) {
						return dealA2(tmp2, a1, a2, resultVos);
					}
				}
				return dealA2(tmp2, a1, a2, resultVos);
			}
		} else if (a1.size() == 0 && a2.size() != 0) {
			ListSizeAfterRemoveVo tmp2 = a2.get(0);
			return dealA2(tmp2, a1, a2, resultVos);
		} else if (a2.size() == 0 && a1.size() != 0) {
			ListSizeAfterRemoveVo tmp1 = a1.get(0);
			return dealA1(tmp1, a1, a2, resultVos);
		} else {
			return resultVos;
		}
	}
	
	private List<ListSizeAfterRemoveVo> dealA1(ListSizeAfterRemoveVo tmp1, List<ListSizeAfterRemoveVo> a1, List<ListSizeAfterRemoveVo> a2, List<ListSizeAfterRemoveVo> resultVos) {
		ListSizeAfterRemoveVo result = new ListSizeAfterRemoveVo();
		result.setId(tmp1.getId());
		result.setCalcCount(tmp1.getCalcCount());
		result.setInfoCount(tmp1.getInfoCount());
		result.setSavedVoStr("a1存的");
		resultVos.add(result);
		a1.remove(0);
		return initData(a1, a2, resultVos);
	}
	
	private List<ListSizeAfterRemoveVo> dealA2(ListSizeAfterRemoveVo tmp2, List<ListSizeAfterRemoveVo> a1, List<ListSizeAfterRemoveVo> a2, List<ListSizeAfterRemoveVo> resultVos) {
		ListSizeAfterRemoveVo result = new ListSizeAfterRemoveVo();
		result.setId(tmp2.getId());
		result.setCalcCount(tmp2.getCalcCount());
		result.setInfoCount(tmp2.getInfoCount());
		result.setSavedVoStr("a2存的");
		resultVos.add(result);
		a2.remove(0);
		return initData(a1, a2, resultVos);
	}
	
	public static void main(String[] args) {
		ListSizeAfterRemove demo = new ListSizeAfterRemove();
		List<ListSizeAfterRemoveVo> a1 = demo.initData(5, 15, 1);
		List<ListSizeAfterRemoveVo> a2 = demo.initData(0, 15, 2);
		List<ListSizeAfterRemoveVo> resultVos = new ArrayList<ListSizeAfterRemoveVo>();
		resultVos = demo.initData(a1, a2, resultVos);
		for (ListSizeAfterRemoveVo vo : resultVos) {
			System.out.println("当前id为：" + vo.getId() + ";是" + vo.getSavedVoStr() + ";存入结果为:calcCount--" + vo.getCalcCount() + ";infoCount--" + vo.getInfoCount());
		}
	}
}
