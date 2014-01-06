package math.jwave

import math.jwave.transforms.BasicTransform

/**
 * Base class for transforms like DiscreteFourierTransform,
 * FastBasicTransform, and WaveletPacketTransform.
 *
 * @date 19.05.2009 09:43:40
 * @author Christian Scheiblich
 */
class Transform(protected var _transform: BasicTransform) {
  type Complex = spire.math.Complex[Double]

  /**
   * Constructor; needs some object like DiscreteFourierTransform,
   * FastBasicTransform, WaveletPacketTransfom, ... It take also a number of iteration for decomposition
   *
   * @date 19.05.2009 09:50:24
   * @author Christian Scheiblich
   */
  def this(transform: BasicTransform, iteration: Int) {
    this(transform)
    if (transform.isInstanceOf[BasicTransform]) {
      _transform = transform
    } else {
      throw new IllegalArgumentException("Can't use transform :" + transform.getClass + " with a specific level decomposition ;" + 
        " use Transform( TransformI transform ) constructor instead.")
    }
  }

  /**
   * Performs the forward transform of the specified BasicWave object.
   *
   * @date 10.02.2010 09:41:01
   * @author Christian Scheiblich
   * @param arrTime
   *          coefficients of time domain
   * @return coefficients of frequency or Hilbert domain
   */
  def forward(arrTime: Array[Double]): Array[Double] = _transform.forward(arrTime)

  /**
   * Performs the reverse transform of the specified BasicWave object.
   *
   * @date 10.02.2010 09:42:18
   * @author Christian Scheiblich
   * @param arrFreq
   *          coefficients of frequency or Hilbert domain
   * @return coefficients of time domain
   */
  def reverse(arrFreq: Array[Double]): Array[Double] = _transform.reverse(arrFreq)

  /**
   * Performs the forward transform from time domain to frequency or Hilbert
   * domain for a given array depending on the used transform algorithm by
   * inheritance.
   *
   * @date 23.11.2010 19:19:24
   * @author Christian Scheiblich
   * @param arrTime
   *          coefficients of 1-D time domain
   * @return coefficients of 1-D frequency or Hilbert domain
   */
  def forward(arrTime: Array[Complex]): Array[Complex] = {
    _transform.asInstanceOf[BasicTransform].forward(arrTime)
  }

  /**
   * Performs the reverse transform from frequency or Hilbert domain to time
   * domain for a given array depending on the used transform algorithm by
   * inheritance.
   *
   * @date 23.11.2010 19:19:33
   * @author Christian Scheiblich
   * @param arrFreq
   *          coefficients of 1-D frequency or Hilbert domain
   * @return coefficients of 1-D time domain
   */
  def reverse(arrFreq: Array[Complex]): Array[Complex] = {
    _transform.asInstanceOf[BasicTransform].reverse(arrFreq)
  }

  /**
   * Performs the 2-D forward transform of the specified BasicWave object.
   *
   * @date 10.02.2010 10:58:54
   * @author Christian Scheiblich
   * @param matrixTime
   *          coefficients of 2-D time domain
   * @return coefficients of 2-D frequency or Hilbert domain
   */
  def forward(matrixTime: Array[Array[Double]]): Array[Array[Double]] = _transform.forward(matrixTime)

  /**
   * Performs the 2-D reverse transform of the specified BasicWave object.
   *
   * @date 10.02.2010 10:59:32
   * @author Christian Scheiblich
   * @param matrixFreq
   *          coefficients of 2-D frequency or Hilbert domain
   * @return coefficients of 2-D time domain
   */
  def reverse(matrixFreq: Array[Array[Double]]): Array[Array[Double]] = _transform.reverse(matrixFreq)

  /**
   * Performs the 3-D forward transform of the specified BasicWave object.
   *
   * @date 10.07.2010 18:15:22
   * @author Christian Scheiblich
   * @param matrixTime
   *          coefficients of 2-D time domain
   * @return coefficients of 2-D frequency or Hilbert domain
   */
  def forward(spaceTime: Array[Array[Array[Double]]]): Array[Array[Array[Double]]] = _transform.forward(spaceTime)

  /**
   * Performs the 3-D reverse transform of the specified BasicWave object.
   *
   * @date 10.07.2010 18:15:33
   * @author Christian Scheiblich
   * @param matrixFreq
   *          coefficients of 2-D frequency or Hilbert domain
   * @return coefficients of 2-D time domain
   */
  def reverse(spaceFreq: Array[Array[Array[Double]]]): Array[Array[Array[Double]]] = _transform.reverse(spaceFreq)
}
