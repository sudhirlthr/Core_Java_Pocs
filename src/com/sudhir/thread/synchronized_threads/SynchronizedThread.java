package com.sudhir.thread.synchronized_threads;

public class SynchronizedThread {

	public static void main(String[] args) {
		Sender sender = new Sender();
		ThreadSend s1 = new ThreadSend("Sudhir ka msg", sender);
		ThreadSend s2 = new ThreadSend("Sudhir ka maal", sender);
		s1.start();
		s2.start();
		try {
			System.out.println(s1.getName());
			s1.join();
			s2.join();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
class Sender{
	public void send(String msg) {
		System.out.println("Started sending message = "+msg);
		try {
			Thread.sleep(200);
		}catch(Exception ex) {ex.printStackTrace();}
		System.out.println("Message sent");
	}
}
class ThreadSend extends Thread{
	private String msg;
	private Sender sender;
	public ThreadSend(String msg, Sender sender) {
		this.msg = msg;
		this.sender = sender;
	}
	public void run() {
		synchronized (this) {
			sender.send(msg);
		}
	}
	
}