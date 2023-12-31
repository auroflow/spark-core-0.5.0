package spark.examples

import spark.SparkContext

object ExceptionHandlingTest {
  def main(args: Array[String]) {
    if (args.length == 0) {
      System.err.println("Usage: ExceptionHandlingTest <host>")
      System.exit(1)
    }

    val sc = new SparkContext(args(0), "ExceptionHandlingTest")
    val result = sc.parallelize(0 until sc.defaultParallelism).map { i =>
      if (Math.random > 0.75)
        throw new Exception("Testing exception handling")
      1
    }.reduce(_ + _)

    println(sc.defaultParallelism + " splits computed.")

    System.exit(0)
  }
}
