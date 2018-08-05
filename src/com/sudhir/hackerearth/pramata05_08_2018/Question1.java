/**
 * 
 */
package com.sudhir.hackerearth.pramata05_08_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author sudhir
 *
 */
public class Question1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] str = br.readLine().trim().split("\\s+");
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			String[] input = br.readLine().trim().split("\\s+");
			BigDecimal[] elements = Arrays.stream(input).map(s->{
				return new BigDecimal(s);
			}).toArray(BigDecimal[]::new);
			List<BigDecimal> list = Arrays.asList(elements);
			if(k<=n) {
				List<BigDecimal> small_list = list.subList(0, k);
				if (k%2!=0) {
					//System.out.println(Collections.max(small_list));
					if (Collections.max(small_list).compareTo(list.get(k)) < 0)
						System.out.println(list.get(k));
					else
						System.out.println(Collections.max(small_list));
				}
				else {
					List<BigDecimal> small_list2 = list.subList(0, k-1);
					//BigDecimal max1 = Collections.max(small_list);
					BigDecimal max2 = list.get(k);
					BigDecimal max3 = Collections.max(small_list2);
					if (max2.compareTo(max3) < 0)
						System.out.println(max3);
					else
						System.out.println(max2);
				}
			}
			else {
				if(k+1==n) {
					System.out.println(Collections.max(list));
				}
				else if(k>n) {
					k=k%n;
					List<BigDecimal> small_list = list.subList(0, k);
					if (small_list.size()>0) {
						BigDecimal max1 = Collections.max(small_list);
						BigDecimal max2 = list.get(k);
						if (max1.compareTo(max2) < 0)
							System.out.println(max2);
						else
							System.out.println(max1);
					}else
						System.out.println(Collections.max(list));
				}
					//System.out.println("-1");
			}
			/*for(int i=0;i<k-1;i++) {
				list.
			}*/
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

}
