package math.jwave.transforms.modes

/**
 * Base class to specify a transform mode: e. g. if JWave should do
 * only two steps from normal to hilbert space or from hilbert space
 * 3 steps towards normal space. Therefore, a class is necessary to
 * solve the problem that JWave can start at data of level 2 and go
 * to a level 3 which means, that the algorithm has to be started
 * in the mid of its full job and has to be stopped earlier again.
 *
 * @author Christian Scheiblich
 * date Feb 7, 2013 1:43:13 PM
 *
 */
abstract class TransformMode {

  /**
   * Storing how many steps the Algorithm should do in a later
   * configured direction.
   *
   * @author Christian Scheiblich
   * date Feb 7, 2013 1:47:41 PM
   *
   */
  protected var _steps: Int = -1

  /**
   * The ending level of the transform that can be either smaller
   * or greater as the starting level given by fromLevel integer.
   *
   * @author Christian Scheiblich
   * date Feb 7, 2013 3:05:22 PM
   *
   */
  protected var _toLevel: Int = -1

  /**
   * The starting level of the transform that can be either smaller
   * or greater as the starting level given by toLevel integer.
   *
   * @author Christian Scheiblich
   * date Feb 7, 2013 3:05:24 PM
   *
   */
  protected var _fromLevel: Int = -1
}
