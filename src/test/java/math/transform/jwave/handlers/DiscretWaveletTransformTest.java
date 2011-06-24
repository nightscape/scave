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
 * This file FastWaveletTransformTest.java is part of JWave.
 *
 * @author Christian Scheiblich
 * date 23.11.2010 19:40:11
 * contact source@linux23.de
 */

package math.transform.jwave.handlers;

import org.junit.Test;

import math.transform.jwave.JUnitTests;
import math.transform.jwave.Transform;
import math.transform.jwave.handlers.wavelets.Haar02;


public class DiscretWaveletTransformTest extends JUnitTests{

  /**
   * Test method for {@link math.transform.jwave.Transform#forward(double[])}.
   */
  @Test
  public void testDiscreteWaveletTransformForwardHaar02Array( ) {

    System.out.println( "" );
    System.out.println( "testDiscreteWaveletTransformForwardHaar02Array" );

    double delta = 1.e-12;

    double[ ] arrTime = { 1., 1., 1., 1. };

    showTime( arrTime );

    Transform t = new Transform( new DiscreteWaveletTransform( new Haar02( ) ) );
    double[ ] arrHilb = t.forward( arrTime );

    showHilb( arrHilb );

    double[ ] expected = { 2., 0., 0., 0. }; // orthonormal Hilbert space
    assertArray( expected, arrHilb, delta );

  }
  
  /**
   * Test method for {@link math.transform.jwave.Transform#reverse(double[])}.
   */
  @Test
  public void testDiscreteWaveletTransformReverseHaar02Array( ) {

    System.out.println( "" );
    System.out.println( "testDiscreteWaveletTransformReverseHaar02Array" );

    double delta = 1e-12;

    double[ ] arrHilb = { 2., 0., 0., 0. }; // orthonormal Hilbert space

    showHilb( arrHilb );

    Transform t = new Transform( new DiscreteWaveletTransform( new Haar02( ) ) );
    double[ ] arrTime = t.reverse( arrHilb );

    showTime( arrTime );

    double[ ] expected = { 1., 1., 1., 1. };
    assertArray( expected, arrTime, delta );

  }
  
  /**
   * Test method for {@link math.transform.jwave.Transform#forward(double[][])}.
   */
  @Test
  public void testDiscretWaveletTransformForwardHaar02Matrix( ) {

    System.out.println( "" );
    System.out.println( "testDiscretWaveletTransformForwardHaar02Matrix" );

    double delta = 1.e-12;

    double[ ][ ] matrixTime = { { 1., 1., 1., 1. }, { 1., 1., 1., 1. },
        { 1., 1., 1., 1. }, { 1., 1., 1., 1. } };

    showTime( matrixTime );

    Transform t = new Transform( new DiscreteWaveletTransform( new Haar02( ) ) );
    double[ ][ ] matrixHilb = t.forward( matrixTime );

    showHilb( matrixHilb );

    double[ ][ ] expected = { { 4., 0., 0., 0. }, { 0., 0., 0., 0. },
        { 0., 0., 0., 0. }, { 0., 0., 0., 0. } };
    assertMatrix( expected, matrixHilb, delta );

  }

  /**
   * Test method for {@link math.transform.jwave.Transform#reverse(double[][])}.
   */
  @Test
  public void testDiscreteWaveletTransformReverseHaar02Matrix( ) {

    System.out.println( "" );
    System.out.println( "testDiscreteWaveletTransformReverseHaar02Matrix" );

    double delta = 1.e-12;

    double[ ][ ] matrixHilb = { { 4., 0., 0., 0. }, { 0., 0., 0., 0. },
        { 0., 0., 0., 0. }, { 0., 0., 0., 0. } };

    showHilb( matrixHilb );

    Transform t = new Transform( new DiscreteWaveletTransform( new Haar02( ) ) );
    double[ ][ ] matrixTime = t.reverse( matrixHilb );

    showTime( matrixTime );

    double[ ][ ] expected = { { 1., 1., 1., 1. }, { 1., 1., 1., 1. },
        { 1., 1., 1., 1. }, { 1., 1., 1., 1. } };
    assertMatrix( expected, matrixTime, delta );

  }
  
