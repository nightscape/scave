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
 * This file JUnitTests.java is part of JWave.
 *
 * @author Christian Scheiblich
 * date 23.02.2010 05:42:23
 * contact graetz@mailfish.de
 */
package math.transform.jwave;

import static org.junit.Assert.assertEquals;

import math.transform.jwave.Transform;
import math.transform.jwave.handlers.FastWaveletTransform;
import math.transform.jwave.handlers.wavelets.Coif06;
import math.transform.jwave.handlers.wavelets.Daub02;
import math.transform.jwave.handlers.wavelets.Haar02;
import math.transform.jwave.handlers.wavelets.Wavelet;
import math.transform.jwave.types.Complex;

import org.junit.Test;


/**
 * Tests for the class math.transform.jwave.Transform.
 * 
 * @date 10.02.2010 09:43:08
 * @author Christian Scheiblich
 */
public class JUnitTests {

  public void assertArray( Complex[ ] expected, Complex[ ] actual, double delta ) {

    int expectedLength = expected.length;
    int actualLength = actual.length;

    assertEquals( expectedLength, actualLength );

    for( int c = 0; c < expectedLength; c++ ) {

      double expectedReal = expected[ c ].getReal( );
      double expectedImag = expected[ c ].getImag( );

      double actualReal = actual[ c ].getReal( );
      double actualImag = actual[ c ].getImag( );

      assertEquals( expectedReal, actualReal, delta );
      assertEquals( expectedImag, actualImag, delta );

    } // c    

  } // assertArray

  /**
   * Test method to check the rounding error of several forward and reverse
   * transforms.
   * 
   * @date 10.02.2010 10:28:00
   * @author Christian Scheiblich
   */
  @Test
  public void testRoundingHaar02FWT( ) {

    //    Performing: 1000000000 forward and reverse transforms ...
    //    0%-------------------------------------50%----------------------------------100%
    //    oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
    //
    //    Input ...
    //    time domain:    1.0 1.0 
    //
    //    Result ...
    //    time domain:    0.9999998429907541 0.9999998429907541 
    //
    //    Absolute error
    //    time domain:    1.5700924593797794E-7 1.5700924593797794E-7 
    //
    //    Relative error [%] ...
    //    time domain:    1.5700924593797794E-5 1.5700924593797794E-5 

    System.out.println( "" );
    System.out.println( "testRoundingHaar02FWT" );

    double delta = 1.e-8;

    double[ ] arrTime = { 1., 1. };

    testFastWaveletTransformRounding( arrTime, new Haar02( ), delta );

  } // testRounding

  /**
   * Test method to check the rounding error of several forward and reverse
   * transforms.
   * 
   * @date 10.02.2010 10:28:00
   * @author Christian Scheiblich
   */
  @Test
  public void testRoundingDaub04FWT( ) {

    //    Performing: 10000000 forward and reverse transforms ...
    //    0%-------------------------------------50%----------------------------------100%
    //    oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
    //
    //    Input ...
    //    time domain:    1.0 1.0 1.0 1.0 
    //
    //    Result ...
    //    time domain:    0.9999999999999553 0.9999999999999547 0.9999999999999553 0.9999999999999547 
    //
    //    Absolute error
    //    time domain:    4.474198789239381E-14 4.529709940470639E-14 4.474198789239381E-14 4.529709940470639E-14 
    //
    //    Relative error [%] ...
    //    time domain:    4.474198789239381E-12 4.529709940470639E-12 4.474198789239381E-12 4.529709940470639E-12 

    System.out.println( "" );
    System.out.println( "testRoundingDaub04FWT" );

    double delta = 1.e-8;

    double[ ] arrTime = { 1., 1., 1., 1. };

    testFastWaveletTransformRounding( arrTime, new Daub02( ), delta );

  } // testRounding

