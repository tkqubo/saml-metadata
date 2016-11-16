name := "saml-metadata"
version := "1.0"
scalaVersion := "2.12.0"
crossScalaVersions := Seq("2.11.8", "2.12.0")

libraryDependencies ++= Seq(
  "org.scala-lang.modules"  %% "scala-xml" % "1.0.6",
  "org.scalatest"           %% "scalatest" % "3.0.0" % Test
)
