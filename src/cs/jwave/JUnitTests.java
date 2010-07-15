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
 * This file JUnitTests.java is part of JWave.
 *
 * @author Christian Scheiblich
 * date 23.02.2010 05:42:23
 * contact source@linux23.de
 */
package cs.jwave;

import org.junit.Test;
import static org.junit.Assert.*;

import cs.jwave.handlers.BasicTransform;
import cs.jwave.handlers.DiscreteFourierTransform;
import cs.jwave.handlers.FastWaveletTransform;
import cs.jwave.handlers.WaveletPacketTransform;
import cs.jwave.handlers.wavelets.Coif06;
import cs.jwave.handlers.wavelets.Daub04;
import cs.jwave.handlers.wavelets.Daub06;
import cs.jwave.handlers.wavelets.Daub08;
import cs.jwave.handlers.wavelets.Haar02;
import cs.jwave.handlers.wavelets.Haar02Orthogonal;
import cs.jwave.handlers.wavelets.Lege02;
import cs.jwave.handlers.wavelets.Lege04;
import cs.jwave.handlers.wavelets.Lege06;
import cs.jwave.handlers.wavelets.Wavelet;

/**
 * Tests for the class cs.jwave.Transform.
 * 
 * @date 10.02.2010 09:43:08
 * @author Christian Scheiblich
 */
public class JUnitTests {

  /**
   * Test method for {@link cs.jwave.Transform#forward(double[])}.
   */
  @Test
  public void testDiscreteFourierTransformForwardArray( ) {

    System.out.println( "" );
    System.out.println( "testDiscreteFourierTransformForwardArray" );

    double delta = 1.e-12;

    double[ ] arrTime = { 1., 1., 1., 1., 1., 1., 1., 1. };

    showTime( arrTime );

    Transform t = new Transform( new DiscreteFourierTransform( ) );
    double[ ] arrFreq = t.forward( arrTime );

    showFreq( arrFreq );

    double[ ] expected = { 1., 1., 0., 0., 0., 0, 0., 0. };
    assertArray( expected, arrFreq, delta );

  }

  /**
   * Test method for {@link cs.jwave.Transform#reverse(double[])}.
   */
  @Test
  public void testDiscreteFourierTransformReverseArray( ) {

    System.out.println( "" );
    System.out.println( "testDiscreteFourierTransformReverseArray" );

    double delta = 1e-12;

    double[ ] arrFreq = { 1., 1., 0., 0., 0., 0, 0., 0. };

    showHilb( arrFreq );

    Transform t = new Transform( new DiscreteFourierTransform( ) );
    double[ ] arrTime = t.reverse( arrFreq );

    showTime( arrTime );

    double[ ] expected = { 1., 1., 1., 1., 1., 1., 1., 1. };
    assertArray( expected, arrTime, delta );

  }

  /**
   * Test method for {@link cs.jwave.Transform#forward(double[])}.
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
   * Test method for {@link cs.jwave.Transform#reverse(double[])}.
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
   * Test method for {@link cs.jwave.Transform#forward(double[][])}.
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
   * Test method for {@link cs.jwave.Transform#reverse(double[][])}.
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
   * Test method for {@link cs.jwave.Transform#forward(double[][][])}.
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
   * Test method for {@link cs.jwave.Transform#reverse(double[][][])}.
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
   * Test method for {@link cs.jwave.Transform#forward(double[])}.
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
   * Test method for {@link cs.jwave.Transform#reverse(double[])}.
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
   * Test method for {@link cs.jwave.Transform#forward(double[])}.
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
   * Test method for {@link cs.jwave.Transform#reverse(double[])}.
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
   * Test method for {@link cs.jwave.Transform#forward(double[])}.
   */
  @Test
  public void testFastWaveletTransformForwardDaub04Array( ) {

    System.out.println( "" );
    System.out.println( "testFastWaveletTransformForwardDaub04Array" );

    double delta = 1.e-12;

    double[ ] arrTime = { 1., 1., 1., 1., 1., 1., 1., 1. };

    showTime( arrTime );

    Transform t = new Transform( new FastWaveletTransform( new Daub04( ) ) );
    double[ ] arrHilb = t.forward( arrTime );

    showHilb( arrHilb );

    double[ ] expected = { 2., 2., 0., 0., 0., 0., 0., 0. };
    assertArray( expected, arrHilb, delta );

  }

