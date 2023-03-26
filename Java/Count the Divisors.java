// https://www.hackerrank.com/contests/segfault/challenges/count-the-divisors

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         int n = in.nextInt();
         int result = (int)Math.sqrt(n) * (int) Math.sqrt(n) == n ? 1:0;
         
         int j = 1;
         while(j*j < n){
           if(n%j == 0){
             result = result + 1;
             int other = n/j;
             result = result + 1;
           }
           j++;
         }
         
         System.out.print(result);
    }
}
