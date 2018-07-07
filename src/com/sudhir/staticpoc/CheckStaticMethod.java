package com.sudhir.staticpoc;

public class CheckStaticMethod {

	public static void disp() {
		System.out.println("Hello from disp method");
	}
	
	public static void main(String[] args) {
		CheckStaticMethod obj = null;
		obj.disp();
	}
}
