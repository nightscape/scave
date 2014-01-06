package math.jwave.types

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import spire.implicits._

/**
 * JUnit test cases for class Complex.
 *
 * @date 19.11.2010 13:41:10
 * @author Christian Scheiblich
 */
class ComplexTest {
  type Complex = spire.math.Complex[Double]

  /**
   * Test method for {@link math.jwave.datatypes.Complex#real()}.
   */
  @Test
  def testreal() {
    val a = new Complex(1., 1.)
    val real = a.real
    assertEquals(1., real, 0.)
  }

  /**
   * Test method for {@link math.jwave.datatypes.Complex#imag()}.
   */
  @Test
  def testimag() {
    val a = new Complex(1., 1.)
    val imag = a.imag
    assertEquals(1., imag, 0.)
  }

  /**
   * Test method for {@link math.jwave.datatypes.Complex#getMag()}.
   */
  @Test
  def testNorm() {
    var mag = 0.
    val a1 = new Complex(Math.sqrt(2.), Math.sqrt(2.))
    mag = a1.norm
    assertEquals(4., mag, 0.00000001)
  }

  /**
   * Test method for
   * {@link math.jwave.datatypes.Complex#add(math.jwave.datatypes.Complex)}.
   */
  @Test
  def testAdd() {
    val a = new Complex(1., 1.)
    val b = new Complex(1., 1.)
    val c = a + b
    assertEquals(2., c.real, 0.)
    assertEquals(2., c.imag, 0.)
  }

  /**
   * Test method for
   * {@link math.jwave.datatypes.Complex#sub(math.jwave.datatypes.Complex)}.
   */
  @Test
  def testSub() {
    val a = new Complex(2., 2.)
    val b = new Complex(1., 1.)
    val c = a - b
    assertEquals(1., c.real, 0.)
    assertEquals(1., c.imag, 0.)
  }

  /**
   * Test method for
   * {@link math.jwave.datatypes.Complex#mul(math.jwave.datatypes.Complex)}.
   */
  @Test
  def testMulComplex() {
    val a = new Complex(1., 1.)
    val b = new Complex(1., 1.)
    val c = a * b
    assertEquals(0., c.real, 0.)
    assertEquals(2., c.imag, 0.)
  }

  /**
   * Test method for {@link math.jwave.datatypes.Complex#mul(double)}.
   */
  @Test
  def testMulDouble() {
    val a = new Complex(1., 1.)
    val s = 2.
    val c = a * s
    assertEquals(2., c.real, 0.)
    assertEquals(2., c.imag, 0.)
  }

  /**
   * Test method for
   * {@link math.jwave.datatypes.Complex#div(math.jwave.datatypes.Complex)}.
   */
  @Test
  def testDivComplex() {
    val a = new Complex(0., 2.)
    val b = new Complex(1., 1.)
    val c = a / b
    assertEquals(1., c.real, 0.)
    assertEquals(1., c.imag, 0.)
  }

  /**
   * Test method for {@link math.jwave.datatypes.Complex#div(double)}.
   */
  @Test
  def testDivDouble() {
    val a = new Complex(1., 1.)
    val s = 2.
    val c = a / s
    assertEquals(.5, c.real, 0.)
    assertEquals(.5, c.imag, 0.)
  }

  /**
   * Test method for
   * {@link math.jwave.datatypes.Complex#equals(math.jwave.datatypes.Complex)}.
   */
  @Test
  def testEquals() {
    var isEqual = false
    val a = new Complex(1., 1.)
    val b = new Complex(1., 1.)
    isEqual = a == b
    assertTrue(isEqual)
    val c = new Complex(1., 1.)
    val d = new Complex(1., 2.)
    isEqual = c == d
    assertFalse(isEqual)
    val e = new Complex(1., 2.)
    val f = new Complex(1., 1.)
    isEqual = e == f
    assertFalse(isEqual)
    val g = new Complex(2., 1.)
    val h = new Complex(1., 1.)
    isEqual = g == h
    assertFalse(isEqual)
    val i = new Complex(1., 1.)
    val j = new Complex(2., 1.)
    isEqual = i == j
    assertFalse(isEqual)
  }
}
