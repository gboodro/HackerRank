// https://www.hackerrank.com/challenges/angry-children-2

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long curTime;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        long[] x = new long[n];
        for(int i = 0; i < n; i++) x[i] = in.nextInt();
        Arrays.sort(x);
        curTime = System.currentTimeMillis();
        System.out.println(f(n, k, x));
    }
    
    private static long f(int n, int k, long[] x){
        long t = unFair(k, x), min = t, s = 0;
        for(int i = 1; i < k; i++) s += x[i];
        
        for(int i = 1; i + k-1 < x.length; i++){
            t += (k-1)*(x[i-1] + x[i+k-1]);
            t -= 2*s;
            if(t < min) min = t;
            s += x[i+k-1] -x[i];
        }
        return min;
    }
    
    private static long unFair(int k, long[] x){
        long s = 0;
        for(int i = 0; i < k; i++){
            s += x[i] *(2*i-k+1);
        }
        return s;
    }
    
    private static long sum(int i, int j, long[] x){
        long s = 0;
        for(int k = i; k <= j; k++) s += x[k];
        return s;
    }
    
}