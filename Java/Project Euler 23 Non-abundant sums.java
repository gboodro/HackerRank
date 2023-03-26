// https://www.hackerrank.com/contests/projecteuler/challenges/euler023

import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();        
        HashSet<Integer> p = getPrimes((int)Math.sqrt(28123)+1);
        long[] sig = new long[28123];
        for(int i = 2; i < sig.length; i++)
            sig[i] = 1;
        for(int i :p){
            for(long j = i; j < sig.length; j*=i){
                for(int k = (int)j; k < sig.length; k+=(int)j){
                    if(k % (j*i) != 0)sig[k] *= (j*i-1)/(i-1);
                }
            }
        }
        HashSet<Integer> abuns = new HashSet();
        for(int i = 2; i < sig.length; i++){
            sig[i] -= i;
            if(sig[i] > i)abuns.add(i);
        }
        boolean[] nonSum = new boolean[sig.length*2+1];
        for(int i:abuns)
            for(int j : abuns)
                nonSum[i+j] = true;
        for(;t-->0;){
            int n = in.nextInt();
            System.out.println(n > 28123 || nonSum[n] ? "YES":"NO");
        }
    }
    static HashSet<Integer> getPrimes(int n){
        HashSet<Integer> p = new HashSet();
        p.add(2);
        int s = (int)Math.sqrt(n);
        boolean[] isP = new boolean[n+1];
        for(int i = 0; i <= n; i+=2) isP[i] = true;
        for(int i = 3; i <= s;){
            p.add(i);
            for(int j = 2*i; j < isP.length; j+=i) isP[j] = true;
            do{i+=2;}while(i <= s && isP[i]);
        }
        for(int i = s+1+s%2; i < isP.length; i+=2) if(!isP[i]) p.add(i);
        return p;
    }
}