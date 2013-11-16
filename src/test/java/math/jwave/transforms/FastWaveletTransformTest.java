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
 * This file FastBasicTransformTest.java is part of JWave.
 *
 * @author Christian Scheiblich
 * date 23.11.2010 19:40:11
 * contact graetz@mailfish.de
 */
package math.jwave.transforms;

import math.jwave.JUnitTests;
import math.jwave.Transform;
import math.jwave.exc.JWaveException;
import math.jwave.transforms.FastWaveletTransform;
import math.jwave.transforms.wavelets.Coif06;
import math.jwave.transforms.wavelets.Daub02;
import math.jwave.transforms.wavelets.Daub03;
import math.jwave.transforms.wavelets.Daub04;
import math.jwave.transforms.wavelets.Haar02;
import math.jwave.transforms.wavelets.Haar02Orthogonal;
import math.jwave.transforms.wavelets.Lege02;
import math.jwave.transforms.wavelets.Lege04;
import math.jwave.transforms.wavelets.Lege06;
import org.junit.Test;

public class FastWaveletTransformTest extends JUnitTests {
  
  /**
   * Test method for {@link math.jwave.Transform#forward(double[])}.
   * @throws JWaveException 
   */
  @Test
  public void testFastBasicTransformForwardHaar02Array( ) throws JWaveException {
    
    System.out.println( "" );
    System.out.println( "testFastBasicTransformForwardHaar02Array" );
    
    double delta = 1.e-12;
    
    double[ ] arrTime = {
    1., 1., 1., 1.
    };
    
    showTime( arrTime );
    
    Transform t = new Transform( new FastWaveletTransform( new Haar02( ) ) );
    double[ ] arrHilb = t.forward( arrTime );
    
    showHilb( arrHilb );
    
    double[ ] expected = {
    2., 0., 0., 0.
    }; // orthonormal Hilbert space
    assertArray( expected, arrHilb, delta );
    
  }
  
  /**
   * Test method for {@link math.jwave.Transform#reverse(double[])}.
   * @throws JWaveException 
   */
  @Test
  public void testFastBasicTransformReverseHaar02Array( ) throws JWaveException {
    
    System.out.println( "" );
    System.out.println( "testFastBasicTransformReverseHaar02Array" );
    
    double delta = 1e-12;
    
    double[ ] arrHilb = {
    2., 0., 0., 0.
    }; // orthonormal Hilbert space
    
    showHilb( arrHilb );
    
    Transform t = new Transform( new FastWaveletTransform( new Haar02( ) ) );
    double[ ] arrTime = t.reverse( arrHilb );
    
    showTime( arrTime );
    
    double[ ] expected = {
    1., 1., 1., 1.
    };
    assertArray( expected, arrTime, delta );
    
  }
  
  @Test
  public void testFastBasicTransformForwardHaar02ArrayLong( ) throws JWaveException {
    
    System.out.println( "" );
    System.out.println( "testFastBasicTransformForwardHaar02Array" );
    
    double delta = 1.e-12;
    
    double[ ] arrTime = { // array of length 64
    1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1.
    };
    
    showTime( arrTime );
    
    Transform t = new Transform( new FastWaveletTransform( new Haar02( ) ) );
    double[ ] arrHilb = t.forward( arrTime );
    
    showHilb( arrHilb );
    
    double[ ] expected = { // array of length 64
    8., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0.
    }; // orthonormal Hilbert space
    assertArray( expected, arrHilb, delta );
    
  }
  
  @Test
  public void testFastBasicTransformReverseHaar02ArrayLong( ) throws JWaveException {
    
    System.out.println( "" );
    System.out.println( "testFastBasicTransformReverseHaar02Array" );
    
    double delta = 1e-12;
    
    double[ ] arrHilb = {  // array of length 64
    8., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0.
    }; // orthonormal Hilbert space
    
    showHilb( arrHilb );
    
    Transform t = new Transform( new FastWaveletTransform( new Haar02( ) ) );
    double[ ] arrTime = t.reverse( arrHilb );
    
    showTime( arrTime );
    
    double[ ] expected = {  // array of length 64
    1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1.
    
    };
    assertArray( expected, arrTime, delta );
    
  }
  
