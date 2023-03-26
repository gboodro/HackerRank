// https://www.hackerrank.com/contests/february-real-data/challenges/matching-questions-answers

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static HashMap<String, String> sol = new HashMap();
    public static void main(String[] args){
        Scanner in = new Scanner(System.in).useDelimiter("\n");
        String[] text = in.next().split("\\.");
        String[] qu = new String[5];
        for(int i = 0; i < 5; i++) qu[i] = in.next();
        HashSet<String> answers = set(in.next().split(";"));
        f(text, set(qu), answers);
        for(String q:qu) System.out.println(sol.get(q));
    }
    
    private static void f(String[] te, HashSet<String> qu, HashSet<String> an){
        if(!qu.isEmpty()){
            String bestAns = "", bestQuestion = "";
            double bestScore = 0;
            for(String q:qu){
                for(String a:an){
                	double curScore = 0;
                    for(String t:te){
                        curScore = Math.max(curScore, score(set(t.split(" ")), set(q.split(" ")), set(a.split(" "))));
                    }
                    if(curScore > bestScore){
                        bestScore = curScore;
                        bestAns = a;
                        bestQuestion = q;
                    }
                }
            }
            sol.put(bestQuestion, bestAns);
            qu.remove(bestQuestion);
            an.remove(bestAns);
            f(te, qu, an);
        }
    }
    
    private static double score(HashSet<String> t, HashSet<String> qu, HashSet<String> an){
        double score = 0;
        for(String q:qu){
            if(t.contains(q)) score += an.contains(q) ? 3 : 1;
        }
        for(String a:an){
            if(t.contains(a) && !qu.contains(a)) score += 2;
        }
        return Math.pow(score, 1);
    }
    
    private static HashSet<String> set(String[] arr){
        HashSet<String> s = new HashSet();
        for(String a:arr) s.add(a);
        return s;
    }
}