// https://www.hackerrank.com/challenges/java-string-compare

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int k = in.nextInt();
        String min = s.substring(0, k);
        String max = min;
        String cur = min;
        for(int i = k; i < s.length(); i++){
            cur = cur.substring(1) + s.charAt(i);
            if(cur.compareTo(max)>0) max = cur;
            if(cur.compareTo(min)<0) min = cur;
        }
        System.out.println(min +"\n"+max);
    }
}