  /**
   * Test method for {@link math.jwave.Transform#forward(double[])}.
   * @throws JWaveException 
   */
  @Test
  public void testFastBasicTransformForwardHaar02ArrayRandom( ) throws JWaveException {
    
    System.out.println( "" );
    System.out.println( "testFastBasicTransformForwardHaar02ArrayRandom" );
    
    double delta = 1.e-12;
    
    double[ ] arrTime = {
    1.2, 2.3, 3.4, 4.5, 5.4, 4.3, 3.2, 2.1
    };
    
    showTime( arrTime );
    
    Transform t = new Transform( new FastWaveletTransform( new Haar02( ) ) );
    double[ ] arrHilb = t.forward( arrTime );
    
    showHilb( arrHilb );
    
    double[ ] expected = {
    9.333809511662427, -1.2727922061357857, -2.1999999999999997, 2.2, -0.7778174593052021, -0.7778174593052025, 0.7778174593052025, 0.7778174593052023
    }; // orthonormal Hilbert space
    assertArray( expected, arrHilb, delta );
    
  }
  
  /**
   * Test method for {@link math.jwave.Transform#reverse(double[])}.
   * @throws JWaveException 
   */
  @Test
  public void testFastBasicTransformReverseHaar02ArrayRandom( ) throws JWaveException {
    
    System.out.println( "" );
    System.out.println( "testFastBasicTransformReverseHaar02ArrayRandom" );
    
    double delta = 1e-12;
    
    double[ ] arrHilb = {
    9.333809511662427, -1.2727922061357857, -2.1999999999999997, 2.2, -0.7778174593052021, -0.7778174593052025, 0.7778174593052025, 0.7778174593052023
    }; // orthonormal Hilbert space
    
    showHilb( arrHilb );
    
    Transform t = new Transform( new FastWaveletTransform( new Haar02( ) ) );
    double[ ] arrTime = t.reverse( arrHilb );
    
    showTime( arrTime );
    
    double[ ] expected = {
    1.2, 2.3, 3.4, 4.5, 5.4, 4.3, 3.2, 2.1
    };
    assertArray( expected, arrTime, delta );
    
  }
  
  /**
   * Test method for {@link math.jwave.Transform#forward(double[][])}.
   * @throws JWaveException 
   */
  @Test
  public void testFastBasicTransformForwardHaar02Matrix( ) throws JWaveException {
    
    System.out.println( "" );
    System.out.println( "testFastBasicTransformForwardHaar02Matrix" );
    
    double delta = 1.e-12;
    
    double[ ][ ] matrixTime = {
    {
    1., 1., 1., 1.
    }, {
    1., 1., 1., 1.
    }, {
    1., 1., 1., 1.
    }, {
    1., 1., 1., 1.
    }
    };
    
    showTime( matrixTime );
    
    Transform t = new Transform( new FastWaveletTransform( new Haar02( ) ) );
    double[ ][ ] matrixHilb = t.forward( matrixTime );
    
    showHilb( matrixHilb );
    
    double[ ][ ] expected = {
    {
    4., 0., 0., 0.
    }, {
    0., 0., 0., 0.
    }, {
    0., 0., 0., 0.
    }, {
    0., 0., 0., 0.
    }
    };
    assertMatrix( expected, matrixHilb, delta );
    
  }
  
  /**
   * Test method for {@link math.jwave.Transform#reverse(double[][])}.
   * @throws JWaveException 
   */
  @Test
  public void testFastBasicTransformReverseHaar02Matrix( ) throws JWaveException {
    
    System.out.println( "" );
    System.out.println( "testFastBasicTransformReverseHaar02Matrix" );
    
    double delta = 1.e-12;
    
    double[ ][ ] matrixHilb = {
    {
    4., 0., 0., 0.
    }, {
    0., 0., 0., 0.
    }, {
    0., 0., 0., 0.
    }, {
    0., 0., 0., 0.
    }
    };
    
    showHilb( matrixHilb );
    
    Transform t = new Transform( new FastWaveletTransform( new Haar02( ) ) );
    double[ ][ ] matrixTime = t.reverse( matrixHilb );
    
    showTime( matrixTime );
    
    double[ ][ ] expected = {
    {
    1., 1., 1., 1.
    }, {
    1., 1., 1., 1.
    }, {
    1., 1., 1., 1.
    }, {
    1., 1., 1., 1.
    }
    };
    assertMatrix( expected, matrixTime, delta );
    
  }
  
