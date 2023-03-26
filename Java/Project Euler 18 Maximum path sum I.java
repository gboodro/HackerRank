// https://www.hackerrank.com/contests/projecteuler/challenges/euler018

import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(;t-->0;){
            int n = in.nextInt();
            
                long[] c = {in.nextLong()};
                for(int i = 2; i <= n; i++){
                    long[] nc = new long[i];
                    nc[0] = c[0] + in.nextLong();
                    for(int j = 1; j < nc.length-1; j++) nc[j] = in.nextLong() + Math.max(c[j-1], c[j]);
                    nc[i-1] = in.nextLong() + c[i-2];
                    c = nc;
                    
                }
            
                long m = 0;
                for(long v : c)
                    m = Math.max(m, v);
                System.out.println(m);
            
        }
    }
}