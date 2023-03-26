// https://www.hackerrank.com/contests/projecteuler/challenges/euler031

import java.util.*;
class Solution{
    static long[][] w = new long[100001][8];
    static int[] a = {1, 2, 5, 10, 20, 50, 100, 200};
    public static void main(String[] args){
        new Solution();
    }
    Solution(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(;n-->0;)System.out.println(f(in.nextInt()));
    }
    long f(int n){
        for(int i = 0; i < a.length; i++) if(a[i] > n) 
            return w(n, i-1);
        return w(n, a.length-1);
    }
    long w(int n, int m){
        if(n < a[m]) return n <= 1 ? 1:f(n);
        else if(w[n][m] == 0){
            for(int i = 0; i <= m; i++){
                w[n][m] += w(n-a[i], i);
                w[n][m] %= 1000000007;
            }
        }
        return w[n][m];
    }
}