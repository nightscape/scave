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
abstract class WaveletTransform protected (val wavelet: Wavelet, val steps: Int = -1, val transformMode: TransformMode = null) extends BasicTransform[WaveletFilterTree] {

  require(wavelet != null, "WaveletTransfrom#checkConfig -- given object Wavelet is null")
  require(steps > 0 || steps == -1, s"WaveletTransfrom#checkConfig -- given steps are not valid: $steps")

  final def minWaveLength = wavelet.wavelength

  override def reverse(arrHilb: TimeFrequencyRepresentation): Seq[Double] = {
    arrHilb.restoreSignal
  }

  override def toString = s"${this.getClass.getSimpleName()} with wavelet type ${wavelet}"
}
