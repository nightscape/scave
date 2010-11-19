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
 * This file Complex2d.java is part of JWave.
 *
 * @author Christian Scheiblich
 * date 19.11.2010 13:20:28
 * contact source@linux23.de
 */
package cs.jwave.types;

/**
 * A class to represent a Complex Number. A Complex object is immutable once
 * created; the add, subtract and multiply routines return newly-created Complex
 * objects containing each requested result.
 * 
 * @date 19.11.2010 13:20:48
 * @author Christian Scheiblich
 */
public class Complex2d {

  /**
   * The real number
   */
  private double _r;

  /**
   * The imaginary number
   */
  private double _j;

  /**
   * Standard constructor.
   * 
   * @date 19.11.2010 13:38:56
   * @author Christian Scheiblich
   */
  public Complex2d( ) {
    _r = 0.;
    _j = 0.;
  } // Complex

  /**
   * Copy constructor.
   * 
   * @date 19.11.2010 13:22:54
   * @author Christian Scheiblich
   * @param c
   *          complex number
   */
  public Complex2d( Complex2d c ) {
    _r = c._r;
    _j = c._j;
  } // Complex2d

  /**
   * Constructor taking real and imaginary number.
   * 
   * @date 19.11.2010 13:21:48
   * @author Christian Scheiblich
   * @param r
   *          real number
   * @param j
   *          imaginary number
   */
  public Complex2d( double r, double j ) {
    _r = r;
    _j = j;
  } // Complex

  /**
   * Display the current Complex as a String, for use in println( ) and
   * elsewhere.
   * 
   * @date 19.11.2010 13:23:13
   * @author Christian Scheiblich
   */
  @Override
  public String toString( ) {
    StringBuffer sb = new StringBuffer( ).append( _r );
    if( _j > 0 )
      sb.append( '+' ); // else append(i) appends - sign
    return sb.append( _j ).append( 'j' ).toString( );
  } // toString

  /**
   * Return the real number.
   * 
   * @date 19.11.2010 13:23:34
   * @author Christian Scheiblich
   * @return real number of this complex number
   */
  public double getReal( ) {
    return _r;
  } // getReal( )

  /**
   * Return the imaginary number.
   * 
   * @date 19.11.2010 13:23:51
   * @author Christian Scheiblich
   * @return imaginary number of this complex number
   */
  public double getImag( ) {
    return _j;
  } // getImag

  /**
   * Calculate the magnitude of the complex number
   * 
   * @date 19.11.2010 13:24:28
   * @author Christian Scheiblich
   * @return magnitude of this complex number
   */
  public double getMag( ) {
    return Math.sqrt( _r * _r + _j * _j );
  } // getMag( )

  /**
   * Calculates the angle phi of a complex number.
   * 
   * @date 19.11.2010 13:24:48
   * @author Christian Scheiblich
   * @return angle of this complex number
   */
  public double getPhi( ) {
    if( _r == 0. && _j == 0 )
      return 0.;
    double phi = Math.toDegrees( Math.atan( Math.abs( _j / _r ) ) );
    if( _r >= 0. && _j >= 0. ) // 1. quadrant
      return phi;
    if( _r <= 0. && _j >= 0. ) // 2. quadrant
      return 180. - phi;
    if( _r <= 0. && _j <= 0. ) // 3. quadrant
      return phi + 180.;
    if( _r >= 0. && _j <= 0. ) // 4. quadrant
      return 360. - phi;
    return Math.toDegrees( Math.atan( Math.abs( _j / _r ) ) );
  } // getPhi( )

  /**
   * Returns the stored values as new double array: [ real, imag ]
   * 
   * @date 19.11.2010 13:25:38
   * @author Christian Scheiblich
   * @return returns stored values as array [ real, imag ]
   */
  public double[ ] toArr( ) {
    double[ ] arr = { _r, _j };
    return arr;
  } // toArr

  /**
   * Returns the conjugate complex number of this complex number
   * 
   * @date 19.11.2010 19:36:52
   * @author Thomas Leduc
   * @return new object of Complex2d keeping the result
   */
  public Complex2d conjugate( ) {
    return new Complex2d( _r, -_j );
  } // conjugate

