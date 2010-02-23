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
 * This file FastWaveletTransform.java is part of JWave.
 *
 * @author Christian Scheiblich
 * date 23.02.2010 05:42:23
 * contact source@linux23.de
 */
package cs.jwave.handlers;

import cs.jwave.handlers.wavelets.Wavelet;

/**
 * Base class for the forward and reverse Fast Wavelet Transform using a
 * specified Wavelet by inheriting class.
 * 
 * @date 10.02.2010 08:10:42
 * @author Christian Scheiblich
 */
public class FastWaveletTransform extends BasicTransform {

  /**
   * The used wavelet for the specified transform algorithm.
   */
  Wavelet _wavelet;

  /**
   * Constructor receiving a Wavelet object.
   * 
   * @date 10.02.2010 08:10:42
   * @author Christian Scheiblich
   * @param wavelet
   *          object of type Wavelet; Haar02, Daub04, Coif06, ...
   */
  public FastWaveletTransform( Wavelet wavelet ) {
    _wavelet = wavelet;
  } // FastWaveletTransform

  /**
   * Performs the 1-D forward transform from time domain to Hilbert domain for
   * the given array using the Fast FastWaveletTransform Transform (FWT)
   * algorithm.
   * 
   * @date 10.02.2010 08:23:24
   * @author Christian Scheiblich
   * @see cs.jwave.handlers.BasicTransform#forward(double[])
   */
  @Override
  public double[ ] forward( double[ ] arrTime ) {

    // TODO think about not to allocating new MEM; return arrTime as arrHilb
    double[ ] arrHilb = new double[ arrTime.length ];
    for( int i = 0; i < arrTime.length; i++ )
      arrHilb[ i ] = arrTime[ i ];

    int level = 0;
    int h = arrTime.length;
    int minWaveLength = _wavelet.getWaveLength( );
    if( h >= minWaveLength ) {

      while( h >= minWaveLength ) {

        double[ ] iBuf = new double[ h ];
        for( int i = 0; i < h; i++ )
          iBuf[ i ] = arrHilb[ i ];

        double[ ] oBuf = _wavelet.forward( iBuf );

        for( int i = 0; i < h; i++ )
          arrHilb[ i ] = oBuf[ i ];

        h = h >> 1;
        level++;
      } // levels

    } // if

    return arrHilb;
  } // forward

  /**
   * Performs the 1-D reverse transform from Hilbert domain to time domain for
   * the given array using the Fast FastWaveletTransform Transform (FWT)
   * algorithm and the selected wavelet.
   * 
   * @date 10.02.2010 08:23:24
   * @author Christian Scheiblich
   * @see cs.jwave.handlers.BasicTransform#reverse(double[])
   */
  @Override
  public double[ ] reverse( double[ ] arrHilb ) {

    // TODO think about not to allocating new MEM; return arrHilb as arrTime
    double[ ] arrTime = new double[ arrHilb.length ];

    for( int i = 0; i < arrHilb.length; i++ )
      arrTime[ i ] = arrHilb[ i ];

    int level = 0;
    int minWaveLength = _wavelet.getWaveLength( );
    int h = minWaveLength;
    if( arrHilb.length >= minWaveLength ) {

      while( h <= arrTime.length && h >= minWaveLength ) {

        double[ ] iBuf = new double[ h ];
        for( int i = 0; i < h; i++ )
          iBuf[ i ] = arrTime[ i ];

        double[ ] oBuf = _wavelet.reverse( iBuf );

        for( int i = 0; i < h; i++ )
          arrTime[ i ] = oBuf[ i ];

        h = h << 1;
        level++;
      } // levels

    } // if

    return arrTime;
  } // reverse

  /**
   * Performs the 2-D forward transform from Hilbert domain to time domain for
   * the given array using the Fast FastWaveletTransform Transform (FWT)
   * algorithm and the selected wavelet.
   * 
   * @date 10.02.2010 11:03:17
   * @author Christian Scheiblich
   * @see cs.jwave.handlers.BasicTransform#forward(double[][])
   */
  @Override
  public double[ ][ ] forward( double[ ][ ] matrixTime ) {

    int noOfRows = matrixTime.length;
    int noOfCols = matrixTime[ 0 ].length;

    double[ ][ ] matrixHilb = new double[ noOfRows ][ noOfCols ];

    for( int i = 0; i < noOfRows; i++ ) {
      double[ ] row = new double[ noOfCols ];
      for( int j = 0; j < noOfCols; j++ )
        row[ j ] = matrixTime[ i ][ j ];
      row = forward( row );
      for( int j = 0; j < noOfCols; j++ )
        matrixHilb[ i ][ j ] = row[ j ];
    } // rows

    for( int j = 0; j < noOfCols; j++ ) {
      double[ ] col = new double[ noOfRows ];
      for( int i = 0; i < noOfRows; i++ )
        col[ i ] = matrixHilb[ i ][ j ];
      col = forward( col );
      for( int i = 0; i < noOfCols; i++ )
        matrixHilb[ i ][ j ] = col[ i ];
    } // cols

    return matrixHilb;
  } // forward

  /**
   * Performs the 2-D reverse transform from Hilbert domain to time domain for
   * the given array using the Fast FastWaveletTransform Transform (FWT)
   * algorithm.
   * 
   * @date 10.02.2010 11:03:17
   * @author Christian Scheiblich
   * @see cs.jwave.handlers.BasicTransform#reverse(double[][])
   */
  @Override
  public double[ ][ ] reverse( double[ ][ ] matrixHilb ) {

    int noOfRows = matrixHilb.length;
    int noOfCols = matrixHilb[ 0 ].length;

    double[ ][ ] matrixTime = new double[ noOfRows ][ noOfCols ];

    for( int j = 0; j < noOfCols; j++ ) {
      double[ ] col = new double[ noOfRows ];
      for( int i = 0; i < noOfRows; i++ )
        col[ i ] = matrixHilb[ i ][ j ];
      col = reverse( col );
      for( int i = 0; i < noOfCols; i++ )
        matrixTime[ i ][ j ] = col[ i ];
    } // cols

    for( int i = 0; i < noOfRows; i++ ) {
      double[ ] row = new double[ noOfCols ];
      for( int j = 0; j < noOfCols; j++ )
        row[ j ] = matrixTime[ i ][ j ];
      row = reverse( row );
      for( int j = 0; j < noOfCols; j++ )
        matrixTime[ i ][ j ] = row[ j ];
    } // rows

    return matrixTime;
  } // reverse

} // class
