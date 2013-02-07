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
 * This file BlockInterface.java is part of JWave.
 *
 * @author Christian Scheiblich
 * contact graetz@mailfish.de
 * date Feb 6, 2013 3:14:20 PM
 *
 */
package math.transform.jwave.blocks.types;

/**
 * @author Christian Scheiblich
 * date Feb 6, 2013 3:14:20 PM
 *
 */
public interface BlockInterface {
  
  /**
   * @author Christian Scheiblich
   * date Feb 6, 2013 3:19:03 PM
   *
   * @return the current unique number of this Block - not negative, starts by 0
   */
  public int getBlockNo( );
  
  /**
   * @author Christian Scheiblich
   * date Feb 6, 2013 3:19:14 PM
   *
   * @param no the current unique number of this Block - not negative, start by 0
   */
  public void setBlockNo( int no );
  
} // BlockInterface