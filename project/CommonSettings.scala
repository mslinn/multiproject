import sbt._
import sbt.Keys._
import play.sbt._
import play.sbt.PlayImport._
import play.sbt.routes.RoutesKeys.routesGenerator

object CommonSettings extends Build {
  val branch = "git rev-parse --abbrev-ref HEAD".!!.trim
  val commit = "git rev-parse --short HEAD".!!.trim
  val buildTime = new java.text.SimpleDateFormat("yyyyMMdd-HHmmss").format(new java.util.Date)
  val appVersion = s"$branch-$commit-$buildTime"

  val scalaBuildOptions = Seq(
    "-deprecation",
    "-encoding", "UTF-8",
    "-feature",
    "-target:jvm-1.8",
    "-unchecked",
    "-Ywarn-adapted-args",
    "-Ywarn-value-discard",
    "-Xlint",
    "-language:experimental.macros"
  )

  val javacOpts = Seq(
    "-Xlint:deprecation",
    "-Xlint:unchecked",
    "-source", "1.8",
    "-target", "1.8",
    "-g:vars"
  )

  val commonSettings = Seq(
    version := appVersion,
    scalaVersion := "2.11.8",
    routesGenerator := play.routes.compiler.InjectedRoutesGenerator,
    doc in Compile <<= target.map(_ / "none"),
    javacOptions := javacOpts,
    scalacOptions ++= scalaBuildOptions,
    sources in doc in Compile := List(),
    javaOptions in Test += "-Dconfig.resource=common-application.conf",
    resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases",
    libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test,
    logBuffered in Test := false,
    Keys.fork in Test := false,
    logLevel := Level.Warn,
    logLevel in test := Level.Info, // Level.Info is needed to see detailed output when running tests
    logLevel in compile := Level.Warn
  )
}
