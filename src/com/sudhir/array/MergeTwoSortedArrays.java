package com.sudhir.array;

import java.util.Arrays;

public class MergeTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]arr1 = {-1,1,3,5,7,9};
		int[]arr2 = {-2,2,3,4,5,6,10};
		System.out.println(Arrays.toString(print(arr1,arr2)));;
	}

	public static int[] print(int[]arr1, int[]arr2) {
		int[] res = new int[arr1.length+arr2.length];
		int index1=0,index2=0;
		for(int i=0;i<arr1.length+arr2.length;i++) {
			if(index2<arr2.length && index1<arr1.length && arr1[index1]<=arr2[index2])
				res[i] = arr1[index1++];
			else if(index2<arr2.length && index1<arr1.length && arr1[index1]>arr2[index2])
				res[i] = arr2[index2++];
			else if(index2 == arr2.length)
				res[i] = arr1[index1++];
			else if(index1 == arr1.length)
				res[i] = arr2[index2++];
			System.out.println("index1 = "+index1+" index2 = "+index2);
		}
		return res;
	}
}
