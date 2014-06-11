package math.jwave.tools

class AncientEgyptianMultiplication {

  /**
   * The method converts a positive integer to the ancient Egyptian multipliers
   * which are actually the multipliers to display the number by a sum of the
   * largest possible powers of two. E.g. 42 = 2^5 + 2^3 + 2^1 = 32 + 8 + 2.0
   * However, odd numbers always 2^0 = 1 as the last entry. Also see:
   * http://en.wikipedia.org/wiki/Ancient_Egyptian_multiplication
   *
   * @param number
   * @return
   * @throws JWaveException
   */
  def decompose(number: Int): Array[Int] = {
    require(number >= 1, "the supported number for decomposition is smaller than one")
    var power = getExponent(number.toDouble)
    val tmpArr = Array.ofDim[Int](power + 1)
    var pos = 0
    var current = number.toDouble
    while (current >= 1.0) {
      power = getExponent(current)
      tmpArr(pos) = power
      current = current - scalb(1.0, power)
      pos += 1
    }
    val ancientEgyptianMultipliers = Array.ofDim[Int](pos)
    for (c <- 0 until pos) ancientEgyptianMultipliers(c) = tmpArr(c)
    ancientEgyptianMultipliers
  }

  /**
   * The method converts a list of ancient Egyptian multipliers to the
   * corresponding integer. The ancient Egyptian multipliers are actually the
   * multipliers to display am integer by a sum of the largest possible powers
   * of two. E.g. 42 = 2^5 + 2^3 + 2^1 = 32 + 8 + 2.0 Also see:
   * http://en.wikipedia.org/wiki/Ancient_Egyptian_multiplication
   *
   * @author Christian Scheiblich
   * date Feb 11, 2013 1:55:54 PM
   *
   * @param ancientEgyptianMultipliers
   *  an integer array keeping the ancient Egyptian multipliers
   * @return resulting integer as sum of powers of two
   * @throws JWaveException
   */
  def compose(ancientEgyptianMultipliers: Array[Int]): Int = {
    require(ancientEgyptianMultipliers != null, "given array is null")
    var number = 0
    val noOfAncientEgyptianMultipliers = ancientEgyptianMultipliers.length
    for (m <- 0 until noOfAncientEgyptianMultipliers) {
      val ancientEgyptianMultiplier = ancientEgyptianMultipliers(m)
      number += scalb(1.0, ancientEgyptianMultiplier).toInt
    }
    number
  }

  /**
   * Replaced Math.getExponent due to google's Android OS is not
   * supporting it in Math library.
   *
   * @author Christian Scheiblich
   * date Feb 11, 2013 1:47:05 PM
   *
   * @author sashi
   * @date 19.04.2011 15:43:16
   *
   * @param f
   * @return p of 2^p <= f < 2^(p+1)
   */
  def getExponent(f: Double): Int = {
    val exp = (Math.log(f) / Math.log(2)).toInt
    exp
  }

  /**
   * Replaced Math.scalb due to google's Android OS is not supporting
   * it in Math library.
   *
   * @author Christian Scheiblich
   * date Feb 11, 2013 1:46:33 PM
   *
   * @param f
   * @param scaleFactor
   * @return f times 2^(scaleFactor)
   */
  def scalb(f: Double, scaleFactor: Int): Double = {
    val res = f * Math.pow(2, scaleFactor)
    res
  }
}
