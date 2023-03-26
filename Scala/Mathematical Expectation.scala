// https://www.hackerrank.com/contests/feb14/challenges/mathematical-expectation

object Solution {
    
    val two = BigInt(2)
        
    def main(args: Array[String]) {
        val nums = readLine.split(" ");
        val k = nums(0).toInt;
        val n = BigInt(nums(1).toInt);
        var p = BigInt(0);
        var den = BigInt(0);
        if(k == 1){
            p = (n-2)*2;
            den = BigInt(3);
        }else if(k == 2){
            p = 40*BigInt(nums(1).toInt).pow(2) - 144*BigInt(nums(1).toInt)+131;
            den = BigInt(90);
        }else if(k == 3){
            p = 280*n.pow(3) - 1344 * n.pow(2) + 2063*n - 1038;
            den = BigInt(945);
        }else if(k == 4){
            p = 2800*n.pow(4) - 15680*n.pow(3) + 28844 * n.pow(2) - 19288*n + 4263;
            den = BigInt(14175);
        }else{
            p = 12320*n.pow(5)  - 73920 * n.pow(4) + 130328*n.pow(3) - 29568 * n.pow(2) - 64150*n - 5124;
            den = BigInt(93555);
        }
        val g = p.gcd(den);
        p /= g;
        den /= g;
        println(p + " / " + den);
    }
    
}