/**
 * 
 */
package com.sudhir.exception;

/**
 * @author sudhir
 *
 */
public class TryCatchFinally {

	public static void throwit() {
		System.out.println("A");
		throw new RuntimeException();
	}
	
	public static void main(String[] args) {
		try {
			System.out.println("B");
			throwit();
		}catch(Exception e) {
			System.out.println("C");
		}
		finally {
			System.out.println("D");
			System.exit(0);
		}
		System.out.println("E");

	}

}
