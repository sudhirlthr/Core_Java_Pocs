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
			return;
		}
		finally {
			System.out.println("D");
		}
		System.out.println("E");

	}

}
