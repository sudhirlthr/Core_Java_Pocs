package com.sudhir.array;

import java.util.Arrays;

public class UniqueElements {

	public static void main(String[] args) {
		String str = "GeeksforGeeks";
		System.out.println(checkDuplicates(str));
		System.out.println(checkMoreThanDuplicates(str));
		System.out.println(CheckUniqueElements(str));
	}

	public static boolean checkDuplicates(String str) {
		// With time complexity O(n^2)
		char[] char_arr = str.toCharArray();
		for(int i=0;i<char_arr.length;i++) {
			for(int j=i+1;j<char_arr.length;j++)
				if(char_arr[i]==char_arr[j]) {
					System.out.println("Duplicate elements inside String");
					return true;
				}
		}
		return false;
	}
	public static boolean checkMoreThanDuplicates(String str) {
		// With time complexity O(nLogn)
		char[] char_arr = str.toCharArray();
		Arrays.sort(char_arr);
		for(int i=0;i<char_arr.length-1;i++)
			if(char_arr[i]==char_arr[i+1])
				return true;
		
		return false;
	}
	public static boolean CheckUniqueElements(String str) {
		// With time complexity O(n)
		int max_length = 256;// because ASCII char supports 8 bit, so 2^8 = 256
		boolean[] index = new boolean[max_length];
		Arrays.fill(index, false);
		for(int i=0;i<str.length();i++) {
			int arr_index = str.charAt(i);
			System.out.println("index = "+arr_index);
			if(index[arr_index]==true) {
				System.out.println("contains duplicate elements at index = "+arr_index);
				return true;
			}
			index[arr_index] = true;
		}
		return false;
	}
}
