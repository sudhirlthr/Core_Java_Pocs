/**
 * 
 */
package com.sudhir.hackerearth.pramata05_08_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author sudhir
 *
 */
public class Question2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine().trim());
			Map<String, Integer> userwithMarks = new HashMap<>();
			Map<String, Integer> userwithTime = new HashMap<>();
			for(int i=0;i<n;i++) {
				String[] entry = br.readLine().split("\\s+");
				if(userwithMarks.containsKey(entry[0])){
					//if(userwithMarks.containsValue(entry[1])) {
						userwithMarks.put(entry[0], userwithMarks.get(entry[0])+100);
						userwithTime.put(entry[0], userwithTime.get(entry[0])+Integer.parseInt(entry[1]));
					//}
				}
				else {
					userwithMarks.put(entry[0], 100);
					userwithTime.put(entry[0], Integer.parseInt(entry[1]));
				}
			}
			
			Set<Entry<String, Integer>> user_marks_set = userwithMarks.entrySet();
			Set<Entry<String, Integer>> user_time_set = userwithTime.entrySet();
			Comparator<Entry<String, Integer>> valuecompare = new Comparator<Map.Entry<String,Integer>>() {
				
				@Override
				public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
					Integer i1 = o1.getValue();
					Integer i2 = o2.getValue();
					return i1.compareTo(i2);
				}
			};
			List<Entry<String, Integer>> userMarkslistofvalues = new ArrayList<>(user_marks_set);// for marks sorting
			List<Entry<String, Integer>> userTimelistofvalues = new ArrayList<>(user_time_set); // for time sorting
			Collections.sort(userMarkslistofvalues,valuecompare.reversed());
			Collections.sort(userTimelistofvalues,valuecompare);
			/*LinkedHashMap<String, Integer> linkedMap = new LinkedHashMap<>(userMarkslistofvalues.size());
			// copying entries from List to Map
	        for(Entry<String, Integer> entry : userMarkslistofvalues){
	        	linkedMap.put(entry.getKey(), entry.getValue());
	        }*/
			ArrayList<String> e_name = new ArrayList<>();
			int id=0;
			String name="";
			Integer marks = 0;
			for (Entry<String, Integer> entry : userMarkslistofvalues) {
				String nam = entry.getKey();
				Integer value = entry.getValue();
				if (id == 0) {
					name = nam;
					marks = value;
					id++;
				} else if (marks.equals(value) && !e_name.contains(nam)) {
					for (Entry<String, Integer> entry2 : userTimelistofvalues) {
						String na = entry2.getKey();
						Integer mark = userwithMarks.get(na);
						String[] str = {name,nam};
						Arrays.sort(str);
						
						if (na.equals(nam) && str[0].equals(na) && !e_name.contains(na)) {
							System.out.println(id++ + "" + na);
							e_name.add(na);
							break;
						} else if (na.equals(name)  && str[0].equals(na) && !e_name.contains(na)) {
							System.out.println(id++ + "" + na);
							e_name.add(na);
							name=nam;
							marks=value;
							break;
						} else if (marks.equals(mark) && (!na.equals(nam)&& !na.equals(name))) {
							System.out.println(id++ + "" + na);
							e_name.add(na);
						} else
							continue;
					}
					/*
					 * int prev_q_time = userwithTime.get(name); int cur_Q_time =
					 * userwithTime.get(nam); if(prev_q_time<cur_Q_time) {
					 * System.out.println(id+++""+name); e_name.add(name); name = nam; marks =
					 * value; } else if(prev_q_time == cur_Q_time){ String[] name_arr = {name,nam};
					 * Arrays.sort(name_arr); if(name_arr[0].equals(name)) {
					 * System.out.println(id+++""+name); e_name.add(name); name=nam; marks = value;
					 * } else { System.out.println(id+++""+nam); e_name.add(nam); } }
					 */

				} else {
					/*
					 * if(e_name.size()>0) { e_name.add(name); Collections.sort(e_name); for(String
					 * str:e_name) { System.out.println(id+""+str); id++; } e_name = new
					 * ArrayList<>(); } else { System.out.println(id+++""+name); }
					 */
					System.out.println(id++ + "" + name);
					e_name.add(name);
					name = nam;
					marks = value;
				}

			}
			if(!e_name.contains(name))
				System.out.println(id+++""+name);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
