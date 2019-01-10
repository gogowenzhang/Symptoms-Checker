//import scala.math.{pow, sqrt}
//
//val x = List(Array(0.0, 1.0,2.0 ,3.0), Array(2.0, 1.0,2.0,3.0),
//  Array(2.0, 1.0,2.0,3.0),
//  Array(0.0, 1.0,2.0 ,3.0), Array(2.0, 1.0,2.0,3.0),
//  Array(2.0, 1.0,2.0,3.0))
//
//val labels = List(0,0,0,1,1,1)
//
//
//
//def CalculateClusterMean(cluster: List[Array[Double]]): Array[Double] = {
//
//  val cumulative = cluster.reduceLeft((a : Array[Double], b : Array[Double]) => (a, b).zipped.map(_ + _))
//  cumulative.map((_: Double)/(cluster.length *1.0))
//}
//
//
//val centriods =  x.zip(labels).groupBy(_._2).mapValues(l => l.map(_._1)).map(_._2).map(CalculateClusterMean).toList
//
//
//
//def UpdateLabels(data: List[Array[Double]], centroids: List[Array[Double]]): Any = {
//  def distance(xs: Array[Double], ys: Array[Double]) = {
//    sqrt((xs zip ys).map { case (x,y) => pow(y - x, 2) }.sum)
//  }
//  data.map { dataInstance =>
//    centroids.zipWithIndex.map { case (centroid, c) =>
//      c -> distance(dataInstance, centroid)
//    }.minBy(_._2)._1
//  }
//}
//
//UpdateLabels(x, centriods)
//
println(2, 3)

1 >> 8