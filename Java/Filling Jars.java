// https://www.hackerrank.com/challenges/filling-jars

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        BigInteger total = BigInteger.ZERO;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long m = in.nextLong();
        BigInteger M = BigInteger.valueOf(n);
        for(int i = 0; i < m; i++){
            BigInteger a = BigInteger.valueOf(in.nextLong());
            BigInteger b = BigInteger.valueOf(in.nextLong()+1);
            BigInteger k = BigInteger.valueOf(in.nextLong());
            total = total.add(k.multiply(b.subtract(a)));
        }
        System.out.println(total.divide(M));
    }
}