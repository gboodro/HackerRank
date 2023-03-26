// https://www.hackerrank.com/challenges/bday-gift

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        double v = 0;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            v += 0.5 * in.nextInt();
        }
        long floor = (long) Math.floor(v);
        if(floor < v){
            System.out.println(floor + ".5");
        }else{
            System.out.println(floor + ".0");
        }
    }
}