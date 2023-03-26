// https://www.hackerrank.com/challenges/game-of-throne-ii

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String t = in.next();
        System.out.println(good(t));
    }
    
    static int[] primes;
    private static int H(int n, int a) {
        int c = 0;
        int p = a;
        while(p <= n){
            c += n / p;
            p *= a;
        }
        return c;
    }

    private static long modPow(int a, int n, long m) {
        if(n == 0) return 1;
        if(n == 1) return a;
        long t = modPow(a, n/2, m);
        return (((t*t)%m)*(n % 2 == 0 ? 1 : a))%m; 
    }
    
    private static long good(String t){
        int[] check = new int[26];
        for(int i = 0; i < t.length(); i++){
            check[(int)(t.charAt(i))-97]++;
        }
        int count = 0;
        for(int i = 0; i < check.length; i++){
            if(check[i] % 2 == 1){
                count++;
            }
            check[i]/=2;
        }
        primes = getPrimes(sum(check)+1);
        return count < 2 ? prodMod(reduce(H(sum(check)), check), 1000000007l) : 0;
    }
    
    private static long prodMod(int[] t, long m){
        long p = 1;
        for(int i = 0; i < t.length; i++){
            p = (p * modPow(primes[i], t[i], m)) % m;
        }
        return p;
    }
    
    private static int[] reduce(int[] num, int[] den){
        for(int i = 0; i < den.length; i++){
            if(den[i] > 1){
                num = reduce1(num, H(den[i]));
            }
        }
        return num;
    }
    
    private static int[] H(int n){
        int j = 0;
        while(j < primes.length && primes[j] <= n) j++;
        int[] h = new int[j];
        for(int i = 0; i < h.length; i++){
            h[i] = H(n, primes[i]);
        }
        return h;
    }
    
    private static int[] reduce1(int[] num, int[] den){
        for(int i = 0; i < den.length; i++){
            num[i] -= den[i];
        }
        return num;
    }
    
    private static int sum(int[] t){
        int s = 0;
        for(int i = 0; i < t.length; i ++){
            s += t[i];
        }
        return s;
    }
    
    private static int[] getPrimes(int n){
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = i;
        }
        nums[1] = 0;
        int t = 2;
        while(t < n){
            for(int p = 2*nums[t]; p < n; p += nums[t]){
                nums[p] = 0;
            }
            do{
                t++;
            }while(t < n && nums[t] == 0);
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] != 0){
                count++;
            }
        }
        int[] prime = new int[count];
        count = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] != 0){
                prime[count] = i;
                count++;
            }
        }
        return prime;
    }
    
}