/**
 * JWave - Java implementation of wavelet transform algorithms
 *
 * Copyright 2010-2011 Christian Scheiblich
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
 * This file BlockFull.java is part of JWave.
 *
 * @author tucker
 * date 11.06.2011 21:38:51
 * contact source@linux23.de
 */
package math.transform.jwave.blocks;

import math.transform.jwave.blocks.exc.BlockException;
import math.transform.jwave.blocks.exc.BlockFailure;

/**
 * Class for generating full blocks that keep information about position and
 * size and allocates memory as double array of an array.
 * 
 * @date 11.06.2011 21:38:51
 * @author Christian Scheiblich
 */
public class BlockFull extends Block {

  /**
   * the internal matrix for keeping stored values
   */
  private double[ ][ ] _matrix;

  /**
   * Constructor for a full block -- use BlockBuilder class for creating.
   * 
   * @date 11.06.2011 21:38:51
   * @author Christian Scheiblich
   * @see math.transform.jwave.blocks.Block#Block(int, int, int , int)
   */
  protected BlockFull( int offSetRow, int offSetCol, int noOfRows, int noOfCols )
      throws BlockException {
    // TODO tucker should implement this constructor
    super( offSetRow, offSetCol, noOfRows, noOfCols );
  }

  /**
   * Returns a requested entry if available.
   * 
   * @date 11.06.2011 21:38:51
   * @author Christian Scheiblich
   * @see math.transform.jwave.blocks.Block#get(int, int)
   */
  @Override
  public double get( int i, int j ) throws BlockException {

    if( !_isMemAllocated )
      throw new BlockFailure( "BlockFull#get -- no memory allocated" );

    try {
      checkIndices( i, j ); // check for correct indices
    } catch( BlockException blockException ) {
      String exceptionMsg = blockException.getMessage( );
      throw new BlockFailure( "BlockFull#get -- " + exceptionMsg );
    }

    return _matrix[ i ][ j ];
  }

  /**
   * Returns all entries as an array of an array; matrix style.
   * 
   * @date 11.06.2011 22:52:34
   * @author tucker
   * @see math.transform.jwave.blocks.Block#get()
   */
  @Override
  public double[ ][ ] get( ) throws BlockException {

    if( !_isMemAllocated )
      throw new BlockFailure( "BlockFull#get -- no memory allocated" );

    double[ ][ ] matrix = new double[ _noOfRows ][ _noOfCols ];

    for( int i = 0; i < _noOfRows; i++ )
      for( int j = 0; j < _noOfCols; j++ )
        matrix[ i ][ j ] = _matrix[ i ][ j ];

    return matrix;
  }

  /**
   * Stores an entry if available.
   * 
   * @date 11.06.2011 21:38:51
   * @author Christian Scheiblich
   * @see math.transform.jwave.blocks.Block#set(int, int)
   */
  @Override
  public void set( int i, int j, double val ) throws BlockException {

    if( !_isMemAllocated )
      throw new BlockFailure( "BlockFull#set -- no memory allocated" );

    try {
      checkIndices( i, j ); // check for correct indices
    } catch( BlockException blockException ) {
      String exceptionMsg = blockException.getMessage( );
      throw new BlockFailure( "BlockFull#set -- " + exceptionMsg );
    }

    _matrix[ i ][ j ] = val;
  }

  /**
   * Allocates memory as an array of an array -- matrix.
   * 
   * @date 11.06.2011 21:38:51
   * @author Christian Scheiblich
   * @see math.transform.jwave.blocks.Block#allocateMemory()
   */
  @Override
  public void allocateMemory( ) throws BlockException {
    _matrix = new double[ _noOfRows ][ _noOfCols ];
    _isMemAllocated = true;
  }

  /**
   * Erases the allocated memory by setting null pointer (and running java's
   * garbage collector).
   * 
   * @date 11.06.2011 21:38:51
   * @author Christian Scheiblich
   * @see math.transform.jwave.blocks.Block#eraseMemory()
   */
  @Override
  public void eraseMemory( ) throws BlockException {
    _matrix = null;
    _isMemAllocated = false;
  }

} // class
