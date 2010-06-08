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
 * This file Transform.java is part of JWave.
 *
 * @author Christian Scheiblich
 * date 23.02.2010 05:42:23
 * contact source@linux23.de
 */
package cs.jwave;

import cs.jwave.handlers.BasicTransform;

/**
 * Base class for transforms like Wavelets, Fourier, and ...
 * 
 * @date 19.05.2009 09:43:40
 * @author Christian Scheiblich
 */
public class Transform {

  /**
   * Transform object of type base class
   */
  BasicTransform _basicTransform;

  /**
   * Constructor; needs some object like DiscreteFourierTransform,
   * FastWaveletTransform, WaveletPacketTransfom, ...
   * 
   * @date 19.05.2009 09:50:24
   * @author Christian Scheiblich
   */
  public Transform( BasicTransform basicTransform ) {
    _basicTransform = basicTransform;
  } // Transform

  /**
   * Performs the forward transform of the specified BasicWave object.
   * 
   * @date 10.02.2010 09:41:01
   * @author Christian Scheiblich
   * @param arrTime
   *          coefficients of time domain
   * @return coefficients of frequency or Hilbert domain
   */
  public double[ ] forward( double[ ] arrTime ) {
    return _basicTransform.forward( arrTime );
  } // forward

  /**
   * Performs the reverse transform of the specified BasicWave object.
   * 
   * @date 10.02.2010 09:42:18
   * @author Christian Scheiblich
   * @param arrFreq
   *          coefficients of frequency or Hilbert domain
   * @return coefficients of time domain
   */
  public double[ ] reverse( double[ ] arrFreq ) {
    return _basicTransform.reverse( arrFreq );
  } // reverse

  /**
   * Performs the 2-D forward transform of the specified BasicWave object.
   * 
   * @date 10.02.2010 10:58:54
   * @author Christian Scheiblich
   * @param matrixTime
   *          coefficients of 2-D time domain
   * @return coefficients of 2-D frequency or Hilbert domain
   */
  public double[ ][ ] forward( double[ ][ ] matrixTime ) {
    return _basicTransform.forward( matrixTime );
  } // forward

  /**
   * Performs the 2-D reverse transform of the specified BasicWave object.
   * 
   * @date 10.02.2010 10:59:32
   * @author Christian Scheiblich
   * @param matrixFreq
   *          coefficients of 2-D frequency or Hilbert domain
   * @return coefficients of 2-D time domain
   */
  public double[ ][ ] reverse( double[ ][ ] matrixFreq ) {
    return _basicTransform.reverse( matrixFreq );
  } // reverse

} // class
