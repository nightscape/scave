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
 * This file TransformLevel.java is part of JWave.
 *
 * @author itechsch
 * date 15.07.2010 13:13:51
 * contact source@linux23.de
 */
package cs.jwave;

import cs.jwave.handlers.BasicTransform;

/**
 * TODO Thomas Haider explainMeShortly
 * 
 * @date 15.07.2010 13:13:51
 * @author Thomas Haider
 */
public class TransformLevel {

  /**
   * Transform object of type base class
   */
  protected BasicTransform _basicTransform;

  /**
   * TODO Thomas Haider explainMeShortly
   * 
   * @date 15.07.2010 13:13:52
   * @author Thomas Haider
   */
  public TransformLevel( BasicTransform basicTransform ) {
    _basicTransform = basicTransform;
  } // TransformLevel

  /**
   * Performs the forward transform of the specified BasicWave object. The
   * number of transformation levels applied is limited by toLevel.
   * 
   * @date 15.07.2010
   * @author Thomas Haider
   * @param arrayTime
   *          coefficients of time domain
   * @param toLevel
   *          threshold for number of iterations
   * @return coefficients of frequency or Hilbert domain
   */
  public double[ ] forward( double[ ] arrayTime, int toLevel ) {
    return _basicTransform.forward( arrayTime, toLevel );
  } // forward

  /**
   * Performs the reverse transform of the specified BasicWave object. The
   * number of transformation levels applied is limited by toLevel.
   * 
   * @date 15.07.2010
   * @author Thomas Haider
   * @param arrayFreq
   *          coefficients of frequency or Hilbert domain
   * @param fromLevel
   *          threshold for number of iterations
   * @return coefficients of time domain
   */
  public double[ ] reverse( double[ ] arrayFreq, int fromLevel ) {
    return _basicTransform.reverse( arrayFreq, fromLevel );
  } // reverse

  /**
   * Performs the 2-D forward transform of the specified BasicWave object. The
   * number of transformation levels applied is limited by toLevel.
   * 
   * @date 15.07.2010
   * @author Thomas Haider
   * @param matrixTime
   *          coefficients of 2-D time domain
   * @param toLevel
   *          threshold for number of iterations
   * @return coefficients of 2-D frequency or Hilbert domain
   */
  public double[ ][ ] forward( double[ ][ ] matrixTime, int toLevel ) {
    return _basicTransform.forward( matrixTime, toLevel );
  } // forward

  /**
   * Performs the 2-D reverse transform of the specified BasicWave object. The
   * number of transformation levels applied is limited by toLevel.
   * 
   * @date 15.07.2010
   * @author Thomas Haider
   * @param matrixFreq
   *          coefficients of 2-D frequency or Hilbert domain
   * @param fromLevel
   *          threshold for number of iterations
   * @return coefficients of 2-D time domain
   */
  public double[ ][ ] reverse( double[ ][ ] matrixFreq, int fromLevel ) {
    return _basicTransform.reverse( matrixFreq, fromLevel );
  } // reverse

  /**
   * Performs the 3-D forward transform of the specified BasicWave object. The
   * number of transformation levels applied is limited by toLevel.
   * 
   * @date 15.07.2010
   * @author Thomas Haider
   * @param spaceTime
   *          coefficients of 3-D time domain
   * @param toLevel
   *          threshold for number of iterations
   * @return coefficients of 3-D frequency or Hilbert domain
   */
  public double[ ][ ][ ] forward( double[ ][ ][ ] spaceTime, int toLevel ) {
    return _basicTransform.forward( spaceTime, toLevel );
  } // forward

  /**
   * Performs the 3-D reverse transform of the specified BasicWave object. The
   * number of transformation levels applied is limited by toLevel.
   * 
   * @date 15.07.2010
   * @author Thomas Haider
   * @param spaceFreq
   *          coefficients of 3-D frequency or Hilbert domain
   * @param fromLevel
   *          threshold for number of iterations
   * @return coefficients of 3-D time domain
   */
  public double[ ][ ][ ] reverse( double[ ][ ][ ] spaceFreq, int fromLevel ) {
    return _basicTransform.reverse( spaceFreq, fromLevel );
  } // reverse

} // class
