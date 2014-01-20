Scave - Scala Wavelets [![Build Status](https://travis-ci.org/nightscape/scave.png?branch=master)](https://travis-ci.org/nightscape/scave)
============================================
Scave is a Scala library for Wavelet transform. It started as a port of [JWave](https://code.google.com/p/jwave/) by Christian Scheiblich.

Features
--------
 * Transform Algorithms
   * Fast Wavelet Transform
   * Wavelet Packet Transform
 * Wavelets
   * Haar
   * Daubechy
   * Legendre
   * Coiflet

Future
------
Once I have understood it, I will try to port the [incremental algorithm](http://nicolas.brodu.net/en/programmation/incremfa/index.html) written by Nicolas Bordu. If anyone is interested in joining development please reply to the [corresponding issue](https://github.com/nightscape/scave/issues/1).

Development
-----------
Scave can be built using SBT. To do this, clone this repository and `cd` into it, then run `sbt`.
In SBT you can
 * run tests with `test`
 * generate the documentation with `doc`
 * package a distributable jar with `package`