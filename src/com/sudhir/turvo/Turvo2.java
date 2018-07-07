package com.sudhir.turvo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Turvo2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		long n = Long.parseLong(input.split("\\s+")[0]);
		long x = Long.parseLong(input.split("\\s+")[1]);
		int index = 0, cost = 0;
		long[] array = new long[(int) n];
		StringTokenizer token = new StringTokenizer(br.readLine());
		while(token.hasMoreTokens()) {
			array[index++] = Long.parseLong(token.nextToken());
		}
		//index = n-1;
		cost += array[0]*x+array[(int) (n-1)]*x;
		for(int i=(int) (n-5);i>=1;i=i-4) {
			cost += array[i]*x;
		}
		System.out.println(cost);
	}
}
