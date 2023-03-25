// https://www.hackerrank.com/contests/round-2-holiday-cup/challenges/baby-monty-and-interview

import java.io.*;
import java.util.*;

public class Solution {
    HashSet<Integer>[] tree;
    public static void main(String[] args) {
        new Solution();
    }
    Solution(){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(;t-->0;){
            tree = new HashSet[in.nextInt() + 1];
            for(int j = 0; j < tree.length; j++)tree[j] = new HashSet();
            System.out.println(getPairs(getTree(in))[2]);
        }
    }
    int getTree(Scanner in){
        int root = -1;
        for(int j = 1; j < tree.length-1; j++){
            int a = in.nextInt(), b = in.nextInt();
            if(root == -1 || b == root) root = a;
            tree[a].add(b);
        }
        return root;
    }
    int[] getPairs(int cur){
        if(tree[cur].isEmpty()) 
            return new int[] {1, 0, 0};
        int[][] s = new int[tree[cur].size()][];
        int k = 0;
        for(int p : tree[cur])
            s[k++] = getPairs(p);
        int a = 1;
        int b = 0;
        int c = 0;
        int ap = 0;
        int bp = 0;
        for(int i = 0; i < s.length; i++){
            a += s[i][1];
            b += s[i][0];
            c += s[i][2] + s[i][1];
            c += ap*s[i][0];
            ap += s[i][0];
            c += bp*s[i][1];
            bp += s[i][1];
        }
        return new int[] {a, b, c};
    }
}