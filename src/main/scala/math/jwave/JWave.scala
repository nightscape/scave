package math.jwave

import math.jwave.transforms.BasicTransform
import math.jwave.transforms.DiscreteFourierTransform
import math.jwave.transforms.FastWaveletTransform
import math.jwave.transforms.WaveletPacketTransform
import math.jwave.transforms.wavelets.Coif06
import math.jwave.transforms.wavelets.Daub02
import math.jwave.transforms.wavelets.Daub03
import math.jwave.transforms.wavelets.Daub04
import math.jwave.transforms.wavelets.Haar02
import math.jwave.transforms.wavelets.Lege02
import math.jwave.transforms.wavelets.Lege04
import math.jwave.transforms.wavelets.Lege06
import math.jwave.transforms.wavelets.Wavelet
import JWave._
//remove if not needed
import scala.collection.JavaConversions._

object JWave {

  /**
   * Main method for doing little test runs for different transform types and
   * different wavelets without JUnit. Requesting the transform type and the
   * type of wavelet to be used else usage is printed.
   *
   * @date 23.02.2010 14:26:47
   * @author Christian Scheiblich
   * @param args
   *          [transformType] [waveletType]
   */
  def main(args: Array[String]) {
    val waveletTypeList = "Haar02, Daub02, Daub04, Lege02"
    if (args.length < 2 || args.length > 3) {
      System.err.println("usage: JWave [transformType] {waveletType} {noOfSteps}")
      System.err.println("")
      System.err.println("transformType: DFT, FWT, WPT, DWT")
      System.err.println("waveletType : " + waveletTypeList)
      System.err.println("noOfSteps : " + "no of steps forward and reverse; optional")
      return
    }
    val wType = args(1)
    var wavelet: Wavelet = null
    if (wType.equalsIgnoreCase("haar02")) wavelet = Haar02
    else if (wType.equalsIgnoreCase("lege02")) wavelet = Lege02
    else if (wType.equalsIgnoreCase("daub02")) wavelet = Daub02
    else if (wType.equalsIgnoreCase("daub03")) wavelet = Daub03
    else if (wType.equalsIgnoreCase("daub04")) wavelet = Daub04
    else if (wType.equalsIgnoreCase("lege04")) wavelet = Lege04
    else if (wType.equalsIgnoreCase("lege06")) wavelet = Lege06
    else if (wType.equalsIgnoreCase("coif06")) wavelet = Coif06
    else {
      System.err.println("usage: JWave [transformType] {waveletType}")
      System.err.println("")
      System.err.println("available wavelets are " + waveletTypeList)
      return
    }
    val tType = args(0)
    var bWave: BasicTransform = null
    if (tType.equalsIgnoreCase("dft")) bWave = new DiscreteFourierTransform() else if (tType.equalsIgnoreCase("fwt")) bWave = new FastWaveletTransform(wavelet) else if (tType.equalsIgnoreCase("wpt")) bWave = new WaveletPacketTransform(wavelet) else {
      System.err.println("usage: JWave [transformType] {waveletType}")
      System.err.println("")
      System.err.println("available transforms are DFT, FWT, WPT")
      return
    }
    var t: Transform = null
    if (args.length > 2) {
      val argNoOfSteps = args(2)
      val noOfSteps = Integer.parseInt(argNoOfSteps)
      t = new Transform(bWave, noOfSteps)
    } else {
      t = new Transform(bWave)
    }
    val arrTime = Array(1., 1., 1., 1., 1., 1., 1., 1.)
    println("")
    println("time domain:")
    for (p <- 0 until arrTime.length) println(f"${arrTime(p)}%9.6f")
    println("")
    val arrFreqOrHilb = t.forward(arrTime)
    if (bWave.isInstanceOf[DiscreteFourierTransform]) println("frequency domain:") else println("Hilbert domain:")
    for (p <- 0 until arrTime.length) println(f"${arrFreqOrHilb(p)}%9.6f")
    println("")
    val arrReco = t.reverse(arrFreqOrHilb)
    println("reconstruction:")
    for (p <- 0 until arrTime.length) println(f"${arrReco(p)}%9.6f")
    println("")
  }
}

/**
 * Main class for doing little test runs for different transform types and
 * different wavelets without JUnit.
 *
 * @date 23.02.2010 14:26:47
 * @author Christian Scheiblich
 */
class JWave
