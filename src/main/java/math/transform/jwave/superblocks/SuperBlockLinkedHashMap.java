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
 * This file SuperBlockLinkedHashMap.java is part of JWave.
 *
 * @author Christian Scheiblich
 * contact graetz@mailfish.de
 * date 08.02.2013 05:53:23
 *
 */
package math.transform.jwave.superblocks;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import math.transform.jwave.superblocks.blocks.Block;
import math.transform.jwave.superblocks.exc.BlockException;

/**
 * Class for storing Block objects that join together to a Matrix.
 * The class is using a linkedHashMap for storage.
 * 
 * @author Christian Scheiblich
 * date 08.02.2013 05:53:23
 *
 */
public class SuperBlockLinkedHashMap implements SuperBlock {
  
  /**
   * A linked hash map that remembers the sequence of input, which is
   * important to get the Block back as added.
   * 
   * @author Christian Scheiblich
   * date 08.02.2013 06:00:27
   *
   */
  protected LinkedHashMap< Integer, Block > _blocks;
  
  /**
   * Getting LinkedHashMap to memory.
   * 
   * @author Christian Scheiblich
   * date 08.02.2013 05:53:24
   *
   */
  public SuperBlockLinkedHashMap( ) {
    
    _blocks = new LinkedHashMap< Integer, Block >( );
    
  }
  
  /* (non-Javadoc)
   * @see math.transform.jwave.superblocks.SuperBlock#eraseMemory()
   */
  @Override
  public void eraseMemory( ) {
    
  }
  
  /* (non-Javadoc)
   * @see math.transform.jwave.superblocks.SuperBlock#computeMemory()
   */
  @Override
  public long computeMemory( ) {
    
    long memory = 0;
    
    try {
      
      int noBlocks = _blocks.size( );
      
      for( int i = 0; i < noBlocks; i++ ) {
        
        memory += _blocks.get( i ).computeMemory( );
        
      }
    } catch( BlockException e ) {
      e.printStackTrace( );
    }
    
    return memory;
  }
  
  /* (non-Javadoc)
   * @see math.transform.jwave.superblocks.SuperBlock#addBlock(math.transform.jwave.superblocks.blocks.Block)
   */
  @Override
  public void addBlock( Block block ) {
    
    int blockNo = block.getBlockNo( );
    
    _blocks.put( blockNo, block );
    
  }
  
  /* (non-Javadoc)
   * @see math.transform.jwave.superblocks.SuperBlock#getBlock(int)
   */
  @Override
  public Block getBlock( int no ) {
    
    Block block = _blocks.get( no );
    
    return block;
    
  }
  
  /* (non-Javadoc)
   * @see math.transform.jwave.superblocks.SuperBlock#getNoBlocks()
   */
  @Override
  public long getNoBlocks( ) {
    
    return _blocks.size( );
    
  }
  
  /* (non-Javadoc)
   * @see math.transform.jwave.superblocks.SuperBlock#getArrOfBlocks()
   */
  @Override
  public ArrayList< Block > getArrOfBlocks( ) {
    
    int noBlocks = _blocks.size( );
    
    ArrayList< Block > arrBlocks = new ArrayList< Block >( noBlocks );
    
    for( int i = 0; i < noBlocks; i++ ) {
      
      Block block = _blocks.get( i );
      
      arrBlocks.add( block );
      
    }
    
    return arrBlocks;
    
  }
  
}
