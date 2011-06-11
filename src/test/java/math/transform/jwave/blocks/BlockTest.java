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
 * This file BlockTest.java is part of JWave.
 *
 * @author tucker
 * date 11.06.2011 22:02:19
 * contact source@linux23.de
 */
package math.transform.jwave.blocks;

import static org.junit.Assert.*;

import math.transform.jwave.blocks.exc.BlockException;

import org.junit.Test;

/**
 * For testing block objects
 * 
 * @date 11.06.2011 22:02:19
 * @author Christian Scheiblich
 */
public class BlockTest {

  /**
   * Test method for {@link math.transform.jwave.blocks.Block#getRow(int)}.
   * 
   * @throws BlockException
   */
  @Test
  public void testGetRow( ) throws BlockException {

    int noOfRows = 1024;
    int noOfCols = 1024;

    Block block = BlockBuilder
        .create( BlockType.Full, 0, 0, noOfRows, noOfCols );

    block.allocateMemory( );

    for( int i = 0; i < block.getNoOfRows( ); i++ )
      for( int j = 0; j < block.getNoOfCols( ); j++ ) {
        double val = (double)( i + j + 1 );
        block.set( i, j, val );
      }

    for( int i = 0; i < block.getNoOfRows( ); i++ ) {
      double[ ] rowVal = block.getRow( i );
      for( int j = 0; j < block.getNoOfCols( ); j++ )
        assertEquals( (double)( i + j + 1 ), rowVal[ j ], 0. );
    }

    block.eraseMemory( );

  }

  /**
   * Test method for {@link math.transform.jwave.blocks.Block#getCol(int)}.
   * 
   * @throws BlockException
   */
  @Test
  public void testGetCol( ) throws BlockException {

    int noOfRows = 1024;
    int noOfCols = 1024;

    Block block = BlockBuilder
        .create( BlockType.Full, 0, 0, noOfRows, noOfCols );

    block.allocateMemory( );

    for( int i = 0; i < block.getNoOfRows( ); i++ )
      for( int j = 0; j < block.getNoOfCols( ); j++ ) {
        double val = (double)( i + j + 1 );
        block.set( i, j, val );
      }

    for( int j = 0; j < block.getNoOfCols( ); j++ ) {
      double[ ] colVal = block.getRow( j );
      for( int i = 0; i < block.getNoOfRows( ); i++ )
        assertEquals( (double)( i + j + 1 ), colVal[ i ], 0. );
    }

    block.eraseMemory( );

  }

  /**
   * Test method for {@link math.transform.jwave.blocks.Block#get(int, int)}.
   * 
   * @throws BlockException
   */
  @Test
  public void testGet( ) throws BlockException {

    int noOfRows = 1024;
    int noOfCols = 1024;

    Block block = BlockBuilder
        .create( BlockType.Full, 0, 0, noOfRows, noOfCols );

    block.allocateMemory( );

    for( int i = 0; i < block.getNoOfRows( ); i++ )
      for( int j = 0; j < block.getNoOfCols( ); j++ ) {
        double val = (double)( i + j + 1 );
        block.set( i, j, val );
      }

    for( int i = 0; i < block.getNoOfRows( ); i++ )
      for( int j = 0; j < block.getNoOfCols( ); j++ ) {
        double val = block.get( i, j );
        assertEquals( (double)( i + j + 1 ), val, 0. );
      }

    double[ ][ ] matrix = block.get( );

    for( int i = 0; i < block.getNoOfRows( ); i++ )
      for( int j = 0; j < block.getNoOfCols( ); j++ ) {
        double val = matrix[ i ][ j ];
        assertEquals( (double)( i + j + 1 ), val, 0. );
      }

    block.eraseMemory( );

  }

  /**
   * Test method for
   * {@link math.transform.jwave.blocks.Block#set(int, int, double)}.
   * 
   * @throws BlockException
   */
  @Test
  public void testSet( ) throws BlockException {

    int noOfRows = 1024;
    int noOfCols = 1024;

    Block block = BlockBuilder
        .create( BlockType.Full, 0, 0, noOfRows, noOfCols );

    block.allocateMemory( );

    for( int i = 0; i < block.getNoOfRows( ); i++ )
      for( int j = 0; j < block.getNoOfCols( ); j++ ) {
        double val = (double)( i + j + 1 );
        block.set( i, j, val );
      }

    for( int i = 0; i < block.getNoOfRows( ); i++ )
      for( int j = 0; j < block.getNoOfCols( ); j++ ) {
        double val = block.get( i, j );
        assertEquals( (double)( i + j + 1 ), val, 0. );
      }

    block.eraseMemory( );

  }

} // class
