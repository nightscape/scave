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
 * This file Wavelet.java is part of JWave.
 *
 * @author Christian Scheiblich
 * date 23.02.2010 05:42:23
 * contact graetz@mailfish.de
 */
package math.jwave.transforms.wavelets

import scala.annotation.meta.field
import scala.annotation.meta.beanSetter

/**
 * Basic class for one wavelet keeping coefficients of the wavelet function, the
 * scaling function, the base wavelength, the forward transform method, and the
 * reverse transform method.
 *
 * @param wavelength minimal wavelength of the used wavelet and scaling coefficients
 * @param coefficients coefficients of the wavelet; wavelet function
 * @param scales coefficients of the scales; scaling function
 */

class Wavelet(val wavelength: Int, val coefficients: Array[Double], val scales: Array[Double]) extends WaveletInterface {

  /**
   * Performs the forward transform for the given array from time domain to
   * Hilbert domain and returns a new array of the same size keeping
   * coefficients of Hilbert domain and should be of length 2 to the power of p
   * -- length = 2^p where p is a positive integer.
   *
   * @param arrTime
   *          array keeping time domain coefficients
   * @return coefficients represented by frequency domain
   */
  def forward(arrTime: Array[Double]): Array[Double] = {

    val arrHilb = new Array[Double](arrTime.length);


    val halfArrayLength = arrTime.length / 2;
    val arrView = arrTime.view ++ arrTime
    for (i <- 0 until halfArrayLength) {
      val arrTimeWindowed = arrView.slice(i * 2, i * 2 + wavelength)
      arrHilb(i) = dot(scales, arrTimeWindowed) // low pass filter - energy (approximation)
      arrHilb(i + halfArrayLength) = dot(coefficients, arrTimeWindowed) // high pass filter - details
    }
    arrHilb
  }

  final def dot(a: Seq[Double], b: Seq[Double]) =
    (0 until a.size).foldLeft(0.0) { case (sum, i) => sum + a(i) * b(i) }
  /**
   * Performs the reverse transform for the given array from Hilbert domain to
   * time domain and returns a new array of the same size keeping coefficients
   * of time domain and should be of length 2 to the power of p -- length = 2^p
   * where p is a positive integer.
   *
   * @param arrHilb
   *          array keeping frequency domain coefficients
   * @return coefficients represented by time domain
   */
  def reverse(arrHilb: Array[Double]): Array[Double] = {

    val arrTime = new Array[Double](arrHilb.length)

    val halfArrayLength = arrHilb.length / 2;


    for (i <- 0 until halfArrayLength) {
      for (j <- 0 until wavelength) {
        val k = (i * 2 + j) % arrHilb.length
        arrTime(k) += (arrHilb(i) * scales(j) + arrHilb(i + halfArrayLength) * coefficients(j)) // adding up details times energy (approximation)
      }
    }
    arrTime
  }

  /**
   * Returns the number of coeffs (and scales).
   *
   * @return integer representing the number of coeffs.
   */
  def getLength(): Int = coefficients.length;
}

object Wavelet {
  def coefficientsFromScales(coefficients: Array[Double], negate: Boolean = false): Array[Double] = {
    val rev = coefficients.reverse.zipWithIndex.map { case (e, i) => if(i % 2 == 0) e else -e }
    rev
  }
}

