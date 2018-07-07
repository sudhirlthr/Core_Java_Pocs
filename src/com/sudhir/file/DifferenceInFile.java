package com.sudhir.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class DifferenceInFile {

	public static void main(String[] args) throws IOException {
		File my_file = new File("/home/sudhir/core-java-workspace/CoreJavaPOC/src/com/sudhir/file/Mine ouput.txt");
		File h_file = new File("/home/sudhir/core-java-workspace/CoreJavaPOC/src/com/sudhir/file/Hacker Earth Output");
		BufferedReader my_reader = new BufferedReader(new FileReader(my_file));
		BufferedReader h_reader = new BufferedReader(new FileReader(h_file));
		System.out.println(FileUtils.contentEquals(my_file, h_file));
		
		String current_line;
		List<String> list = new ArrayList<>();
		while((current_line=my_reader.readLine())!=null)
			list.add(current_line);
			
		List<String> h_list = new ArrayList<>();
		while((current_line=h_reader.readLine())!=null)
			h_list.add(current_line);
		
		System.out.println("my length = "+list.size()+" and h_list = "+h_list.size());
		/*for(String str_my:list) {*/
			for(String str_h:h_list) {
				//if(!str_h.equals(str_my))
					System.out.println("str_h = "+str_h);
			}
		//}
		list.removeAll(h_list);
		for(String str_my:list)
			System.out.println(str_my);
		
	}

}