  /**
   * Test method to check the rounding error of several forward and reverse
   * transforms.
   * 
   * @date 10.02.2010 10:28:00
   * @author Christian Scheiblich
   */
  @Test
  public void testRoundingCoif06FWT( ) {

    //    Performing: 10000000 forward and reverse transforms ...
    //
    //    Input ...
    //    time domain:    1.0 1.0 1.0 1.0 1.0 1.0 
    //
    //    Result ...
    //    time domain:    1.000000000000003 1.0000000000000024 1.000000000000005 1.0000000000000024 1.0000000000000033 1.0000000000000022 
    //
    //    Absolute error
    //    time domain:    3.1086244689504383E-15 2.4424906541753444E-15 5.10702591327572E-15 2.4424906541753444E-15 3.3306690738754696E-15 2.220446049250313E-15 
    //
    //    Relative error [%] ...
    //    time domain:    3.1086244689504383E-13 2.4424906541753444E-13 5.10702591327572E-13 2.4424906541753444E-13 3.3306690738754696E-13 2.220446049250313E-13  

    System.out.println( "" );
    System.out.println( "testRoundingCoif06FWT" );

    double delta = 1.e-8;

    double[ ] arrTime = { 1., 1., 1., 1., 1., 1. };

    testFastWaveletTransformRounding( arrTime, new Coif06( ), delta );

  } // testRounding

  /**
   * Test method to check the rounding error of several forward and reverse
   * transforms.
   * 
   * @date 10.02.2010 10:28:00
   * @author Christian Scheiblich
   */
  public void testFastWaveletTransformRounding( double[ ] arr, Wavelet wavelet,
      double delta ) {

    long noOfSteps = 10000000;

    noOfSteps = 1000;

    double[ ] arrTime = arr;

    showTime( arrTime );

    double[ ] arrTimeRound = new double[ arrTime.length ];
    for( int c = 0; c < arrTime.length; c++ )
      arrTimeRound[ c ] = arrTime[ c ];

    Transform t = new Transform( new FastWaveletTransform( wavelet ) );

    System.out.println( "" );
    System.out.println( "" );
    System.out.print( "Performing: " + noOfSteps
        + " forward and reverse transforms ..." );
    // Bar bar = new Bar( new BarHandlerOs( noOfSteps ) );
    for( long s = 0; s < noOfSteps; s++ ) {
      arrTimeRound = t.reverse( t.forward( arrTimeRound ) );
      // bar.trigger( );
    } // s
    System.out.println( "" );
    System.out.println( "" );

    assertArray( arrTime, arrTimeRound, delta );

    System.out.println( "Input ..." );
    showTime( arrTime );
    System.out.println( "" );

    System.out.println( "Result ..." );
    showTime( arrTimeRound );
    System.out.println( "" );

    double[ ] arrTimeErrorAbs = new double[ arrTimeRound.length ];
    for( int c = 0; c < arrTimeRound.length; c++ )
      arrTimeErrorAbs[ c ] = Math.abs( arrTimeRound[ c ] - arrTime[ c ] );

    System.out.println( "Absolute error" );
    showTime( arrTimeErrorAbs );
    System.out.println( "" );

    double[ ] arrTimeErrorRel = new double[ arrTimeRound.length ];
    for( int c = 0; c < arrTimeRound.length; c++ )
      arrTimeErrorRel[ c ] = Math.abs( ( arrTimeRound[ c ] - arrTime[ c ] )
          * 100. / arrTime[ c ] );

    System.out.println( "Relative error [%] ..." );
    showTime( arrTimeErrorRel );
    System.out.println( "" );

  } // testRounding

  protected void assertArray( double[ ] expected, double[ ] actual, double delta ) {
    for( int i = 0; i < expected.length; i++ )
      assertEquals( expected[ i ], actual[ i ], delta );
  } // assertMatrix

  protected void assertMatrix( double[ ][ ] expected, double[ ][ ] actual,
      double delta ) {
    for( int i = 0; i < expected.length; i++ )
      for( int j = 0; j < expected[ i ].length; j++ )
        assertEquals( expected[ i ][ j ], actual[ i ][ j ], delta );
  } // assertMatrix

  protected void assertSpace( double[ ][ ][ ] expected, double[ ][ ][ ] actual,
      double delta ) {
    for( int i = 0; i < expected.length; i++ )
      for( int j = 0; j < expected[ i ].length; j++ )
        for( int k = 0; k < expected[ i ][ j ].length; k++ )
          assertEquals( expected[ i ][ j ][ k ], actual[ i ][ j ][ k ], delta );
  } // assertSpace