  /**
   * Test method for {@link math.jwave.Transform#forward(double[][][])}.
   * @throws JWaveException 
   */
  @Test
  public void testFastBasicTransformForwardHaar02Space( ) throws JWaveException {
    
    System.out.println( "" );
    System.out.println( "testFastBasicTransformForwardHaar02Space" );
    
    double delta = 1.e-12;
    
    double[ ][ ][ ] spaceTime = {
    {
    {
    1., 1., 1., 1.
    }, {
    1., 1., 1., 1.
    }, {
    1., 1., 1., 1.
    }, {
    1., 1., 1., 1.
    }
    }, {
    {
    1., 1., 1., 1.
    }, {
    1., 1., 1., 1.
    }, {
    1., 1., 1., 1.
    }, {
    1., 1., 1., 1.
    }
    }, {
    {
    1., 1., 1., 1.
    }, {
    1., 1., 1., 1.
    }, {
    1., 1., 1., 1.
    }, {
    1., 1., 1., 1.
    }
    }, {
    {
    1., 1., 1., 1.
    }, {
    1., 1., 1., 1.
    }, {
    1., 1., 1., 1.
    }, {
    1., 1., 1., 1.
    }
    }
    };
    
    showTime( spaceTime );
    
    Transform t = new Transform( new FastWaveletTransform( new Haar02( ) ) );
    double[ ][ ][ ] spaceHilb = t.forward( spaceTime );
    
    showHilb( spaceHilb );
    
    double[ ][ ][ ] expected = {
    {
    {
    8., 0., 0., 0.
    }, {
    0., 0., 0., 0.
    }, {
    0., 0., 0., 0.
    }, {
    0., 0., 0., 0.
    }
    }, {
    {
    0., 0., 0., 0.
    }, {
    0., 0., 0., 0.
    }, {
    0., 0., 0., 0.
    }, {
    0., 0., 0., 0.
    }
    }, {
    {
    0., 0., 0., 0.
    }, {
    0., 0., 0., 0.
    }, {
    0., 0., 0., 0.
    }, {
    0., 0., 0., 0.
    }
    }, {
    {
    0., 0., 0., 0.
    }, {
    0., 0., 0., 0.
    }, {
    0., 0., 0., 0.
    }, {
    0., 0., 0., 0.
    }
    }
    };
    assertSpace( expected, spaceHilb, delta );
    
  }
  
  /**
   * Test method for {@link math.jwave.Transform#reverse(double[][][])}.
   * @throws JWaveException 
   */
  @Test
  public void testFastBasicTransformReverseHaar02Space( ) throws JWaveException {
    
    System.out.println( "" );
    System.out.println( "testFastBasicTransformReverseHaar02Space" );
    
    double delta = 1.e-12;
    
    double[ ][ ][ ] spaceHilb = {
    {
    {
    8., 0., 0., 0.
    }, {
    0., 0., 0., 0.
    }, {
    0., 0., 0., 0.
    }, {
    0., 0., 0., 0.
    }
    }, {
    {
    0., 0., 0., 0.
    }, {
    0., 0., 0., 0.
    }, {
    0., 0., 0., 0.
    }, {
    0., 0., 0., 0.
    }
    }, {
    {
    0., 0., 0., 0.
    }, {
    0., 0., 0., 0.
    }, {
    0., 0., 0., 0.
    }, {
    0., 0., 0., 0.
    }
    }, {
    {
    0., 0., 0., 0.
    }, {
    0., 0., 0., 0.
    }, {
    0., 0., 0., 0.
    }, {
    0., 0., 0., 0.
    }
    }
    };
    
    showHilb( spaceHilb );
    
    Transform t = new Transform( new FastWaveletTransform( new Haar02( ) ) );
    double[ ][ ][ ] spaceTime = t.reverse( spaceHilb );
    
    showTime( spaceTime );
    
    double[ ][ ][ ] expected = {
    {
    {
    1., 1., 1., 1.
    }, {
    1., 1., 1., 1.
    }, {
    1., 1., 1., 1.
    }, {
    1., 1., 1., 1.
    }
    }, {
    {
    1., 1., 1., 1.
    }, {
    1., 1., 1., 1.
    }, {
    1., 1., 1., 1.
    }, {
    1., 1., 1., 1.
    }
    }, {
    {
    1., 1., 1., 1.
    }, {
    1., 1., 1., 1.
    }, {
    1., 1., 1., 1.
    }, {
    1., 1., 1., 1.
    }
    }, {
    {
    1., 1., 1., 1.
    }, {
    1., 1., 1., 1.
    }, {
    1., 1., 1., 1.
    }, {
    1., 1., 1., 1.
    }
    }
    };
    
    assertSpace( expected, spaceTime, delta );
    
  }
  
