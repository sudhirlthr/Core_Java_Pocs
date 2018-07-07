/**
 * 
 */
package com.sudhir.array;

import java.util.Arrays;

/**
 * @author sudhir
 *
 */
public class SmallestPeak {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {10,5,2,14,5,1,3,7};
		int[] result = getPeakElements(arr,3);
		System.out.println(Arrays.toString(result));
	}

	public static int[] getPeakElements(int[] arr,int k) {
		int[] result = new int[arr.length-2];
		int index = 0, max =0;
		for(int i=0;i<arr.length-2;i++) {
			max = 0;
			for(int j=i;j<i+k;j++) {
				if(max < arr[j])
					max = arr[j];
			}
			result[index++] = max;
		}
		return result;
	}
	
}
