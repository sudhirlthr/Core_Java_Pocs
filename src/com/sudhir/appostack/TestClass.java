/**
 * 
 */
package com.sudhir.appostack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author sudhir
 *
 */
public class TestClass {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)) ;
		String str = reader.readLine();
		int n = Integer.parseInt(str.split("\\s+")[0]);
		int q = Integer.parseInt(str.split("\\s+")[1]);
		int[] array = Arrays.asList(reader.readLine().split("\\s+")).stream().mapToInt(Integer::parseInt).toArray();
		while(q-->0) {
			str = reader.readLine();
			int type = Integer.parseInt(str.split("\\s+")[0]);
			int index = Integer.parseInt(str.split("\\s+")[1]);
			int first=-1, second=-1;
			if(type == 0) {
				for(int i=index-1;i>=0;i--)
					if(array[i]==1) {
						first = i;
						break;
					}
				for(int i=index+1;i<array.length;i++)
					if(array[i]==1) {
						second = i;
						break;
					}
				System.out.println(first+" "+second);
			}
			else {
				if(array[index] == 0)
					array[index] = 1;
			}
		}
	}

}
