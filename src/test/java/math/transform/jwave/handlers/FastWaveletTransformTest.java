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
 * This file FastWaveletTransformTest.java is part of JWave.
 *
 * @author Christian Scheiblich
 * date 23.11.2010 19:40:11
 * contact cscheiblich@googlemail.com
 */
package math.transform.jwave.handlers;

import math.transform.jwave.JUnitTests;
import math.transform.jwave.Transform;
import math.transform.jwave.handlers.FastWaveletTransform;
import math.transform.jwave.handlers.wavelets.Coif06;
import math.transform.jwave.handlers.wavelets.Daub02;
import math.transform.jwave.handlers.wavelets.Daub03;
import math.transform.jwave.handlers.wavelets.Daub04;
import math.transform.jwave.handlers.wavelets.Haar02;
import math.transform.jwave.handlers.wavelets.Haar02Orthogonal;
import math.transform.jwave.handlers.wavelets.Lege02;
import math.transform.jwave.handlers.wavelets.Lege04;
import math.transform.jwave.handlers.wavelets.Lege06;

import org.junit.Test;


public class FastWaveletTransformTest extends JUnitTests {

  /**
   * Test method for {@link math.transform.jwave.Transform#forward(double[])}.
   */
  @Test
  public void testFastWaveletTransformForwardHaar02Array( ) {

    System.out.println( "" );
    System.out.println( "testFastWaveletTransformForwardHaar02Array" );

    double delta = 1.e-12;

    double[ ] arrTime = { 1., 1., 1., 1. };

    showTime( arrTime );

    Transform t = new Transform( new FastWaveletTransform( new Haar02( ) ) );
    double[ ] arrHilb = t.forward( arrTime );

    showHilb( arrHilb );

    double[ ] expected = { 2., 0., 0., 0. }; // orthonormal Hilbert space
    assertArray( expected, arrHilb, delta );

  }

  /**
   * Test method for {@link math.transform.jwave.Transform#reverse(double[])}.
   */
  @Test
  public void testFastWaveletTransformReverseHaar02Array( ) {

    System.out.println( "" );
    System.out.println( "testFastWaveletTransformReverseHaar02Array" );

    double delta = 1e-12;

    double[ ] arrHilb = { 2., 0., 0., 0. }; // orthonormal Hilbert space

    showHilb( arrHilb );

    Transform t = new Transform( new FastWaveletTransform( new Haar02( ) ) );
    double[ ] arrTime = t.reverse( arrHilb );

    showTime( arrTime );

    double[ ] expected = { 1., 1., 1., 1. };
    assertArray( expected, arrTime, delta );

  }

  /**
   * Test method for {@link math.transform.jwave.Transform#forward(double[])}.
   */
  @Test
  public void testFastWaveletTransformForwardHaar02ArrayRandom( ) {

    System.out.println( "" );
    System.out.println( "testFastWaveletTransformForwardHaar02ArrayRandom" );

    double delta = 1.e-12;

    double[ ] arrTime = { 1.2, 2.3, 3.4, 4.5, 5.4, 4.3, 3.2, 2.1 };

    showTime( arrTime );

    Transform t = new Transform( new FastWaveletTransform( new Haar02( ) ) );
    double[ ] arrHilb = t.forward( arrTime );

    showHilb( arrHilb );

    double[ ] expected = { 9.333809511662427, -1.2727922061357857,
        -2.1999999999999997, 2.2, -0.7778174593052021, -0.7778174593052025,
        0.7778174593052025, 0.7778174593052023 }; // orthonormal Hilbert space
    assertArray( expected, arrHilb, delta );

  }

  /**
   * Test method for {@link math.transform.jwave.Transform#reverse(double[])}.
   */
  @Test
  public void testFastWaveletTransformReverseHaar02ArrayRandom( ) {

    System.out.println( "" );
    System.out.println( "testFastWaveletTransformReverseHaar02ArrayRandom" );

    double delta = 1e-12;

    double[ ] arrHilb = { 9.333809511662427, -1.2727922061357857,
        -2.1999999999999997, 2.2, -0.7778174593052021, -0.7778174593052025,
        0.7778174593052025, 0.7778174593052023 }; // orthonormal Hilbert space

    showHilb( arrHilb );

    Transform t = new Transform( new FastWaveletTransform( new Haar02( ) ) );
    double[ ] arrTime = t.reverse( arrHilb );

    showTime( arrTime );

    double[ ] expected = { 1.2, 2.3, 3.4, 4.5, 5.4, 4.3, 3.2, 2.1 };
    assertArray( expected, arrTime, delta );

  }

