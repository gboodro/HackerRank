// https://www.hackerrank.com/challenges/special-multiple

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap();
        HashSet<Integer> found = new HashSet();
        for(int i = 1; i <= 500; i++) found.add(i);
        LinkedList<String> nums = new LinkedList();
        nums.add("9");
        String cur;
        BigInteger curNum;
        boolean[] b = new boolean[501];
        while(!found.isEmpty()){
            cur = nums.remove();
            curNum = new BigInteger(cur);
            for(int i = 1; i < b.length; i++){
                if(!b[i] && curNum.mod(BigInteger.valueOf((long)i)).equals(BigInteger.ZERO)){
                    b[i] = true;
                    found.remove(i);
                    map.put(i, cur);
                }
            }
            nums.add(cur+"0");
            nums.add(cur+"9");
        }
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++) System.out.println(map.get(in.nextInt()));
    }
}