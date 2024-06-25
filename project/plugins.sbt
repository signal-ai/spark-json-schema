addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.9.2")

// Code coverage
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "2.0.12")

// Code formatting
addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.8.3")

// fix old scala-xml 1.x dependency in sbt-scalariform
// https://github.com/sbt/sbt-scalariform/issues/85#issuecomment-2110505635
libraryDependencySchemes += "org.scala-lang.modules" %% "scala-xml" % VersionScheme.Always

// Code style
addSbtPlugin("com.sksamuel.scapegoat" %% "sbt-scapegoat" % "1.2.4")

// Publishing
addSbtPlugin("com.codecommit" % "sbt-github-packages" % "0.5.3")
