// https://www.hackerrank.com/contests/gamathon-july14/challenges/peg-solitaire

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        startTime = System.currentTimeMillis();
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(), n = in.nextInt();
        board = new int[n][m];
        for(int i = 0; i < board.length; i++)
            board[i] = intArr(in.next());         
        go("", 0);
        System.out.println(maxMoves + maxMove);
    }
  
    static long startTime;
    static int[][] board;
    static String maxMove = "";
    static int maxMoves = 0;
    static int initPegs = 0;
    static int[][] poss = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static String[] mov = {"LEFT", "RIGHT", "DOWN", "UP"};
    
    private static int[] intArr(String t){
        int[] a = new int[t.length()];
        for(int i = 0; i < a.length; i++)
            a[i] = intVal(t.charAt(i));
        return a;
    }
    
    private static boolean canGo(int i, int j, int di, int dj) {
       return i+2*di > 0 && j+2*dj > 0 && i+2*di < board.length && j+2*dj < board[0].length && board[i+di][j+dj] == 1 && board[i+2*di][j+2*dj] == 0;
    }
    
    private static void go(String move, int moves){
        if(moves > maxMoves){
            maxMoves = moves;
            maxMove = move;
        }
        if(System.currentTimeMillis() - startTime > 3500){
            System.out.println(maxMoves + maxMove);
            System.exit(0);
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 1){
                    for(int k = 0; k < poss.length; k++){
                        int di = poss[k][0], dj = poss[k][1];
                        if(canGo(i, j, di, dj)){
                            board[i][j] = 0;
                            board[i+di][j+dj] = 0;
                            board[i+2*di][j+2*dj] = 1;
                            go(move + "\n" + i + " " + j + " "+ mov[k], moves+1);
                            board[i][j] = 1;
                            board[i+di][j+dj] = 1;
                            board[i+2*di][j+2*dj] = 0;
                        }
                    }
                }
            }
        }
    }
    
    private static int intVal(char a){
        if(a == '-') return 0;
        if(a == '.') return 1;
        return 2;
    }
}