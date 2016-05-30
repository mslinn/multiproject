import sbt._
import CommonSettings._

lazy val root = project.in(file("."))
  .enablePlugins(PlayScala)
  .settings(commonSettings:_*)
  .dependsOn(serviceA, serviceB)
  .aggregate(serviceA, serviceB)

lazy val common: Project = project.in(file("modules/common"))
  .enablePlugins(PlayScala)
  .settings(commonSettings:_*)
  .settings(aggregateReverseRoutes := Seq(serviceA, serviceB))

lazy val nonPlay: Project = project.in(file("modules/nonPlay"))
  .settings(commonSettings:_*)
  .dependsOn(common)

lazy val serviceA: Project = project.in(file("modules/serviceA"))
  .enablePlugins(PlayScala)
  .settings(commonSettings:_*)
  .dependsOn(nonPlay)
  .aggregate(common, nonPlay)

lazy val serviceB: Project = project.in(file("modules/serviceB"))
  .enablePlugins(PlayScala)
  .settings(commonSettings:_*)
  .dependsOn(nonPlay)
  .aggregate(common, nonPlay)
