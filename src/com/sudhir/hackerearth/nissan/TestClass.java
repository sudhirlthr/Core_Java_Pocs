/**
 * 
 */
package com.sudhir.hackerearth.nissan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author sudhir
 *
 */
public class TestClass extends Thread{
	public static List<BigInteger> element_list = new ArrayList<>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());
			
			BigInteger sum = new BigInteger("0");
			StringTokenizer token = new StringTokenizer(br.readLine());
			while(token.hasMoreTokens()) {
				BigInteger current_element = new BigInteger(token.nextToken());
				sum = sum.add(current_element);
				element_list.add(current_element);
			}
			TestClass test  = new TestClass();
			test.start();
			int q = Integer.parseInt(br.readLine());
			while(q-->0) {
				boolean flag = true;
				BigInteger temp_sum = sum;
				BigInteger k = new BigInteger(br.readLine());
				//test.join();
				for(int i=n;i>=1;i--) {
					if(temp_sum.divide(new BigInteger(String.valueOf(i))).compareTo(k)<0) {
						System.out.println(i);
						flag = false;
						break;
					}
					else
						temp_sum = temp_sum.subtract(element_list.get(i-1));
				}
				if(flag)
					System.out.println("0");
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void run() {
		Collections.sort(element_list);
	}
}
