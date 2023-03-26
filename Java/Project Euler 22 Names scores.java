// https://www.hackerrank.com/contests/projecteuler/challenges/euler022

import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] names = new String[in.nextInt()];
        for(int i = 0; i < names.length; i++)names[i] = in.next();
        Arrays.sort(names);
        HashMap<String, Integer> map = new HashMap();
        for(int i = 0; i < names.length; i++){
            map.put(names[i], (i+1)*nameScore(names[i].toCharArray()));
        }
        int q = in.nextInt();
        for(;q-->0;)System.out.println(map.get(in.next()));
    }
    static int nameScore(char[] s){
        int sc = 0;
        for(char c:s) sc += (int)c-64;
        return sc;
    }
}