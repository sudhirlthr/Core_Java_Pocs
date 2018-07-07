package com.sudhir.thread.synchronized_runnable;

public class SynchronizedRunnableEample {
	public static void main(String[] args) {
		Sender sender = new Sender();
		RunnableImpl obj1 = new RunnableImpl("Sudhir", sender);
		RunnableImpl obj2 = new RunnableImpl("Kumar", sender);
		Thread t1 = new Thread(obj1);
		Thread t2 = new Thread(obj2);
		t1.start();
		t2.start();
		try {
			System.out.println("thread coint in main = "+Thread.activeCount());
			/*t1.join();
			t2.join();*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

class Sender{
	public void send(String msg) {
		System.out.println("Started sending msg = "+msg);
		synchronized (this) {
			try {
				System.out.println("sending...");
				System.out.println("thread coint = "+Thread.activeCount());
				Thread.sleep(2500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Msg sent");
	}
}
class RunnableImpl implements Runnable{
	private String str;
	private Sender sender;
	
	
	public RunnableImpl(String str, Sender sender) {
		this.str = str;
		this.sender = sender;
	}


	@Override
	public void run() {
		sender.send(str);
	}
	
}