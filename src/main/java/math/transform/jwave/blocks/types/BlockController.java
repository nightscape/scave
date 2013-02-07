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
 * This file BlockBuilder.java is part of JWave.
 *
 * @author tucker
 * date 11.06.2011 21:25:17
 * contact graetz@mailfish.de
 */
package math.transform.jwave.blocks.types;

import math.transform.jwave.blocks.exc.BlockError;
import math.transform.jwave.blocks.exc.BlockException;

/**
 * Creates Block objects
 * 
 * @date 11.06.2011 21:25:17
 * @author Christian Scheiblich
 */
public class BlockController {

  public static Block create( BlockType blockType, int offSetRow,
      int offSetCol, int noOfRows, int noOfCols ) throws BlockException {

    Block block = null;

    switch( blockType ) {

      case Dummy :

        block = new BlockDummy( offSetRow, offSetCol, noOfRows, noOfCols );

        break;

      case Full :

        block = new BlockFull( offSetRow, offSetCol, noOfRows, noOfCols );

        break;

      case Index :

        block = new BlockIndex( offSetRow, offSetCol, noOfRows, noOfCols );

        break;

      default :

        throw new BlockError(
            "BlockBuilder#create -- given BlockType is not defined" );

    } // switch

    return block;

  }

  /**
   * Convert a block to a different type of block as a copy.
   * 
   * @date 12.06.2011 23:33:50
   * @author Christian Scheiblich
   * @param blockType
   *          the type of block to convert to
   * @param block
   *          the pattern block keeping memory or not
   * @return a new block object as a copy for the the requested type
   * @throws BlockException
   *           if off sets or sizes are negative or out of bound
   */
  public static Block convert( BlockType blockType, Block block )
      throws BlockException {

    Block newBlock = null;

    newBlock = create( blockType, block.getOffSetRow( ), block.getOffSetCol( ),
        block.getNoRows( ), block.getNoCols( ) );

    if( block.isMemAllocated( ) ) {

      newBlock.allocateMemory( );

      double[ ][ ] matrix = block.get( );

      for( int i = 0; i < block.getNoRows( ); i++ )
        for( int j = 0; j < block.getNoCols( ); j++ ) {

          double val = matrix[ i ][ j ];

          if( val != 0. )
            newBlock.set( i, j, val );
        } // for

    } // if

    return newBlock;

  }
} // class
