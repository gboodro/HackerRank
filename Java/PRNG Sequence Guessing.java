// https://www.hackerrank.com/challenges/prng-sequence-guessing

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
            long a = in.nextLong(), b = in.nextLong();
            int[] n = new int[10];
            for(int j = 0; j < n.length; j++) n[j] = in.nextInt();
            f(a, b, n);
        }
    }
    
    private static void f(long a, long b, int[] k){
        Random g;
        boolean good;
        do{
            g = new Random(a);
            good = true;
            for(int num:k) if(num != g.nextInt(1000)){
                good = false;
                break;
            }
            a++;
        }while(a <= b && !good);
        String guess = a-1+" ";
        for(int i = 0; i < 10; i++) guess += g.nextInt(1000)+" ";
        System.out.println(guess.trim());
    }
}