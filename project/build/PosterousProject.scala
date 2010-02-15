import sbt._

class PosterousProject(info: ProjectInfo) extends PluginProject(info) with posterous.Publish {
  val dispatch = "net.databinder" %% "dispatch-http" % "0.7.0"

  val t_repo = "t_repo" at "http://tristanhunt.com:8081/content/groups/public/"
  val knockoff = "com.tristanhunt" %% "knockoff" % "0.6.1-8"
  
  override def extraTags = "knockoff" :: "dispatch" :: "sbt" :: super.extraTags

  override def managedStyle = ManagedStyle.Maven
  val publishTo = "Scala Tools Nexus" at "http://nexus.scala-tools.org/content/repositories/releases/"
  Credentials(Path.userHome / ".ivy2" / ".credentials", log)
}