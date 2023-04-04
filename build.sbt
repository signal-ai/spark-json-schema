name := "spark-json-schema"

ThisBuild / version := "0.6.4-4-SNAPSHOT"
organization := "com.signal-ai"

scalaVersion := "2.12.17"
crossScalaVersions := Seq("2.12.17", "2.13.10")

libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.3.0"  % Provided
libraryDependencies += "com.typesafe.play" %% "play-json" % "2.9.3"
libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.13.4"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.12" % "test"

ThisBuild / scapegoatVersion := "2.1.1"
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
