package math.jwave.transforms

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import math.jwave.transforms.wavelets._

@RunWith(classOf[JUnitRunner])
class WaveletPacketTransformTest  extends WaveletTransformTest {
  def createTransform(wavelet: Wavelet) = new WaveletPacketTransform(wavelet)

  val knownTransformResults =
    Table(
      ("wavelet", "signal", "transformed", "delta"),
      (Haar02, Seq(2., 4., 7., 11.), Seq(12., -6., -3., 1.), 1.0e-12),
      (Daub02, Seq(1.2, 2.3, 3.4, 4.5, 5.4, 4.3, 3.2, 2.1), Seq(7.432531754730547, 5.76746824526945, 2.2766660498395392, -2.276666049839541, 0.9580127018922185, -0.9580127018922194, 0.2566987298107781, -0.25669872981077807), 1.0e-12))

  //  @Test
  //  def testWaveletPacketTransformForwardHaar02Matrix() {
  //    val delta = 1.e-12
  //    val matrixTime = Array(Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.))
  //    showTime(matrixTime)
  //    val t = new WaveletPacketTransform(Haar02)
  //    val matrixHilb = t.forward(matrixTime)
  //    showHilb(matrixHilb)
  //    val expected = Array(Array(4., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.))
  //    assertMatrix(expected, matrixHilb, delta)
  //  }
  //
  //  @Test
  //  def testWaveletPacketTransformReverseHaar02Matrix() {
  //    val delta = 1.e-12
  //    val matrixHilb = Array(Array(4., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.))
  //    showHilb(matrixHilb)
  //    val t = new WaveletPacketTransform(Haar02)
  //    val matrixTime = t.reverse(matrixHilb)
  //    showTime(matrixTime)
  //    val expected = Array(Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.))
  //    assertMatrix(expected, matrixTime, delta)
  //  }
  //
  //  @Test
  //  def testWaveletPacketTransformForwardHaar02Space() {
  //    val delta = 1.e-12
  //    val spaceTime = Array(Array(Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.)), Array(Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.)), Array(Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.)), Array(Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.)))
  //    showTime(spaceTime)
  //    val t = new WaveletPacketTransform(Haar02)
  //    val spaceHilb = t.forward(spaceTime)
  //    showHilb(spaceHilb)
  //    val expected = Array(Array(Array(8., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.)), Array(Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.)), Array(Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.)), Array(Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.)))
  //    assertSpace(expected, spaceHilb, delta)
  //  }
  //
  //  @Test
  //  def testWaveletPacketTransformReverseHaar02Space() {
  //    val delta = 1.e-12
  //    val spaceHilb = Array(Array(Array(8., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.)), Array(Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.)), Array(Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.)), Array(Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.)))
  //    showHilb(spaceHilb)
  //    val t = new WaveletPacketTransform(Haar02)
  //    val spaceTime = t.reverse(spaceHilb)
  //    showTime(spaceTime)
  //    val expected = Array(Array(Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.)), Array(Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.)), Array(Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.)), Array(Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.)))
  //    assertSpace(expected, spaceTime, delta)
  //  }

}
