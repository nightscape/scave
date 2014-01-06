package math.jwave

import org.junit.Assert.assertEquals
import math.jwave.datatypes.Complex
import math.jwave.transforms.FastWaveletTransform
import math.jwave.transforms.wavelets.Coif06
import math.jwave.transforms.wavelets.Daub02
import math.jwave.transforms.wavelets.Haar02
import math.jwave.transforms.wavelets.Wavelet
import org.junit.Test
//remove if not needed
import scala.collection.JavaConversions._

/**
 * Tests for the class math.jwave.Transform.
 *
 * @date 10.02.2010 09:43:08
 * @author Christian Scheiblich
 */
class JUnitTests {

  def assertArray(expected: Array[Complex], actual: Array[Complex], delta: Double) {
    val expectedLength = expected.length
    val actualLength = actual.length
    assertEquals(expectedLength, actualLength)
    for (c <- 0 until expectedLength) {
      val expectedReal = expected(c).getReal
      val expectedImag = expected(c).getImag
      val actualReal = actual(c).getReal
      val actualImag = actual(c).getImag
      assertEquals(expectedReal, actualReal, delta)
      assertEquals(expectedImag, actualImag, delta)
    }
  }

  /**
   * Test method to check the rounding error of several forward and reverse
   * transforms.
   *
   * @date 10.02.2010 10:28:00
   * @author Christian Scheiblich
   * @throws JWaveException
   */
  @Test
  def testRoundingHaar02FWT() {
    println("")
    println("testRoundingHaar02FWT")
    val delta = 1.e-8
    val arrTime = Array(1., 1.)
    testFastBasicTransformRounding(arrTime, new Haar02(), delta)
  }

  /**
   * Test method to check the rounding error of several forward and reverse
   * transforms.
   *
   * @date 10.02.2010 10:28:00
   * @author Christian Scheiblich
   * @throws JWaveException
   */
  @Test
  def testRoundingDaub04FWT() {
    println("")
    println("testRoundingDaub04FWT")
    val delta = 1.e-8
    val arrTime = Array(1., 1., 1., 1.)
    testFastBasicTransformRounding(arrTime, new Daub02(), delta)
  }

  /**
   * Test method to check the rounding error of several forward and reverse
   * transforms.
   *
   * @date 10.02.2010 10:28:00
   * @author Christian Scheiblich
   * @throws JWaveException
   */
  @Test
  def testRoundingCoif06FWT() {
    println("")
    println("testRoundingCoif06FWT")
    val delta = 1.e-8
    val arrTime = Array(1., 1., 1., 1., 1., 1.)
    testFastBasicTransformRounding(arrTime, new Coif06(), delta)
  }

  /**
   * Test method to check the rounding error of several forward and reverse
   * transforms.
   *
   * @date 10.02.2010 10:28:00
   * @author Christian Scheiblich
   * @throws JWaveException
   */
  def testFastBasicTransformRounding(arr: Array[Double], wavelet: Wavelet, delta: Double) {
    var noOfSteps = 10000000
    noOfSteps = 1000
    val arrTime = arr
    showTime(arrTime)
    var arrTimeRound = Array.ofDim[Double](arrTime.length)
    for (c <- 0 until arrTime.length) arrTimeRound(c) = arrTime(c)
    val t = new Transform(new FastWaveletTransform(wavelet))
    println("")
    println("")
    System.out.print("Performing: " + noOfSteps + " forward and reverse transforms ...")
    for (s <- 0 until noOfSteps) {
      arrTimeRound = t.reverse(t.forward(arrTimeRound))
    }
    println("")
    println("")
    assertArray(arrTime, arrTimeRound, delta)
    println("Input ...")
    showTime(arrTime)
    println("")
    println("Result ...")
    showTime(arrTimeRound)
    println("")
    val arrTimeErrorAbs = Array.ofDim[Double](arrTimeRound.length)
    for (c <- 0 until arrTimeRound.length) arrTimeErrorAbs(c) = Math.abs(arrTimeRound(c) - arrTime(c))
    println("Absolute error")
    showTime(arrTimeErrorAbs)
    println("")
    val arrTimeErrorRel = Array.ofDim[Double](arrTimeRound.length)
    for (c <- 0 until arrTimeRound.length) arrTimeErrorRel(c) = Math.abs((arrTimeRound(c) - arrTime(c)) * 100. / arrTime(c))
    println("Relative error [%] ...")
    showTime(arrTimeErrorRel)
    println("")
  }

