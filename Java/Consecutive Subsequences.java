// https://www.hackerrank.com/contests/w6/challenges/consecutive-subsequences

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for(;tests-->0;){
            int[] a = new int[in.nextInt()];
            int k = in.nextInt();
            for(int i = 0; i < a.length; i++) a[i] = in.nextInt() % k;
            long c = 0;
            int[][] ct = new int[a.length+1][k];
            for(int i = 0; i < a.length; i++){
                c += ct[i][0];
                ct[i+1][a[i]] = 1;
                for(int t = 0; t < k; t++){
                    ct[i+1][(a[i] + t) % k] += ct[i][t];
                }
            }
            System.out.println(c + ct[a.length][0]);
        }
    }
}