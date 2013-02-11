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
 * This file BlockIndex.java is part of JWave.
 *
 * @author Christian Scheiblich
 * date 12.06.2011 23:45:37
 * contact graetz@mailfish.de
 */
package math.transform.jwave.superblocks.types;

import java.util.ArrayList;
import math.transform.jwave.superblocks.exc.BlockError;
import math.transform.jwave.superblocks.exc.BlockException;
import math.transform.jwave.superblocks.exc.BlockFailure;

/**
 * A block that stores given data sparse to reduce memory costs.
 * 
 * @date 12.06.2011 23:45:37
 * @author Christian Scheiblich
 */
public class BlockIndex extends Block {
  
  /**
   * Array for storing the row indices of values.
   */
  ArrayList< Integer > _arrI;
  
  /**
   * Array for storing the column indices of values.
   */
  ArrayList< Integer > _arrJ;
  
  /**
   * Array for storing values.
   */
  ArrayList< Double > _arrVal;
  
  /**
   * Constructor taking position and dimension.
   * 
   * @date 12.06.2011 23:45:37
   * @author Christian Scheiblich
   * @see math.transform.jwave.superblocks.types.Block#Block(int, int, int, int)
   */
  protected BlockIndex( int offSetRow, int offSetCol, int noOfRows, int noOfCols ) throws BlockException {
    super( offSetRow, offSetCol, noOfRows, noOfCols );
  }
  
  /**
   * Returns either 0 if there is no value stored for the pair (i,j) or the
   * value stored for the pair (i,j).
   * 
   * @date 12.06.2011 23:45:37
   * @author Christian Scheiblich
   * @see math.transform.jwave.superblocks.types.Block#get(int, int)
   */
  @Override
  public double get( int i, int j ) throws BlockException {
    
    if( !isMemAllocated( ) )
      throw new BlockFailure( "BlockIndex#get -- memory is not allocted" );
    
    boolean isOccupied = false;
    try {
      isOccupied = isOccupied( i, j );
    } catch( BlockException blockException ) {
      String exceptionMsg = blockException.getMessage( );
      throw new BlockFailure( "BlockIndex#get -- " + exceptionMsg );
    }
    
    double val = 0.;
    
    if( isOccupied ) {
      
      int pos = getOccupiedInternalArrayIndices( i, j );
      
      val = _arrVal.get( pos );
      
    }
    
    return val;
  }
  
  /**
   * Returns a complete matrix filled by zeros and the entries stored at pairs
   * (i,j).
   * 
   * @date 12.06.2011 23:45:37
   * @author Christian Scheiblich
   * @see math.transform.jwave.superblocks.types.Block#get()
   */
  @Override
  public double[ ][ ] get( ) throws BlockException {
    
    double[ ][ ] matrix = new double[ _noOfRows ][ _noOfCols ];
    
    int noOf = _arrVal.size( );
    
    for( int p = 0; p < noOf; p++ )
      matrix[ _arrI.get( p ) ][ _arrJ.get( p ) ] = _arrVal.get( p );
    
    return matrix;
    
  }
  
  /**
   * Add an entry to the array lists by extending those.
   * 
   * @date 12.06.2011 23:45:37
   * @author Christian Scheiblich
   * @see math.transform.jwave.superblocks.types.Block#set(int, int, double)
   */
  @Override
  public void set( int i, int j, double val ) throws BlockException {
    
    if( !isMemAllocated( ) )
      throw new BlockFailure( "BlockIndex#set -- memory is not allocted" );
    
    boolean isOccupied = false;
    try {
      isOccupied = isOccupied( i, j );
    } catch( BlockException blockException ) {
      String exceptionMsg = blockException.getMessage( );
      throw new BlockFailure( "BlockIndex#set -- " + exceptionMsg );
    }
    
    if( !isOccupied ) {
      
      _arrI.add( i );
      _arrJ.add( j );
      _arrVal.add( val );
      
    } else {
      
      int pos = getOccupiedInternalArrayIndices( i, j );
      _arrI.set( pos, i );
      _arrJ.set( pos, j );
      _arrVal.set( pos, val );
      
    } // if 
    
  }
  
