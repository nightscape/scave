/**
 * JWave
 *
 * Copyright 2010-2013 Christian Scheiblich
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
 * This file WaveletTransform.java is part of JWave.
 *
 * @author Christian Scheiblich
 * contact graetz@mailfish.de
 * date Feb 6, 2013 4:50:31 PM
 *
 */
package math.transform.jwave.handlers;

import math.transform.jwave.exc.JWaveError;
import math.transform.jwave.exc.JWaveException;
import math.transform.jwave.exc.JWaveFailure;
import math.transform.jwave.handlers.wavelets.Wavelet;

/**
 * @author Christian Scheiblich
 * date Feb 6, 2013 4:50:31 PM
 *
 */
public abstract class WaveletTransform extends BasicTransform {
  
  /**
   * The used wavelet for transforming
   * 
   * @author Christian Scheiblich
   * date Feb 6, 2013 4:51:51 PM
   *
   */
  protected Wavelet _wavelet;
  
  /**
   * The steps the Wavelet transform should do. If it is set to -1,
   * the transform algorithms perform the maximum number of steps.
   * 
   * @author Christian Scheiblich
   * date Feb 6, 2013 4:54:00 PM
   *
   */
  protected int _steps;
  
  /**
   * @author Christian Scheiblich
   * date Feb 6, 2013 4:51:01 PM
   *
   * @param wavelet
   */
  protected WaveletTransform( Wavelet wavelet ) throws JWaveException {
    
    if( wavelet == null )
      throw new JWaveError( "Given object Wavelet is null" );
    
    _wavelet = wavelet;

    _steps = -1; // allows for the maximum number of steps
    
  }
  
  /**
   * A Wavelet transform that is reduced to minor steps as given
   * by a positive number.
   * 
   * @author Christian Scheiblich
   * date Feb 6, 2013 4:54:43 PM
   *
   * @param wavelet
   * @param steps
   * @throws JWaveException
   */
  protected WaveletTransform( Wavelet wavelet, int steps ) throws JWaveException {
    
    if( wavelet == null )
      throw new JWaveError( "Given object Wavelet is null" );
    
    _wavelet = wavelet;
    
    if( steps < 1 )
      throw new JWaveFailure( "given steps are smaller than 1" );
    
    _steps = steps;
    
  }
  
}
