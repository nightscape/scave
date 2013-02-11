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
 * This file BlockException.java is part of JWave.
 *
 * @author Christian Scheiblich
 * contact graetz@mailfish.de
 * date Feb 11, 2013 2:46:06 PM
 *
 */
package math.transform.jwave.superblocks.blocks.exc;

import math.transform.jwave.superblocks.exc.SuperBlockException;


/**
 * @author Christian Scheiblich
 * date Feb 11, 2013 2:46:06 PM
 *
 */
public class BlockException extends SuperBlockException {
  
  /**
   * @author Christian Scheiblich
   * date Feb 11, 2013 2:46:36 PM
   *
   */
  private static final long serialVersionUID = 8039031915291034048L;

  /**
   * @author Christian Scheiblich
   * date Feb 11, 2013 2:46:06 PM
   *
   * @param message
   */
  public BlockException( String message ) {
    super( message );
  }
  
  /**
   * @author Christian Scheiblich
   * date Feb 11, 2013 2:46:06 PM
   *
   * @param e
   */
  public BlockException( Exception e ) {
    super( e );
  }
  
}
