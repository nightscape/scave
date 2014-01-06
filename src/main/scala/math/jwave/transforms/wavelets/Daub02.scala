
package math.jwave.transforms.wavelets;

/**
 *
 * Ingrid Daubechies' orthonormal wavelet of four coefficients and the scales;
 * normed, due to ||*||2 - euclidean norm.
 * @date 25.03.2010 14:03:20
 * @author Christian Scheiblich
 */
@Deprecated
class Daub02 extends Wavelet {

  _waveLength = 4;
  val sqrt3 = Math.sqrt(3.) // 1.7320508075688772

  _scales = Array[Double]( // can be done in static way also; faster?

    ((1. + sqrt3) / 4.) / 1.4142135623730951,
    ((3. + sqrt3) / 4.) / 1.4142135623730951,
    ((3. - sqrt3) / 4.) / 1.4142135623730951,
    ((1. - sqrt3) / 4.) / 1.4142135623730951)

  _coeffs = Array[Double]( // can be done in static way also; faster?

    _scales(3),
    -_scales(2),
    _scales(1),
    -_scales(0))
}