// https://www.hackerrank.com/contests/projecteuler/challenges/euler042

import java.util.*;
class Solution{
    public static void main(String... args){
        new Solution();
    }
    Solution(){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(;t-->0;)
            System.out.println(tri(in.nextLong()));
    }
    long tri(long t){
        long n = (long)Math.sqrt(2*t+1);
        return 2*t == n*(n+1) ? n : -1;
    }
}