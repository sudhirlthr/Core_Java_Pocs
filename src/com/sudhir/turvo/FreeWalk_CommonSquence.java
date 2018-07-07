package com.sudhir.turvo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FreeWalk_CommonSquence {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int test = Integer.parseInt(br.readLine()), count = 0, prev = 0;
			while(test-->0) {
				String str_path = br.readLine();
				for(int i=0;i<str_path.length()-1;i++) {
					if(str_path.charAt(i)=='?' ) {
						count++;
						prev++;
					}
					else if(str_path.charAt(i)==str_path.charAt(i+1) && str_path.charAt(i)=='C') {
						count++;
						if(count>=prev)
							prev = 0;
					}
					else if(str_path.charAt(i)==str_path.charAt(i+1) && str_path.charAt(i)=='A') {
						prev++;
						if(prev>=count)
							count = 0;
					}
					else if(str_path.charAt(i)!=str_path.charAt(i+1) &&(str_path.charAt(i)=='A') && str_path.charAt(i+1)=='?') {
						prev++;
						if(prev>=count)
							count = 0;
					}
					else if(str_path.charAt(i)!=str_path.charAt(i+1) &&(str_path.charAt(i)=='C') && str_path.charAt(i+1)=='?') {
						count++;
						if(count>=prev)
							prev = 0;
					}
					else if(str_path.charAt(i)!=str_path.charAt(i+1) &&(str_path.charAt(i)=='?') && str_path.charAt(i+1)=='A')
						prev++;
					else if(str_path.charAt(i)=='?' ) {
						count++;
						prev++;
					}
				}
				System.out.println(prev > count ? prev : count);
			}
		} catch (NumberFormatException ne) {
			ne.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
