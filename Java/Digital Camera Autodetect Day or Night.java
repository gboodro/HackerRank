// https://www.hackerrank.com/challenges/digital-camera-day-or-night

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in).useDelimiter("\n");
        LinkedList<int[][]> rows = new LinkedList();
        while(in.hasNext()){
            String[] cur = in.next().split(" ");
            int[][] k = new int[cur.length][3];
            for(int i = 0; i < k.length; i++){
                String[] rgb = cur[i].split(",");
                for(int j = 0; j < k[i].length; j++){
                    k[i][j] = Integer.parseInt(rgb[j]);
                }
            }
            rows.add(k);
        }
        int[][][] colors = new int[rows.size()][][];
        for(int i = 0; i < colors.length; i++) colors[i] = rows.get(i);
        System.out.println(bestGuess(colors));
    }
     
    private static String bestGuess(int[][][] colors){
        long countNight = 0, countDay = 0;
        for(int i = 0; i < colors.length; i++){
            for(int j = 0; j < colors[i].length; j++){
                if(isDark(colors[i][j])) countNight++;
                else countDay++;
            }
        }
        return countNight > countDay ? "night":"day";
    }
    
    private static boolean isDark(int[] rgb){
        return rgb[0] + rgb[1] + rgb[2] < 200;
    }
    
}