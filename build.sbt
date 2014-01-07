name := "scave"

version := "1.0.0"

libraryDependencies ++= Seq(
  "org.spire-math" %% "spire" % "0.7.3",
  "com.softwaremill.scalamacrodebug" %% "macros" % "0.2",
  "org.scalatest" %% "scalatest" % "2.0.1-SNAP" % "test",
  "org.scalautils" %% "scalautils" % "2.0" % "test",
  "org.scalacheck" %% "scalacheck" % "1.11.1" % "test",
  "junit" % "junit" % "4.11" % "test"
)