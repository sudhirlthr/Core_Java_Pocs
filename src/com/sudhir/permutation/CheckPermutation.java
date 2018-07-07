package com.sudhir.permutation;

import java.util.Arrays;

public class CheckPermutation {

	public static void main(String[] args) {
		System.out.println(sort("Ccc").equals(sort("cCc")));
	}
	
	public static String sort(String str) {
		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}
}
