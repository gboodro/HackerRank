// https://www.hackerrank.com/contests/w2/challenges/cut-the-tree

import java.util.*;
class Solution{
    HashMap<String, Long> mem;
    public static void main(String[] args){
        new Solution();
    }
    
    Solution(){
        mem = new HashMap();
        Scanner in = new Scanner(System.in);
        int[] a = new int[in.nextInt()];
        for(int i = 0; i < a.length; i++)a[i] = in.nextInt();
        Tree t = new Tree(a);
        for(int i = 1; i < a.length; i++) t.addEdge(in.nextInt(), in.nextInt());
        System.out.println(t.getMinDel());
    }
    
    private class Node{
        HashSet<Node> child;
        long v;
        int name;
        Node(int name, int n){
            this.name = name;
            v = n;
            child = new HashSet();
        }
        long traverse(Node notB){
            if(!mem.containsKey(name + " " + notB.name)){
                long sum = v;
                for(Node c:child) if(c != notB) sum += c.traverse(this);
                mem.put(name + " " + notB.name, sum);
            } 
            return mem.get(name + " " + notB.name);
        }
    }
    
    private class Tree{
        HashSet<int[]> queries;
        Node[] nodes;
        Tree(int[] arr){
            queries = new HashSet();
            mem = new HashMap();
            nodes = new Node[arr.length+1];
            for(int i = 0; i < arr.length; i++) 
                nodes[i+1] = new Node(i+1, arr[i]);
        }
        
        void addEdge(int a, int b){
            queries.add(new int[] {a, b});
            nodes[a].child.add(nodes[b]);
            nodes[b].child.add(nodes[a]);
        }
        
        long getMinDel(){
            long del = Long.MAX_VALUE;
            for(int[] q:queries) 
                del = Math.min(del, Math.abs(nodes[q[1]].traverse(nodes[q[0]])-nodes[q[0]].traverse(nodes[q[1]])));
            return del;
        }
    }
    
}