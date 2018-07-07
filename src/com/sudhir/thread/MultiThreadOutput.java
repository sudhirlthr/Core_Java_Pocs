/**
 * 
 */
package com.sudhir.thread;

/**
 * @author sudhir
 *
 */
public class MultiThreadOutput extends Thread{

	/**
	 * @param args
	 */
	
	final StringBuffer sb = new StringBuffer();
	final StringBuffer sb2 = new StringBuffer();
	public static void main(String[] args) {
		MultiThreadOutput object = new MultiThreadOutput();
		new Thread() {
			public void run() {
				synchronized (this) {
					object.sb.append("Foo");
					object.sb2.append("Woo");
				}
			}
		}.start();
		
		new Thread() {
			public void run() {
				synchronized (this) {
					object.sb.append("Boo");
					object.sb2.append("Loo");
				}
			}
		}.start();
		System.out.println("SB = "+object.sb+"\nAnd SB2 = "+object.sb2);
	}

}
