package math.jwave.test.matchers

import org.scalatest.matchers.Matcher
import org.scalatest.matchers.MatchResult

trait NumericArrayMatchers {
  def pretty(a: Array[Double]) = a.mkString("Array(", ",", ")")

  def equalWithTolerance(right: Array[Double], tol: Double) =
    Matcher[Array[Double]] { (left: Array[Double]) =>
      MatchResult(
        (left zip right) forall { case (a, b) => a <= b + tol && a >= b - tol },
        s"${pretty(left)} did not equal ${pretty(right)} with tolerance $tol",
        s"${pretty(left)} equaled ${pretty(right)} with tolerance $tol")
    }
}