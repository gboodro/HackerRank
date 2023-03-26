// https://www.hackerrank.com/challenges/harry-potter-and-the-floating-rocks

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
            System.out.println(numRocks(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()));
        }
    }
    
    private static long numRocks(int x1, int y1, int x2, int y2){
        if(x1 == x2) return Math.abs(y2-y1)-1;
        else if(y1 == y2) return Math.abs(x2-x1)-1;
        else{
            int gcd = gcd(Math.abs(y1-y2), Math.abs(x1-x2));
            return gcd-1;
        }
    }
    
    private static int gcd(int a, int b){
        return b == 0 ? a:gcd(b, a%b);
    }
}