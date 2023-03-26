// https://www.hackerrank.com/challenges/service-lane

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static int[] w;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), t = in.nextInt();
        w = new int[n];
        for(int i = 0; i < n; i++) w[i] = in.nextInt();
        for(int i = 0; i < t; i++) System.out.println(query(in.nextInt(), in.nextInt()));
    }
    
    private static int query(int a, int j){
        int max = w[a];
        while(a <= j && max >= 2){
            max = Math.min(max, w[a]);
            a++;
        }
        return max;
    }
}