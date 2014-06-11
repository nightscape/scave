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
import math.jwave.test.matchers.NumericArrayMatchers

@RunWith(classOf[JUnitRunner])
class WaveletTest extends PropSpec with PropertyChecks with Matchers with NumericArrayMatchers {
  def energy(arr: Seq[Double]): Double = arr.map(x => x * x).sum
  implicit val disableShrink: Shrink[Array[Double]] = Shrink(s => Stream.empty)
  val wavelets = List(Coif06, Daub02, Daub03, Daub04, Haar1, Haar02Orthogonal, Lege02, Lege04, Lege06)
  def timeSeries(wavelet: Wavelet) = {
    val lengthExponent = Gen.choose(1, 10)
    val timeSeries = for {
      le <- lengthExponent
      series <- Gen.containerOfN[Array, Double](wavelet.wavelength * scala.math.pow(2, le).toInt, Gen.choose(0, 100))
    } yield (series)
    timeSeries
  }
  wavelets.diff(List(Lege04, Lege06, Haar02Orthogonal)).foreach { wavelet =>
    property(s"transforming and reversing with ${wavelet.getClass().getSimpleName()} restores original series") {
      forAll(timeSeries(wavelet)) { s: Array[Double] =>
        wavelet.mergeSignals(wavelet.splitSignal(s)) should equalWithTolerance(s.toSeq, 1.0E-1)
      }
    }
  }
  wavelets.diff(List(Daub04, Haar02Orthogonal, Lege04, Lege06)).foreach { wavelet =>
    property(s"transforming with ${wavelet.getClass().getSimpleName()} maintains energy") {
      forAll(timeSeries(wavelet)) { s: Array[Double] =>
        val (approximation, details) = wavelet.splitSignal(s)
        (energy(approximation) + energy(details)) should be(energy(s) +- 1.0E-1)
      }
    }
  }
  wavelets.diff(List(Haar02Orthogonal, Lege04, Lege06)).foreach { wavelet =>
    property(s"${wavelet.getClass().getSimpleName()} is self-similar") {
      val (approximation, details) = wavelet.splitSignal(wavelet.coefficients)
      
      exactly(1, (approximation ++ details)) should be(1.0 +- 1.0E-4)
    }
  }

  wavelets.foreach { wavelet =>
    property(s"${wavelet.getClass().getSimpleName()} has a mean of zero") {
      wavelet.coefficients.sum should be(0.0 +- 1.0E-4)
    }
  }

  wavelets.foreach { wavelet =>
    property(s"${wavelet.getClass().getSimpleName()} recognizes a sine wave with period of its wavelength") {
      val sine = (0 until wavelet.wavelength * 4).map(x => scala.math.sin(x * scala.math.Pi * 2 / wavelet.wavelength)).toArray
      println(s"${wavelet.getClass().getSimpleName()} length = ${wavelet.wavelength}")
      println(sine.mkString(","))
//      println(wavelet.forward(sine).mkString(","))
    }
  }
}
