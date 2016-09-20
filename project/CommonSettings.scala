import sbt._
import sbt.Keys._
import play.sbt._
import play.sbt.PlayImport._
import play.sbt.routes.RoutesKeys.routesGenerator

object CommonSettings {
  private val branch = "git rev-parse --abbrev-ref HEAD".!!.trim
  private val commit = "git rev-parse --short HEAD".!!.trim
  private val buildTime = new java.text.SimpleDateFormat("yyyyMMdd-HHmmss").format(new java.util.Date)
  private val appVersion = s"$branch-$commit-$buildTime"

  private val scalaBuildOptions = Seq(
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

  private val javacOpts = Seq(
    "-Xlint:deprecation",
    "-Xlint:unchecked",
    "-source", "1.8",
    "-target", "1.8",
    "-g:vars"
  )

  // all subprojects and the root project share these settings
  val commonSettings = Seq(
    version := appVersion,
    scalaVersion := "2.11.8",
    doc in Compile <<= target.map(_ / "none"),
    javacOptions := javacOpts,
    scalacOptions ++= scalaBuildOptions,
    sources in doc in Compile := List(),
    logBuffered in Test := false,
    Keys.fork in Test := false,
    logLevel := Level.Warn,
    logLevel in test := Level.Info, // Level.Info is needed to see detailed output when running tests
    logLevel in compile := Level.Warn
  )

  // All non-Play subprojects share these settings
  val nonPlaySubProjectSettings = Seq(
    libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % Test
  )

  // All Play subprojects share these settings
  val playSubProjectSettings = Seq(
    javaOptions += "-Dlogger.resource=../../conf/logback.xml",
    javaOptions += "-Dlogger.resource=../../test/resources/test.logback.xml"
  )

  // All web apps use this setting
  val webAppSettings = Seq(
    routesGenerator := play.routes.compiler.InjectedRoutesGenerator,
    javaOptions in Test += "-Dconfig.resource=common.application.conf",
    libraryDependencies ++= Seq(
      "org.webjars"            %  "bootstrap"          % "3.3.7",
      "org.webjars"            %  "dropzone"           % "4.2.0",
      "org.webjars"            %  "jquery"             % "2.2.4",
      "org.webjars"            %  "jquery-cookie"      % "1.4.1-1",
      "org.webjars"            %  "jquery-ui"          % "1.12.1",
      "org.webjars"            %  "jquery-ui-themes"   % "1.10.3",
      "org.webjars.bower"      %  "compass-mixins"     % "1.0.2",
      //"org.webjars.bower"      %  "bootstrap-sass"     % "3.3.6",
      "net.codingwell"         %% "scala-guice"        % "4.0.1" withSources(),
      "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
    )
  )
}
