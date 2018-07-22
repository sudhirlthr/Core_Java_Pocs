/**
 * 
 */
package com.sudhir.hackerearth.capilary.July_21_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * @author sudhir
 *
 */
public class OldAndColdNumbers {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(String.valueOf(br.readLine()));
		while(test-->0) {
			int n = Integer.parseInt(String.valueOf(br.readLine()));
			BigInteger[] array = new BigInteger[n];
			String[] elements = br.readLine().trim().split("\\s+");
			for(int i=0;i<n;i++)
				array[i] = new BigInteger(elements[i]);
			//array = Stream.of(elements.split("\\s+")).mapToInt(Integer::parseInt).toArray();
			/*int index = 0;
			StringTokenizer token = new StringTokenizer(br.readLine());
			while(token.hasMoreTokens())
				array[index++] = new BigInteger(token.nextToken());*/
				
			int q = Integer.parseInt(String.valueOf(br.readLine()));
			while(q-->0) {
				elements = br.readLine().trim().split("\\s+");
				int l = Integer.parseInt(elements[0]);
				int r = Integer.parseInt(elements[1]);
				System.out.println(getResult(array, l, r));
			}
			
		}
	}

	
	public static int getResult(BigInteger[] array, int l ,int r) {
		BigInteger[] old_numbers = getOldNumbers(array, l ,r);
		int result = 0;
		if(r%2==0 && old_numbers.length>=r/2) return 0;
		else if(r%2!=0 && old_numbers.length>=(r/2)+1) return 0;
		else {
			/*BigInteger[] cold_numbers = new BigInteger[array.length-old_numbers.length];
			int index = 0;
			boolean flag = false;
			for(int i=0;i<array.length;i++) {
				for(int j=0;j<old_numbers.length;j++)
					if(array[i].equals(old_numbers[j]))
						flag = true;
				if(!flag) {
					cold_numbers[index++] = array[i];
				}
				flag = false;
			}*/
			
			//int c_len = cold_numbers.length, o_len = old_numbers.length;
			int c_len = r-l+1-old_numbers.length, o_len = old_numbers.length;
			while(c_len>o_len) {
				result++;
				c_len--;
				o_len++;
			}
			
		}
		return result;
	}
	
	public static BigInteger[] getOldNumbers(BigInteger[] array, int l, int r) {
		StringBuilder sb = new StringBuilder("");
		for(int i=l-1;i<=r-1;i++) {
			int odd_count = getOddCount(array[i]);
			if(array[i].mod(new BigInteger(String.valueOf(odd_count))).compareTo(new BigInteger("0"))==0)
				sb.append(array[i]+" ");
		}
		String[] str = new String(sb).trim().split("\\s+");
		BigInteger[] res = new BigInteger[str.length];
		if (sb.length()>0) {
			
			for (int i = 0; i < str.length; i++)
				res[i] = new BigInteger(str[i]);
		}
		return res;
	}
	
	public static int getOddCount(BigInteger ele_value) {
		BigInteger i = new BigInteger("1");
		BigInteger t = new BigInteger("2");
	
		int count = 0;
		for(i = new BigInteger("1");i.compareTo(ele_value)!=0;i=i.add(new BigInteger("1"))) {
			BigInteger rem = i.mod(t);
			if(rem.compareTo(new BigInteger("0"))!=0)
				count++;
		}
		return count;
	}
}
