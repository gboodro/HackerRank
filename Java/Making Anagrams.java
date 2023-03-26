// https://www.hackerrank.com/challenges/making-anagrams

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in).useDelimiter("\n");
        String a = in.next(), b = in.next();
        System.out.println(del(a.toCharArray(), b.toCharArray()));
    }
    
    private static long del(char[] a, char[] b){
        int[] A = new int[26], B = new int[26];
        for(char t:a) A[(int)t-97]++;
        for(char t:b) B[(int)t-97]++;
        long count = 0;
        for(int i = 0; i < A.length; i++){
            count += Math.abs(A[i]-B[i]);
        }
        return count;
    }
}