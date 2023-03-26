// https://www.hackerrank.com/challenges/count-luck

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	static HashMap<Character, Integer> map = new HashMap();
    public static void main(String[] args) {
        map.put('M', 0);
        map.put('*', 1);
        map.put('X', 2);
        map.put('.', 3);
        Scanner in = new Scanner(System.in).useDelimiter("\n");
        int t = Integer.parseInt(in.next());
        for(int i = 0; i < t; i++){
            String[] nums = in.next().split(" ");
            int n = Integer.parseInt(nums[0]);
            int m = Integer.parseInt(nums[1]);
            int[][] b = new int[n][m];
            
            for(int j = 0; j < n; j++) b[j] = val(in.next().toCharArray());
            int k = Integer.parseInt(in.next());
            System.out.println(f(b, k));
        }
    }
    
    private static int[] val(char[] v){
        int[] b = new int[v.length];
        for(int i = 0; i < b.length; i++) b[i] = map.get(v[i]);
        return b;
    }
    
    private static String f(int[][] b, int k){
        int[] curPos = getPos(b);
        int val = dfs(b, curPos[0], curPos[1], 0, new boolean[b.length][b[0].length])[0];
        return  val == k ? "Impressed":"Oops!";
    }
    
    private static int[] dfs(int[][] b, int cx, int cy, int ct, boolean[][] used){
        if(b[cx][cy] == 1){
            return new int[] {ct, 1};
        }else{
            used[cx][cy] = true;
            int[][] poss = getPoss(b, cx, cy, used);
            if(poss.length == 0){
                return new int[] {0, 0};
            }else if(poss.length == 1){
                return dfs(b, poss[0][0], poss[0][1], ct, used);
            }else{
                for(int i = 0; i < poss.length; i++){
                    int[] cur = dfs(b, poss[i][0], poss[i][1], ct+1, used);
                    if(cur[1] == 1) return cur;
                }
                return new int[] {0, 0};
            }
        }
    }
    
    private static int[][] getPoss(int[][] b, int cx, int cy, boolean[][] used){
        HashSet<int[]> p = new HashSet();
        if(cx > 0 && !used[cx-1][cy] && b[cx-1][cy] != 2) p.add(new int[] {cx-1, cy});
        if(cx < b.length-1 && !used[cx+1][cy] && b[cx+1][cy] != 2) p.add(new int[] {cx+1, cy});
        if(cy > 0 && !used[cx][cy-1] && b[cx][cy-1] != 2) p.add(new int[] {cx, cy-1});
        if(cy < b[cx].length-1 && !used[cx][cy+1] && b[cx][cy+1] != 2) p.add(new int[] {cx, cy+1});
        int[][] P = new int[p.size()][];
        int i = 0;
        for(int[] a:p){
            P[i] = a;
            i++;
        }
        return P;
    }
    
    private static int[] getPos(int[][] b){
        for(int i = 0; i < b.length; i++)
            for(int j = 0; j < b[i].length; j++)
            if(b[i][j] == 0) return new int[] {i, j};
        return new int[] {0, 0};
    }
}
