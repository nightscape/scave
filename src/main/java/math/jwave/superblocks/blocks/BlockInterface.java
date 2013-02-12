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
package math.jwave.superblocks.blocks;

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
  
  /**
   * Get the number of rows the block is holding.
   * 
   * @author Christian Scheiblich
   * date 07.02.2013 05:18:54
   *
   * @return the number of rows the block got.
   */
  public int getNoRows( );
  
  /**
   * Get the number of cols the block is holding.
   * 
   * @author Christian Scheiblich
   * date 07.02.2013 05:19:17
   *
   * @return the number of columns the block got.
   */
  public int getNoCols( );
  
  /**
   * Get the offset of the rows of the Block.
   * 
   * @author Christian Scheiblich
   * date 07.02.2013 05:19:47
   *
   * @return the upper left position for the rows of the block.
   */
  public int getOffSetRow( );
  
  /**
   * Get the offset of the columns of the Block.
   * 
   * @author Christian Scheiblich
   * date 07.02.2013 05:20:11
   *
   * @return the upper left position for the columns of the block.
   */
  public int getOffSetCol( );
  
} // BlockInterface