  /**
   * Test method for {@link math.transform.jwave.Transform#forward(double[][])}.
   */
  @Test
  public void testFastWaveletTransformForwardHaar02Matrix( ) {

    System.out.println( "" );
    System.out.println( "testFastWaveletTransformForwardHaar02Matrix" );

    double delta = 1.e-12;

    double[ ][ ] matrixTime = { { 1., 1., 1., 1. }, { 1., 1., 1., 1. },
        { 1., 1., 1., 1. }, { 1., 1., 1., 1. } };

    showTime( matrixTime );

    Transform t = new Transform( new FastWaveletTransform( new Haar02( ) ) );
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
  public void testFastWaveletTransformReverseHaar02Matrix( ) {

    System.out.println( "" );
    System.out.println( "testFastWaveletTransformReverseHaar02Matrix" );

    double delta = 1.e-12;

    double[ ][ ] matrixHilb = { { 4., 0., 0., 0. }, { 0., 0., 0., 0. },
        { 0., 0., 0., 0. }, { 0., 0., 0., 0. } };

    showHilb( matrixHilb );

    Transform t = new Transform( new FastWaveletTransform( new Haar02( ) ) );
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
  public void testFastWaveletTransformForwardHaar02Space( ) {

    System.out.println( "" );
    System.out.println( "testFastWaveletTransformForwardHaar02Space" );

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

    Transform t = new Transform( new FastWaveletTransform( new Haar02( ) ) );
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
  public void testFastWaveletTransformReverseHaar02Space( ) {

    System.out.println( "" );
    System.out.println( "testFastWaveletTransformReverseHaar02Space" );

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

    Transform t = new Transform( new FastWaveletTransform( new Haar02( ) ) );
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

  /**
   * Test method for {@link math.transform.jwave.Transform#forward(double[])}.
   */
  @Test
  public void testFastWaveletTransformForwardHaar02OrthogonalArray( ) {

    System.out.println( "" );
    System.out.println( "testFastWaveletTransformForwardHaar02OrthogonalArray" );

    double delta = 1.e-12;

    double[ ] arrTime = { 1., 1., 1., 1. };

    showTime( arrTime );

    Transform t = new Transform( new FastWaveletTransform(
        new Haar02Orthogonal( ) ) );
    double[ ] arrHilb = t.forward( arrTime );

    showHilb( arrHilb );

    double[ ] expected = { 4., 0., 0., 0. }; // see the orthonormal version above
    assertArray( expected, arrHilb, delta );

  }

  /**
   * Test method for {@link math.transform.jwave.Transform#reverse(double[])}.
   */
  @Test
  public void testFastWaveletTransformReverseHaar02OrthogonalArray( ) {

    System.out.println( "" );
    System.out.println( "testFastWaveletTransformReverseHaar02OrthogonalArray" );

    double delta = 1e-12;

    double[ ] arrHilb = { 4., 0., 0., 0. }; // see the orthonormal version above

    showHilb( arrHilb );

    Transform t = new Transform( new FastWaveletTransform(
        new Haar02Orthogonal( ) ) );
    double[ ] arrTime = t.reverse( arrHilb );

    showTime( arrTime );

    double[ ] expected = { 1., 1., 1., 1. };
    assertArray( expected, arrTime, delta );

  }

  /**
   * Test method for {@link math.transform.jwave.Transform#forward(double[])}.
   */
  @Test
  public void testFastWaveletTransformForwardLege02Array( ) {

    System.out.println( "" );
    System.out.println( "testFastWaveletTransformForwardLege02Array" );

    double delta = 1.e-12;

    double[ ] arrTime = { 1., 1., 1., 1. };

    showTime( arrTime );

    Transform t = new Transform( new FastWaveletTransform( new Lege02( ) ) );
    double[ ] arrHilb = t.forward( arrTime );

    showHilb( arrHilb );

    double[ ] expected = { 2., 0., 0., 0. }; // orthonormal Hilbert space
    assertArray( expected, arrHilb, delta );

  }

  /**
   * Test method for {@link math.transform.jwave.Transform#reverse(double[])}.
   */
  @Test
  public void testFastWaveletTransformReverseLege02Array( ) {

    System.out.println( "" );
    System.out.println( "testFastWaveletTransformReverseLege02Array" );

    double delta = 1e-12;

    double[ ] arrHilb = { 2., 0., 0., 0. }; // orthonormal Hilbert space

    showHilb( arrHilb );

    Transform t = new Transform( new FastWaveletTransform( new Lege02( ) ) );
    double[ ] arrTime = t.reverse( arrHilb );

    showTime( arrTime );

    double[ ] expected = { 1., 1., 1., 1. };
    assertArray( expected, arrTime, delta );

  }

  /**
   * Test method for {@link math.transform.jwave.Transform#forward(double[])}.
   */
  @Test
  public void testFastWaveletTransformForwardDaub04Array( ) {

    System.out.println( "" );
    System.out.println( "testFastWaveletTransformForwardDaub04Array" );

    double delta = 1.e-12;

    double[ ] arrTime = { 1., 1., 1., 1., 1., 1., 1., 1. };

    showTime( arrTime );

    Transform t = new Transform( new FastWaveletTransform( new Daub02( ) ) );
    double[ ] arrHilb = t.forward( arrTime );

    showHilb( arrHilb );

    double[ ] expected = { 2., 2., 0., 0., 0., 0., 0., 0. };
    assertArray( expected, arrHilb, delta );

  }

  /**
   * Test method for {@link math.transform.jwave.Transform#reverse(double[])}.
   */
  @Test
  public void testFastWaveletTransformReverseDaub04Array( ) {

    System.out.println( "" );
    System.out.println( "testFastWaveletTransformReverseDaub04Array" );

    double delta = 1.e-12;

    double[ ] arrHilb = { 2., 2., 0., 0., 0., 0., 0., 0. };

    showHilb( arrHilb );

    Transform t = new Transform( new FastWaveletTransform( new Daub02( ) ) );
    double[ ] arrTime = t.reverse( arrHilb );

    showTime( arrTime );

    double[ ] expected = { 1., 1., 1., 1., 1., 1., 1., 1. };
    assertArray( expected, arrTime, delta );

  }

  /**
   * Test method for {@link math.transform.jwave.Transform#forward(double[])}.
   */
  @Test
  public void testFastWaveletTransformForwardLege04Array( ) {

    System.out.println( "" );
    System.out.println( "testFastWaveletTransformForwardLege04Array" );

    double delta = 1.e-12;

    double[ ] arrTime = { 1., 1., 1., 1., 1., 1., 1., 1. };

    showTime( arrTime );

    Transform t = new Transform( new FastWaveletTransform( new Lege04( ) ) );
    double[ ] arrHilb = t.forward( arrTime );

    showHilb( arrHilb );

    double[ ] expected = { 2., 2., 0., 0., 0., 0., 0., 0. };
    assertArray( expected, arrHilb, delta );

  }

  /**
   * Test method for {@link math.transform.jwave.Transform#reverse(double[])}.
   */
  @Test
  public void testFastWaveletTransformReverseLege04Array( ) {

    System.out.println( "" );
    System.out.println( "testFastWaveletTransformReverseLege04Array" );

    double delta = 1.e-12;

    double[ ] arrHilb = { 2., 2., 0., 0., 0., 0., 0., 0. };

    showHilb( arrHilb );

    Transform t = new Transform( new FastWaveletTransform( new Lege04( ) ) );
    double[ ] arrTime = t.reverse( arrHilb );

    showTime( arrTime );

    double[ ] expected = { 1., 1., 1., 1., 1., 1., 1., 1. };
    assertArray( expected, arrTime, delta );

  }

  /**
   * Test method for {@link math.transform.jwave.Transform#forward(double[])}.
   */
  @Test
  public void testFastWaveletTransformForwardDaub06Array( ) {

    System.out.println( "" );
    System.out.println( "testFastWaveletTransformForwardDaub06Array" );

    double delta = 1.e-12;

    double[ ] arrTime = { 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1. };

    showTime( arrTime );

    Transform t = new Transform( new FastWaveletTransform( new Daub03( ) ) );
    double[ ] arrHilb = t.forward( arrTime );

    showHilb( arrHilb );

    double[ ] expected = { 2., 2., 2., 0., 0., 0., 0., 0., 0., 0., 0., 0. };
    assertArray( expected, arrHilb, delta );

  }

  /**
   * Test method for {@link math.transform.jwave.Transform#reverse(double[])}.
   */
  @Test
  public void testFastWaveletTransformReverseDaub06Array( ) {

    System.out.println( "" );
    System.out.println( "testFastWaveletTransformReverseDaub06Array" );

    double delta = 1.e-12;

    double[ ] arrHilb = { 2., 2., 2., 0., 0., 0., 0., 0., 0., 0., 0., 0. };

    showHilb( arrHilb );

    Transform t = new Transform( new FastWaveletTransform( new Daub03( ) ) );
    double[ ] arrTime = t.reverse( arrHilb );

    showTime( arrTime );

    double[ ] expected = { 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1. };
    assertArray( expected, arrTime, delta );

  }

  /**
   * Test method for {@link math.transform.jwave.Transform#forward(double[])}.
   */
  @Test
  public void testFastWaveletTransformForwardLege06Array( ) {

    System.out.println( "" );
    System.out.println( "testFastWaveletTransformForwardLege06Array" );

    double delta = 1.e-12;

    double[ ] arrTime = { 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1. };

    showTime( arrTime );

    Transform t = new Transform( new FastWaveletTransform( new Lege06( ) ) );
    double[ ] arrHilb = t.forward( arrTime );

    showHilb( arrHilb );

    double[ ] expected = { 2., 2., 2., 0., 0., 0., 0., 0., 0., 0., 0., 0. };
    assertArray( expected, arrHilb, delta );

  }

  /**
   * Test method for {@link math.transform.jwave.Transform#reverse(double[])}.
   */
  @Test
  public void testFastWaveletTransformReverseLege06Array( ) {

    System.out.println( "" );
    System.out.println( "testFastWaveletTransformReverseLege06Array" );

    double delta = 1.e-12;

    double[ ] arrHilb = { 2., 2., 2., 0., 0., 0., 0., 0., 0., 0., 0., 0. };

    showHilb( arrHilb );

    Transform t = new Transform( new FastWaveletTransform( new Lege06( ) ) );
    double[ ] arrTime = t.reverse( arrHilb );

    showTime( arrTime );

    double[ ] expected = { 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1. };
    assertArray( expected, arrTime, delta );

  }

  /**
   * Test method for {@link math.transform.jwave.Transform#forward(double[])}.
   */
  @Test
  public void testFastWaveletTransformForwardCoif06Array( ) {

    System.out.println( "" );
    System.out.println( "testFastWaveletTransformForwardCoif06Array" );

    double delta = 1.e-12;

    double[ ] arrTime = { 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1. };

    showTime( arrTime );

    Transform t = new Transform( new FastWaveletTransform( new Coif06( ) ) );
    double[ ] arrHilb = t.forward( arrTime );

    showHilb( arrHilb );

    double[ ] expected = { 2., 2., 2., 0., 0., 0., 0., 0., 0., 0., 0., 0. };
    assertArray( expected, arrHilb, delta );

  }

  /**
   * Test method for {@link math.transform.jwave.Transform#reverse(double[])}.
   */
  @Test
  public void testFastWaveletTransformReverseCoif06Array( ) {

    System.out.println( "" );
    System.out.println( "testFastWaveletTransformReverseCoif06Array" );

    double delta = 1.e-12;

    double[ ] arrHilb = { 2., 2., 2., 0., 0., 0., 0., 0., 0., 0., 0., 0. };

    showHilb( arrHilb );

    Transform t = new Transform( new FastWaveletTransform( new Coif06( ) ) );
    double[ ] arrTime = t.reverse( arrHilb );

    showTime( arrTime );

    double[ ] expected = { 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1. };
    assertArray( expected, arrTime, delta );

  }

  /**
   * Test method for {@link math.transform.jwave.Transform#forward(double[])}.
   */
  @Test
  public void testFastWaveletTransformForwardDaub08Array( ) {

    System.out.println( "" );
    System.out.println( "testFastWaveletTransformForwardDaub08Array" );

    double delta = 1.e-3;

    double[ ] arrTime = { 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1.,
        1., 1., 1. };

    showTime( arrTime );

    Transform t = new Transform( new FastWaveletTransform( new Daub04( ) ) );
    double[ ] arrHilb = t.forward( arrTime );

    showHilb( arrHilb );

    double[ ] expected = { 2., 2., 2., 2., 0., 0., 0., 0., 0., 0., 0., 0., 0.,
        0., 0., 0. };
    assertArray( expected, arrHilb, delta );

  }

  /**
   * Test method for {@link math.transform.jwave.Transform#reverse(double[])}.
   */
  @Test
  public void testFastWaveletTransformReverseDaub08Array( ) {

    System.out.println( "" );
    System.out.println( "testFastWaveletTransformReverseDaub08Array" );

    double delta = 1.e-3;

    double[ ] arrHilb = { 2., 2., 2., 2., 0., 0., 0., 0., 0., 0., 0., 0., 0.,
        0., 0., 0. };

    showHilb( arrHilb );

    Transform t = new Transform( new FastWaveletTransform( new Daub04( ) ) );
    double[ ] arrTime = t.reverse( arrHilb );

    showTime( arrTime );

    double[ ] expected = { 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1.,
        1., 1., 1. };
    assertArray( expected, arrTime, delta );

  }

}
