
package math.jwave.transforms.wavelets;

/**
 *
 * Ingrid Daubechies' orthonormal wavelet of four coefficients and the scales;
 * normed, due to ||*||2 - euclidean norm.
 * @date 25.03.2010 14:03:20
 * @author Christian Scheiblich
 */
import Daub02Constants._
@Deprecated
object Daub02 extends Wavelet(Daub02Constants.scales)

object Daub02Constants {
  val sqrt3 = Math.sqrt(3.) // 1.7320508075688772
  val scales = Array[Double](

    ((1. + sqrt3) / 4.) / 1.4142135623730951,
    ((3. + sqrt3) / 4.) / 1.4142135623730951,
    ((3. - sqrt3) / 4.) / 1.4142135623730951,
    ((1. - sqrt3) / 4.) / 1.4142135623730951)
}