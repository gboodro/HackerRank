// https://www.hackerrank.com/challenges/halloween-party

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++) System.out.println(f(in.nextInt()));
    }
    
    private static long f(long n){
        long p = 0;
        for(long i = 1; i <= n/2; i++){
            if(p < i*(n-i)) p = i * (n-i);
        }
        return p;
    }
}