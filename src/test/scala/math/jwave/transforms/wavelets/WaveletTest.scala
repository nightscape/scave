package math.jwave.transforms.wavelets
import org.junit.runner.RunWith
import org.scalacheck._
import org.scalacheck.Gen
import org.scalatest._
import org.scalatest.junit._
import org.scalatest.Matchers
import org.scalatest.prop.PropertyChecks
import org.scalatest.matchers.Matcher
import org.scalatest.matchers.MatchResult

@RunWith(classOf[JUnitRunner])
class WaveletTest extends PropSpec with PropertyChecks with Matchers with NumericArrayMatchers {
  def energy(arr: Array[Double]): Double = arr.map(x => x * x).sum
  implicit val disableShrink: Shrink[Array[Double]] = Shrink(s => Stream.empty)
  val wavelets = List(Coif06, Daub02, Daub03, Daub04, Haar02, Haar02Orthogonal, Lege02, Lege04, Lege06)
  def timeSeries(wavelet: Wavelet) = {
    val lengthExponent = Gen.choose(1, 10)
    val timeSeries = for {
      le <- lengthExponent
      series <- Gen.containerOfN[Array, Double](wavelet.wavelength * scala.math.pow(2, le).toInt, Gen.choose(0, 100))
    } yield (series)
    timeSeries
  }
  wavelets.diff(List(Lege04, Lege06)).foreach { wavelet =>
    property(s"transforming and reversing with ${wavelet.getClass().getSimpleName()} restores original series") {
      forAll(timeSeries(wavelet)) { s: Array[Double] =>
        wavelet.reverse(wavelet.forward(s)) should equalWithTolerance(s, 1.0E-1)
      }
    }
  }
  wavelets.diff(List(Daub04, Haar02Orthogonal, Lege04, Lege06)).foreach { wavelet =>
    property(s"transforming with ${wavelet.getClass().getSimpleName()} maintains energy") {
      forAll(timeSeries(wavelet)) { s: Array[Double] =>
        energy(wavelet.forward(s)) should be(energy(s) +- 1.0E-1)
      }
    }
  }
  wavelets.diff(List(Haar02Orthogonal, Lege04, Lege06)).foreach { wavelet =>
    property(s"${wavelet.getClass().getSimpleName()} is self-similar") {
      exactly(1, wavelet.forward(wavelet.coefficients)) should be(1.0 +- 1.0E-4)
    }
  }
}

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