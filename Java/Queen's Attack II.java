// https://www.hackerrank.com/contests/world-codesprint-9/challenges/queens-attack-2

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int right = n+1, left = 0, down = 0, up = n+1;
        int k = in.nextInt();
        int rQ = in.nextInt();
        int cQ = in.nextInt();
        int uprightRow = (rQ >= cQ) ? n+1 : rQ + n+1 - cQ;
        int downrightRow = (rQ <= n + 1 - cQ) ? 0 : rQ - (n+1 - cQ);
        int upleftRow = (rQ > n + 1 - cQ) ? n+1 : rQ + cQ;
        int downleftRow = (rQ <= cQ) ? 0 : rQ - cQ; 
        for(int a0 = 0; a0 < k; a0++){
            int rO = in.nextInt();
            int cO = in.nextInt();
            if(rO == rQ){
                if(cO < cQ){
                    left = Math.max(left, cO);
                }else{
                    right = Math.min(right, cO);    
                } 
            }else if(cO == cQ){
                if(rO < rQ){
                    down = Math.max(down, rO);
                }else{
                    up = Math.min(up, rO);    
                }
            }else if(rQ - rO == cQ - cO){//slope is 1
                if(rO < rQ){
                    downleftRow = Math.max(downleftRow, rO);
                }else{
                    uprightRow = Math.min(uprightRow, rO);    
                }
            }else if(rQ - rO == cO - cQ){//slope is -1
                if(rO < rQ){
                    downrightRow = Math.max(downrightRow, rO);
                }else{
                    upleftRow = Math.min(upleftRow, rO);    
                }
            }
        }
        System.out.println(up - rQ + rQ - down + cQ - left + right - cQ + rQ - downrightRow + rQ - downleftRow + upleftRow - rQ + uprightRow - rQ - 8);
    }
}
