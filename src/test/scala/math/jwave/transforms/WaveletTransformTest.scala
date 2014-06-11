package math.jwave.transforms
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
import math.jwave.transforms.wavelets._
import org.scalatest.prop._

abstract class WaveletTransformTest extends PropSpec with PropertyChecks with Matchers with NumericArrayMatchers {
  def createTransform(wavelet: Wavelet): WaveletTransform

  def energy(arr: Array[Double]): Double = arr.map(x => x * x).sum
  implicit val disableShrink: Shrink[Array[Double]] = Shrink(s => Stream.empty)
  val wavelets = List(Coif06, Daub02, Daub03, Daub04, Haar1, Lege02)
  val transforms = wavelets.map(createTransform)
  def timeSeries(wavelet: Wavelet) = {
    val lengthExponent = Gen.choose(1, 10)
    val timeSeries = for {
      le <- lengthExponent
      series <- Gen.containerOfN[Array, Double](wavelet.wavelength * scala.math.pow(2, le).toInt, Gen.choose(0, 100))
    } yield (series)
    timeSeries
  }
  transforms.foreach { transform =>
    property(s"transforming and reversing with ${transform} restores original series") {
      forAll(timeSeries(transform.wavelet)) { s: Array[Double] =>
        transform.reverse(transform.forward(s)) should equalWithTolerance(s.toSeq, 1.0E-1)
      }
    }
  }
  def knownTransformResults: TableFor4[Wavelet, Seq[Double], Seq[Double], Double]
  property("known transform results work") {
    forAll(knownTransformResults) {
      case (wavelet, input, expected, delta) =>
        val transform = createTransform(wavelet)
        val transformed = transform.forward(input)
        expected should equalWithTolerance(transformed.flatten, delta)
        val restored = transform.reverse(transformed)
        input should equalWithTolerance(restored, delta)

    }
  }
}
