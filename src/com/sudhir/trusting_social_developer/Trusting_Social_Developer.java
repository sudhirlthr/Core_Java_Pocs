package com.sudhir.trusting_social_developer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Trusting_Social_Developer {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int array[] = new int[n];
		SortedSet<Integer> list = new TreeSet<>(Collections.reverseOrder());
		for(int i=0;i<n;i++){
			String oprn = br.readLine();
			int type = Integer.parseInt(oprn.split("\\s+")[0]);
			int elements = -1;

			if(type == 1) {
				elements = Integer.parseInt(oprn.split("\\s+")[1]);
				list.add(elements);
			}
			else if(type == 2) {
				if(list.size()>=3) {
					List<Integer> copy_list = new ArrayList<>();
					copy_list.addAll(list);
					//Collections.reverse(copy_list);
					int length = copy_list.size();
					System.out.println(copy_list.get((length/3)-1));
				}
				else
					System.out.println("Not enough enemies");
			}
		}
	}

}
