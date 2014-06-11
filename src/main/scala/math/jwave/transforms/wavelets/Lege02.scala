/**
 * JWave - Java implementation of wavelet transform algorithms
 *
 * Copyright 2010-2012 Christian Scheiblich
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * This file Lege02.java is part of JWave.
 *
 * @author itechsch
 * date 08.06.2010 09:32:08
 * contact graetz@mailfish.de
 */
package math.jwave.transforms.wavelets;

/**
 * Orthonormal Legendre wavelet transform of 2 coefficients based on the
 * Legendre polynomial. But, actually for the smallest Legendre wavelet, the
 * wavelet is the mirrored Haar Wavelet.
 */
object Lege02 extends Wavelet(2, Lege02Constants.coefficients, Lege02Constants.scales)

object Lege02Constants {
  val coefficients = Array[Double](
    -1.0 / 1.4142135623730951,
    1.0 / 1.4142135623730951)

  val scales = Array[Double](
    -coefficients(1),
    coefficients(0))
}
