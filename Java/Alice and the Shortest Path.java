// https://www.hackerrank.com/contests/segfault/challenges/alice-and-the-shortest-path

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static int n;
    public static int m;
    public static int[][] adjMatrix;
    public static int qq [];
    public static int dist [];
    public static int res  [];

    public static final int MAXN = 5005;
    public static final int INF  = 10000000;

    static void bfs(int src) {
        Queue<Integer> Q = new LinkedList<Integer>();
        for(int i=0;i<MAXN;i++) dist[i] = INF;

        Q.add(src);
        dist[src] = 0;

        while(!Q.isEmpty()){
            int u = Q.remove();
            for(int i = u; i<= n;i++){
                if(dist[i] > dist[u] + adjMatrix[u][i]){
                    dist[i] = dist[u] + adjMatrix[u][i];
                    Q.add(i);
                }
            }
        }
        return;
    }

    public static void main(String[] args) {

        adjMatrix = new int [MAXN][MAXN];
        qq        = new int [MAXN];
        dist      = new int [MAXN];
        res       = new int [MAXN];

        for(int i=0;i<MAXN;i++){
            for(int j=0;j<MAXN;j++){
                adjMatrix[i][j] = INF;
            }
        }

        int u, v, w;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();

        for(int i=0;i<m;i++){
            u = in.nextInt();
            v = in.nextInt();
            w = in.nextInt();

            adjMatrix[u][v] = Math.min(w, adjMatrix[u][v]);
        }

        int d, q;

        d = in.nextInt();
        q = in.nextInt();

        for(int i=0;i<q;i++){
            qq[i] = in.nextInt();
        }

        for(int i=0;i<q;i++){
            bfs(qq[i]);
            res[i] = dist[d];
        }

        for(int i=0;i<q;i++){
            if(res[i] == INF){
                System.out.println("Impossible");
            }else{
                System.out.println(res[i]);
            }
        }
   }
}
