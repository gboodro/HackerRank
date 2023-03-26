// https://www.hackerrank.com/contests/segfault/challenges/three-loops

import java.util.*;
public class Solution
{
   public static void main(String []argh)
   {
         Scanner sc = new Scanner(System.in);
         int n,sum;
         n=sc.nextInt();
         sum=sc.nextInt();
         int ans=0;
         for(int a=1;a<=n;a++)
         {
            for(int b=a;b<=n;b++)
            {
               for(int c=sum-a-b, d = 1;d-->0;)
               {
                  if(c >= b){
                     ans += 6 - (b == c ? (a == b ? 5:3): (a == b ? 3:0));
                  }
               }
               
            }
            
         }
         System.out.println(ans);   
   }
}
