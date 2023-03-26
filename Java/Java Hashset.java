// https://www.hackerrank.com/challenges/java-hashset

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        HashSet<String> names = new HashSet();
        Scanner in = new Scanner(System.in).useDelimiter("\n");
        int t = Integer.parseInt(in.next().trim());
        for(;t-->0;){
            names.add(in.next());
            System.out.println(names.size());
        }
    }
}