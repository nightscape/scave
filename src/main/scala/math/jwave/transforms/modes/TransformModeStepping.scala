package math.jwave.transforms.modes

/**
 * Class for indicating that there will be a stepping from either the
 * base level of the normal space or taking the Hilbert space as a
 * base level to step away the given number of steps from each base.
 *
 * @author Christian Scheiblich
 * date Feb 7, 2013 3:02:56 PM
 *
 */
class TransformModeStepping(steps: Int) extends TransformMode {

  require(steps >= 1, "given integer steps is smaller than 1 - no steps possible")

  _steps = steps

  _toLevel = -1

  _fromLevel = -1
}
