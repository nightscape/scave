package math.jwave.transforms

import math.jwave.transforms.wavelets.Wavelet
/**
 * Base class for the forward and reverse Fast Wavelet Transform in 1-D, 2-D,
 * and 3-D using a specified Wavelet by inheriting class.
 * 
 * @date 10.02.2010 08:10:42
 * @author Christian Scheiblich
 */
class FastWaveletTransform(wavelet: Wavelet, steps: Int) extends WaveletTransform(wavelet, steps) {

  def this(wavelet: Wavelet) = this(wavelet, -1)

  /**
   * Performs the 1-D forward transform for arrays of dim N from time domain to
   * Hilbert domain for the given array using the Fast Wavelet Transform (FWT)
   * algorithm.
   * 
   * @see math.jwave.transforms.BasicTransform#forward(double[])
   */
  protected def forwardTransform(arrHilb: Array[Double], windowSize: Int) = {
    val oBuf = wavelet.forward(arrHilb.view.slice(0, windowSize))
    Array.copy(oBuf, 0, arrHilb, 0, windowSize)
    arrHilb
  }
  /**
   * Performs the 1-D reverse transform for arrays of dim N from Hilbert domain
   * to time domain for the given array using the Fast Wavelet Transform (FWT)
   * algorithm and the selected wavelet.
   * 
   * @see math.jwave.transforms.BasicTransform#reverse(double[])
   */

  protected def reverseTransform(arrTime: Array[Double], h: Int) = {
    val oBuf = wavelet.reverse(arrTime.slice(0, h))
    Array.copy(oBuf, 0, arrTime, 0, h)
    arrTime
  }
}
