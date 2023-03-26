// https://www.hackerrank.com/challenges/hexagonal-grid

import java.util.*;
class Solution{
  	public static void main(String[] args){
      	Scanner in = new Scanner(System.in).useDelimiter("\n");
      	int t = Integer.parseInt(in.next());
      	for(int i = 0; i < t; i++){
          	int n = Integer.parseInt(in.next());
          	boolean[][] g = new boolean[2][n];
          	for(int j = 0; j < g.length; j++){
              	String line = in.next();
              	for(int k = 0; k < g[j].length; k++){
                  	g[j][k] = line.charAt(k) == '1';
                }
            }
          	System.out.println(dfs(0, 0, g) ? "YES":"NO");
        }
    }
  
  	private static boolean dfs(int x, int y, boolean[][] g){
      	if(x == g.length) return true;
      	else if(y == g[x].length) return dfs(x+1, 0, g);
        else if(g[x][y]) return dfs(x, y+1, g);
        else{
          	if(x == 0 && !g[x+1][y]){
              	g[x][y] = true;
              	g[x+1][y] = true;
              	if(dfs(x, y+1, g)) return true;
              	g[x][y] = false;
              	g[x+1][y] = false;
            }
          	if(y < g[x].length - 1 && !g[x][y+1]){
              	g[x][y] = true;
              	g[x][y+1] = true;
              	if(dfs(x, y+1, g)) return true;
              	g[x][y] = false;
              	g[x][y+1] = false;
            }
          	if(x == 0 && y > 0 && !g[x+1][y-1]){
              	g[x][y] = true;
              	g[x+1][y-1] = true;
              	if(dfs(x, y+1, g)) return true;
              	g[x][y] = false;
              	g[x+1][y-1] = false;
            }
          	return false;
        }
    }
}