// https://www.hackerrank.com/challenges/game-of-thrones

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(f(in.next().toCharArray()));
    }
    
    private static String f(char[] arr){
        int[] ct = new int[26];
        for(char c:arr) ct[(int)c-97]++;
        int b = 0;
        for(int i :ct) b += i&1;
        return b < 2 ? "YES":"NO";
    }
}