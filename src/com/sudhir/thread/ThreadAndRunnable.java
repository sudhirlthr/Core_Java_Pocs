package com.sudhir.thread;

public class ThreadAndRunnable {
	public static void main(String[] args) {
		new MyThread().start();
		new MyThread(new RunnableDemo()).start();
	}
}
class MyThread extends Thread{
	public MyThread() {
		// TODO Auto-generated constructor stub
	}
	MyThread(Runnable runnable){
		super(runnable);
	}
	@Override
	public void run() {
		System.out.println("Under run method of MyThread class");
	}
}
class RunnableDemo implements Runnable{

	@Override
	public void run() {
		System.out.println("Under rnnable run method");
	}
	
}