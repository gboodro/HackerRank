// https://www.hackerrank.com/challenges/board-cutting

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int n = in.nextInt(), m = in.nextInt();
            int[] y = new int[n-1], x = new int[m-1];
            for(int j = 0; j < y.length; j++) y[j] = in.nextInt();
            for(int j = 0; j < x.length; j++) x[j] = in.nextInt();
            System.out.println(min(y, x));
        }
    }
    
    private static long sum(int[] arr){
        long s = 0;
        for(int a:arr) s+= a;
        return s;
    }
    
    private static long min(int[] y, int[] x){
        Arrays.sort(y);
        Arrays.sort(x);
        int xInd = x.length-1, yInd = y.length-1;
        long cost = 0, m = 1000000007, cX = 1, cY = 1;
        while(xInd >= 0 && yInd >= 0){
            if(x[xInd] < y[yInd]){
                cost += cX * y[yInd];
                cY++;
                cost %= m;
                yInd--;
            }else if(x[xInd] > y[yInd]){
                cost += cY * x[xInd];
                cX++;
                cost %= m;
                xInd--;
            }else{
                if(cX > cY){
                    cost += cY * x[xInd];
                    cX++;
                    cost %= m;
                    xInd--;
                }else{
                    cost += cX * y[yInd];
                    cY++;
                    cost %= m;
                    yInd--;
                }
            }
        }
        while(xInd >= 0){
            cost += cY*x[xInd];
            cost %= m;
            xInd--;
        }
        while(yInd >= 0){
            cost += cX*y[yInd];
            cost %= m;
            yInd--;
        }
        return cost;
    }
    
}