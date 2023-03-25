// https://www.hackerrank.com/contests/world-codesprint-9/challenges/grading

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            int grade = in.nextInt();
            System.out.println((grade > 37 && grade % 5 > 2) ? (grade+2)/5*5:grade);
        }
    }
}