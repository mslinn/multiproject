import sbt._
import Build._

lazy val root = project.in(file("."))
  .enablePlugins(PlayScala)
  .settings(commonSettings:_*)
  .dependsOn(serviceA, serviceB)
  .aggregate(common, serviceA, serviceB)

lazy val common: Project = project.in(file("modules/common"))
  .enablePlugins(PlayScala)
  .settings(aggregateReverseRoutes := Seq(serviceA, serviceB))
  .settings(commonSettings:_*)

lazy val serviceA: Project = project.in(file("modules/serviceA"))
  .enablePlugins(PlayScala)
  .settings(commonSettings:_*)
  .dependsOn(common)

lazy val serviceB: Project = project.in(file("modules/serviceB"))
  .enablePlugins(PlayScala)
  .settings(commonSettings:_*)
  .dependsOn(common)
