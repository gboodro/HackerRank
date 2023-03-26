// https://www.hackerrank.com/contests/anki/challenges/zone-detection

import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String[] args) throws Exception{
      	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();
        HashSet<Zone> curInside = new HashSet(), curOutside = new HashSet();
      	int k = 1;
      	while(line != null && !(line.contains("F") || line.contains("B") || line.contains("R") || line.contains("L"))){
        	curOutside.add(zone(k, line));
          	k++;
          	line = in.readLine();
        }
        int x = 0, y = 0, dir = 0;
      	String[] moves = line.split(",");
      	String entered = "";
      	for(int i = 0; i < moves.length; i++){
          	//System.out.println(x + " " + y);
        	if(moves[i].equals("R")){
            	dir++;
              	dir%=4;
            }else if(moves[i].equals("L")){
              	dir = (3 + dir) % 4;
            }else{
              	int dist = Integer.parseInt(moves[i].substring(1));
              	int delX = dir % 2 == 1 ? (dir == 1 ? 1:-1):0;
                int delY = dir % 2 == 0 ? (dir == 0 ? 1:-1):0;
              	if(moves[i].startsWith("B")){
                  	delX *= -1;
                  	delY *= -1;
                }
              	for(int j = 0; j < dist; j++){
                 	x += delX;
                  	y += delY;
                  	for(Zone z:curInside){
                      	if(z.exited(x, y)){
                          	curOutside.add(z);
                          	curInside.remove(z);
                          	break;
                        }
                    }
                  	for(Zone z:curOutside){
                      	if(z.entered(x, y)){
                          	curInside.add(z);
                          	curOutside.remove(z);
                          	entered += "," + z.val;
                          	break;
                        }
                    }
                }
            }
        }
      	if(!entered.isEmpty()) System.out.println(entered.substring(1));
    }
  
  	private static Zone zone(int v, String t){
    	String[] c = t.split(",");
      	return new Zone(v, Integer.parseInt(c[0]), Integer.parseInt(c[1]), Integer.parseInt(c[2]), Integer.parseInt(c[3]));
    }
  
  	private static class Zone{
    	int x1, x2, y1, y2, val;
      	Zone(int v, int x1, int y1, int x2, int y2){
        	this.x1 = Math.min(x1, x2);
          	this.x2 = Math.max(x1, x2);
          	this.y1 = Math.min(y1, y2);
          	this.y2 = Math.max(y1, y2);
          	this.val = v;
        }
      
      	public boolean entered(int x, int y){
        	return x > x1 && x < x2 && y > y1 && y < y2;
        }
      
      	public boolean exited(int x, int y){
        	return x < x1 || x > x2 || y < y1 || y > y2;
        }
      
      	@Override
      	public boolean equals(Object o){
        	Zone z = (Zone) o;
          	return z.x1 == x1 && z.x2 == x2 && z.y1 == y1 && z.y2 == y2;
        }
    }
}