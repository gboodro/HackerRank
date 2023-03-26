// https://www.hackerrank.com/challenges/building-a-list

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static HashSet<String> lowest;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in).useDelimiter("\n");
        int t = Integer.parseInt(in.next());
        for(int i = 0; i < t; i++){
            lowest = new HashSet();
            int n = Integer.parseInt(in.next());
            comb(sort(in.next()));
            String[] sortLow = new String[lowest.size()];
            int j = 0;
            for(String a:lowest){
                sortLow[j] = a;
                j++;
            }
            Arrays.sort(sortLow);
            for(String a:sortLow) System.out.println(a);
        }
    } 
    
    private static String sort(String t){
        char[] cur = t.toCharArray();
        Arrays.sort(cur);
        t = "";
        for(char c:cur) t += c;
        return t;
    }
    
    private static void comb(String t){
        if(!t.isEmpty() && lowest.add(t)){
            for(int i = 0; i < t.length(); i++){
                comb(remove(t, i));
            }
        }
    }
    
    private static String remove(String t, int i){
        String m = "";
        for(int j = 0; j < t.length(); j++){
            if(i!=j) m+=t.charAt(j);
        }
        return m;
    }
}