  /**
   * Test method for {@link math.jwave.Transform#forward(double[])}.
   * @throws JWaveException 
   */
  @Test
  public void testFastBasicTransformForwardHaar02OrthogonalArray( ) throws JWaveException {
    
    System.out.println( "" );
    System.out.println( "testFastBasicTransformForwardHaar02OrthogonalArray" );
    
    double delta = 1.e-12;
    
    double[ ] arrTime = {
    1., 1., 1., 1.
    };
    
    showTime( arrTime );
    
    Transform t = new Transform( new FastWaveletTransform( new Haar02Orthogonal( ) ) );
    double[ ] arrHilb = t.forward( arrTime );
    
    showHilb( arrHilb );
    
    double[ ] expected = {
    4., 0., 0., 0.
    }; // see the orthonormal version above
    assertArray( expected, arrHilb, delta );
    
  }
  
  /**
   * Test method for {@link math.jwave.Transform#reverse(double[])}.
   * @throws JWaveException 
   */
  @Test
  public void testFastBasicTransformReverseHaar02OrthogonalArray( ) throws JWaveException {
    
    System.out.println( "" );
    System.out.println( "testFastBasicTransformReverseHaar02OrthogonalArray" );
    
    double delta = 1e-12;
    
    double[ ] arrHilb = {
    4., 0., 0., 0.
    }; // see the orthonormal version above
    
    showHilb( arrHilb );
    
    Transform t = new Transform( new FastWaveletTransform( new Haar02Orthogonal( ) ) );
    double[ ] arrTime = t.reverse( arrHilb );
    
    showTime( arrTime );
    
    double[ ] expected = {
    1., 1., 1., 1.
    };
    assertArray( expected, arrTime, delta );
    
  }
  
  /**
   * Test method for {@link math.jwave.Transform#forward(double[])}.
   * @throws JWaveException 
   */
  @Test
  public void testFastBasicTransformForwardLege02Array( ) throws JWaveException {
    
    System.out.println( "" );
    System.out.println( "testFastBasicTransformForwardLege02Array" );
    
    double delta = 1.e-12;
    
    double[ ] arrTime = {
    1., 1., 1., 1.
    };
    
    showTime( arrTime );
    
    Transform t = new Transform( new FastWaveletTransform( new Lege02( ) ) );
    double[ ] arrHilb = t.forward( arrTime );
    
    showHilb( arrHilb );
    
    double[ ] expected = {
    2., 0., 0., 0.
    }; // orthonormal Hilbert space
    assertArray( expected, arrHilb, delta );
    
  }
  
