package math.jwave.transforms

import org.junit.runner.RunWith
import math.jwave.transforms.wavelets._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class FastWaveletTransformTest extends WaveletTransformTest {
  def createTransform(wavelet: Wavelet) = new FastWaveletTransform(wavelet)
  val knownTransformResults =
    Table(
      ("wavelet", "signal", "transformed", "delta"),
      (Haar02, Seq(1., 1., 1., 1.), Seq(2., 0., 0., 0.), 1.0e-12),
      (Haar02, List.fill(64)(1.0), 8.0 :: List.fill(63)(0.0), 1.0e-12),
      (Haar02, Seq(1.2, 2.3, 3.4, 4.5, 5.4, 4.3, 3.2, 2.1), Seq(9.333809511662427, -1.2727922061357857, -2.1999999999999997, 2.2, -0.7778174593052021, -0.7778174593052025, 0.7778174593052025, 0.7778174593052023), 1.0e-12),
//      (Haar02, Seq(1., 1., 1., 1.), Seq(Math.sqrt(2.), Math.sqrt(2.), 0., 0.), 1.0e-12),
//      (Haar02Orthogonal, Seq(1., 1., 1., 1.), Seq(4., 0., 0., 0.), 1.0e-12),
      (Lege02, Seq(1., 1., 1., 1.), Seq(2., 0., 0., 0.), 1.0e-12),
      (Lege04, Seq(1., 1., 1., 1., 1., 1., 1., 1.), Seq(2., 2., 0., 0., 0., 0., 0., 0.), 1.0e-12),
      (Lege06, Seq(1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1.), Seq(2., 2., 2., 0., 0., 0., 0., 0., 0., 0., 0., 0.), 1.0e-12),
      (Daub02, Seq(1., 1., 1., 1., 1., 1., 1., 1.), Seq(2., 2., 0., 0., 0., 0., 0., 0.), 1.0e-12),
      (Daub03, Seq(1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1.), Seq(2., 2., 2., 0., 0., 0., 0., 0., 0., 0., 0., 0.), 1.0e-12),
      (Daub04, List.fill(16)(1.0), List.fill(4)(2.0) ++ List.fill(12)(0.0), 1.0e-3),
      (Daub04, List.fill(64)(1.0), List.fill(4)(4.0) ++ List.fill(60)(0.0), 1.0e-2),
      (Coif06, Seq(1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1.), Seq(2., 2., 2., 0., 0., 0., 0., 0., 0., 0., 0., 0.), 1.0e-12)
      )

  //  @Test
  //  def testFastBasicTransformForwardHaar02Matrix() {
  //    val delta = 1.e-12
  //    val matrixTime = Seq(Seq(1., 1., 1., 1.), Seq(1., 1., 1., 1.), Seq(1., 1., 1., 1.), Seq(1., 1., 1., 1.))
  //    val t = new FastWaveletTransform(Haar02)
  //    val matrixHilb = t.forward(matrixTime)
  //    val expected = Seq(Seq(4., 0., 0., 0.), Seq(0., 0., 0., 0.), Seq(0., 0., 0., 0.), Seq(0., 0., 0., 0.))
  //    assertMatrix(expected, matrixHilb, delta)
  //  }
  //
  //  @Test
  //  def testFastBasicTransformReverseHaar02Matrix() {
  //    val delta = 1.e-12
  //    val matrixHilb = Seq(Seq(4., 0., 0., 0.), Seq(0., 0., 0., 0.), Seq(0., 0., 0., 0.), Seq(0., 0., 0., 0.))
  //    val t = new FastWaveletTransform(Haar02)
  //    val matrixTime = t.reverse(matrixHilb)
  //    val expected = Seq(Seq(1., 1., 1., 1.), Seq(1., 1., 1., 1.), Seq(1., 1., 1., 1.), Seq(1., 1., 1., 1.))
  //    assertMatrix(expected, matrixTime, delta)
  //  }
  //
  //  @Test
  //  def testFastBasicTransformForwardHaar02Space() {
  //    val delta = 1.e-12
  //    val spaceTime = Seq(Seq(Seq(1., 1., 1., 1.), Seq(1., 1., 1., 1.), Seq(1., 1., 1., 1.), Seq(1., 1., 1., 1.)), Seq(Seq(1., 1., 1., 1.), Seq(1., 1., 1., 1.), Seq(1., 1., 1., 1.), Seq(1., 1., 1., 1.)), Seq(Seq(1., 1., 1., 1.), Seq(1., 1., 1., 1.), Seq(1., 1., 1., 1.), Seq(1., 1., 1., 1.)), Seq(Seq(1., 1., 1., 1.), Seq(1., 1., 1., 1.), Seq(1., 1., 1., 1.), Seq(1., 1., 1., 1.)))
  //    val t = new FastWaveletTransform(Haar02)
  //    val spaceHilb = t.forward(spaceTime)
  //    val expected = Seq(Seq(Seq(8., 0., 0., 0.), Seq(0., 0., 0., 0.), Seq(0., 0., 0., 0.), Seq(0., 0., 0., 0.)), Seq(Seq(0., 0., 0., 0.), Seq(0., 0., 0., 0.), Seq(0., 0., 0., 0.), Seq(0., 0., 0., 0.)), Seq(Seq(0., 0., 0., 0.), Seq(0., 0., 0., 0.), Seq(0., 0., 0., 0.), Seq(0., 0., 0., 0.)), Seq(Seq(0., 0., 0., 0.), Seq(0., 0., 0., 0.), Seq(0., 0., 0., 0.), Seq(0., 0., 0., 0.)))
  //    assertSpace(expected, spaceHilb, delta)
  //  }
  //
  //  @Test
  //  def testFastBasicTransformReverseHaar02Space() {
  //    val delta = 1.e-12
  //    val spaceHilb = Seq(Seq(Seq(8., 0., 0., 0.), Seq(0., 0., 0., 0.), Seq(0., 0., 0., 0.), Seq(0., 0., 0., 0.)), Seq(Seq(0., 0., 0., 0.), Seq(0., 0., 0., 0.), Seq(0., 0., 0., 0.), Seq(0., 0., 0., 0.)), Seq(Seq(0., 0., 0., 0.), Seq(0., 0., 0., 0.), Seq(0., 0., 0., 0.), Seq(0., 0., 0., 0.)), Seq(Seq(0., 0., 0., 0.), Seq(0., 0., 0., 0.), Seq(0., 0., 0., 0.), Seq(0., 0., 0., 0.)))
  //    val t = new FastWaveletTransform(Haar02)
  //    val spaceTime = t.reverse(spaceHilb)
  //    val expected = Seq(Seq(Seq(1., 1., 1., 1.), Seq(1., 1., 1., 1.), Seq(1., 1., 1., 1.), Seq(1., 1., 1., 1.)), Seq(Seq(1., 1., 1., 1.), Seq(1., 1., 1., 1.), Seq(1., 1., 1., 1.), Seq(1., 1., 1., 1.)), Seq(Seq(1., 1., 1., 1.), Seq(1., 1., 1., 1.), Seq(1., 1., 1., 1.), Seq(1., 1., 1., 1.)), Seq(Seq(1., 1., 1., 1.), Seq(1., 1., 1., 1.), Seq(1., 1., 1., 1.), Seq(1., 1., 1., 1.)))
  //    assertSpace(expected, spaceTime, delta)
  //  }

}
