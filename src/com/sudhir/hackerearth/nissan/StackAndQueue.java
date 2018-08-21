/**
 * 
 */
package com.sudhir.hackerearth.nissan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author sudhir
 *
 */
public class StackAndQueue extends Thread{
	public static long min =Long.MIN_VALUE, array[];
	public static int k = 0,n=0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String input = br.readLine();
			n = Integer.parseInt(input.split("\\s+")[0]);
			k = Integer.parseInt(input.split("\\s+")[1]);
			BigDecimal sum = new BigDecimal("0");
			array = new long[n];
			array = Arrays.asList(br.readLine().split("\\s+")).stream().mapToLong(Long::parseLong).toArray();
			boolean flag = false;
			
			int index = n;
			for(int i=0;i<=k-1;i++) {
				long temp = array[i]>array[index-1]?array[i]:array[index-1];
				if(temp==array[index-1])
					index--;
				else
					flag = true;
				sum = sum.add(new BigDecimal(String.valueOf(temp)));
			}
			
			if(!flag) {
				min = array[n-k];
				for(int i=n-k;i<n-1;i++) {
					if(array[i]<min)
						min = array[i];
				}
				sum = sum.subtract(new BigDecimal(min)).add(new BigDecimal(array[0]));
			}
			System.out.println(sum);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		for(int i=n-k-1;i<n-1;i++) {
			if(array[i]<min)
				min = array[i];
		}
	}
}
