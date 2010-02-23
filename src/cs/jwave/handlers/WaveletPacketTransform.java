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
 * This file WaveletPacketTransform.java is part of JWave.
 *
 * @author Christian Scheiblich
 * date 23.02.2010 13:44:05
 * contact source@linux23.de
 */
package cs.jwave.handlers;

import cs.jwave.handlers.wavelets.Wavelet;

/**
 * Base class for the forward and reverse Wavelet Packet Transform using a
 * specified Wavelet by inheriting class.
 * 
 * @date 23.02.2010 13:44:05
 * @author Christian Scheiblich
 */
public class WaveletPacketTransform extends BasicTransform {

  /**
   * The used wavelet for the specified transform algorithm.
   */
  Wavelet _wavelet;

  /**
   * Constructor receiving a Wavelet object.
   * 
   * @date 23.02.2010 13:44:05
   * @author Christian Scheiblich
   * @param wavelet
   *          object of type Wavelet; Haar02, Daub04, Coif06, ...
   */
  public WaveletPacketTransform( Wavelet wavelet ) {
    _wavelet = wavelet;
  } // WaveletPacketTransform

  /**
   * TODO Christian Scheiblich explainMeShortly
   * 
   * @date 23.02.2010 13:44:05
   * @author Christian Scheiblich
   * @see cs.jwave.handlers.BasicTransform#forward(double[])
   */
  @Override
  public double[ ] forward( double[ ] arrTime ) {
    // TODO Christian Scheiblich should implement this method
    return null;
  } // forward

  /**
   * TODO Christian Scheiblich explainMeShortly
   * 
   * @date 23.02.2010 13:44:05
   * @author Christian Scheiblich
   * @see cs.jwave.handlers.BasicTransform#reverse(double[])
   */
  @Override
  public double[ ] reverse( double[ ] arrFreq ) {
    // TODO Christian Scheiblich should implement this method
    return null;
  } // reverse

  /**
   * TODO Christian Scheiblich explainMeShortly
   * 
   * @date 23.02.2010 13:44:05
   * @author Christian Scheiblich
   * @see cs.jwave.handlers.BasicTransform#forward(double[][])
   */
  @Override
  public double[ ][ ] forward( double[ ][ ] matrixTime ) {
    // TODO Christian Scheiblich should implement this method
    return null;
  } // forward

  /**
   * TODO Christian Scheiblich explainMeShortly
   * 
   * @date 23.02.2010 13:44:05
   * @author Christian Scheiblich
   * @see cs.jwave.handlers.BasicTransform#reverse(double[][])
   */
  @Override
  public double[ ][ ] reverse( double[ ][ ] matrixFreq ) {
    // TODO Christian Scheiblich should implement this method
    return null;
  } // reverse

}
