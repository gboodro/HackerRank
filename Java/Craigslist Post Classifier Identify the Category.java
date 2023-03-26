// https://www.hackerrank.com/challenges/craigslist-post-classifier-the-category

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static HashMap<String, String[]> map = new HashMap();
    static HashMap<String, HashMap<String, Integer>> mCat = new HashMap();
    static HashMap<String, Integer> tMap = new HashMap();
    static Random g = new Random();
    public static void main(String[] args) {
        map.put("for-sale", new String[] {"appliances", "cell-phones", "video-games", "photography"});
        map.put("housing", new String[] {"housing", "shared", "wanted-housing", "temporary"});
        map.put("community", new String[] {"general", "activities", "childcare", "artists"});
        map.put("services", new String[] {"automotive", "household-services", "therapeutic", "real-estate"});
        loadTraining();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();
            int N = Integer.parseInt(line);
            for (int i = 0; i < N; i++) {
                System.out.println(f(br.readLine()));
            }
        }catch(IOException e){}
    }
    
    private static String f(String t){
        t = t.substring(1, t.length()-1);
        String[] m = t.split(",");
        String city = m[0].split(":")[1], section = m[1].split(":")[1], heading = m[2].split(":")[1];
        city = city.replaceAll("\"", "");
        section = section.replaceAll("\"", "");
        heading = heading.replaceAll("\"", "");
        return bestGuess(city, section, relevant(heading.toLowerCase().split(" ")));
    }
    
    private static String bestGuess(String city, String section, String[] heading){
        double[] scores = new double[4];
        String[] cans = map.get(section);
        for(int i = 0; i < cans.length; i++){
            scores[i] = score(cans[i], heading);
        }
        double bestScore = 0, secondBest = 0, temp;
        String best = "", second = "";
        for(int i = 0; i < scores.length; i++){
            if(scores[i] > bestScore){
                secondBest = bestScore;
                second = best;
                bestScore = scores[i];
                best = cans[i];
            }else if(scores[i] >= secondBest){
                secondBest = scores[i];
                second = cans[i];
            }
        }
        if(bestScore == 0){
            return map.get(section)[g.nextInt(4)];
        }else if(secondBest == 0){
            return best;
        }else if(bestScore == secondBest){
            return g.nextInt(2) == 0 ? best:second;
        }else{
            return best;
        }
    }
    
    private static double score(String category, String[] heading){
        double s = 0;
        HashMap<String, Integer> curMap = mCat.get(category);
        int total = tMap.get(category);
        for(int i = 0; i < heading.length; i++){
            if(curMap.containsKey(heading[i])){
                s += Math.pow(curMap.get(heading[i]), .17);
            }
        }
        return s;
    }
    
    private static void loadTraining(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("training.json"));
            String line = br.readLine();
            int N = Integer.parseInt(line);
            String t;
            String[] m;
            String category, heading;
            ArrayList<String> cats = new ArrayList();
            HashMap<String, ArrayList<String[]>> curHead = new HashMap();
            for(int i = 0; i < N; i++){
                t = br.readLine();
                m = t.substring(1, t.length()-1).split(",");
                category = m[1].split(":")[1];
                heading = m[3].split(":")[1];
                category = category.replaceAll("\"", "");
                heading = heading.replaceAll("\"", "");
                if(!cats.contains(category)){
                    cats.add(category);
                    ArrayList<String[]> cHead = new ArrayList();
                    cHead.add(relevant(heading.toLowerCase().split(" ")));
                    curHead.put(category, cHead);
                }else{
                    ArrayList<String[]> cHead = curHead.get(category);
                    cHead.add(relevant(heading.toLowerCase().split(" ")));
                    curHead.put(category, cHead);
                }
            }
            for(int i = 0; i < cats.size(); i++){
                g(cats.get(i), curHead.get(cats.get(i)));
            }
        }catch(IOException e){}
    }
    
    private static void g(String category, ArrayList<String[]> heads){
        //System.out.println("1 " + category);
        int headLen = heads.size();
        HashMap<String, Integer> gMap = new HashMap();
        String[] heading;
        String cur = "";
        for(int j = 0; j < headLen; j++){
            heading = heads.get(j);
            for(int i = 0; i < heading.length; i++){
                if(!cur.contains(" " + heading[i] + " ")){
                    cur = cur.concat(heading[i] + " ");
                    gMap.put(heading[i], 1);
                }else{
                    gMap.put(heading[i], gMap.get(heading[i])+1);
                }
            }
        }
        String[] c = cur.trim().split(" ");
        int total = 0, count;
        HashMap<String, Integer> temp = new HashMap();
        for(int i = 0; i < c.length; i++){
            count = gMap.get(c[i]);
            if(count > 0){
                total += count;
                temp.put(c[i], count);
            }
        }
        mCat.put(category, temp);
        tMap.put(category, total);
    }
    
    private static String[] relevant(String[] a){
        ArrayList<String> t = new ArrayList();
        for(int i = 0; i < a.length; i++){
            if(acceptable(a[i])) t.add(a[i]);
        }
        String[] b = new String[t.size()];
        for(int i = 0; i < b.length; i++){
            b[i] = t.get(i);
        }
        return b;
    }
    
    static String fluff = " to a the do be because is i you she he it me we in and an but that this with or your with how who what more just put on as if of ";
    private static boolean acceptable(String a){
        //return true;
        return isWord(a) && !fluff.contains(" " + a + " ");
    }
    
    private static boolean isWord(String a){
        a = a.replaceAll(".", "");
        a = a.replaceAll(",", "");
        //a = a.replaceAll(""+'\u0028', "");
        //a = a.replaceAll(""+'\u0029', "");
        a = a.replaceAll("-", "");
        char c;
        for(int i = 0; i < a.length(); i++){
            c = a.charAt(i);
            if(c < 'a' || c > 'z' || specialChar(c)) return false;
        }
        return true;
    }
    
    private static boolean specialChar(char a){
        char[] acc = new char[] {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        for(int i = 0; i < acc.length; i++) if(a == acc[i]) return true;
        return false;
    }
}