// https://www.hackerrank.com/contests/w9/challenges/lexicographic-steps

import java.util.*;
class Solution{
    long[][] ways;
    public static void main(String... args){new Solution();}
    Solution(){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(;t-->0;){
            int m = in.nextInt(), n = in.nextInt();
            ways = new long[n+1][m+1];
            ways[ways.length-1][ways[0].length-1] = 1;
            System.out.println(lex(in.nextLong()));
        }
    }
    String lex(long k){
        String s = "";
        int i = 0, j = 0;
        while(i+1 < ways.length && j+1 < ways[0].length){
            if(k >= ways(i,j+1)){
                s += "V";
                k -= ways(i, j+1);
                i++;
            }else{
                s += "H";
                j++;
            }
        }
        
        while(++i < ways.length){
            s += "V";
        }
        
        while(++j < ways[0].length)
            s += "H";
        
        return s;
    }
    long ways(int i, int j){
        if(i < ways.length && j < ways[i].length){
            if(ways[i][j] == 0) ways[i][j] = ways(i+1, j) + ways(i, j+1);
            return ways[i][j];
        }
        return 0;
    }
}