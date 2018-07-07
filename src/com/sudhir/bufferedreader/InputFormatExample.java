/**
 * 
 */
package com.sudhir.bufferedreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author sudhir
 *
 */
public class InputFormatExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine().trim());
		int[] array = new int[n];
		for(int i=0;i<n;i++)
			array[i] = Integer.parseInt(reader.readLine().trim());
		Arrays.sort(array);
		int count = 0;
		boolean flag = true;
		for(int i=0;i<n-1;i++) {
			if(array[i] == array[i+1] && flag == true) {
				count++;
				flag = false;
			}
			else if(array[i] != array[i+1])
				flag = true;
		}
		System.out.println(count);
	}

}
