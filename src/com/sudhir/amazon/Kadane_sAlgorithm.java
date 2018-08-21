package com.sudhir.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Kadane_sAlgorithm {

	public static void main(String[] args) {
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int test = Integer.parseInt(br.readLine());
			while (test-- > 0) {
				int n = Integer.parseInt(br.readLine()),i=0;
				Integer[] array = new Integer[n];
				StringTokenizer token = new StringTokenizer(br.readLine());
				while(token.hasMoreTokens())
					array[i++] = Integer.parseInt(token.nextToken());
				//int[] array = Arrays.asList(br.readLine().split("\\s+")).stream().mapToInt(Integer::parseInt).toArray();
				
				System.out.println(sumOfContigousSubArray(array));
				System.out.println(getSumOfContigousSubArray(array));
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static int sumOfContigousSubArray(Integer [] array) {
		int old,sum,i=0,total=0;
		Integer max_index = Arrays.asList(array).indexOf(Collections.max(Arrays.asList(array)));
		total = old=sum=Collections.max(Arrays.asList(array));
		
		for(i=max_index+1;i<array.length;i++) {
			total +=array[i];
			if(sum<array[i] && sum<0)
				sum = array[i];
			else if(sum+array[i]>sum)
				sum +=array[i];
			else if(old<=sum) {
				old = sum;
				sum = array[i];
			}
			else if(sum>array[i]  && old>=sum)
				sum = array[i];
		}
		sum = sum>old?sum:old;
		
		for(i=max_index-1;i>=0;i--) {
			total +=array[i];
			if(sum<array[i] && sum<0)
				sum = array[i];
			else if(sum+array[i]>sum)
				sum +=array[i];
			else if(old<=sum) {
				old = sum;
				sum = array[i];
			}
			else if(sum>array[i]  && old>=sum)
				sum = array[i];
		}
		return total>(sum>old?sum:old)?total:(sum>old?sum:old);
	}
	
	public static int getSumOfContigousSubArray(Integer[] array) {
		int max = array[0], max2=array[0];
		for(int i=1;i<array.length;i++) {
			max = max+array[i]>array[i]?max+array[i]:array[i];
			max2 = max>max2?max:max2;
		}
		return max2;
	}
}
