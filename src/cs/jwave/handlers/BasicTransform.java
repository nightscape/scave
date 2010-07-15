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
 * This file BasicTransform.java is part of JWave.
 *
 * @author Christian Scheiblich
 * date 23.02.2010 05:42:23
 * contact source@linux23.de
 */
package cs.jwave.handlers;

/**
 * Basic Wave for transformations like Fast Fourier Transform (FFT), Fast
 * Wavelet Transform (FWT), or Fast Wavelet Packet Transform (WPT). Naming of
 * this class due to en.wikipedia.org; to write Fourier series in terms of the
 * 'basic waves' of function: e^(2*pi*i*w).
 * 
 * @date 08.02.2010 11:11:59
 * @author Christian Scheiblich
 */
public abstract class BasicTransform {

  /**
   * Constructor; does nothing
   * 
   * @date 08.02.2010 11:11:59
   * @author Christian Scheiblich
   */
  protected BasicTransform( ) {
  } // BasicTransform

  /**
   * Performs the forward transform from time domain to frequency or Hilbert
   * domain for a given array depending on the used transform algorithm by
   * inheritance.
   * 
   * @date 10.02.2010 08:23:24
   * @author Christian Scheiblich
   * @param arrTime
   *          coefficients of 1-D time domain
   * @return coefficients of 1-D frequency or Hilbert domain
   */
  public abstract double[ ] forward( double[ ] arrTime );

  /**
   * Performs the reverse transform from frequency or Hilbert domain to time
   * domain for a given array depending on the used transform algorithm by
   * inheritance.
   * 
   * @date 10.02.2010 08:23:24
   * @author Christian Scheiblich
   * @param arrFreq
   *          coefficients of 1-D frequency or Hilbert domain
   * @return coefficients of 1-D time domain
   */
  public abstract double[ ] reverse( double[ ] arrFreq );

  /**
   * Performs the 2-D forward transform from time domain to frequency or Hilbert
   * domain for a given array depending on the used transform algorithm by
   * inheritance.
   * 
   * @date 10.02.2010 11:00:29
   * @author Christian Scheiblich
   * @param matrixTime
   *          coefficients of 2-D time domain
   * @return coefficients of 2-D frequency or Hilbert domain
   */
  public abstract double[ ][ ] forward( double[ ][ ] matrixTime );

  /**
   * Performs the 2-D reverse transform from frequency or Hilbert or time domain
   * to time domain for a given array depending on the used transform algorithm
   * by inheritance.
   * 
   * @date 10.02.2010 11:01:38
   * @author Christian Scheiblich
   * @param matrixFreq
   *          coefficients of 2-D frequency or Hilbert domain
   * @return coefficients of 2-D time domain
   */
  public abstract double[ ][ ] reverse( double[ ][ ] matrixFreq );

  /**
   * Performs the 3-D forward transform from time domain to frequency or Hilbert
   * domain for a given array depending on the used transform algorithm by
   * inheritance.
   * 
   * @date 10.07.2010 18:08:17
   * @author Christian Scheiblich
   * @param matrixFreq
   *          coefficients of 3-D frequency or Hilbert domain
   * @return coefficients of 3-D time domain
   */
  public abstract double[ ][ ][ ] forward( double[ ][ ][ ] spcTime );

  /**
   * Performs the 3-D reverse transform from frequency or Hilbert domain to time
   * domain for a given array depending on the used transform algorithm by
   * inheritance.
   * 
   * @date 10.07.2010 18:09:54
   * @author Christian Scheiblich
   * @param matrixFreq
   *          coefficients of 3-D frequency or Hilbert domain
   * @return coefficients of 3-D time domain
   */
  public abstract double[ ][ ][ ] reverse( double[ ][ ][ ] spcHilb );

  /**
   * Performs the forward transform from time domain to frequency or Hilbert
   * domain for a given array depending on the used transform algorithm by
   * inheritance. The number of transformation levels applied is limited by
   * threshold.
   * 
   * @date 15.07.2010
   * @author Thomas Haider
   * @param arrTime
   *          coefficients of 1-D time domain
   * @param toLevel
   *          threshold for number of iterations
   * @return coefficients of 1-D frequency or Hilbert domain
   */
  public abstract double[ ] forward( double[ ] arrTime, int toLevel );

  /**
   * Performs the reverse transform from frequency or Hilbert domain to time
   * domain for a given array depending on the used transform algorithm by
   * inheritance. The number of transformation levels applied is limited by
   * threshold.
   * 
   * @date 15.07.2010
   * @author Thomas Haider
   * @param arrFreq
   *          coefficients of 1-D frequency or Hilbert domain
   * @param fromLevel
   *          threshold for number of iterations
   * @return coefficients of 1-D time domain
   */
  public abstract double[ ] reverse( double[ ] arrFreq, int fromLevel );

  /**
   * Performs the 2-D forward transform from time domain to frequency or Hilbert
   * domain for a given array depending on the used transform algorithm by
   * inheritance. The number of transformation levels applied is limited by
   * threshold.
   * 
   * @date 15.07.2010
   * @author Thomas Haider
   * @param matrixTime
   *          coefficients of 2-D time domain
   * @param toLevel
   *          threshold for number of iterations
   * @return coefficients of 2-D frequency or Hilbert domain
   */
  public abstract double[ ][ ] forward( double[ ][ ] matrixTime, int toLevel );

  /**
   * Performs the 2-D reverse transform from frequency or Hilbert or time domain
   * to time domain for a given array depending on the used transform algorithm
   * by inheritance. The number of transformation levels applied is limited by
   * threshold.
   * 
   * @date 15.07.2010
   * @author Thomas Haider
   * @param matrixFreq
   *          coefficients of 2-D frequency or Hilbert domain
   * @param fromLevel
   *          threshold for number of iterations
   * @return coefficients of 2-D time domain
   */
  public abstract double[ ][ ] reverse( double[ ][ ] matrixFreq, int fromLevel );

  /**
   * Performs the 3-D forward transform from time domain to frequency or Hilbert
   * domain for a given array depending on the used transform algorithm by
   * inheritance. The number of transformation levels applied is limited by
   * threshold.
   * 
   * @date 15.07.2010
   * @author Thomas Haider
   * @param matrixFreq
   *          coefficients of 3-D frequency or Hilbert domain
   * @param toLevel
   *          threshold for number of iterations
   * @return coefficients of 3-D time domain
   */
  public abstract double[ ][ ][ ] forward( double[ ][ ][ ] spcTime,
      int toLevel );

  /**
   * Performs the 3-D reverse transform from frequency or Hilbert domain to time
   * domain for a given array depending on the used transform algorithm by
   * inheritance. The number of transformation levels applied is limited by
   * threshold.
   * 
   * @date 15.07.2010
   * @author Thomas Haider
   * @param matrixFreq
   *          coefficients of 3-D frequency or Hilbert domain
   * @param threshold
   *          threshold for number of iterations
   * @return coefficients of 3-D time domain
   */
  public abstract double[ ][ ][ ] reverse( double[ ][ ][ ] spcHilb,
      int fromLevel );

} // class
