// https://www.hackerrank.com/challenges/connecting-towns

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
            int n = in.nextInt()-1;
            long p = 1;
            for(int j = 0; j < n; j++) p = (p*in.nextInt())%1234567;
            System.out.println(p);
        }
    }
}