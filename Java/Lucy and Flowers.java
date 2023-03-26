// https://www.hackerrank.com/contests/w4/challenges/lucy-and-flowers

import java.util.*;
class Solution{
    long[] mem = new long[5001];
    long m = 1000000009;
    public static void main(String[] args){
        new Solution();
    }
    Solution(){
        mem[0]=1;
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(;t-->0;)System.out.println((f(in.nextInt())+1000000008)%m);
    }
    long f(int n){
        if(mem[n] != 0)return mem[n];
        long s = 1;
        for(int i = 0; i < n; i++){
            s += f(i)*f(n-i-1);
            s%=m;
        }
        mem[n] = s;
        return s;
    }
}