package com.sudhir.sorocco;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsPhoneNumber {
	public static void main(String[] args) throws NumberFormatException, IOException {

        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String regex = "([0-9]{1,3})[- ]([0-9]{1,3})[- ]([0-9]{4,10})";
        for(int i =0; i<n; i++){
        	String output =new String();
            String text = br.readLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);
            
            while (matcher.find()){
                output =matcher.group(1)+"-"+matcher.group(2)+"-"+matcher.group(3)+"\n";
            }
            if(output.equals(""))
            	System.out.println("NONE");
            else
            	System.out.print(output);           
        }
	}
}
