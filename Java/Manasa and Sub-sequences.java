// https://www.hackerrank.com/contests/infinitum-may14/challenges/manasa-and-sub-sequences

import java.math.*;
import java.util.*;

class Solution{
    
    static long m = 1000000007;    
    
    public static void main(String[] args){
        System.out.println(f(new Scanner(System.in).next()));
    }
    
    static long f(String num){
        return aux(intArr(num.toCharArray()));
    }
    
    static long aux(int[] num){
        long t = 1;
        long s = 0;
        for(int i = 0; i < num.length; i++){
            s += ((powMod(11, num.length - i - 1)*t)%m *(num[i]%10))%m;
            s %= m;
            t *= 2L;
            t %= m;
        }
        return s;
    }
    
    static long powMod(long a, long p){
        if(p <= 1) return p == 0 ? 1: a%m;
        return (powMod((a*a)%m, p/2)*(p % 2==1?a%m:1))%m;
    }
    
    static int[] intArr(char[] c){
        int[] arr = new int[c.length];
        int i = 0;
        for(char ch:c) arr[i++] = (int)(ch-48);
        return arr;
    }
}