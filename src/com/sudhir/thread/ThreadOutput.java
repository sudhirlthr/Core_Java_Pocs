/**
 * 
 */
package com.sudhir.thread;

/**
 * @author sudhir
 *
 */
public class ThreadOutput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread thread = new ThreaDemo() {
			public void run() {
				System.out.println("In declaration run method");
			}
		};
		thread.start();

	}

}
class ThreaDemo extends Thread{
	public ThreaDemo() {
		System.out.println("In ThreadDemo Construtor");
	}
	public void run() {
		System.out.println("In 0-args run method");
	}
	public void run(String str) {
		System.out.println("In String args run method");
	}
}
