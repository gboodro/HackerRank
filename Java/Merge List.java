// https://www.hackerrank.com/contests/infinitum9/challenges/merge-list

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int max = 101, t = in.nextInt();
        long[][] c = new long[max][max];
        for(int i = 0; i < max; i++){
            c[0][i] = 1;
            c[i][0] = 1;
        }
        for(int i = 1; i < max; i++){
            for(int j = 1; j < max; j++){
                c[i][j] = (c[i-1][j] + c[i][j-1]) % 1000000007;
            }
        }
        for(;t-->0;) System.out.println(c[in.nextInt()][in.nextInt()]);
    }
}