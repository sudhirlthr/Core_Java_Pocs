package com.sudhir.turvo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MaxItem {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String input = br.readLine();
			long n = Integer.parseInt(input.split("\\s+")[0]);
			long m = Integer.parseInt(input.split("\\s+")[1]), total_item = 0;;
			boolean check_prcice = false;
			Map<Long, Long> map = new TreeMap<Long, Long>();
			List<Long> result = new ArrayList<>();
			while(n-->0) {
				String str = br.readLine();
				long price = Long.parseLong(str.split("\\s+")[0]);
				long id = Long.parseLong(str.split("\\s+")[1]);
				if(map.containsKey(price)) {
					if(map.get(price)<id)
						map.put(price, id);
				}
				else
					map.put(price, id);
			}
			for(Map.Entry<Long, Long> itr:map.entrySet()) {
				long key = itr.getKey();
				long value = itr.getValue();
				if(!check_prcice && key>m) {
					System.out.println("-1");
					check_prcice = true;
					break;
				}
				else if(m>=total_item+key){
					result.add(value);
					total_item += key;
				}
				else
					break;
			}
			if(!check_prcice) {
				Collections.sort(result);
				for(Long res:result)
					System.out.println(res);
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
