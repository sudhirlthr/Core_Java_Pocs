package com.sudhir.airtel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class FirstNonReatingChar {
	public static void main(String[] args) {
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(getFirstNonRepeateCharacter(input.readLine()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static char getFirstNonRepeateCharacter(String input) {
		if(input == null) return 0;
		else {
			String regex = "[a-zA-Z0-9]";
			
			input = getString(input);
			for(int i=0;i<input.length();i++) {
				String temp = ""+input.charAt(i)+"";
				if(temp.matches(regex))
					return input.charAt(i);
				
			}
		}
		return 0;
	}
	
	public static String getString(String str) {
		Set<Character> set = new HashSet<>();
		char[] charArray = str.toCharArray();
		for(int i=0;i<charArray.length;i++) {
			if(set.contains(charArray[i]))
				str = str.replaceAll(""+charArray[i], "#");
			else
				set.add(charArray[i]);
		}
		//System.out.println("replaced string = "+str);
		return str;
	}
}
