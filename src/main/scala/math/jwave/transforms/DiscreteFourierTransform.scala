package math.jwave.transforms

import spire.implicits._

/**
 * The Discrete Fourier Transform (DFT) is - as the name says - the discrete
 * version of the Fourier Transform applied to a discrete complex valued series.
 * While the DFT can be applied to any complex valued series; of any length, in
 * practice for large series it can take considerable time to compute, while the
 * time taken being proportional to the square of the number on points in the
 * series.
 *
 * @date 25.03.2010 19:56:29
 * @author Christian Scheiblich
 */
class DiscreteFourierTransform extends BasicTransform[Seq[Double]] {

  /**
   * The 1-D forward version of the Discrete Fourier Transform (DFT); The input
   * array arrTime is organized by real and imaginary parts of a complex number
   * using even and odd places for the index. For example: arrTime[ 0 ] = real1,
   * arrTime[ 1 ] = imag1, arrTime[ 2 ] = real2, arrTime[ 3 ] = imag2, ... The
   * output arrFreq is organized by the same scheme.
   *
   * @date 25.03.2010 19:56:29
   * @author Christian Scheiblich
   * @see math.jwave.transforms.BasicTransform#forward(double[])
   */
  override def forward(arrTime: Seq[Double]): TimeFrequencyRepresentation = {
    val m = arrTime.length
    val arrFreq = Array.ofDim[Double](m)
    val n = m >> 1
    for (i <- 0 until n) {
      val iR = i * 2
      val iC = i * 2 + 1
      arrFreq(iR) = 0.
      arrFreq(iC) = 0.
      val arg = -2. * Math.PI * i.toDouble / n.toDouble
      for (k <- 0 until n) {
        val kR = k * 2
        val kC = k * 2 + 1
        val cos = Math.cos(k * arg)
        val sin = Math.sin(k * arg)
        arrFreq(iR) += arrTime(kR) * cos - arrTime(kC) * sin
        arrFreq(iC) += arrTime(kR) * sin + arrTime(kC) * cos
      }
      arrFreq(iR) /= n.toDouble
      arrFreq(iC) /= n.toDouble
    }
    arrFreq
  }

  /**
   * The 1-D reverse version of the Discrete Fourier Transform (DFT); The input
   * array arrFreq is organized by real and imaginary parts of a complex number
   * using even and odd places for the index. For example: arrTime[ 0 ] = real1,
   * arrTime[ 1 ] = imag1, arrTime[ 2 ] = real2, arrTime[ 3 ] = imag2, ... The
   * output arrTime is organized by the same scheme.
   *
   * @date 25.03.2010 19:56:29
   * @author Christian Scheiblich
   * @see math.jwave.transforms.BasicTransform#reverse(double[])
   */
  override def reverse(arrFreq: TimeFrequencyRepresentation): Seq[Double] = {
    val m = arrFreq.length
    val arrTime = Array.ofDim[Double](m)
    val n = m >> 1
    for (i <- 0 until n) {
      val iR = i * 2
      val iC = i * 2 + 1
      arrTime(iR) = 0.
      arrTime(iC) = 0.
      val arg = 2. * Math.PI * i.toDouble / n.toDouble
      for (k <- 0 until n) {
        val kR = k * 2
        val kC = k * 2 + 1
        val cos = Math.cos(k * arg)
        val sin = Math.sin(k * arg)
        arrTime(iR) += arrFreq(kR) * cos - arrFreq(kC) * sin
        arrTime(iC) += arrFreq(kR) * sin + arrFreq(kC) * cos
      }
    }
    arrTime
  }

