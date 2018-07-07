package com.sudhir.paytm;

import java.util.HashMap;
import java.util.Map;

public class Triplet {

	public static void main(String[] args) {
		int arr[] = {1, 4, 6, 2, 3, 8};
		int m = 24;
		long start = System.currentTimeMillis();
		System.out.println(countTriplet(arr,m));
		long end = System.currentTimeMillis();
		System.out.println("Time = "+(end-start)+"ms");
		
		start = System.currentTimeMillis();
		System.out.println(countTriplet2(arr,m));
		end = System.currentTimeMillis();
		System.out.println("Time = "+(end-start)+"ms");
	}

	public static int countTriplet(int[] arr,int m) {
		//TC = O(n^3)
		int count = 0;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				for(int k=j+1;k<arr.length;k++) {
					if(arr[i]*arr[j]*arr[k]==m)
						count++;
				}
			}
		}
		return count;
	}
	public static int countTriplet2(int arr[], int m) {
		//TC = O(n^3)
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<arr.length;i++)
			map.put(arr[i], i);
		
		int count = 0;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				int check = m/arr[i]*arr[j];
				if(map.containsKey(check) && check != arr[i] && check!=arr[j]) {
					count++;
				}
			}

		}
		return count;
	}
}
