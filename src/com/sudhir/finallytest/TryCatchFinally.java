package com.sudhir.finallytest;

public class TryCatchFinally {

	public static void main(String[] args) {
		System.out.println("main");
		System.out.println(devide(10, 0));
	}
	public static int devide(int a, int b){
		int c = -1;
		try {
			System.out.println("before devide");
			c = a/b;
			System.out.println("after devide");
		}catch(Exception exc) {
			System.out.println("Error");
		}finally {
			System.out.println("Finally");
			
		}
		System.out.println("returning 0");
		return 0;
	}
	
	static {
		
		System.out.println("IN Stattic block");
	}
	
	
}
