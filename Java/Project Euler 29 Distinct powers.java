// https://www.hackerrank.com/contests/projecteuler/challenges/euler029

import java.util.*;
class Solution{
    static long[] value;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        setValues(n);
        boolean[] hit = new boolean[n+1];
        long i = 2;
        long sum = 0;
        while(i <= n){
            long c = i;
            int pow = 0;
            while(c <= n){
                pow++;
                hit[(int)c] = true;
                c *= i;
            }
            do{i+=1;}while(i<=n && hit[(int)i]);
            sum += value[pow];
        }        
        System.out.println(sum);
    }
    static void setValues(int n){
        value = new long[(int)(Math.log(n) / Math.log(2)) + 1];
        boolean[] hit = new boolean[value.length*n+1];
        long c = 0;
        for(int i = 1; i < value.length; i++){
            for(int j = 2; j <= n; j++){
                if(!hit[i*j]){
                    hit[i*j] = true;
                    c++;
                }
            }
            value[i] = c;
        }
    }
}