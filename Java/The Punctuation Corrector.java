// https://www.hackerrank.com/contests/nov13/challenges/punctuation-corrector-its

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String line, cur;
        for(int i = 0; i < n; i++){
            line = "";
            while(!line.endsWith(".") && !line.endsWith("!") && (line.endsWith("???") || !line.endsWith("?")) && in.hasNext()){
                line += " " + in.next();
            }
            System.out.println(fix(line.substring(1)));
        }
    }
    
    private static String fix(String t){
        if(t.startsWith("???")) t = "It's" + t.substring(3);
        if(t.startsWith("\"???")) t = "\"It's" + t.substring(4);
        String[] itIs = new String[] {"-", "\"", "\'", "so", "said", "Now", "now", ";", ",", "When", "when", "But", "but", "ly", "what", "What"};
        String[] its = new String[] {"than", " in", "In", "For", " for", "from", "From", "has", "Has", "ed", " of", "Of", "At", " at", "es"};
        for(String a: itIs){
            t = t.replaceAll(a+ " \\?\\?\\?", a + " it's");
        }
        //for(String a: its){
        //    t = t.replaceAll(a+ " \\?\\?\\?", a + " its");
        //}
        t = t.replaceAll("\\?\\?\\? a ", "it's a ");
        t = t.replaceAll("\\?\\?\\?", "its");
        return t;
    }
}