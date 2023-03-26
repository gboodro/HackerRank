// https://www.hackerrank.com/challenges/ajourney

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.awt.Robot;
import java.awt.AWTException;
public class Solution {
    static HashMap<String, Long> r = new HashMap();
    static HashMap<Integer, Double> fd = new HashMap();
    static long[] k = new long[] {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000l};
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++)
            System.out.println(part(in.nextInt(), in.nextInt()));
    }
    
    private static long part(int n, int m){
        return front(partF(n-1), k[m]) + partR(n-1, k[m]);
    }
    
    private static long partR(int n, long m){
        if(n == 0) return 1;
        if(n == 1) return 2;
        if(r.containsKey(n + " " + m)) return r.get(n + " " + m);
        r.put(n + " " + m, (partR(n/2, m)*partR(n-n/2, m))%m);
        return r.get(n + " " + m);
    }
    
    private static double partF(int n){
        if(n == 0) return 1.0;
        if(n == 1) return 2.0;
        if(fd.containsKey(n)) return fd.get(n);
        double v = front(partF(n/2)*partF(n-n/2));
        fd.put(n, v);
        return v;
    }
    
    private static long front(double n, long m){
        while(n > m) n /= 10;
        return (long)n;
    }
    
    private static double front(double n){
        while(n > 1e100) n /= 1e90;
        return n;
    }
    
}