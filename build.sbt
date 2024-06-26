name := "spark-json-schema"

ThisBuild / version := "0.6.4-6-SNAPSHOT"
organization := "com.signal-ai"

scalaVersion := "2.12.19"
crossScalaVersions := Seq("2.12.19", "2.13.14")

libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.5.0"  % Provided
libraryDependencies += "org.playframework" %% "play-json" % "3.0.4"
libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.17.1"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.18" % "test"

ThisBuild / scapegoatVersion := "2.1.6"
scapegoatIgnoredFiles := Seq(s"${target.value}.*.scala")

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

// pom extra info
publishMavenStyle := true

githubOwner := "signal-ai"
githubRepository := "spark-json-schema"
githubTokenSource := TokenSource.Or(
  // Injected during a github workflow for publishing
  TokenSource.Environment("GITHUB_TOKEN"),
  // safe to assume this will be set in all our devs environments, usually /bin/bash, doesn't matter what it is to prevent local errors
  TokenSource.Environment("SHELL"),
)
Test / publishArtifact := false

Test / fork := true
Test / javaOptions += "--add-exports=java.base/sun.nio.ch=ALL-UNNAMED"

javacOptions ++= Seq("-target", "8")
scalacOptions ++= Seq("-target", "8")

pomExtra := (
  <developers>
    <developer>
      <name>Henning-Ulrich Esser</name>
      <email>henning-ulrich.esser@zalando.de</email>
      <url>https://github.com/zalando</url>
    </developer>
    <developer>
      <name>Patrick Baier</name>
      <email>patrick.baier@zalando.de</email>
      <url>https://github.com/zalando</url>
    </developer>
  </developers>
)
