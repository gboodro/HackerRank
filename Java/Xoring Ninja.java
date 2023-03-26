// https://www.hackerrank.com/challenges/xoring-ninja

import java.math.BigInteger;
import java.util.*;

public class Solution {
    static long[] fact;
    static long[] ifact;    
    public static void main(String[] args) {
        int n = 100001;
        fact = new long[n];
        ifact = new long[n];
        fact[0] = 1;
        ifact[0] = 1;
        long m = 1000000007;
        BigInteger M = BigInteger.valueOf(m);
        for(int i = 1; i < fact.length; i++){
            fact[i] = (fact[i-1] * i) % m;
            ifact[i] = (ifact[i-1] * BigInteger.valueOf(i).modInverse(M).longValue()) % m;
        }
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int[] a = new int[in.nextInt()];
            for (int j = 0; j < a.length; j++) {
                a[j] = in.nextInt();
            }
            System.out.println(f(a));
        }
    }

    private static long f(int[] a) {
        long s = 0, m = 1000000007, p = 1;
        while (!good(a)) {
            int[] ct = new int[2];
            for (int i = 0; i < a.length; i++) {
                ct[a[i] % 2]++;
                a[i] /= 2;
            }
            s += ((p * powMod(2, ct[0], m)) % m * sumBin(ct[1], m)) % m;
            p *= 2;
            p %= m;
          	s %= m;
        }
        return s;
    }

    private static long powMod(long a, long p, long m) {
        if (p < 2) {
            return p == 0 ? 1 : a;
        }
        long v = powMod(a, p / 2, m);
        v *= v;
        v %= m;
        return p % 2 == 0 ? v : (v * a) % m;
    }

    private static long sumBin(int n, long m) {
        long s = 0;
        for (int i = 1; i <= n; i += 2) {
            s += binom(n, i, m);
            s %= m;
        }
        return s;
    }

    private static long binom(int n, int k, long m) {
        return ((fact[n] * ifact[k]) % m * ifact[n - k]) % m;
    }

    private static boolean good(int... arr) {
        for (int a : arr) {
            if (a != 0) {
                return false;
            }
        }
        return true;
    }
}
