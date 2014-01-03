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
 * This file WaveletPacketTransform.java is part of JWave.
 *
 * @author Christian Scheiblich
 * date 23.02.2010 13:44:05
 * contact graetz@mailfish.de
 */
package math.jwave.transforms;

import java.util.Arrays;
import math.jwave.exc.JWaveException;
import math.jwave.transforms.wavelets.Wavelet;

/**
 * Base class for the forward and reverse Wavelet Packet Transform (WPT) also
 * called Wavelet Packet Decomposition (WPD) using a specified Wavelet by
 * inheriting class.
 * 
 * @date 23.02.2010 13:44:05
 * @author Christian Scheiblich
 */
public class WaveletPacketTransform extends WaveletTransform {

  /**
   * Constructor receiving a Wavelet object.
   * 
   * @date 23.02.2010 13:44:05
   * @author Christian Scheiblich
   * @param wavelet
   *          object of type Wavelet; Haar02, Daub02, Coif06, ...
   * @throws JWaveException 
   */
  public WaveletPacketTransform( Wavelet wavelet ) {
    super( wavelet );

    try {
      checkConfig( );
    } catch( JWaveException e ) {
      e.printStackTrace( );
    }

  } // WaveletPacketTransform

  /**
   * Constructor receiving a Wavelet object.
   * 
   * @date 23.02.2010 13:44:05
   * @author Christian Scheiblich
   * @param wavelet
   *          object of type Wavelet; Haar02, Daub02, Coif06, ...
   * @param steps
   *          how many steps the algorithm should perform
   * @throws JWaveException 
   */
  public WaveletPacketTransform( Wavelet wavelet, int steps ) {

    super( wavelet, steps );

    try {
      checkConfig( );
    } catch( JWaveException e ) {
      e.printStackTrace( );
    }

  } // WaveletPacketTransform

  /**
   * Implementation of the 1-D forward wavelet packet transform for arrays of
   * dim N by filtering with the longest wavelet first and then always with both
   * sub bands -- low and high (approximation and details) -- by the next
   * smaller wavelet.
   * 
   * @date 23.02.2010 13:44:05
   * @author Christian Scheiblich
   * @see math.jwave.transforms.BasicTransform#forward(double[])
   */
  protected void forwardTransform( double[ ] arrHilb, int h ) {
    int g = arrHilb.length / h; // 1 -> 2 -> 4 -> 8 -> ...

    for( int p = 0; p < g; p++ ) {

      double[ ] iBuf = new double[ h ];

      for( int i = 0; i < h; i++ )
        iBuf[ i ] = arrHilb[ i + ( p * h ) ];

      double[ ] oBuf = _wavelet.forward( iBuf );

      for( int i = 0; i < h; i++ )
        arrHilb[ i + ( p * h ) ] = oBuf[ i ];

    } // packets
  }

  /**
   * Implementation of the 1-D reverse wavelet packet transform for arrays of
   * dim N by filtering with the smallest wavelet for all sub bands -- low and
   * high bands (approximation and details) -- and the by the next greater
   * wavelet combining two smaller and all other sub bands.
   * 
   * @date 23.02.2010 13:44:05
   * @author Christian Scheiblich
   * @see math.jwave.transforms.BasicTransform#reverse(double[])
   */
  protected void reverseTransform( double[ ] arrTime, int h ) {
    int g = arrTime.length / h; // ... -> 8 -> 4 -> 2 -> 1

    for( int p = 0; p < g; p++ ) {

      double[ ] iBuf = new double[ h ];

      for( int i = 0; i < h; i++ )
        iBuf[ i ] = arrTime[ i + ( p * h ) ];

      double[ ] oBuf = _wavelet.reverse( iBuf );

      for( int i = 0; i < h; i++ )
        arrTime[ i + ( p * h ) ] = oBuf[ i ];

    } // packets
  }

} // class
