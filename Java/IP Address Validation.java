// https://www.hackerrank.com/challenges/ip-address-validation

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        for(int i = 0; i < n; i++){
            System.out.println(categorize(in.readLine()));
        }
    }
    
    private static String categorize(String t){
        if(t.contains(":") && isIPv6(t.split(":")))
            return "IPv6";
        else if(isIPv4(t.split("\\.")))
            return "IPv4";
        else
            return "Neither";
    }
    
    private static boolean isHex(String t){
        return t.matches("[\\da-f][\\da-f][\\da-f][\\da-f]") ||
               t.matches("[\\da-f][\\da-f][\\da-f]") ||
               t.matches("[\\da-f][\\da-f]") ||
               t.matches("[\\da-f]");
    }
    
    private static boolean isByte(String t){
        return t.matches("[12]\\d\\d") ||
               t.matches("\\d\\d") ||
               t.matches("\\d");
    }
    
    private static boolean isIPv6(String[] t){
        if(t.length == 8){
            for(String sect:t)
                if(!isHex(sect)) 
                    return false;
            return true;
        }
        return false;
    }
    
    private static boolean isIPv4(String[] t){
        if(t.length == 4){
            for(String a:t)
                if(!isByte(a)) 
                    return false;
            return true;
        }
        return false;
    }
}