// https://www.hackerrank.com/challenges/swap-nodes

object Solution {

    def main(args: Array[String]) {
        var tree = new Tree(readLine.toInt);
      	for(i <- 1 to tree.node.size-1){
          	val n = readLine.split(" ").map(x=>x.toInt);
          	tree.set(i, n(0), n(1));
        }
      	val t = readLine.toInt;
      	for(i <- 1 to t){
          	val k = readLine.toInt;
          	tree.swap(k);
          	println(tree.inTra());
        }
    }
}

class Node {
  	var root = "";
  	var left:Node = null;
  	var right:Node = null;

  	def swap():Unit = {
    	val t = right;
    	right = left;
    	left = t;
  	}
}

class Tree(n:Int){

    var node = Array.fill(n+1){ new Node() };
	
    def set(i:Int, L:Int, R:Int):Unit = {
      	node(i).root = i+"";
        if(L != -1) node(i).left = node(L);
        if(R != -1) node(i).right = node(R);
    }

    def inTra():String = {
      	return inTra(node(1));
    }

    def inTra(n:Node):String = {
      if(n.left == null && n.right == null) 
        	return n.root;
      else if(n.left == null) 
        	return n.root + " " + inTra(n.right);
      else if(n.right == null) 
        	return inTra(n.left) + " " + n.root;
      else 
        	return inTra(n.left) + " " + n.root + " " + inTra(n.right);
 	}

    def swap(k:Int):Unit = {
      	df(node(1), 1, k);
    }
  
  	def df(cur:Node, depth:Int, k:Int):Unit = {
      	if(depth % k == 0) cur.swap;
      	if(cur.left != null) df(cur.left, depth+1, k);
      	if(cur.right != null) df(cur.right, depth+1, k);
    }
}