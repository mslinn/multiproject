import sbt._
import sbt.Keys._
import play.sbt._
import play.sbt.PlayImport._
import play.sbt.routes.RoutesKeys.routesGenerator

object Build extends Build {
  val branch = "git rev-parse --abbrev-ref HEAD".!!.trim
  val commit = "git rev-parse --short HEAD".!!.trim
  val buildTime = new java.text.SimpleDateFormat("yyyyMMdd-HHmmss").format(new java.util.Date)
  val appVersion = s"$branch-$commit-$buildTime"

  val scalaBuildOptions = Seq("-unchecked", "-deprecation", "-feature", "-language:reflectiveCalls",
    "-language:implicitConversions", "-language:postfixOps", "-language:dynamics","-language:higherKinds",
    "-language:existentials", "-language:experimental.macros", "-Xmax-classfile-name", "140")

  val commonSettings = Seq(
    version := appVersion,
    scalaVersion := "2.11.8",
    routesGenerator := play.routes.compiler.InjectedRoutesGenerator,
    doc in Compile <<= target.map(_ / "none"),
    scalacOptions ++= scalaBuildOptions,
    sources in doc in Compile := List(),
    javaOptions in Test += "-Dconfig.resource=common-application.conf",
    resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases",
    libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
  )
}
