/**
 * 
 */
package com.sudhir.appostack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/**
 * @author sudhir
 *
 */
public class AppoStack2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)) ;
		String str = reader.readLine();
		BigDecimal n = new BigDecimal(str.split("\\s+")[0]);
		int k = Integer.parseInt(str.split("\\s+")[1]);
		String seating = reader.readLine();
		int q = Integer.parseInt(reader.readLine());
		
	}

}
