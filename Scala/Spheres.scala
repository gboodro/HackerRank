// https://www.hackerrank.com/challenges/spheres

object Solution{
    def main(args:Array[String]){
        val t = readInt;
        for(i <- 1 to t){
            val rs = readLine.split(" ").map(_.toDouble);
            val p1 = readLine.split(" ").map(_.toDouble);
            val a1 = readLine.split(" ").map(_.toDouble);
            val p2 = readLine.split(" ").map(_.toDouble);
            val a2 = readLine.split(" ").map(_.toDouble);
            println(intersects(rs, p1, a1, p2, a2));
        }
    }
    def intersects(rs:Array[Double], p1:Array[Double], a1:Array[Double], p2:Array[Double], a2:Array[Double]):String = {
        val r  = rs(0) + rs(1);
        val dx = p1(0)-p2(0);
        val dy = p1(1)-p2(1);
        val dz = p1(2)-p2(2);
        val ax = a1(0)-a2(0);
        val ay = a1(1)-a2(1);
        val az = a1(2)-a2(2);
        val a  = (ax*ax + ay*ay + az*az) / 4;
        val b  = ax*dx + ay*dy + az*dz;
        val c  = dx*dx + dy*dy + dz*dz - r*r;
        if(b*b-4*a*c < 0) return "NO";
        val t2 = (-b + Math.sqrt(b*b-4*a*c))/2/a;
        if(t2 >= 0) return "YES";
        else return "NO";
    }
}