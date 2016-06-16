name := "scave"

lazy val commonSettings = Seq(
  version := "1.0.0",
  scalaVersion := "2.11.8"
)

libraryDependencies ++= Seq(
  "org.spire-math" %% "spire" % "0.7.5",
  "com.softwaremill.scalamacrodebug" %% "macros" % "0.4",
  "org.scala-lang.modules" %% "scala-xml" % "1.0.1",
  "org.scalatest" %% "scalatest" % "2.2.0" % "test",
  "org.scalautils" %% "scalautils" % "2.1.7" % "test",
  "org.scalacheck" %% "scalacheck" % "1.11.4" % "test",
  "junit" % "junit" % "4.11" % "test"
)

lazy val root = (project in file(".")).settings(commonSettings: _*)

lazy val benchmark = project.enablePlugins(JmhPlugin).dependsOn(root).settings(
  commonSettings: _*
)
