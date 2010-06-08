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
 * This file Wavelet.java is part of JWave.
 *
 * @author Christian Scheiblich
 * date 23.02.2010 05:42:23
 * contact source@linux23.de
 */
package cs.jwave.handlers.wavelets;

/**
 * Basic class for one wavelet keeping coefficients of the wavelet function, the
 * scaling function, the base wavelength, the forward transform method, and the
 * reverse transform method.
 * 
 * @date 10.02.2010 08:54:48
 * @author Christian Scheiblich
 */
public abstract class Wavelet {

  /**
   * minimal wavelength of the used wavelet and scaling coefficients
   */
  protected int _waveLength;

  /**
   * coefficients of the wavelet; wavelet function
   */
  protected double[ ] _coeffs;

  /**
   * coefficients of the scales; scaling function
   */
  protected double[ ] _scales;

  /**
   * Constructor; predefine members to init values
   * 
   * @date 10.02.2010 08:54:48
   * @author Christian Scheiblich
   */
  public Wavelet( ) {
    _waveLength = 0;
    _coeffs = null;
    _scales = null;
  } // Wavelet

  /**
   * Performs the forward transform for the given array from time domain to
   * Hilbert domain and returns a new array of the same size keeping
   * coefficients of Hilbert domain.
   * 
   * @date 10.02.2010 08:18:02
   * @author Christian Scheiblich
   * @param arrTime
   *          array keeping time domain coefficients
   * @return coefficients represented by frequency domain
   */
  public abstract double[ ] forward( double[ ] arrTime );

  /**
   * Performs the reverse transform for the given array from Hilbert domain to
   * time domain and returns a new array of the same size keeping coefficients
   * of time domain.
   * 
   * @date 10.02.2010 08:19:24
   * @author Christian Scheiblich
   * @param arrHilb
   *          array keeping frequency domain coefficients
   * @return coefficients represented by time domain
   */
  public abstract double[ ] reverse( double[ ] arrHilb );

  /**
   * Returns the minimal wavelength for the used wavelet.
   * 
   * @date 10.02.2010 08:13:59
   * @author Christian Scheiblich
   * @return the minimal wavelength for this basic wave
   */
  public int getWaveLength( ) {
    return _waveLength;
  } // getWaveLength

  /**
   * Returns the number of coeffs (and scales).
   * 
   * @date 08.02.2010 13:11:47
   * @author Christian Scheiblich
   * @return integer representing the number of coeffs.
   */
  public int getLength( ) {
    return _coeffs.length;
  } // getLength

  /**
   * Returns a double array with the coeffs.
   * 
   * @date 08.02.2010 13:14:54
   * @author Christian Scheiblich
   * @return double array keeping the coeffs.
   */
  public double[ ] getCoeffs( ) {
    double[ ] coeffs = new double[ _coeffs.length ];
    for( int c = 0; c < _coeffs.length; c++ )
      coeffs[ c ] = _coeffs[ c ];
    return coeffs;
  } // getCoeffs

  /**
   * Returns a double array with the scales (of a wavelet).
   * 
   * @date 08.02.2010 13:15:25
   * @author Christian Scheiblich
   * @return double array keeping the scales.
   */
  public double[ ] getScales( ) {
    double[ ] scales = new double[ _scales.length ];
    for( int s = 0; s < _scales.length; s++ )
      scales[ s ] = _scales[ s ];
    return scales;
  } // getScales

} // class