  protected void showTime( double[ ] arrTime ) {
    System.out.print( "time domain: " + "\t" + "\t" );
    for( int c = 0; c < arrTime.length; c++ )
      System.out.print( arrTime[ c ] + " " );
    System.out.println( "" );
  } // showTime

  protected void showFreq( double[ ] arrFreq ) {
    System.out.print( "frequency domain: " + "\t" );
    for( int c = 0; c < arrFreq.length; c++ )
      System.out.print( arrFreq[ c ] + " " );
    System.out.println( "" );
  } // showHilb

  protected void showHilb( double[ ] arrHilb ) {
    System.out.print( "Hilbert domain: " + "\t" );
    for( int c = 0; c < arrHilb.length; c++ )
      System.out.print( arrHilb[ c ] + " " );
    System.out.println( "" );
  } // showHilb

  protected void showTime( Complex[ ] arrTime ) {
    System.out.print( "time domain: " + "\t" + "\t" );
    for( int c = 0; c < arrTime.length; c++ )
      System.out.print( arrTime[ c ].toString( ) + " " );
    System.out.println( "" );
  } // showTime

  protected void showFreq( Complex[ ] arrFreq ) {
    System.out.print( "frequency domain: " + "\t" );
    for( int c = 0; c < arrFreq.length; c++ )
      System.out.print( arrFreq[ c ].toString( ) + " " );
    System.out.println( "" );
  } // showHilb  

  protected void showTime( double[ ][ ] matrixTime ) {
    System.out.println( "time domain: " + "\t" );
    for( int i = 0; i < matrixTime.length; i++ ) {
      for( int j = 0; j < matrixTime[ i ].length; j++ )
        System.out.print( matrixTime[ i ][ j ] + " " );
      System.out.println( "" );
    }
    System.out.println( "" );
  } // showTime 

  protected void showFreq( double[ ][ ] matrixFreq ) {
    System.out.println( "frequency domain: " + "\t" );
    for( int i = 0; i < matrixFreq.length; i++ ) {
      for( int j = 0; j < matrixFreq[ i ].length; j++ )
        System.out.print( matrixFreq[ i ][ j ] + " " );
      System.out.println( "" );
    }
    System.out.println( "" );
  } // showFreq

  protected void showHilb( double[ ][ ] matrixHilb ) {
    System.out.println( "Hilbert domain: " + "\t" );
    for( int i = 0; i < matrixHilb.length; i++ ) {
      for( int j = 0; j < matrixHilb[ i ].length; j++ )
        System.out.print( matrixHilb[ i ][ j ] + " " );
      System.out.println( "" );
    }
    System.out.println( "" );
  } // showHilb

  protected void showTime( double[ ][ ][ ] spaceTime ) {
    System.out.println( "time domain: " + "\t" );
    for( int i = 0; i < spaceTime.length; i++ ) {
      for( int j = 0; j < spaceTime[ i ].length; j++ ) {
        for( int k = 0; k < spaceTime[ i ][ j ].length; k++ )
          System.out.print( spaceTime[ i ][ j ][ k ] + " " );
        System.out.println( "" );
      }
      System.out.println( "" );
    }
    System.out.println( "" );
  } // showTime   

  protected void showFreq( double[ ][ ][ ] spaceTime ) {
    System.out.println( "frequency domain: " + "\t" );
    for( int i = 0; i < spaceTime.length; i++ ) {
      for( int j = 0; j < spaceTime[ i ].length; j++ ) {
        for( int k = 0; k < spaceTime[ i ][ j ].length; k++ )
          System.out.print( spaceTime[ i ][ j ][ k ] + " " );
        System.out.println( "" );
      }
      System.out.println( "" );
    }
    System.out.println( "" );
  } // showFreq   

  protected void showHilb( double[ ][ ][ ] spaceTime ) {
    System.out.println( "Hilbert domain: " + "\t" );
    for( int i = 0; i < spaceTime.length; i++ ) {
      for( int j = 0; j < spaceTime[ i ].length; j++ ) {
        for( int k = 0; k < spaceTime[ i ][ j ].length; k++ )
          System.out.print( spaceTime[ i ][ j ][ k ] + " " );
        System.out.println( "" );
      }
      System.out.println( "" );
    }
    System.out.println( "" );
  } // showHilb   

} // class
