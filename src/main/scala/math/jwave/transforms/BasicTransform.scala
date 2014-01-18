package math.jwave.transforms


/**
 * Basic Wave for transformations like Fast Fourier Transform (FFT), Fast
 * Wavelet Transform (FWT), Fast Wavelet Packet Transform (WPT), or Discrete
 * Wavelet Transform (DWT). Naming of this class due to en.wikipedia.org; to
 * write Fourier series in terms of the 'basic waves' of function: e^(2*pi*i*w).
 *
 * @date 08.02.2010 11:11:59
 * @author Christian Scheiblich
 */
abstract class BasicTransform[T] {
  type TimeFrequencyRepresentation = T
  type Complex = spire.math.Complex[Double]

  /**
   * Performs the forward transform from time domain to frequency or Hilbert
   * domain for a given array depending on the used transform algorithm by
   * inheritance.
   *
   * @param arrTime coefficients of 1-D time domain
   * @return coefficients of 1-D frequency or Hilbert domain
   */
  def forward(arrTime: Seq[Double]): TimeFrequencyRepresentation

  /**
   * Performs the reverse transform from frequency or Hilbert domain to time
   * domain for a given array depending on the used transform algorithm by
   * inheritance.
   *
   * @param arrFreq coefficients of 1-D frequency or Hilbert domain
   * @return coefficients of 1-D time domain
   */
  def reverse(arrFreq: TimeFrequencyRepresentation): Seq[Double]

  /**
   * Performs the forward transform from time domain to frequency or Hilbert
   * domain for a given array depending on the used transform algorithm by
   * inheritance.
   *
   * @param arrTime coefficients of 1-D time domain
   * @return coefficients of 1-D frequency or Hilbert domain
   */
  def forward(arrTime: Array[Complex]): Array[Complex] = null

