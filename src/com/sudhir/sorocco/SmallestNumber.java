package com.sudhir.sorocco;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SmallestNumber {

	public static void main(String[] args) {
		System.out.println(find_smallest_number("45623"));

	}
	static String find_smallest_number(String num) {
		BigInteger[] array = Arrays.stream(num.split("")).map(SmallestNumber::convertFromStringToBigInteger).toArray(BigInteger[]::new);
		List<BigInteger> numberList = Arrays.asList(array);
		BigInteger smallestNumber = Collections.min(numberList);
		int indexPosition = numberList.indexOf(smallestNumber);
		StringBuilder resultString = new StringBuilder("");
		if(array[0] != smallestNumber) {
			BigInteger tempVariable = array[0];
			array[0] = smallestNumber;
			array[indexPosition] = tempVariable;
			
			
			/*tempVariable = array[1];
			for(int i=2;i<array.length;i++) {
				if(array[i].compareTo(tempVariable)<=0  && tempVariable.compareTo(smallestNumber)>=0) {
					tempVariable = array[i];
				}
			}
			int index = numberList.indexOf(tempVariable);
			if(numberList.indexOf(smallestNumber) == numberList.indexOf(tempVariable)) {
				for(int i=1;i<array.length;i++)
					if(array[i].compareTo(tempVariable)==0)
						index=i;
			}
			
			if(index != 1) {
				BigInteger toBeExchangeElement = array[1];
				array[1] = tempVariable;
				array[index] = toBeExchangeElement;
			}*/
			
			
			for (BigInteger bigInteger : array) {
				resultString.append(bigInteger.toString());
			}
		}else {
			BigInteger tempVariable = array[1];
			for(int i=2;i<array.length;i++) {
				if(array[i].compareTo(tempVariable)<=0  && tempVariable.compareTo(smallestNumber)>=0) {
					tempVariable = array[i];
				}
			}
			int index = numberList.indexOf(tempVariable);
			if(numberList.indexOf(smallestNumber) == numberList.indexOf(tempVariable)) {
				for(int i=1;i<array.length;i++)
					if(array[i].compareTo(tempVariable)==0)
						index=i;
			}
			
			if(index != 1) {
				BigInteger toBeExchangeElement = array[1];
				array[1] = tempVariable;
				array[index] = toBeExchangeElement;
			}
			for (BigInteger bigInteger : array) {
				resultString.append(bigInteger.toString());
			}
		}
			
		return resultString.toString();
	}
	
	private static BigInteger convertFromStringToBigInteger(String unsorted) {
        return new BigInteger(unsorted);
    }
}