  protected def assertArray(expected: Array[Double], actual: Array[Double], delta: Double) {
    for (i <- 0 until expected.length) assertEquals(expected(i), actual(i), delta)
  }

  protected def assertMatrix(expected: Array[Array[Double]], actual: Array[Array[Double]], delta: Double) {
    for (i <- 0 until expected.length; j <- 0 until expected(i).length) assertEquals(expected(i)(j), 
      actual(i)(j), delta)
  }

  protected def assertSpace(expected: Array[Array[Array[Double]]], actual: Array[Array[Array[Double]]], delta: Double) {
    for (i <- 0 until expected.length; j <- 0 until expected(i).length; k <- 0 until expected(i)(j).length) assertEquals(expected(i)(j)(k), 
      actual(i)(j)(k), delta)
  }

  protected def showTime(arrTime: Array[Double]) {
    System.out.print("time domain: " + "\t" + "\t")
    for (c <- 0 until arrTime.length) System.out.print(arrTime(c) + " ")
    println("")
  }

  protected def showFreq(arrFreq: Array[Double]) {
    System.out.print("frequency domain: " + "\t")
    for (c <- 0 until arrFreq.length) System.out.print(arrFreq(c) + " ")
    println("")
  }

  protected def showHilb(arrHilb: Array[Double]) {
    System.out.print("Hilbert domain: " + "\t")
    for (c <- 0 until arrHilb.length) System.out.print(arrHilb(c) + " ")
    println("")
  }

  protected def showTime(arrTime: Array[Complex]) {
    System.out.print("time domain: " + "\t" + "\t")
    for (c <- 0 until arrTime.length) System.out.print(arrTime(c).toString + " ")
    println("")
  }

  protected def showFreq(arrFreq: Array[Complex]) {
    System.out.print("frequency domain: " + "\t")
    for (c <- 0 until arrFreq.length) System.out.print(arrFreq(c).toString + " ")
    println("")
  }

  protected def showTime(matrixTime: Array[Array[Double]]) {
    println("time domain: " + "\t")
    for (i <- 0 until matrixTime.length) {
      for (j <- 0 until matrixTime(i).length) System.out.print(matrixTime(i)(j) + " ")
      println("")
    }
    println("")
  }

  protected def showFreq(matrixFreq: Array[Array[Double]]) {
    println("frequency domain: " + "\t")
    for (i <- 0 until matrixFreq.length) {
      for (j <- 0 until matrixFreq(i).length) System.out.print(matrixFreq(i)(j) + " ")
      println("")
    }
    println("")
  }

  protected def showHilb(matrixHilb: Array[Array[Double]]) {
    println("Hilbert domain: " + "\t")
    for (i <- 0 until matrixHilb.length) {
      for (j <- 0 until matrixHilb(i).length) System.out.print(matrixHilb(i)(j) + " ")
      println("")
    }
    println("")
  }

  protected def showTime(spaceTime: Array[Array[Array[Double]]]) {
    println("time domain: " + "\t")
    for (i <- 0 until spaceTime.length) {
      for (j <- 0 until spaceTime(i).length) {
        for (k <- 0 until spaceTime(i)(j).length) System.out.print(spaceTime(i)(j)(k) + " ")
        println("")
      }
      println("")
    }
    println("")
  }

  protected def showFreq(spaceTime: Array[Array[Array[Double]]]) {
    println("frequency domain: " + "\t")
    for (i <- 0 until spaceTime.length) {
      for (j <- 0 until spaceTime(i).length) {
        for (k <- 0 until spaceTime(i)(j).length) System.out.print(spaceTime(i)(j)(k) + " ")
        println("")
      }
      println("")
    }
    println("")
  }

  protected def showHilb(spaceTime: Array[Array[Array[Double]]]) {
    println("Hilbert domain: " + "\t")
    for (i <- 0 until spaceTime.length) {
      for (j <- 0 until spaceTime(i).length) {
        for (k <- 0 until spaceTime(i)(j).length) System.out.print(spaceTime(i)(j)(k) + " ")
        println("")
      }
      println("")
    }
    println("")
  }
}
