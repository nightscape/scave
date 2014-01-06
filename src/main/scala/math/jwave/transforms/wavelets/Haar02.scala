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
 * This file Haar02.java is part of JWave.
 *
 * @author Christian Scheiblich
 * date 23.02.2010 05:42:23
 * contact graetz@mailfish.de
 */
package math.jwave.transforms.wavelets;

/**
 * Alfred Haar's orthonormal wavelet transform.
 *
 * @date 08.02.2010 12:46:34
 * @author Christian Scheiblich
 */
class Haar02 extends Wavelet {

  /**
   * Constructor setting up the orthonormal Haar2 wavelet coeffs and the scales;
   * normed, due to ||*||_2 -- euclidean norm. See the orthogonal version in
   * class Haar02Orthogonal for more details.
   *
   * @date 08.02.2010 12:46:34
   * @author Christian Scheiblich
   */

  _waveLength = 2;

  _coeffs = Array[Double](

    1. / 1.4142135623730951,
    -1. / 1.4142135623730951)
  _scales = Array[Double](
    -_coeffs(1),
    _coeffs(0))

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
