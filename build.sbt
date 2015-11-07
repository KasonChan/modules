val name = "module"

lazy val buildSettings = Seq(
  version := "0.1.0-SNAPSHOT",
  scalaVersion := "2.11.7",
  crossScalaVersions := Seq("2.10.5", "2.11.7")
)

lazy val compilerOptions = Seq(
  "-encoding", "UTF-8",
  "-feature"
)

val testDependencies = Seq(
  "org.scalacheck" %% "scalacheck" % "1.12.5",
  "org.scalatest" %% "scalatest" % "2.2.5"
)

val baseSettings = Seq(
  libraryDependencies ++= Seq(
    "org.scala-lang" % "scala-reflect" % scalaVersion.value
  ) ++ testDependencies.map(_ % "test"),
  scalacOptions ++= compilerOptions,
  scalacOptions in(Compile, console) := compilerOptions
)

lazy val noPublishSettings = Seq(
  publish := {},
  publishLocal := {}
)

lazy val allSettings = baseSettings ++ buildSettings

lazy val root = project.in(file("."))
  .settings(moduleName := name)
  .settings(allSettings: _*)
  .settings(noPublishSettings: _*)
  .aggregate(core, test, docs)
  .dependsOn(core)

lazy val core = project
  .settings(moduleName := name + "-" + "core")
  .settings(allSettings: _*)

lazy val test = project
  .settings(moduleName := name + "-" + "test")
  .settings(allSettings: _*)
  .settings(
    libraryDependencies ++= testDependencies
  )
  .dependsOn(core)

lazy val docs = project
  .settings(moduleName := name + "-" + "docs")
  .settings(allSettings: _*)
  .settings(
    libraryDependencies ++= testDependencies
  )
  .dependsOn(core)
