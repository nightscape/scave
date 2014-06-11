package math.jwave.transforms

import math.jwave.JUnitTests
import org.junit.Test
import spire.implicits._

class DiscreteFourierTransformTest extends JUnitTests {
  @Test
  def testForwardDoubleArray() {
    val delta = 1.0e-12
    val arrTime = Array(1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0)
    val t = new DiscreteFourierTransform()
    val arrFreq = t.forward(arrTime)
    val expected = Array(1.0, 1.0, 0.0, 0.0, 0.0, 0, 0.0, 0.0)
    assertArray(expected, arrFreq, delta)
  }

  @Test
  def testReverseDoubleArray() {
    val delta = 1e-12
    val arrFreq = Array(1.0, 1.0, 0.0, 0.0, 0.0, 0, 0.0, 0.0)
    val t = new DiscreteFourierTransform()
    val arrTime = t.reverse(arrFreq)
    val expected = Array(1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0)
    assertArray(expected, arrTime, delta)
  }

  @Test
  def testForwardComplexArray() {
    val delta = 1.0e-12
    val arrTime = Array(new Complex(1.0, 1.0), new Complex(1.0, 1.0), new Complex(1.0, 1.0), new Complex(1.0, 1.0))
    val t = new DiscreteFourierTransform()
    val arrFreq = t.forward(arrTime)
    val expected = Array(new Complex(1.0, 1.0), new Complex(0.0, 0.0), new Complex(0.0, 0.0), new Complex(0.0, 0.0))
    assertArray(expected, arrFreq, delta)
  }

  @Test
  def testReverseComplexArray() {
    val delta = 1e-12
    val arrFreq = Array(new Complex(1.0, 1.0), new Complex(0.0, 0.0), new Complex(0.0, 0.0), new Complex(0.0, 0.0))
    val t = new DiscreteFourierTransform()
    val arrTime = t.reverse(arrFreq)
    val expected = Array(new Complex(1.0, 1.0), new Complex(1.0, 1.0), new Complex(1.0, 1.0), new Complex(1.0, 1.0))
    assertArray(expected, arrTime, delta)
  }
}
