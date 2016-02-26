import sbt._
import Keys._

object MiniBuild extends Build {
  override lazy val settings = super.settings ++ Seq(
    scalaVersion := "2.11.7",
    scalacOptions ++= Seq("-deprecation","-unchecked"),
    parallelExecution in Global := false
  )
  lazy val chisel    = project
  lazy val cde       = project.dependsOn(chisel)
  lazy val junctions = project.dependsOn(cde)
  lazy val root      = (project in file(".")).settings(settings:_*).dependsOn(junctions)
}