  /**
   * Test method for {@link cs.jwave.Transform#reverse(double[])}.
   */
  @Test
  public void testFastWaveletTransformReverseDaub04Array( ) {

    System.out.println( "" );
    System.out.println( "testFastWaveletTransformReverseDaub04Array" );

    double delta = 1.e-12;

    double[ ] arrHilb = { 2., 2., 0., 0., 0., 0., 0., 0. };

    showHilb( arrHilb );

    Transform t = new Transform( new FastWaveletTransform( new Daub04( ) ) );
    double[ ] arrTime = t.reverse( arrHilb );

    showTime( arrTime );

    double[ ] expected = { 1., 1., 1., 1., 1., 1., 1., 1. };
    assertArray( expected, arrTime, delta );

  }

  /**
   * Test method for {@link cs.jwave.Transform#forward(double[])}.
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
   * Test method for {@link cs.jwave.Transform#reverse(double[])}.
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
   * Test method for {@link cs.jwave.Transform#forward(double[])}.
   */
  @Test
  public void testFastWaveletTransformForwardDaub06Array( ) {

    System.out.println( "" );
    System.out.println( "testFastWaveletTransformForwardDaub06Array" );

    double delta = 1.e-12;

    double[ ] arrTime = { 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1. };

    showTime( arrTime );

    Transform t = new Transform( new FastWaveletTransform( new Daub06( ) ) );
    double[ ] arrHilb = t.forward( arrTime );

    showHilb( arrHilb );

    double[ ] expected = { 2., 2., 2., 0., 0., 0., 0., 0., 0., 0., 0., 0. };
    assertArray( expected, arrHilb, delta );

  }

  /**
   * Test method for {@link cs.jwave.Transform#reverse(double[])}.
   */
  @Test
  public void testFastWaveletTransformReverseDaub06Array( ) {

    System.out.println( "" );
    System.out.println( "testFastWaveletTransformReverseDaub06Array" );

    double delta = 1.e-12;

    double[ ] arrHilb = { 2., 2., 2., 0., 0., 0., 0., 0., 0., 0., 0., 0. };

    showHilb( arrHilb );

    Transform t = new Transform( new FastWaveletTransform( new Daub06( ) ) );
    double[ ] arrTime = t.reverse( arrHilb );

    showTime( arrTime );

    double[ ] expected = { 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1. };
    assertArray( expected, arrTime, delta );

  }

  /**
   * Test method for {@link cs.jwave.Transform#forward(double[])}.
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
   * Test method for {@link cs.jwave.Transform#reverse(double[])}.
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
   * Test method for {@link cs.jwave.Transform#forward(double[])}.
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
   * Test method for {@link cs.jwave.Transform#reverse(double[])}.
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
   * Test method for {@link cs.jwave.Transform#forward(double[])}.
   */
  @Test
  public void testFastWaveletTransformForwardDaub08Array( ) {

    System.out.println( "" );
    System.out.println( "testFastWaveletTransformForwardDaub08Array" );

    double delta = 1.e-3;

    double[ ] arrTime = { 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1.,
        1., 1., 1. };

    showTime( arrTime );

    Transform t = new Transform( new FastWaveletTransform( new Daub08( ) ) );
    double[ ] arrHilb = t.forward( arrTime );

    showHilb( arrHilb );

    double[ ] expected = { 2., 2., 2., 2., 0., 0., 0., 0., 0., 0., 0., 0., 0.,
        0., 0., 0. };
    assertArray( expected, arrHilb, delta );

  }

