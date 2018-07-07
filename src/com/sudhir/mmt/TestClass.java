package com.sudhir.mmt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TestClass {

	public static void main(String[] args) {
		try {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String input = br.readLine();
			int n = Integer.parseInt(input.split("\\s+")[0]);
			int q = Integer.parseInt(input.split("\\s+")[1]);
			int []arr = new int[n];
			Arrays.fill(arr, 0);
			for(int i=0;i<q;i++){
				input = br.readLine();
				int type = 0,index = 0;
				type= Integer.parseInt(input.split("\\s+")[0]);
				index = Integer.parseInt(input.split("\\s+")[1])-1;
				if(type == 1) {
					arr[index] = (arr[index]*2)+1;
				}
				else if(type == 2) {
					arr[index] = arr[index]/2;
				}
				else if(type == 3) {
					int y = Integer.parseInt(input.split("\\s+")[2])-1;
					StringBuilder str = new StringBuilder("");
					for(int j=index;j<=y;j++) {
						str.append(Integer.toBinaryString(arr[j]));
					}
					int count = 0;
					for(int j=0;j<str.length();j++)
						if(str.charAt(j) == '1')
							count++;
					
					System.out.println(count);
				}
			}
		} catch (IOException e) {	
			e.printStackTrace();
		} 

	}

}