  /**
   * Test method for {@link math.jwave.Transform#reverse(double[])}.
   * @throws JWaveException 
   */
  @Test
  public void testFastBasicTransformReverseLege02Array( ) throws JWaveException {
    
    System.out.println( "" );
    System.out.println( "testFastBasicTransformReverseLege02Array" );
    
    double delta = 1e-12;
    
    double[ ] arrHilb = {
    2., 0., 0., 0.
    }; // orthonormal Hilbert space
    
    showHilb( arrHilb );
    
    Transform t = new Transform( new FastWaveletTransform( new Lege02( ) ) );
    double[ ] arrTime = t.reverse( arrHilb );
    
    showTime( arrTime );
    
    double[ ] expected = {
    1., 1., 1., 1.
    };
    assertArray( expected, arrTime, delta );
    
  }
  
  /**
   * Test method for {@link math.jwave.Transform#forward(double[])}.
   * @throws JWaveException 
   */
  @Test
  public void testFastBasicTransformForwardDaub04Array( ) throws JWaveException {
    
    System.out.println( "" );
    System.out.println( "testFastBasicTransformForwardDaub04Array" );
    
    double delta = 1.e-12;
    
    double[ ] arrTime = {
    1., 1., 1., 1., 1., 1., 1., 1.
    };
    
    showTime( arrTime );
    
    Transform t = new Transform( new FastWaveletTransform( new Daub02( ) ) );
    double[ ] arrHilb = t.forward( arrTime );
    
    showHilb( arrHilb );
    
    double[ ] expected = {
    2., 2., 0., 0., 0., 0., 0., 0.
    };
    assertArray( expected, arrHilb, delta );
    
  }
  
  /**
   * Test method for {@link math.jwave.Transform#reverse(double[])}.
   * @throws JWaveException 
   */
  @Test
  public void testFastBasicTransformReverseDaub04Array( ) throws JWaveException {
    
    System.out.println( "" );
    System.out.println( "testFastBasicTransformReverseDaub04Array" );
    
    double delta = 1.e-12;
    
    double[ ] arrHilb = {
    2., 2., 0., 0., 0., 0., 0., 0.
    };
    
    showHilb( arrHilb );
    
    Transform t = new Transform( new FastWaveletTransform( new Daub02( ) ) );
    double[ ] arrTime = t.reverse( arrHilb );
    
    showTime( arrTime );
    
    double[ ] expected = {
    1., 1., 1., 1., 1., 1., 1., 1.
    };
    assertArray( expected, arrTime, delta );
    
  }
  
  /**
   * Test method for {@link math.jwave.Transform#forward(double[])}.
   * @throws JWaveException 
   */
  @Test
  public void testFastBasicTransformForwardLege04Array( ) throws JWaveException {
    
    System.out.println( "" );
    System.out.println( "testFastBasicTransformForwardLege04Array" );
    
    double delta = 1.e-12;
    
    double[ ] arrTime = {
    1., 1., 1., 1., 1., 1., 1., 1.
    };
    
    showTime( arrTime );
    
    Transform t = new Transform( new FastWaveletTransform( new Lege04( ) ) );
    double[ ] arrHilb = t.forward( arrTime );
    
    showHilb( arrHilb );
    
    double[ ] expected = {
    2., 2., 0., 0., 0., 0., 0., 0.
    };
    assertArray( expected, arrHilb, delta );
    
  }
  
  /**
   * Test method for {@link math.jwave.Transform#reverse(double[])}.
   * @throws JWaveException 
   */
  @Test
  public void testFastBasicTransformReverseLege04Array( ) throws JWaveException {
    
    System.out.println( "" );
    System.out.println( "testFastBasicTransformReverseLege04Array" );
    
    double delta = 1.e-12;
    
    double[ ] arrHilb = {
    2., 2., 0., 0., 0., 0., 0., 0.
    };
    
    showHilb( arrHilb );
    
    Transform t = new Transform( new FastWaveletTransform( new Lege04( ) ) );
    double[ ] arrTime = t.reverse( arrHilb );
    
    showTime( arrTime );
    
    double[ ] expected = {
    1., 1., 1., 1., 1., 1., 1., 1.
    };
    assertArray( expected, arrTime, delta );
    
  }
  
