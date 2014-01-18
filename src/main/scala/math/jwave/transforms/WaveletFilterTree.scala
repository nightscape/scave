package math.jwave.transforms

import math.jwave.transforms.wavelets.Wavelet

trait WaveletFilterTree {
  def restoreSignal:Seq[Double]
  def flatten: Seq[Double]
}


case class WaveletNode(val coefficients: Seq[Double]) extends WaveletFilterTree {
  def restoreSignal = coefficients
  def flatten = coefficients
}

case class WaveletBinaryTree(val wavelet: Wavelet, val approximation: WaveletFilterTree, val details: WaveletFilterTree) extends WaveletFilterTree {
  def restoreSignal = wavelet.mergeSignals(approximation.restoreSignal, details.restoreSignal)
  def flatten = approximation.flatten.view ++ details.flatten
}