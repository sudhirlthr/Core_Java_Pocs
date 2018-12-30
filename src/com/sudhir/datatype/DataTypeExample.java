package com.sudhir.datatype;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map;
import java.util.TreeMap;

public class DataTypeExample {

	public static void main(String[] args) {
     
        /*Scanner in = new Scanner(System.in);
        int a;
        a = in.nextInt();
        int b;
        b = in.nextInt();
        int sum;
        sum = solveMeFirst(a, b);
        System.out.println(sum);*/
        try {
        	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String[] inputArray = reader.readLine().split("\\s+");
            int n=0,m=0,k=0;
            n = Integer.parseInt(inputArray[0]);
            m = Integer.parseInt(inputArray[1]);
            k = Integer.parseInt(inputArray[2]);
            Character[][] matrix = new Character[n][m];
            Map<String,Integer> resultMap = new TreeMap<String,Integer>();
            Map<String,Character> treasureMap = new HashMap<String,Character>();
            while(k-->0){
                inputArray = reader.readLine().split("\\s+");
                int row =  Integer.parseInt(inputArray[0]);
                int col =  Integer.parseInt(inputArray[1]);
                matrix[row][col] = 'T';
                treasureMap.put(""+row+":"+col,'T');
            }
            
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(matrix[i][j]!= null){
                        // for rhs 
                        if(j+1 != m && matrix[i][j] != null && matrix[i][j+1] !=null && matrix[i][j+1] == 'T'){
                            if(resultMap.containsKey(""+i+":"+(j+1))){
                                int value = resultMap.get(""+i+":"+(j+1));
                                resultMap.put(""+i+":"+(j+1),value+1);
                            }else{
                                resultMap.put(""+i+":"+(j+1),1);
                            }
                        }
                        
                        // for lower right diagonal
                        if(i+1 < n && j+1 < m && matrix[i][j]!= null && matrix[i+1][j+1]!=null && matrix[i+1][j+1] == 'T'){
                            if(resultMap.containsKey(""+(i+1)+":"+(j+1))){
                                int value = resultMap.get(""+(i+1)+":"+(j+1));
                                resultMap.put(""+(i+1)+":"+(j+1),value+1);
                            }else{
                                resultMap.put(""+(i+1)+":"+(j+1),1);
                            }
                        }
                        
                         // for bottom index
                        if(i+1 < n && j <m  && matrix[i][j]!= null && matrix[i+1][j]!=null && matrix[i+1][j] == 'T'){
                            if(resultMap.containsKey(""+(i+1)+":"+(j))){
                                int value = resultMap.get(""+(i+1)+":"+(j));
                                resultMap.put(""+(i+1)+":"+(j),value+1);
                            }else{
                                resultMap.put(""+(i+1)+":"+(j),1);
                            }
                        }
                        
                        // for left index
                        if(i < n && j-1 >= 0 && matrix[i][j]!= null && matrix[i][j-1]!=null &&  matrix[i][j-1] == 'T'){
                            if(resultMap.containsKey(""+(i+1)+":"+(j-1))){
                                int value = resultMap.get(""+(i+1)+":"+(j-1));
                                resultMap.put(""+(i+1)+":"+(j-1),value+1);
                            }else{
                                resultMap.put(""+(i+1)+":"+(j-1),1);
                            }
                        }
                        
                        // for upper index
                        if(i-1 >=0 && j >= 0 && matrix[i][j]!= null && matrix[i-1][j]!=null && matrix[i-1][j] == 'T'){
                            if(resultMap.containsKey(""+(i-1)+":"+(j))){
                                int value = resultMap.get(""+(i-1)+":"+(j));
                                resultMap.put(""+(i-1)+":"+(j),value+1);
                            }else{
                                resultMap.put(""+(i-1)+":"+(j),1);
                            }
                        }
                        
                        
                         // for lower left diagonal
                        if(i+1 < n && j-1 >=0 &&  matrix[i][j]!= null && matrix[i+1][j-1]!=null && matrix[i+1][j-1] == 'T'){
                            if(resultMap.containsKey(""+(i+1)+":"+(j-1))){
                                int value = resultMap.get(""+(i+1)+":"+(j-1));
                                resultMap.put(""+(i+1)+":"+(j-1),value+1);
                            }else{
                                resultMap.put(""+(i+1)+":"+(j-1),1);
                            }
                        }
                        
                          // for upper left diagonal
                        if(i-1 >=0 && j-1 >=0 && matrix[i][j]!= null && matrix[i-1][j-1] != null && matrix[i-1][j-1] == 'T'){
                            if(resultMap.containsKey(""+(i-1)+":"+(j-1))){
                                int value = resultMap.get(""+(i-1)+":"+(j-1));
                                resultMap.put(""+(i-1)+":"+(j-1),value+1);
                            }else{
                                resultMap.put(""+(i-1)+":"+(j-1),1);
                            }
                        }
                        
                          // for upper right diagonal
                        if(i-1 >= 0 && j+1 < m && matrix[i][j]!= null && matrix[i-1][j+1] !=null  && matrix[i-1][j+1] == 'T'){
                            if(resultMap.containsKey(""+(i-1)+":"+(j+1))){
                                int value = resultMap.get(""+(i-1)+":"+(j+1));
                                resultMap.put(""+(i-1)+":"+(j+1),value+1);
                            }else{
                                resultMap.put(""+(i-1)+":"+(j+1),1);
                            }
                        }
                    }
                }
            }
            
            for(Map.Entry<String, Integer> entry:resultMap.entrySet()){
                String key = entry.getKey();
                Integer count = entry.getValue();
                System.out.println(key+" "+count);
            }
        }catch(Exception e) {
        }
        
   
 }

}
