// https://www.hackerrank.com/challenges/red-john-is-back

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tC = in.nextInt();
        pr[0] = 1;
        pr[1] = 1;
        pr[2] = 1;
        pr[3] = 1;
        for(int i = 0; i < tC; i++){
            System.out.println(findP(in.nextInt()));
        }
    }
    
    static long[] pr = new long[41];
    private static int getPrimes(long n){
        n++;
        int[] nums = new int[(int)n];
        for(int i = 0; i < n; i++){
            nums[i] = i;
        }
        nums[1] = 0;
        int t = 2;
        while(t < n){
            for(int p = 2*nums[t]; p < n; p += nums[t]){
                nums[p] = 0;
            }
            do{
                t++;
            }while(t < n && nums[t] == 0);
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] != 0){
                count++;
            }
        }
        return count;
    }
    
    private static long findP(int n){
        return getPrimes(p(n));
    }
    
    private static long p(int n){
        if(pr[n] != 0) return pr[n];
        pr[n] = p(n-1) + p(n-4);
        return pr[n];
    }
}