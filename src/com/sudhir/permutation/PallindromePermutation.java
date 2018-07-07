package com.sudhir.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class PallindromePermutation {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		int test = Integer.parseInt(bf.readLine());
		while(test-->0) {
			int size = 0;
			int k = Integer.parseInt(bf.readLine());
			for(int i=0;i<str.length();i++) {
				if(i+k<str.length()) {
					String sub = str.substring(i, i+k);
					System.out.println("Sub string = "+sub);
					boolean check = new PallindromePermutation().isPermutationOfPalindrome(sub);
					if(check) {
						System.out.println("check = "+check+", len = "+sub.length());
						if(size<sub.length())
							size = sub.length();
					}
				}
			}
			if(size>0)
				System.out.println(size);
			else
				System.out.println("-1");
		}*/
		System.out.println(new PallindromePermutation().isPermutationOfPalindrome("cCc"));
	}

	boolean isPermutationOfPalindrome(String phrase) {
		int bitVector = createBitVector(phrase);
		return bitVector == 0 || checkExactlyOneBitSet(bitVector);
		}
		/* Create a bit vector for the string. For each letter with value i, toggle the
		* ith bit. */
	int createBitVector(String phrase) {
		int bitVector = 0;
		for (char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			bitVector = toggle(bitVector, x);
		}
		return bitVector;
	}
		/* Toggle the ith bit in the integer. */
	int toggle(int bitVector, int index) {
		if (index < 0) return bitVector;
		int mask= 1 << index;
		if ((bitVector & mask) == 0) {
			bitVector |= mask;
		} else {
			bitVector &= ~mask;
		}
		return bitVector;
		} 
	/* Check that exactly one bit is set by subtracting one from the integer and* ANDing it with the original integer. */
	boolean checkExactlyOneBitSet(int bitVector) {
		return (bitVector & (bitVector - 1)) == 0;
	}


	int getCharNumber(Character c) {
		int a= Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val= Character.getNumericValue(c);
		if (a<= val && val<= z) {
			return val - a;
		}
		return -1;
	}

}
