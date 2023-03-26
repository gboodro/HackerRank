// https://www.hackerrank.com/challenges/range-minimum-query

import collection.mutable.LinkedList;
object Solution {
    var A = Array[Int]();
    def main(args: Array[String]) {
        val nums = readLine.split(" ");
        val m = nums(1).toInt;
        A = readLine.split(" ").toList.map(x=>x.toInt).toArray;
        val node = constructSegmentTree(0, A.length-1);        
        for( i <- 1 to m){
            val cur = readLine.split(" ");
            println(getMin(node, cur(0).toInt, cur(1).toInt)); 
        }
    }
    
    class STNode() {
        var leftIndex = 0;
        var rightIndex = 0;
        var sum = Integer.MAX_VALUE;
        var leftNode:STNode = null;
        var rightNode:STNode = null;
    }

    def constructSegmentTree( l:Int, r:Int):STNode = {
        if (l == r) {
            var node = new STNode();
            node.leftIndex = l;
            node.rightIndex = r;
            node.sum = A(l);
            return node;
        }
        val mid = (l + r) / 2;
        var leftNode = constructSegmentTree(l, mid);
        var rightNode = constructSegmentTree(mid+1, r);
        var root = new STNode();
        root.leftIndex = leftNode.leftIndex;
        root.rightIndex = rightNode.rightIndex;
        root.sum = Math.min(leftNode.sum, rightNode.sum);
        root.leftNode = leftNode;
        root.rightNode = rightNode;
        return root;
    }

    def getMin(root:STNode, l:Int, r:Int):Int = {
        if(root.leftIndex >= l && root.rightIndex <= r)
            return root.sum;
        if(root.rightIndex < l || root.leftIndex > r)
            return Integer.MAX_VALUE;
        return Math.min(getMin(root.leftNode, l, r), getMin(root.rightNode, l, r));
    }
    
}