  /**
   * Add another complex number to this one and return.
   * 
   * @date 19.11.2010 13:25:55
   * @author Christian Scheiblich
   * @param c
   *          complex number
   * @return new object of Complex2d keeping the result
   */
  public Complex2d add( Complex2d c ) {
    return new Complex2d( _r + c._r, _j + c._j );
  } // add

  /**
   * Subtract another complex number from this one.
   * 
   * @date 19.11.2010 13:27:05
   * @author Christian Scheiblich
   * @param c
   *          complex number
   * @return new object of Complex2d keeping the result
   */
  public Complex2d sub( Complex2d c ) {
    return new Complex2d( _r - c._r, _j - c._j );
  } // sub

  /**
   * Multiply this complex number times another one.
   * 
   * @date 19.11.2010 13:27:36
   * @author Christian Scheiblich
   * @param c
   *          complex number
   * @return new object of Complex2d keeping the result
   */
  public Complex2d mul( Complex2d c ) {
    return new Complex2d( _r * c._r - _j * c._j, _r * c._j + _j * c._r );
  } // mul

  /**
   * Multiply this complex number times a scalar.
   * 
   * @date 19.11.2010 13:28:03
   * @author Christian Scheiblich
   * @param s
   *          scalar
   * @return new object of Complex2d keeping the result
   */
  public Complex2d mul( double s ) {
    return new Complex2d( _r * s, _j * s );
  } // mul

  /**
   * Divide this complex number by another one.
   * 
   * @date 19.11.2010 19:45:02
   * @author Thomas Leduc
   * @param c
   *          complex number
   * @return new object of Complex2d keeping the result
   */
  public Complex2d div( Complex2d c ) {
    return mul( c.conjugate( ) ).div( c._r * c._r + c._j * c._j );
  } // div

  /**
   * Divide this complex number by a scalar.
   * 
   * @date 19.11.2010 13:29:49
   * @author Thomas Leduc
   * @param s
   *          scalar
   * @return new object of Complex2d keeping the result
   */
  public Complex2d div( double s ) {
    return mul( 1. / s );
  } // div

  /**
   * Generates a hash code for this object.
   * 
   * @date 19.11.2010 19:42:39
   * @author Thomas Leduc
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode( ) {
    final int prime = 31;
    int result = 1;
    long temp;
    temp = Double.doubleToLongBits( _j );
    result = prime * result + (int)( temp ^ ( temp >>> 32 ) );
    temp = Double.doubleToLongBits( _r );
    result = prime * result + (int)( temp ^ ( temp >>> 32 ) );
    return result;
  } // hashCode  

  /**
   * Compare this Complex number with another one.
   * 
   * @date 19.11.2010 13:30:35
   * @author Thomas Leduc
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals( Object obj ) {
    if( this == obj )
      return true;
    if( obj == null )
      return false;
    if( getClass( ) != obj.getClass( ) )
      return false;
    Complex2d other = (Complex2d)obj;
    if( Double.doubleToLongBits( _j ) != Double.doubleToLongBits( other._j ) )
      return false;
    if( Double.doubleToLongBits( _r ) != Double.doubleToLongBits( other._r ) )
      return false;
    return true;
  } // equals

  /**
   * Print this complex number to console.
   * 
   * @date 19.11.2010 13:31:16
   * @author Christian Scheiblich
   */
  public void show( ) {
    if( _j < 0 )
      System.out.println( getReal( ) + " - j" + Math.abs( getImag( ) ) );
    else
      System.out.println( getReal( ) + " + j" + getImag( ) );
  } // show

  /**
   * Print this complex number to console with an identifier before.
   * 
   * @date 19.11.2010 13:31:32
   * @author Christian Scheiblich
   * @param ident
   *          string to label this complex number
   */
  public void show( String ident ) {
    if( _j < 0 )
      System.out.println( ident + ": " + getReal( ) + " - j"
          + Math.abs( getImag( ) ) );
    else
      System.out.println( ident + ": " + getReal( ) + " + j" + getImag( ) );
  } // show

  /**
   * Print magnitude to console out.
   * 
   * @date 19.11.2010 13:32:15
   * @author Christian Scheiblich
   */
  public void showMag( ) {
    System.out.println( getMag( ) );
  } // showMag

  /**
   * Print angle to console out.
   * 
   * @date 19.11.2010 13:32:33
   * @author Christian Scheiblich
   */
  public void showPhi( ) {
    System.out.println( getPhi( ) );
  } // showPhi

} // class
