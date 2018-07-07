/**
 * 
 */
package com.sudhir.dac;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author sudhir
 *
 */
public class FindMaxMinUsingRecursion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer array[] = {10,20,30,9,15,27,42,31,55};
		System.out.println(getMax(array, 0, array.length));
		
		System.out.println(findMaxUsingCollectionInArray(array));
		System.out.println(findMinUsingCollectionInArray(array));
	}
	public static int getMax(Integer[] arr, int  i, int j) {
		int max1 = 0,max2=0;
		if(i==j) return max1 = arr[i];
		else if(i == j-1) {
			if(arr[i] > arr[j-1]) max1 = arr[i];
			else max1 = arr[j-1];
		}
		else {
			int mid = (i+j)/2;
			max1 = getMax(arr, i, mid);
			max2 = getMax(arr,mid+1,j);
		}
		return max1>max2? max1:max2;
	}
	
	public static int findMaxUsingCollectionInArray(Integer[] array) {
		if(array.length == 0) return -1;
		else 
			return Collections.max(Arrays.asList(array));
	}
	public static int findMinUsingCollectionInArray(Integer[] array) {
		return Collections.min(Arrays.asList(array));
	}
}
