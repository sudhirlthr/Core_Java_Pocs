package com.sudhir.trusting_social_developer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FlashAndCoscoWinner {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long test = Long.parseLong(br.readLine());
		long[] initial_score = new long[4];
		long[] flash_score = new long[4];
		long[] cisco_score = new long[4];
		long[] decrease_score = new long[4];
		for(long i=0;i<test;i++) {
			String input = br.readLine();
			initial_score[0] = Long.parseLong(input.split("\\s+")[0]);
			initial_score[1] = Long.parseLong(input.split("\\s+")[1]);
			initial_score[2] = Long.parseLong(input.split("\\s+")[2]);
			initial_score[3] = Long.parseLong(input.split("\\s+")[3]);
			
			//decrease score
			input = br.readLine();
			decrease_score[0] = Long.parseLong(input.split("\\s+")[0]);
			decrease_score[1] = Long.parseLong(input.split("\\s+")[1]);
			decrease_score[2] = Long.parseLong(input.split("\\s+")[2]);
			decrease_score[3] = Long.parseLong(input.split("\\s+")[3]);
			
			// flash submission
			input = br.readLine();
			flash_score[0] = Long.parseLong(input.split("\\s+")[0]);
			flash_score[1] = Long.parseLong(input.split("\\s+")[1]);
			flash_score[2] = Long.parseLong(input.split("\\s+")[2]);
			flash_score[3] = Long.parseLong(input.split("\\s+")[3]);
			
			//cisco submission
			input = br.readLine();
			cisco_score[0] = Long.parseLong(input.split("\\s+")[0]);
			cisco_score[1] = Long.parseLong(input.split("\\s+")[1]);
			cisco_score[2] = Long.parseLong(input.split("\\s+")[2]);
			cisco_score[3] = Long.parseLong(input.split("\\s+")[3]);
			
			long flash = Math.max(initial_score[0]/2, initial_score[0]-flash_score[0]*decrease_score[0])
					+ Math.max(initial_score[1]/2, initial_score[1]-flash_score[1]*decrease_score[1])
					+ Math.max(initial_score[2]/2, initial_score[2]-flash_score[2]*decrease_score[2])
					+ Math.max(initial_score[3]/2, initial_score[3]-flash_score[3]*decrease_score[3]);
			
			long cisco = Math.max(initial_score[0]/2, initial_score[0]-cisco_score[0]*decrease_score[0])
					+ Math.max(initial_score[1]/2, initial_score[1]-cisco_score[1]*decrease_score[1])
					+ Math.max(initial_score[2]/2, initial_score[2]-cisco_score[2]*decrease_score[2])
					+ Math.max(initial_score[3]/2, initial_score[3]-cisco_score[3]*decrease_score[3]);
			
			if(cisco != flash) {
				if(cisco>flash)
					System.out.println("Cisco");
				else
					System.out.println("Flash");
			}
			else{
				Arrays.sort(flash_score);
				Arrays.sort(cisco_score);
				if(flash_score[3]<cisco_score[3])
					System.out.println("Flash");
				else if(flash_score[3]>cisco_score[3])
					System.out.println("Cisco");
				else if(flash_score[3]==cisco_score[3])
					System.out.println("Tie");
					
			}
			
		}
	}

}
