import sbt.Keys.version

lazy val root = (project in file("."))
  .settings(
    name := "gameoflife",
    version := "0.1",
    scalaVersion := "2.13.0",

    scalacOptions ++= Seq(
      "-deprecation",
      "-feature",
      "-Xfatal-warnings"
    ),

    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.0.8" % Test
    )
  )
