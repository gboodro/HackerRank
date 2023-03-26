// https://www.hackerrank.com/challenges/is-fibo

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static HashSet<Long> fibs = new HashSet();
    public static void main(String[] args) {
        long max = 10000000000l;
        long a = 1, b = 1, c;
        fibs.add(0l);
        fibs.add(1l);
        do{
            c = a+b;
            fibs.add(c);
            a = b;
            b = c;
        }while(c <= max);
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++) System.out.println(isFib(in.nextLong()));
    }
    
    private static String isFib(long n){
        return fibs.contains(n)? "IsFibo":"IsNotFibo";
    }
}