import AssemblyKeys._

assemblySettings

jarName in assembly := "brumes_server.jar"

mainClass in assembly := Some("fr.gembasher.brumes.server.Launcher")

name := "Serveur Brumes"

version := "0.01"

scalaVersion := "2.9.2"
