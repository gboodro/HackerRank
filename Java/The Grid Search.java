// https://www.hackerrank.com/contests/back2school14/challenges/the-grid-search

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        new Solution();   
    }
    Solution(){
        HashMap<Character, HashSet<String>> locMap = new HashMap();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(;t-->0;){
            for(char c = '0'; c <= '9'; c++)locMap.put(c, new HashSet());
            int R = in.nextInt(), C = in.nextInt();
            for(int r = 0; r < R; r++){
                char[] line = in.next().toCharArray();
                for(int c = 0; c < line.length; c++)
                    locMap.get(line[c]).add(r +" "+ c);
            }
            char[][] sub = new char[in.nextInt()][in.nextInt()];
            for(int i = 0; i < sub.length; i++)
                sub[i] = in.next().toCharArray();
            boolean good = false;
            for(String p:locMap.get(sub[0][0])){
                good = true;
                String[] spl = p.split(" ");
                int x = Integer.parseInt(spl[0]), y = Integer.parseInt(spl[1]);
                All:
                for(int i = 0; i < sub.length; i++){
                    for(int j = 1; j < sub[i].length; j++){
                        if(!locMap.get(sub[i][j]).contains((x + i) + " " + (y + j))){
                            good = false;
                            break All;
                        }
                    }
                }
                if(good) break;
            }
            System.out.println(good ? "YES":"NO");
        }
    }
}