package com.spark.test

import org.apache.spark.{SparkContext, SparkConf}

/**
 * @author mashengli
 */
object WordCount {
  def main(args: Array[String]) {
    val dataFile = args(0)
    val output = args(1)
    val sparkConf = new SparkConf().setAppName("WorldCount")
    val sparkContext = new SparkContext(sparkConf)
    val lines = sparkContext.textFile(dataFile)
    val counts = lines.flatMap(_.split(",")).map(s => (s,1)).reduceByKey((a,b) => a+b)
    counts.saveAsTextFile(output)
    sparkContext.stop()
  }
}
