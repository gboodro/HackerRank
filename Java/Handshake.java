// https://www.hackerrank.com/challenges/handshake

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
            System.out.println(tri(in.nextInt()-1));
        }
    }
    
    private static long tri(long n){
        return n*(n+1)/2;
    }
}