package com.sudhir.inheritance;

public class Inheritance {
	public static void main(String[] args) {
		new Inheritance().m1();
		System.out.println("dome");
	}
	public synchronized void  m1() {
		System.out.println("in M1");
	}
	public synchronized void  m2() {
		System.out.println("in M2");
		m1();
	}
}




class A{
	public void disp() {
		System.out.println("in A");
	}
}
class B extends A{
	public void disp() {
		System.out.println("in B");
	}
}
