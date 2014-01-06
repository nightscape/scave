package math.jwave.transforms

import math.jwave.tools.AncientEgyptianMultiplication

/**
 * A wavelet transform method for arrays and signals of arbitrary lengths, even
 * odd lengths. The array is decomposed in several parts of optimal lengths by
 * applying the ancient Egyptian decomposition. Hereby, the array or signal is
 * decomposed to the largest possible sub arrays of two the power of p.
 * Afterwards each sub array is transformed forward and copied back to the
 * discrete position of the input array. The reverse transform applies the same
 * vice versa. In more detail the ancient Egyptian Multiplication can be easily
 * explained by the following example: 42 = 2^5 + 2^3 + 2^1 = 32 + 8 + 2.
 * However, an array or signal of odd length produces the smallest ancient
 * Egyptian multiplier 2^0 which is actually 1. Therefore, the matching sub
 * array or signal is untouched an the coefficient is actually the wavelet
 * coefficient of wavelet space of level 0. For an "orthonormal" wavelet this
 * holds. See: http://en.wikipedia.org/wiki/Ancient_Egyptian_multiplication
 *
 * @date 14.08.2010 10:43:28
 * @author Christian Scheiblich
 */
class AncientEgyptianDecomposition(protected var _waveTransform: BasicTransform)
    extends BasicTransform {

  private var _ancientEgyptianMultiplication: AncientEgyptianMultiplication = new AncientEgyptianMultiplication()

  /**
   * This forward method decomposes the given array of arbitrary length to sub
   * arrays while applying the ancient Egyptian decomposition. Each sub array is
   * transformed by the selected basic transform and the resulting wavelet
   * coefficients are copied back to their original discrete positions.
   *
   * @date 14.08.2010 10:43:28
   * @author Christian Scheiblich
   * @see math.jwave.transforms.BasicTransform#forward(double[])
   */
  override def forward(arrTime: Array[Double]): Array[Double] = {
    val arrHilb = Array.ofDim[Double](arrTime.length)
    var ancientEgyptianMultipliers: Array[Int] = null
    try {
      ancientEgyptianMultipliers = _ancientEgyptianMultiplication.decompose(arrTime.length)
    } catch {
      case e: Exception => e.printStackTrace()
    }
    var offSet = 0
    for (m <- 0 until ancientEgyptianMultipliers.length) {
      val ancientEgyptianMultiplier = ancientEgyptianMultipliers(m)
      val arrTimeSubLength = _ancientEgyptianMultiplication.scalb(1., ancientEgyptianMultiplier).toInt
      val arrTimeSub = Array.ofDim[Double](arrTimeSubLength)
      for (i <- 0 until arrTimeSub.length) arrTimeSub(i) = arrTime(i + offSet)
      val arrHilbSub = _waveTransform.forward(arrTimeSub)
      for (i <- 0 until arrHilbSub.length) arrHilb(i + offSet) = arrHilbSub(i)
      offSet += arrHilbSub.length
    }
    arrHilb
  }

  /**
   * This reverse method awaits an array of arbitrary length in wavelet space
   * keeping the wavelet already decomposed by the ancient Egyptian
   * decomposition. Therefore, each of the existing sub arrays of length 2^p is
   * reverse transformed by the selected basic transform and the resulting
   * coefficients of time domain are copied back to their original discrete
   * positions.
   *
   * @date 14.08.2010 10:43:28
   * @author Christian Scheiblich
   * @see math.jwave.transforms.BasicTransform#reverse(double[])
   */
  override def reverse(arrHilb: Array[Double]): Array[Double] = {
    val arrTime = Array.ofDim[Double](arrHilb.length)
    var ancientEgyptianMultipliers: Array[Int] = null
    try {
      ancientEgyptianMultipliers = _ancientEgyptianMultiplication.decompose(arrHilb.length)
    } catch {
      case e: Exception => e.printStackTrace()
    }
    var offSet = 0
    for (m <- 0 until ancientEgyptianMultipliers.length) {
      val ancientEgyptianMultiplier = ancientEgyptianMultipliers(m)
      val arrHilbSubLength = _ancientEgyptianMultiplication.scalb(1., ancientEgyptianMultiplier).toInt
      val arrHilbSub = Array.ofDim[Double](arrHilbSubLength)
      for (i <- 0 until arrHilbSub.length) arrHilbSub(i) = arrHilb(i + offSet)
      val arrTimeSub = _waveTransform.reverse(arrHilbSub)
      for (i <- 0 until arrTimeSub.length) arrTime(i + offSet) = arrTimeSub(i)
      offSet += arrHilbSub.length
    }
    arrTime
  }
}
