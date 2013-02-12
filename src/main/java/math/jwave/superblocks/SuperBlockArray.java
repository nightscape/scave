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
 * This file SuperBlockArray.java is part of JWave.
 *
 * @author Christian Scheiblich
 * contact graetz@mailfish.de
 * date 07.02.2013 05:44:13
 *
 */
package math.jwave.superblocks;

import java.util.ArrayList;
import math.jwave.superblocks.blocks.Block;
import math.jwave.superblocks.exc.SuperBlockException;

/**
 * Class for storing Block objects that join together to a Matrix.
 * The class is using an ArrayList for storage.
 * 
 * @author Christian Scheiblich
 * date 07.02.2013 05:44:13
 *
 */
public class SuperBlockArray implements SuperBlock {

  /**
   * ArrayList of Block objects as simplest way for storage.
   * 
   * @author Christian Scheiblich
   * date 07.02.2013 06:58:58
   *
   */
  private ArrayList< Block > _blocks;
  
  
  /**
   * Creates the object SuperBlock
   * 
   * @author Christian Scheiblich
   * date 07.02.2013 07:00:06
   *
   * @param _blocks
   */
  public SuperBlockArray( ) {
    
    _blocks = new ArrayList< Block >( );
  
  }

  /* (non-Javadoc)
   * @see math.jwave.superblocks.SuperBlock#eraseMemory()
   */
  @Override
  public void eraseMemory( ) {
    
    try {
      
      long noBlocks = getNoBlocks( );
      
      ArrayList< Block > blocks = getArrOfBlocks( );
      
      for( long i = 0; i < noBlocks; i++ ) {
        
        Block block = blocks.get( (int)i );
        
        block.eraseMemory( );
        
      } // i
      
    } catch( SuperBlockException e ) {
      e.printStackTrace( );
    }
    
  }
  
  /* (non-Javadoc)
   * @see math.jwave.superblocks.SuperBlock#computeMemory()
   */
  @Override
  public long computeMemory( ) {
    
    long occupiedMemory = 0;
    
    try {
      
      long noBlocks = getNoBlocks( );
      
      ArrayList< Block > blocks = getArrOfBlocks( );
      
      for( long i = 0; i < noBlocks; i++ ) {
        
        Block block = blocks.get( (int)i );
        
        occupiedMemory += block.computeMemory( );
        
      } // i
      
    } catch( SuperBlockException e ) {
      e.printStackTrace( );
    }
    
    return occupiedMemory;
    
  }
  
  /* (non-Javadoc)
   * @see math.jwave.superblocks.SuperBlock#addBlock(math.jwave.superblocks.blocks.Block)
   */
  @Override
  public void addBlock( Block block ) {
 
    _blocks.add( block );
    
  }
  
  /* (non-Javadoc)
   * @see math.jwave.superblocks.SuperBlock#getBlock(int)
   */
  @Override
  public Block getBlock( int no ) {

    return _blocks.get( no );
    
  }
  
  /* (non-Javadoc)
   * @see math.jwave.superblocks.SuperBlock#getNoBlocks()
   */
  @Override
  public long getNoBlocks( ) {
    return _blocks.size( );
  }
  
  /* (non-Javadoc)
   * @see math.jwave.superblocks.SuperBlock#getArrOfBlocks()
   */
  @Override
  public ArrayList< Block > getArrOfBlocks( ) {
  
    return new ArrayList< Block >( _blocks );
  
  }
  
}
