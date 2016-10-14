import sbtrelease.ReleasePlugin.autoImport._
import com.typesafe.sbt.pgp.PgpKeys

organization := "org.scoverage"

name := "scalac-scoverage-runtime"

crossPaths := false

autoScalaLibrary := false

publishMavenStyle := true

publishArtifact in Test := false

parallelExecution in Test := false

javacOptions := Seq("-encoding", "utf8")
javacOptions in compile ++= Seq("-source", "1.6", "-target", "1.6", "-deprecation")
javacOptions in doc ++= Seq("-source", "1.6")

publishTo <<= version {
    (v: String) =>
        val nexus = "https://oss.sonatype.org/"
        if (v.trim.endsWith("SNAPSHOT"))
            Some("snapshots" at nexus + "content/repositories/snapshots")
        else
            Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

pomExtra := {
    <url>https://github.com/scoverage/scalac-scoverage-runtime-java</url>
    <licenses>
        <license>
            <name>Apache 2</name>
            <url>http://www.apache.org/licenses/LICENSE-2.0</url>
            <distribution>repo</distribution>
        </license>
    </licenses>
    <scm>
        <url>git@github.com:scoverage/scalac-scoverage-runtime-java.git</url>
        <connection>scm:git@github.com:scoverage/scalac-scoverage-runtime-java.git</connection>
    </scm>
    <developers>
        <developer>
            <id>sksamuel</id>
            <name>sksamuel</name>
            <url>http://github.com/sksamuel</url>
        </developer>
    </developers>
}

releasePublishArtifactsAction := PgpKeys.publishSigned.value
