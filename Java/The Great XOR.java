// https://www.hackerrank.com/contests/w28/challenges/the-great-xor

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            long x = in.nextLong();
            long sum = 0;
            long pow = 1;
            while(x > 0){
                if(x % 2 == 0){
                    sum += pow;
                }
                x /= 2;
                pow *= 2;
            }
            System.out.println(sum);
        }
    }
}