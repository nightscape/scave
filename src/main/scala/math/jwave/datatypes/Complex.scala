package math.jwave.datatypes

/**
 * A class to represent a Complex Number. A Complex object is immutable once
 * created; the add, subtract and multiply routines return newly-created Complex
 * objects containing each requested result.
 *
 * @date 19.11.2010 13:20:48
 * @author Christian Scheiblich
 */
class Complex {

  /**
   * The real number.
   */
  private var _r: Double = 0.

  /**
   * The imaginary number.
   */
  private var _j: Double = 0.

  /**
   * Copy constructor.
   *
   * @date 19.11.2010 13:22:54
   * @author Christian Scheiblich
   * @param c
   *          complex number
   */
  def this(c: Complex) {
    this()
    _r = c._r
    _j = c._j
  }

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
  def this(r: Double, j: Double) {
    this()
    _r = r
    _j = j
  }

  /**
   * Display the current Complex as a String, for usage in println( ) and
   * elsewhere.
   *
   * @date 19.11.2010 13:23:13
   * @author Christian Scheiblich
   */
  override def toString(): String = {
    val sb = new StringBuffer().append(_r)
    if (_j > 0) sb.append('+')
    sb.append(_j).append('j').toString
  }

  /**
   * Return the real number.
   *
   * @date 19.11.2010 13:23:34
   * @author Christian Scheiblich
   * @return real number of this complex number
   */
  def getReal(): Double = _r

  /**
   * Return the imaginary number.
   *
   * @date 19.11.2010 13:23:51
   * @author Christian Scheiblich
   * @return imaginary number of this complex number
   */
  def getImag(): Double = _j

  /**
   * Set the real number.
   *
   * @date 23.11.2010 18:44:52
   * @author Christian Scheiblich
   * @param r
   *          the real number
   */
  def setReal(r: Double) {
    _r = r
  }

  /**
   * Set the imaginary number.
   *
   * @date 23.11.2010 18:45:16
   * @author Christian Scheiblich
   * @param j
   *          the imaginary number
   */
  def setImag(j: Double) {
    _j = j
  }

  /**
   * Add to real number.
   *
   * @date 23.11.2010 18:49:57
   * @author Christian Scheiblich
   * @param r
   *          the real number
   */
  def addReal(r: Double) {
    _r += r
  }

  /**
   * Add to imaginary number.
   *
   * @date 23.11.2010 18:50:23
   * @author Christian Scheiblich
   * @param j
   *          the imaginary number
   */
  def addImag(j: Double) {
    _j += j
  }

  /**
   * multiply scalar to real number.
   *
   * @date 23.11.2010 18:53:27
   * @author Christian Scheiblich
   * @param s
   *          scalar
   */
  def mulReal(s: Double) {
    _r *= s
  }

  /**
   * multiply scalar to imaginary number.
   *
   * @date 23.11.2010 18:54:48
   * @author Christian Scheiblich
   * @param s
   *          scalar
   */
  def mulImag(s: Double) {
    _j *= s
  }

  /**
   * Calculate the magnitude of the complex number.
   *
   * @date 19.11.2010 13:24:28
   * @author Christian Scheiblich
   * @return magnitude of this complex number
   */
  def getMag(): Double = Math.sqrt(_r * _r + _j * _j)

  /**
   * Calculates the angle phi of a complex number.
   *
   * @date 19.11.2010 13:24:48
   * @author Christian Scheiblich
   * @return angle of this complex number
   */
  def getPhi(): Double = {
    if (_r == 0. && _j == 0) return 0.
    val phi = Math.toDegrees(Math.atan(Math.abs(_j / _r)))
    if (_r >= 0. && _j >= 0.) return phi
    if (_r <= 0. && _j >= 0.) return 180. - phi
    if (_r <= 0. && _j <= 0.) return phi + 180.
    if (_r >= 0. && _j <= 0.) return 360. - phi
    Math.toDegrees(Math.atan(Math.abs(_j / _r)))
  }

  /**
   * Returns the stored values as new double array: [ real, imag ].
   *
   * @date 19.11.2010 13:25:38
   * @author Christian Scheiblich
   * @return returns stored values as array [ real, imag ]
   */
  def toArr(): Array[Double] = {
    val arr = Array(_r, _j)
    arr
  }

