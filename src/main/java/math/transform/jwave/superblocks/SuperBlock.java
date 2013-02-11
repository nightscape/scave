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
 * This file SuperBlock.java is part of JWave.
 *
 * @author Christian Scheiblich
 * contact graetz@mailfish.de
 * date Feb 6, 2013 3:06:47 PM
 *
 */
package math.transform.jwave.superblocks;

import java.util.ArrayList;
import math.transform.jwave.superblocks.blocks.Block;

/**
 * @author Christian Scheiblich
 * date Feb 6, 2013 3:06:47 PM
 *
 */
public interface SuperBlock {
  
  /**
   * @author Christian Scheiblich
   * date Feb 6, 2013 3:26:20 PM
   *
   * Delete all blocks that are stored in the SuperBlockArray object
   * to allow for a rapid memory break downs
   */
  public void eraseMemory( );
  
  /**
   * @author Christian Scheiblich
   * date Feb 6, 2013 3:30:51 PM
   *
   * @return total number of Blocks that are stored in the SuperBlockArray object
   */
  public long computeMemory( );
  
  /**
   * @author Christian Scheiblich
   * date Feb 6, 2013 3:31:35 PM
   *
   * Add a Block to the SuperBlockArray bz adding it to the internal type of storage.
   * Attention there is no control yet if two Blocks are covering the same area.
   *
   * @param block a valid object of type Block
   */
  public void addBlock( Block block );
  
  /**
   * @author Christian Scheiblich
   * date Feb 6, 2013 3:33:13 PM
   *
   * @param no the valid unique number of the Block starting bz zero up to noOfBlock-1
   * @return the request Block object
   */
  public Block getBlock( int no );
  
  /**
   * @author Christian Scheiblich
   * date Feb 6, 2013 3:34:43 PM
   *
   * @return the number of Block objects that are stored currently in the SuperBlockArray object.
   */
  public long getNoBlocks( );
  
  /**
   * @author Christian Scheiblich
   * date Feb 6, 2013 3:36:05 PM
   *
   * @return All Block objects in an ArrayList object, sorted to their number
   */
  public ArrayList< Block > getArrOfBlocks( );
  
  //  TODO Code some methods that allow for getting an entry by number of rows and columns
  
}
