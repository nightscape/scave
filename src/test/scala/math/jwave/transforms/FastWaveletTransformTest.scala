package math.jwave.transforms

import math.jwave.JUnitTests
import math.jwave.Transform
import math.jwave.transforms.wavelets.Coif06
import math.jwave.transforms.wavelets.Daub02
import math.jwave.transforms.wavelets.Daub03
import math.jwave.transforms.wavelets.Daub04
import math.jwave.transforms.wavelets.Haar02
import math.jwave.transforms.wavelets.Haar02Orthogonal
import math.jwave.transforms.wavelets.Lege02
import math.jwave.transforms.wavelets.Lege04
import math.jwave.transforms.wavelets.Lege06
import org.junit.Test

class FastWaveletTransformTest extends JUnitTests {

  @Test
  def testFastBasicTransformForwardHaar02Array() {
    val delta = 1.e-12
    val arrTime = Array(1., 1., 1., 1.)
    val t = new Transform(new FastWaveletTransform(Haar02))
    val arrHilb = t.forward(arrTime)
    val expected = Array(2., 0., 0., 0.)
    assertArray(expected, arrHilb, delta)
  }

  @Test
  def testFastBasicTransformReverseHaar02Array() {
    val delta = 1e-12
    val arrHilb = Array(2., 0., 0., 0.)
    val t = new Transform(new FastWaveletTransform(Haar02))
    val arrTime = t.reverse(arrHilb)
    val expected = Array(1., 1., 1., 1.)
    assertArray(expected, arrTime, delta)
  }

  @Test
  def testFastBasicTransformForwardHaar02ArrayLong() {
    val delta = 1.e-12
    val arrTime = Array(1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1.)
    val t = new Transform(new FastWaveletTransform(Haar02))
    val arrHilb = t.forward(arrTime)
    val expected = Array(8., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0.)
    assertArray(expected, arrHilb, delta)
  }

  @Test
  def testFastBasicTransformReverseHaar02ArrayLong() {
    val delta = 1e-12
    val arrHilb = Array(8., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0.)
    val t = new Transform(new FastWaveletTransform(Haar02))
    val arrTime = t.reverse(arrHilb)
    val expected = Array(1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1.)
    assertArray(expected, arrTime, delta)
  }

  @Test
  def testFastBasicTransformForwardHaar02ArrayRandom() {
    val delta = 1.e-12
    val arrTime = Array(1.2, 2.3, 3.4, 4.5, 5.4, 4.3, 3.2, 2.1)
    val t = new Transform(new FastWaveletTransform(Haar02))
    val arrHilb = t.forward(arrTime)
    val expected = Array(9.333809511662427, -1.2727922061357857, -2.1999999999999997, 2.2, -0.7778174593052021, -0.7778174593052025, 0.7778174593052025, 0.7778174593052023)
    assertArray(expected, arrHilb, delta)
  }

  @Test
  def testFastBasicTransformReverseHaar02ArrayRandom() {
    val delta = 1e-12
    val arrHilb = Array(9.333809511662427, -1.2727922061357857, -2.1999999999999997, 2.2, -0.7778174593052021, -0.7778174593052025, 0.7778174593052025, 0.7778174593052023)
    val t = new Transform(new FastWaveletTransform(Haar02))
    val arrTime = t.reverse(arrHilb)
    val expected = Array(1.2, 2.3, 3.4, 4.5, 5.4, 4.3, 3.2, 2.1)
    assertArray(expected, arrTime, delta)
  }

