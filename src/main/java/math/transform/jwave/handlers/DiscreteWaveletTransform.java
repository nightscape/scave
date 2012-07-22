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
 * This file FastWaveletTransform.java is part of JWave.
 *
 * @author Christian Scheiblich
 * date 23.02.2010 05:42:23
 * contact graetz@mailfish.de
 */

package math.transform.jwave.handlers;

import math.transform.jwave.handlers.wavelets.Wavelet;
import math.transform.jwave.handlers.wavelets.WaveletInterface;


/**
 * Base class for the forward and reverse Discret Wavelet Transform in 1-D, 2-D,
 * and 3-D using a specified Wavelet by inheriting class.
 *
 * @date 23 juin 2011 15:55:33
 * @author Pol Kennel
 */
public class DiscreteWaveletTransform extends WaveletTransform {

  
  /**
   * Constructor receiving a WaveletI object.
   *
   * @date 23 juin 2011 15:54:54
   * @author Pol Kennel
   * @param wavelet
   */
  public DiscreteWaveletTransform(WaveletInterface wavelet ) {
    super(wavelet);
  }
  
  /**
   * Constructor receiving a WaveletI object and a iteration level for forward reverse methods
   *
   * @date 23 juin 2011 15:54:54
   * @author Pol Kennel
   * @param wavelet
   */
  public DiscreteWaveletTransform(WaveletInterface wavelet, int iteration ) {
    super(wavelet, iteration);
  }
  
  /**
   * Performs the 1-D forward transform for arrays of dim N from time domain to
   * Hilbert domain for the given array using the Discrete Wavelet Transform
   * (DWT) algorithm (identical to the Fast Wavelet Transform (FWT) in 1-D).
   * 
   * @date 24 juin 2011 13:16:00
   * @author Pol Kennel
   * @date 10.02.2010 08:23:24
   * @author Christian Scheiblich
   * @param arrTime
   *          coefficients of 1-D Time domain
   * @see math.transform.jwave.handlers.BasicTransform#forward(double[])
   */
  @Override
  public double[ ] forwardWavelet( double[ ] arrTime ) {
   
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
  }

