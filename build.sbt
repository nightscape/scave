name := "scave"

lazy val commonSettings = Seq(
  version := "1.0.0",
  scalaVersion := "2.11.8"
)

libraryDependencies ++= Seq(
  "org.spire-math" %% "spire" % "0.11.0",
  "com.softwaremill.scalamacrodebug" %% "macros" % "0.4",
  "org.scala-lang.modules" %% "scala-xml" % "1.0.5",
  "org.scalatest" %% "scalatest" % "2.2.6" % "test",
  "org.scalactic" %% "scalactic" % "2.2.6" % "test",
  "org.scalacheck" %% "scalacheck" % "1.12.5" % "test",
  "junit" % "junit" % "4.12" % "test"
)

lazy val root = (project in file(".")).settings(commonSettings: _*)

lazy val benchmark = project.enablePlugins(JmhPlugin).dependsOn(root).settings(
  commonSettings: _*
)
