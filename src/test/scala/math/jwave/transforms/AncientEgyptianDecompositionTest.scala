package math.jwave.transforms

import math.jwave.JUnitTests
import math.jwave.Transform
import math.jwave.transforms.wavelets.Haar02
import org.junit.Test

class AncientEgyptianDecompositionTest extends JUnitTests {
  @Test
  def testAncientEgyptianDecompositionFwtForwardHaar02Array() {
    val delta = 1.e-12
    val arrTime = Array(1., 1., 1., 1., 1., 1., 1.)
    val t = new Transform(new AncientEgyptianDecomposition(new FastWaveletTransform(Haar02)))
    val arrHilb = t.forward(arrTime)
    val expected = Array(2., 0., 0., 0., Math.sqrt(2.), 0., 1.)
    assertArray(expected, arrHilb, delta)
  }

  @Test
  def testAncientEgyptianDecompositionFwtReverseHaar02Array() {
    val delta = 1e-12
    val arrHilb = Array(2., 0., 0., 0., Math.sqrt(2.), 0., 1.)
    val t = new Transform(new AncientEgyptianDecomposition(new FastWaveletTransform(Haar02)))
    val arrTime = t.reverse(arrHilb)
    val expected = Array(1., 1., 1., 1., 1., 1., 1.)
    assertArray(expected, arrTime, delta)
  }

  @Test
  def testAncientEgyptianDecompositionWptForwardHaar02Array() {
    val delta = 1.e-12
    val arrTime = Array(1., 2., 3., 4., 2., 0., 1.)
    val t = new Transform(new AncientEgyptianDecomposition(new WaveletPacketTransform(Haar02)))
    val arrHilb = t.forward(arrTime)
    val sqrt2 = Math.sqrt(2.)
    val expected = Array(5., -2., -1., 0., sqrt2, sqrt2, 1.)
    assertArray(expected, arrHilb, delta)
  }

  @Test
  def testAncientEgyptianDecompositionWptReverseHaar02Array() {
    val delta = 1e-12
    val sqrt2 = Math.sqrt(2.)
    val arrHilb = Array(5., -2., -1., 0., sqrt2, sqrt2, 1.)
    val t = new Transform(new AncientEgyptianDecomposition(new WaveletPacketTransform(Haar02)))
    val arrTime = t.reverse(arrHilb)
    val expected = Array(1., 2., 3., 4., 2., 0., 1.)
    assertArray(expected, arrTime, delta)
  }
}
