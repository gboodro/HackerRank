// https://www.hackerrank.com/challenges/sherlock-and-the-beast

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
    
    private static String f(int n){
        int fives = mostFives(n), threes = n-fives;
        if(threes % 5 != 0) return "-1";
        return string(5, fives) + string(3, threes);
    }
    
    private static int mostFives(int n){
        for(int j = n - (n%3); j > 0; j -= 3){
            if((n - j) % 5 == 0) return j;
        }
        return 0;
    }
    
    private static String string(int t, int n){
        if(n <= 1){
            return n == 1 ? ("" + t):"";
        }else{
            String k = string(t, n/2);
            return k + k + (n % 2 == 1 ? (""+t):"");
        }
    }
}