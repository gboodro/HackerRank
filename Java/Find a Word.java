// https://www.hackerrank.com/challenges/find-a-word

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] strs = new String[n];
        for(int i = 0; i < n; i++){
            strs[i] = in.readLine();
        }
        int t = Integer.parseInt(in.readLine());
        String[] ts = new String[t];
        for(int j = 0; j < t; j++)
            ts[j] = in.readLine();
        int count;
        for(String curT:ts){
            count = 0;
            for(String cur:strs)
                count += numOcc(cur, Pattern.compile("\\b" + curT + "\\b"));
            System.out.println(count);
        }
    }
    
    private static int numOcc(String cur, Pattern p){
        //not (letter, number, or underscore) word (not letter, number, or underscore);
        //[_[a-zA-Z[0-9]]]word[_[a-zA-Z[0-9]]];
        Matcher m = p.matcher(cur);
        int count = 0;
        while(m.find()) count++;
        return count;
    }
}