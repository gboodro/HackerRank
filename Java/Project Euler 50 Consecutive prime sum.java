// https://www.hackerrank.com/contests/projecteuler/challenges/euler050

import java.util.*;
import java.math.*;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }
    long[] p = getPrimes(7000000);
    Solution(){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(;t-->0;)System.out.println(longest(in.nextLong()));
    }
    String longest(long n){
        long s = 0;
        int i = 0;
        while(i < p.length && p[i] + s <= n) 
            s += p[i++];
        while(!isPrime(s)){
            long t = s;
            for(int k = 0; i + k < p.length && t + p[i+k] - p[k] <= n; k++){
                t += p[i+k] - p[k];
                if(isPrime(t))
                    return t + " " + i;
            }
            s -= p[--i];
        }
        return s + " " + i;
    }
    long[] getPrimes(int n){
        List<Integer> pr = new LinkedList();
        if(n >= 2) pr.add(2);
        boolean[] isP = new boolean[n+1];
        for(int i = 4; i < isP.length; i+=2) isP[i] = true;
        int a = 3;
        while(a < isP.length){
            pr.add(a);
            for(int k = 2*a; k < isP.length; k+=a)isP[k] = true;
            do{a+=2;}while(a < isP.length && isP[a]);
        }
        long[] g = new long[pr.size()];
        a = 0;
        for(int i : pr) g[a++] = (long)i;
        return g;
    }
    boolean isPrime(long n){
        return BigInteger.valueOf(n).isProbablePrime(20);
    }
}