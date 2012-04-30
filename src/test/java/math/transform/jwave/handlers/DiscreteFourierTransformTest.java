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
 * This file DiscreteFourierTransformTest.java is part of JWave.
 *
 * @author tucker
 * date 23.11.2010 19:05:07
 * contact cscheiblich@googlemail.com
 */
package math.transform.jwave.handlers;

import math.transform.jwave.JUnitTests;
import math.transform.jwave.Transform;
import math.transform.jwave.handlers.DiscreteFourierTransform;
import math.transform.jwave.types.Complex;

import org.junit.Test;


/**
 * Tests for the base methods of class DiscreteFourierTransform.
 * 
 * @date 23.11.2010 19:05:07
 * @author Christian Scheiblich
 */
public class DiscreteFourierTransformTest extends JUnitTests {

  /**
   * Test method for
   * {@link math.transform.jwave.handlers.DiscreteFourierTransform#forward(double[])}.
   */
  @Test
  public void testForwardDoubleArray( ) {

    System.out.println( "" );
    System.out.println( "testDiscreteFourierTransformForwardDoubleArray" );

    double delta = 1.e-12;

    double[ ] arrTime = { 1., 1., 1., 1., 1., 1., 1., 1. };

    showTime( arrTime );

    Transform t = new Transform( new DiscreteFourierTransform( ) );
    double[ ] arrFreq = t.forward( arrTime );

    showFreq( arrFreq );

    double[ ] expected = { 1., 1., 0., 0., 0., 0, 0., 0. };
    assertArray( expected, arrFreq, delta );

  } // testForwardDoubleArray

  /**
   * Test method for
   * {@link math.transform.jwave.handlers.DiscreteFourierTransform#reverse(double[])}.
   */
  @Test
  public void testReverseDoubleArray( ) {

    System.out.println( "" );
    System.out.println( "testDiscreteFourierTransformReverseDoubleArray" );

    double delta = 1e-12;

    double[ ] arrFreq = { 1., 1., 0., 0., 0., 0, 0., 0. };

    showHilb( arrFreq );

    Transform t = new Transform( new DiscreteFourierTransform( ) );
    double[ ] arrTime = t.reverse( arrFreq );

    showTime( arrTime );

    double[ ] expected = { 1., 1., 1., 1., 1., 1., 1., 1. };
    assertArray( expected, arrTime, delta );

  } // testReverseDoubleArray

  /**
   * Test method for
   * {@link math.transform.jwave.handlers.DiscreteFourierTransform#forward(math.transform.jwave.types.Complex[])}
   * .
   */
  @Test
  public void testForwardComplexArray( ) {

    System.out.println( "" );
    System.out.println( "testDiscreteFourierTransformForwardComplexArray" );

    double delta = 1.e-12;

    Complex[ ] arrTime = { new Complex( 1., 1. ), new Complex( 1., 1. ),
        new Complex( 1., 1. ), new Complex( 1., 1. ) };

    showTime( arrTime );

    Transform t = new Transform( new DiscreteFourierTransform( ) );
    Complex[ ] arrFreq = t.forward( arrTime );

    showFreq( arrFreq );

    Complex[ ] expected = { new Complex( 1., 1. ), new Complex( 0., 0. ),
        new Complex( 0., 0. ), new Complex( 0., 0. ) };

    assertArray( expected, arrFreq, delta );

  } // testForwardComplexArray

  /**
   * Test method for
   * {@link math.transform.jwave.handlers.DiscreteFourierTransform#reverse(math.transform.jwave.types.Complex[])}
   * .
   */
  @Test
  public void testReverseComplexArray( ) {
    System.out.println( "" );
    System.out.println( "testDiscreteFourierTransformReverseDoubleArray" );

    double delta = 1e-12;

    Complex[ ] arrFreq = { new Complex( 1., 1. ), new Complex( 0., 0. ),
        new Complex( 0., 0. ), new Complex( 0., 0. ) };

    showFreq( arrFreq );

    Transform t = new Transform( new DiscreteFourierTransform( ) );
    Complex[ ] arrTime = t.reverse( arrFreq );

    showTime( arrTime );

    Complex[ ] expected = { new Complex( 1., 1. ), new Complex( 1., 1. ),
        new Complex( 1., 1. ), new Complex( 1., 1. ) };

    assertArray( expected, arrTime, delta );

  } // testReverseComplexArray

}
