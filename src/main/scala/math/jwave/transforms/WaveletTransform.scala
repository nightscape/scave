package math.jwave.transforms

import java.util.Arrays
import math.jwave.transforms.modes.TransformMode
import math.jwave.transforms.wavelets.Wavelet
import _root_.scala.annotation.tailrec
/**
 * A Wavelet transform that is reduced to some minor steps depending on the
 * supported TransformMode object that handles how to treat the given data.
 *
 * @param wavelet The used wavelet for transforming
 * @param steps The steps the Wavelet transform should do. If it is set to -1,
 * the transform algorithms perform the maximum number of steps.
 * A Wavelet transform that is reduced to minor steps as given
 * by a positive number.
 * @param transformMode Specifying how the transform should do its job.
 *
 * @throws JWaveException
 */
abstract class WaveletTransform protected (protected val wavelet: Wavelet, val steps: Int, val transformMode: TransformMode = null) extends BasicTransform {

  protected def this(wavelet: Wavelet) = this(wavelet, -1, null)

  require(wavelet != null, "WaveletTransfrom#checkConfig -- given object Wavelet is null")
  require(steps > 0 || steps == -1, s"WaveletTransfrom#checkConfig -- given steps are not valid: $steps")

  final def minWaveLength = wavelet.wavelength

  override def forward(arrTime: Array[Double]): Array[Double] = {
    @tailrec
    def innerForward(level: Int, windowSize: Int, arrHilb: Array[Double]): Array[Double] = {
      if (windowSize >= minWaveLength && (level < steps || steps == -1)) {
        innerForward(level + 1, windowSize / 2, forwardTransform(arrHilb, windowSize))
      } else {
        arrHilb
      }
    }
    if (arrTime.length >= minWaveLength) {
      innerForward(0, arrTime.length, arrTime.clone)
    } else
      arrTime
  }

  protected def forwardTransform(arrTime: Array[Double], h: Int): Array[Double]

  override def reverse(arrHilb: Array[Double]): Array[Double] = {
    @tailrec
    def innerReverse(level: Int, h: Int, arrTime: Array[Double]): Array[Double] = {
      if (h <= arrTime.length && (level < steps || steps == -1)) {
        innerReverse(level + 1, h << 1, reverseTransform(arrTime, h))
      } else {
        arrTime
      }
    }
    if (arrHilb.length >= minWaveLength) {
      innerReverse(0, minWaveLength, arrHilb.clone)
    } else
      arrHilb
  }

  protected def reverseTransform(arrTime: Array[Double], h: Int): Array[Double]
}
