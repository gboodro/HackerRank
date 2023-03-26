// https://www.hackerrank.com/challenges/period

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
            System.out.println(f(in.nextInt(), in.nextInt(), in.nextInt()));
        }
    }
    
    private static long f(long a, long b, long m){
        if(a == 0 && b == 0) return -1;
        else{
            long n = 1, c = a, d = b, pc, pd;
            while(c != 0 && d != 0 && n < m){
                pc = c;
                pd = d;
                c = (((a*pc) % m) + ((5*b*pd)%m)) % m;
                d = (((a*pd) % m) + ((b*pc)%m)) % m;
                n++;
            }
            if(n == m) return -1;
            if(c == 0){
                long g = gcd((5*d*d)%m, m);
                return g > 1 ? -1:per((5*d*d)%m, m)*n*2;
            }else if(c != 1){
                long g = gcd(c, m);
                return g > 1? -1:per(c%m, m)*n;
            }else return n;
        }
    }
    
    private static long gcd(long a, long b){
        return b == 0?a:gcd(b, a%b);
    }
    
    private static long per(long a, long m){
        long p = a, rep = 1;
        while(p != 1){
            rep++;
            p = (p*a)%m;
        }
        return rep;
    }
}