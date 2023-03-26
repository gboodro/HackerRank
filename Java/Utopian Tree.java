// https://www.hackerrank.com/challenges/utopian-tree

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
    
    private static long f(int n){
        long h = 1;
        while(n > 0){
            h *= 2;
            n--;
            if(n > 0) h++;
            n--;
        }
        return h;
    }
}