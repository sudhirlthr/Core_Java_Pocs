package com.sudhir.main;

public class MaximizeSumAfterRotation {

	public static void main(String[] args) {
		int[] arr = {8,3,1,2};// get the array element
		System.out.println(new MaximizeSumAfterRotation().findMax(arr));
	}

	public int findMax(int[] arr) {
		int array_sum = 0, cur_max_sum = 0 , prev_max_sum = 0;
		
		
		for(int i=0;i<arr.length;i++) {
			array_sum += arr[i];//get sum value of array so that .
								// on each iteration we can get sum of others array value
								// by subtracting current value
			
			// we will get current maximum value, if this will be smaller with current element 
			// after rotation then we will keep value after reverse
			cur_max_sum += i*arr[i];
		}
		
		
		// Now get current max value as initial value so that we can compare with current evaluated value
		prev_max_sum = cur_max_sum;

		for(int i=1;i<arr.length;i++) {
			int temp_max_val = cur_max_sum-(array_sum-arr[i-1])+arr[i-1]*(arr.length-1);// arr.length -1 because we are keeping current value
																					// by assuming it last
			// update max value;
			cur_max_sum = temp_max_val;
			
			if(prev_max_sum<temp_max_val)
				prev_max_sum = temp_max_val;
			
		}
		return prev_max_sum;
	}
}
