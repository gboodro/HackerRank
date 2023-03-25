//https://www.hackerrank.com/challenges/java-string-tokens

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        s = s.trim().replaceAll("[^A-Za-z\\s]", " ").replaceAll("\\s+", " ").replaceAll("\\s", "\n");
        System.out.println(s.length() == 0  || s == null ? "0" : s.split("\n").length + "\n" + s);
        scan.close();
    }
}