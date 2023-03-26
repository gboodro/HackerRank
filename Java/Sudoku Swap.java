// https://www.hackerrank.com/contests/w15/challenges/sudoku-swap

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }
    Solution(){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 1; i <= t; i++)
            System.out.println("Case #" + i + ":\n" + AllSols(getGrid(in)));
    }
    
    String AllSols(int[][] g){
        if(good(g)) return "Serendipity";
        String res = "";
        for(int i1 = 0; i1 < g.length; i1++){
            for(int j1 = 0; j1 < g[i1].length; j1++){
                for(int i2 = i1; i2 < g.length; i2++){
                    for(int j2 = i2 == i1 ? j1+1:0; j2 < g[i2].length; j2++){
                        if(g[i1][j1] != g[i2][j2]){
                            int temp = g[i1][j1];
                            g[i1][j1] = g[i2][j2];
                            g[i2][j2] = temp;
                            if(good(g)) res += "(" + (i1+1) + "," + (j1+1) + ") <-> (" + (i2+1) + "," + (j2+1) + ")\n";
                            g[i2][j2] = g[i1][j1];
                            g[i1][j1] = temp;
                        }
                    }
                }
            }
        }
        return res.substring(0, res.length()-1);
    }
    
    int[][] getGrid(Scanner in){
        int[][] g = new int[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                g[i][j] = in.nextInt();
            }
        }
        return g;
    }
    
    boolean good(int[][] g){
        //check rows
        HashSet<Integer> checkCol, checkRow;
        for(int i = 0; i < g.length; i++){
            checkCol = new HashSet();
            checkRow = new HashSet();
            for(int j = 0; j < 9; j++){
                checkCol.add(g[j][i]);
                checkRow.add(g[i][j]);
            }
            if(checkRow.size() < 9 || checkCol.size() < 9) return false;
        }        
        //check squs
        HashSet<Integer> checkSqu;
        for(int i1 = 0; i1 < 3; i1++)
            for(int j1 = 0; j1 < 3; j1++){
                checkSqu = new HashSet();
                for(int i2 = 0; i2 < 3; i2++){
                    for(int j2 = 0; j2 < 3; j2++){
                        checkSqu.add(g[i1*3 + i2][j1*3 + j2]);
                    }
                }
                if(checkSqu.size() < 9) return false;
            }
        return true;
    }
}