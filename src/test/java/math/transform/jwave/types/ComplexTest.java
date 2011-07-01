/**
 * JWave - Java implementation of wavelet transform algorithms
 *
 * Copyright 2010-2011 Christian Scheiblich
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
 * This file ComplexTest.java is part of JWave.
 *
 * @author Christian Scheiblich
 * date 19.11.2010 13:41:10
 * contact source@linux23.de
 */
package math.transform.jwave.types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import math.transform.jwave.types.Complex;

import org.junit.Test;


/**
 * JUnit test cases for class Complex.
 * 
 * @date 19.11.2010 13:41:10
 * @author Christian Scheiblich
 */
public class ComplexTest {

  /**
   * Test method for {@link math.transform.jwave.types.Complex#getReal()}.
   */
  @Test
  public void testGetReal( ) {
    Complex a = new Complex( 1., 1. );
    double real = a.getReal( );
    assertEquals( 1., real, 0. );
  }

  /**
   * Test method for {@link math.transform.jwave.types.Complex#getImag()}.
   */
  @Test
  public void testGetImag( ) {
    Complex a = new Complex( 1., 1. );
    double imag = a.getImag( );
    assertEquals( 1., imag, 0. );
  }

  /**
   * Test method for {@link math.transform.jwave.types.Complex#getMag()}.
   */
  @Test
  public void testGetMag( ) {
    double mag = 0.;
    // 1. quarter
    Complex a1 = new Complex( Math.sqrt( 2. ), Math.sqrt( 2. ) );
    mag = a1.getMag( );
    assertEquals( 2., mag, 0. );
  }

  /**
   * Test method for {@link math.transform.jwave.types.Complex#getPhi()}.
   */
  @Test
  public void testGetPhi( ) {

    double phi = 0.;

    // 1. quarter
    Complex a1 = new Complex( 1., 0. );
    phi = a1.getPhi( );
    assertEquals( 0., phi, 0. );
    Complex b1 = new Complex( 1., 1. );
    phi = b1.getPhi( );
    assertEquals( 45., phi, 0. );
    Complex c1 = new Complex( 0., 1. );
    phi = c1.getPhi( );
    assertEquals( 90., phi, 0. );

    // 2. quarter
    Complex a2 = new Complex( -1., 1. );
    phi = a2.getPhi( );
    assertEquals( 135., phi, 0. );
    Complex b2 = new Complex( -1., 0. );
    phi = b2.getPhi( );
    assertEquals( 180., phi, 0. );

    // 3. quarter
    Complex a3 = new Complex( -1., -1. );
    phi = a3.getPhi( );
    assertEquals( 225., phi, 0. );
    Complex b3 = new Complex( 0., -1. );
    phi = b3.getPhi( );
    assertEquals( 270., phi, 0. );

    // 4. quarter
    Complex a4 = new Complex( 1., -1. );
    phi = a4.getPhi( );
    assertEquals( 315., phi, 0. );

  }

  /**
   * Test method for
   * {@link math.transform.jwave.types.Complex#add(math.transform.jwave.types.Complex)}.
   */
  @Test
  public void testAdd( ) {
    Complex a = new Complex( 1., 1. );
    Complex b = new Complex( 1., 1. );
    Complex c = a.add( b );
    assertEquals( 2., c.getReal( ), 0. );
    assertEquals( 2., c.getImag( ), 0. );
  }

  /**
   * Test method for
   * {@link math.transform.jwave.types.Complex#sub(math.transform.jwave.types.Complex)}.
   */
  @Test
  public void testSub( ) {
    Complex a = new Complex( 2., 2. );
    Complex b = new Complex( 1., 1. );
    Complex c = a.sub( b );
    assertEquals( 1., c.getReal( ), 0. );
    assertEquals( 1., c.getImag( ), 0. );
  }

  /**
   * Test method for
   * {@link math.transform.jwave.types.Complex#mul(math.transform.jwave.types.Complex)}.
   */
  @Test
  public void testMulComplex( ) {
    Complex a = new Complex( 1., 1. );
    Complex b = new Complex( 1., 1. );
    Complex c = a.mul( b );
    assertEquals( 0., c.getReal( ), 0. );
    assertEquals( 2., c.getImag( ), 0. );
  }

  /**
   * Test method for {@link math.transform.jwave.types.Complex#mul(double)}.
   */
  @Test
  public void testMulDouble( ) {
    Complex a = new Complex( 1., 1. );
    double s = 2.;
    Complex c = a.mul( s );
    assertEquals( 2., c.getReal( ), 0. );
    assertEquals( 2., c.getImag( ), 0. );
  }

  /**
   * Test method for
   * {@link math.transform.jwave.types.Complex#div(math.transform.jwave.types.Complex)}.
   */
  @Test
  public void testDivComplex( ) {
    Complex a = new Complex( 0., 2. );
    Complex b = new Complex( 1., 1. );
    Complex c = a.div( b );
    assertEquals( 1., c.getReal( ), 0. );
    assertEquals( 1., c.getImag( ), 0. );
  }

  /**
   * Test method for {@link math.transform.jwave.types.Complex#div(double)}.
   */
  @Test
  public void testDivDouble( ) {
    Complex a = new Complex( 1., 1. );
    double s = 2.;
    Complex c = a.div( s );
    assertEquals( .5, c.getReal( ), 0. );
    assertEquals( .5, c.getImag( ), 0. );
  }

  /**
   * Test method for
   * {@link math.transform.jwave.types.Complex#equals(math.transform.jwave.types.Complex)}.
   */
  @Test
  public void testEquals( ) {

    boolean isEqual = false;

    Complex a = new Complex( 1., 1. );
    Complex b = new Complex( 1., 1. );
    isEqual = a.equals( b );
    assertTrue( isEqual );

    Complex c = new Complex( 1., 1. );
    Complex d = new Complex( 1., 2. );
    isEqual = c.equals( d );
    assertFalse( isEqual );

    Complex e = new Complex( 1., 2. );
    Complex f = new Complex( 1., 1. );
    isEqual = e.equals( f );
    assertFalse( isEqual );

    Complex g = new Complex( 2., 1. );
    Complex h = new Complex( 1., 1. );
    isEqual = g.equals( h );
    assertFalse( isEqual );

    Complex i = new Complex( 1., 1. );
    Complex j = new Complex( 2., 1. );
    isEqual = i.equals( j );
    assertFalse( isEqual );

  }

}
