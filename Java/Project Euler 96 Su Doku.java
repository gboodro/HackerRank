// https://www.hackerrank.com/contests/projecteuler/challenges/euler096

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[][] grid;
    static HashSet<Integer>[] row, col;
    static HashSet<Integer>[][] box;
    static HashMap<Character, Integer> val = new HashMap();
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        box = new HashSet[3][3];
        row = new HashSet[9];
        col = new HashSet[9];
        char[] chs = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for(int i = 0; i < chs.length; i++) 
            val.put(chs[i], i);
        grid = new int[9][];
        for(int i = 0; i < grid.length; i++)
            grid[i] = intArr(in.next().toCharArray());
        
        
        
        for(int i = 0; i < box.length; i++){
            for(int j = 0; j < box[i].length; j++){
                box[i][j] = new HashSet();
                for(int k = 1; k <= 9; k++) box[i][j].add(k);
            }
        }
        
        for(int i = 0; i < row.length; i++){
            row[i] = new HashSet();
            for(int k = 1; k <= 9; k++) row[i].add(k);
        }
        
        for(int i = 0; i < col.length; i++){
            col[i] = new HashSet();
            for(int k = 1; k <= 9; k++) col[i].add(k);
        }
        
        removeInit();
        dfs(0, 0);
        
    }

    static private void removeInit() {
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[i].length; j++)
                if(grid[i][j] != 0){
                    row[i].remove(grid[i][j]);
                    col[j].remove(grid[i][j]);
                    box[i/3][j/3].remove(grid[i][j]);
                }
    }
    
    static private void dfs(int curX, int curY){
        if(curX == grid.length){
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[i].length; j++){
                    System.out.print(grid[i][j]);
                }
                System.out.println();
            } 
            System.exit(0);
        }else if(curY == grid[curX].length){
            dfs(curX+1, 0);
        }else if(grid[curX][curY] == 0){
            HashSet<Integer> poss = intersection(intersection(row[curX], col[curY]), box[curX/3][curY/3]);
            for(int cur:poss){
                row[curX].remove(cur);
                col[curY].remove(cur);
                box[curX/3][curY/3].remove(cur);
                grid[curX][curY] = cur;
                dfs(curX, curY+1);
                row[curX].add(cur);
                col[curY].add(cur);
                grid[curX][curY] = 0;
                box[curX/3][curY/3].add(cur);
            }
        }else{
            dfs(curX, curY+1);
        }
    }
    
    static private HashSet<Integer> intersection(HashSet<Integer> a, HashSet<Integer> b){
        HashSet<Integer> c = new HashSet();
        for(int d:a) if(b.contains(d)) c.add(d);
        return c;
    }

    static private int[] intArr(char[] s) {
        int[] arr = new int[s.length];
        for(int i = 0; i < arr.length; i++) 
            arr[i] = val.get(s[i]);
        return arr;
    }
}