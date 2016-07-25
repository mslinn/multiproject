import sbt._
import CommonSettings._

lazy val root = project.in(file("."))
  .enablePlugins(PlayScala)
  .settings(commonSettings:_*)
  .settings(webAppSettings:_*)
  .dependsOn(serviceA, serviceB)
  .aggregate(common, nonPlay, serviceA, serviceB)

lazy val common: Project = project.in(file("modules/common"))
  .enablePlugins(PlayScala)
  .settings(commonSettings:_*)
  .settings(playSubProjectSettings:_*)
  .settings(webAppSettings:_*)
  .settings(aggregateReverseRoutes := Seq(serviceA, serviceB))

lazy val nonPlay: Project = project.in(file("modules/nonPlay"))
  .settings(commonSettings:_*)
  .settings(nonPlaySubProjectSettings:_*)
  .dependsOn(common)
  .aggregate(common)

lazy val serviceA: Project = project.in(file("modules/serviceA"))
  .enablePlugins(PlayScala)
  .settings(commonSettings:_*)
  .settings(playSubProjectSettings:_*)
  .settings(webAppSettings:_*)
  .dependsOn(serviceB)
  .aggregate(common, nonPlay, serviceB) // must common & nonPlay be mentioned (is common transitive)?

lazy val serviceB: Project = project.in(file("modules/serviceB"))
  .enablePlugins(PlayScala)
  .settings(commonSettings:_*)
  .settings(playSubProjectSettings:_*)
  .settings(webAppSettings:_*)
  .dependsOn(nonPlay)
  .aggregate(common, nonPlay) // must common be mentioned (is common transitive)?
