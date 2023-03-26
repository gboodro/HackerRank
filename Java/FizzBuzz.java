// https://www.hackerrank.com/challenges/fizzbuzz

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        int i = 1;
        String v;
        while(i < 101){
            v = (i % 3 == 0 ? "Fizz":"") + (i % 5 == 0 ? "Buzz":"");
            System.out.println(v.equals("") ? i : v);
            i++;
        }
    }
    
}