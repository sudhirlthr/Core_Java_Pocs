/**
 * 
 */
package com.sudhir.hackerearth.capilary.July_21_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author sudhir
 *
 */
public class HappinessTour {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(String.valueOf(br.readLine()));
		while(test-->0) {
			int n_numOfCities = Integer.parseInt(String.valueOf(br.readLine()));
			//long[] happiness = Stream.of(br.readLine().split("\\s+")).mapToLong(Long::parseLong).toArray();
			BigInteger[] happiness = new BigInteger[n_numOfCities];
			String[] elements = br.readLine().trim().split("\\s+");
			for(int i=0;i<n_numOfCities;i++)
				happiness[i] = new BigInteger(elements[i]);
			int m_numOfRoads = Integer.parseInt(String.valueOf(br.readLine()));
			//int[] from = Stream.of(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			//int[] to = Stream.of(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			int[] from = new int[m_numOfRoads];
			int[] to = new int[m_numOfRoads];
			elements = br.readLine().trim().split("\\s+");
			String[] str_to = br.readLine().trim().split("\\s+");
			for(int i=0;i<m_numOfRoads;i++) {
				from[i] = Integer.parseInt(elements[i]);
				to[i] = Integer.parseInt(str_to[i]);
			}
			System.out.println(getHappinessMarks(happiness, m_numOfRoads, from, to));
		}
	}

	public static BigInteger getHappinessMarks(BigInteger[] happiness, int m_numOfRoads, int[] from, int[] to) {
		int prev_key = -1, next_key = -1;
		BigInteger happiness_marks = new BigInteger("0");
		Map<Integer, ArrayList<Integer>> map = new Hashtable<>();
		for(int i=0;i<m_numOfRoads;i++) {
			if(map.containsKey(from[i])) {
				ArrayList<Integer> to_list= map.get(from[i]);
				to_list.add(to[i]);
				map.put(from[i], to_list);
			}
			else {
				ArrayList<Integer> to_list = new ArrayList<>();
				to_list.add(to[i]);
				map.put(from[i], to_list);
			}
		}
		
		for(Map.Entry<Integer, ArrayList<Integer>> entry_map:map.entrySet()) {
			int from_key = entry_map.getKey();
			List<Integer> to_value = map.get(from_key);
			if(prev_key == -1) {
				BigInteger max_cost = new BigInteger("0");
				for(Integer tv:to_value) {
					if(max_cost.compareTo(happiness[tv-1])==-1) {
						max_cost = happiness[tv-1];
						prev_key = from_key;
						next_key = tv;
					}
				}
				happiness_marks = happiness_marks.add(max_cost);
			}
			else if(prev_key == from_key || to_value.contains(prev_key) || to_value.contains(next_key)) {
				BigInteger max_cost = new BigInteger("0");
				for(Integer tv:to_value) {
					if(max_cost.compareTo(happiness[tv-1])==-1) {
						max_cost = happiness[tv-1];
						prev_key = from_key;
						next_key = tv;
					}
				}
				happiness_marks = happiness_marks.add(max_cost);
			}
		}
		
		return happiness_marks;
	}
}