  /**
   * The 1-D forward version of the Discrete Fourier Transform (DFT); The input
   * array arrTime is organized by a class called Complex keeping real and
   * imaginary part of a complex number. The output arrFreq is organized by the
   * same scheme.
   *
   * @date 23.11.2010 18:57:34
   * @author Christian Scheiblich
   * @param arrTime
   *          array of type Complex keeping coefficients of complex numbers
   * @return array of type Complex keeping the discrete fourier transform
   *         coefficients
   */
  override def forward(arrTime: Array[Complex]): Array[Complex] = {
    val n = arrTime.length
    val arrFreq = Array.ofDim[Complex](n)
    for (i <- 0 until n) {
      arrFreq(i) = new Complex(0., 0.)
      val arg = -2. * Math.PI * i.toDouble / n.toDouble
      for (k <- 0 until n) {
        val cos = Math.cos(k * arg)
        val sin = Math.sin(k * arg)
        val real = arrTime(k).real
        val imag = arrTime(k).imag
        arrFreq(i) += new Complex(real * cos - imag * sin, real * sin + imag * cos)
      }
      arrFreq(i) *= 1. / n.toDouble
    }
    arrFreq
  }

  /**
   * The 1-D reverse version of the Discrete Fourier Transform (DFT); The input
   * array arrFreq is organized by a class called Complex keeping real and
   * imaginary part of a complex number. The output arrTime is organized by the
   * same scheme.
   *
   * @date 23.11.2010 19:02:12
   * @author Christian Scheiblich
   * @param arrFreq
   *          array of type Complex keeping the discrete fourier transform
   *          coefficients
   * @return array of type Complex keeping coefficients of tiem domain
   */
  override def reverse(arrFreq: Array[Complex]): Array[Complex] = {
    val n = arrFreq.length
    val arrTime = Array.ofDim[Complex](n)
    for (i <- 0 until n) {
      arrTime(i) = new Complex(0., 0.)
      val arg = 2. * Math.PI * i.toDouble / n.toDouble
      for (k <- 0 until n) {
        val cos = Math.cos(k * arg)
        val sin = Math.sin(k * arg)
        val real = arrFreq(k).real
        val imag = arrFreq(k).imag
        arrTime(i) += new Complex(real * cos - imag * sin, real * sin + imag * cos)
      }
    }
    arrTime
  }

  /**
   * The 2-D forward version of the Discrete Fourier Transform (DFT); The input
   * array matTime is organized by real and imaginary parts of a complex number
   * using even and odd places for the indices. For example: matTime[0][0] =
   * real11, matTime[0][1] = imag11, matTime[0][2] = real12, matTime[0][3] =
   * imag12, matTime[1][0] = real21, matTime[1][1] = imag21, matTime[1][2] =
   * real22, matTime[1][3] = imag2... The output matFreq is organized by the
   * same scheme.
   *
   * @date 25.03.2010 19:56:29
   * @author Christian Scheiblich
   * @see math.jwave.transforms.BasicTransform#forward(double[][])
   */
//  override def forward(matTime: Array[Array[Double]]): Array[Array[Double]] = null

  /**
   * The 2-D reverse version of the Discrete Fourier Transform (DFT); The input
   * array matFreq is organized by real and imaginary parts of a complex number
   * using even and odd places for the indices. For example: matFreq[0][0] =
   * real11, matFreq[0][1] = imag11, matFreq[0][2] = real12, matFreq[0][3] =
   * imag12, matFreq[1][0] = real21, matFreq[1][1] = imag21, matFreq[1][2] =
   * real22, matFreq[1][3] = imag2... The output matTime is organized by the
   * same scheme.
   *
   * @date 25.03.2010 19:56:29
   * @author Christian Scheiblich
   * @see math.jwave.transforms.BasicTransform#reverse(double[][])
   */
//  override def reverse(matFreq: Array[Array[Double]]): Array[Array[Double]] = null

  /**
   * The 3-D forward version of the Discrete Fourier Transform (DFT);
   *
   * @date 10.07.2010 18:10:43
   * @author Christian Scheiblich
   * @see math.jwave.transforms.BasicTransform#forward(double[][][])
   */
//  override def forward(spcTime: Array[Array[Array[Double]]]): Array[Array[Array[Double]]] = null

  /**
   * The 3-D reverse version of the Discrete Fourier Transform (DFT);
   *
   * @date 10.07.2010 18:10:45
   * @author Christian Scheiblich
   * @see math.jwave.transforms.BasicTransform#reverse(double[][][])
   */
//  override def reverse(spcHilb: Array[Array[Array[Double]]]): Array[Array[Array[Double]]] = null
}