  /**
   * Test method for {@link cs.jwave.Transform#reverse(double[])}.
   */
  @Test
  public void testFastWaveletTransformReverseDaub08Array( ) {

    System.out.println( "" );
    System.out.println( "testFastWaveletTransformReverseDaub08Array" );

    double delta = 1.e-3;

    double[ ] arrHilb = { 2., 2., 2., 2., 0., 0., 0., 0., 0., 0., 0., 0., 0.,
        0., 0., 0. };

    showHilb( arrHilb );

    Transform t = new Transform( new FastWaveletTransform( new Daub08( ) ) );
    double[ ] arrTime = t.reverse( arrHilb );

    showTime( arrTime );

    double[ ] expected = { 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1.,
        1., 1., 1. };
    assertArray( expected, arrTime, delta );

  }

  /**
   * Test method for {@link cs.jwave.Transform#forward(double[])}.
   */
  @Test
  public void testWaveletPacketTransformForwardHaar02Array( ) {

    System.out.println( "" );
    System.out.println( "testWaveletPacketTransformForwardHaar02Array" );

    double delta = 1.e-12;

    double[ ] arrTime = { 2., 4., 7., 11. };

    showTime( arrTime );

    Transform t = new Transform( new WaveletPacketTransform( new Haar02( ) ) );
    double[ ] arrHilb = t.forward( arrTime );

    showHilb( arrHilb );

    double[ ] expected = { 12., -6., -3., 1. };
    assertArray( expected, arrHilb, delta );

  }

  /**
   * Test method for {@link cs.jwave.Transform#reverse(double[])}.
   */
  @Test
  public void testWaveletPacketTransformReverseHaar02Array( ) {

    System.out.println( "" );
    System.out.println( "testWaveletPacketTransformReverseHaar02Array" );

    double delta = 1e-12;

    double[ ] arrHilb = { 12., -6., -3., 1. };

    showHilb( arrHilb );

    Transform t = new Transform( new WaveletPacketTransform( new Haar02( ) ) );
    double[ ] arrTime = t.reverse( arrHilb );

    showTime( arrTime );

    double[ ] expected = { 2., 4., 7., 11. };
    assertArray( expected, arrTime, delta );

  }

  /**
   * Test method for {@link cs.jwave.Transform#forward(double[][])}.
   */
  @Test
  public void testWaveletPacketTransformForwardHaar02Matrix( ) {

    System.out.println( "" );
    System.out.println( "testWaveletPacketTransformForwardHaar02Matrix" );

    double delta = 1.e-12;

    double[ ][ ] matrixTime = { { 1., 1., 1., 1. }, { 1., 1., 1., 1. },
        { 1., 1., 1., 1. }, { 1., 1., 1., 1. } };

    showTime( matrixTime );

    Transform t = new Transform( new WaveletPacketTransform( new Haar02( ) ) );
    double[ ][ ] matrixHilb = t.forward( matrixTime );

    showHilb( matrixHilb );

    double[ ][ ] expected = { { 4., 0., 0., 0. }, { 0., 0., 0., 0. },
        { 0., 0., 0., 0. }, { 0., 0., 0., 0. } };
    assertMatrix( expected, matrixHilb, delta );

  }

  /**
   * Test method for {@link cs.jwave.Transform#reverse(double[][])}.
   */
  @Test
  public void testWaveletPacketTransformReverseHaar02Matrix( ) {

    System.out.println( "" );
    System.out.println( "testWaveletPacketTransformReverseHaar02Matrix" );

    double delta = 1.e-12;

    double[ ][ ] matrixHilb = { { 4., 0., 0., 0. }, { 0., 0., 0., 0. },
        { 0., 0., 0., 0. }, { 0., 0., 0., 0. } };

    showHilb( matrixHilb );

    Transform t = new Transform( new WaveletPacketTransform( new Haar02( ) ) );
    double[ ][ ] matrixTime = t.reverse( matrixHilb );

    showTime( matrixTime );

    double[ ][ ] expected = { { 1., 1., 1., 1. }, { 1., 1., 1., 1. },
        { 1., 1., 1., 1. }, { 1., 1., 1., 1. } };
    assertMatrix( expected, matrixTime, delta );

  }

