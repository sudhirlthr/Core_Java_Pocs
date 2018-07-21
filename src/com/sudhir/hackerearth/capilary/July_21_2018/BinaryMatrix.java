/**
 * 
 */
package com.sudhir.hackerearth.capilary.July_21_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/**
 * @author sudhir
 *
 */
public class BinaryMatrix {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nm = br.readLine();
		int n = Integer.parseInt(nm.split("\\s+")[0]);
		int m = Integer.parseInt(nm.split("\\s+")[1]);
		String[] array = new String[n];
		for(int i=0;i<n;i++)
			array[i] = br.readLine();
		System.out.println(getIndex(array));
	}

	public static int getIndex(String[] array) {
		BigDecimal max = new BigDecimal(0);
		int index = 1;
		for(int i=0;i<array.length;i++){
			BigDecimal curr_max = getValue(array[i]);
			//System.out.println("decimal = "+curr_max);
			if(max.compareTo(curr_max)==-1) {
				max = curr_max;
				index = i+1;
			}
		}
		return index;
	}
	public static BigDecimal getValue(String binary) {
		String num = binary;
        //int dec_value = 0;
		BigDecimal dec_value = new BigDecimal(0);
		BigDecimal base = new BigDecimal(1);
        //int base = 1;
     
        int len = num.length();
        for (int i = len - 1; i >= 0; i--)
        {
            if (num.charAt(i) == '1')
                dec_value = dec_value.add(base);
            base = base.multiply(new BigDecimal(2));
        }
     
        return dec_value;
	}
}
