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
 * This file BlockDummy.java is part of JWave.
 *
 * @author tucker
 * date 11.06.2011 21:31:12
 * contact graetz@mailfish.de
 */
package math.transform.jwave.blocks;

import math.transform.jwave.blocks.exc.BlockException;
import math.transform.jwave.blocks.exc.BlockFailure;

/**
 * Class for generating dummy blocks that keep information about position and
 * size but never allocate memory.
 * 
 * @date 11.06.2011 21:31:12
 * @author Christian Scheiblich
 */
public class BlockDummy extends Block {

  /**
   * Constructor for a dummy block -- use BlockBuilder class for creating.
   * 
   * @date 11.06.2011 21:31:12
   * @author Christian Scheiblich
   * @see math.transform.jwave.blocks.Block#Block(int, int, int , int)
   */
  protected BlockDummy( int offSetRow, int offSetCol, int noOfRows, int noOfCols )
      throws BlockException {
    super( offSetRow, offSetCol, noOfRows, noOfCols );
  }

  /**
   * Method is not available in case of a dummy.
   * 
   * @date 11.06.2011 21:31:12
   * @author Christian Scheiblich
   * @see math.transform.jwave.blocks.Block#get(int, int)
   */
  @Override
  public double get( int i, int j ) throws BlockException {
    throw new BlockFailure( "BlockDummy#get -- method not available" );
  }

  /**
   * Method is not available in case of a dummy.
   * 
   * @date 11.06.2011 22:51:59
   * @author tucker
   * @see math.transform.jwave.blocks.Block#get()
   */
  @Override
  public double[ ][ ] get( ) throws BlockException {
    throw new BlockFailure( "BlockDummy#get -- method not available" );
  }

  /**
   * Method is not available in case of a dummy.
   * 
   * @date 11.06.2011 21:31:12
   * @author Christian Scheiblich
   * @see math.transform.jwave.blocks.Block#set(int, int)
   */
  @Override
  public void set( int i, int j, double val ) throws BlockException {
    throw new BlockFailure( "BlockDummy#set -- method not available" );
  }

  /**
   * Method is not available in case of a dummy.
   * 
   * @date 11.06.2011 21:31:12
   * @author Christian Scheiblich
   * @see math.transform.jwave.blocks.Block#allocateMemory()
   */
  @Override
  public void allocateMemory( ) throws BlockException {
    throw new BlockFailure( "BlockDummy#allocateMemory -- method not available" );
  }

  /**
   * Method is not available in case of a dummy.
   * 
   * @date 11.06.2011 21:31:12
   * @author Christian Scheiblich
   * @see math.transform.jwave.blocks.Block#eraseMemory()
   */
  @Override
  public void eraseMemory( ) throws BlockException {
    throw new BlockFailure( "BlockDummy#eraseMemory -- method not available" );
  }

} // class
