// https://www.hackerrank.com/contests/projecteuler/challenges/euler089

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(;t-->0;){
            System.out.println(efficient(in.next()));
        }
    }

    static String efficient(String num){
        String temp = num;
        String ptemp;
        do{
            ptemp = temp;
            while(temp.contains("DD")) temp = temp.replaceAll("DD", "M");
            while(temp.contains("CCCCC")) temp = temp.replaceAll("CCCCC", "D");
            while(temp.contains("LL")) temp = temp.replaceAll("LL", "C");
            while(temp.contains("XXXXX")) temp = temp.replaceAll("XXXXX", "L");
            while(temp.contains("VV")) temp = temp.replaceAll("VV", "X");
            while(temp.contains("IIIII")) temp = temp.replaceAll("IIIII", "V");
            if(ptemp != temp) continue;
            temp = temp.replaceAll("MDM", "MD");
            temp = temp.replaceAll("DDD", "MD");
            temp = temp.replaceAll("DCD", "CM");
            temp = temp.replaceAll("CCCC", "CD");
            temp = temp.replaceAll("LXL", "XC");
            temp = temp.replaceAll("XXXX", "XL");
            temp = temp.replaceAll("VX", "V");
            temp = temp.replaceAll("VVV", "XV");
            temp = temp.replaceAll("VIV", "IX");
            temp = temp.replaceAll("IIII", "IV");
        }while(!temp.equals(ptemp));
        return temp;
    }
}
