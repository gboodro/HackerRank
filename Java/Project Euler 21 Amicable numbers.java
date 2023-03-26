// https://www.hackerrank.com/contests/projecteuler/challenges/euler021

import java.util.*;
class Solution{
    public static void main(String[] args){
        int max = 500000;
        HashSet<Integer> p = getPrimes(max);
        long[] sig = new long[max];
        for(int i = 2; i < sig.length; i++)
            sig[i] = 1;
        for(int i :p){
            for(long j = i; j < sig.length; j*=i){
                for(int k = (int)j; k < sig.length; k+=(int)j){
                    if(k % (j*i) != 0)sig[k] *= (j*i-1)/(i-1);
                }
            }
        }
        for(int i = 2; i < sig.length; i++)
            sig[i] -= i;
        long[] sum = new long[max+1];
        for(int i = 2; i < sum.length; i++){
            sum[i] += sum[i-1];
            try{
                if(i == sig[(int)sig[i]] && sig[i] != i) sum[i] += i;
            }catch(ArrayIndexOutOfBoundsException e){}
        }
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(;t-->0;)System.out.println(sum[in.nextInt()-1]);
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