  /**
   * Returns the conjugate complex number of this complex number.
   *
   * @date 19.11.2010 19:36:52
   * @author Thomas Leduc
   * @return new object of Complex keeping the result
   */
  def conjugate(): Complex = new Complex(_r, -_j)

  /**
   * Add another complex number to this one and return.
   *
   * @date 19.11.2010 13:25:55
   * @author Christian Scheiblich
   * @param c
   *          complex number
   * @return new object of Complex keeping the result
   */
  def add(c: Complex): Complex = new Complex(_r + c._r, _j + c._j)

  /**
   * Subtract another complex number from this one.
   *
   * @date 19.11.2010 13:27:05
   * @author Christian Scheiblich
   * @param c
   *          complex number
   * @return new object of Complex keeping the result
   */
  def sub(c: Complex): Complex = new Complex(_r - c._r, _j - c._j)

  /**
   * Multiply this complex number times another one.
   *
   * @date 19.11.2010 13:27:36
   * @author Christian Scheiblich
   * @param c
   *          complex number
   * @return new object of Complex keeping the result
   */
  def mul(c: Complex): Complex = {
    new Complex(_r * c._r - _j * c._j, _r * c._j + _j * c._r)
  }

  /**
   * Multiply this complex number times a scalar.
   *
   * @date 19.11.2010 13:28:03
   * @author Christian Scheiblich
   * @param s
   *          scalar
   * @return new object of Complex keeping the result
   */
  def mul(s: Double): Complex = new Complex(_r * s, _j * s)

  /**
   * Divide this complex number by another one.
   *
   * @date 19.11.2010 19:45:02
   * @author Thomas Leduc
   * @param c
   *          complex number
   * @return new object of Complex keeping the result
   */
  def div(c: Complex): Complex = {
    mul(c.conjugate()).div(c._r * c._r + c._j * c._j)
  }

  /**
   * Divide this complex number by a scalar.
   *
   * @date 19.11.2010 13:29:49
   * @author Thomas Leduc
   * @param s
   *          scalar
   * @return new object of Complex keeping the result
   */
  def div(s: Double): Complex = mul(1. / s)

  /**
   * Generates a hash code for this object.
   *
   * @date 19.11.2010 19:42:39
   * @author Thomas Leduc
   * @see java.lang.Object#hashCode()
   */
  override def hashCode(): Int = {
    val prime = 31
    var result = 1
    var temp: Long = 0l
    temp = _j.toLong
    result = prime * result + (temp ^ (temp >>> 32)).toInt
    temp = _r.toLong
    result = prime * result + (temp ^ (temp >>> 32)).toInt
    result
  }

  /**
   * Compare this Complex number with another one.
   *
   * @date 19.11.2010 13:30:35
   * @author Thomas Leduc
   * @see java.lang.Object#equals(java.lang.Object)
   */
  override def equals(obj: Any): Boolean = {
    if (obj == null) return false
    if (getClass != obj.getClass) return false
    val other = obj.asInstanceOf[Complex]
    if (_j != other._j) return false
    if (_r != other._r) return false
    true
  }

  /**
   * Print this complex number to console.
   *
   * @date 19.11.2010 13:31:16
   * @author Christian Scheiblich
   */
  def show() {
    if (_j < 0) println(getReal + " - j" + Math.abs(getImag)) else println(getReal + " + j" + getImag)
  }

  /**
   * Print this complex number to console with an identifier before.
   *
   * @date 19.11.2010 13:31:32
   * @author Christian Scheiblich
   * @param ident
   *          string to label this complex number
   */
  def show(ident: String) {
    if (_j < 0) println(ident + ": " + getReal + " - j" + Math.abs(getImag)) else println(ident + ": " + getReal + " + j" + getImag)
  }

  /**
   * Print magnitude to console out.
   *
   * @date 19.11.2010 13:32:15
   * @author Christian Scheiblich
   */
  def showMag() {
    println(getMag)
  }

  /**
   * Print angle to console out.
   *
   * @date 19.11.2010 13:32:33
   * @author Christian Scheiblich
   */
  def showPhi() {
    println(getPhi)
  }
}
