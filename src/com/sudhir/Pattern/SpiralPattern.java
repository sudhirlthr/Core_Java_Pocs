/**
 * 
 */
package com.sudhir.Pattern;

/**
 * @author sudhir
 *
 */
public class SpiralPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		printPattern(10);
	}

	public static void printPattern(int n) {
		int count = 0;
		for(int i=1;i<=n;i++) {
			if(i%2!=0) {
				int temp = count;
				for(int j=temp+1;j<=temp+i;j++) {
					System.out.print(j+" ");
					count++;
				}
			}
			else {
				for(int k=count+i; k>count;k--)
					System.out.print(k+" ");
				count =count+i;
			}
			System.out.println();
		}
	}
}
