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
 * This file Lege06.java is part of JWave.
 *
 * @author Christian Scheiblich
 * date 03.06.2010 22:04:35
 * contact graetz@mailfish.de
 */
package math.jwave.transforms.wavelets;

/**
 * Legendre's orthonormal wavelet of six coefficients and the scales; normed,
 * due to ||*||2 - euclidean norm.
 */
@Deprecated
object Lege06 extends Wavelet(Array[Double](
    -63. / 128. / 1.4142135623730951,
    -35. / 128. / 1.4142135623730951,
    -30. / 128. / 1.4142135623730951,
    -30. / 128. / 1.4142135623730951,
    -35. / 128. / 1.4142135623730951,
    -63. / 128. / 1.4142135623730951)
)
