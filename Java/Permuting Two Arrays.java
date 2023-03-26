// https://www.hackerrank.com/challenges/two-arrays

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(), n, k;
        for(int i = 0; i < t; i++){
            n = in.nextInt();
            k = in.nextInt();
            int[] a = new int[n], b = new int[n];
            for(int j = 0; j < a.length; j++) a[j] = in.nextInt();
            for(int j = 0; j < b.length; j++) b[j] = in.nextInt();
            System.out.println(f(a, b, k));
        }
    }
    
    private static String f(int[] a, int[] b, int k){
        Arrays.sort(a);
        Arrays.sort(b);
        int[] c;
        int lastA, bInd;
        while(a.length > 0){
            lastA = a[a.length-1];
            c = new int[a.length-1];
            System.arraycopy(a, 0, c, 0, c.length);
            a = new int[c.length];
            System.arraycopy(c, 0, a, 0, a.length);
            bInd = 0;
            while(bInd < b.length && lastA+b[bInd] < k) bInd++;
            if(bInd == b.length){
                return "NO";
            }
            c = new int[b.length-1];
            System.arraycopy(b, 0, c, 0, bInd);
            for(int i = bInd+1; i < b.length; i++){
                c[i-1] = b[i];
            }
            b = new int[c.length];
            System.arraycopy(c, 0, b, 0, b.length);
            
        }
        return "YES";
    }
}