package com.sudhir.compression;

public class Compression {

	public static void main(String[] args) {
		System.out.println(compress("aabcccccaaa"));
		System.out.println(compressString("aabcccccaaa"));
	}

	public static String compress(String str) {
		//time complexity
		int consecutive = 0;
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<str.length();i++) {
			consecutive++;
			if(i+1>= str.length() || str.charAt(i)!=str.charAt(i+1)) {
				sb = sb.append(str.charAt(i)).append(consecutive);
				consecutive = 0;
			}
		}
		return str.length()<sb.length()?str:sb.toString();
	} 
	public static String compressString(String str) {
		int finallength = countCompress(str);
		if(finallength >= str.length()) return str;
		int countConsecutive = 0;
		StringBuilder sb = new StringBuilder(finallength);
		for(int i=0;i<str.length();i++) {
			countConsecutive++;
			if(i+1>=str.length() || str.charAt(i)!=str.charAt(i+1)) {
				sb = sb.append(str.charAt(i)).append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return sb.toString();
	} 
	public static int countCompress(String str) {
		//TC is O(n) and also minimizes space complexity of SB 
		//and returning before compressing if compressed string is of more length
		int compressedLength = 0;
		int countConsecutive = 0;
		for(int i=0;i<str.length();i++) {
			countConsecutive++;
			if(i+1>=str.length() || str.charAt(i)!=str.charAt(i+1)) {
				compressedLength += 1+String.valueOf(countConsecutive).length();
				countConsecutive = 0;
			}
		}
		return compressedLength;
	}
}
