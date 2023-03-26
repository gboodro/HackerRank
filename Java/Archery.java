// https://www.hackerrank.com/contests/quora-haqathon/challenges/archery

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] r = new long[2000000];
        for(int i = 0; i < n; i++) r[in.nextInt()]++;
        int m = in.nextInt();
        long[] c = new long[2000000];
        for(int i = 0; i < m; i++){
            double x1 = in.nextInt();
            double y1 = in.nextInt();
            double x2 = in.nextInt();
            double y2 = in.nextInt();
            double r1 = Math.sqrt(x1*x1 + y1*y1);
            double r2 = Math.sqrt(x2*x2 + y2*y2);
            double minR = Math.min(r1, r2);
            double maxR = Math.max(r1, r2);
            c[ceil(minR)]++;
            c[ceil(maxR)]--;
        }
        long cur = 0;
        long sum = 0;
        for(int i = 0; i < c.length; i++){
            cur += c[i];
            sum += cur * r[i];
        }
        System.out.println(sum);
    }
    static int ceil(double d){
        return (int) d + ((int)d != d ? 1 : 0); 
    }
}