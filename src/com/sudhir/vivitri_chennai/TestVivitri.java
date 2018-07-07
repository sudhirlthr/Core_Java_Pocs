package com.sudhir.vivitri_chennai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class TestVivitri {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int array[] = new int[n];
		HashSet<?>[] arraySet = new HashSet<?>[n];
		int i=0;
		StringTokenizer token = new StringTokenizer(br.readLine());
		while(token.hasMoreTokens())
			array[i++] = Integer.parseInt(token.nextToken());
		
		List<Integer> list = new ArrayList<>();
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for(i=0;i<n;i++){
			int element = array[i];
			Set<Integer> set = new HashSet<>();
			while(element>0) {
				set.add(element%10);
				element /=10;
			}
			arraySet[i] = (HashSet<?>) set;
			map.put(array[i], set);
			System.out.println("hashset "+Arrays.toString(arraySet));
		}
		int count = 0;
		boolean flag = true;
		i=1;
		for(Map.Entry<Integer, Set<Integer>> itr:map.entrySet()) {
			int key = itr.getKey();
			HashSet<Integer> value = (HashSet<Integer>) itr.getValue();
			/*while(key>0 && flag) {
				int val = key %10;
				if(value.contains(val)) {
					count++;
					break;
				}
				key /=10;
			}*/
			HashSet<Integer> dup = (HashSet<Integer>) arraySet[i];
			System.out.println("value = "+value+ " and dup = "+dup);
			/*if(dup.retainAll(value)) {
				count++;
			}*/
			if(!Collections.disjoint(value, dup)) {
				count++;
				dup.retainAll(value);
			}
			System.out.println("vale set = "+value+ "and dup ="+dup );
		}
		System.out.println("count = "+count);
	}
}
