package com.sudhir.paytm;

public class GCD {

	public static void main(String[] args) {
		System.out.println(findGCD(48,60));
	}

	
	public static int findGCD(int a,int b) {
		if(a == 0 || b == 0 || a==b) return a;
		
		if(a>b)
			return findGCD(a-b, b);
		return findGCD(a, b-a);
	}
}
