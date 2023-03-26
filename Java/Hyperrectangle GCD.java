// https://www.hackerrank.com/challenges/hyperrectangle-gcd

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
  
    public static void main(String[]args){
        long m = 1000000007;
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int j = 0; j < t; j++){
            int k = in.nextInt();
            int[] n = new int[k];
            int max = 100000;
            for(int i = 0; i < k; i++){
                n[i] = in.nextInt();
                if(n[i] < max) max = n[i];
            }
            long[] res = new long[max+1];
            for(int d = max; d > 0; d--){
                long mul = 1;
                for(int i=0; i < k; i++){
                    mul *= (n[i]/d);
                    mul %= m;
                }
                res[d] = mul;
                for(int z = 2; z*d <= max; z++){
                    res[d] -= res[z*d];
                    if(res[d] < 0) res[d] += m;
                }
            }
            long s = 0;
            for(int d = max; d > 0; d--){
                s += res[d]*d;
                s %= m;
            }
            System.out.println(s);
        }
    }
}