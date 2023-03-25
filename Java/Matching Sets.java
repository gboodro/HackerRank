// https://www.hackerrank.com/contests/w22/challenges/box-moving

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] X = new int[n], Y = new int[n];
        long sumX = 0, sumY = 0;
        for(int i = 0; i < X.length; i++){
            X[i] = in.nextInt();
            sumX += X[i];
        }
        for(int i = 0; i < Y.length; i++){
            Y[i] = in.nextInt();
            sumY += Y[i];
        }
        if(sumX != sumY){
            System.out.println(-1);
            System.exit(0);
        }
        Arrays.sort(X);
        Arrays.sort(Y);
        long ops = 0;
        for(int i = 0; i < X.length; i++){
            if(X[i] > Y[i]){
                ops += X[i] - Y[i];
            }
        }
        System.out.println(ops);
    }
}