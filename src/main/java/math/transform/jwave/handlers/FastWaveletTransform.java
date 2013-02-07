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
 * This file FastBasicTransform.java is part of JWave.
 *
 * @author Christian Scheiblich
 * date 23.02.2010 05:42:23
 * contact graetz@mailfish.de
 */
package math.transform.jwave.handlers;

import math.transform.jwave.exc.JWaveException;
import math.transform.jwave.handlers.wavelets.Wavelet;
import math.transform.jwave.handlers.wavelets.WaveletInterface;

/**
 * Base class for the forward and reverse Fast Wavelet Transform in 1-D, 2-D,
 * and 3-D using a specified Wavelet by inheriting class.
 * 
 * @date 10.02.2010 08:10:42
 * @author Christian Scheiblich
 */
public class FastWaveletTransform extends WaveletTransform {
  
  /**
   * Constructor receiving a Wavelet object.
   * 
   * @date 10.02.2010 08:10:42
   * @author Christian Scheiblich
   * @param wavelet
   *          object of type Wavelet; Haar02, Daub02, Coif06, ...
   * @throws JWaveException 
   */
  public FastWaveletTransform( Wavelet wavelet ) throws JWaveException {
    super( wavelet );
  } // FastBasicTransform
  
  /**
   * Constructor receiving a Wavelet object.
   * 
   * @date 10.02.2010 08:10:42
   * @author Christian Scheiblich
   * @param wavelet
   *          object of type Wavelet; Haar02, Daub02, Coif06, ...
   * @throws JWaveException 
   */
  public FastWaveletTransform( Wavelet wavelet, int iteration ) throws JWaveException {
    super( wavelet, iteration );
  } // FastBasicTransform
  
  /**
   * Performs the 1-D forward transform for arrays of dim N from time domain to
   * Hilbert domain for the given array using the Fast Wavelet Transform (FWT)
   * algorithm.
   * 
   * @date 10.02.2010 08:23:24
   * @author Christian Scheiblich
   * @see math.transform.jwave.handlers.BasicTransform#forward(double[])
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
      
      while( h >= minWaveLength && ( level < _steps || _steps == -1 ) ) {
        
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
   * @see math.transform.jwave.handlers.BasicTransform#reverse(double[])
   */
  @Override
  public double[ ] reverse( double[ ] arrHilb ) {
    
    double[ ] arrTime = new double[ arrHilb.length ];
    
    for( int i = 0; i < arrHilb.length; i++ )
      arrTime[ i ] = arrHilb[ i ];
    
    int level = 0;
    int minWaveLength = _wavelet.getWaveLength( );
    int h = minWaveLength;
    //  int h = (int)( arrHilb.length / ( Math.pow( 2, _steps - 1 ) ) ); // added by Pol
    if( arrHilb.length >= minWaveLength ) {
      
      // while( h <= arrTime.length && h >= minWaveLength ) {
      
      while( h <= arrTime.length && h >= minWaveLength && ( level < _steps || _steps == -1 ) ) {
        
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
  }// reverse  
   
} // class
