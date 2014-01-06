package math.jwave.types

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import math.jwave.datatypes.Complex
import org.junit.Test
//remove if not needed
import scala.collection.JavaConversions._

/**
 * JUnit test cases for class Complex.
 *
 * @date 19.11.2010 13:41:10
 * @author Christian Scheiblich
 */
class ComplexTest {

  /**
   * Test method for {@link math.jwave.datatypes.Complex#getReal()}.
   */
  @Test
  def testGetReal() {
    val a = new Complex(1., 1.)
    val real = a.getReal
    assertEquals(1., real, 0.)
  }

  /**
   * Test method for {@link math.jwave.datatypes.Complex#getImag()}.
   */
  @Test
  def testGetImag() {
    val a = new Complex(1., 1.)
    val imag = a.getImag
    assertEquals(1., imag, 0.)
  }

  /**
   * Test method for {@link math.jwave.datatypes.Complex#getMag()}.
   */
  @Test
  def testGetMag() {
    var mag = 0.
    val a1 = new Complex(Math.sqrt(2.), Math.sqrt(2.))
    mag = a1.getMag
    assertEquals(2., mag, 0.)
  }

  /**
   * Test method for {@link math.jwave.datatypes.Complex#getPhi()}.
   */
  @Test
  def testGetPhi() {
    var phi = 0.
    val a1 = new Complex(1., 0.)
    phi = a1.getPhi
    assertEquals(0., phi, 0.)
    val b1 = new Complex(1., 1.)
    phi = b1.getPhi
    assertEquals(45., phi, 0.)
    val c1 = new Complex(0., 1.)
    phi = c1.getPhi
    assertEquals(90., phi, 0.)
    val a2 = new Complex(-1., 1.)
    phi = a2.getPhi
    assertEquals(135., phi, 0.)
    val b2 = new Complex(-1., 0.)
    phi = b2.getPhi
    assertEquals(180., phi, 0.)
    val a3 = new Complex(-1., -1.)
    phi = a3.getPhi
    assertEquals(225., phi, 0.)
    val b3 = new Complex(0., -1.)
    phi = b3.getPhi
    assertEquals(270., phi, 0.)
    val a4 = new Complex(1., -1.)
    phi = a4.getPhi
    assertEquals(315., phi, 0.)
  }

  /**
   * Test method for
   * {@link math.jwave.datatypes.Complex#add(math.jwave.datatypes.Complex)}.
   */
  @Test
  def testAdd() {
    val a = new Complex(1., 1.)
    val b = new Complex(1., 1.)
    val c = a.add(b)
    assertEquals(2., c.getReal, 0.)
    assertEquals(2., c.getImag, 0.)
  }

  /**
   * Test method for
   * {@link math.jwave.datatypes.Complex#sub(math.jwave.datatypes.Complex)}.
   */
  @Test
  def testSub() {
    val a = new Complex(2., 2.)
    val b = new Complex(1., 1.)
    val c = a.sub(b)
    assertEquals(1., c.getReal, 0.)
    assertEquals(1., c.getImag, 0.)
  }

  /**
   * Test method for
   * {@link math.jwave.datatypes.Complex#mul(math.jwave.datatypes.Complex)}.
   */
  @Test
  def testMulComplex() {
    val a = new Complex(1., 1.)
    val b = new Complex(1., 1.)
    val c = a.mul(b)
    assertEquals(0., c.getReal, 0.)
    assertEquals(2., c.getImag, 0.)
  }

  /**
   * Test method for {@link math.jwave.datatypes.Complex#mul(double)}.
   */
  @Test
  def testMulDouble() {
    val a = new Complex(1., 1.)
    val s = 2.
    val c = a.mul(s)
    assertEquals(2., c.getReal, 0.)
    assertEquals(2., c.getImag, 0.)
  }

  /**
   * Test method for
   * {@link math.jwave.datatypes.Complex#div(math.jwave.datatypes.Complex)}.
   */
  @Test
  def testDivComplex() {
    val a = new Complex(0., 2.)
    val b = new Complex(1., 1.)
    val c = a.div(b)
    assertEquals(1., c.getReal, 0.)
    assertEquals(1., c.getImag, 0.)
  }

  /**
   * Test method for {@link math.jwave.datatypes.Complex#div(double)}.
   */
  @Test
  def testDivDouble() {
    val a = new Complex(1., 1.)
    val s = 2.
    val c = a.div(s)
    assertEquals(.5, c.getReal, 0.)
    assertEquals(.5, c.getImag, 0.)
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
