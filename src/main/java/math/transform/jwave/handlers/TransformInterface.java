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

/**
 * 
 * Interface for all transform methods.
 *
 * @date 30 juin 2011 10:14:22
 * @author Pol Kennel
 */
public interface TransformInterface {

  // 1-D
  public abstract double[ ] forward( double[ ] arrTime );

  public abstract double[ ] reverse( double[ ] arrHilb );

  // 2-D
  public abstract double[ ][ ] forward( double[ ][ ] matTime );

  public abstract double[ ][ ] reverse( double[ ][ ] matHilb );

  // 3-D
  public abstract double[ ][ ][ ] forward( double[ ][ ][ ] spcTime );

  public abstract double[ ][ ][ ] reverse( double[ ][ ][ ] spcHilb );

}
