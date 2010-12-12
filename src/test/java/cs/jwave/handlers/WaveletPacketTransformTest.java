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
 * This file WaveletPacketTransformTest.java is part of JWave.
 *
 * @author Christian Scheiblich
 * date 23.11.2010 19:39:23
 * contact source@linux23.de
 */
package test.java.cs.jwave.handlers;

import org.junit.Test;

import test.java.cs.jwave.JUnitTests;
import main.java.cs.jwave.Transform;
import main.java.cs.jwave.handlers.WaveletPacketTransform;
import main.java.cs.jwave.handlers.wavelets.Daub02;
import main.java.cs.jwave.handlers.wavelets.Haar02;

public class WaveletPacketTransformTest extends JUnitTests {

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
   * Test method for {@link cs.jwave.Transform#forward(double[])}.
   */
  @Test
  public void testWaveletPacketTransformForwardDaub04ArrayRandom( ) {

    System.out.println( "" );
    System.out.println( "testWaveletPacketTransformForwardDaub04ArrayRandom" );

    double delta = 1.e-12;

    double[ ] arrTime = { 1.2, 2.3, 3.4, 4.5, 5.4, 4.3, 3.2, 2.1 };

    showTime( arrTime );

    Transform t = new Transform( new WaveletPacketTransform( new Daub02( ) ) );
    double[ ] arrHilb = t.forward( arrTime );

    showHilb( arrHilb );

    double[ ] expected = { 7.432531754730547, 5.76746824526945,
        2.2766660498395392, -2.276666049839541, 0.9580127018922185,
        -0.9580127018922194, 0.2566987298107781, -0.25669872981077807 };
    assertArray( expected, arrHilb, delta );

  }

  /**
   * Test method for {@link cs.jwave.Transform#reverse(double[])}.
   */
  @Test
  public void testWaveletPacketTransformReverseDaub04ArrayRandom( ) {

    System.out.println( "" );
    System.out.println( "testWaveletPacketTransformReverseDaub04ArrayRandom" );

    double delta = 1e-12;

    double[ ] arrHilb = { 7.432531754730547, 5.76746824526945,
        2.2766660498395392, -2.276666049839541, 0.9580127018922185,
        -0.9580127018922194, 0.2566987298107781, -0.25669872981077807 };

    showHilb( arrHilb );

    Transform t = new Transform( new WaveletPacketTransform( new Daub02( ) ) );
    double[ ] arrTime = t.reverse( arrHilb );

    showTime( arrTime );

    double[ ] expected = { 1.2, 2.3, 3.4, 4.5, 5.4, 4.3, 3.2, 2.1 };
    assertArray( expected, arrTime, delta );

  }

}
