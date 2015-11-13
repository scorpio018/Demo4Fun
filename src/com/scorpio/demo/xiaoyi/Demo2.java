package com.scorpio.demo.xiaoyi;
/**
 * 被2除余1，被3除余1，被4除余1，被5除余1，被6除余1，被7整除的数
 * @author Administrator
 *
 */
public class Demo2 {
	
	public static void main(String[] args) {
		Demo2 demo = new Demo2();
		int num = demo.getNum();
		System.out.println("能被2除余1，被3除余1，被4除余1，被5除余1，被6除余1，被7整除的数为：" + num);
	}
	
	public int getNum() {
		int i = 1;
		int finalNum = 0;
		while (true) {
			int tmp = i++ * 7;
			if (tmp % 2 != 1) {
				System.out.println("【" + tmp + "被2整除不余1");
				continue;
			}
			if (tmp % 3 != 1) {
				System.out.println("【" + tmp + "被3整除不余1");
				continue;
			}
			if (tmp % 4 != 1) {
				System.out.println("【" + tmp + "被4整除不余1");
				continue;
			}
			if (tmp % 5 != 1) {
				System.out.println("【" + tmp + "被5整除不余1");
				continue;
			}
			if (tmp % 6 != 1) {
				System.out.println("【" + tmp + "被6整除不余1");
				continue;
			}
			finalNum = tmp;
			break;
		}
		return finalNum;
	}
	
}
