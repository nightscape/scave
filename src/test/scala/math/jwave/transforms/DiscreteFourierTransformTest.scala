package math.jwave.transforms

import math.jwave.JUnitTests
import math.jwave.Transform
import math.jwave.datatypes.Complex
import org.junit.Test

/**
 * Tests for the base methods of class DiscreteFourierTransform.
 *
 * @date 23.11.2010 19:05:07
 * @author Christian Scheiblich
 */
class DiscreteFourierTransformTest extends JUnitTests {

  /**
   * Test method for
   * {@link math.jwave.transforms.DiscreteFourierTransform#forward(double[])}.
   */
  @Test
  def testForwardDoubleArray() {
    println("")
    println("testDiscreteFourierTransformForwardDoubleArray")
    val delta = 1.e-12
    val arrTime = Array(1., 1., 1., 1., 1., 1., 1., 1.)
    showTime(arrTime)
    val t = new Transform(new DiscreteFourierTransform())
    val arrFreq = t.forward(arrTime)
    showFreq(arrFreq)
    val expected = Array(1., 1., 0., 0., 0., 0, 0., 0.)
    assertArray(expected, arrFreq, delta)
  }

  /**
   * Test method for
   * {@link math.jwave.transforms.DiscreteFourierTransform#reverse(double[])}.
   */
  @Test
  def testReverseDoubleArray() {
    println("")
    println("testDiscreteFourierTransformReverseDoubleArray")
    val delta = 1e-12
    val arrFreq = Array(1., 1., 0., 0., 0., 0, 0., 0.)
    showHilb(arrFreq)
    val t = new Transform(new DiscreteFourierTransform())
    val arrTime = t.reverse(arrFreq)
    showTime(arrTime)
    val expected = Array(1., 1., 1., 1., 1., 1., 1., 1.)
    assertArray(expected, arrTime, delta)
  }

  /**
   * Test method for
   * {@link math.jwave.transforms.DiscreteFourierTransform#forward(math.jwave.datatypes.Complex[])}
   * .
   */
  @Test
  def testForwardComplexArray() {
    println("")
    println("testDiscreteFourierTransformForwardComplexArray")
    val delta = 1.e-12
    val arrTime = Array(new Complex(1., 1.), new Complex(1., 1.), new Complex(1., 1.), new Complex(1., 
      1.))
    showTime(arrTime)
    val t = new Transform(new DiscreteFourierTransform())
    val arrFreq = t.forward(arrTime)
    showFreq(arrFreq)
    val expected = Array(new Complex(1., 1.), new Complex(0., 0.), new Complex(0., 0.), new Complex(0., 
      0.))
    assertArray(expected, arrFreq, delta)
  }

  /**
   * Test method for
   * {@link math.jwave.transforms.DiscreteFourierTransform#reverse(math.jwave.datatypes.Complex[])}
   * .
   */
  @Test
  def testReverseComplexArray() {
    println("")
    println("testDiscreteFourierTransformReverseDoubleArray")
    val delta = 1e-12
    val arrFreq = Array(new Complex(1., 1.), new Complex(0., 0.), new Complex(0., 0.), new Complex(0., 
      0.))
    showFreq(arrFreq)
    val t = new Transform(new DiscreteFourierTransform())
    val arrTime = t.reverse(arrFreq)
    showTime(arrTime)
    val expected = Array(new Complex(1., 1.), new Complex(1., 1.), new Complex(1., 1.), new Complex(1., 
      1.))
    assertArray(expected, arrTime, delta)
  }
}
