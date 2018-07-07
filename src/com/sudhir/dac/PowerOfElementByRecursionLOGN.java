/**
 * 
 */
package com.sudhir.dac;

/**
 * @author sudhir
 *
 */
public class PowerOfElementByRecursionLOGN {

	/**
	 * @param args
	 */
	static int b=0, c=0;
	public static void main(String[] args) {
		int value = 3, power = 4;
		if(power%2==0)
			System.out.println(findPower(value, power));
		else
			System.out.println(findPower(value, power)*value);
	}
	public static int findPower(int val, int exp) {
		if(exp == 1) return val;
		else {
			int mid = exp/2;
			b = findPower(val, mid);
			c = b*b;
			return c;
		}
	}
}
