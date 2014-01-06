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
 * This file Haar02Orthogonal.java is part of JWave.
 *
 * @author Christian Scheiblich
 * date 03.06.2010 09:47:24
 * contact graetz@mailfish.de
 */
package math.jwave.transforms.wavelets;

/**
 * Alfred Haar's orthogonal wavelet transform.
 * 
 * @date 03.06.2010 09:47:24
 * @author Christian Scheiblich
 */
class Haar02Orthogonal extends Wavelet {
  
  /**
   * Constructor setting up the orthogonal Haar wavelet coeffs and the scales;
   * 
   * @date 03.06.2010 09:47:24
   * @author Christian Scheiblich
   */
    
    _waveLength = 2;
    
    _coeffs = Array[Double]( // can be done in static way also; faster?
    
    // Orthogonal wavelet coefficients; NOT orthonormal, due to missing sqrt(2.) 
    1.,
    -1.)
    
    _scales = Array[Double]( // can be done in static way also; faster?
    
    // Rule for constructing an orthogonal vector in R^2 -- scales
    -_coeffs(1),
    _coeffs(0))
    //
    // Remark on mathematics (perpendicular, orthogonal, and orthonormal):
    // 
    // "Orthogonal" is used for vectors which are perpendicular but of any length.
    // "Orthonormal" is used for vectors which are perpendicular and of a unit length of one.
    //
    //
    // "Orthogonal" system -- ASCII art does not display the angles in 90 deg (or 45 deg):
    //            
    //    ^ y          
    //    |          
    //  1 +      .  scaling function  
    //    |    /    {1,1}  \
    //    |  /             | length = 1.4142135623730951
    //    |/               /        = sqrt( (1)^2 + (1)^2 )
    //  --o------+-> x
    //  0 |\     1         \
    //    |  \             | length = 1.4142135623730951
    //    |    \           /        = sqrt( (1)^2 + (-1)^2 )
    // -1 +      .  wavelet function     
    //    |         {1,-1}
    //
    // One can see that by each step of the algorithm the input coefficients "energy" 
    // (energy := ||.||_2 euclidean norm) rises, while ever input value is multiplied
    // by 1.414213 (sqrt(2)). However, one has to correct this change of "energy" in
    // the reverse transform by adding the factor 1/2 .
    //
    // (see http://en.wikipedia.org/wiki/Euclidean_norm  for the euclidean norm)
    //
    // The main disadvantage using an "orthogonal" wavelet is that the generated wavelet
    // sub spaces of different size and/or level can not be combined anymore easily, due
    // to their differing "energy" or norm (||.||_2). If an "orthonormal" wavelet is
    // taken, the ||.||_2 norm does not change at any size or any transform level. This
    // allows for combining wavelet sub spaces of different dimension or even level.
    
    // Also possible coefficients -> change forward and reverse functions in common
    // _coeffs[ 0 ] = .5; // w0 
    // _coeffs[ 1 ] = -.5; // w1
    // _scales[ 0 ] = -_coeffs[ 1 ]; // -w1 
    // _scales[ 1 ] = _coeffs[ 0 ]; // w0
    // The ||.||_2 norm will shrink compared to the input signal's norm.
  
  
  /**
   * The forward wavelet transform using the Alfred Haar's wavelet. The arrTime
   * array keeping coefficients of time domain should be of length 2 to the
   * power of p -- length = 2^p where p is a positive integer.
   * 
   * @date 03.06.2010 09:47:24
   * @author Christian Scheiblich
   * @see math.jwave.transforms.wavelets.Wavelet#forward(double[])
   */

  override def forward(arrTime: Array[Double]): Array[Double] = {
    val arrHilb = Array.ofDim[Double](arrTime.length)
    var k = 0
    val h = arrTime.length >> 1
    for (i <- 0 until h; j <- 0 until _waveLength) {
      k = (i << 1) + j
      if (k >= arrTime.length) k -= arrTime.length
 // low pass filter - energy
      arrHilb(i) += arrTime(k) * _scales(j)
 // high pass filter - details
      arrHilb(i + h) += arrTime(k) * _coeffs(j)
        // by each summation, "energy" is added, due to the orthogonal Haar Wavelet.
    }
    arrHilb
  }


  /**
   * The reverse wavelet transform using the Alfred Haar's wavelet. The arrHilb
   * array keeping coefficients of Hilbert domain should be of length 2 to the
   * power of p -- length = 2^p where p is a positive integer. But in case of an
   * only orthogonal Haar wavelet the reverse transform has to have a factor of
   * 0.5 to reduce the up sampled "energy" ion Hilbert space.
   * 
   * @date 03.06.2010 09:47:24
   * @author Christian Scheiblich
   * @see math.jwave.transforms.wavelets.Wavelet#reverse(double[])
   */

  override def reverse(arrHilb: Array[Double]): Array[Double] = {
    val arrTime = Array.ofDim[Double](arrHilb.length)
    var k = 0
    val h = arrHilb.length >> 1
    for (i <- 0 until h; j <- 0 until _waveLength) {
      k = (i << 1) + j
      if (k >= arrHilb.length) k -= arrHilb.length
       // adding up details times energy
      arrTime(k) += (arrHilb(i) * _scales(j) + arrHilb(i + h) * _coeffs(j))
      // The factor .5 gets necessary here to reduce the added "energy" of the forward method
      // correction of the up sampled "energy" -- ||.||_2 euclidean norm
      arrTime(k) *= .5
    }
    arrTime
  }
}

