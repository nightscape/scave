package math.jwave.transforms.wavelets;

/**
 * Alfred Haar's orthonormal wavelet transform.
 *
 * @author Christian Scheiblich
 */
object Haar1 extends Wavelet(2, Haar1Constants.coefficients, Haar1Constants.scales)

object Haar1Constants {

  /**
   * Constructor setting up the orthonormal Haar2 wavelet coeffs and the scales;
   * normed, due to ||*||_2 -- euclidean norm. See the orthogonal version in
   * class Haar02Orthogonal for more details.
   *
   * @date 08.02.2010 12:46:34
   * @author Christian Scheiblich
   */

  val coefficients = Array[Double](

    1.0 / 1.4142135623730951,
    -1.0 / 1.4142135623730951)
  val scales = Array[Double](
    -coefficients(1),
    coefficients(0))

  /**
   * The forward wavelet transform using the Alfred Haar's wavelet.
   *
   * @date 10.02.2010 08:26:06
   * @author Christian Scheiblich
   * @see math.jwave.transforms.wavelets.Wavelet#forward(double[])
   */

  /**
   * The reverse wavelet transform using the Alfred Haar's wavelet. The arrHilb
   * array keeping coefficients of Hilbert domain should be of length 2 to the
   * power of p -- length = 2^p where p is a positive integer.
   *
   * @date 10.02.2010 08:26:06
   * @author Christian Scheiblich
   * @see math.jwave.transforms.wavelets.Wavelet#reverse(double[])
   */

}
