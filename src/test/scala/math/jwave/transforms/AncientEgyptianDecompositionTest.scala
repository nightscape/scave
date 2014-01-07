package math.jwave.transforms

import math.jwave.JUnitTests
import math.jwave.Transform
import math.jwave.transforms.wavelets.Haar02
import org.junit.Test

class AncientEgyptianDecompositionTest extends JUnitTests {

  /**
   * Test method for {@link math.jwave.Transform#forward(double[])}.
   * @throws JWaveException
   */
  @Test
  def testAncientEgyptianDecompositionFwtForwardHaar02Array() {
    println("")
    println("testAncientEgyptianDecompositionFwtForwardHaar02Array")
    val delta = 1.e-12
    val arrTime = Array(1., 1., 1., 1., 1., 1., 1.)
    showTime(arrTime)
    val t = new Transform(new AncientEgyptianDecomposition(new FastWaveletTransform(Haar02)))
    val arrHilb = t.forward(arrTime)
    showHilb(arrHilb)
    val expected = Array(2., 0., 0., 0., Math.sqrt(2.), 0., 1.)
    assertArray(expected, arrHilb, delta)
  }

  /**
   * Test method for {@link math.jwave.Transform#reverse(double[])}.
   * @throws JWaveException
   */
  @Test
  def testAncientEgyptianDecompositionFwtReverseHaar02Array() {
    println("")
    println("testAncientEgyptianDecompositionFwtReverseHaar02Array")
    val delta = 1e-12
    val arrHilb = Array(2., 0., 0., 0., Math.sqrt(2.), 0., 1.)
    showHilb(arrHilb)
    val t = new Transform(new AncientEgyptianDecomposition(new FastWaveletTransform(Haar02)))
    val arrTime = t.reverse(arrHilb)
    showTime(arrTime)
    val expected = Array(1., 1., 1., 1., 1., 1., 1.)
    assertArray(expected, arrTime, delta)
  }

  /**
   * Test method for {@link math.jwave.Transform#forward(double[])}.
   * @throws JWaveException
   */
  @Test
  def testAncientEgyptianDecompositionWptForwardHaar02Array() {
    println("")
    println("testAncientEgyptianDecompositionWptForwardHaar02Array")
    val delta = 1.e-12
    val arrTime = Array(1., 2., 3., 4., 2., 0., 1.)
    showTime(arrTime)
    val t = new Transform(new AncientEgyptianDecomposition(new WaveletPacketTransform(Haar02)))
    val arrHilb = t.forward(arrTime)
    showHilb(arrHilb)
    val sqrt2 = Math.sqrt(2.)
    val expected = Array(5., -2., -1., 0., sqrt2, sqrt2, 1.)
    assertArray(expected, arrHilb, delta)
  }

  /**
   * Test method for {@link math.jwave.Transform#reverse(double[])}.
   * @throws JWaveException
   */
  @Test
  def testAncientEgyptianDecompositionWptReverseHaar02Array() {
    println("")
    println("testAncientEgyptianDecompositionWptReverseHaar02Array")
    val delta = 1e-12
    val sqrt2 = Math.sqrt(2.)
    val arrHilb = Array(5., -2., -1., 0., sqrt2, sqrt2, 1.)
    showHilb(arrHilb)
    val t = new Transform(new AncientEgyptianDecomposition(new WaveletPacketTransform(Haar02)))
    val arrTime = t.reverse(arrHilb)
    showTime(arrTime)
    val expected = Array(1., 2., 3., 4., 2., 0., 1.)
    assertArray(expected, arrTime, delta)
  }
}
