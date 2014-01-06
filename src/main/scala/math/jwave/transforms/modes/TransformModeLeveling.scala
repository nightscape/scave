package math.jwave.transforms.modes

/**
 * Class for indicating that there will be a starting level of transform
 * and an end level of the transform, which allows for specialized
 * filtering by the transform.
 *
 * @author Christian Scheiblich
 * date Feb 7, 2013 3:04:09 PM
 *
 */
class TransformModeLeveling(fromLevel: Int, toLevel: Int) extends TransformMode {

  require(toLevel != fromLevel, "fromLevel equals toLevel - not possible")

  _fromLevel = fromLevel

  _toLevel = toLevel

  if (_fromLevel < _toLevel) _steps = _toLevel - _fromLevel

  if (_toLevel < _fromLevel) _steps = _fromLevel - _toLevel
}
