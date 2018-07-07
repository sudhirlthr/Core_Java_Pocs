package com.sudhir.turvo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FreeWalk {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int test = Integer.parseInt(br.readLine());
			while(test-->0) {
				String path = br.readLine();
				long count_a = path.chars().filter(ch -> ch == 'A').count();
				System.out.println("Occurance of A = "+count_a);
				
				long count_c = path.chars().filter(ch -> ch == 'C').count();
				System.out.println("Occurance of C = "+count_c);
				
				long count_unknown = path.chars().filter(ch -> ch == '?').count();
				System.out.println("Occurance of ? = "+count_unknown);
				
				if(count_a >= count_c)
					System.out.println(count_a+count_unknown);
				else if(count_a < count_c)
					System.out.println(count_c+count_unknown);
					
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
