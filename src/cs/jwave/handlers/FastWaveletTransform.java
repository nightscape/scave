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
 * Base class for the forward and reverse Fast Wavelet Transform in 1-D, 2-D,
 * and 3-D using a specified Wavelet by inheriting class.
 * 
 * @date 10.02.2010 08:10:42
 * @author Christian Scheiblich
 */
public class FastWaveletTransform extends BasicTransform {

  /**
   * The selected wavelet for the specified transform algorithm.
   */
  protected Wavelet _wavelet;

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
   * Performs the 1-D forward transform for arrays of dim N from time domain to
   * Hilbert domain for the given array using the Fast Wavelet Transform (FWT)
   * algorithm.
   * 
   * @date 10.02.2010 08:23:24
   * @author Christian Scheiblich
   * @see cs.jwave.handlers.BasicTransform#forward(double[])
   */
  @Override
  public double[ ] forward( double[ ] arrTime ) {

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
   * Performs the 1-D reverse transform for arrays of dim N from Hilbert domain
   * to time domain for the given array using the Fast Wavelet Transform (FWT)
   * algorithm and the selected wavelet.
   * 
   * @date 10.02.2010 08:23:24
   * @author Christian Scheiblich
   * @see cs.jwave.handlers.BasicTransform#reverse(double[])
   */
  @Override
  public double[ ] reverse( double[ ] arrHilb ) {

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
   * Performs the 2-D forward transform for N^2 matrices from time domain to
   * Hilbert domain for the given array using the Fast Wavelet Transform (FWT)
   * algorithm and the selected wavelet.
   * 
   * @date 10.02.2010 11:03:17
   * @author Christian Scheiblich
   * @see cs.jwave.handlers.BasicTransform#forward(double[][])
   */
  @Override
  public double[ ][ ] forward( double[ ][ ] matTime ) {

    int noOfRows = matTime.length;
    int noOfCols = matTime[ 0 ].length;

    double[ ][ ] matHilb = new double[ noOfRows ][ noOfCols ];

    for( int i = 0; i < noOfRows; i++ ) {

      double[ ] arrTime = new double[ noOfCols ];

      for( int j = 0; j < noOfCols; j++ )
        arrTime[ j ] = matTime[ i ][ j ];

      double[ ] arrHilb = forward( arrTime );

      for( int j = 0; j < noOfCols; j++ )
        matHilb[ i ][ j ] = arrHilb[ j ];

    } // rows

    for( int j = 0; j < noOfCols; j++ ) {

      double[ ] arrTime = new double[ noOfRows ];

      for( int i = 0; i < noOfRows; i++ )
        arrTime[ i ] = matHilb[ i ][ j ];

      double[ ] arrHilb = forward( arrTime );

      for( int i = 0; i < noOfRows; i++ )
        matHilb[ i ][ j ] = arrHilb[ i ];

    } // cols

    return matHilb;
  } // forward

  /**
   * Performs the 2-D reverse transform for N^2 matrices from Hilbert domain to
   * time domain for the given array using the Fast Wavelet Transform (FWT)
   * algorithm.
   * 
   * @date 10.02.2010 11:03:17
   * @author Christian Scheiblich
   * @see cs.jwave.handlers.BasicTransform#reverse(double[][])
   */
  @Override
  public double[ ][ ] reverse( double[ ][ ] matHilb ) {

    int noOfRows = matHilb.length;
    int noOfCols = matHilb[ 0 ].length;

    double[ ][ ] matTime = new double[ noOfRows ][ noOfCols ];

    for( int j = 0; j < noOfCols; j++ ) {

      double[ ] arrHilb = new double[ noOfRows ];

      for( int i = 0; i < noOfRows; i++ )
        arrHilb[ i ] = matHilb[ i ][ j ];

      double[ ] arrTime = reverse( arrHilb );

      for( int i = 0; i < noOfRows; i++ )
        matTime[ i ][ j ] = arrTime[ i ];

    } // cols

    for( int i = 0; i < noOfRows; i++ ) {

      double[ ] arrHilb = new double[ noOfCols ];

      for( int j = 0; j < noOfCols; j++ )
        arrHilb[ j ] = matTime[ i ][ j ];

      double[ ] arrTime = reverse( arrHilb );

      for( int j = 0; j < noOfCols; j++ )
        matTime[ i ][ j ] = arrTime[ j ];

    } // rows

    return matTime;
  } // reverse

  /**
   * Performs the 3-D forward transform for N^3 spaces from time domain to
   * Hilbert domain for the given array using the Fast Wavelet Transform (FWT)
   * algorithm and the selected wavelet.
   * 
   * @date 10.07.2010 20:25:19
   * @author Christian Scheiblich
   * @see cs.jwave.handlers.BasicTransform#forward(double[][][])
   */
  @Override
  public double[ ][ ][ ] forward( double[ ][ ][ ] spcTime ) {

    int noOfRows = spcTime.length; // first dimension
    int noOfCols = spcTime[ 0 ].length; // second dimension
    int noOfHigh = spcTime[ 0 ][ 0 ].length; // third dimension

    double[ ][ ][ ] spcHilb = new double[ noOfRows ][ noOfCols ][ noOfHigh ];

    for( int i = 0; i < noOfRows; i++ ) {

      double[ ][ ] matTime = new double[ noOfCols ][ noOfHigh ];

      for( int j = 0; j < noOfCols; j++ ) {

        for( int k = 0; k < noOfHigh; k++ ) {

          matTime[ j ][ k ] = spcTime[ i ][ j ][ k ];

        } // high

      } // cols      

      double[ ][ ] matHilb = forward( matTime ); // 2-D forward

      for( int j = 0; j < noOfCols; j++ ) {

        for( int k = 0; k < noOfHigh; k++ ) {

          spcHilb[ i ][ j ][ k ] = matHilb[ j ][ k ];

        } // high

      } // cols

    } // rows  

    for( int j = 0; j < noOfCols; j++ ) {

      for( int k = 0; k < noOfHigh; k++ ) {

        double[ ] arrTime = new double[ noOfRows ];

        for( int i = 0; i < noOfRows; i++ )
          arrTime[ i ] = spcHilb[ i ][ j ][ k ];

        double[ ] arrHilb = forward( arrTime ); // 1-D forward

        for( int i = 0; i < noOfRows; i++ )
          spcHilb[ i ][ j ][ k ] = arrHilb[ i ];

      } // high

    } // cols

    return spcHilb;

  } // forward

  /**
   * Performs the 3-D forward transform for N^3 spaces from time domain to
   * Hilbert domain for the given array using the Fast Wavelet Transform (FWT)
   * algorithm and the selected wavelet.
   * 
   * @date 10.07.2010 20:25:32
   * @author Christian Scheiblich
   * @see cs.jwave.handlers.BasicTransform#forward(double[][][])
   */
  @Override
  public double[ ][ ][ ] reverse( double[ ][ ][ ] spcHilb ) {

    int noOfRows = spcHilb.length; // first dimension
    int noOfCols = spcHilb[ 0 ].length; // second dimension
    int noOfHigh = spcHilb[ 0 ][ 0 ].length; // third dimension

    double[ ][ ][ ] spcTime = new double[ noOfRows ][ noOfCols ][ noOfHigh ];

    for( int i = 0; i < noOfRows; i++ ) {

      double[ ][ ] matHilb = new double[ noOfCols ][ noOfHigh ];

      for( int j = 0; j < noOfCols; j++ ) {

        for( int k = 0; k < noOfHigh; k++ ) {

          matHilb[ j ][ k ] = spcHilb[ i ][ j ][ k ];

        } // high

      } // cols      

      double[ ][ ] matTime = reverse( matHilb ); // 2-D reverse

      for( int j = 0; j < noOfCols; j++ ) {

        for( int k = 0; k < noOfHigh; k++ ) {

          spcTime[ i ][ j ][ k ] = matTime[ j ][ k ];

        } // high

      } // cols

    } // rows  

    for( int j = 0; j < noOfCols; j++ ) {

      for( int k = 0; k < noOfHigh; k++ ) {

        double[ ] arrHilb = new double[ noOfRows ];

        for( int i = 0; i < noOfRows; i++ )
          arrHilb[ i ] = spcTime[ i ][ j ][ k ];

        double[ ] arrTime = reverse( arrHilb ); // 1-D reverse

        for( int i = 0; i < noOfRows; i++ )
          spcTime[ i ][ j ][ k ] = arrTime[ i ];

      } // high

    } // cols

    return spcTime;

  } // reverse

  /**
   * Performs the 1-D forward transform for arrays of dim N from time domain to
   * Hilbert domain for the given array using the Fast Wavelet Transform (FWT)
   * algorithm. The number of transformation levels applied is limited by
   * threshold.
   * 
   * @date 15.07.2010 13:26:26
   * @author Thomas Haider
   * @see cs.jwave.handlers.BasicTransform#forward(double[], int)
   */
  @Override
  public double[ ] forward( double[ ] arrTime, int toLevel ) {

    double[ ] arrHilb = new double[ arrTime.length ];
    for( int i = 0; i < arrTime.length; i++ )
      arrHilb[ i ] = arrTime[ i ];

    int level = 0;
    int h = arrTime.length;
    int minWaveLength = _wavelet.getWaveLength( );
    if( h >= minWaveLength ) {

      while( h >= minWaveLength && ( toLevel < 0 || level < toLevel ) ) {

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
   * Performs the 1-D reverse transform for arrays of dim N from Hilbert domain
   * to time domain for the given array using the Fast Wavelet Transform (FWT)
   * algorithm and the selected wavelet. The number of transformation levels
   * applied is limited by threshold.
   * 
   * @date 15.07.2010 13:28:06
   * @author Thomas Haider
   * @see cs.jwave.handlers.BasicTransform#reverse(double[], int)
   */
  @Override
  public double[ ] reverse( double[ ] arrHilb, int fromLevel ) {

    double[ ] arrTime = new double[ arrHilb.length ];

    for( int i = 0; i < arrHilb.length; i++ )
      arrTime[ i ] = arrHilb[ i ];

    int level = 0;
    int minWaveLength = _wavelet.getWaveLength( );
    int h = minWaveLength;
    if( arrHilb.length >= minWaveLength ) {

      while( h <= arrTime.length && h >= minWaveLength
          && ( fromLevel < 0 || level < fromLevel ) ) {

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
   * Performs the 2-D forward transform for N^2 matrices from time domain to
   * Hilbert domain for the given array using the Fast Wavelet Transform (FWT)
   * algorithm and the selected wavelet. The number of transformation levels
   * applied is limited by threshold.
   * 
   * @date 15.07.2010 13:31:03
   * @author Thomas Haider
   * @see cs.jwave.handlers.BasicTransform#forward(double[][], int)
   */
  @Override
  public double[ ][ ] forward( double[ ][ ] matTime, int toLevel ) {

    int noOfRows = matTime.length;
    int noOfCols = matTime[ 0 ].length;

    double[ ][ ] matHilb = new double[ noOfRows ][ noOfCols ];

    for( int i = 0; i < noOfRows; i++ ) {

      double[ ] arrTime = new double[ noOfCols ];

      for( int j = 0; j < noOfCols; j++ )
        arrTime[ j ] = matTime[ i ][ j ];

      double[ ] arrHilb = forward( arrTime, toLevel );

      for( int j = 0; j < noOfCols; j++ )
        matHilb[ i ][ j ] = arrHilb[ j ];

    } // rows

    for( int j = 0; j < noOfCols; j++ ) {

      double[ ] arrTime = new double[ noOfRows ];

      for( int i = 0; i < noOfRows; i++ )
        arrTime[ i ] = matHilb[ i ][ j ];

      double[ ] arrHilb = forward( arrTime, toLevel );

      for( int i = 0; i < noOfRows; i++ )
        matHilb[ i ][ j ] = arrHilb[ i ];

    } // cols

    return matHilb;
  } // forward

  /**
   * Performs the 2-D reverse transform for N^2 matrices from Hilbert domain to
   * time domain for the given array using the Fast Wavelet Transform (FWT)
   * algorithm. The number of transformation levels applied is limited by
   * threshold.
   * 
   * @date 15.07.2010 13:32:50
   * @author Thomas Haider
   * @see cs.jwave.handlers.BasicTransform#reverse(double[][], int)
   */
  @Override
  public double[ ][ ] reverse( double[ ][ ] matHilb, int fromLevel ) {

    int noOfRows = matHilb.length;
    int noOfCols = matHilb[ 0 ].length;

    double[ ][ ] matTime = new double[ noOfRows ][ noOfCols ];

    for( int j = 0; j < noOfCols; j++ ) {

      double[ ] arrHilb = new double[ noOfRows ];

      for( int i = 0; i < noOfRows; i++ )
        arrHilb[ i ] = matHilb[ i ][ j ];

      double[ ] arrTime = reverse( arrHilb, fromLevel );

      for( int i = 0; i < noOfRows; i++ )
        matTime[ i ][ j ] = arrTime[ i ];

    } // cols

    for( int i = 0; i < noOfRows; i++ ) {

      double[ ] arrHilb = new double[ noOfCols ];

      for( int j = 0; j < noOfCols; j++ )
        arrHilb[ j ] = matTime[ i ][ j ];

      double[ ] arrTime = reverse( arrHilb, fromLevel );

      for( int j = 0; j < noOfCols; j++ )
        matTime[ i ][ j ] = arrTime[ j ];

    } // rows

    return matTime;
  } // reverse

  /**
   * Performs the 3-D forward transform for N^3 spaces from time domain to
   * Hilbert domain for the given array using the Fast Wavelet Transform (FWT)
   * algorithm and the selected wavelet. The number of transformation levels
   * applied is limited by threshold.
   * 
   * @date 15.07.2010 13:34:49
   * @author Thomas Haider
   * @see cs.jwave.handlers.BasicTransform#forward(double[][][], int)
   */
  @Override
  public double[ ][ ][ ] forward( double[ ][ ][ ] spcTime, int toLevel ) {

    int noOfRows = spcTime.length; // first dimension
    int noOfCols = spcTime[ 0 ].length; // second dimension
    int noOfHigh = spcTime[ 0 ][ 0 ].length; // third dimension

    double[ ][ ][ ] spcHilb = new double[ noOfRows ][ noOfCols ][ noOfHigh ];

    for( int i = 0; i < noOfRows; i++ ) {

      double[ ][ ] matTime = new double[ noOfCols ][ noOfHigh ];

      for( int j = 0; j < noOfCols; j++ ) {

        for( int k = 0; k < noOfHigh; k++ ) {

          matTime[ j ][ k ] = spcTime[ i ][ j ][ k ];

        } // high

      } // cols      

      double[ ][ ] matHilb = forward( matTime, toLevel ); // 2-D forward

      for( int j = 0; j < noOfCols; j++ ) {

        for( int k = 0; k < noOfHigh; k++ ) {

          spcHilb[ i ][ j ][ k ] = matHilb[ j ][ k ];

        } // high

      } // cols

    } // rows  

    for( int j = 0; j < noOfCols; j++ ) {

      for( int k = 0; k < noOfHigh; k++ ) {

        double[ ] arrTime = new double[ noOfRows ];

        for( int i = 0; i < noOfRows; i++ )
          arrTime[ i ] = spcHilb[ i ][ j ][ k ];

        double[ ] arrHilb = forward( arrTime, toLevel ); // 1-D forward

        for( int i = 0; i < noOfRows; i++ )
          spcHilb[ i ][ j ][ k ] = arrHilb[ i ];

      } // high

    } // cols

    return spcHilb;
  } // forward

  /**
   * Performs the 3-D reverse transform for N^3 spaces from Hilbert domain to
   * time domain for the given array using the Fast Wavelet Transform (FWT)
   * algorithm and the selected wavelet. The number of transformation levels
   * applied is limited by threshold.
   * 
   * @date 15.07.2010 13:35:37
   * @author Thomas Haider
   * @see cs.jwave.handlers.BasicTransform#forward(double[][][], int)
   */
  @Override
  public double[ ][ ][ ] reverse( double[ ][ ][ ] spcHilb, int fromLevel ) {

    int noOfRows = spcHilb.length; // first dimension
    int noOfCols = spcHilb[ 0 ].length; // second dimension
    int noOfHigh = spcHilb[ 0 ][ 0 ].length; // third dimension

    double[ ][ ][ ] spcTime = new double[ noOfRows ][ noOfCols ][ noOfHigh ];

    for( int i = 0; i < noOfRows; i++ ) {

      double[ ][ ] matHilb = new double[ noOfCols ][ noOfHigh ];

      for( int j = 0; j < noOfCols; j++ ) {

        for( int k = 0; k < noOfHigh; k++ ) {

          matHilb[ j ][ k ] = spcHilb[ i ][ j ][ k ];

        } // high

      } // cols      

      double[ ][ ] matTime = reverse( matHilb, fromLevel ); // 2-D reverse

      for( int j = 0; j < noOfCols; j++ ) {

        for( int k = 0; k < noOfHigh; k++ ) {

          spcTime[ i ][ j ][ k ] = matTime[ j ][ k ];

        } // high

      } // cols

    } // rows  

    for( int j = 0; j < noOfCols; j++ ) {

      for( int k = 0; k < noOfHigh; k++ ) {

        double[ ] arrHilb = new double[ noOfRows ];

        for( int i = 0; i < noOfRows; i++ )
          arrHilb[ i ] = spcTime[ i ][ j ][ k ];

        double[ ] arrTime = reverse( arrHilb, fromLevel ); // 1-D reverse

        for( int i = 0; i < noOfRows; i++ )
          spcTime[ i ][ j ][ k ] = arrTime[ i ];

      } // high

    } // cols

    return spcTime;
  } // reverse

} // class