  @Test
  def testFastBasicTransformForwardHaar02Matrix() {
    val delta = 1.e-12
    val matrixTime = Array(Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.))
    val t = new Transform(new FastWaveletTransform(Haar02))
    val matrixHilb = t.forward(matrixTime)
    val expected = Array(Array(4., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.))
    assertMatrix(expected, matrixHilb, delta)
  }

  @Test
  def testFastBasicTransformReverseHaar02Matrix() {
    val delta = 1.e-12
    val matrixHilb = Array(Array(4., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.))
    val t = new Transform(new FastWaveletTransform(Haar02))
    val matrixTime = t.reverse(matrixHilb)
    val expected = Array(Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.))
    assertMatrix(expected, matrixTime, delta)
  }

  @Test
  def testFastBasicTransformForwardHaar02Space() {
    val delta = 1.e-12
    val spaceTime = Array(Array(Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.)), Array(Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.)), Array(Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.)), Array(Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.)))
    val t = new Transform(new FastWaveletTransform(Haar02))
    val spaceHilb = t.forward(spaceTime)
    val expected = Array(Array(Array(8., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.)), Array(Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.)), Array(Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.)), Array(Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.)))
    assertSpace(expected, spaceHilb, delta)
  }

  @Test
  def testFastBasicTransformReverseHaar02Space() {
    val delta = 1.e-12
    val spaceHilb = Array(Array(Array(8., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.)), Array(Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.)), Array(Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.)), Array(Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.), Array(0., 0., 0., 0.)))
    val t = new Transform(new FastWaveletTransform(Haar02))
    val spaceTime = t.reverse(spaceHilb)
    val expected = Array(Array(Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.)), Array(Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.)), Array(Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.)), Array(Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.), Array(1., 1., 1., 1.)))
    assertSpace(expected, spaceTime, delta)
  }

  @Test
  def testFastBasicTransformForwardHaar02OrthogonalArray() {
    val delta = 1.e-12
    val arrTime = Array(1., 1., 1., 1.)
    val t = new Transform(new FastWaveletTransform(Haar02Orthogonal))
    val arrHilb = t.forward(arrTime)
    val expected = Array(4., 0., 0., 0.)
    assertArray(expected, arrHilb, delta)
  }

  @Test
  def testFastBasicTransformReverseHaar02OrthogonalArray() {
    val delta = 1e-12
    val arrHilb = Array(4., 0., 0., 0.)
    val t = new Transform(new FastWaveletTransform(Haar02Orthogonal))
    val arrTime = t.reverse(arrHilb)
    val expected = Array(1., 1., 1., 1.)
    assertArray(expected, arrTime, delta)
  }

  @Test
  def testFastBasicTransformForwardLege02Array() {
    val delta = 1.e-12
    val arrTime = Array(1., 1., 1., 1.)
    val t = new Transform(new FastWaveletTransform(Lege02))
    val arrHilb = t.forward(arrTime)
    val expected = Array(2., 0., 0., 0.)
    assertArray(expected, arrHilb, delta)
  }

  @Test
  def testFastBasicTransformReverseLege02Array() {
    val delta = 1e-12
    val arrHilb = Array(2., 0., 0., 0.)
    val t = new Transform(new FastWaveletTransform(Lege02))
    val arrTime = t.reverse(arrHilb)
    val expected = Array(1., 1., 1., 1.)
    assertArray(expected, arrTime, delta)
  }

  @Test
  def testFastBasicTransformForwardDaub04Array() {
    val delta = 1.e-12
    val arrTime = Array(1., 1., 1., 1., 1., 1., 1., 1.)
    val t = new Transform(new FastWaveletTransform(Daub02))
    val arrHilb = t.forward(arrTime)
    val expected = Array(2., 2., 0., 0., 0., 0., 0., 0.)
    assertArray(expected, arrHilb, delta)
  }

  @Test
  def testFastBasicTransformReverseDaub04Array() {
    val delta = 1.e-12
    val arrHilb = Array(2., 2., 0., 0., 0., 0., 0., 0.)
    val t = new Transform(new FastWaveletTransform(Daub02))
    val arrTime = t.reverse(arrHilb)
    val expected = Array(1., 1., 1., 1., 1., 1., 1., 1.)
    assertArray(expected, arrTime, delta)
  }

  @Test
  def testFastBasicTransformForwardLege04Array() {
    val delta = 1.e-12
    val arrTime = Array(1., 1., 1., 1., 1., 1., 1., 1.)
    val t = new Transform(new FastWaveletTransform(Lege04))
    val arrHilb = t.forward(arrTime)
    val expected = Array(2., 2., 0., 0., 0., 0., 0., 0.)
    assertArray(expected, arrHilb, delta)
  }

  @Test
  def testFastBasicTransformReverseLege04Array() {
    val delta = 1.e-12
    val arrHilb = Array(2., 2., 0., 0., 0., 0., 0., 0.)
    val t = new Transform(new FastWaveletTransform(Lege04))
    val arrTime = t.reverse(arrHilb)
    val expected = Array(1., 1., 1., 1., 1., 1., 1., 1.)
    assertArray(expected, arrTime, delta)
  }

  @Test
  def testFastBasicTransformForwardDaub06Array() {
    val delta = 1.e-12
    val arrTime = Array(1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1.)
    val t = new Transform(new FastWaveletTransform(Daub03))
    val arrHilb = t.forward(arrTime)
    val expected = Array(2., 2., 2., 0., 0., 0., 0., 0., 0., 0., 0., 0.)
    assertArray(expected, arrHilb, delta)
  }

  @Test
  def testFastBasicTransformReverseDaub06Array() {
    val delta = 1.e-12
    val arrHilb = Array(2., 2., 2., 0., 0., 0., 0., 0., 0., 0., 0., 0.)
    val t = new Transform(new FastWaveletTransform(Daub03))
    val arrTime = t.reverse(arrHilb)
    val expected = Array(1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1.)
    assertArray(expected, arrTime, delta)
  }

  @Test
  def testFastBasicTransformForwardLege06Array() {
    val delta = 1.e-12
    val arrTime = Array(1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1.)
    val t = new Transform(new FastWaveletTransform(Lege06))
    val arrHilb = t.forward(arrTime)
    val expected = Array(2., 2., 2., 0., 0., 0., 0., 0., 0., 0., 0., 0.)
    assertArray(expected, arrHilb, delta)
  }

  @Test
  def testFastBasicTransformReverseLege06Array() {
    val delta = 1.e-12
    val arrHilb = Array(2., 2., 2., 0., 0., 0., 0., 0., 0., 0., 0., 0.)
    val t = new Transform(new FastWaveletTransform(Lege06))
    val arrTime = t.reverse(arrHilb)
    val expected = Array(1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1.)
    assertArray(expected, arrTime, delta)
  }

  @Test
  def testFastBasicTransformForwardCoif06Array() {
    val delta = 1.e-12
    val arrTime = Array(1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1.)
    val t = new Transform(new FastWaveletTransform(Coif06))
    val arrHilb = t.forward(arrTime)
    val expected = Array(2., 2., 2., 0., 0., 0., 0., 0., 0., 0., 0., 0.)
    assertArray(expected, arrHilb, delta)
  }

  @Test
  def testFastBasicTransformReverseCoif06Array() {
    val delta = 1.e-12
    val arrHilb = Array(2., 2., 2., 0., 0., 0., 0., 0., 0., 0., 0., 0.)
    val t = new Transform(new FastWaveletTransform(Coif06))
    val arrTime = t.reverse(arrHilb)
    val expected = Array(1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1.)
    assertArray(expected, arrTime, delta)
  }

  @Test
  def testFastBasicTransformForwardDaub08Array() {
    val delta = 1.e-3
    val arrTime = Array(1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1.)
    val t = new Transform(new FastWaveletTransform(Daub04))
    val arrHilb = t.forward(arrTime)
    val expected = Array(2., 2., 2., 2., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0.)
    assertArray(expected, arrHilb, delta)
  }

  @Test
  def testFastBasicTransformReverseDaub08Array() {
    val delta = 1.e-3
    val arrHilb = Array(2., 2., 2., 2., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0.)
    val t = new Transform(new FastWaveletTransform(Daub04))
    val arrTime = t.reverse(arrHilb)
    val expected = Array(1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1.)
    assertArray(expected, arrTime, delta)
  }

  @Test
  def testFastBasicTransformForwardDaub04ArrayLong() {
    val delta = 1.e-2
    val arrTime = Array(1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1.)
    val t = new Transform(new FastWaveletTransform(Daub04))
    val arrHilb = t.forward(arrTime)
    val expected = Array(4., 4., 4., 4., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0.)
    assertArray(expected, arrHilb, delta)
  }

  @Test
  def testFastBasicTransformReverseDaub04ArrayLong() {
    val delta = 1e-2
    val arrHilb = Array(4., 4., 4., 4., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0.)
    val t = new Transform(new FastWaveletTransform(Daub04))
    val arrTime = t.reverse(arrHilb)
    val expected = Array(1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1.)
    assertArray(expected, arrTime, delta)
  }

  @Test
  def testFastBasicTransformForwardHaar02ArraySteps() {
    val delta = 1.e-12
    val arrTime = Array(1., 1., 1., 1.)
    val t = new Transform(new FastWaveletTransform(Haar02, 1))
    val arrHilb = t.forward(arrTime)
    val expected = Array(Math.sqrt(2.), Math.sqrt(2.), 0., 0.)
    assertArray(expected, arrHilb, delta)
  }

  @Test
  def testFastBasicTransformReverseHaar02ArraySteps() {
    val delta = 1e-12
    val arrHilb = Array(2., 0, 0., 0.)
    val t = new Transform(new FastWaveletTransform(Haar02, 1))
    val arrTime = t.reverse(arrHilb)
    val sqrt2 = Math.sqrt(2.)
    val expected = Array(sqrt2, sqrt2, 0., 0.)
    assertArray(expected, arrTime, delta)
  }
}
