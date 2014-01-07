package math.jwave

import org.junit.Assert._
import math.jwave.transforms.FastWaveletTransform
import math.jwave.transforms.wavelets.Coif06
import math.jwave.transforms.wavelets.Daub02
import math.jwave.transforms.wavelets.Haar02
import math.jwave.transforms.wavelets.Wavelet
import org.junit.Test

/**
 * Tests for the class math.jwave.Transform.
 *
 * @date 10.02.2010 09:43:08
 * @author Christian Scheiblich
 */
class JUnitTests extends org.scalatest.Matchers {
  type Complex = spire.math.Complex[Double]

  def assertArray(expected: Array[Complex], actual: Array[Complex], delta: Double) {
    actual should have length(expected.length)
    val diff = actual.zip(expected).map { case (a, e) => a - e }
    all(diff.map(_.norm)) should be < delta * delta
  }


  @Test
  def testRoundingHaar02FWT() {
    testFastBasicTransformRounding(Array(1., 1.), new Haar02(), 1.e-8)
  }

  @Test
  def testRoundingDaub04FWT() {
    testFastBasicTransformRounding(Array(1., 1., 1., 1.), new Daub02(), 1.e-8)
  }

  @Test
  def testRoundingCoif06FWT() {
    testFastBasicTransformRounding(Array(1., 1., 1., 1., 1., 1.), new Coif06(), 1.e-8)
  }

  /**
   * Test method to check the rounding error of several forward and reverse
   * transforms.
   */
  def testFastBasicTransformRounding(arr: Array[Double], wavelet: Wavelet, delta: Double) {
    var noOfSteps = 10000000
    noOfSteps = 1000
    val arrTime = arr
    showTime(arrTime)
    var arrTimeRound = arrTime.clone
    val t = new Transform(new FastWaveletTransform(wavelet))
    for (s <- 0 until noOfSteps) {
      arrTimeRound = t.reverse(t.forward(arrTimeRound))
    }
    assertArray(arrTime, arrTimeRound, delta)
    val arrTimeErrorAbs = arrTimeRound.zip(arrTime).map{ case (a,b) => (a - b).abs }
    val arrTimeErrorRel = arrTimeRound.zip(arrTime).map{ case (a,b) => (a - b).abs * 100 / b }
    assertTrue(arrTimeErrorRel.max < delta)
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
