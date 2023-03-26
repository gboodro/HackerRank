// https://www.hackerrank.com/challenges/ncr-table

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static BigInteger[] fact = new BigInteger[1001];
    static BigInteger m = BigInteger.valueOf(1000000000l);
    public static void main(String[] args) {
        fact[0] = BigInteger.ONE;
        for(int i= 1; i < fact.length; i++) fact[i] = fact[i-1].multiply(BigInteger.valueOf(i));
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++)
            nCrRow(in.nextInt());
    }
    
    private static void nCrRow(int n){
        String end = "";
        for(int i = 0; i < (n+1)/2; i++){
            int cur = nCr(n, i);
            end = cur + " " + end;
            System.out.print(cur+" ");
        } 
        if(n % 2 == 0) System.out.print(nCr(n, n/2)+" ");
        System.out.println(end.trim());
    }
    
    private static int nCr(int n, int k){
        return fact[n].divide(fact[k]).divide(fact[n-k]).mod(m).intValue();
    }
}