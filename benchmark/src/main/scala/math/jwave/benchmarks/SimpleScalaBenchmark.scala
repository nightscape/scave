package math.jwave.benchmarks

import org.openjdk.jmh.annotations.{Setup, Scope, State, Benchmark}

@State(Scope.Thread)
class SimpleScalaBenchmark {
  @Setup
  def prepare: Unit = {
  }

  @Benchmark
  def benchmarkNanoTime(): Unit = {
    System.nanoTime()
  }
}
