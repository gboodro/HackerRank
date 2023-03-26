// https://www.hackerrank.com/challenges/area-under-curves-and-volume-of-revolving-a-curv

object Solution {

import scala.annotation.tailrec
// This function will be used while invoking "Summation" to compute
 // The area under the curve.

/* def f(a:List[Int], b:List[Int], x:Double):Double =
   {
      if(a.isEmpty)
          0.0
      else
          Math.pow(x, b.head+1) * a.head / (b.head+1) + f(a.tail, b.tail, x);
   }
*/
def f(a:List[Int], b:List[Int], x:Double):Double =
   {
      if(a.isEmpty)
          0.0
      else
          Math.pow(x, b.head) * a.head + f(a.tail, b.tail, x);
   }

  // This function will be used while invoking "Summation" to compute 
  // The Volume of revolution of the curve around the X-Axis
  // The 'Area' referred to here is the area of the circle obtained
  // By rotating the point on the curve (x,f(x)) around the X-Axis
  def area(coefficients:List[Int],powers:List[Int],x:Double):Double = 
   {
      //Fill Up this function body
        // To compute the area of the circle on revolving the point
         // (x,f(x)) around the X-Axis
        // For the given coefficients, powers and value of x
      Math.PI * Math.pow(f(coefficients, powers, x), 2)
   }

   // This is the part where the series is summed up
   // This function is invoked once with func = f to compute the area         // under the curve
    // Then it is invoked again with func = area to compute the volume 
    // of revolution of the curve
   def summation(func:(List[Int],List[Int],Double)=>Double,upperLimit:Double,lowerLimit:Double, coefficients:List[Int],powers:List[Int]):Double =
   {
       @tailrec def loop(s:Double, func:(List[Int],List[Int],Double)=>Double, a:List[Int], b:List[Int], low:Double, up:Double):Double = {
           //println(up+" "+s)
           if(up <= low)
               s
           else
               loop(s+func(a, b, up)*0.001, func, a, b, low, up - 0.001)
       }
       loop(0.0, func, coefficients, powers, lowerLimit, upperLimit)
   }


// The Input-Output functions will be handled by us. You only need to concentrate your effort on the function bodies above.
def displayAnswers(coefficients:List[Int],powers:List[Int],limits:List[Int])
    {
      println(summation(f,limits.reverse.head,limits.head,coefficients,powers))
      println(summation(area,limits.reverse.head,limits.head,coefficients,powers))
    }

    def main(args: Array[String]) {
        /** Purely IO Section **/
       displayAnswers(readLine().trim().split(" ").toList.map(_.toInt),readLine().trim().split(" ").toList.map(_.toInt),readLine().trim().split(" ").toList.map(_.toInt))
    }
}
