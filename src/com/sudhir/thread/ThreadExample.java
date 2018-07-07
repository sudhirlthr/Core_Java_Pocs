package com.sudhir.thread;

public class ThreadExample extends Thread{
	static Abc a1;
	static Abc a2;
	public static void main(String[] args) {
		a1 = new Abc();
		a2 = new Abc();
		ThreadExample th1 = new ThreadExample();
		ThreadExample th2 = new ThreadExample();
		th1.start();
		th2.start();
	}

	
	@Override
	public void run() {
		a1.disp2();
		a2.disp();
		
		a1.disp();
		a2.disp2();
	}
}

class Abc{
	public synchronized static void disp(){
		System.out.println("in disp current thread = "+Thread.currentThread());
	}
	public synchronized void disp2(){
		System.out.println("in disp2 current thread = "+Thread.currentThread());
	}
}