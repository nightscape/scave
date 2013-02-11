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
 * This file BlockFailure.java is part of JWave.
 *
 * @author Christian Scheiblich
 * contact graetz@mailfish.de
 * date Feb 11, 2013 2:47:32 PM
 *
 */
package math.transform.jwave.superblocks.blocks.exc;


/**
 * @author Christian Scheiblich
 * date Feb 11, 2013 2:47:32 PM
 *
 */
public class BlockFailure extends BlockException {
  
  /**
   * @author Christian Scheiblich
   * date Feb 11, 2013 2:47:47 PM
   *
   */
  private static final long serialVersionUID = 4627006925537451321L;

  /**
   * @author Christian Scheiblich
   * date Feb 11, 2013 2:47:32 PM
   *
   * @param message
   */
  public BlockFailure( String message ) {
    super( message );
  }
  
  /**
   * @author Christian Scheiblich
   * date Feb 11, 2013 2:47:32 PM
   *
   * @param e
   */
  public BlockFailure( Exception e ) {
    super( e );
  }
  
}
