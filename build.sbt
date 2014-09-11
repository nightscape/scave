name := "scave"

version := "1.0.0"

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  "org.spire-math" %% "spire" % "0.7.5",
  "com.softwaremill.scalamacrodebug" %% "macros" % "0.4",
  "org.scala-lang.modules" %% "scala-xml" % "1.0.1",
  "org.scalatest" %% "scalatest" % "2.2.0" % "test",
  "org.scalautils" %% "scalautils" % "2.1.7" % "test",
  "org.scalacheck" %% "scalacheck" % "1.11.4" % "test",
  "junit" % "junit" % "4.11" % "test",
  "com.google.caliper" % "caliper" % "1.0-beta-1"
)

seq(cappiSettings:_*)
