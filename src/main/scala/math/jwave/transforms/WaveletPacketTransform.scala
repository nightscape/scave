package math.jwave.transforms

import math.jwave.transforms.wavelets.Wavelet
import scala.annotation.tailrec
/**
 * Base class for the forward and reverse Wavelet Packet Transform (WPT) also
 * called Wavelet Packet Decomposition (WPD) using a specified Wavelet by
 * inheriting class.
 */

class WaveletPacketTransform(wavelet: Wavelet, steps: Int = -1) extends WaveletTransform(wavelet, steps) {
  /**
   * Implementation of the 1-D forward wavelet packet transform for arrays of
   * dim N by filtering with the longest wavelet first and then always with both
   * sub bands -- low and high (approximation and details) -- by the next
   * smaller wavelet.
   *
   * @see math.jwave.transforms.BasicTransform#forward(double[])
   */
  override def forward(arrTime: Seq[Double]): TimeFrequencyRepresentation = {
    def innerForward(level: Int, arrHilb: Seq[Double]): TimeFrequencyRepresentation = {
      if (arrHilb.size >= minWaveLength && (level < steps || steps == -1)) {
        val (approximation, details) = wavelet.splitSignal(arrHilb)

        WaveletBinaryTree(wavelet, innerForward(level + 1, approximation), innerForward(level + 1, details))
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
   * Implementation of the 1-D reverse wavelet packet transform for arrays of
   * dim N by filtering with the smallest wavelet for all sub bands -- low and
   * high bands (approximation and details) -- and the by the next greater
   * wavelet combining two smaller and all other sub bands.
   *
   * @see math.jwave.transforms.BasicTransform#reverse(double[])
   */
  protected def reverseTransform(_arrTime: Seq[Double], h: Int) = {
    val arrTime = _arrTime.toArray
    val g = arrTime.length / h
    for (p <- 0 until g) {
      val iBuf = arrTime.view.slice(p * h, (p + 1) * h).toSeq
      val oBuf = wavelet.mergeSignals(iBuf.splitAt(iBuf.size / 2)).toArray
      Array.copy(oBuf, 0, arrTime, p * h, h)
    }
    arrTime
  }
  def filterTree(arrTime: Array[Double]): WaveletFilterTree = {
    val transformed = forward(arrTime)
    null
  }
}