  /**
   * Test method for {@link math.jwave.Transform#forward(double[])}.
   * @throws JWaveException 
   */
  @Test
  public void testFastBasicTransformForwardDaub06Array( ) throws JWaveException {
    
    System.out.println( "" );
    System.out.println( "testFastBasicTransformForwardDaub06Array" );
    
    double delta = 1.e-12;
    
    double[ ] arrTime = {
    1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1.
    };
    
    showTime( arrTime );
    
    Transform t = new Transform( new FastWaveletTransform( new Daub03( ) ) );
    double[ ] arrHilb = t.forward( arrTime );
    
    showHilb( arrHilb );
    
    double[ ] expected = {
    2., 2., 2., 0., 0., 0., 0., 0., 0., 0., 0., 0.
    };
    assertArray( expected, arrHilb, delta );
    
  }
  
  /**
   * Test method for {@link math.jwave.Transform#reverse(double[])}.
   * @throws JWaveException 
   */
  @Test
  public void testFastBasicTransformReverseDaub06Array( ) throws JWaveException {
    
    System.out.println( "" );
    System.out.println( "testFastBasicTransformReverseDaub06Array" );
    
    double delta = 1.e-12;
    
    double[ ] arrHilb = {
    2., 2., 2., 0., 0., 0., 0., 0., 0., 0., 0., 0.
    };
    
    showHilb( arrHilb );
    
    Transform t = new Transform( new FastWaveletTransform( new Daub03( ) ) );
    double[ ] arrTime = t.reverse( arrHilb );
    
    showTime( arrTime );
    
    double[ ] expected = {
    1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1.
    };
    assertArray( expected, arrTime, delta );
    
  }
  
  /**
   * Test method for {@link math.jwave.Transform#forward(double[])}.
   * @throws JWaveException 
   */
  @Test
  public void testFastBasicTransformForwardLege06Array( ) throws JWaveException {
    
    System.out.println( "" );
    System.out.println( "testFastBasicTransformForwardLege06Array" );
    
    double delta = 1.e-12;
    
    double[ ] arrTime = {
    1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1.
    };
    
    showTime( arrTime );
    
    Transform t = new Transform( new FastWaveletTransform( new Lege06( ) ) );
    double[ ] arrHilb = t.forward( arrTime );
    
    showHilb( arrHilb );
    
    double[ ] expected = {
    2., 2., 2., 0., 0., 0., 0., 0., 0., 0., 0., 0.
    };
    assertArray( expected, arrHilb, delta );
    
  }
  
  /**
   * Test method for {@link math.jwave.Transform#reverse(double[])}.
   * @throws JWaveException 
   */
  @Test
  public void testFastBasicTransformReverseLege06Array( ) throws JWaveException {
    
    System.out.println( "" );
    System.out.println( "testFastBasicTransformReverseLege06Array" );
    
    double delta = 1.e-12;
    
    double[ ] arrHilb = {
    2., 2., 2., 0., 0., 0., 0., 0., 0., 0., 0., 0.
    };
    
    showHilb( arrHilb );
    
    Transform t = new Transform( new FastWaveletTransform( new Lege06( ) ) );
    double[ ] arrTime = t.reverse( arrHilb );
    
    showTime( arrTime );
    
    double[ ] expected = {
    1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1.
    };
    assertArray( expected, arrTime, delta );
    
  }
  
  /**
   * Test method for {@link math.jwave.Transform#forward(double[])}.
   * @throws JWaveException 
   */
  @Test
  public void testFastBasicTransformForwardCoif06Array( ) throws JWaveException {
    
    System.out.println( "" );
    System.out.println( "testFastBasicTransformForwardCoif06Array" );
    
    double delta = 1.e-12;
    
    double[ ] arrTime = {
    1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1.
    };
    
    showTime( arrTime );
    
    Transform t = new Transform( new FastWaveletTransform( new Coif06( ) ) );
    double[ ] arrHilb = t.forward( arrTime );
    
    showHilb( arrHilb );
    
    double[ ] expected = {
    2., 2., 2., 0., 0., 0., 0., 0., 0., 0., 0., 0.
    };
    assertArray( expected, arrHilb, delta );
    
  }
  
