name := "spark-json-schema"

ThisBuild / version := "0.6.4-2-SNAPSHOT"
organization := "com.signal_ai"

scalaVersion := "2.12.10"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.2.1"  % Provided
libraryDependencies += "com.typesafe.play" %% "play-json" % "2.9.2"
libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.13.3"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.12" % "test"

ThisBuild / scapegoatVersion := "1.4.5"
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
  <scm>
    <url>git@github.com:signal-ai/spark-json-schema.git</url>
    <developerConnection>scm:git:git@github.com:signal-ai/spark-json-schema.git</developerConnection>
    <connection>scm:git:https://github.com/signal-ai/spark-json-schema.git</connection>
  </scm>
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
