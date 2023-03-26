// https://www.hackerrank.com/challenges/journey-to-the-moon

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer>[] country = new ArrayList[n];
        int[] minIndex = new int[n];
        for(int i = 0; i < minIndex.length; i++) minIndex[i] = -1;
        for(int i = 0; i < country.length; i++){
            country[i] = new ArrayList();
            country[i].add(i);
            minIndex[i] = i;
        }
        int lines = in.nextInt();
        int a, b, min, max, minB, tem;
        String temp;
        boolean good;
        for(int w = 0; w < lines; w++){
            a = in.nextInt();
            b = in.nextInt();
            if(minIndex[a] < minIndex[b]){
                minB = minIndex[b];
                while(!country[minB].isEmpty()){
                    tem = country[minB].remove(0);
                    minIndex[tem] = minIndex[a];
                    country[minIndex[a]].add(tem);
                }
            }else if(minIndex[b] < minIndex[a]){
                minB = minIndex[a];
                while(!country[minB].isEmpty()){
                    tem = country[minB].remove(0);
                    minIndex[tem] = minIndex[b];
                    country[minIndex[b]].add(tem);
                }
            }
        }
        int c = 0;
        for(int i = 0; i < country.length; i++){
            if(country[i].size()>0) c++;
        }
        int[] k = new int[c];
        c = 0;
        for(int i = 0; i < country.length; i++){
            if(country[i].size() > 0) {
                k[c] = country[i].size();
                c++;
            }
        }
        System.out.println(choose(k));
    }
    
    private static BigInteger choose(int[] n){
        BigInteger sum = BigInteger.ZERO;
        for(int i = 1; i < n.length; i++){
            sum = sum.add(BigInteger.valueOf(n[i]));
        }
        BigInteger s = BigInteger.ZERO;
        for(int i = 0; i < n.length-1; i++){
            s = s.add(sum.multiply(BigInteger.valueOf(n[i])));
            sum = sum.subtract(BigInteger.valueOf(n[i+1]));
        }
        return s;
    }
}