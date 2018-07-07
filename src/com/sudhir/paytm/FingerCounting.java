package com.sudhir.paytm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FingerCounting {

	public static void main(String[] args) throws NumberFormatException, IOException {
		CountNumbers();
	}
	public static void CountNumbers() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-->0) {
			int n = Integer.parseInt(br.readLine())%8;
            System.out.println(n<=5 ? (n==0 ? 2 : n) : 10 - n);
	
		}
	}
}
