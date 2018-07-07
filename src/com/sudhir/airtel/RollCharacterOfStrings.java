/**
 * 
 */
package com.sudhir.airtel;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author sudhir
 *
 */
public class RollCharacterOfStrings {
	public static void main(String[] args) {
		int roll[] = {1,2,5};
		String str = "geeks";
		System.out.println(rollString(str,roll));
	}
	
	public static String rollString(String str, int[] roll) {
		int rollCounts[] = new int[str.length()];
		//Arrays.stream(roll).forEach(rollCount -> rollCounts[rollCount - 1]++);
		
		// count/store which index character need to be roll
		for(int i=0;i<roll.length;i++)
			rollCounts[roll[i]-1]++;
		System.out.println(Arrays.toString(rollCounts));
		
		// backtracking means from last to first index add
		// and then all index so that in last step just need to add to characer 
		for(int ind = str.length()-2;ind>=0;ind--) {
			rollCounts[ind] += rollCounts[ind+1];
		}
		System.out.println(Arrays.toString(rollCounts));// counted array where need to be roll which index by how much

		// make char array so that we can add to 'a' after finding number too be rolled for particular character
		char[] charr = str.toCharArray();
		IntStream.range(0, str.length()).forEach(ind->{
			charr[ind] = (char) ('a' + (rollCounts[ind] % 26 + charr[ind] - 'a') % 26);
		});
		return String.valueOf(charr);
	}
}
