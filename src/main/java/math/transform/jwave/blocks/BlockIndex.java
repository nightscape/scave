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
 * This file BlockIndex.java is part of JWave.
 *
 * @author Christian Scheiblich
 * date 12.06.2011 23:45:37
 * contact source@linux23.de
 */
package math.transform.jwave.blocks;

import java.util.ArrayList;

import math.transform.jwave.blocks.exc.BlockException;

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
  ArrayList< Integer > _arrVal;

  /**
   * Constructor taking position and dimension.
   * 
   * @date 12.06.2011 23:45:37
   * @author Christian Scheiblich
   * @see math.transform.jwave.blocks.Block#Block(int, int, int, int)
   */
  public BlockIndex( int offSetRow, int offSetCol, int noOfRows, int noOfCols )
      throws BlockException {
    super( offSetRow, offSetCol, noOfRows, noOfCols );
  }

  /**
   * TODO Christian Scheiblich explainMeShortly
   * 
   * @date 12.06.2011 23:45:37
   * @author Christian Scheiblich
   * @see math.transform.jwave.blocks.Block#get(int, int)
   */
  @Override
  public double get( int i, int j ) throws BlockException {
    // TODO Christian Scheiblich should implement this method
    return 0;
  }

  /**
   * TODO Christian Scheiblich explainMeShortly
   * 
   * @date 12.06.2011 23:45:37
   * @author Christian Scheiblich
   * @see math.transform.jwave.blocks.Block#get()
   */
  @Override
  public double[ ][ ] get( ) throws BlockException {
    // TODO Christian Scheiblich should implement this method
    return null;
  }

  /**
   * TODO Christian Scheiblich explainMeShortly
   * 
   * @date 12.06.2011 23:45:37
   * @author Christian Scheiblich
   * @see math.transform.jwave.blocks.Block#set(int, int, double)
   */
  @Override
  public void set( int i, int j, double val ) throws BlockException {
    // TODO Christian Scheiblich should implement this method
  }

  /**
   * TODO Christian Scheiblich explainMeShortly
   * 
   * @date 12.06.2011 23:45:37
   * @author Christian Scheiblich
   * @see math.transform.jwave.blocks.Block#allocateMemory()
   */
  @Override
  public void allocateMemory( ) throws BlockException {

    _arrI = new ArrayList< Integer >( );
    _arrJ = new ArrayList< Integer >( );
    _arrVal = new ArrayList< Integer >( );

    _isMemAllocated = true;
  }

  /**
   * Erase the allocated memory by setting null pointers.
   * 
   * @date 12.06.2011 23:45:37
   * @author Christian Scheiblich
   * @see math.transform.jwave.blocks.Block#eraseMemory()
   */
  @Override
  public void eraseMemory( ) throws BlockException {

    _arrI = null;
    _arrJ = null;
    _arrVal = null;
    
    _isMemAllocated = false;

  }

} // class
