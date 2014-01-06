package math.jwave.transforms

import math.jwave.JUnitTests
import math.jwave.Transform
import math.jwave.transforms.wavelets.Daub02
import math.jwave.transforms.wavelets.Haar02
import org.junit.Test

class WaveletPacketTransformTest extends JUnitTests {

  /**
   * Test method for {@link math.jwave.Transform#forward(double[])}.
   * @throws JWaveException
   */
  @Test
  def testWaveletPacketTransformForwardHaar02Array() {
    println("")
    println("testWaveletPacketTransformForwardHaar02Array")
    val delta = 1.e-12
    val arrTime = Array(2., 4., 7., 11.)
    showTime(arrTime)
    val t = new Transform(new WaveletPacketTransform(new Haar02()))
    val arrHilb = t.forward(arrTime)
    showHilb(arrHilb)
    val expected = Array(12., -6., -3., 1.)
    assertArray(expected, arrHilb, delta)
  }

  /**
   * Test method for {@link math.jwave.Transform#reverse(double[])}.
   * @throws JWaveException
   */
  @Test
  def testWaveletPacketTransformReverseHaar02Array() {
    println("")
    println("testWaveletPacketTransformReverseHaar02Array")
    val delta = 1e-12
    val arrHilb = Array(12., -6., -3., 1.)
    showHilb(arrHilb)
    val t = new Transform(new WaveletPacketTransform(new Haar02()))
    val arrTime = t.reverse(arrHilb)
    showTime(arrTime)
    val expected = Array(2., 4., 7., 11.)
    assertArray(expected, arrTime, delta)
  }

  /**
   * Test method for {@link math.jwave.Transform#forward(double[][])}.
   * @throws JWaveException
   */
  @Test
  def testWaveletPacketTransformForwardHaar02Matrix() {
    println("")
    println("testWaveletPacketTransformForwardHaar02Matrix")
    val delta = 1.e-12
    val matrixTime = Array(Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.))
    showTime(matrixTime)
    val t = new Transform(new WaveletPacketTransform(new Haar02()))
    val matrixHilb = t.forward(matrixTime)
    showHilb(matrixHilb)
    val expected = Array(Array(4., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.))
    assertMatrix(expected, matrixHilb, delta)
  }

  /**
   * Test method for {@link math.jwave.Transform#reverse(double[][])}.
   * @throws JWaveException
   */
  @Test
  def testWaveletPacketTransformReverseHaar02Matrix() {
    println("")
    println("testWaveletPacketTransformReverseHaar02Matrix")
    val delta = 1.e-12
    val matrixHilb = Array(Array(4., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.))
    showHilb(matrixHilb)
    val t = new Transform(new WaveletPacketTransform(new Haar02()))
    val matrixTime = t.reverse(matrixHilb)
    showTime(matrixTime)
    val expected = Array(Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.))
    assertMatrix(expected, matrixTime, delta)
  }

  /**
   * Test method for {@link math.jwave.Transform#forward(double[][][])}.
   * @throws JWaveException
   */
  @Test
  def testWaveletPacketTransformForwardHaar02Space() {
    println("")
    println("testWaveletPacketTransformForwardHaar02Space")
    val delta = 1.e-12
    val spaceTime = Array(Array(Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.)), Array(Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.)), Array(Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.)), Array(Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.)))
    showTime(spaceTime)
    val t = new Transform(new WaveletPacketTransform(new Haar02()))
    val spaceHilb = t.forward(spaceTime)
    showHilb(spaceHilb)
    val expected = Array(Array(Array(8., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.)), Array(Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.)), Array(Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.)), Array(Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.)))
    assertSpace(expected, spaceHilb, delta)
  }

  /**
   * Test method for {@link math.jwave.Transform#reverse(double[][][])}.
   * @throws JWaveException
   */
  @Test
  def testWaveletPacketTransformReverseHaar02Space() {
    println("")
    println("testWaveletPacketTransformReverseHaar02Space")
    val delta = 1.e-12
    val spaceHilb = Array(Array(Array(8., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.)), Array(Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.)), Array(Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.)), Array(Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.)))
    showHilb(spaceHilb)
    val t = new Transform(new WaveletPacketTransform(new Haar02()))
    val spaceTime = t.reverse(spaceHilb)
    showTime(spaceTime)
    val expected = Array(Array(Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.)), Array(Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.)), Array(Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.)), Array(Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.)))
    assertSpace(expected, spaceTime, delta)
  }

  /**
   * Test method for {@link math.jwave.Transform#forward(double[])}.
   * @throws JWaveException
   */
  @Test
  def testWaveletPacketTransformForwardDaub04ArrayRandom() {
    println("")
    println("testWaveletPacketTransformForwardDaub04ArrayRandom")
    val delta = 1.e-12
    val arrTime = Array(1.2, 2.3, 3.4, 4.5, 5.4, 4.3, 3.2, 2.1)
    showTime(arrTime)
    val t = new Transform(new WaveletPacketTransform(new Daub02()))
    val arrHilb = t.forward(arrTime)
    showHilb(arrHilb)
    val expected = Array(7.432531754730547, 5.76746824526945, 2.2766660498395392, -2.276666049839541, 0.9580127018922185, -0.9580127018922194, 0.2566987298107781, -0.25669872981077807)
    assertArray(expected, arrHilb, delta)
  }

  /**
   * Test method for {@link math.jwave.Transform#reverse(double[])}.
   * @throws JWaveException
   */
  @Test
  def testWaveletPacketTransformReverseDaub04ArrayRandom() {
    println("")
    println("testWaveletPacketTransformReverseDaub04ArrayRandom")
    val delta = 1e-12
    val arrHilb = Array(7.432531754730547, 5.76746824526945, 2.2766660498395392, -2.276666049839541, 0.9580127018922185, -0.9580127018922194, 0.2566987298107781, -0.25669872981077807)
    showHilb(arrHilb)
    val t = new Transform(new WaveletPacketTransform(new Daub02()))
    val arrTime = t.reverse(arrHilb)
    showTime(arrTime)
    val expected = Array(1.2, 2.3, 3.4, 4.5, 5.4, 4.3, 3.2, 2.1)
    assertArray(expected, arrTime, delta)
  }
}
