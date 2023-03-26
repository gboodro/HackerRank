// https://www.hackerrank.com/contests/101jan14/challenges/cube-summation

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static HashMap<String, Integer> map;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        for(int i = 0; i < t; i++){
            map = new HashMap();
            String[] cur = in.readLine().split(" ");
            int n = Integer.parseInt(cur[0]);
            int q = Integer.parseInt(cur[1]);
            String[] query;
            for(int j = 0; j < q; j++){
                query = in.readLine().split(" ");
                if(query[0].charAt(0) == 'U'){
                    map.put(query[1] +" "+query[2]+" "+query[3], Integer.parseInt(query[4]));
                }else{
                    int x1 = Integer.parseInt(query[1]);
                    int y1 = Integer.parseInt(query[2]);
                    int z1 = Integer.parseInt(query[3]);
                    int x2 = Integer.parseInt(query[4]);
                    int y2 = Integer.parseInt(query[5]);
                    int z2 = Integer.parseInt(query[6]);
                    System.out.println(calcSum(x1, y1, z1, x2, y2, z2));
                }
            }
        }
    }
    
    private static long calcSum(int x1, int y1, int z1, int x2, int y2, int z2){
        long s = 0;
        for(String k:map.keySet()){
            String[] cur = k.split(" ");
            int x = Integer.parseInt(cur[0]);
            int y = Integer.parseInt(cur[1]);
            int z = Integer.parseInt(cur[2]);
            if(between(x, Math.min(x1, x2), Math.max(x1, x2)) && 
               between(y, Math.min(y1, y2), Math.max(y1, y2)) &&
               between(z, Math.min(z1, z2), Math.max(z1, z2)))
                s += map.get(k);
        }
        return s;
    }
    
    private static boolean between(int x, int min, int max){
        return x >= min && x <= max;
    }
}