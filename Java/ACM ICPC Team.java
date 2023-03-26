// https://www.hackerrank.com/contests/w6/challenges/acm-icpc-team

import java.util.*;

class Solution{
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        HashSet<Integer>[] vs = new HashSet[n];
        String cur;
        for(int i = 0; i < n; i++){
            cur = in.next();
            vs[i] = new HashSet();
            for(int j = 0; j < cur.length(); j++){
                if(cur.charAt(j) == '1') vs[i].add(j);
            }
        }
            
        int max = 0;
        int maxCt = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(vs[i].size() + vs[j].size() >= max){
                    int q = 0;
                    if(vs[i].size() < vs[j].size()){
                        q += vs[j].size();
                        for(int u : vs[i]) if(!vs[j].contains(u))q++;
                    }else{
                        q += vs[i].size();
                        for(int w : vs[j]) if(!vs[i].contains(w))q++;
                    }
                    if(q > max){
                        max = q;
                        maxCt = 1;
                    }else if(q == max) maxCt++;
                }
            }
        }
        System.out.println(max);
        System.out.println(maxCt);
    }
    
}