  /**
   * Test method for {@link cs.jwave.Transform#forward(double[][][])}.
   */
  @Test
  public void testWaveletPacketTransformForwardHaar02Space( ) {

    System.out.println( "" );
    System.out.println( "testWaveletPacketTransformForwardHaar02Space" );

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

    Transform t = new Transform( new WaveletPacketTransform( new Haar02( ) ) );
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
   * Test method for {@link cs.jwave.Transform#reverse(double[][][])}.
   */
  @Test
  public void testWaveletPacketTransformReverseHaar02Space( ) {

    System.out.println( "" );
    System.out.println( "testWaveletPacketTransformReverseHaar02Space" );

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

    Transform t = new Transform( new WaveletPacketTransform( new Haar02( ) ) );
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

    testFastWaveletTransformRounding( arrTime, new Daub04( ), delta );

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

  public void assertArray( double[ ] expected, double[ ] actual, double delta ) {
    for( int i = 0; i < expected.length; i++ )
      assertEquals( expected[ i ], actual[ i ], delta );
  } // assertMatrix

  public void assertMatrix( double[ ][ ] expected, double[ ][ ] actual,
      double delta ) {
    for( int i = 0; i < expected.length; i++ )
      for( int j = 0; j < expected[ i ].length; j++ )
        assertEquals( expected[ i ][ j ], actual[ i ][ j ], delta );
  } // assertMatrix

  public void assertSpace( double[ ][ ][ ] expected, double[ ][ ][ ] actual,
      double delta ) {
    for( int i = 0; i < expected.length; i++ )
      for( int j = 0; j < expected[ i ].length; j++ )
        for( int k = 0; k < expected[ i ][ j ].length; k++ )
          assertEquals( expected[ i ][ j ][ k ], actual[ i ][ j ][ k ], delta );
  } // assertSpace

  public void showTime( double[ ] arrTime ) {
    System.out.print( "time domain: " + "\t" + "\t" );
    for( int c = 0; c < arrTime.length; c++ )
      System.out.print( arrTime[ c ] + " " );
    System.out.println( "" );
  } // showTime

  public void showFreq( double[ ] arrFreq ) {
    System.out.print( "frequency domain: " + "\t" );
    for( int c = 0; c < arrFreq.length; c++ )
      System.out.print( arrFreq[ c ] + " " );
    System.out.println( "" );
  } // showHilb

  public void showHilb( double[ ] arrHilb ) {
    System.out.print( "Hilbert domain: " + "\t" );
    for( int c = 0; c < arrHilb.length; c++ )
      System.out.print( arrHilb[ c ] + " " );
    System.out.println( "" );
  } // showHilb

  public void showTime( double[ ][ ] matrixTime ) {
    System.out.println( "time domain: " + "\t" );
    for( int i = 0; i < matrixTime.length; i++ ) {
      for( int j = 0; j < matrixTime[ i ].length; j++ )
        System.out.print( matrixTime[ i ][ j ] + " " );
      System.out.println( "" );
    }
    System.out.println( "" );
  } // showTime 

  public void showFreq( double[ ][ ] matrixFreq ) {
    System.out.println( "frequency domain: " + "\t" );
    for( int i = 0; i < matrixFreq.length; i++ ) {
      for( int j = 0; j < matrixFreq[ i ].length; j++ )
        System.out.print( matrixFreq[ i ][ j ] + " " );
      System.out.println( "" );
    }
    System.out.println( "" );
  } // showFreq

  public void showHilb( double[ ][ ] matrixHilb ) {
    System.out.println( "Hilbert domain: " + "\t" );
    for( int i = 0; i < matrixHilb.length; i++ ) {
      for( int j = 0; j < matrixHilb[ i ].length; j++ )
        System.out.print( matrixHilb[ i ][ j ] + " " );
      System.out.println( "" );
    }
    System.out.println( "" );
  } // showHilb

  public void showTime( double[ ][ ][ ] spaceTime ) {
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

  public void showFreq( double[ ][ ][ ] spaceTime ) {
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

  public void showHilb( double[ ][ ][ ] spaceTime ) {
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
