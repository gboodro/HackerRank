// https://www.hackerrank.com/challenges/chocolate-feast

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
            System.out.println(f(in.nextInt(), in.nextInt(), in.nextInt()));
        }
    }
    
    private static long f(int n, int a, int b){
        return n/a + g(n/a, b);
    }
    
    private static long g(int a, int b){
        if(a < b) return 0;
        else return a/b + g(a-a/b*b + a/b, b);
    }
}