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
 * This file Complex2dTest.java is part of JWave.
 *
 * @author Christian Scheiblich
 * date 19.11.2010 13:41:10
 * contact source@linux23.de
 */
package cs.jwave.types;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit test cases for Complex2d class.
 * 
 * @date 19.11.2010 13:41:10
 * @author Christian Scheiblich
 */
public class Complex2dTest {

  /**
   * Test method for {@link cs.jwave.types.Complex2d#getReal()}.
   */
  @Test
  public void testGetReal( ) {
    Complex2d a = new Complex2d( 1., 1. );
    double real = a.getReal( );
    assertEquals( 1., real, 0. );
  }

  /**
   * Test method for {@link cs.jwave.types.Complex2d#getImag()}.
   */
  @Test
  public void testGetImag( ) {
    Complex2d a = new Complex2d( 1., 1. );
    double imag = a.getImag( );
    assertEquals( 1., imag, 0. );
  }

  /**
   * Test method for {@link cs.jwave.types.Complex2d#getMag()}.
   */
  @Test
  public void testGetMag( ) {
    double mag = 0.;
    // 1. quarter
    Complex2d a1 = new Complex2d( Math.sqrt( 2. ), Math.sqrt( 2. ) );
    mag = a1.getMag( );
    assertEquals( 2., mag, 0. );
  }

  /**
   * Test method for {@link cs.jwave.types.Complex2d#getPhi()}.
   */
  @Test
  public void testGetPhi( ) {

    double phi = 0.;

    // 1. quarter
    Complex2d a1 = new Complex2d( 1., 0. );
    phi = a1.getPhi( );
    assertEquals( 0., phi, 0. );
    Complex2d b1 = new Complex2d( 1., 1. );
    phi = b1.getPhi( );
    assertEquals( 45., phi, 0. );
    Complex2d c1 = new Complex2d( 0., 1. );
    phi = c1.getPhi( );
    assertEquals( 90., phi, 0. );

    // 2. quarter
    Complex2d a2 = new Complex2d( -1., 1. );
    phi = a2.getPhi( );
    assertEquals( 135., phi, 0. );
    Complex2d b2 = new Complex2d( -1., 0. );
    phi = b2.getPhi( );
    assertEquals( 180., phi, 0. );

    // 3. quarter
    Complex2d a3 = new Complex2d( -1., -1. );
    phi = a3.getPhi( );
    assertEquals( 225., phi, 0. );
    Complex2d b3 = new Complex2d( 0., -1. );
    phi = b3.getPhi( );
    assertEquals( 270., phi, 0. );

    // 4. quarter
    Complex2d a4 = new Complex2d( 1., -1. );
    phi = a4.getPhi( );
    assertEquals( 315., phi, 0. );

  }

  /**
   * Test method for
   * {@link cs.jwave.types.Complex2d#add(cs.jwave.types.Complex2d)}.
   */
  @Test
  public void testAdd( ) {
    Complex2d a = new Complex2d( 1., 1. );
    Complex2d b = new Complex2d( 1., 1. );
    Complex2d c = a.add( b );
    assertEquals( 2., c.getReal( ), 0. );
    assertEquals( 2., c.getImag( ), 0. );
  }

  /**
   * Test method for
   * {@link cs.jwave.types.Complex2d#sub(cs.jwave.types.Complex2d)}.
   */
  @Test
  public void testSub( ) {
    Complex2d a = new Complex2d( 2., 2. );
    Complex2d b = new Complex2d( 1., 1. );
    Complex2d c = a.sub( b );
    assertEquals( 1., c.getReal( ), 0. );
    assertEquals( 1., c.getImag( ), 0. );
  }

  /**
   * Test method for
   * {@link cs.jwave.types.Complex2d#mul(cs.jwave.types.Complex2d)}.
   */
  @Test
  public void testMulComplex2d( ) {
    Complex2d a = new Complex2d( 1., 1. );
    Complex2d b = new Complex2d( 1., 1. );
    Complex2d c = a.mul( b );
    assertEquals( 0., c.getReal( ), 0. );
    assertEquals( 2., c.getImag( ), 0. );
  }

  /**
   * Test method for {@link cs.jwave.types.Complex2d#mul(double)}.
   */
  @Test
  public void testMulDouble( ) {
    Complex2d a = new Complex2d( 1., 1. );
    double s = 2.;
    Complex2d c = a.mul( s );
    assertEquals( 2., c.getReal( ), 0. );
    assertEquals( 2., c.getImag( ), 0. );
  }

  /**
   * Test method for
   * {@link cs.jwave.types.Complex2d#div(cs.jwave.types.Complex2d)}.
   */
  @Test
  public void testDivComplex2d( ) {
    Complex2d a = new Complex2d( 0., 2. );
    Complex2d b = new Complex2d( 1., 1. );
    Complex2d c = a.div( b );
    assertEquals( 1., c.getReal( ), 0. );
    assertEquals( 1., c.getImag( ), 0. );
  }

  /**
   * Test method for {@link cs.jwave.types.Complex2d#div(double)}.
   */
  @Test
  public void testDivDouble( ) {
    Complex2d a = new Complex2d( 1., 1. );
    double s = 2.;
    Complex2d c = a.div( s );
    assertEquals( .5, c.getReal( ), 0. );
    assertEquals( .5, c.getImag( ), 0. );
  }

  /**
   * Test method for
   * {@link cs.jwave.types.Complex2d#equals(cs.jwave.types.Complex2d)}.
   */
  @Test
  public void testEquals( ) {

    boolean isEqual = false;

    Complex2d a = new Complex2d( 1., 1. );
    Complex2d b = new Complex2d( 1., 1. );
    isEqual = a.equals( b );
    assertTrue( isEqual );

    Complex2d c = new Complex2d( 1., 1. );
    Complex2d d = new Complex2d( 1., 2. );
    isEqual = c.equals( d );
    assertFalse( isEqual );

    Complex2d e = new Complex2d( 1., 2. );
    Complex2d f = new Complex2d( 1., 1. );
    isEqual = e.equals( f );
    assertFalse( isEqual );

    Complex2d g = new Complex2d( 2., 1. );
    Complex2d h = new Complex2d( 1., 1. );
    isEqual = g.equals( h );
    assertFalse( isEqual );

    Complex2d i = new Complex2d( 1., 1. );
    Complex2d j = new Complex2d( 2., 1. );
    isEqual = i.equals( j );
    assertFalse( isEqual );

  }

}
