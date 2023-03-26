// https://www.hackerrank.com/contests/projecteuler/challenges/euler081

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[][] mat = new long[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                mat[i][j] = in.nextLong();
            }
        }
        for(int i = 1; i < n; i++){
            mat[0][i] += mat[0][i-1];
            mat[i][0] += mat[i-1][0];
        }
        for(int i = 1; i < n; i++){
            mat[i][i] += Math.min(mat[i-1][i], mat[i][i-1]);
            for(int j = i+1; j < n; j++){
                mat[i][j] += Math.min(mat[i-1][j], mat[i][j-1]);
                mat[j][i] += Math.min(mat[j-1][i], mat[j][i-1]);
            }
        }
        System.out.println(mat[n-1][n-1]);
    }
}