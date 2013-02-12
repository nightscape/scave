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
 * This file SuperBlockController.java is part of JWave.
 *
 * @author Christian Scheiblich
 * contact graetz@mailfish.de
 * date 08.02.2013 06:54:39
 *
 */
package math.transform.jwave.superblocks;

import math.transform.jwave.superblocks.blocks.BlockController;
import math.transform.jwave.superblocks.blocks.BlockType;
import math.transform.jwave.superblocks.exc.SuperBlockError;
import math.transform.jwave.superblocks.exc.SuperBlockException;

/**
 * Class for building a SuperBlock object as a representation of a matrix.
 * This can be done by an empty SuperBlock, by a SuperBlock keeping already
 * DummyBlock objects, or by a SuperBlock keeping already memory occupying
 * BlockFull or BlockIndex objects. Building philosophy is given by a set
 * size of each block. However, a rest of number of unknowns is handled by
 * the Ancient Egyptian Multiplication, setting up squeezed and stretched
 * Block objects.
 * 
 * @author Christian Scheiblich
 * date 08.02.2013 06:54:39
 *
 */
public class SuperBlockController {
  
  /**
   * @author Christian Scheiblich
   * date 08.02.2013 06:54:39
   *
   */
  public SuperBlockController( ) {
  }
  
  public static SuperBlock createSuperBlock( BuildStrategy buildStrategy, SuperBlockType superBlockType, BlockType blockType ) throws SuperBlockException {
    
    if( buildStrategy == null )
      throw new SuperBlockError( "given buildStrategy object is null" );
    
    int[ ] rowDecomp = buildStrategy.generateRowDecomposition( );
    
    int[ ] colDecomp = buildStrategy.generateColDecomposition( );
    
    SuperBlock superBlock = createSuperBlock( superBlockType );
    
    int sizeRowDecomp = rowDecomp.length;
    
    int sizeColDecomp = colDecomp.length;
    
    int offSetRow = 0;
    
    int offSetCol = 0;
    
    int noOfRows = 0;
    
    int noOfCols = 0;
    
    for( int i = 0; i < sizeRowDecomp; i++ ) {
      
      noOfRows = rowDecomp[ i ];
      
      for( int j = 0; j < sizeColDecomp; j++ ) {
        
        noOfCols = colDecomp[ j ];
        
        System.out.println( offSetRow + " " + offSetCol + " " + noOfRows + " " + noOfCols );
        
        superBlock.addBlock( BlockController.create( blockType, offSetRow, offSetCol, noOfRows, noOfCols ) );
        
        offSetCol += colDecomp[ j ];
        
      } // j
      
      offSetCol = 0; // reset cols
      
      offSetRow += rowDecomp[ i ];
      
    } // i
    
    return superBlock;
    
  }
  
  /**
   * The methods only creates an empty object of type SuperBlock.
   * 
   * @author Christian Scheiblich
   * date Feb 11, 2013 3:57:25 PM
   * 
   * @param superBlockType
   * @return
   * @throws SuperBlockException
   */
  private static SuperBlock createSuperBlock( SuperBlockType superBlockType ) throws SuperBlockException {
    
    SuperBlock superBlock = null;
    
    switch( superBlockType ) {
      case Array:
        
        superBlock = new SuperBlockArray( );
        
        break;
      
      case LinkedHashMap:
        
        superBlock = new SuperBlockLinkedHashMap( );
        
        break;
      
      default:
        
        throw new SuperBlockError( "given type of SuperBlock object is unkown" );
        
    } // switch
    
    return superBlock;
    
  }
  
}
