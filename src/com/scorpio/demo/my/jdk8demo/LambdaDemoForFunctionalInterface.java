package com.scorpio.demo.my.jdk8demo;

public class LambdaDemoForFunctionalInterface {
	public static void runThread() {
	    new Thread(new Runnable() {
	        public void run() {
	            System.out.println("Run!");
	        }
	    }).start();
	}
	
	public static void runThreadUseLambda() {
	    new Thread(() -> {
	        System.out.println("Run!");
	    }).start();
	}
	
	public static void main(String[] args) {
		LambdaDemoForFunctionalInterface.runThreadUseLambda();
	}
}
