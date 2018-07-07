package com.sudhir.turvo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Turvo {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String input = br.readLine();
			if(input != null && !input.equals("")) {
				StringTokenizer token = new StringTokenizer(input, "\\n");
				while(token.hasMoreTokens())
					System.out.println(token.nextToken());
				System.out.println(input);
				String[] strArray = input.split("(\r\n|\r|\n)", -1);
				for(String str:strArray) {
					System.out.println(str);
					String[] backspace = str.split("\\b"); 
					for(String s:backspace)
						System.out.print(s);
				}
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
