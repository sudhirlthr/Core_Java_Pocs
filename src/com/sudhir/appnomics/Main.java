package com.sudhir.appnomics;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static int count = 0;
    public static int processData(ArrayList<String> array) {
        Map<String, Integer> map = new HashMap<>(); // taking map so that i can keep latest version record for every software 
        array.forEach(arr->{ 
        	String software_name = arr.split(",")[2].trim(); // splitting the input line to get software name as index 3
        	String[] version = arr.split(",")[3].trim().split("\\."); // splitting the input line to get version of software and again splitting to get all version release number 
        	int version_array[] = Arrays.asList(version).stream().mapToInt(Integer::parseInt).toArray();// getting int array from version array to add all version's digits
        	int total_value = 0;
        	for(int i=0;i<version_array.length;i++)
        		total_value += version_array[i];//total value of version(e.g: 5.5.2 = 5+5+2=12)
        	
        	if(map.get(software_name)!=null) {
        		if(map.get(software_name)<total_value) {// checking if software version is latest or higher version
        			map.put(software_name, total_value);//storing the latest version if previous was old version
        			count++;	// incrementing bcoz latest version is higher than old version
        		}
        		else if(map.get(software_name)>total_value)
        			count++;// incrementing bcoz current version is old version 

        	}
        	else
        		map.put(software_name, total_value);// keeping version for every software during first time read
        	
        });
        return count;
    }

    public static void main (String[] args) {
        ArrayList<String> inputData = new ArrayList<String>();
        try {
            Scanner in = new Scanner(new File("input.txt"));
            while(in.hasNextLine()) {
                String line = in.nextLine().trim();
                if (!line.isEmpty()) // Ignore blank lines
                    inputData.add(line);
                
            }
            int retVal = processData(inputData);
            PrintWriter output = new PrintWriter(new File("output.txt"));
            output.println("" + retVal);
            output.close();
        } catch (IOException e) {
            System.out.println("IO error in input.txt or output.txt");
        }
    }
}
