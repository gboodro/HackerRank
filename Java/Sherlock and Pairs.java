// https://www.hackerrank.com/challenges/sherlock-and-pairs

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int j = 0; j < n; j++) a[j] = in.nextInt();
            System.out.println(f(a));
        }
    }
    
    private static long f(int[] a){
        int max = 0;
        for(int b:a) max = Math.max(max, b);
        int[] c = new int[max+1];
        for(int b:a) c[b]++;
        long sum = 0;
        for(int d:c) sum += (long)d*(d-1);
        return sum;
    }
}