  /**
   * Test method for {@link math.transform.jwave.Transform#forward(double[][][])}.
   */
  @Test
  public void testDiscreteWaveletTransformForwardHaar02Space( ) {

    System.out.println( "" );
    System.out.println( "testDiscreteWaveletTransformForwardHaar02Space" );

    double delta = 1.e-12;

    double[ ][ ][ ] spaceTime = {
        { { 1., 1., 1., 1. }, { 1., 1., 1., 1. }, { 1., 1., 1., 1. },
            { 1., 1., 1., 1. } },
        { { 1., 1., 1., 1. }, { 1., 1., 1., 1. }, { 1., 1., 1., 1. },
            { 1., 1., 1., 1. } },
        { { 1., 1., 1., 1. }, { 1., 1., 1., 1. }, { 1., 1., 1., 1. },
            { 1., 1., 1., 1. } },
        { { 1., 1., 1., 1. }, { 1., 1., 1., 1. }, { 1., 1., 1., 1. },
            { 1., 1., 1., 1. } } };

    showTime( spaceTime );

    Transform t = new Transform( new DiscreteWaveletTransform( new Haar02( ) ) );
    double[ ][ ][ ] spaceHilb = t.forward( spaceTime );

    showHilb( spaceHilb );

    double[ ][ ][ ] expected = {
        { { 8., 0., 0., 0. }, { 0., 0., 0., 0. }, { 0., 0., 0., 0. },
            { 0., 0., 0., 0. } },
        { { 0., 0., 0., 0. }, { 0., 0., 0., 0. }, { 0., 0., 0., 0. },
            { 0., 0., 0., 0. } },
        { { 0., 0., 0., 0. }, { 0., 0., 0., 0. }, { 0., 0., 0., 0. },
            { 0., 0., 0., 0. } },
        { { 0., 0., 0., 0. }, { 0., 0., 0., 0. }, { 0., 0., 0., 0. },
            { 0., 0., 0., 0. } } };
    assertSpace( expected, spaceHilb, delta );

  }

  /**
   * Test method for {@link math.transform.jwave.Transform#reverse(double[][][])}.
   */
  @Test
  public void testDiscreteWaveletTransformReverseHaar02Space( ) {

    System.out.println( "" );
    System.out.println( "testDiscreteWaveletTransformReverseHaar02Space" );

    double delta = 1.e-12;

    double[ ][ ][ ] spaceHilb = {
        { { 8., 0., 0., 0. }, { 0., 0., 0., 0. }, { 0., 0., 0., 0. },
            { 0., 0., 0., 0. } },
        { { 0., 0., 0., 0. }, { 0., 0., 0., 0. }, { 0., 0., 0., 0. },
            { 0., 0., 0., 0. } },
        { { 0., 0., 0., 0. }, { 0., 0., 0., 0. }, { 0., 0., 0., 0. },
            { 0., 0., 0., 0. } },
        { { 0., 0., 0., 0. }, { 0., 0., 0., 0. }, { 0., 0., 0., 0. },
            { 0., 0., 0., 0. } } };

    showHilb( spaceHilb );

    Transform t = new Transform( new DiscreteWaveletTransform( new Haar02( ) ) );
    double[ ][ ][ ] spaceTime = t.reverse( spaceHilb );

    showTime( spaceTime );

    double[ ][ ][ ] expected = {
        { { 1., 1., 1., 1. }, { 1., 1., 1., 1. }, { 1., 1., 1., 1. },
            { 1., 1., 1., 1. } },
        { { 1., 1., 1., 1. }, { 1., 1., 1., 1. }, { 1., 1., 1., 1. },
            { 1., 1., 1., 1. } },
        { { 1., 1., 1., 1. }, { 1., 1., 1., 1. }, { 1., 1., 1., 1. },
            { 1., 1., 1., 1. } },
        { { 1., 1., 1., 1. }, { 1., 1., 1., 1. }, { 1., 1., 1., 1. },
            { 1., 1., 1., 1. } } };

    assertSpace( expected, spaceTime, delta );

  }
  
}
