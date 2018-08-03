/**
 * 
 */
package com.sudhir.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sudhir
 *
 */
public class CompareTwoFiles {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader(new File("/home/sudhir/Desktop/HackerEarth/Capilary/1/HackerEarth_result_5.txt"));
			BufferedReader br_hke = new BufferedReader(fr);
			BufferedReader br_mine = new BufferedReader(new FileReader(new File("/home/sudhir/Desktop/HackerEarth/Capilary/1/Sudhir_Result_5.txt")));
			List<Integer> hk_list = new ArrayList<>();
			List<Integer> mine_list = new ArrayList<>();
			String str1;
			while((str1=br_hke.readLine())!=null) {
				hk_list.add(Integer.parseInt(str1));
			}
			while((str1=br_mine.readLine())!=null) {
				mine_list.add(Integer.parseInt(str1));
			}
			
			System.out.println("hk size = "+hk_list.size()+" and mine list size = "+mine_list.size());
			if(hk_list.containsAll(mine_list))
				System.out.println("Equal list");
			else
				System.out.println(hk_list.retainAll(mine_list));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