  /**
   * Performs the reverse transform from frequency or Hilbert domain to time
   * domain for a given array depending on the used transform algorithm by
   * inheritance.
   *
   * @param arrFreq coefficients of 1-D frequency or Hilbert domain
   * @return coefficients of 1-D time domain
   */
  def reverse(arrFreq: Array[Complex]): Array[Complex] = null

//  /**
//   * Performs the 2-D forward transform from time domain to frequency or Hilbert
//   * domain for a given array depending on the used transform algorithm by
//   * inheritance.
//   *
//   * @param matTime coefficients of 2-D time domain
//   * @return coefficients of 2-D frequency or Hilbert domain
//   */
//  def forward(matTime: Array[Array[Double]]): Array[Array[Double]] = {
//    val noOfRows = matTime.length
//    val noOfCols = matTime(0).length
//    val matHilb = Array.ofDim[Double](noOfRows, noOfCols)
//    for (i <- 0 until noOfRows) {
//      val arrTime = Array.ofDim[Double](noOfCols)
//      for (j <- 0 until noOfCols) arrTime(j) = matTime(i)(j)
//      val arrHilb = forward(arrTime)
//      for (j <- 0 until noOfCols) matHilb(i)(j) = arrHilb(j)
//    }
//    for (j <- 0 until noOfCols) {
//      val arrTime = Array.ofDim[Double](noOfRows)
//      for (i <- 0 until noOfRows) arrTime(i) = matHilb(i)(j)
//      val arrHilb = forward(arrTime)
//      for (i <- 0 until noOfRows) matHilb(i)(j) = arrHilb(i)
//    }
//    matHilb
//  }
//
//  /**
//   * Performs the 2-D reverse transform from frequency or Hilbert or time domain
//   * to time domain for a given array depending on the used transform algorithm
//   * by inheritance.
//   *
//   * @param matFreq coefficients of 2-D frequency or Hilbert domain
//   * @return coefficients of 2-D time domain
//   */
//  def reverse(matFreq: Array[Array[Double]]): Array[Array[Double]] = {
//    val noOfRows = matFreq.length
//    val noOfCols = matFreq(0).length
//    val matTime = Array.ofDim[Double](noOfRows, noOfCols)
//    for (j <- 0 until noOfCols) {
//      val arrFreq = Array.ofDim[Double](noOfRows)
//      for (i <- 0 until noOfRows) arrFreq(i) = matFreq(i)(j)
//      val arrTime = reverse(arrFreq)
//      for (i <- 0 until noOfRows) matTime(i)(j) = arrTime(i)
//    }
//    for (i <- 0 until noOfRows) {
//      val arrFreq = Array.ofDim[Double](noOfCols)
//      for (j <- 0 until noOfCols) arrFreq(j) = matTime(i)(j)
//      val arrTime = reverse(arrFreq)
//      for (j <- 0 until noOfCols) matTime(i)(j) = arrTime(j)
//    }
//    matTime
//  }
//
//  /**
//   * Performs the 3-D forward transform from time domain to frequency or Hilbert
//   * domain for a given array depending on the used transform algorithm by
//   * inheritance.
//   *
//   * @param spcTime coefficients of 3-D time domain domain
//   * @return coefficients of 3-D frequency or Hilbert domain
//   */
//  def forward(spcTime: Array[Array[Array[Double]]]): Array[Array[Array[Double]]] = {
//    val noOfRows = spcTime.length
//    val noOfCols = spcTime(0).length
//    val noOfHigh = spcTime(0)(0).length
//    val spcHilb = Array.ofDim[Double](noOfRows, noOfCols, noOfHigh)
//    for (i <- 0 until noOfRows) {
//      val matTime = Array.ofDim[Double](noOfCols, noOfHigh)
//      for (j <- 0 until noOfCols; k <- 0 until noOfHigh) {
//        matTime(j)(k) = spcTime(i)(j)(k)
//      }
//      val matHilb = forward(matTime)
//      for (j <- 0 until noOfCols; k <- 0 until noOfHigh) {
//        spcHilb(i)(j)(k) = matHilb(j)(k)
//      }
//    }
//    for (j <- 0 until noOfCols; k <- 0 until noOfHigh) {
//      val arrTime = Array.ofDim[Double](noOfRows)
//      for (i <- 0 until noOfRows) arrTime(i) = spcHilb(i)(j)(k)
//      val arrHilb = forward(arrTime)
//      for (i <- 0 until noOfRows) spcHilb(i)(j)(k) = arrHilb(i)
//    }
//    spcHilb
//  }
//
//  /**
//   * Performs the 3-D reverse transform from frequency or Hilbert domain to time
//   * domain for a given array depending on the used transform algorithm by
//   * inheritance.
//   *
//   * @param spcHilb coefficients of 3-D frequency or Hilbert domain
//   * @return coefficients of 3-D time domain
//   */
//  def reverse(spcHilb: Array[Array[Array[Double]]]): Array[Array[Array[Double]]] = {
//    val noOfRows = spcHilb.length
//    val noOfCols = spcHilb(0).length
//    val noOfHigh = spcHilb(0)(0).length
//    val spcTime = Array.ofDim[Double](noOfRows, noOfCols, noOfHigh)
//    for (i <- 0 until noOfRows) {
//      val matHilb = Array.ofDim[Double](noOfCols, noOfHigh)
//      for (j <- 0 until noOfCols; k <- 0 until noOfHigh) {
//        matHilb(j)(k) = spcHilb(i)(j)(k)
//      }
//      val matTime = reverse(matHilb)
//      for (j <- 0 until noOfCols; k <- 0 until noOfHigh) {
//        spcTime(i)(j)(k) = matTime(j)(k)
//      }
//    }
//    for (j <- 0 until noOfCols; k <- 0 until noOfHigh) {
//      val arrHilb = Array.ofDim[Double](noOfRows)
//      for (i <- 0 until noOfRows) arrHilb(i) = spcTime(i)(j)(k)
//      val arrTime = reverse(arrHilb)
//      for (i <- 0 until noOfRows) spcTime(i)(j)(k) = arrTime(i)
//    }
//    spcTime
//  }
}
