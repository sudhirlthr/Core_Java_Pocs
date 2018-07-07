package com.sudhir.paytm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WildCardPattern {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-->0) {
			String pattern = br.readLine();
			String text = br.readLine();
			System.out.println(new WildCardPattern().checkWIldPattern(text, pattern));
		}
	}

	public boolean checkWIldPattern(String text, String pattern) {
		//if(pattern.length()<text.length()) return false;
		char[] char_text = text.toCharArray();
		char[] pat = pattern.toCharArray();
		boolean flag = false;
		int i=0;
		for(int j=0;j<pat.length;j++) {
			if(i<=j && (pattern.replaceAll("\\*", "")).length()<=text.length()) {

				if(pat[j]=='*')
					continue;
				else if(pat[j]=='?') {
					i++;				
				}
				else if(pat[j]==char_text[i]) {
					i++;
					flag = true;
				}
				else if(pat[j]!=char_text[i]) {
					if(i==j)
						return false;
					i++;
					flag = false;
					j--;
				}
				else
					return flag;
			}
			else
				return false;
		}
		return flag;
	}
}
