// https://www.hackerrank.com/contests/projecteuler/challenges/euler044

import java.util.*;
class Solution{
    public static void main(String... args){
        new Solution();
    }
    HashSet<Long> p = new HashSet();
    Solution(){
        long[] pen = new long[1000000];
        for(int i = 0; i < pen.length; i++){
            pen[i] = pen(i);
            p.add(pen[i]);
        }
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        for(int a = k+1; a < n; a++){
            if(isPen(pen[a] + pen[a-k]) || isPen(pen[a] - pen[a-k]))
                System.out.println(pen[a]);
        }
    }
    boolean isPen(long n){
        return p.contains(n);
    }
    long pen(long n){
        return n*(3*n-1)/2;
    }
}