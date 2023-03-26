// https://www.hackerrank.com/challenges/gcd-product

import java.util.*;
import java.math.BigInteger;

class Solution{
    
    static BigInteger M = BigInteger.valueOf(1000000007);
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        System.out.println(G(m, n));
    }
    
    static long G(int m, int n){
        long mod = 1000000007l;
        HashSet<BigInteger> p = getPrimes(Math.min(m, n));
        BigInteger gcd = BigInteger.ONE;
        for(BigInteger prime : p){
            gcd = gcd.multiply(powMod(prime, g(m, n, prime.longValue()))).mod(M);
        }
        return gcd.longValue();
    }
    
    static BigInteger powMod(BigInteger a, long p){
        if(p <= 1) return p == 1 ? a.mod(M):BigInteger.ONE;
        if(p % 2 == 0) return powMod(a.multiply(a).mod(M), p/2).mod(M);
        return a.multiply(powMod(a.multiply(a).mod(M), p/2)).mod(M);
    }
    
    static HashSet<BigInteger> getPrimes(int n){
        boolean[] isP = new boolean[n+1];
        HashSet<BigInteger> p = new HashSet();
        if(n > 1) p.add(BigInteger.valueOf(2L));
        int i = 3;
        while(i <= n){
            p.add(BigInteger.valueOf((long)i));
            for(int j = i*2; j <= n; j+=i) isP[j] = true;
            do{i+=2;}while(i <= n && isP[i]);
        }
        return p;
    }
    
    static long g(long m, long n, long p){
        long s = 0;
        while(m >= p && n >= p){
            s += (n/p)*(m/p);
            m /= p;
            n /= p;
        }
        return s;
    }
}