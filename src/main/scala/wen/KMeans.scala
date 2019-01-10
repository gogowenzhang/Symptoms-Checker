package wen

import math._

/** K-means Clustering
  * Choose k random points to be the centroid of the k clusters.
  * Repeat until clusters stop changing:
  * For every data point in the dataset, determine which centroid it is closest
  * to and assign it to that cluster.
  * Update the centroids to be the new center of all the points in that cluster
  * (just take the arithmetic mean)
  */

class KMeans {

  def UpdateCentroids(data: List[Array[Double]], labels: List[Int]): List[Array[Double]] = {
    def CalculateClusterMean(cluster: List[Array[Double]]): Array[Double] = {
      val cumulative = cluster.reduceLeft((a : Array[Double], b : Array[Double]) => (a, b).zipped.map(_ + _))
      cumulative.map((_/(cluster.length *1.0)))
    }
    data.zip(labels).groupBy(_._2).mapValues(l => l.map(_._1)).map(_._2).map(CalculateClusterMean).toList
  }

  def UpdateLabels(data: List[Array[Double]], centroids: List[Array[Double]]): List[Int] = {
    def distance(xs: Array[Double], ys: Array[Double]) = {
      sqrt((xs zip ys).map { case (x,y) => pow(y - x, 2) }.sum)
    }
    data.map { dataInstance =>
      centroids.zipWithIndex.map { case (centroid, c) =>
        c -> distance(dataInstance, centroid)
      }.minBy(_._2)._1
    }
  }

  def train(data: List[Array[Double]], k: Int, MaxIterations: Int): List[Int] = {
    // Random init
    val labels = Array.fill[Int](data.length)(0).toList
    val start_point_index = (scala.util.Random.shuffle(0 to data.length-1) take k).toList
    val centroids = start_point_index map data

    def loop(labels: List[Int], centroids: List[Array[Double]], iter: Int): List[Int] = {
      println(labels, iter)
      if (iter > MaxIterations) labels
      else if (centroids == UpdateCentroids(data, UpdateLabels(data, centroids))) labels
      else loop(UpdateLabels(data, centroids), UpdateCentroids(data, UpdateLabels(data, centroids)) , iter+1)
    }

    loop(labels, centroids, 1)
  }

}
