package com.sudhir.sorocco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CoinChange {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> customerQueue = Arrays.asList(bufferedReader.readLine().split(",")).stream().map(Integer::parseInt).collect(Collectors.toList());
		System.out.println(getNumber(customerQueue));
	}
	public static int getNumber(List<Integer> rupee_notes) {
		List<Integer> shopKeeperMoney = new ArrayList<>();
		Integer totalBalance = 0;
		int result = 0;
		boolean flag = false;
		for(int i=0;i<rupee_notes.size();i++) {
			Integer customerMoney = rupee_notes.get(i);
			if(shopKeeperMoney.contains(5)) {
				totalBalance = 0;
				for (Integer shopKeeperBalanceMoney : shopKeeperMoney) {
					totalBalance +=shopKeeperBalanceMoney;
				}
				if(totalBalance == 0 && customerMoney==5)
					shopKeeperMoney.add(customerMoney);
				else if(totalBalance > 0 && customerMoney == 10)
					shopKeeperMoney.remove(shopKeeperMoney.indexOf(5));
				else if((totalBalance == 0 && customerMoney == 10) || (totalBalance == 0 && customerMoney == 20)) {
					result = i+1;
					break;
				}
				else if(totalBalance == 5 && customerMoney == 20) {
					result = i+1;
					break;
				}
				else if(totalBalance > customerMoney && customerMoney == 20 ) {
					shopKeeperMoney.remove(shopKeeperMoney.indexOf(5));
					shopKeeperMoney.remove(shopKeeperMoney.indexOf(5));
					shopKeeperMoney.remove(shopKeeperMoney.indexOf(5));
				}
				else if(totalBalance > 0 && customerMoney == 20 && totalBalance+5 < customerMoney) {
					result = i+1;
					break;
				}
				else if(totalBalance > 0 && customerMoney >= totalBalance +5)
					shopKeeperMoney = new ArrayList<>();
				
			}else if(customerMoney == 5)
				shopKeeperMoney.add(5);
			else
				result = i+1;
			
			if(i== rupee_notes.size()-1)
				flag = true;
		}
		if(shopKeeperMoney.size()>0) {
			if(totalBalance /5 !=0)
				if(!flag)
					return result;
				else
					return 0;
			else
				return 0;
			
		}
		else
			return result;
	}
}
