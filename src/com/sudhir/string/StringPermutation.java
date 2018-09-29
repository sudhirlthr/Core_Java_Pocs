package com.sudhir.string;

public class StringPermutation {

public static void main(String args[]){
		String s1 = "12345660897";
		String s2 = "54612389760";
		System.out.println(checkPermutation(s1, s2));
		if(checkPermutationWithSort(s1,s2))
			System.out.println("YES");
		else
			System.out.println("NO");
		System.out.println(checkPermutationWithCount(s1, s2));
	}

public static String checkPermutation(String s1, String s2){
		if(s1.length() != s2.length())
			return "No";
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		java.util.Arrays.sort(c1);
		java.util.Arrays.sort(c2);
		System.out.println("c1 = "+java.util.Arrays.toString(c1)+", c2 = "+java.util.Arrays.toString(c2));
		if(c1.equals(c2))
			return "YES";
		else
			return "NO";
	}
public static boolean checkPermutationWithSort(String s1, String s2){
	if(s1.length() != s2.length())
		return false;
	return sort(s1).equals(sort(s2));
}
public static String sort(String str){
	char[] arr = str.toCharArray();
	java.util.Arrays.sort(arr);
	System.out.println("In Short method, char array = "+java.util.Arrays.toString(arr));
	return new String(arr);
}
public static String checkPermutationWithCount(String s1, String s2){
		if(s1.length() != s2.length())
			return "NO";
		int[] arr = new int[256];
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		System.out.println(java.util.Arrays.toString(c1));
		System.out.println(java.util.Arrays.toString(c2));
		for(int i=0;i<c1.length;i++)
			arr[(int) c1[i]]++;

		for(int i=0;i<c2.length;i++){
			int temp = (int) c2[i];
			arr[temp]--;
			if(arr[temp]<0)
				return "NO";
		}
		return "YES";
	}
}
