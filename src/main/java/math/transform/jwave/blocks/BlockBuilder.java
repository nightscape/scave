/**
 * JWave - Java implementation of wavelet transform algorithms
 *
 * Copyright 2010 Christian Scheiblich
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
 * contact source@linux23.de
 */
package math.transform.jwave.blocks;

import math.transform.jwave.blocks.exc.BlockError;
import math.transform.jwave.blocks.exc.BlockException;
import math.transform.jwave.blocks.exc.BlockFailure;

/**
 * Creates Block objects
 * 
 * @date 11.06.2011 21:25:17
 * @author tucker
 */
public class BlockBuilder {

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

      case Stripe :

        throw new BlockFailure(
            "BlockBuilder#create -- requested BlockType is not implemented yet" );

        // break;

      case Index :

        throw new BlockFailure(
            "BlockBuilder#create -- requested BlockType is not implemented yet" );

        // break;

      default :

        throw new BlockError(
            "BlockBuilder#create -- given BlockType is not defined" );

    } // switch

    return block;

  }
} // class
