/**
 * JWave - Java implementation of wavelet transform algorithms
 *
 * Copyright 2010 Christian Scheiblich
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
 * contact source@linux23.de
 */
package cs.jwave.handlers.wavelets;

/**
 * Alfred Haar's orthogonal Wavelet Transform.
 * 
 * @date 03.06.2010 09:47:24
 * @author Christian Scheiblich
 */
public class Haar02Orthogonal extends Wavelet {

  /**
   * Constructor setting up the orthogonal Haar wavelet coeffs and the scales;
   * NOT normed, due to ||*||_2 -- euclidean norm.
   * 
   * @date 03.06.2010 09:47:24
   * @author Christian Scheiblich
   */
  public Haar02Orthogonal( ) {

    _waveLength = 2;

    _coeffs = new double[ _waveLength ]; // can be done in static way also; faster?
    _scales = new double[ _waveLength ]; // can be done in static way also; faster?

    // Orthogonal wavelet coefficients; NOT orthonormal, due to missing sqrt(2.) 
    _coeffs[ 0 ] = 1.; // w0 
    _coeffs[ 1 ] = -1.; //  w1
    // rule for constructing an orthogonal vector in R^2 -- scales
    _scales[ 0 ] = -_coeffs[ 1 ]; // -w1 
    _scales[ 1 ] = _coeffs[ 0 ]; // w0
    //
    // Orthogonal system -- ASCII art does not display the angles in 90° (or 45°):
    //         ^
    // wavelet | scales
    //     . 1.+   .
    //      \  |  /    \
    //       \ | /     | length: sqrt( 1.^2 + 1^2. ) = 1.4142135623730951
    //        \|/      /
    //    -+---O---+-> x    
    //    -1.      1.
    //
    // Therefore, one can see that, by each step of the algorithm, the input coefficients
    // "energy" (||.||_2 euclidean norm) change and, so, one has to correct this change in
    // the reverse transform by factor 0.5.
    //
    // (see http://en.wikipedia.org/wiki/Euclidean_norm  for the euclidean norm)
    //
    // Main disadvantage here is, that wavelet sub spaces of different dimension or level
    // can not be combined anymore, while there are of different ||.||_2 norm. If the
    // orthonormal Haar wavelet is taken, the ||.||_2 norm does not change and allows for
    // combining wavelet sub space of different dimension or even level. E. g. using wavelets
    // for data  compression like JPEG2000 but with adaptable set block size -- not always
    // 8 x 8 pixel.

    // Also possible coefficients -> change forward and reverse functions in common
    // _coeffs[ 0 ] = .5; // w0 
    // _coeffs[ 1 ] = -.5; // w1
    // _scales[ 0 ] = -_coeffs[ 1 ]; // -w1 
    // _scales[ 1 ] = _coeffs[ 0 ]; // w0
    // The ||.||_2 norm will shrink compared to the input signal's norm.

  } // Haar02

  /**
   * The forward Fast Wavelet Transform using the Alfred Haar02's wavelet. The
   * arrTime array keeping coefficients of time domain should be of length 2 to
   * the power of p -- length = 2^p where p is a positive integer.
   * 
   * @date 03.06.2010 09:47:24
   * @author Christian Scheiblich
   * @see cs.jwave.handlers.wavelets.Wavelet#forward(double[])
   */
  @Override
  public double[ ] forward( double[ ] arrTime ) {

    double[ ] arrHilb = new double[ arrTime.length ];

    int k = 0;
    int h = arrTime.length >> 1;

    for( int i = 0; i < h; i++ ) {

      for( int j = 0; j < _waveLength; j++ ) {

        k = ( i << 1 ) + j;
        if( k >= arrTime.length )
          k -= arrTime.length;

        arrHilb[ i ] += arrTime[ k ] * _scales[ j ]; // low pass filter - energy
        arrHilb[ i + h ] += arrTime[ k ] * _coeffs[ j ]; // high pass filter - details

        // by each summation, "energy" is added, due to the orthogonal Haar Wavelet.

      } // wavelet

    } // h

    return arrHilb;
  } // forward

  /**
   * The reverse Fast Wavelet Transform using the Alfred Haar02's wavelet. The
   * arrHilb array keeping coefficients of Hilbert domain should be of length 2
   * to the power of p -- length = 2^p where p is a positive integer. But in
   * case of an only orthogonal Haar wavelet the reverse transform has to have a
   * factor of 0.5 to reduce the up sampled "energy" ion hilbert space.
   * 
   * @date 03.06.2010 09:47:24
   * @author Christian Scheiblich
   * @see cs.jwave.handlers.wavelets.Wavelet#reverse(double[])
   */
  @Override
  public double[ ] reverse( double[ ] arrHilb ) {

    double[ ] arrTime = new double[ arrHilb.length ];

    int k = 0;
    int h = arrHilb.length >> 1;
    for( int i = 0; i < h; i++ ) {

      for( int j = 0; j < _waveLength; j++ ) {

        k = ( i << 1 ) + j;
        if( k >= arrHilb.length )
          k -= arrHilb.length;

        arrTime[ k ] += ( arrHilb[ i ] * _scales[ j ] + arrHilb[ i + h ]
            * _coeffs[ j ] ); // adding up details times energy

        // The factor .5 gets necessary here, due reduce the added "energy" of the forward method
        arrTime[ k ] *= .5; // correction of the up sampled "energy" -- ||.||_2 euclidean norm

      } // wavelet

    } //  h

    return arrTime;
  }
} // class