  /**
   * Performs the 1-D reverse transform for arrays of dim N from Hilbert domain
   * to time domain for the given array using the Discrete Wavelet Transform
   * (DWT) algorithm and the selected wavelet (identical to the Fast Wavelet
   * Transform (FWT) in 1-D).
   * 
   * @date 24 juin 2011 13:16:18
   * @author Pol Kennel
   * @date 10.02.2010 08:23:24
   * @author Christian Scheiblich
   * @param arrHilb
   *          coefficients of 1-D Hilbert domain
   * @see math.transform.jwave.handlers.BasicTransform#reverse(double[])
   */
  @Override
  public double[ ] reverseWavelet( double[ ] arrHilb ) {

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
   * Performs the 1-D forward transform for arrays of dim N from time domain to
   * Hilbert domain for the given array using the Discrete Wavelet Transform
   * (DWT) algorithm. The number of transformation levels applied is limited by
   * threshold (identical to the Fast Wavelet Transform (FWT) in 1-D).
   * 
   * @date 24 juin 2011 13:18:38
   * @author Pol Kennel
   * @date 15.07.2010 13:26:26
   * @author Thomas Haider
   * @date 15.08.2010 00:31:36
   * @author Christian Scheiblich
   * @param arrTime
   *          coefficients of 1-D Time domain
   * @param toLevel
   *          iteration number
   * @see math.transform.jwave.handlers.BasicTransform#forward(double[], int)
   */
  @Override
  public double[ ] forwardWavelet( double[ ] arrTime, int toLevel ) {
    
    double[ ] arrHilb = new double[ arrTime.length ];
    for( int i = 0; i < arrTime.length; i++ )
      arrHilb[ i ] = arrTime[ i ];

    int level = 0;
    int h = arrTime.length;
    int minWaveLength = _wavelet.getWaveLength( );
    if( h >= minWaveLength ) {

      while( h >= minWaveLength && level < toLevel ) {

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
    
  }

  /**
   * Performs the 1-D reverse transform for arrays of dim N from Hilbert domain
   * to time domain for the given array using the Discrete Wavelet Transform
   * (DWT) algorithm and the selected wavelet (identical to the Fast Wavelet
   * Transform (FWT) in 1-D). The number of transformation levels applied is
   * limited by threshold.
   * 
   * @author Pol Kennel
   * @date 24 juin 2011 13:43:05
   * @author Thomas Haider
   * @date 15.08.2010 00:31:09
   * @author Christian Scheiblich
   * @date 20.06.2011 13:03:27
   * @param arrHilb
   *          coefficients of 1-D Hilbert domain
   * @param fromLevel
   *          iteration number
   * @see math.transform.jwave.handlers.BasicTransform#reverse(double[], int)
   */
  @Override
  public double[ ] reverseWavelet( double[ ] arrHilb, int fromLevel ) {
    
    double[ ] arrTime = new double[ arrHilb.length ];

    for( int i = 0; i < arrHilb.length; i++ )
      arrTime[ i ] = arrHilb[ i ];

    int level = 0;
    
    int minWaveLength = _wavelet.getWaveLength( );
    
    // int h = minWaveLength; // bug ... 20110620
    int h = (int)( arrHilb.length / ( Math.pow( 2, fromLevel - 1 ) ) ); // added by Pol
    
    if( arrHilb.length >= minWaveLength ) {

      while( h <= arrTime.length && h >= minWaveLength && level < fromLevel ) {

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
    
  }
  
  /**
   * Performs the 2-D forward transform from time domain to frequency or Hilbert
   * domain for a given array using the Discrete Wavelet Transform (DWT). It
   * corresponds to the non standard decomposition (alternates between
   * operations on rows and columns, in opposition of the standard
   * decomposition).
   * 
   * @date 24 juin 2011 13:44:51
   * @author Pol Kennel
   * @param matTime
   *          coefficients of 2-D time domain
   * @see math.transform.jwave.handlers.DiscreteWaveletTransform#forward(double[][])
   */
  public double[ ][ ] forwardWavelet( double[ ][ ] matTime ) {
    
    System.out.println("use bad one!");
    
    try {
      throw new Exception( "dfd");
    } catch( Exception e ) {
      // TODO pol should implement this try n catch
      e.printStackTrace();
    }
    
    int noOfRows = matTime.length;
    int noOfCols = matTime[ 0 ].length;
    double[ ][ ] matHilb = new double[ noOfRows ][ noOfCols ];
    for( int i = 0; i < matHilb[ 0 ].length; i++ )
      for( int j = 0; j < matHilb.length; j++ )
        matHilb[ i ][ j ] = matTime[ i ][ j ];

    int h = Math.min( noOfRows, noOfCols );
    int minWaveLength = _wavelet.getWaveLength( );
    
    if( h >= minWaveLength ) {
      while( h >= minWaveLength ) {                  // dimension limit
        
        for( int i = 0; i < h; i++ ) {               // rows processing
          double[ ] arrTime = new double[ h ];
          for( int j = 0; j < h; j++ )
            arrTime[ j ] = matHilb[ i ][ j ];
          
          double[ ] arrHilb = _wavelet.forward( arrTime );
          
          for( int j = 0; j < h; j++ )
            matHilb[ i ][ j ] = arrHilb[ j ];
        }
        
        for( int j = 0; j < h; j++ ) {               // columns processing
          double[ ] arrTime = new double[ h ];
          for( int i = 0; i < h; i++ )
            arrTime[ i ] = matHilb[ i ][ j ];

          double[ ] arrHilb = _wavelet.forward( arrTime );

          for( int i = 0; i < h; i++ )
            matHilb[ i ][ j ] = arrHilb[ i ];
        } 
        
        h = h >> 1;
      }
    }
    
    return matHilb;
  }

  /**
   * Performs the 2-D reverse transform from frequency or Hilbert or time domain
   * to time domain for a given array using the Discrete Wavelet Transform
   * (DWT). It corresponds to the non standard decomposition (alternates between
   * operations on rows and columns, in opposition of the standard
   * decomposition).
   * 
   * @date 24 juin 2011 13:51:05
   * @author Pol Kennel
   * @param matHilb
   *          coefficients of 2-D Hilbert domain
   * @see math.transform.jwave.handlers.DiscreteWaveletTransform#reverse(double[][])
   */
  public double[ ][ ] reverseWavelet( double[ ][ ] matHilb ) {
    
    int noOfRows = matHilb.length;
    int noOfCols = matHilb[ 0 ].length;
    double[ ][ ] matTime = new double[ noOfRows ][ noOfCols ];
    for( int i = 0; i < matHilb[ 0 ].length; i++ )
      for( int j = 0; j < matHilb.length; j++ )
        matTime[ i ][ j ] = matHilb[ i ][ j ];

    int dim = Math.min( noOfRows, noOfCols );
    int minWaveLength = _wavelet.getWaveLength( );
    int h = minWaveLength;
    
    if( h >= minWaveLength ) {
      while( h <= dim && h >= minWaveLength ) {              // dimension limit
        
        for( int i = 0; i < h; i++ ) {                       // rows processing
          double[ ] arrHilb = new double[ h ];
          for( int j = 0; j < h; j++ )
            arrHilb[ j ] = matTime[ i ][ j ];
          
          double[ ] arrTime = _wavelet.reverse( arrHilb );
          
          for( int j = 0; j < h; j++ )
            matTime[ i ][ j ] = arrTime[ j ];
        }
        
        for( int j = 0; j < h; j++ ) {                      // columns processing
          double[ ] arrHilb = new double[ h ];
          for( int i = 0; i < h; i++ )
            arrHilb[ i ] = matTime[ i ][ j ];

          double[ ] arrTime = _wavelet.reverse( arrHilb );

          for( int i = 0; i < h; i++ )
            matTime[ i ][ j ] = arrTime[ i ];
        } 
        
        h = h << 1;
      }
    }
    
    return matTime;
  }
  
  /**
   * Performs the 2-D forward transform from time domain to frequency or Hilbert
   * domain for a given array using the Discrete Wavelet Transform (DWT). It
   * corresponds to the non standard decomposition (alternates between
   * operations on rows and columns, in opposition of the standard
   * decomposition). The number of transformation levels applied is limited by
   * threshold.
   * 
   * @date 24 juin 2011 13:44:51
   * @author Pol Kennel
   * @param matTime
   *          coefficients of 2-D time domain
   * @param toLevel
   *          iteration number
   * @see math.transform.jwave.handlers.DiscreteWaveletTransform#forward(double[][])
   */
  @Override
  public double[ ][ ] forwardWavelet( double[ ][ ] matTime, int toLevel ) {
    
    System.out.println("use good one!");
    
    int noOfRows = matTime.length;
    int noOfCols = matTime[ 0 ].length;
    double[ ][ ] matHilb = new double[ noOfRows ][ noOfCols ];
    for( int i = 0; i < matHilb[ 0 ].length; i++ )
      for( int j = 0; j < matHilb.length; j++ )
        matHilb[ i ][ j ] = matTime[ i ][ j ];

    int level = 0;
    int h = Math.min( noOfRows, noOfCols );
    int minWaveLength = _wavelet.getWaveLength( );
    
    if( h >= minWaveLength ) {
      while( h >= minWaveLength && level < toLevel) { // levels
        
        for( int i = 0; i < h; i++ ) {                // rows processing
          double[ ] arrTime = new double[ h ];
          for( int j = 0; j < h; j++ )
            arrTime[ j ] = matHilb[ i ][ j ];
          
          double[ ] arrHilb = _wavelet.forward( arrTime );
          
          for( int j = 0; j < h; j++ )
            matHilb[ i ][ j ] = arrHilb[ j ];
        }
        
        for( int j = 0; j < h; j++ ) {                // columns processing
          double[ ] arrTime = new double[ h ];
          for( int i = 0; i < h; i++ )
            arrTime[ i ] = matHilb[ i ][ j ];

          double[ ] arrHilb = _wavelet.forward( arrTime );

          for( int i = 0; i < h; i++ )
            matHilb[ i ][ j ] = arrHilb[ i ];
        } 
        
        h = h >> 1;
        level++;
        
      }
    }
    
    return matHilb;
  }
  
  /**
   * Performs the 2-D reverse transform from frequency or Hilbert or time domain
   * to time domain for a given array using the Discrete Wavelet Transform
   * (DWT). It corresponds to the non standard decomposition (alternates between
   * operations on rows and columns, in opposition of the standard
   * decomposition). The number of transformation levels applied is limited by
   * threshold.
   * 
   * @date 24 juin 2011 13:51:05
   * @author Pol Kennel
   * @param matHilb
   *          coefficients of 2-D Hilbert domain
   * @param fromLevel
   *          iteration number
   * @see math.transform.jwave.handlers.DiscreteWaveletTransform#reverse(double[][])
   */
  @Override
  public double[ ][ ] reverseWavelet( double[ ][ ] matHilb, int fromLevel ) {

    int noOfRows = matHilb.length;
    int noOfCols = matHilb[ 0 ].length;
    double[ ][ ] matTime = new double[ noOfRows ][ noOfCols ];
    for( int i = 0; i < matHilb[ 0 ].length; i++ )
      for( int j = 0; j < matHilb.length; j++ )
        matTime[ i ][ j ] = matHilb[ i ][ j ];

    int level = 0;
    int dim = Math.min( noOfRows, noOfCols );
    int minWaveLength = _wavelet.getWaveLength( );
    int h = (int)( dim / Math.pow( 2, fromLevel - 1 ) );
    
    if( h >= minWaveLength ) {

      while( h <= dim && h >= minWaveLength && level < fromLevel) { // levels
        
        for( int i = 0; i < h; i++ ) {                              // rows processing
          double[ ] arrHilb = new double[ h ];
          for( int j = 0; j < h; j++ )
            arrHilb[ j ] = matTime[ i ][ j ];
          
          double[ ] arrTime = _wavelet.reverse( arrHilb );
          
          for( int j = 0; j < h; j++ )
            matTime[ i ][ j ] = arrTime[ j ];
        }
        
        for( int j = 0; j < h; j++ ) {                              // columns processing
          double[ ] arrHilb = new double[ h ];
          for( int i = 0; i < h; i++ )
            arrHilb[ i ] = matTime[ i ][ j ];

          double[ ] arrTime = _wavelet.reverse( arrHilb );

          for( int i = 0; i < h; i++ )
            matTime[ i ][ j ] = arrTime[ i ];
        } 
        
        h = h << 1;
        level++;
      }
    }
    
    return matTime;
  }
  
  /**
   * 
   * TODO pol explainMeShortly
   *
   * @date 24 juin 2011 14:04:00
   * @author pol
   * @see math.transform.jwave.handlers.BasicTransform#forward(double[][][])
   */
  public double[ ][ ][ ] forwardWavelet( double[ ][ ][ ] spcTime ) {
    // TODO 
    return spcTime;
  }
  
  /**
   * 
   * TODO pol explainMeShortly
   *
   * @date 24 juin 2011 14:04:18
   * @author pol
   * @see math.transform.jwave.handlers.BasicTransform#reverse(double[][][])
   */
  public double[ ][ ][ ] reverseWavelet( double[ ][ ][ ] spcHilb ) {
    // TODO
    return spcHilb;
    
  }
  
  

}
