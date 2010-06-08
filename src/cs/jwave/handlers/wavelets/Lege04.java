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
 * This file Legendre04.java is part of JWave.
 *
 * @author tucker
 * date 03.06.2010 21:19:04
 * contact source@linux23.de
 */
package cs.jwave.handlers.wavelets;

/**
 * Legendre's orthonormal wavelet of four coefficients and the scales; normed,
 * due to ||*||2 - euclidean norm.
 * 
 * @date 03.06.2010 21:19:04
 * @author Christian Scheiblich
 */
public class Lege04 extends Wavelet {

  /**
   * Constructor setting up the orthonormal Legendre4 wavelet coeffs and the
   * scales; normed, due to ||*||2 - euclidean norm.
   * 
   * @date 03.06.2010 21:19:04
   * @author Christian Scheiblich
   */
  public Lege04( ) {

    _waveLength = 4;

    _scales = new double[ _waveLength ]; // can be done in static way also; faster?

    _scales[ 0 ] = ( -5. / 8. ) / 1.4142135623730951;
    _scales[ 1 ] = ( -3. / 8. ) / 1.4142135623730951;
    _scales[ 2 ] = ( -3. / 8. ) / 1.4142135623730951;
    _scales[ 3 ] = ( -5. / 8. ) / 1.4142135623730951;

    _coeffs = new double[ _waveLength ]; // can be done in static way also; faster?

    _coeffs[ 0 ] = _scales[ 3 ]; //    h3
    _coeffs[ 1 ] = -_scales[ 2 ]; //  -h2
    _coeffs[ 2 ] = _scales[ 1 ]; //    h1
    _coeffs[ 3 ] = -_scales[ 0 ]; //  -h0

  } // Legendre04

  /**
   * The forward wavelet transform using the Legendre's wavelet of four
   * coefficients. The arrHilb array keeping coefficients of Hilbert domain
   * should be of length 2 to the power of p -- length = 2^p where p is a
   * positive integer.
   * 
   * @date 03.06.2010 21:19:04
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

      } // wavelet

    } // h

    return arrHilb;
  } // forward

  /**
   * The reverse wavelet transform using the Legendre's wavelet of four
   * coefficients. The arrHilb array keeping coefficients of Hilbert domain
   * should be of length 2 to the power of p -- length = 2^p where p is a
   * positive integer.
   * 
   * @date 03.06.2010 21:19:04
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

      } // wavelet

    } //  h

    return arrTime;
  } // reverse

} // class
