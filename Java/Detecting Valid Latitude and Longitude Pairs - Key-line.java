// https://www.hackerrank.com/contests/magic-lines-may-2015/challenges/detecting-valid-latitude-and-longitude-pairs-key-line

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Solution {
   static BufferedReader br;
   static PrintWriter out;
   static String INPUT = "";
   
   static void solve() throws Exception
   {
      Pattern p = Pattern.compile("\\([-+]?((90(\\.0+)?)|([1-8]?[0-9](\\.[0-9]+)?)), [-+]?((180(\\.0+)?)|(1[0-7][0-9]|[1-9]?[0-9])(\\.[0-9]+)?)\\)");
      int n = Integer.parseInt(br.readLine());
      for(int i = 0;i < n;i++){
         String line = br.readLine();
         if(p.matcher(line).matches()){
            out.println("Valid");
         }else{
            out.println("Invalid");
         }
      }
   }
   
   public static void main(String[] args) throws Exception
   {
      long S = System.currentTimeMillis();
      br = new BufferedReader(INPUT.isEmpty() ? new InputStreamReader(System.in) : new StringReader(INPUT));
      out = new PrintWriter(System.out);
      
      solve();
      out.flush();
      long G = System.currentTimeMillis();
      tr(G-S+"ms");
   }
   
   static void tr(Object... o) { if(INPUT.length() != 0)System.out.println(Arrays.deepToString(o)); }
}
