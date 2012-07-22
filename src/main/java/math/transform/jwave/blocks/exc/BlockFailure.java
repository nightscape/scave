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
 * This file BlockFailure.java is part of JWave.
 *
 * @author tucker
 * date 11.06.2011 20:06:56
 * contact graetz@mailfish.de
 */
package math.transform.jwave.blocks.exc;

/**
 * Failure class as an recoverable exception.
 * 
 * @date 11.06.2011 20:06:56
 * @author Christian Scheiblich
 */
public class BlockFailure extends BlockException {

  /**
   * Generated serial id.
   *
   * @date 11.06.2011 20:08:17
   * @author Christian Scheiblich
   */
  private static final long serialVersionUID = -1020584447000514150L;

  /**
   * Constructor for failure message.
   * 
   * @date 11.06.2011 20:06:56
   * @author Christian Scheiblich
   * @param message
   */
  public BlockFailure( String message ) {
    super( message );
  }

  /**
   * Constructor taking any Java based exception.
   * 
   * @date 11.06.2011 20:06:56
   * @author Christian Scheiblich
   * @param e  object of type java.lang.Exception
   */
  public BlockFailure( Exception e ) {
    super( e );
  }

} // class
