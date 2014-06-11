/**
 * ouble
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
 * This file Coif06.java is part of JWave.
 *
 * @author Christian Scheiblich
 * date 23.02.2010 05:42:23
 * contact graetz@mailfish.de
 */
package math.jwave.transforms.wavelets

import Wavelet._

/**
 * Ingrid Daubechies' orthonormal Coiflet wavelet of six coefficients and the
 * scales; normed, due to ||*||2 - euclidean norm.
 *
 * @date 10.02.2010 16:32:38
 * @author Christian Scheiblich
 */
@Deprecated
object Coif06 extends Wavelet(Coif06Constants.scales)

object Coif06Constants {

  val sqrt15 = Math.sqrt(15.0);

  val scales = Array[Double](
    1.4142135623730951 * (sqrt15 - 3.0) / 32.0,
    1.4142135623730951 * (1.0 - sqrt15) / 32.0,
    1.4142135623730951 * (6.0 - 2 * sqrt15) / 32.0,
    1.4142135623730951 * (2.0 * sqrt15 + 6.0) / 32.0,
    1.4142135623730951 * (sqrt15 + 13.0) / 32.0,
    1.4142135623730951 * (9.0 - sqrt15) / 32.0)
}