  /**
   * Allocated memory for the index block as extendible array lists.
   * 
   * @date 12.06.2011 23:45:37
   * @author Christian Scheiblich
   * @see math.transform.jwave.superblocks.types.Block#allocateMemory()
   */
  @Override
  public void allocateMemory( ) throws BlockException {
    
    _arrI = new ArrayList< Integer >( );
    _arrJ = new ArrayList< Integer >( );
    _arrVal = new ArrayList< Double >( );
    
    _isMemAllocated = true;
  }
  
  /**
   * Erase the allocated memory by setting null pointers.
   * 
   * @date 12.06.2011 23:45:37
   * @author Christian Scheiblich
   * @see math.transform.jwave.superblocks.types.Block#eraseMemory()
   */
  @Override
  public void eraseMemory( ) throws BlockException {
    
    _arrI = null;
    _arrJ = null;
    _arrVal = null;
    
    _isMemAllocated = false;
    
  }
  
  /**
   * Checks if a given pair is already stored in the Block.
   * 
   * @date 13.06.2011 14:44:54
   * @author Christian Scheiblich
   * @param i
   *          local index for rows
   * @param j
   *          local index for columns
   * @return false if pair (i,j) is not stored yet other wise if pair (i,j) is
   *         stored true
   * @throws BlockException
   *           if indices are negative or out of bound or no memory is
   *           allocated.
   */
  private boolean isOccupied( int i, int j ) throws BlockException {
    
    if( !isMemAllocated( ) )
      throw new BlockFailure( "BlockIndex#isOccupied -- memory is not allocted" );
    
    try {
      checkIndices( i, j ); // check for correct indices
    } catch( BlockException blockException ) {
      String exceptionMsg = blockException.getMessage( );
      throw new BlockFailure( "BlockIndex#isOccupied -- " + exceptionMsg );
    }
    
    boolean isOccupied = false;
    
    int noOfIndicesI = _arrI.size( );
    int noOfIndicesJ = _arrJ.size( );
    
    if( noOfIndicesI != noOfIndicesJ )
      throw new BlockError( "BlockIndex#isOccupied -- something wicked happend to internal sizes" );
    
    for( int p = 0; p < noOfIndicesI; p++ )
      if( i == _arrI.get( p ) && j == _arrJ.get( p ) )
        isOccupied = true;
    
    return isOccupied;
  }
  
  /**
   * Searches and returns the internal index for both array lists for a
   * requested pair of indices.
   * 
   * @date 13.06.2011 15:31:47
   * @author Christian Scheiblich
   * @param i
   *          local index for rows
   * @param j
   *          local index for columns
   * @return an integer displaying the internal index of both array lists
   * @throws BlockException
   *           if given pair (i,j) is negative or out of bound or non memory is
   *           allocated.
   */
  private int getOccupiedInternalArrayIndices( int i, int j ) throws BlockException {
    
    if( !isMemAllocated( ) )
      throw new BlockFailure( "BlockIndex#getOccupiedInternalArrayIndices -- memory is not allocted" );
    
    try {
      checkIndices( i, j ); // check for correct indices
    } catch( BlockException blockException ) {
      String exceptionMsg = blockException.getMessage( );
      throw new BlockFailure( "BlockIndex#getOccupiedIndexRow -- " + exceptionMsg );
    }
    
    int p = 0;
    
    boolean isFound = false;
    
    while( !isFound && p < _arrI.size( ) ) {
      if( i == _arrI.get( p ) ) {
        if( j == _arrJ.get( p ) )
          isFound = true;
      } // if
      p++;
    } // whiles
    
    if( isFound ) {
      
      if( p > 0 )
        p--;
      
    } else
      p = -1;
    
    return p;
    
  }
  
  /* (non-Javadoc)
   * @see math.transform.jwave.superblocks.types.Block#computeMemory()
   */
  @Override
  public long computeMemory( ) throws BlockException {
    
    return _arrI.size( ) * 4 + _arrJ.size( ) * 4 + _arrVal.size( ) * 8; // if full doubles the time BlockFull occupies
  }
  
} // class
