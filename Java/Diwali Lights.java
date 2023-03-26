// https://www.hackerrank.com/challenges/diwali-lights

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        int[] twoPow = new int[10000];
        twoPow[0] = 1;
        for(int i = 1; i < twoPow.length; i++)
            twoPow[i] = (2*twoPow[i-1]) % 100000;
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++)
            System.out.println(twoPow[in.nextInt()]-1);
    }
    
}