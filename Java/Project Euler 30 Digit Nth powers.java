// https://www.hackerrank.com/contests/projecteuler/challenges/euler030

import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] pows = new long[10];
        for(int i = 0; i < pows.length; i++)
            pows[i] = (long)Math.pow(i, n);
        long sum = 0;
        int max = 150000000;
        int last = 0;
        for(int i = 10; i <= max; i++){
            long c = 0;
            long a = i;
            while(a >= 10){
                c += pows[(int)(a%10)];
                a /= 10;
            }
            c += pows[(int)a];
            if(c == i){ 
                sum += i;
                last = i;
            }
        }
        System.out.println(sum);
    }
}