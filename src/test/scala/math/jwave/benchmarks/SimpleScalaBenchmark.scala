package math.jwave.benchmarks

class SimpleScalaBenchmark extends ScalaBenchmarkHelper {
  def timeNanoTime(reps: Int) {
    repeat(reps) { System.nanoTime() }
  }
}
