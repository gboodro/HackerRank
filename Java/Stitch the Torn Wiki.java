// https://www.hackerrank.com/challenges/stitch-the-torn-wiki

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static HashMap<String, Integer>[] mapA, mapB;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] A = new String[n], B = new String[n];
        for(int i = 0; i < n; i++) A[i] = in.readLine();
        String split = in.readLine();
        for(int i = 0; i < n; i++) B[i] = in.readLine();
        makeMapA(A);
        makeMapB(B);
        print(chooseAll());
    }
    
    private static void print(int[] a){
        for(int b:a) System.out.println(b);
    }
    
    private static void makeMapA(String[] A){
        mapA = new HashMap[A.length];
        for(int i = 0; i < A.length; i++){
            mapA[i] = getMap(A[i].split(" "));
        }
    }
    
    private static void makeMapB(String[] B){
        mapB = new HashMap[B.length];
        for(int i = 0; i < B.length; i++){
            mapB[i] = getMap(B[i].split(" "));
        }
    }
    
    private static HashMap<String, Integer> getMap(String[] t){
        HashMap<String, Integer> curMap = new HashMap();
        for(String cur:t){
            if(curMap.containsKey(cur))
                curMap.put(cur, curMap.get(cur)+1);
            else
                curMap.put(cur, 1);
        }
        return curMap;
    }
    
    private static int[] chooseAll(){
        boolean[] hitA = new boolean[mapA.length], hitB = new boolean[mapB.length];
        int[] best = new int[mapA.length], cur;
        for(int i = 0; i < mapA.length; i++){
            cur = getBest(hitA, hitB);
            best[cur[0]] = cur[1]+1;
            hitA[cur[0]] = true;
            hitB[cur[1]] = true;
        }
        return best;
    }
    
    private static int[] getBest(boolean[] ha, boolean[] hb){
        double score, maxScore = 0.0;
        int[] bestMatch = new int[] {-1, -1};
        for(int i = 0; i < ha.length; i++){
            if(!ha[i]){
                for(int j = 0; j < hb.length; j++){
                    if(!hb[j]){
                        score = getScore(mapA[i], mapB[j]);
                        if(score > maxScore){
                            maxScore = score;
                            bestMatch = new int[] {i, j};
                        }
                    }
                }
            }
        }
        return bestMatch;
    }
    
    private static double getScore(HashMap<String, Integer> a, HashMap<String, Integer> b){
        double s = 0;
        Set<String> kA = a.keySet();
        for(String k:kA){
            if(b.containsKey(k) && k.length() > 0) s += fun(a.get(k), b.get(k), isUpper(k.charAt(0)));
        }
        return s;
    }
    
    private static double fun(int a, int b, boolean isUp){
        return (isUp ? 4:1) * Math.pow(a, .25)*Math.pow(b, .25);
    }
    
    private static boolean isUpper(char i){
        return i >= 'A' && i <= 'Z';
    }
}