// https://www.hackerrank.com/contests/projecteuler/challenges/euler009

import java.util.*;
class Solution{
    public static void main(String[] args){
        long[] max = new long[3001];
        for(int i = 0; i < max.length; i++) 
            max[i] = -1;
        for(int c = 1; c*2 < max.length; c++){
            for(int b = c-1; b*b*2 >= c*c; b--){
                int a = (int) Math.sqrt(c*c-b*b);
                if(a*a + b*b == c*c && a+b+c < max.length)
                    max[a+b+c] = Math.max(max[a+b+c], (long)a*b*c);
            }
        }
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++)
            System.out.println(max[in.nextInt()]);
    }                                  
}