  /**
   * Test method for {@link math.jwave.Transform#reverse(double[])}.
   * @throws JWaveException 
   */
  @Test
  public void testFastBasicTransformReverseCoif06Array( ) throws JWaveException {
    
    System.out.println( "" );
    System.out.println( "testFastBasicTransformReverseCoif06Array" );
    
    double delta = 1.e-12;
    
    double[ ] arrHilb = {
    2., 2., 2., 0., 0., 0., 0., 0., 0., 0., 0., 0.
    };
    
    showHilb( arrHilb );
    
    Transform t = new Transform( new FastWaveletTransform( new Coif06( ) ) );
    double[ ] arrTime = t.reverse( arrHilb );
    
    showTime( arrTime );
    
    double[ ] expected = {
    1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1.
    };
    assertArray( expected, arrTime, delta );
    
  }
  
  /**
   * Test method for {@link math.jwave.Transform#forward(double[])}.
   * @throws JWaveException 
   */
  @Test
  public void testFastBasicTransformForwardDaub08Array( ) throws JWaveException {
    
    System.out.println( "" );
    System.out.println( "testFastBasicTransformForwardDaub08Array" );
    
    double delta = 1.e-3;
    
    double[ ] arrTime = {
    1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1.
    };
    
    showTime( arrTime );
    
    Transform t = new Transform( new FastWaveletTransform( new Daub04( ) ) );
    double[ ] arrHilb = t.forward( arrTime );
    
    showHilb( arrHilb );
    
    double[ ] expected = {
    2., 2., 2., 2., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0.
    };
    assertArray( expected, arrHilb, delta );
    
  }
  
  /**
   * Test method for {@link math.jwave.Transform#reverse(double[])}.
   * @throws JWaveException 
   */
  @Test
  public void testFastBasicTransformReverseDaub08Array( ) throws JWaveException {
    
    System.out.println( "" );
    System.out.println( "testFastBasicTransformReverseDaub08Array" );
    
    double delta = 1.e-3;
    
    double[ ] arrHilb = {
    2., 2., 2., 2., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0., 0.
    };
    
    showHilb( arrHilb );
    
    Transform t = new Transform( new FastWaveletTransform( new Daub04( ) ) );
    double[ ] arrTime = t.reverse( arrHilb );
    
    showTime( arrTime );
    
    double[ ] expected = {
    1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1., 1.
    };
    assertArray( expected, arrTime, delta );
    
  }
  
  /**
   * Test method for {@link math.jwave.Transform#forward(double[])}.
   * @throws JWaveException 
   */
  @Test
  public void testFastBasicTransformForwardHaar02ArraySteps( ) throws JWaveException {
    
    System.out.println( "" );
    System.out.println( "testFastBasicTransformForwardHaar02Array" );
    
    double delta = 1.e-12;
    
    double[ ] arrTime = {
    1., 1., 1., 1.
    };
    
    showTime( arrTime );
    
    Transform t = new Transform( new FastWaveletTransform( new Haar02( ), 1 ) );
    double[ ] arrHilb = t.forward( arrTime );
    
    showHilb( arrHilb );
    
    double[ ] expected = {
    Math.sqrt( 2. ), Math.sqrt( 2. ), 0., 0.
    }; // orthonormal Hilbert space
    assertArray( expected, arrHilb, delta );
    
  }
  
  /**
   * Test method for {@link math.jwave.Transform#reverse(double[])}.
   * @throws JWaveException 
   */
  @Test
  public void testFastBasicTransformReverseHaar02ArraySteps( ) throws JWaveException {
    
    System.out.println( "" );
    System.out.println( "testFastBasicTransformReverseHaar02Array" );
    
    double delta = 1e-12;
    
    double[ ] arrHilb = {
    2., 0, 0., 0.
    }; // orthonormal Hilbert space
    
    showHilb( arrHilb );
    
    Transform t = new Transform( new FastWaveletTransform( new Haar02( ), 1 ) );
    double[ ] arrTime = t.reverse( arrHilb );
    
    showTime( arrTime );
    
    double sqrt2 = Math.sqrt( 2. );
    
    double[ ] expected = {
    sqrt2, sqrt2, 0., 0.
    };
    assertArray( expected, arrTime, delta );
    
  }
  
}
