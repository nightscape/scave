package math.jwave.transforms

import math.jwave.transforms.wavelets.Wavelet
import scala.annotation.tailrec
/**
 * Base class for the forward and reverse Fast Wavelet Transform in 1-D, 2-D,
 * and 3-D using a specified Wavelet by inheriting class.
 *
 * @date 10.02.2010 08:10:42
 * @author Christian Scheiblich
 */
class FastWaveletTransform(wavelet: Wavelet, steps: Int = -1) extends WaveletTransform(wavelet, steps) {

  /**
   * Performs the 1-D forward transform for arrays of dim N from time domain to
   * Hilbert domain for the given array using the Fast Wavelet Transform (FWT)
   * algorithm.
   *
   * @see math.jwave.transforms.BasicTransform#forward(double[])
   */
  override def forward(arrTime: Seq[Double]): TimeFrequencyRepresentation = {
    def innerForward(level: Int, arrHilb: Seq[Double]): TimeFrequencyRepresentation = {
      if (arrHilb.size >= minWaveLength && (level < steps || steps == -1)) {
        val (approximation, details) = wavelet.splitSignal(arrHilb)
        WaveletBinaryTree(wavelet, innerForward(level + 1, approximation), WaveletNode(details))
      } else {
        WaveletNode(arrHilb)
      }
    }
    if (arrTime.length >= minWaveLength) {
      innerForward(0, arrTime)
    } else
      WaveletNode(arrTime)
  }


  /**
   * Performs the 1-D reverse transform for arrays of dim N from Hilbert domain
   * to time domain for the given array using the Fast Wavelet Transform (FWT)
   * algorithm and the selected wavelet.
   *
   * @see math.jwave.transforms.BasicTransform#reverse(double[])
   */

  protected def reverseTransform(_arrTime: Seq[Double], h: Int) = {
    val arrTime = _arrTime.toArray
    val slice = arrTime.slice(0, h)
    val (approximation, details) = slice.splitAt(h / 2)
    val oBuf = wavelet.mergeSignals(approximation, details).toArray
    Array.copy(oBuf, 0, arrTime, 0, h)
    arrTime
  }

  def filterTree(arrTime: Array[Double]): WaveletFilterTree = {
    null
  }
}
