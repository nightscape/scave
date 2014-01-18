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
 * This file Daub04.java is part of JWave.
 *
 * @author Christian Scheiblich
 * date 26.03.2010 07:35:31
 * contact graetz@mailfish.de
 */
package math.jwave.transforms.wavelets;

/**
 * Ingrid Daubechies' orthonormal wavelet of eight coefficients and the scales;
 * normed, due to ||*||2 - euclidean norm.
 */
object Daub04 extends Wavelet(Daub04Constants.scales)

object Daub04Constants {

  // TODO Get analytical formulation, due to its precision; this is around 1.e-3 only
  // values are from: http://de.wikipedia.org/wiki/Daubechies-Wavelets
  val sqrt02 = 1.4142135623730951

  val scales = Array[Double](
    0.32580343,
    1.01094572,
    0.8922014,
    -0.03967503,
    -0.26450717,
    0.0436163,
    0.0465036,
    -0.01498699
    // divide to square root of 2 for being an orthonormal wavelet (instead of orthogonal) 
    ).map(_ / sqrt02)
}
