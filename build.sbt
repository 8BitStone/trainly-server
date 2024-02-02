ThisBuild / scalaVersion := "2.13.9"

ThisBuild / version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayJava, PlayEbean)
  .settings(
    name := """trainly-server""",
    libraryDependencies ++= Seq(
      guice,
      jdbc,
      "com.h2database" % "h2" % "1.4.199",
      "mysql" % "mysql-connector-java" % "8.0.17",
    )
  )