lazy val root = (project in file(".")).
  settings(
    organization := "io.elepay",
    name := "elepay-java-sdk",
    version := "1.2.4",
    scalaVersion := "2.11.4",
    scalacOptions ++= Seq("-feature"),
    javacOptions in compile ++= Seq("-Xlint:deprecation"),
    publishArtifact in (Compile, packageDoc) := false,
    resolvers += Resolver.mavenLocal,
    libraryDependencies ++= Seq(
      "io.swagger" % "swagger-annotations" % "1.5.22",
      "org.glassfish.jersey.core" % "jersey-client" % "2.25.1",
      "org.glassfish.jersey.media" % "jersey-media-multipart" % "2.25.1",
      "org.glassfish.jersey.media" % "jersey-media-json-jackson" % "2.25.1",
      "com.fasterxml.jackson.core" % "jackson-core" % "2.9.10" % "compile",
      "com.fasterxml.jackson.core" % "jackson-annotations" % "2.9.10" % "compile",
      "com.fasterxml.jackson.core" % "jackson-databind" % "2.9.10.1" % "compile",
      "com.fasterxml.jackson.datatype" % "jackson-datatype-jsr310" % "2.9.10" % "compile",
      "junit" % "junit" % "4.12" % "test",
      "com.novocode" % "junit-interface" % "0.10" % "test"
    )
  )
