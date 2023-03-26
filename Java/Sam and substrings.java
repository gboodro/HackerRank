// https://www.hackerrank.com/contests/w3/challenges/sam-and-substrings

import java.math.*;
import java.util.*;

class Solution{
    
    static long m = 1000000007;    
    static BigInteger zero = new BigInteger("0");
    static BigInteger ten = new BigInteger("10");
    static BigInteger M = BigInteger.valueOf(m);
    
    public static void main(String[] args){
        System.out.println(f(new Scanner(System.in).next()));
    }
    
    static long f(String num){
        return aux(intArr(num.toCharArray()));
    }
    
    static long aux(int[] num){
        long c = num.length;
        long t = 1;
        long m = 1000000007;
        long s = 0;
        for(int i = num.length-1; i >= 0; i--){
            s += t*c*(num[i]%10);
            s %= m;
            t = (t*10+1)%m;
            c -= 1;
        }
        return s;
    }
    
    static int[] intArr(char[] c){
        int[] arr = new int[c.length];
        int i = 0;
        for(char ch:c) arr[i++] = (int)(ch-48);
        return arr;
    }
}