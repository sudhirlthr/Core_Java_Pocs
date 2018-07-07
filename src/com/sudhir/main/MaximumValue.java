package com.sudhir.main;
import java.util.Arrays;

public class MaximumValue {

	public static void main(String[] args) {
		int[] arr = {8,3,1,2};
		System.out.println(new MaximumValue().findMax(arr));
	}
	
	public int findMax(int[] arr) {
		int max = 0;
		Arrays.sort(arr); //sorting because if larger value of array will be 
						  // multiplied to larger index then we can get max element
		
		for(int i=0;i<arr.length;i++) {
			max += i*arr[i]; 
		}
		return max;
	}

}
