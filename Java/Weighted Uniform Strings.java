// https://www.hackerrank.com/contests/world-codesprint-9/challenges/weighted-uniform-string

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] s = in.next().toCharArray();
        int[] arr = new int[26];
        for(int i = 0; i < s.length; i++){
            int j = i;
            while(j+1 < s.length && s[j] == s[j+1])j++;
            arr[(int)(s[i] - 'a')] = Math.max(arr[(int)(s[i] - 'a')], j-i+1);
            i = j;
        }
        HashSet<Integer> U = new HashSet();
        for(int i = 0; i < arr.length; i++){
            for(int j = 1; j <= arr[i]; j++){
                U.add(j * (i+1));
            }
        }
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            System.out.println(U.contains(in.nextInt()) ? "Yes":"No");
        }
    }
}
