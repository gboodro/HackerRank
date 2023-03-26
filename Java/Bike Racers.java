// https://www.hackerrank.com/challenges/bike-racers

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt(), k = in.nextInt();
        int[][] a = new int[n][], b = new int[m][];
        for(int i = 0; i < n; i++) a[i] = new int[] {in.nextInt(), in.nextInt()};
        for(int i = 0; i < m; i++) b[i] = new int[] {in.nextInt(), in.nextInt()};
        Edge[] e = new Edge[n*m];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                e[i*m + j] = new Edge(i+1, j+1, dist(a[i], b[j]));
        Arrays.sort(e);
        System.out.println(Min(e, k));
    }
    
    private static long Min(Edge[] e, int k){
        Graph g = new Graph(251, 251);
        int i = 0; 
        while(g.maxMatching() < k && i < e.length){
            g.addEdge(e[i].a, e[i].b);
            i++;
        }
        return e[i-1].d;
    }
    
    private static long dist(int[] a, int[] b){
        long d = 0;
        for(int i = 0; i < a.length; i++) d += sqr(a[i]-b[i]);
        return d;
    }
    
    private static long sqr(long a){return a*a;}

    private static class Edge implements Comparable {
        int a, b;
        long d;
        Edge(int a, int b, long d){
            this.a = a;
            this.b = b;
            this.d = d;
        }
        @Override
        public int compareTo(Object o){
            Edge e = (Edge) o;
            return d < e.d ? -1:1;
        }
    }
    
    private static class Graph{
        final int MAXN1 = 251;
        final int MAXN2 = 251;
        final int MAXM = MAXN1*MAXN2;
        int n1, n2, edges;
        int[] last = new int[MAXN1], prev = new int[MAXM], head = new int[MAXM];
        int[] matching = new int[MAXN2], dist = new int[MAXN1], Q = new int[MAXN1];
        boolean[] used = new boolean[MAXN1], vis = new boolean[MAXN1];
        
        Graph(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;
            this.edges = 0;
            for(int i = 0; i < n1; i++) last[i] = -1;
        }

        void addEdge(int u, int v) {
            head[edges] = v;
            prev[edges] = last[u];
            last[u] = edges++;
        }

        void bfs() {
            for(int i = 0; i < n1; i++) dist[i] = -1;
            int sizeQ = 0;
            for (int u = 0; u < n1; ++u) {
                if (!used[u]) {
                    Q[sizeQ++] = u;
                    dist[u] = 0;
                }
            }
            for (int i = 0; i < sizeQ; i++) {
                int u1 = Q[i];
                for (int e = last[u1]; e >= 0; e = prev[e]) {
                    int u2 = matching[head[e]];
                    if (u2 >= 0 && dist[u2] < 0) {
                        dist[u2] = dist[u1] + 1;
                        Q[sizeQ++] = u2;
                    }
                }
            }
        }

        boolean dfs(int u1) {
            vis[u1] = true;
            for (int e = last[u1]; e >= 0; e = prev[e]) {
                int v = head[e];
                int u2 = matching[v];
                if (u2 < 0 || !vis[u2] && dist[u2] == dist[u1] + 1 && dfs(u2)) {
                    matching[v] = u1;
                    used[u1] = true;
                    return true;
                }
            }
            return false;
        }

        int maxMatching() {
            for(int i = 0; i < n1; i++) used[i] = false;
            for(int i = 0; i < n2; i++) matching[i] = -1;
            for(int res = 0;;){
                bfs();
                for(int i = 0; i < n1; i++) vis[i] = false;
                int f = 0;
                for(int u = 0; u < n1; ++u)
                    if (!used[u] && dfs(u))
                        f++;
                if(f == 0) return res;
                res += f;
            }
        }
    }
}