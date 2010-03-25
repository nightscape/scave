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
 * This file DiscreteFourierTransform.java is part of JWave.
 *
 * @author Christian Scheiblich
 * date 25.03.2010 19:56:29
 * contact source@linux23.de
 */
package cs.jwave.handlers;

/**
 * The Discrete Fourier Transform (DFT) is - as the name says - the discrete
 * version of the Fourier Transform applied to a discrete complex valued series.
 * While the DFT can be applied to any complex valued series; of any length, in
 * practice for large series it can take considerable time to compute, while the
 * time taken being proportional to the square of the number on points in the
 * series.
 * 
 * @date 25.03.2010 19:56:29
 * @author Christian Scheiblich
 */
public class DiscreteFourierTransform extends BasicTransform {

  protected double _pi;

  /**
   * Constructor setting initializes member variables for DFT; herePI
   * 
   * @date 25.03.2010 19:56:29
   * @author Christian Scheiblich
   */
  public DiscreteFourierTransform( ) {
    _pi = 3.141592654;
  } // DiscreteFourierTransform

  /**
   * The 1-D forward version of the Discrete Fourier Transform (DFT); The input
   * array arrTime is organized by real and imaginary parts of a complex number
   * using even and odd places for the index. For example: arrTime[ 0 ] = real1,
   * arrTime[ 1 ] = imag1, arrTime[ 2 ] = real2, arrTime[ 3 ] = imag2, ... The
   * output arrFreq is organized by the same scheme.
   * 
   * @date 25.03.2010 19:56:29
   * @author Christian Scheiblich
   * @see cs.jwave.handlers.BasicTransform#forward(double[])
   */
  @Override
  public double[ ] forward( double[ ] arrTime ) {

    int m = arrTime.length;
    double[ ] arrFreq = new double[ m ]; // result

    int n = m >> 1; // half of m
    for( int i = 0; i < n; i++ ) {
      int iR = i * 2;
      int iC = i * 2 + 1;
      arrFreq[ iR ] = 0.;
      arrFreq[ iC ] = 0.;
      double arg = -2. * _pi * (double)i / (double)n;
      for( int k = 0; k < n; k++ ) {
        int kR = k * 2;
        int kC = k * 2 + 1;
        double cos = Math.cos( k * arg );
        double sin = Math.sin( k * arg );
        arrFreq[ iR ] += arrTime[ kR ] * cos - arrTime[ kC ] * sin;
        arrFreq[ iC ] += arrTime[ kR ] * sin + arrTime[ kC ] * cos;
      } // k
      arrFreq[ iR ] /= (double)n;
      arrFreq[ iC ] /= (double)n;
    } // i

    return arrFreq;
  } // forward

  /**
   * The 1-D reverse version of the Discrete Fourier Transform (DFT); The input
   * array arrFreq is organized by real and imaginary parts of a complex number
   * using even and odd places for the index. For example: arrTime[ 0 ] = real1,
   * arrTime[ 1 ] = imag1, arrTime[ 2 ] = real2, arrTime[ 3 ] = imag2, ... The
   * output arrTime is organized by the same scheme.
   * 
   * @date 25.03.2010 19:56:29
   * @author Christian Scheiblich
   * @see cs.jwave.handlers.BasicTransform#reverse(double[])
   */
  @Override
  public double[ ] reverse( double[ ] arrFreq ) {

    int m = arrFreq.length;
    double[ ] arrTime = new double[ m ]; // result

    int n = m >> 1; // half of m
    for( int i = 0; i < n; i++ ) {
      int iR = i * 2;
      int iC = i * 2 + 1;
      arrTime[ iR ] = 0.;
      arrTime[ iC ] = 0.;
      double arg = 2. * _pi * (double)i / (double)n;
      for( int k = 0; k < n; k++ ) {
        int kR = k * 2;
        int kC = k * 2 + 1;
        double cos = Math.cos( k * arg );
        double sin = Math.sin( k * arg );
        arrTime[ iR ] += arrFreq[ kR ] * cos - arrFreq[ kC ] * sin;
        arrTime[ iC ] += arrFreq[ kR ] * sin + arrFreq[ kC ] * cos;
      } // a
    } // i

    return arrTime;
  } // reverse

  /**
   * The 2-D forward version of the Discrete Fourier Transform (DFT); The input
   * array matTime is organized by real and imaginary parts of a complex number
   * using even and odd places for the indices. For example: matTime[0][0] =
   * real11, matTime[0][1] = imag11, matTime[0][2] = real12, matTime[0][3] =
   * imag12, matTime[1][0] = real21, matTime[1][1] = imag21, matTime[1][2] =
   * real22, matTime[1][3] = imag2... The output matFreq is organized by the
   * same scheme.
   * 
   * @date 25.03.2010 19:56:29
   * @author Christian Scheiblich
   * @see cs.jwave.handlers.BasicTransform#forward(double[][])
   */
  @Override
  public double[ ][ ] forward( double[ ][ ] matTime ) {
    // TODO Christian Scheiblich should implement this method
    return null;
  } // forward

  /**
   * The 2-D reverse version of the Discrete Fourier Transform (DFT); The input
   * array matFreq is organized by real and imaginary parts of a complex number
   * using even and odd places for the indices. For example: matFreq[0][0] =
   * real11, matFreq[0][1] = imag11, matFreq[0][2] = real12, matFreq[0][3] =
   * imag12, matFreq[1][0] = real21, matFreq[1][1] = imag21, matFreq[1][2] =
   * real22, matFreq[1][3] = imag2... The output matTime is organized by the
   * same scheme.
   * 
   * @date 25.03.2010 19:56:29
   * @author Christian Scheiblich
   * @see cs.jwave.handlers.BasicTransform#reverse(double[][])
   */
  @Override
  public double[ ][ ] reverse( double[ ][ ] matFreq ) {
    // TODO Christian Scheiblich should implement this method
    return null;
  } // reverse

} // class
