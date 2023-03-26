// https://www.hackerrank.com/contests/segfault/challenges/construct-a-string

import java.util.Scanner;

class Solution{
   static int MX=100+5;
   static int MOD=1000007;

   static String a,b,c;
   static int [][][]dp=new int[MX][MX][MX];

   static int func(int i,int j,int k){
      if(i>a.length())return 0;
      if(j>b.length())return 0;
      if(k==c.length())return 1;
      int ret=dp[i][j][k];
      if(ret!=-1)return ret;
      ret=func(i+1,j,k) + func(i,j+1,k);
      ret-=func(i+1,j+1,k);
      ret%=MOD;
      /* */
      /* */
      /* */
      if(i<a.length() && a.charAt(i)==c.charAt(k)){
         ret+=func(i+1,j,k+1);
         ret%=MOD;
         ret-=func(i+1,j+1,k+1);
         ret%=MOD;
      }
      /* */
      /* */
      /* */
      if(j<b.length() && b.charAt(j)==c.charAt(k)){
         ret+=func(i,j+1,k+1);
         ret%=MOD;
         ret-=func(i+1,j+1,k+1);
         ret%=MOD;
      }
      /* */
      /* */
      /* */
      ret+=MOD;
      ret%=MOD;
      dp[i][j][k]=ret;
      return ret;
   }

    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);
   
      a=sc.next();
      b=sc.next();
      c=sc.next();
      for(int i=0;i<MX;i++)
         for(int j=0;j<MX;j++)
            for(int k=0;k<MX;k++)dp[i][j][k]=-1;
      System.out.println(func(0,0,0));
    }
}
