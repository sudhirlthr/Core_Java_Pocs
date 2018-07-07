package com.sudhir.vivitri_chennai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class CommonDigit {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long array[] = new long[n];
		HashSet<?>[] arraySet = new HashSet<?>[n];
		int i=0;
		StringTokenizer token = new StringTokenizer(br.readLine());
		while(token.hasMoreTokens())
			array[i++] = Long.parseLong(token.nextToken());
		
		List<Integer> list = new ArrayList<>();
		for(i=0;i<n;i++){
			long element = array[i];
			Set<Long> set = new HashSet<>();
			while(element>0) {
				set.add(element%10);
				element /=10;
			}
			arraySet[i] = (HashSet<?>) set;
		}
		System.out.println("hashset "+Arrays.toString(arraySet));
		int count = 0, pre = 0;
		HashSet<Long> prev = (HashSet<Long>) arraySet[0];
		for(i=1;i<n;i++) {
			HashSet<Long> value = (HashSet<Long>) arraySet[i];
			if(prev.retainAll(value) || prev.equals(value))
				if(prev.size()>0)
					count++;
			else
				count =0;
			System.out.println("prev = "+prev);
			prev = (HashSet<Long>) arraySet[i];
			
			if(pre<count) {
				pre = count;				
			}
		}
		if(count>0)
			System.out.println("count = "+(pre+1));
		else
			System.out.println("1");
	}
}
