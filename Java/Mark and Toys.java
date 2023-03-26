// https://www.hackerrank.com/challenges/mark-and-toys

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static long[] k;
    static int max = 0;
    static long start;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        k = new long[in.nextInt()];
        long money = in.nextLong();
        for(int i = 0; i < k.length; i++){
            k[i] = in.nextLong();
        }
        Arrays.sort(k);
        start = System.currentTimeMillis();
        System.out.println(maxT(0, 0, money));
    }
    
    private static int maxT(int j, int c, long money){
        for(int i = 0; i < k.length && money > 0; i++){
            c++;
            money -= k[i];
        }
        return c-1;
    }
}